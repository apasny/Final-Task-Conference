package com.epam.conference.dao;

import com.epam.conference.connection.ProxyConnection;
import com.epam.conference.entity.Conference;
import com.epam.conference.entity.Request;
import com.epam.conference.exception.DaoException;
import com.epam.conference.exception.DatabaseConnectorException;
import com.epam.conference.mapper.RequestMapper;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class RequestDaoImpl extends AbstractDao<Request> implements RequestDao {

    public RequestDaoImpl(ProxyConnection proxyConnection) {
        super(proxyConnection, new RequestMapper());
    }

    @Override
    public List<Request> getAllRequests() throws DaoException {
            String table = getTableName();
            return executeQuery("select * from " + table);
    }

    @Override
    public List<Request> getUserRequests(String userId) throws DaoException {
        return executeForColumnResult(Request.USER_ID, userId);
    }

    @Override
    public void close() throws DaoException {
        closeConnection();
    }

    @Override
    public void apply(Request request) throws DaoException {
        create(request);
    }

    @Override
    protected String getTableName() {
        return Request.TABLE;
    }

    @Override
    protected Map<String, Object> getFields(Request item) {
        Map<String, Object> requestFields = new LinkedHashMap<>();
        requestFields.put(Request.ID,item.getId());
        requestFields.put(Request.USER_ID,item.getUserId());
        requestFields.put(Request.SECTION_ID,item.getSectionId());
        requestFields.put(Request.STATUS,item.getStatus());
        return requestFields;
    }
}
