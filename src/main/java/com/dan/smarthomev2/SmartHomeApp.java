package com.dan.smarthomev2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SmartHomeApp extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("sceneHome.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Smart Home Controls");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}