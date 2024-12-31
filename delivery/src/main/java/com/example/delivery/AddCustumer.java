package com.example.delivery;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class AddCustumer {
    @FXML
    private Button backButton;
    @FXML
    private Button confirmButton;
    @FXML
    private TextField customeridfield;
    @FXML
    private TextField orderidfield;
    @FXML
    private TextField destinationfield;
    @FXML
    private TextField statusfield;

    // ustawianie w polach tego co wpisalimy w pola klasy Customers BEZ WYJATKOW DO POPRAWY

    public void setCustomer( String customerID, String name, String address, String contact) {
        customeridfield.setText(customerID);
        orderidfield.setText(name);
        destinationfield.setText(address);
        statusfield.setText(contact);

    }

   //powrot do poprzdniej sceny
    public void onbackButton(ActionEvent actionEvent) throws IOException {
            try {
                HelloApplication.changescene("customers.fxml");
                Stage stage = (Stage) backButton.getScene().getWindow();
                stage.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    public void onconfirmButton(ActionEvent actionEvent) {
        try {
            String name = orderidfield.getText();
            String address = destinationfield.getText();
            String contact = statusfield.getText();

            Customer newCustomer = new Customer(name, address, contact, AppContext.getCustomerDAO());
            AppContext.getCustomerDAO().saveCustomer(newCustomer);

            Stage stage = (Stage) confirmButton.getScene().getWindow();
            stage.close();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void onnextButton(ActionEvent actionEvent) {
    }

    public void onstatusfield(ActionEvent actionEvent) {
    }

    public void ondestinationfield(ActionEvent actionEvent) {
    }

    public void onorderidfield(ActionEvent actionEvent) {
    }

    public void oncustomerfield(ActionEvent actionEvent) {
    }
}
