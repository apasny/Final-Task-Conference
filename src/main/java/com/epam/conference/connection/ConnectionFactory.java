package com.epam.conference.connection;


import com.epam.conference.exception.DatabaseConnectorException;

import java.sql.Connection;
import java.util.ResourceBundle;

public class ConnectionFactory {

    private final ResourceBundle resourceBundle = ResourceBundle.getBundle("database");
    private Connection connection;
    private ConnectionPool connectionPool;

    {
        try {
            connection = DatabaseConnector.getConnection(resourceBundle);
            connectionPool = ConnectionPool.getInstance();
        } catch (DatabaseConnectorException e) {
            e.printStackTrace();
        }
    }

    public ConnectionFactory() {
    }

    public ProxyConnection create() {
        return new ProxyConnection(connection, connectionPool);
    }

}
