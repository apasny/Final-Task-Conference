package com.epam.conference.connection;

import com.epam.conference.exception.DatabaseConnectorException;

import java.sql.SQLException;
import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

public class ConnectionPool {

    private static ConnectionPool instance;
    private static Queue<ProxyConnection> connectionPool;
    private final Queue<ProxyConnection> connectionInUse = new ArrayDeque<>();
    private static ConnectionFactory connectionFactory;

    private final ReentrantLock connectionLock = new ReentrantLock();
    private static final ReentrantLock connectionPoolLock = new ReentrantLock();

    private static final int INITIAL_POOL_SIZE = 10;

    private ConnectionPool() {
    }

    public static ConnectionPool getInstance() throws DatabaseConnectorException {
        ConnectionPool localInstance = instance;
        connectionPoolLock.lock();
        try {
            if (localInstance == null) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new ConnectionPool();
                    initConnectionPool();
                }
            }
        } finally {
            connectionPoolLock.unlock();
        }
        return localInstance;
    }

    private static void initConnectionPool() throws DatabaseConnectorException {
        connectionFactory = new ConnectionFactory();
        connectionPool = new ArrayDeque<>(INITIAL_POOL_SIZE);
        for (int i = 0; i < INITIAL_POOL_SIZE; i++) {
            connectionPool.add(connectionFactory.create());
        }
    }

    public void returnConnection(ProxyConnection proxyConnection) {
        connectionLock.lock();
        try {
            if (connectionInUse.contains(proxyConnection) && connectionPool.size()<INITIAL_POOL_SIZE) {
                connectionPool.offer(connectionInUse.poll());
            }
        } finally {
            connectionLock.unlock();
        }
    }

    public ProxyConnection getConnection() throws SQLException, DatabaseConnectorException {
        connectionLock.lock();
        ProxyConnection connection;
        try {
            if (connectionPool.isEmpty()) {
                if (connectionInUse.size() < 10) {
                    connectionPool.add(connectionFactory.create());
                } else {
                    throw new RuntimeException("Maximum pool size, no available connections");
                }
            }
            try {
                connection = connectionPool.poll();
            } catch (NullPointerException e) {
                throw new RuntimeException("No available connections");
            }

            if (connection != null && !connection.isValid(10)) {
                connection = connectionPool.poll();
            }

            connectionInUse.add(connection);
            return connection;
        } finally {
            connectionLock.unlock();
        }
    }

    public Queue<ProxyConnection> getConnectionPool(){
        return connectionPool;
    }

    public Queue<ProxyConnection> getConnectionInUse(){
        return connectionInUse;
    }

}
