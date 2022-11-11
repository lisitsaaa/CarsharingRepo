package com.example.testapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class ShowCarsController {

    @FXML
    private Button homeButton7;

    @FXML
    private Button jeepCompassButton;

    @FXML
    private Button kiaRioButton;

    @FXML
    private Button toyotaCamryButton;

    @FXML
    private Button toyotaTacomaButton;

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
    void openJeepCompassScene(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("jeepCompass.fxml"));
        Parent root = loader.load();
        JeepCompassController jeepCompassController = loader.getController();

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("JEEP COMPASS");
        stage.show();
    }

    @FXML
    void openKiaRioScene(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("kiaRio.fxml"));
        Parent root = loader.load();
        KiaRioController kiaRioController = loader.getController();

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("KIA RIO");
        stage.show();
    }

    @FXML
    void openToyotaTacomaScene(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("toyotaTacoma.fxml"));
        Parent root = loader.load();
        ToyotaTacomaController toyotaTacomaController = loader.getController();

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("TOYOTA TACOMA");
        stage.show();
    }

    @FXML
    void openToyotaCamryScene(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("toyotaCamry.fxml"));
        Parent root = loader.load();
        ToyotaCamryController toyotaCamryController = loader.getController();

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("TOYOTA CAMRY");
        stage.show();
    }

    @FXML
    void initialize() {
//      HOME
        homeButton7.setOnAction(actionEvent -> {
            homeButton7.getScene().getWindow().hide();
            try {
                openHomeScene(actionEvent);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

//      JEEP COMPASS
        jeepCompassButton.setOnAction(actionEvent -> {
            jeepCompassButton.getScene().getWindow().hide();
            try {
                openJeepCompassScene(actionEvent);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

//      KIA RIO
        kiaRioButton.setOnAction(actionEvent -> {
            kiaRioButton.getScene().getWindow().hide();
            try {
                openKiaRioScene(actionEvent);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

//      TOYOTA TACOMA
        toyotaTacomaButton.setOnAction(actionEvent -> {
            toyotaTacomaButton.getScene().getWindow().hide();
            try {
                openToyotaTacomaScene(actionEvent);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

//      TOYOTA CAMRY
        toyotaCamryButton.setOnAction(actionEvent -> {
            toyotaCamryButton.getScene().getWindow().hide();
            try {
                openToyotaCamryScene(actionEvent);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
