package com.epam.conference.dao;

import com.epam.conference.connection.ConnectionPool;
import com.epam.conference.exception.DaoException;
import com.epam.conference.exception.DatabaseConnectorException;

import java.sql.SQLException;

public class DaoHelperFactory {

    public DaoHelper create() throws DatabaseConnectorException, SQLException, DaoException {
        return new DaoHelper(ConnectionPool.getInstance());
    }
}
