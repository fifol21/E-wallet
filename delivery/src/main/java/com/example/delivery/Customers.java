package com.example.delivery;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
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

            // czesc ktora pozwala pobierac juz zainicjowane w zmienne wartosci z pol BEZ WYJATKOW DO POPRAWY
            AddCustumer AddCostumerController = fxmlLoader.getController();

            String customerid = customeridfield.getText();
            String name = namefield.getText();
            String address = addressfield.getText();
            String contact = contactfield.getText();
            // tworzenie obiektu z danymi wpisanymi w gui
            Customer newCustomer = new Customer(Integer.parseInt(customerid), name, address, contact);

            AddCostumerController.setCustomer(customerid, name, address, contact);

            add_costumer_stage.setScene(scene);
            add_costumer_stage.show();
            Stage stage = (Stage) nextButton.getScene().getWindow();
            stage.close();
            System.out.println(newCustomer);
        }catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void onnamefield(ActionEvent actionEvent) {
    }

    public void onaddressfield(ActionEvent actionEvent) {
    }

    public void oncontactfield(ActionEvent actionEvent) {
    }
}
