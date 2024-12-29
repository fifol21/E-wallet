package com.example.delivery;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;


public class AddVehicle {
    @FXML
    private Button backButton;
    @FXML
    private TextField vehicleidfield;
    @FXML
    private TextField typefield;
    @FXML
    private TextField availablefield;
    @FXML
    private TextField loadfield;
    @FXML
    private TextField capacityfield;
    @FXML
    private Button confirmButton;


    public void setVehicle(String vehicleID, String type, String available, String capacity, String load){
        try {
            vehicleidfield.setText(vehicleID);
            typefield.setText(type);
            availablefield.setText(available);
            capacityfield.setText(capacity);
            loadfield.setText(load);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void onbackButton(ActionEvent actionEvent) throws IOException {
        HelloApplication.changescene("vehicle.fxml");
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.close();

    }

    public void onvehicleidfield(ActionEvent actionEvent) {
    }

    public void ontypefield(ActionEvent actionEvent) {
    }

    public void onavailablefield(ActionEvent actionEvent) {
    }

    public void onloadfield(ActionEvent actionEvent) {
    }

    public void oncapacityfield(ActionEvent actionEvent) {
    }

    public void onconfirmButton(ActionEvent actionEvent) {
    }

    public void onnextButton(ActionEvent actionEvent) {
    }
}
