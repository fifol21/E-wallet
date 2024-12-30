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
            Scene scene = new Scene(fxmlLoader.load(), 600 ,400);

            String orderID = orderfield.getText();
            String customerID = customeridfield.getText().toLowerCase();
            String destination = destinationfield.getText().toLowerCase();
            String status = statusfield.getText().toLowerCase();
            String vehicleID = vehicleidfield.getText().toLowerCase();
            String cost = costfield.getText().toLowerCase();
            String packageID = packageidfield.getText().toLowerCase();

            // check input data
            checkInput(orderID,customerID,destination,status,vehicleID,cost,packageID);


            AddOrder AddOrderController = fxmlLoader.getController();

            Order newOrder = new Order(Integer.parseInt(orderID), Integer.parseInt(customerID), destination, status, Integer.parseInt(vehicleID), Float.parseFloat(cost), Integer.parseInt(packageID));

            AddOrderController.setOrder(orderID, customerID, destination, status, vehicleID, cost, packageID);
            add_order.setScene(scene);
            add_order.show();

        }catch (IllegalArgumentException e) {
            ErrorAlert(e.getMessage(), "Error");
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
    public void checkInput(String orderID, String customerID, String destination, String status, String vehicleID, String cost, String packageID) {
        if (orderID == null|| orderID.isEmpty() || !orderID.matches("[0-9]+$")) {
            throw new IllegalArgumentException("Error: Order ID is incorrect (it has to be numeric) [123]");
        }
        if (customerID==null || customerID.isEmpty()|| !customerID.matches("[0-9]+$")) {
            throw new IllegalArgumentException("Error :Customer ID is incorrect (it has to be numeric)[123]");
        }
        if (destination==null || destination.isEmpty() || destination.matches("[0-9]+$")) {
            throw new IllegalArgumentException("Error: Destination is incorrect (it has to be alphanumeric)[abc]");
        }
        if (status==null || status.isEmpty() || status.matches("^[0-9]+$")) {
            throw new IllegalArgumentException("Error: Status  is incorrect (it has to be alphanumeric) [abc]");
        }
        if (vehicleID==null || vehicleID.isEmpty()|| !vehicleID.matches("^[0-9]+$")) {
            throw new IllegalArgumentException("Error: Vehicle ID is incorrect (it has to be numeric) [123]");
        }
        if (cost==null || cost.isEmpty() || !cost.matches("^[0-9]+\\.[0-9]+$")){
            throw new IllegalArgumentException("Error: Cost is incorrect (it has to be decimal) [123.123]");
        }
    }
    public void ErrorAlert(String message, String title) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

        public void onpackageidfield (ActionEvent actionEvent){
        }
    }

