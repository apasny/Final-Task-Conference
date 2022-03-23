package com.epam.conference.service;

import com.epam.conference.dao.DtoDao;
import com.epam.conference.entity.Dto;
import com.epam.conference.entity.Request;
import com.epam.conference.exception.DaoException;
import com.epam.conference.exception.ServiceException;

import java.util.List;

public class DtoServiceImpl implements DtoService {

    private final DtoDao dao;

    public DtoServiceImpl(DtoDao dao) {
        this.dao = dao;
    }

    @Override
    public List<Dto> allRequests() throws ServiceException {
        List<Dto> requests;
        try {
            requests = dao.getAllRequests();
        } catch (DaoException e) {
            throw new ServiceException("Cannot get requests" + e.getMessage(),e);
        }

        return requests;
    }

    @Override
    public List<Dto> userRequests(String userId) throws ServiceException {
        List<Dto> requests;
        try {
            requests = dao.getUserRequests(userId);
        } catch (DaoException e) {
            throw new ServiceException("Cannot get requests" + e.getMessage(),e);
        }

        return requests;
    }

    @Override
    public void close() throws ServiceException {
        try {
            dao.close();
        } catch (DaoException e) {
            throw new ServiceException("Unable to close connection", e);
        }
    }

    @Override
    public void apply(Request request) throws ServiceException {

    }
}
