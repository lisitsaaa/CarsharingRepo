package com.example.testapp;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class HomeController {

    @FXML
    private Button buyButton;

    @FXML
    private Button currentStatusButton;

    @FXML
    private Button giveBackButton;

    @FXML
    private Button rentButton;

    @FXML
    private Button showCarsButton;

    @FXML
    void openShowCarsScene(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("showCars.fxml"));
        Parent root = loader.load();
        ShowCarsController showCarsController = loader.getController();

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("SHOW CARS");
        stage.show();
    }

    @FXML
    void openRentScene(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("rent.fxml"));
        Parent root = loader.load();
        SignUpRentController signUpRentController = loader.getController();

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("RENT");
        stage.show();
    }

    @FXML
    void openBuyScene(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("buy.fxml"));
        Parent root = loader.load();
        SignUpBuyController signUpBuyController = loader.getController();

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("BUY");
        stage.show();
    }

    @FXML
    void openGiveBackScene(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("giveBack.fxml"));
        Parent root = loader.load();
        SignUpGiveBackController signUpGiveBackController = loader.getController();

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("GIVE BACK");
        stage.show();
    }

    @FXML
    void openCurrentStatusScene(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("currentStatus.fxml"));
        Parent root = loader.load();
        CurrentStatusController currentStatusController = loader.getController();

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("CURRENT STATUS");
        stage.show();
    }

    @FXML
    void initialize() {
//      SHOW CAR
        showCarsButton.setOnAction(actionEvent -> {
            showCarsButton.getScene().getWindow().hide();
            try {
                openShowCarsScene(actionEvent);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

//      RENT
        rentButton.setOnAction(actionEvent -> {
            rentButton.getScene().getWindow().hide();
            try {
                openRentScene(actionEvent);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

//      GIVE BACK
        giveBackButton.setOnAction(actionEvent -> {
            giveBackButton.getScene().getWindow().hide();
            try {
                openGiveBackScene(actionEvent);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

//      BUY
        buyButton.setOnAction(actionEvent -> {
            buyButton.getScene().getWindow().hide();
            try {
                openBuyScene(actionEvent);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

//      CURRENT STATUS
        currentStatusButton.setOnAction(actionEvent -> {
            currentStatusButton.getScene().getWindow().hide();
            try {
                openCurrentStatusScene(actionEvent);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
