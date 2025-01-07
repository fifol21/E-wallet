package com.example.delivery;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OrdersHistory {
    @FXML
    public Button closeButton;
    @FXML
    public ListView OrdersHistoryView;

    public void oncloseButton(ActionEvent actionEvent) throws IOException {
        HelloApplication.changescene("Orders.fxml");
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }
    public void initialize() throws IOException {
        try{
            OrdersHistoryView.getItems().add("Order ID   Status");
            List<List<String>> history = AppContext.getOrderDAO().get_orders_history();
//            for(int i =0; i<history.size(); i++){
//                String data = "" + String.valueOf(pending_ones.get(i).getOrderID()) + pending_ones.get(i).getDestination() + pending_ones.get(i).getStatus() + "";
//                list.add(data);
//            }
            OrdersHistoryView.getItems().addAll(history);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
