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

public class Customers {
    @FXML
    private Button backButton;
    @FXML
    private TextField customeridfield;
    @FXML
    private TextField namefield;
    @FXML
    private TextField addressfield;
    @FXML
    private TextField contactfield;
    @FXML
    private Button nextButton;




    public void onbackButton(ActionEvent actionEvent) {
        try {
            HelloApplication.changescene("after_login.fxml");
            Stage stage = (Stage) backButton.getScene().getWindow();
            stage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void oncustomerfield(ActionEvent actionEvent) throws IOException {
    }





    public void onnextButton(ActionEvent actionEvent) {
    }

    public void onaddcostumerButton(ActionEvent actionEvent) throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("addcostumer.fxml"));
            Stage add_costumer_stage = new Stage();
            add_costumer_stage.setTitle("Add Costumer");
            add_costumer_stage.setResizable(false);
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);

            AddCustumer AddCostumerController = fxmlLoader.getController();

            String customerID = customeridfield.getText().toLowerCase();
            String name = namefield.getText();
            String address = addressfield.getText();
            String contact = contactfield.getText();

            // tworzenie obiektu z danymi wpisanymi w gui

            checkInput(name, address, contact); // input check

            AddCostumerController.setCustomer(customerID, name, address, contact);

            add_costumer_stage.setScene(scene);
            add_costumer_stage.show();
            Stage stage = (Stage) nextButton.getScene().getWindow();
            stage.close();
//            System.out.println(newCustomer);
        }catch (IllegalArgumentException e) {
            ErrorAlert( e.getMessage(), "Error");
            e.printStackTrace();
        }catch (NullPointerException e) {
            ErrorAlert("Error Class:", "Customer is null");
            e.printStackTrace();
        }catch (IOException e){
            ErrorAlert("Error:", "FXML load error");
            e.printStackTrace();
        }catch (Exception e ){
            ErrorAlert("Error:", "Error occured try again");
            e.printStackTrace();
        }
    }
    public void checkInput(String name, String address, String contact) {
//            if (customerID == null || customerID.isEmpty()|| !customerID.matches("^[0-9]+$")){
//                throw new IllegalArgumentException("Error: Customer ID is incorrect (it has to be numeric) [123]");
//            }
            if (name == null || name.isEmpty()||!name.matches("^[a-zA-Z]+$")){
                throw new IllegalArgumentException("Error: name is incorrect (it has to be alphanumeric) [abc]");

            }
            if (address == null || address.isEmpty()||!address.matches("^[a-zA-Z]+$")){
                throw new IllegalArgumentException("Error: address is incorrect (it has to be alphanumeric) [abc]");
            }
            if (contact == null || contact.isEmpty()||!contact.matches("^[0-9]+$")){
                throw new IllegalArgumentException("Error: contact is incorrect (it has to be numeric) [123]");
            }
        }
    public void ErrorAlert(String message, String title) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public void onnamefield(ActionEvent actionEvent) {
    }

    public void onaddressfield(ActionEvent actionEvent) {
    }

    public void oncontactfield(ActionEvent actionEvent) {
    }
}
