package com.example.delivery;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class AddCustumer {
    @FXML
    public TextField namefield;
    @FXML
    public TextField addressfield;
    @FXML
    public TextField numberfield;
    @FXML
    private Button backButton;
    @FXML
    private Button confirmButton;

    // ustawianie w polach tego co wpisalimy w pola klasy Customers BEZ WYJATKOW DO POPRAWY

    public void setCustomer( String name, String address, String contact) {
        namefield.setText(name);
        addressfield.setText(address);
        numberfield.setText(contact);

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
            String name = namefield.getText();
            String address = addressfield.getText();
            String contact = numberfield.getText();

            Customer newCustomer = new Customer(name, address, contact, AppContext.getCustomerDAO());
            AppContext.getCustomerDAO().saveCustomer(newCustomer);

        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void onnextButton(ActionEvent actionEvent) {
    }

    public void onaddressfield(ActionEvent actionEvent) {
    }

    public void onnumberfield(ActionEvent actionEvent) {
    }
}
