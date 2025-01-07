package com.example.delivery;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;

public class OrdersHistory {
    @FXML
    public Button closeButton;
    @FXML
    public ListView OrdersHistoryView;

    public void oncloseButton(ActionEvent actionEvent) throws IOException {
        HelloApplication.changescene("Orders.fxml");
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }
    public void initialize() {

    }
}
