package com.example.delivery;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Orders {


    public void onbackButton(ActionEvent actionEvent) throws IOException {
            try{
                HelloApplication.changescene("after_login.fxml");
            }catch (IOException e){
                e.printStackTrace();
            }
    }

    public void onnextButton(ActionEvent actionEvent) {
    }

    public void oncostumeridfield(ActionEvent actionEvent) {
    }

    public void onnamefield(ActionEvent actionEvent) {
    }

    public void onaddressfield(ActionEvent actionEvent) {
    }

    public void onresetButton(ActionEvent actionEvent) {
    }
}
