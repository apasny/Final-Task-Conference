package com.epam.conference.dao;

import com.epam.conference.entity.Request;
import com.epam.conference.exception.DaoException;

import java.util.List;

public interface RequestDao {

    List<Request> getAllRequests() throws DaoException;
    List<Request> getUserRequests(String userId) throws DaoException;

    void close() throws DaoException;

    void apply(Request request) throws DaoException;
}
