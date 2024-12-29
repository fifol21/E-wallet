package com.example.delivery;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


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
    @FXML
    private Button nextButton;

    public void onbackButton(ActionEvent actionEvent) {
        try{
            HelloApplication.changescene("after_login.fxml");
        }catch (IOException e){
            e.printStackTrace();
        }

    }
    public void onaddvehicleButton(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("addvehicle.fxml"));
            Stage add_vehicle_stage= new Stage();
            add_vehicle_stage.setTitle("Add Vehicle");
            add_vehicle_stage.setResizable(false);
            Scene scene =new Scene(fxmlLoader.load(),600,400);
            AddVehicle AddVehicleController = fxmlLoader.getController();

            String vehicleID = vehicleidfield.getText().toLowerCase();
            String type = typefield.getText().toLowerCase();
            String available = availablefield.getText().toLowerCase();
            String capacity = capacityfield.getText().toLowerCase();
            String load = loadfield.getText().toLowerCase();

            Vehicle newVehicle = new Vehicle(Integer.parseInt(vehicleID), type, Boolean.parseBoolean(available), Integer.parseInt(capacity), Integer.parseInt(load));
            System.out.println(newVehicle.DisplayInfo());
            // adding data from vehicle to add vehicle
            AddVehicleController.setVehicle(vehicleID,type,available,capacity,load);
            add_vehicle_stage.setScene(scene);
            add_vehicle_stage.show();


            Stage stage = (Stage) nextButton.getScene().getWindow();
            stage.close();

        }catch (NumberFormatException e) {
            e.getCause();
            System.out.println("entered" +e.getMessage() + " is in wrong format");
        }catch (NullPointerException e) {
            e.getCause();
            e.printStackTrace();
            System.out.println("Tried to add a null vehicle");
        }catch (Exception e) {
            e.getCause();
            System.out.println(e.getMessage());
            e.printStackTrace();
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
