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

public class ToyotaTacomaController {

    @FXML
    private Button backButton9;

    @FXML
    private Button homeButton9;

    @FXML
    private ImageView toyotaTacomaImage;

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
        File file = new File("src/main/java/com/example/testapp/assets/toyotaTacoma.png");
        Image image = new Image(file.toURI().toString());
        toyotaTacomaImage.setImage(image);

//      BACK
        backButton9.setOnAction(actionEvent -> {
            backButton9.getScene().getWindow().hide();
            try {
                openBackScene(actionEvent);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

//      HOME
        homeButton9.setOnAction(actionEvent -> {
            homeButton9.getScene().getWindow().hide();
            try {
                openHomeScene(actionEvent);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }


}
