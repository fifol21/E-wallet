package com.example.delivery;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    private static Stage stg;
    @Override
    public void start(Stage primarystage) throws IOException {
        stg = primarystage;
        primarystage.setResizable(false);
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login_scene.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        primarystage.setTitle("WELCOME TO MileDeliverEx!");
        primarystage.setScene(scene);
        primarystage.show();


    }
    public static void changescene(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(fxml));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Stage newstage = new Stage();
        newstage.setScene(scene);
        newstage.setTitle("WELCOME TO MileDeliverEx!");
        newstage.show();
        stg.close();
        stg=newstage;
    }

    public static void main(String[] args) {
        launch();
        
    }
}