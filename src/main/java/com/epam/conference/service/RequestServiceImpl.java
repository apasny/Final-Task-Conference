package com.epam.conference.service;

import com.epam.conference.dao.RequestDao;
import com.epam.conference.entity.Request;
import com.epam.conference.exception.DaoException;
import com.epam.conference.exception.ServiceException;

import java.util.List;

public class RequestServiceImpl implements RequestService {

    private final RequestDao dao;

    public RequestServiceImpl(RequestDao dao) {
        this.dao = dao;
    }

    @Override
    public List<Request> allRequests() throws ServiceException {
        List<Request> requests;
        try {
            requests = dao.getAllRequests();
        } catch (DaoException e) {
            throw new ServiceException("Cannot get requests" + e.getMessage(),e);
        }

        return requests;
    }

    @Override
    public List<Request> userRequests(String userId) throws ServiceException {
        List<Request> requests;
        try {
            requests = dao.getUserRequests(userId);
        } catch (DaoException e) {
            throw new ServiceException("Cannot get requests" + e.getMessage(),e);
        }

        return requests;
    }
}
