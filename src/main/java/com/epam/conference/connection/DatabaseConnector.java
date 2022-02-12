package com.epam.conference.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DatabaseConnector {

    public static Connection getConnection() {

//        ResourceBundle resourceBundle = ResourceBundle.getBundle("database");
//        String url = resourceBundle.getString("db.url");
//        String user = resourceBundle.getString("db.user");
//        String password = resourceBundle.getString("db.password");
        String url = "jdbc:mysql://localhost:3306/conference";
        String user = "root";
        String password = "lolik123";

        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new NullPointerException("connection error");
        }
    }

}
