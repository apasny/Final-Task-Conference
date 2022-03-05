package com.epam.conference.service;

import com.epam.conference.entity.Conference;
import com.epam.conference.exception.DaoException;
import com.epam.conference.exception.ServiceException;

import java.util.List;

public interface ConferenceService {
    void create(Conference conference) throws DaoException;
    void delete(Long id) throws ServiceException;
    List<Conference> conferences() throws ServiceException;
}
