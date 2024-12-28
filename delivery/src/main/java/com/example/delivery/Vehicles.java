package com.example.delivery;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


import java.io.IOException;
import java.util.Locale;


public class Vehicles {
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
    private Button addvehicleButton;

    public void onbackButton(ActionEvent actionEvent) {
        try{
            HelloApplication.changescene("after_login.fxml");
        }catch (IOException e){
            e.printStackTrace();
        }

    }
    public void onaddvehicleButton(ActionEvent actionEvent) {
        try {
            String vehicleID = vehicleidfield.getText().toLowerCase();
            String type = typefield.getText().toLowerCase();
            String available = availablefield.getText().toLowerCase();
            String capacity = capacityfield.getText().toLowerCase();
            String load = loadfield.getText().toLowerCase();

            Vehicle newVehicle = new Vehicle(Integer.parseInt(vehicleID), type, Boolean.parseBoolean(available), Integer.parseInt(capacity), Integer.parseInt(load));
            System.out.println(newVehicle.DisplayInfo());
        }catch (NumberFormatException e) {
            e.getCause();
            System.out.println("entered" +e.getMessage() + " is in wrong format");
        }catch (NullPointerException e) {
            e.getCause();
            System.out.println("Tried to add a null vehicle");
        }catch (Exception e) {
            e.getCause();
            System.out.println(e.getMessage());
        }




    }

    public void onnextButton(ActionEvent actionEvent) {
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

}
