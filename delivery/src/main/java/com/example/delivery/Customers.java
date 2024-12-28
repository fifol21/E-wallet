package com.example.delivery;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Customers {
    @FXML
    private Button backButton;

    public void onbackButton(ActionEvent actionEvent) {
        try {
            HelloApplication.changescene("after_login.fxml");
            Stage stage = (Stage) backButton.getScene().getWindow();
            stage.close();
        } catch (IOException e) {
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

    public void onaddcostumerButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("addcostumer.fxml"));
        Stage add_costumer_stage = new Stage();
        add_costumer_stage.setTitle("Add Costumer");
        add_costumer_stage.setResizable(false);
        add_costumer_stage.setScene(new Scene(fxmlLoader.load(), 600, 400));
        add_costumer_stage.show();


    }
}
