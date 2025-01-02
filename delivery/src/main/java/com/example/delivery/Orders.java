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
    private TextField phonenumberfield;
    @FXML
    private TextField namefield;
    @FXML
    private TextField addressfield;
    @FXML
    private TextField destinationfield;
    @FXML
    private TextField statusfield;
    @FXML
    private TextField sizefield;
    @FXML
    private TextField weightfield;
    @FXML
    private TextField iffragilefield;
    @FXML
    private TextField searchbyorderid;
    @FXML
    private Button displayinfoButton;



    public void onbackButton(ActionEvent actionEvent) throws IOException {
        try {
            HelloApplication.changescene("after_login.fxml");
            Stage stage = (Stage) backButton.getScene().getWindow();
            stage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void ondestinationfield(ActionEvent actionEvent) {
    }

    public void onstatusfield(ActionEvent actionEvent) {
    }

    public void onaddorderButton(ActionEvent actionEvent) throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("addorder(ok).fxml"));
            Stage add_order = new Stage();
            add_order.setTitle("Add Order");
            add_order.setResizable(false);
            Scene scene = new Scene(fxmlLoader.load(), 600 ,400);

            String phonenumber = phonenumberfield.getText();
            String name = namefield.getText();
            String address = addressfield.getText();
            String destination = destinationfield.getText();
            String status = statusfield.getText();
            String weight = weightfield.getText();
            String iffragile = iffragilefield.getText();
            String size = sizefield.getText();





            // check input data
            checkInput(phonenumber, name, address, destination, status, weight, iffragile);


            AddOrder AddOrderController = fxmlLoader.getController();




            AddOrderController.setOrder(phonenumber,name,address,size,destination,status,weight, iffragile);
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

    public void checkInput(String phonenumber, String name, String address, String destination, String status, String weight, String iffragile) {
        if (phonenumber == null|| phonenumber.isEmpty() || !phonenumber.matches("^[0-9]+$")) {
            throw new IllegalArgumentException("Error: phone number is incorrect (it has to be numeric) [123]");
        }
        if (name==null || name.isEmpty()|| !name.matches("^[a-zA-Z]+$")) {
            throw new IllegalArgumentException("Error: name is incorrect (it has to be numeric)[123]");
        }
        if (destination==null || destination.isEmpty() || destination.matches("^[0-9]+$")) {
            throw new IllegalArgumentException("Error: Destination is incorrect (it has to be alphanumeric)[abc]");
        }
        if (status==null || status.isEmpty() || status.matches("^[0-9]+$")) {
            throw new IllegalArgumentException("Error: Status  is incorrect (it has to be alphanumeric) [abc]");
        }
        if (address==null || address.isEmpty()|| !address.matches("^[a-zA-Z]+$")) {
            throw new IllegalArgumentException("Error: address is incorrect (it has to be numeric) [123]");
        }
        if (weight==null || weight.isEmpty() || !weight.matches("^[0-9]+$")){
            throw new IllegalArgumentException("Error: weight is incorrect (it has to be decimal) [123.123]");
        }
        if (iffragile==null || iffragile.isEmpty() || !iffragile.equalsIgnoreCase("true") && !iffragile.equalsIgnoreCase("false")) {
            throw new IllegalArgumentException("Error: Iffragile is incorrect (it has to be true or false)");
        }
    }
    public void ErrorAlert(String message, String title) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
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

    public void ondisplayinfoButton(ActionEvent actionEvent) throws Exception{

        // jesli sie wpisze numer telefonu poprawnie, musi wyszukac informacje o zamowieniu i wyswietlic je w okienku"searchorder"
        // trzeba tutaj dopisac metode czy cos zeby po poprawnym wpisaniu nr wyszukalo w bazie i wyplulo poprawne informacje.
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("searchOrder.fxml"));
            Stage search_order = new Stage();
            search_order.setTitle("Information about order");
            search_order.setResizable(false);
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);

            String search_orderID = searchbyorderid.getText();
            String customer_ID;
            String destination;
            String status;
            String vehicleID;
            String cost;
            String packageID;
            if (search_orderID == null || search_orderID.isEmpty() || !search_orderID.matches("^[0-9]+$")) {
                ErrorAlert("Order ID should be numeric", "Error");
            } else {
                UpdateStatus UpdateStatusController = fxmlLoader.getController();
                Order read_from_db = AppContext.getOrderDAO().readOrder(Integer.parseInt(search_orderID), AppContext.getPackageDAO());
                if(read_from_db == null){
                    ErrorAlert("There is not such a order", "Error");
                    Stage stage = (Stage) searchbyorderid.getScene().getWindow();
                    stage.close();
                }else{
                    customer_ID = String.valueOf(read_from_db.getCustomerID());
                    destination = read_from_db.getDestination();
                    status = read_from_db.getStatus();
                    vehicleID = String.valueOf(read_from_db.getVehicleID());
                    cost = String.valueOf(read_from_db.getCost());
                    packageID = String.valueOf(read_from_db.getPackageID());
                    UpdateStatusController.setInfo(search_orderID, customer_ID,destination,status,vehicleID,cost,packageID);
                }

                search_order.setScene(scene);
                search_order.show();
            }
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }



    public void onsearchbyorderid(ActionEvent actionEvent) {
    }
}

