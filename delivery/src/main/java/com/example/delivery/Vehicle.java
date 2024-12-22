package com.example.delivery;

import javafx.event.ActionEvent;

import java.io.IOException;

public class Vehicle {
    public void onbackButton(ActionEvent actionEvent) {
        try{
            HelloApplication.changescene("after_login.fxml");
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public void onnextButton(ActionEvent actionEvent) {
    }
}
