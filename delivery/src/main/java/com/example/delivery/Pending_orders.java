package com.example.delivery;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Pending_orders {
    @FXML
    public ListView pendingListView;


    public void initialize() throws IOException {
        try{
        List<Order> pending_ones = AppContext.getOrderDAO().getPendingOrders();
        ArrayList<String> list = new ArrayList<>();
        pendingListView.getItems().add("Order ID, Destination, Status");
        for(int i =0; i<pending_ones.size(); i++){
            String data = "" + String.valueOf(pending_ones.get(i).getOrderID()) +",  "+ pending_ones.get(i).getDestination() +",  "+ pending_ones.get(i).getStatus() + "";
            list.add(data);
        }
        pendingListView.getItems().addAll(list);
    }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void oncloseButton(ActionEvent actionEvent) {
        try {
            HelloApplication.changescene("Orders.fxml");
            Stage stage = (Stage) pendingListView.getScene().getWindow();
            stage.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
