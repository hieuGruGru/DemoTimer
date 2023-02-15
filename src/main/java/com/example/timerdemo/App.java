package com.example.timerdemo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage currentStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
        currentStage.setScene(new Scene(root, 1200, 1040));
        currentStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}