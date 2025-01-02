package com.example.delivery;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


import java.io.IOException;

public class Vehicles {
    @FXML
    private TextField vehicleidfield;
    private TextField capacityfield;
    @FXML
    private Button addvehicleButton;

    public void onbackButton(ActionEvent actionEvent) {
        try {
            HelloApplication.changescene("after_login.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void onaddvehicleButton(ActionEvent actionEvent) throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("addvehicle.fxml"));
            Stage add_vehicle_stage = new Stage();
            add_vehicle_stage.setTitle("Add Vehicle");
            add_vehicle_stage.setResizable(false);
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            AddVehicle AddVehicleController = fxmlLoader.getController();
            //System.out.println("przed");

            String vehicleID = vehicleidfield.getText().toLowerCase();
            String capacity = capacityfield.getText().toLowerCase();

            checkInput(vehicleID, capacity);





            // adding data from vehicle to add vehicle
            AddVehicleController.setVehicle(vehicleID,capacity);
            add_vehicle_stage.setScene(scene);
            add_vehicle_stage.show();


            Stage stage = (Stage) capacityfield.getScene().getWindow();
            stage.close();

        }catch (IllegalArgumentException e) {
            ErrorAlert( e.getMessage(), "Error");
            e.printStackTrace();
        }catch (NullPointerException e) {
            ErrorAlert("Error Class:", "Customer is null");
            e.printStackTrace();
        }catch (IOException e){
            ErrorAlert("Error:", "FXML load error");
            e.printStackTrace();
        }catch (Exception e ) {
            ErrorAlert("Error:", "Error occured try again");
            e.printStackTrace();
        }


    }
    public void checkInput(String vehicleID, String capacity) {
        if (vehicleID == null || vehicleID.isEmpty() || !vehicleID.matches("^[0-9]+$")) {
            throw new IllegalArgumentException("Error: Vehicle ID is incorrect (it has to be numeric) [123]");
        }
        if (capacity == null || capacity.isEmpty() || !capacity.matches("^[0-9]+$")) {
            throw new IllegalArgumentException("Error: Capacity is incorrect (it has to be numeric) [123]");
        }
    }

    public void ErrorAlert(String message, String title) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }


    public void onvehicleidfield(ActionEvent actionEvent) {
    }

    public void ontypefield(ActionEvent actionEvent) {
    }

    public void oncapacityfield(ActionEvent actionEvent) {
    }

}

