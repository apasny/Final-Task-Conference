package com.epam.conference.service;

import com.epam.conference.dao.ConferenceDao;
import com.epam.conference.entity.Conference;
import com.epam.conference.entity.Request;
import com.epam.conference.exception.DaoException;
import com.epam.conference.exception.ServiceException;

import java.util.List;

public class ConferenceServiceImpl implements ConferenceService{

    private final ConferenceDao dao;

    public ConferenceServiceImpl(ConferenceDao dao) {
        this.dao = dao;
    }

    @Override
    public void create(Conference conference) throws DaoException {
        dao.createConference(conference);
    }

    @Override
    public void delete(Long id) throws ServiceException {
        try {
            dao.deleteConference(id);
        } catch (DaoException e) {
            throw new ServiceException("Unable to delete conference", e);
        }
    }

    @Override
    public List<Conference> conferences() throws ServiceException {
        List<Conference> conferences;
        try {
            conferences = dao.getAllConferences();
        } catch (DaoException e) {
            throw new ServiceException("Cannot get requests" + e.getMessage(),e);
        }

        return conferences;
    }
}
