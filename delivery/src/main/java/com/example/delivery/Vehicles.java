package com.example.delivery;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
    public Button DisplayInfoButton;
    @FXML
    public TextField vehicle_searchIDfield;
    @FXML
    public TextField typefield;
    @FXML
    private TextField vehicleidfield;
    @FXML
    private TextField capacityfield;

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


//            Stage stage = (Stage) capacityfield.getScene().getWindow();
//            stage.close();

        }catch (IllegalArgumentException e) {
            HelloApplication.ErrorAlert( e.getMessage(), "Error");
            e.printStackTrace();
        }catch (NullPointerException e) {
            HelloApplication.ErrorAlert("Error Class:", "Customer is null");
            e.printStackTrace();
        }catch (IOException e){
            HelloApplication.ErrorAlert("Error:", "FXML load error");
            e.printStackTrace();
        }catch (Exception e ) {
            HelloApplication.ErrorAlert("Error:", "Error occured try again");
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




    public void onvehicleidfield(ActionEvent actionEvent) {
    }

    public void ontypefield(ActionEvent actionEvent) {
    }

    public void oncapacityfield(ActionEvent actionEvent) {
    }

    public void onDisplayInfoButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("searhcvehicle.fxml"));
        Stage search_vehicle_stage = new Stage();
        search_vehicle_stage.setTitle("Information about Vehicle");
        search_vehicle_stage.setResizable(false);
        Scene scene = new Scene(fxmlLoader.load(),600,400);

        SearchVehicle SearchVehicleController = fxmlLoader.getController();

        String search_vehicleID = vehicle_searchIDfield.getText();
        String capacity;
        String type;
        String isavailable;
        String load;

        if(search_vehicleID == null || search_vehicleID.isEmpty() || !search_vehicleID.matches("^[0-9]+$")) {
            HelloApplication.ErrorAlert( "Vehicle ID should be numeric " ,"Error");
        }else{
            Vehicle read_from_db = AppContext.getVehicleDAO().getVehicle(Integer.parseInt(search_vehicleID));
            if(read_from_db == null) {
                HelloApplication.ErrorAlert( "Vehicle ID does not exist" ,"Error");
            }else{
                capacity=Integer.toString(read_from_db.getCapacity());
                type=String.valueOf(read_from_db.getType());
                isavailable=String.valueOf(read_from_db.isAvailable());
                load=Integer.toString(read_from_db.getLoad());
                SearchVehicleController.setInfo(search_vehicleID,capacity,type,isavailable,load);

            }
            search_vehicle_stage.setScene(scene);
            search_vehicle_stage.show();
        }
    }
}

