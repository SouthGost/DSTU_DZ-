package com.example.qwe;

import org.w3c.dom.*;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "Task4", value = "/valuta")
public class ValutServlet extends HttpServlet {

    public void init() {    }

    private String makeRequest(String valuta, String req_date1, String req_date2){
        URL url = null;
        HttpURLConnection con = null;
        String params = "?date_req1=" + req_date1 +"&date_req2=" + req_date2 +"&VAL_NM_RQ=" + valuta;
        System.out.println(params);
        try{
            url = new URL(
                    "https://www.cbr.ru/scripts/XML_dynamic.asp" + params
            );
            con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Content-Type", "text/html");
            con.setConnectTimeout(5000);
            con.setReadTimeout(5000);
        } catch (Exception e){
            System.out.println("ERROR 35");
            return "";
        }

        StringBuffer data = new StringBuffer();
        try {
            int status = con.getResponseCode();
            if(status > 299) {
                return "";
            }
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream())
            );
            String str = null;
            while((str=in.readLine()) != null) data.append(str);
            in.close();
            con.disconnect();
        } catch(Exception e) {
            System.out.println("ERROR 53");
            return "";
        }
        return data.toString();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try{
            String date1 = request.getParameter("date1");
            String date2 = request.getParameter("date2");
            String valuta = request.getParameter("valuta");
            String req_date1;
            String req_date2;

            if(date1.length() != 10){
                throw new Exception("Ne pravilnaya date1");
            }
            req_date1 = date1.substring(8,10) + "/" + date1.substring(5,7) + "/" + date1.substring(0,4);
            if(date2.length() != 10 && !date2.equals("")){
                throw new Exception("Ne pravilnaya date2");
            }
            if(!date2.equals("")){
                req_date2 = date2.substring(8,10) + "/" + date2.substring(5,7) + "/" + date2.substring(0,4);
            } else {
                req_date2 = req_date1;
            }
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h1>Task4</h1>");

            String cbRequest = makeRequest(valuta,req_date1,req_date2);
            StringBufferInputStream stringBufferInputStream = new StringBufferInputStream(cbRequest);
            DocumentBuilderFactory docfactory = null;
            DocumentBuilder docbuilder = null;
            Document doc = null;
            try {
                docfactory = DocumentBuilderFactory.newInstance();
                docbuilder = docfactory.newDocumentBuilder();
    //            File f = new File("currency.xml");
                doc = docbuilder.parse(stringBufferInputStream); /* есть перегруженный метод parse, получающий ссылку на InputStream */
            } catch(Exception e) {
                e.printStackTrace();
            }
            doc.getDocumentElement().normalize();
            NodeList nodes = doc.getElementsByTagName("Record");
            out.println("<table>");
            out.println("<tr>");
                out.println("<td>Valuta</td>");
                for(int i = 0; i < nodes.getLength(); i++){
                    Node node = nodes.item(i);
                    NamedNodeMap map = node.getAttributes();
                    Node dateNode = map.getNamedItem("Date");

                    out.println("<td>"+ dateNode.getNodeValue() +"</td>");
                }
            out.println("</tr>");
            out.println("<tr>");
                out.println("<td>USA</td>");
                for(int i = 0; i < nodes.getLength(); i++){
                    Node node = nodes.item(i);
                    NodeList nl = node.getChildNodes();
                    String data = nl.item(1).getTextContent();

                    out.println("<td>"+ data +"</td>");
                }
            out.println("</tr>");
            out.println("</table>");
            out.println("</body></html>");
        } catch (Exception e){
            PrintWriter out = response.getWriter();

            out.println("<html><body>");
            out.println("<h1>Error</h1>");
            out.println(e.getMessage());
            out.println("</body></html>");
        }
    }

    public void destroy() {
    }
}