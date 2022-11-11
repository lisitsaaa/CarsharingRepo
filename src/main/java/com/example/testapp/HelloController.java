package com.example.testapp;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

public class HelloController {

    @FXML
    private Button autoSingInButton;

    @FXML
    private PasswordField passwordField;

    @FXML
    void openHomeScene(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("app1.fxml"));
        Parent root = loader.load();
        HomeController homeController = loader.getController();

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("HOME");
        stage.show();
    }

    @FXML
    void errorPage(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        Parent root = loader.load();
        HelloController helloController = loader.getController();

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("TRY AGAIN");
        stage.show();
    }

    @FXML
    void initialize() {
//      LOG IN
        autoSingInButton.setOnAction(actionEvent -> {
            autoSingInButton.getScene().getWindow().hide();
            String password = passwordField.getText().trim();
            if (password.equals("admin"))
                try {
                    openHomeScene(actionEvent);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            else {
                System.out.println("Sorry! Your password isn't correct :(");
                try {
                    errorPage(actionEvent);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        });
    }

}