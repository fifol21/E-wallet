package com.example.delivery;

import javafx.event.ActionEvent;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class Vehicle {
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

    public void onnextButton(ActionEvent actionEvent) {
    }
}
