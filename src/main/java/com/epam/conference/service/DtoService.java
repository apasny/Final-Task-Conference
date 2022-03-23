package com.epam.conference.service;

import com.epam.conference.entity.Dto;
import com.epam.conference.entity.Request;
import com.epam.conference.exception.ServiceException;

import java.util.List;

public interface DtoService {
    List<Dto> allRequests() throws ServiceException;
    List<Dto> userRequests(String userId) throws ServiceException;

    void close() throws ServiceException;

    void apply(Request request) throws ServiceException;
}
