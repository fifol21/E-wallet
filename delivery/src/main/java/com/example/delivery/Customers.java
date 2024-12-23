package com.example.delivery;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Customers {
    @FXML
    private Button backButton;
    public void onbackButton(ActionEvent actionEvent) {
        try{
            HelloApplication.changescene("after_login.fxml");
            Stage stage = (Stage) backButton.getScene().getWindow();
            stage.close();
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
