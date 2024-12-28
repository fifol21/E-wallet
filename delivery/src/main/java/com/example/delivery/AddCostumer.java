package com.example.delivery;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class AddCostumer {
    @FXML
    private Button backButton;

    public void oncustomerfield(ActionEvent actionEvent) {
    }

    public void onorderidfield(ActionEvent actionEvent) {
    }

    public void ondestinationfield(ActionEvent actionEvent) {
    }

    public void onbackButton(ActionEvent actionEvent) throws IOException {
            try {
                HelloApplication.changescene("customers");
                Stage stage = (Stage) backButton.getScene().getWindow();
                stage.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    public void onstatusfield(ActionEvent actionEvent) {
    }

    public void onconfirmButton(ActionEvent actionEvent) {
    }

    public void onnextButton(ActionEvent actionEvent) {
    }
}
