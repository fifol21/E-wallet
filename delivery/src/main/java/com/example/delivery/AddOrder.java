package com.example.delivery;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class AddOrder {

    @FXML
    private TextField destinationfield;
    @FXML
    private TextField statusfield;
    @FXML
    private TextField phonenumberfield;
    @FXML
    private TextField namefield;
    @FXML
    private TextField addressfield;
    @FXML
    private TextField sizefield;
    @FXML
    private TextField weightfield;
    @FXML
    private TextField iffragilefield;

    @FXML
    private Button backButton;

    public void setOrder(String phonenumber, String name, String address, String size, String destination,String status,String weight, String iffragile) {
        phonenumberfield.setText(phonenumber);
        namefield.setText(name);
        addressfield.setText(address);
        sizefield.setText(size);
        weightfield.setText(weight);
        iffragilefield.setText(iffragile);
        statusfield.setText(status);
        destinationfield.setText(destination);



    }


    public void onbackButton(ActionEvent actionEvent) throws IOException {
        try{
        HelloApplication.changescene("Orders.fxml");
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.close();
    }catch (Exception e){
            e.printStackTrace();
        }
    }



    public void ondestinationfield(ActionEvent actionEvent) {
    }

    public void onstatusfield(ActionEvent actionEvent) {
    }


    public void onnextButton(ActionEvent actionEvent) {
    }

    public void onconfirmButton(ActionEvent actionEvent) {
        String phonenumber = phonenumberfield.getText();
        String name = namefield.getText();
        String address = addressfield.getText();
        String destination = destinationfield.getText();
        String status = statusfield.getText();
        String weight = weightfield.getText();
        String iffragile = iffragilefield.getText();
        String size = sizefield.getText();

        HelloApplication.createOrder(phonenumber,name,address,status,destination, size, Float.parseFloat(weight), Boolean.parseBoolean(iffragile),AppContext.getCustomerDAO(),AppContext.getPackageDAO(), AppContext.getOrderDAO(),AppContext.getVehicleDAO());
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.close();
    }

    public void onphonenumberfield(ActionEvent actionEvent) {
    }

    public void onnamefield(ActionEvent actionEvent) {
    }

    public void onaddressfield(ActionEvent actionEvent) {
    }

    public void onsizefield(ActionEvent actionEvent) {
    }

    public void onweightfield(ActionEvent actionEvent) {
    }

    public void iffragilefield(ActionEvent actionEvent) {

    }
}
