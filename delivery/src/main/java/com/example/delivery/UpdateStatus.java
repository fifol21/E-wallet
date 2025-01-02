package com.example.delivery;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class UpdateStatus {
    @FXML
    public TextField orderidfield;
    @FXML
    public TextField customeridfield;
    @FXML
    public TextField destinationfield;
    @FXML
    public TextField statusfield;
    @FXML
    public TextField vehicleidfield;
    @FXML
    public TextField costfield;
    @FXML
    public Button updatestatusButton;
    @FXML
    public TextField packageidfield;
    @FXML
    private Button backButton;


    // Zadaniem tej klasy bedzie pokazanie informacji ktore zostana wyplute przed metode w klasie Order -> ondisplayinfoButton.
    // kolejne zadanie to bedzie tyljo edytowalny pole STATUS, zebysmy moghli zmienic status i wcisniecie przycisku changestatus zapisze do bazy danych
    // nowe dane
    public void setInfo(String order_id,String customer_id, String destination, String status, String vehicle_id, String cost, String package_id){
        orderidfield.setText(order_id);
        customeridfield.setText(customer_id);
        destinationfield.setText(destination);
        statusfield.setText(status);
        vehicleidfield.setText(vehicle_id);
        costfield.setText(cost);
        packageidfield.setText(package_id);
    }
    public void onbackButton(ActionEvent actionEvent) throws IOException {
        HelloApplication.changescene("Orders.fxml");
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.close();
        }


    public void onphonenumberfield(ActionEvent actionEvent) {
    }

    public void onnamefield(ActionEvent actionEvent) {
    }

    public void ondestinationfield(ActionEvent actionEvent) {
    }

    public void onstatusfield(ActionEvent actionEvent) {
    }

    public void onaddressfield(ActionEvent actionEvent) {
    }

    public void onsizefield(ActionEvent actionEvent) {
    }



    public void onweightfield(ActionEvent actionEvent) {
    }

    public void iffragilefield(ActionEvent actionEvent) {
    }

    public void onupdatestatusButton(ActionEvent actionEvent) {
        String order_id = orderidfield.getText();
        String customer_id = customeridfield.getText();
        String destination = destinationfield.getText();
        String status = statusfield.getText();
        String vehicle_id = vehicleidfield.getText();
        String cost = costfield.getText();
        String package_id = packageidfield.getText();

        Order updated = new Order(Integer.parseInt(order_id),Integer.parseInt(customer_id),destination,status,Integer.parseInt(vehicle_id),Float.parseFloat(cost),Integer.parseInt(package_id));
        AppContext.getOrderDAO().updateOrder(updated);

        Stage stage = (Stage) updatestatusButton.getScene().getWindow();
        stage.close();
    }
}
