package com.example.qwe;

import java.io.*;
import java.util.Date;
import java.util.HashMap;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "task3Login", value = "/task3/login")
public class Task3LoginServlet extends HttpServlet {
    private HashMap<String,Integer> badUsers = new HashMap<>();

    public void init() {

    }

    private String findUser(String login, int password, String session){
        Integer badAttempts = badUsers.get(session);
        if(badAttempts!=null){
            if(badAttempts > 2){
                return "soo more attempts";
            }
        } else {
            badAttempts = 0;
        }
        File file = new File("Users.txt");

        try(FileReader reader = new FileReader(file))
        {
            BufferedReader bufRead = new BufferedReader(reader);
            String line = bufRead.readLine();

            while(line != null){
                String[] splitLine = line.split(" ");
                if(login.equals(splitLine[0])){
                    if(password == Integer.parseInt(splitLine[1])){
                        return "1";
                    } else {
                        break;
                    }
                }
                line = bufRead.readLine();
            }
            reader.close();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
            return "My bad. Sorry. Need wait";
        }
        badAttempts++;
        badUsers.put(session,badAttempts);
        return "Uncorrectable login or password";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String login = request.getParameter("login").toLowerCase();
        int password = request.getParameter("password").hashCode();
        String session = request.getParameter("session");
        String message = findUser(login, password, session);

        if(message.equals("1")){
            Date date = new Date();
            message = "Hello " + login + ". " + date + " GET";
        }
        response.setContentType("text/txt");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.println(message + " " + session);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String login = request.getParameter("login").toLowerCase();
        int password = request.getParameter("password").hashCode();
        System.out.println(request.getParameter("login") + " " + request.getParameter("password"));
        String session = request.getParameter("session");
        String message = findUser(login, password, session);

        if(message.equals("1")){
            Date date = new Date();
            message = "Hello " + login + ". " + date + " POST";
        }
        response.setContentType("text/txt");
        PrintWriter out = response.getWriter();
        out.println(message);
    }

    public void destroy() {
    }
    //////
}