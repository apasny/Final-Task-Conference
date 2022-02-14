package com.epam.conference.connection;

import com.epam.conference.exception.DatabaseConnectorException;
import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ConnectionPoolTest {

    @Test
    public void getInstance() throws DatabaseConnectorException, SQLException {

        List<ConnectionPool> connectionPoolList = new ArrayList<>();

        for (int i = 1; i < 4; i++) {
            connectionPoolList.add(ConnectionPool.getInstance());
        }

        ConnectionPool.getInstance().getConnection();

        Assert.assertEquals(connectionPoolList.get(0),ConnectionPool.getInstance());
        Assert.assertEquals(connectionPoolList.get(1),ConnectionPool.getInstance());
        Assert.assertEquals(connectionPoolList.get(2),ConnectionPool.getInstance());

        Assert.assertEquals(connectionPoolList.get(0).getConnectionPool().size(),9);
        Assert.assertEquals(connectionPoolList.get(1).getConnectionPool().size(),9);
        Assert.assertEquals(connectionPoolList.get(2).getConnectionPool().size(),9);

        Assert.assertEquals(ConnectionPool.getInstance().getConnectionInUse().size(),1);

    }
}