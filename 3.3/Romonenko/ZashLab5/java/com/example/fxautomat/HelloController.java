package com.example.fxautomat;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.Pair;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Pattern;

public class HelloController {

    @FXML
    private TextField InputLogin;

    @FXML
    private TextField InputText;

    @FXML
    private Button SubmitLogin;

    @FXML
    private Button SubmitText;

    @FXML
    private Label Text;

    private String[] texts;
    private HashMap<String, Pair<Integer, Integer>> users;
    private Pair<Integer, Integer> currentUser = null;

    private void setDisableForText(boolean is){
        InputText.setDisable(is);
        SubmitText.setDisable(is);
    }

    private void addUser(String login){
        if(users.get(login) == null){
            setDisableForText(false);
            
        }
    }

    @FXML
    void initialize() {
        setDisableForText(true);
        Text.setText("Privet");
        try(FileReader reader = new FileReader("texts.txt"))
        {
            String fulltext = "";
            int c;
            while((c=reader.read())!=-1){
                fulltext += (char) c;
            }
            texts = fulltext.split("\n");
        }
        catch(IOException ex){

            System.out.println("Не получилось получить фразы");
        }
        try(FileReader reader = new FileReader("users.txt"))
        {
            String fulltext = "";
            int c;
            while((c=reader.read())!=-1){
                fulltext += (char) c;
            }
            String[] UsersAndTimes = fulltext.split("[ ]");
            for(int i=0;i<UsersAndTimes.length; i+=3){

            }
        }
        catch(IOException ex){

            System.out.println("Не получилось прочесть пользователей");
        }
        Pattern pattern = Pattern.compile("[a-z]");
        SubmitLogin.setOnAction((event) -> {
            String login = InputLogin.getText();
            if(Pattern.matches("[a-zA-Z][a-zA-Z0-9]+", login)){
                currentUser = users.get(login);
                if(currentUser != null){

                }else{

                }
                setDisableForText(false);
            } else {
                Text.setText("Недопустимый логин");
                setDisableForText(true);
            }
        });


    }

}