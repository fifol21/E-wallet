package com.example.delivery;

import javafx.event.ActionEvent;

import java.io.IOException;

public class Customers {
    public void onbackButton(ActionEvent actionEvent) {
        try{
            HelloApplication.changescene("after_login.fxml");
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public void oncustomerfield(ActionEvent actionEvent) {
    }

    public void onorderidfield(ActionEvent actionEvent) {
    }

    public void ondestinationfield(ActionEvent actionEvent) {
    }

    public void onstatusfield(ActionEvent actionEvent) {
    }

    public void onvehiclefield(ActionEvent actionEvent) {
    }

    public void oncostfield(ActionEvent actionEvent) {
    }

    public void onnextButton(ActionEvent actionEvent) {
    }

}
