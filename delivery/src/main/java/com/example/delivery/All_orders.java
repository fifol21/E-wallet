package com.example.delivery;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class All_orders {
    @FXML
    public ListView allordersListViev;
    @FXML
    public Button closeButton;

    public void initialize() {
        List<Order> all_ones = AppContext.getOrderDAO().getAllOrders();
        ArrayList<String> list = new ArrayList<>();
        allordersListViev.getItems().add("Order ID,  Customer ID,  Destination,  Status,  Vehicle ID,  Cost,  Package ID");
        for(int i =0; i<all_ones.size(); i++){
            String data = "" + String.valueOf(all_ones.get(i).getOrderID())
                    + " " + String.valueOf(all_ones.get(i).getCustomerID())
                    + " "+ all_ones.get(i).getDestination()
                    +" "+ all_ones.get(i).getStatus() + ""
                    +" "+ String.valueOf(all_ones.get(i).getVehicleID())
                    +" " + String.valueOf(all_ones.get(i).getCost())
                    +" " + String.valueOf(all_ones.get(i).getPackageID()) + "";
            list.add(data);
        }
        if(all_ones.isEmpty()){
            allordersListViev.getItems().add("No pending orders");
        }else {
            allordersListViev.getItems().addAll(list);
        }
    }

    public void oncloseButton(ActionEvent actionEvent) throws IOException {
        HelloApplication.changescene("Orders.fxml");
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }
}
