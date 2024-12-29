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
    @FXML
    private Button ordersButton;


    public void onvehicleButton(ActionEvent actionEvent) throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("vehicle.fxml"));
            Stage vehicle_stage = new Stage();
            vehicle_stage.setResizable(false);
            vehicle_stage.setTitle("Vehicle data");
            vehicle_stage.setScene(new Scene(fxmlLoader.load(), 600, 400));
            vehicle_stage.show();
            Stage stage = (Stage) customersButton.getScene().getWindow();
            stage.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void onordersButton(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Orders.fxml"));
            Stage order_stage = new Stage();
            order_stage.setResizable(false);
            order_stage.setTitle("Customers data");
            order_stage.setScene(new Scene(fxmlLoader.load(), 600, 400));
            order_stage.show();
            Stage stage = (Stage) customersButton.getScene().getWindow();
            stage.close();

        }catch (IOException e){
            e.printStackTrace();
        }


    }

    public void oncustomersbutton(ActionEvent actionEvent) throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("customers.fxml"));
            Stage customer_stage = new Stage();
            customer_stage.setResizable(false);
            customer_stage.setTitle("Customers data");
            customer_stage.setScene(new Scene(fxmlLoader.load(), 600, 400));
            customer_stage.show();
            Stage stage = (Stage) ordersButton.getScene().getWindow();
            stage.close();

        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
