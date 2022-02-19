package com.epam.conference.dao;

import com.epam.conference.exception.DaoException;

public interface ConferenceDao {
    void createConference() throws DaoException;
}
