package com.epam.conference.connection;

import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class DatabaseConnectorTest {

    @Test
    public void getConnection() throws SQLException {

        ResourceBundle resourceBundle = ResourceBundle.getBundle("database");
        String url = resourceBundle.getString("db.url");
        String user = resourceBundle.getString("db.user");
        String password = resourceBundle.getString("db.password");

        Connection connection = DriverManager.getConnection(url, user, password);

        Assert.assertNotNull(connection);

    }
}