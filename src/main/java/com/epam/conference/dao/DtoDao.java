package com.epam.conference.dao;

import com.epam.conference.entity.Dto;
import com.epam.conference.entity.Request;
import com.epam.conference.exception.DaoException;

import java.util.List;

public interface DtoDao {

    List<Dto> getAllRequests() throws DaoException;
    List<Dto> getUserRequests(String userId) throws DaoException;

    void close() throws DaoException;

    void apply(Request request) throws DaoException;

}
