package com.example.analizer;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class cipherController extends Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea finalFileField;

    @FXML
    private TextField keyField;

    @FXML
    private Button mainMenuButton;

    @FXML
    private TextArea sourceFileField;

    @FXML
    private Button startButton;

    @FXML
    void initialize() {

        class CaesarCipher{
            StringBuilder cipher(String message, int offset){
                StringBuilder result = new StringBuilder();
                for(char character : message.toCharArray()){
                    if(character != ' '){
                       if(character != '\n') {
                                int originalAlphabetPosition = character - 'а';
                                int newAlphabetPosition = (originalAlphabetPosition + offset);
                                char newCharacter = (char) ('а' + newAlphabetPosition);
                                result.append(newCharacter);
                        }else{
                            result.append(character);
                        }
                    }else {
                        result.append(character);
                    }
                }
                return result;
            }

        }

        try {
            List<String> list = Files.readAllLines(Path.of(Controller.file.getAbsolutePath()));
            String s = "";
            for (String str : list) {
                s = s + str + "\n";
            }
            sourceFileField.setText(s);
        } catch (IOException e) {
            e.printStackTrace();
        }

        mainMenuButton.setOnAction(event -> {
            mainMenuButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("firstScene.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });

        startButton.setOnAction(actionEvent -> {
            CaesarCipher cipher = new CaesarCipher();
            String cipheredMessage = String.valueOf(cipher.cipher(sourceFileField.getText(), Integer.parseInt(keyField.getText())));
            finalFileField.setText(String.valueOf(cipheredMessage));
        });
    }

}


