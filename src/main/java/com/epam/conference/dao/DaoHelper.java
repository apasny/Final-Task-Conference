package com.epam.conference.dao;

import com.epam.conference.connection.ConnectionPool;
import com.epam.conference.connection.ProxyConnection;

import java.sql.SQLException;

public class DaoHelper implements AutoCloseable {

    private final ProxyConnection connection;

    public DaoHelper(ConnectionPool connectionPool) throws SQLException {
        this.connection = connectionPool.getConnection();
    }

    @Override
    public void close()  {
        connection.close();
    }

    public UserDao createUserDao(){
        return new UserDaoImpl(connection);
    }

    public ConferenceDao createConferenceDao(){
        return new ConferenceDaoImpl(connection);
    }
}
