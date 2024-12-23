package com.example.delivery;

import com.sun.tools.javac.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import java.io.IOException;
import java.net.URL;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class HelloController {
    private static Stage stg;
    public HelloController() {

    }
    @FXML
    private Button cancelButton;
    @FXML
    private Button loginBUTTON;
    @FXML
    private TextField passwordfield;
    @FXML
    private TextField usernameTEXTFIELD;
    @FXML
    private Label wronglogin;

    public void onusernameTEXTFIELD(ActionEvent actionEvent) {
    }


    public void onLoginBUTTON(ActionEvent actionEvent)  throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("after_login.fxml"));
            Stage second_stage = new Stage();
            second_stage.setTitle("Choose action");
            second_stage.setScene(new Scene(fxmlLoader.load(), 600, 400));
            second_stage.show();
            Stage stage = (Stage) cancelButton.getScene().getWindow();
            stage.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error");

        }
    }





    public void oncancelButton(ActionEvent e) {
        Stage scene = (Stage) cancelButton.getScene().getWindow();
        scene.close();
    }





    public void passwordfield(ActionEvent actionEvent) {
    }

    public void onentry(MouseEvent mouseEvent) {
    }

    public void onpasswordfield(ActionEvent actionEvent) {
    }
}