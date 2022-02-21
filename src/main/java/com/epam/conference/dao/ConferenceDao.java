package com.epam.conference.dao;

import com.epam.conference.entity.Conference;
import com.epam.conference.exception.DaoException;

import java.util.List;

public interface ConferenceDao {
    void createConference() throws DaoException;

    List<Conference> getAllConferences() throws DaoException;
}