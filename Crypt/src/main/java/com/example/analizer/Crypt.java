package com.example.analizer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Crypt extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Crypt.class.getResource("firstScene.fxml"));
        stage.setTitle("CryptAnalyzer");
        stage.setScene(new Scene(fxmlLoader.load(), 700, 400));
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}