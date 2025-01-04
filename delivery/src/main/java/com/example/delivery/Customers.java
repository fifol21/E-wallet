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
    private Button DisplayInfo;
    @FXML
    private TextField searchbyphonenumberfield;




    public void onbackButton(ActionEvent actionEvent) {
        try {
            HelloApplication.changescene("after_login.fxml");
            Stage stage = (Stage) backButton.getScene().getWindow();
            stage.close();
        } catch (RuntimeException e) {
            HelloApplication.ErrorAlert("Error in loading scene", "Error");
        }catch (Exception e) {
            e.printStackTrace();
        }

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
            Stage stage = (Stage) DisplayInfo.getScene().getWindow();
            stage.close();

        }catch (IllegalArgumentException e) {
            HelloApplication.ErrorAlert( e.getMessage(), "Error");
            e.printStackTrace();
        }catch (NullPointerException e) {
            HelloApplication.ErrorAlert("Error Class:", "Customer is null");
            e.printStackTrace();
        }catch (IOException e){
            HelloApplication.ErrorAlert("Error:", "FXML load error");
            e.printStackTrace();
        }catch (Exception e ){
            HelloApplication.ErrorAlert("Error:", "Error occured try again");
            e.printStackTrace();
        }
    }
    public void checkInput(String name, String address, String contact) {

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

    public void onDisplayInfo(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("searchCustomer.fxml"));
        Stage searchCustomer_stage = new Stage();
        searchCustomer_stage.setTitle("Information about Customer");
        searchCustomer_stage.setResizable(false);
        Scene scene = new Scene(fxmlLoader.load(),600,400);

        String contact = searchbyphonenumberfield.getText();
        String name;
        String address;
        String Customer_ID;

        if(contact == null || contact.isEmpty() || !contact.matches("^[0-9]+$")){
            HelloApplication.ErrorAlert("Customer ID has to be alphanumeric", "Error");
        }else{
            SearchCustomer SearchCustomerController = fxmlLoader.getController();
            Customer read_from_db = AppContext.getCustomerDAO().readCustomer(Integer.parseInt(contact));
            if(read_from_db == null){
                HelloApplication.ErrorAlert("Customer not found", "Error");
                Stage stage = (Stage) customeridfield.getScene().getWindow();
                stage.close();
            }else{
                name = String.valueOf(read_from_db.getName());
                address = String.valueOf(read_from_db.getAddress());
                Customer_ID = String.valueOf(read_from_db.getCustomerID());
                SearchCustomerController.setInfo(contact,name,address,Customer_ID);
            }
            searchCustomer_stage.setScene(scene);
            searchCustomer_stage.show();

        }

    }
}
