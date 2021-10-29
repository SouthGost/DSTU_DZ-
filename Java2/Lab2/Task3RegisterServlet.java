package com.example.qwe;

import java.io.*;
import java.util.Date;
import java.util.HashMap;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "task3Register", value = "/task3/register")
public class Task3RegisterServlet extends HttpServlet {
    private HashMap<String,User> users = new HashMap<>();

    public void init() {
        System.out.println("Init Login");
        File file = new File("Users.txt");

        try(FileReader reader = new FileReader(file))
        {
            BufferedReader bufRead = new BufferedReader(reader);
            String line = bufRead.readLine();

            while(line != null){
                String[] splitLine = line.split(" ");

                users.put(splitLine[0], new User(splitLine[0], Integer.parseInt(splitLine[1])));
                line = bufRead.readLine();
            }
            reader.close();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    private String addUser(String login, int password){
        try(FileWriter writer = new FileWriter("Users.txt", true))
        {
            if(users.get(login) != null){

                return "This is Stranger accaunt";
            }
            users.put(login, new User(login, password));
            writer.append("" + login + " " + password + "\n");
            writer.close();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());

            return "My bad. Sorry. Need wait";
        }

        return "1";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String login = request.getParameter("login").toLowerCase();
        int password = request.getParameter("password").hashCode();
        String message = addUser(login, password);

        if(message.equals("1")){
            Date date = new Date();
            message = "Hellow " + login + ". " + date + "";
            message = "Accaunt create.\n Hellow " + login + ". " + date + "";
        }
        response.setContentType("text/txt");
        PrintWriter out = response.getWriter();
        out.println(message);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String login = request.getParameter("login").toLowerCase();
        int password = request.getParameter("password").hashCode();
        String message = addUser(login, password);

        if(message.equals("1")){
            Date date = new Date();
            message = "Hellow " + login + ". " + date + "";
            message = "Accaunt create.\n Hellow " + login + ". " + date + "";
        }
        response.setContentType("text/txt");
        PrintWriter out = response.getWriter();
        out.println(message);
    }

    public void destroy() {
    }

}