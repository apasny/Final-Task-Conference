package com.epam.conference.dao;

import com.epam.conference.connection.ProxyConnection;
import com.epam.conference.entity.Conference;
import com.epam.conference.exception.DaoException;
import com.epam.conference.exception.DatabaseConnectorException;
import com.epam.conference.mapper.ConferenceMapper;

import java.util.List;

public class ConferenceDaoImpl extends AbstractDao<Conference> implements ConferenceDao {

    public ConferenceDaoImpl(ProxyConnection proxyConnection) {
        super(proxyConnection, new ConferenceMapper());
    }

    @Override
    public void createConference() throws DaoException {
        create();
    }

    @Override
    public List<Conference> getAllConferences() throws DaoException {
        try {
            return getAll();
        } catch (DatabaseConnectorException e) {
            throw new DaoException("Unable to get conferences from database", e);
        }
    }

    @Override
    protected String getTableName() {
        return Conference.TABLE;
    }
}
