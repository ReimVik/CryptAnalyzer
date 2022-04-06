package com.example.analizer;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;



public class Controller {

    @FXML
    private AnchorPane invicibleAnchorPane;

    @FXML
    private Button okButton;

    @FXML
    private Button cipherButton;

    protected static File file;
    @FXML
    private TextField pathField;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button analizeCryptButton;

    @FXML
    private Button bruteForceButton;

    @FXML
    private   Button fileChooseButton;

    @FXML
    private AnchorPane secondAnchorPane;

    @FXML
    void initialize() {

        FileChooser fileChooser = new FileChooser();
        fileChooseButton.setOnAction(actionEvent -> {
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter(".txt", "*.txt"));
            file = fileChooser.showOpenDialog(new Stage());
            pathField.setText(file.getAbsolutePath());
        });


        bruteForceButton.setOnAction(event -> {
            bruteForceButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("bruteForceScene.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });

        cipherButton.setOnAction(event -> {
            if(pathField.getText().isEmpty()){
                invicibleAnchorPane.visibleProperty().setValue(true);
                secondAnchorPane.visibleProperty().setValue(false);
            }else {
                cipherButton.getScene().getWindow().hide();
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("cipher.fxml"));
                try {
                    loader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Parent root = loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.showAndWait();
            }
        });
        okButton.setOnAction(actionEvent -> {
            invicibleAnchorPane.visibleProperty().setValue(false);
            secondAnchorPane.visibleProperty().setValue(true);
        });
    }

}

