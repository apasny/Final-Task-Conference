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
    public void create(String... params) throws DaoException {
        dao.createConference();
    }

    @Override
    public void delete() {

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
