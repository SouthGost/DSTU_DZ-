package com.example.codinglzw;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class HelloController {
    private File file = null;

    @FXML
    private Button chooseButton;

    @FXML
    private Text messageLabel;

    @FXML
    private ProgressBar progressBar;

    @FXML
    private ComboBox<String> actionCBox;

    @FXML
    private ComboBox<String> codeTypeCBox;

    public static void codingFile(File file){
        try(FileReader reader = new FileReader(file))
        {
            try(FileWriter writer = new FileWriter("" + file.getName() +"C.txt", false))
            {
                Map<Long,Integer> map = new HashMap<>();
                long w;
                int k = -1;
                int count = 1106;
                int link = 0;
                boolean isRepeat = false;

                if((w=reader.read())!=-1){
                    System.out.print((char)w);
                }
                while((k=reader.read())!=-1){
                    if(map.get(w*1105+k) == null){
                        if (isRepeat) {
                            writer.write(link);
                            System.out.println(link);
                        } else {
                            writer.write((int)w);
                        }
                        System.out.print((char)k);
                        map.put((long)(w*1105+k),count);
                        count++;
                        w=k;
                        isRepeat = false;
                    } else {
                        link = map.get(w*1105+k);
                        w = w*1105+k;
                        isRepeat = true;
                    }
                }
                if (isRepeat) {
                    writer.write(link);
                } else {
                    writer.write((int)w);
                }
                writer.flush();

//                int w;
//                while((w=reader.read())!=-1){
//                    System.out.println((char)w +" - " + w);
//                }
            }
            catch(IOException ex){

                System.out.println(ex.getMessage());
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }

    @FXML
    protected void onChooseButtonClick() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("TXT", "*.txt"));
        File file = fileChooser.showOpenDialog(progressBar.getScene().getWindow());

        if(file != null){
            messageLabel.setText("File " + file.getName() + " is load");
            codingFile(file);
        }
    }
}