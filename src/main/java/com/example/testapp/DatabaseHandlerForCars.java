package com.example.testapp;


import java.sql.*;

public class DatabaseHandlerForCars extends Configs {
    Connection dbConnection;

    public Connection getDbConnection()
            throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":"
                + dbPort + "/" + dbName + "?" + "autoReconnect=true&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        Class.forName("com.mysql.cj.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);
        return dbConnection;
    }

    //      МЕТОД ДОБАВЛЕНИЯ ДАННЫХ О МАШИНАХ В БД
    public void signUpCars(Cars car) throws SQLException, ClassNotFoundException {
        String insert = "INSERT INTO" + ConstCars.USER_TABLE + "(" + ConstCars.CAR_TYPE + "," +
                ConstCars.IP + "," + ConstCars.CAR_LEVEL + "," + ConstCars.CURRENT_STATUS + ")" +
                "VALUES(?,?,?,?)";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, car.getCarType());
            prSt.setString(2, car.getCarIP());
            prSt.setString(3, car.getCarLevel());
            prSt.setString(4, car.getCurrentStatus());

            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
