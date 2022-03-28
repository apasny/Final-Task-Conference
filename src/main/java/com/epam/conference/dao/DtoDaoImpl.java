package com.epam.conference.dao;

import com.epam.conference.connection.ProxyConnection;
import com.epam.conference.entity.Dto;
import com.epam.conference.entity.Request;
import com.epam.conference.exception.DaoException;
import com.epam.conference.mapper.DtoMapper;

import java.util.List;
import java.util.Map;

public class DtoDaoImpl extends AbstractDao<Dto> implements DtoDao{

    public DtoDaoImpl(ProxyConnection proxyConnection) {
        super(proxyConnection, new DtoMapper());
    }

    @Override
    protected String getTableName() {
        return Dto.TABLE;
    }

    @Override
    protected Map<String, Object> getFields(Dto item) {
        return null;
    }

    @Override
    public List<Dto> getAllRequests() throws DaoException {
        return executeQuery("select * from request join user on user.id=request.user_id join section on section.id = request.section_id join conference on conference.id = section.conference_id");
    }

    @Override
    public List<Dto> getUserRequests(String userId) throws DaoException {
        return executeQuery("select * from request join user on user.id=request.user_id join section on section.id = request.section_id join conference on conference.id = section.conference_id where user.id="+userId);

    }

    @Override
    public void close() throws DaoException {
        closeConnection();
    }

    @Override
    public void apply(Request request) throws DaoException {

    }
}
