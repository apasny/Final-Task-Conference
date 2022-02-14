package com.epam.conference.connection;

import com.epam.conference.exception.DatabaseConnectorException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DatabaseConnector {

    public static Connection getConnection(ResourceBundle resourceBundle) throws DatabaseConnectorException {

        String url = resourceBundle.getString("db.url");
        String user = resourceBundle.getString("db.user");
        String password = resourceBundle.getString("db.password");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new DatabaseConnectorException("Cannot create database connector driver " +
                    e.getMessage(), e);
        }

        Connection connection;
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new DatabaseConnectorException("Database connection failure " +
                    e.getSQLState() +
                    e.getErrorCode(), e);
        }

        return connection;
    }
}
