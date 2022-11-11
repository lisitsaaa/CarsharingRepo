package com.example.testapp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CurrentStatusController {

    @FXML
    private Button addButton;

    @FXML
    private TextField carTypeField;

    @FXML
    private TableColumn<Cars, String> cs;

    @FXML
    private TextField currentStatusField;

    @FXML
    private Button deleteButton;

    @FXML
    private Button updateButton;

    @FXML
    private Button homeButton10;

    @FXML
    private TableColumn<Cars, String> ip;

    @FXML
    private TextField ipField;

    @FXML
    private TableColumn<Cars, String> level;

    @FXML
    private TextField levelField;

    @FXML
    private TableView<Cars> table;

    @FXML
    private TableColumn<Cars, String> type;

    ObservableList<Cars> carList = FXCollections.observableArrayList();
    String query = null;
    Connection connection = null;
    ResultSet resultSet = null;
    PreparedStatement preparedStatement = null;
    Cars car;

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
    public void initialize() {

//      HOME BUTTON
        homeButton10.setOnAction(actionEvent -> {
            homeButton10.getScene().getWindow().hide();
            try {
                openHomeScene(actionEvent);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

//      ADD BUTTON
        addButton.setOnAction(ActionEvent -> {
            SignUpCars();
        });

//      DELETE BUTTON
        deleteButton.setOnAction(ActionEvent -> {
            try {
                deleteBD();
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        });

//      UPDATE BUTTON
        updateButton.setOnAction(ActionEvent -> {
            try {
                loadDate();
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        });
    }

//      ДОБАВЛЕНИЕ ДАННЫХ В БД
    private void SignUpCars() {
        DatabaseHandlerForCars dbHandlerForCars = new DatabaseHandlerForCars();

        String carType = carTypeField.getText();
        String carID = ipField.getText();
        String carLevel = levelField.getText();
        String currentStatus = currentStatusField.getText();

        Cars car = new Cars(carType, carID, carLevel, currentStatus);
        try {
            dbHandlerForCars.signUpCars(car);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

//      ОБНОВЛЕНИЕ СТРАНИЦЫ
    public void refreshTable() {
        carList.clear();
        try {
            query = "SELECT * FROM intocars";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
                carList.add(new Cars(
                        resultSet.getString("carType"), resultSet.getString("carIP"),
                        resultSet.getString("carLevel"), resultSet.getString("currentStatus")));
            table.setItems(carList);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//      ВЫВОД ТАБЛИЦЫ
    private void loadDate() throws SQLException, ClassNotFoundException {
        connection = DatabaseHandler.getDbConnection();
        refreshTable();

        type.setCellValueFactory(new PropertyValueFactory<Cars, String>("carType"));
        ip.setCellValueFactory(new PropertyValueFactory<Cars, String>("carIP"));
        level.setCellValueFactory(new PropertyValueFactory<Cars, String>("carLevel"));
        cs.setCellValueFactory(new PropertyValueFactory<Cars, String>("currentStatus"));
    }

//      УДАЛЕНИЕ АВТОМОБИЛЯ ИЗ БД
    private void deleteBD() throws SQLException, ClassNotFoundException {
        connection = DatabaseHandler.getDbConnection();
        query = "DELETE FROM intocars WHERE carIP = ?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, ipField.getText());
            preparedStatement.execute();
            refreshTable();

        } catch (Exception e){
            e.printStackTrace();
        }

    }

}
