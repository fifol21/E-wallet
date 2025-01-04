package com.example.delivery;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class SearchVehicle {
    @FXML
    public TextField vehicleidfield;
    @FXML
    public TextField typefield;
    @FXML
    public TextField capacityfield;
    @FXML
    public Button backButton;
    @FXML
    public TextField loadfield;
    @FXML
    public TextField availablefield;

    public void setInfo(String vehicleid, String type, String capacity,String isavailable, String load) {
        vehicleidfield.setText(vehicleid);
        typefield.setText(type);
        capacityfield.setText(capacity);
        availablefield.setText(isavailable);
        loadfield.setText(load);
    }

    public void onbackButton(ActionEvent actionEvent) throws IOException {
        try {
            HelloApplication.changescene("vehicle.fxml");
            Stage stage = (Stage) backButton.getScene().getWindow();
            stage.close();
        }catch (NullPointerException e){
            HelloApplication.ErrorAlert("Error Occured", "Error Occured");
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
