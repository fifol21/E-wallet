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
    //@FXML
    //private TextField availablefield;
    //@FXML
    //private TextField loadfield;
    @FXML
    private TextField capacityfield;
    @FXML
    private Button confirmButton;


    public void setVehicle(String vehicleID, String capacity){
        try {
            vehicleidfield.setText(vehicleID);
           // typefield.setText(type);
           // availablefield.setText(available);
            capacityfield.setText(capacity);
           // loadfield.setText(load);
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

   // public void onavailablefield(ActionEvent actionEvent) {
    //}

    //public void onloadfield(ActionEvent actionEvent) {
   // }

    public void oncapacityfield(ActionEvent actionEvent) {
    }

    public void onconfirmButton(ActionEvent actionEvent) {
        String vehicleID = vehicleidfield.getText().toLowerCase();
        //String type = typefield.getText().toLowerCase();
        String capacity = capacityfield.getText().toLowerCase();

        HelloApplication.addVehicle(Integer.parseInt(vehicleID),Integer.parseInt(capacity),AppContext.getVehicleDAO());
      //  AppContext.getVehicleDAO().createVehicle(newVehicle); // czy to jest git napewno ? i czy nie mozna zrobic metode addVehicle static i zmienic tutaj
      //  System.out.println(newVehicle.DisplayInfo());
        Stage stage = (Stage) capacityfield.getScene().getWindow();
        stage.close();

    }


}
