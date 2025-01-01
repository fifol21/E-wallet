package com.example.delivery;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class UpdateStatus {
    @FXML
    private Button backButton;
    @FXML
    private Button updatestatusButton;
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

    // Zadaniem tej klasy bedzie pokazanie informacji ktore zostana wyplute przed metode w klasie Order -> ondisplayinfoButton.
    // kolejne zadanie to bedzie tyljo edytowalny pole STATUS, zebysmy moghli zmienic status i wcisniecie przycisku changestatus zapisze do bazy danych
    // nowe dane

    public void onbackButton(ActionEvent actionEvent) throws IOException {
        HelloApplication.changescene("Orders.fxml");
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.close();
        }


    public void onphonenumberfield(ActionEvent actionEvent) {
    }

    public void onnamefield(ActionEvent actionEvent) {
    }

    public void ondestinationfield(ActionEvent actionEvent) {
    }

    public void onstatusfield(ActionEvent actionEvent) {
    }

    public void onaddressfield(ActionEvent actionEvent) {
    }

    public void onsizefield(ActionEvent actionEvent) {
    }



    public void onweightfield(ActionEvent actionEvent) {
    }

    public void iffragilefield(ActionEvent actionEvent) {
    }

    public void onupdatestatusButton(ActionEvent actionEvent) {
    }
}
