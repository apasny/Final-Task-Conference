package com.epam.conference.dao;

import com.epam.conference.entity.Request;
import com.epam.conference.exception.DaoException;

import java.util.List;

public interface RequestDao {

    List<Request> getAllRequests() throws DaoException;

}
