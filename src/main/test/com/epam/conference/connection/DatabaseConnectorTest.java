package com.epam.conference.connection;

import com.epam.conference.command.CommandFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class DatabaseConnectorTest {

    private static final Logger LOGGER = LogManager.getLogger(CommandFactory.class);

    @Test
    public void getConnection() {

        ResourceBundle resourceBundle = ResourceBundle.getBundle("database");
        String url = resourceBundle.getString("db.url");
        String user = resourceBundle.getString("db.user");
        String password = resourceBundle.getString("db.password");

        Connection connection;

        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            LOGGER.warn("SQLException message:" + e.getMessage());
            LOGGER.warn("SQLException SQL state:" + e.getSQLState());
            LOGGER.warn("SQLException SQL error code:" + e.getErrorCode());
            throw new NullPointerException();
        }

        Assert.assertNotNull(connection);

    }
}