package com.example.testapp;

import java.sql.*;

public class DatabaseHandler {

    public static Connection getDbConnection()
            throws ClassNotFoundException, SQLException {
        String dbHost = "localhost";
        String dbPort = "3306";
        String dbName = "application";
        String dbUser = "root";
        String dbPass = "17023";

        String connectionString = "jdbc:mysql://" + dbHost + ":"
                + dbPort + "/" + dbName + "?" + "autoReconnect=true&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);
        return dbConnection;
    }

//      МЕТОД ДОБАВЛЕНИЯ ДАННЫХ О ПОЛЬЗОВАТЕЛЯХ В БД
    public void signUpUsers(User user) throws SQLException, ClassNotFoundException {
        String insert = "INSERT INTO" + Const.USER_TABLE + "(" +
                Const.CAR_TYPE + "," + Const.CAR_ID + "," + Const.CAR_LEVEL + "," +
                Const.USERS_NAME + "," + Const.USERS_FAMILY_NAME + "," +
                Const.USERS_PASSPORT + "," + Const.DATE_OF_EXPIRY_PASSPORT + "," +
                Const.DRIVER_LICENSE + "," + Const.DATE_OF_EXPIRY_DRIVER_LICENSE + "," +
                Const.DATE_OF_ISSUE + "," + Const.DATE_OF_EXPIRY + "," + Const.CURRENT_STATUS + "," +
                Const.PHONE_NUMBER + ")" + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, user.getCarType());
            prSt.setString(2, user.getCarID());
            prSt.setString(3, user.getCarLevel());
            prSt.setString(4, user.getUserName());
            prSt.setString(5, user.getUserFamilyName());
            prSt.setString(6, user.getPassport());
            prSt.setString(7, user.getDataOfExpiryPassport());
            prSt.setString(8, user.getDriverLicense());
            prSt.setString(9, user.getDataOfExpiryDriverLicense());
            prSt.setString(10, user.getDataOfIssue());
            prSt.setString(11, user.getDataOfExpiry());
            prSt.setString(12, user.getCurrentStatus());
            prSt.setString(13, user.getPhoneNumber());

            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

//      МЕТОД АВТОРИТИЗАЦИИ ДАННЫХ О ПОЛЬЗОВАТЕЛЯХ ИЗ БД
    public ResultSet getUser(User user) {
        ResultSet resSet = null;
        String select = "SELECT * FROM into" + Const.USER_TABLE + " WHERE " +
                Const.CAR_TYPE + " =? AND " + Const.CAR_ID + " =? AND " + Const.CURRENT_STATUS + " =? ";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1, user.getCarType());
            prSt.setString(2, user.getCarID());
            prSt.setString(3, user.getCurrentStatus());

            resSet = prSt.executeQuery();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resSet;
    }


}


