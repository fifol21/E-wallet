package com.example.delivery;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.util.ArrayList;
import java.util.List;

public class Pending_orders {
    @FXML
    private ListView<String> listView;

    public void initialize(){
        List<Order> pending_ones = AppContext.getOrderDAO().getPendingOrders();
        ArrayList<String> list = new ArrayList<>();
        for(int i =0; i<pending_ones.size(); i++){
            String data = "" + String.valueOf(pending_ones.get(i).getOrderID()) + pending_ones.get(i).getDestination() + pending_ones.get(i).getStatus() + "";
            list.add(data);
        }
        listView.getItems().addAll(list);
    }
}
