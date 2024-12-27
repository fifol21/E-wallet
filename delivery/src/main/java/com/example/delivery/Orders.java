package com.example.delivery;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Orders {
    @FXML
    private TextField customeridfield;
    @FXML
    private Button backButton;


    public void onbackButton(ActionEvent actionEvent) throws IOException {
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

    public void oncostumeridfield(ActionEvent actionEvent) {
        String customerid = customeridfield.getText();
        System.out.println(customerid);
    }

    public void onnamefield(ActionEvent actionEvent) {

    }

    public void onaddressfield(ActionEvent actionEvent) {
    }

    public void onresetButton(ActionEvent actionEvent) {
    }
}
