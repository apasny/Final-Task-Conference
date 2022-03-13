package com.epam.conference.dao;

import com.epam.conference.connection.ConnectionPool;
import com.epam.conference.connection.ProxyConnection;
import com.epam.conference.entity.Section;
import com.epam.conference.exception.DaoException;
import com.epam.conference.exception.DatabaseConnectorException;

import java.sql.SQLException;

public class DaoHelper implements AutoCloseable {

    private final ProxyConnection connection;

    public DaoHelper(ConnectionPool connectionPool) throws SQLException, DaoException {
        try {
            this.connection = connectionPool.getConnection();
        } catch (DatabaseConnectorException e) {
            throw new DaoException("Cannot get connection",e);
        }
    }

    @Override
    public void close() throws SQLException {
        connection.close();
    }

    public UserDao createUserDao(){
        return new UserDaoImpl(connection);
    }

    public ConferenceDao createConferenceDao(){
        return new ConferenceDaoImpl(connection);
    }

    public RequestDao createRequestDao(){
        return new RequestDaoImpl(connection);
    }

    public SectionDao createSectionDao(){
        return new SectionDaoImpl(connection);
    }
}
