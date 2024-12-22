package com.example.delivery;

import com.sun.tools.javac.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import java.io.IOException;
import java.net.URL;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javafx.event.ActionEvent;

public class Afterlogin {
    @FXML
    private Button vehicleButton;
    @FXML
    private Button customersButton;


    public void onvehicleButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("vehicle.fxml"));
        Stage vehicle_stage = new Stage();
        vehicle_stage.setTitle("Vehicle data");
        vehicle_stage.setScene(new Scene(fxmlLoader.load(), 600,400));
        vehicle_stage.show();
        Stage stage = (Stage) vehicleButton.getScene().getWindow();
        stage.close();

    }

    public void onordersButton(ActionEvent actionEvent) {

    }

    public void oncustomersbutton(ActionEvent actionEvent) throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("customers.fxml"));
            Stage customer_stage = new Stage();
            customer_stage.setTitle("Customers data");
            customer_stage.setScene(new Scene(fxmlLoader.load(), 600, 400));
            customer_stage.show();

        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
