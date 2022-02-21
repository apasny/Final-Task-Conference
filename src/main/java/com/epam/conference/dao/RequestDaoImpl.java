package com.epam.conference.dao;

import com.epam.conference.connection.ProxyConnection;
import com.epam.conference.entity.Request;
import com.epam.conference.exception.DaoException;
import com.epam.conference.exception.DatabaseConnectorException;
import com.epam.conference.mapper.RequestMapper;

import java.util.List;

public class RequestDaoImpl extends AbstractDao<Request> implements RequestDao {

    public RequestDaoImpl(ProxyConnection proxyConnection) {
        super(proxyConnection, new RequestMapper());
    }

    @Override
    public List<Request> getAllRequests() throws DaoException {
        try {
            return getAll();
        } catch (DatabaseConnectorException e) {
            throw new DaoException("Unable to get requests from database", e);
        }
    }

    @Override
    protected String getTableName() {
        return Request.TABLE;
    }
}
