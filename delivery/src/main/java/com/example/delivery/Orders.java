package com.example.delivery;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Orders {
    @FXML
    private Button backButton;
    @FXML
    private Button addorderButton;
    @FXML
    private TextField orderfield;
    @FXML
    private TextField customeridfield;
    @FXML
    private TextField destinationfield;
    @FXML
    private TextField statusfield;
    @FXML
    private TextField vehicleidfield;
    @FXML
    private TextField costfield;
    @FXML
    private TextField packageidfield;


    public void onbackButton(ActionEvent actionEvent) throws IOException {
        try {
            HelloApplication.changescene("after_login.fxml");
            Stage stage = (Stage) backButton.getScene().getWindow();
            stage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onnextButton(ActionEvent actionEvent) {
    }

    public void onorderidfield(ActionEvent actionEvent) {
    }

    public void oncostumeridfield(ActionEvent actionEvent) {
    }

    public void ondestinationfield(ActionEvent actionEvent) {
    }

    public void onstatusfield(ActionEvent actionEvent) {
    }

    public void onvehicleidfield(ActionEvent actionEvent) {
    }

    public void oncostfield(ActionEvent actionEvent) {
    }

    public void onaddorderButton(ActionEvent actionEvent) throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("addorder.fxml"));
            Stage add_order = new Stage();
            add_order.setTitle("Add Order");
            add_order.setResizable(false);
            Scene scene = new Scene(fxmlLoader.load(), 400, 600);

            String orderID = orderfield.getText();
            String customerID = customeridfield.getText().toLowerCase();
            String destination = destinationfield.getText().toLowerCase();
            String status = statusfield.getText().toLowerCase();
            String vehicleID = vehicleidfield.getText().toLowerCase();
            String cost = costfield.getText().toLowerCase();
            String packageID = packageidfield.getText().toLowerCase();

            AddOrder AddOrderController = fxmlLoader.getController();

            Order newOrder = new Order(Integer.parseInt(orderID), Integer.parseInt(customerID), destination, status, Integer.parseInt(vehicleID), Float.parseFloat(cost), Integer.parseInt(packageID));

            AddOrderController.setOrder(orderID, customerID, destination, status, vehicleID, cost, packageID);
            add_order.setScene(scene);
            add_order.show();

        }catch (NumberFormatException e) {
            e.getCause();
            System.out.println("entered" + e.getCause() + " is in wrong format");
        }catch (NullPointerException e){
            e.getCause();;
        }catch (IOException e){
            e.getCause();
        }
    }

        public void onpackageidfield (ActionEvent actionEvent){
        }
    }

