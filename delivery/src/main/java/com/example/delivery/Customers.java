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
    private TextField orderidfield;
    @FXML
    private TextField destinationfield;
    @FXML
    private TextField statusfield;




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
        String customerid = customeridfield.getText();
        System.out.println(customerid);

    }

    public void onorderidfield(ActionEvent actionEvent) {
        String orderid = orderidfield.getText();
        System.out.println(orderid);
    }

    public void ondestinationfield(ActionEvent actionEvent) {
        String destination = destinationfield.getText();
        System.out.println(destination);
    }

    public void onstatusfield(ActionEvent actionEvent) {
        String status = statusfield.getText();
        System.out.println(status);
    }

    public void onnextButton(ActionEvent actionEvent) {
    }

    public void onaddcostumerButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("addcostumer.fxml"));
        Stage add_costumer_stage = new Stage();
        add_costumer_stage.setTitle("Add Costumer");
        add_costumer_stage.setResizable(false);
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);

        // czesc ktora pozwala pobierac juz zainicjowane w zmienne wartosci z pol BEZ WYJATKOW DO POPRAWY
        AddCustumer AddCostumerController = fxmlLoader.getController();
        String customerid = customeridfield.getText();
        String orderid = orderidfield.getText();
        String destination = destinationfield.getText();
        String status = statusfield.getText();

        AddCostumerController.setData(customerid, orderid, destination, status);

        add_costumer_stage.setScene(scene);
        add_costumer_stage.show();




    }
}
