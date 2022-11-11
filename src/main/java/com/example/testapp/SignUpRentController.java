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
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class SignUpRentController {

    @FXML
    private TextField phoneNumberField;

    @FXML
    private TextField IDField;

    @FXML
    private Button autoSingInRentButton;

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
    private Button homeButton6;

    @FXML
    private TextField nameField;

    @FXML
    private TextField passportField;


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
        homeButton6.setOnAction(actionEvent -> {
            homeButton6.getScene().getWindow().hide();
            try {
                openHomeScene(actionEvent);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

//      RENT BUTTON
        autoSingInRentButton.setOnAction(event -> {
            SignUpRentUser();
        });
    }

    private void SignUpRentUser() {
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
        String currentStatus = "RENT";
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
