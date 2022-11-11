module com.example.testapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.java;


    opens com.example.testapp to javafx.fxml;
    exports com.example.testapp;
}