package com.example.delivery;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class SearchCustomer {
    @FXML
    public TextField customeridfield;
    @FXML
    public TextField namefield;
    @FXML
    public TextField addressfield;
    @FXML
    public TextField contactfield;
    @FXML
    public Button backButton;
    @FXML
    public Button UpdateCustomerButton;


    public void onbackButton(ActionEvent actionEvent) throws IOException {
        HelloApplication.changescene("customers.fxml");
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.close();
    }

    public void setInfo(String contact, String name, String address, String customerID) {
        contactfield.setText(contact);
        namefield.setText(name);
        addressfield.setText(address);
        contactfield.setText(customerID);
    }

    public void onUpdateCustomerButton(ActionEvent actionEvent) {
        String name = namefield.getText();
        String address = addressfield.getText();
        String customer_ID = contactfield.getText();
        String contact = customeridfield.getText();

        Customer update = new Customer(Integer.parseInt(customer_ID), name, address, contact);
        AppContext.getCustomerDAO().saveCustomer(update); // nie wiem czy to jest ok, bo nie ma metody update Customer
    }
}
