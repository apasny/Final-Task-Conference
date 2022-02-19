package com.epam.conference.service;

import com.epam.conference.exception.DaoException;

public interface ConferenceService {
    void create(String... params) throws DaoException;
    void delete();
}
