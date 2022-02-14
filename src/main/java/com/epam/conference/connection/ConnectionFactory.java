package com.epam.conference.connection;


import com.epam.conference.exception.DatabaseConnectorException;

import java.sql.Connection;
import java.util.ResourceBundle;

public class ConnectionFactory {

    private static final ResourceBundle resourceBundle = ResourceBundle.getBundle("database");
    private static Connection connection;
    private static ConnectionPool connectionPool;

    static {
        try {
            connection = DatabaseConnector.getConnection(resourceBundle);
            connectionPool = ConnectionPool.getInstance();
        } catch (DatabaseConnectorException e) {
            e.printStackTrace();
        }
    }

    public ConnectionFactory() {
    }

    public static ProxyConnection create() {
        return new ProxyConnection(connection, connectionPool);
    }

}
