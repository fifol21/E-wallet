module com.example.delivery {
    requires javafx.controls;
    requires javafx.fxml;
    requires jdk.compiler;
    requires java.sql;


    opens com.example.delivery to javafx.fxml;
    exports com.example.delivery;
}