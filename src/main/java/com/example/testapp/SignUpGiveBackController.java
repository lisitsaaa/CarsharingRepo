package com.example.testapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class SignUpGiveBackController {

    @FXML
    private TextField IDField;

    @FXML
    private Button autoSingUpGiveBackButton;

    @FXML
    private TextField carField;

    @FXML
    private TextField carLevelField;

    @FXML
    private TextField dataOfExpiryField;

    @FXML
    private TextField dataOfIssueField;

    @FXML
    private TextField dataPField;

    @FXML
    private TextField dateDLField;

    @FXML
    private TextField driverLicenseField;

    @FXML
    private TextField familyNameField;

    @FXML
    private Button homeButton3;

    @FXML
    private TextField nameField;

    @FXML
    private TextField passportField;

    @FXML
    private TextField phoneNumberField;

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
    void initialize() {
//      HOME BUTTON
        homeButton3.setOnAction(actionEvent -> {
            homeButton3.getScene().getWindow().hide();
            try {
                openHomeScene(actionEvent);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

//      GIVE BACK BUTTON
        autoSingUpGiveBackButton.setOnAction(event -> {
           SignUpGiveBackUser();
});
    }

//      ДОБАВЛЕНИЕ ДАННЫХ В БД
    private void SignUpGiveBackUser() {
        DatabaseHandler dbHandler = new DatabaseHandler();

        String carType = carField.getText();
        String carID = IDField.getText();
        String carLevel = carLevelField.getText();
        String userName = nameField.getText();
        String userFamilyName = familyNameField.getText();
        String passport = passportField.getText();
        String dataOfExpiryPassport = dataPField.getText();
        String driverLicense = driverLicenseField.getText();
        String dataOfExpiryDriverLicense = dateDLField.getText();
        String dataOfIssue = dataOfIssueField.getText();
        String dataOfExpiry = dataOfExpiryField.getText();
        String currentStatus = "GIVE BACK";
        String phoneNumber = phoneNumberField.getText();

        User user = new User(carType, carID, carLevel, userName,
                userFamilyName, passport, dataOfExpiryPassport, driverLicense,
                dataOfExpiryDriverLicense, dataOfIssue, dataOfExpiry, currentStatus, phoneNumber);
        try {
            dbHandler.signUpUsers(user);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}