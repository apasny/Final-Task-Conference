package com.epam.conference.connection;


import com.epam.conference.exception.DatabaseConnectorException;

import java.sql.Connection;
import java.util.ResourceBundle;

public class ConnectionFactory {

    private final ResourceBundle resourceBundle = ResourceBundle.getBundle("database");
    private final ConnectionPool connectionPool;

    public ConnectionFactory() throws DatabaseConnectorException {
        connectionPool = ConnectionPool.getInstance();
    }

    public ProxyConnection create() throws DatabaseConnectorException {
        return new ProxyConnection(DatabaseConnector.getConnection(resourceBundle), connectionPool);
    }

}
