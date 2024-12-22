module com.example.delivery {
    requires javafx.controls;
    requires javafx.fxml;
    requires jdk.compiler;


    opens com.example.delivery to javafx.fxml;
    exports com.example.delivery;
}