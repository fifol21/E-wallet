package com.example.delivery;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Pending_orders {
    @FXML
    public ListView pendingListView;
    @FXML
    public Button closeButton;


    public void initialize(){
        List<Order> pending_ones = AppContext.getOrderDAO().getPendingOrders();
        ArrayList<String> list = new ArrayList<>();
        pendingListView.getItems().add("Order ID     Destination     Status");
        for(int i =0; i<pending_ones.size(); i++){
            String data = "" + String.valueOf(pending_ones.get(i).getOrderID()) + " "+ pending_ones.get(i).getDestination() +" "+ pending_ones.get(i).getStatus() + "";
            list.add(data);
        }
        if(pending_ones.isEmpty()){
            pendingListView.getItems().add("No pending orders");
        }else {
            pendingListView.getItems().addAll(list);
        }
    }

    public void oncloseButton(ActionEvent actionEvent) throws IOException {
        HelloApplication.changescene("Orders.fxml");
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }
}
