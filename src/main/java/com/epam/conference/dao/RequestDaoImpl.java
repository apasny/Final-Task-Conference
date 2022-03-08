package com.epam.conference.dao;

import com.epam.conference.connection.ProxyConnection;
import com.epam.conference.entity.Conference;
import com.epam.conference.entity.Request;
import com.epam.conference.exception.DaoException;
import com.epam.conference.exception.DatabaseConnectorException;
import com.epam.conference.mapper.RequestMapper;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
    public List<Request> getUserRequests(String userId) throws DaoException {
        return executeForColumnResult(Request.USER_ID, userId);
    }

    @Override
    protected String getTableName() {
        return Request.TABLE;
    }

    @Override
    protected Map<String, Object> getFields(Request item) {
        Map<String, Object> requestFields = new LinkedHashMap<>();
        requestFields.put(Request.ID,item.getId());
        requestFields.put(Request.TIME,item.getTime());
        requestFields.put(Request.USER_ID,item.getUserId());
        requestFields.put(Request.SECTION_ID,item.getSectionId());
        requestFields.put(Request.STATUS,item.getStatus());
        return requestFields;
    }
}
