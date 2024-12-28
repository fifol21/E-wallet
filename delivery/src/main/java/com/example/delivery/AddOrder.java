package com.example.delivery;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class AddOrder {
    @FXML
    private TextField orderfield;
    @FXML
    private TextField customeridfield;
    @FXML
    private TextField destinationfield;
    @FXML
    private TextField statusfield;
    @FXML
    private TextField vehicleidfield;
    @FXML
    private TextField costfield;
    @FXML
    private TextField packageidfield;

    public void setOrder (String orderID, String customerID, String destination, String status, String vehicleID, String cost, String packageID){
        orderfield.setText(orderID);
        customeridfield.setText(customerID);
        destinationfield.setText(destination);
        statusfield.setText(status);
        vehicleidfield.setText(vehicleID);
        costfield.setText(cost);
        packageidfield.setText(packageID);
    }


    public void onbackButton(ActionEvent actionEvent) {
    }

    public void onorderidfield(ActionEvent actionEvent) {
    }

    public void oncostumeridfield(ActionEvent actionEvent) {
    }

    public void ondestinationfield(ActionEvent actionEvent) {
    }

    public void onstatusfield(ActionEvent actionEvent) {
    }

    public void onvehicleidfield(ActionEvent actionEvent) {
    }

    public void oncostfield(ActionEvent actionEvent) {
    }

    public void onpackageidfield(ActionEvent actionEvent) {
    }

    public void onnextButton(ActionEvent actionEvent) {
    }

    public void onconfirmButton(ActionEvent actionEvent) {
    }
}
