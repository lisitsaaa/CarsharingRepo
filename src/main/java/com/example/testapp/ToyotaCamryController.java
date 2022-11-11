package com.example.testapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class ToyotaCamryController {

    @FXML
    private Button backButton8;

    @FXML
    private Button homeButton8;

    @FXML
    private ImageView toyotaCamryImage;

    @FXML
    void openBackScene(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("showCars.fxml"));
        Parent root = loader.load();
        ShowCarsController showCarsController = loader.getController();

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("SHOW CARS");
        stage.show();
    }

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
//      IMAGE
        File file = new File("src/main/java/com/example/testapp/assets/toyotaCamry2.png");
        Image image = new Image(file.toURI().toString());
        toyotaCamryImage.setImage(image);

//      BACK
        backButton8.setOnAction(actionEvent -> {
            backButton8.getScene().getWindow().hide();
            try {
                openBackScene(actionEvent);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

//      HOME
        homeButton8.setOnAction(actionEvent -> {
            homeButton8.getScene().getWindow().hide();
            try {
                openHomeScene(actionEvent);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }


}
