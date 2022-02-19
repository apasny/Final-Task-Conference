package com.epam.conference.dao;

import com.epam.conference.entity.Conference;
import com.epam.conference.exception.DaoException;
import com.epam.conference.mapper.ConferenceMapper;

import java.sql.Connection;

public class ConferenceDaoImpl extends AbstractDao<Conference> implements ConferenceDao {

    public ConferenceDaoImpl(Connection connection) {
        super(connection, new ConferenceMapper());
    }

    @Override
    public void createConference() throws DaoException {
        create();
    }

    @Override
    protected String getTableName() {
        return Conference.TABLE;
    }
}
