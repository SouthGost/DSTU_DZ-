package com.example.fxautomat;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.Pair;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
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
    private HashMap<String, Pair<Integer, Integer>> users = new HashMap<>();
    public Pair<Integer, Integer>[] timesForNew;
    private String currentUserLogin = null;
    private Integer currentTextId = null;
    public long[] timeArray;
    private int epsilon = 400;

    private void setDisableForText(boolean is){
        InputText.setDisable(is);
        SubmitText.setDisable(is);
    }

    private Pair<Integer, Integer> getTimePair() throws Exception { //переделать
        if(timeArray != null){
            int ideal = 0;
            if(timeArray[0] == 0){
                throw new Exception("Не записанн символ");
            }
            for(int i = 1; i< timeArray.length; i++ ){
                if(timeArray[i] == 0){
                    throw new Exception("Не записанн символ");
                }
                ideal += (timeArray[i] - timeArray[i-1]);
            }
            ideal /= texts[currentTextId].length()-1;
            int otklon = 0;
            for(int i = 1; i< timeArray.length; i++ ){
                otklon += Math.abs((timeArray[i] - timeArray[i-1])- ideal);
            }
            otklon /= texts[currentTextId].length()-1;
            return new Pair<>(ideal,otklon);
        }
        throw new Exception("Не записанн временной почерк");
    }

    private void changeWord(String prefix){
        currentTextId = (int)(Math.random() * texts.length);
        timeArray = new long[texts[currentTextId].length()];
        Text.setText(prefix + "\n" + texts[currentTextId]);
    }

    private void addUser(String login){
        if(users.get(login) == null){
            Pair<Integer, Integer> addingUser = new Pair<>(0,0);
            for(int i = 0; i < 4; i++){
                setDisableForText(false);

            }

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
            texts = fulltext.split("\r\n");
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

        //Кнопка подтверждения текста
        SubmitText.setOnAction((event) -> {
            try{
                if(InputText.getText().equals(texts[currentTextId])){
                    if(timesForNew != null){
                        int i = 0;
                        while( i < timesForNew.length && timesForNew[i] != null){
                            i++;
                        }
                        if(i == timesForNew.length){
                            int ideal = 0;
                            int otklon = 0;
                            for(int j = 0; j < timesForNew.length; j++){
                                ideal += timesForNew[j].getKey();
                                otklon += timesForNew[j].getValue();
                            }
                            ideal /= timesForNew.length;
                            otklon /= timesForNew.length;
                            users.put(currentUserLogin, new Pair<>(ideal, otklon));
                            timesForNew = null;
                            changeWord("Вы сохранены");
                        } else {
                            timesForNew[i] = getTimePair();
                            changeWord("Записываем почерк. Введиде текст(" + (i+2) + " из " + timesForNew.length);
                        }
                    } else {
                        Pair<Integer,Integer> userTimes = users.get(currentUserLogin);
                        Pair<Integer,Integer> currentTimes = getTimePair();
                        if(Math.abs(userTimes.getKey() - currentTimes.getKey()) < epsilon && Math.abs(userTimes.getValue() - currentTimes.getValue()) < epsilon){
                            changeWord("Вход выполнен успешно");
                        } else {
                            throw new Exception("Отказанно во входе");
                        }
                    }
                } else{
                    throw new Exception("Не правильный текст");
                }
            }catch (Exception e){
                changeWord(e.getMessage());
            }
//            System.out.println("текст дописан");
//            for(var t:timeArray){
//                System.out.println(t);
//            }
            InputText.setText("");
        });

        //параметры ввода текста
        InputText.textProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue.length() > 0 && newValue.length() <= texts[currentTextId].length()){
                timeArray[newValue.length()-1] = new Date().getTime();
                System.out.println((newValue.length()) + " из " + texts[currentTextId].length() + " (" + timeArray.length + ")" );
            }
//            String sub = newValue.substring(0,newValue.length()-1);
//            System.out.println(sub);
//            System.out.println(oldValue);
//            if(newValue.substring(0,oldValue.length()).equals(oldValue)){ //newValue.length() > oldValue.length() &&
//                if (timeArray[newValue.length()-1] == 0) {
//                    timeArray[newValue.length()-1] = new Date().getTime();
//                    System.out.println((newValue.length()) + " из " + texts[currentTextId].length() + " (" + timeArray.length + ")" );
//                    if(newValue.length() == texts[currentTextId].length()){
//                        System.out.println("текст дописан");
//                        for(var t:timeArray){
//                            System.out.println(t);
//                        }
//                        setDisableForText(true);
//                        InputText.setText("");
//                    }
//                }
//            } else if (!(newValue.equals("") && InputText.isDisable())) {
//                InputText.setText(oldValue);
//            }
        });

        //Кнопка ввода логина
        SubmitLogin.setOnAction((event) -> {
            String login = InputLogin.getText();
            if(Pattern.matches("[a-zA-Z][a-zA-Z0-9]+", login)){
                currentUserLogin = login;
                String text = ""; //
                setDisableForText(false);
                if(users.get(currentUserLogin) == null){
                    timesForNew = new Pair[4];
                    text += "Записываем почерк. Введиде текст(1 из " + timesForNew.length + ")" ;
                }else{
                    timesForNew = null;
                    text += "Введиде текст";
                }
                changeWord(text);
            } else {
                Text.setText("Недопустимый логин");
                setDisableForText(true);
            }
        });


    }

}
