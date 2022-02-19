package com.epam.conference.service;

import com.epam.conference.dao.ConferenceDao;
import com.epam.conference.exception.DaoException;

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
}
