package com.epam.conference.dao;

import com.epam.conference.connection.ProxyConnection;
import com.epam.conference.entity.Conference;
import com.epam.conference.exception.DaoException;
import com.epam.conference.exception.DatabaseConnectorException;
import com.epam.conference.mapper.ConferenceMapper;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ConferenceDaoImpl extends AbstractDao<Conference> implements ConferenceDao {

    public ConferenceDaoImpl(ProxyConnection proxyConnection) {
        super(proxyConnection, new ConferenceMapper());
    }

    @Override
    public void createConference(Conference conference) throws DaoException {
        create(conference);
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

    @Override
    protected Map<String, Object> getFields(Conference item) {
        Map<String, Object> conferenceFields = new LinkedHashMap<>();
        conferenceFields.put(Conference.ID,item.getId());
        conferenceFields.put(Conference.TOPIC,item.getTopic());
        conferenceFields.put(Conference.STARTDATE,item.getStartDate());
        conferenceFields.put(Conference.ENDDATE,item.getEndDate());
        conferenceFields.put(Conference.ISAVAILABLE,item.isAvailable());
        conferenceFields.put(Conference.PLACE,item.getPlace());
        return conferenceFields;
    }
}
