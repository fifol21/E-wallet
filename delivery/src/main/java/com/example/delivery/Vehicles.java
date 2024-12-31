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
import java.util.InputMismatchException;
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
            String type = typefield.getText().toLowerCase();
            String available = availablefield.getText().toLowerCase();
            String capacity = capacityfield.getText().toLowerCase();
            String load = loadfield.getText().toLowerCase();

            checkInput(vehicleID, type, available, capacity, load);

            Vehicle newVehicle = new Vehicle(Integer.parseInt(vehicleID), type, Boolean.parseBoolean(available), Integer.parseInt(capacity), Integer.parseInt(load));
            System.out.println(newVehicle.DisplayInfo());
            //System.out.println("po utworzeniu");

            // adding data from vehicle to add vehicle
            AddVehicleController.setVehicle(vehicleID, type, available, capacity, load);
            add_vehicle_stage.setScene(scene);
            add_vehicle_stage.show();


            Stage stage = (Stage) nextButton.getScene().getWindow();
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
    public void checkInput(String vehicleID, String type, String available, String capacity, String load) {
        if (vehicleID == null || vehicleID.isEmpty() || !vehicleID.matches("^[0-9]+$")) {
            throw new IllegalArgumentException("Error: Vehicle ID is incorrect (it has to be numeric) [123]");
        }
        if (type == null || type.isEmpty() || !type.matches("^[a-zA-Z]+$")) {
            throw new IllegalArgumentException("Error: Type is incorrect (it has to be alphanumeric) [abc]");
        }
        if (!available.equalsIgnoreCase("true") && !available.equalsIgnoreCase("false")) {
            throw new IllegalArgumentException("Error: Available must be 'true' or 'false'");
        }
        if (capacity == null || capacity.isEmpty() || !capacity.matches("^[0-9]+$")) {
            throw new IllegalArgumentException("Error: Capacity is incorrect (it has to be numeric) [123]");
        }
        if (load == null || load.isEmpty() || !load.matches("^[0-9]+$")) {
            throw new IllegalArgumentException("Error: Load is incorrect (it has to be numeric) [123]");
        }
    }

    public void ErrorAlert(String message, String title) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
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

