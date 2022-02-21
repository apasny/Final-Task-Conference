package com.epam.conference.service;

import com.epam.conference.entity.Request;
import com.epam.conference.exception.ServiceException;

import java.util.List;

public interface RequestService {

    List<Request> requests() throws ServiceException;

}
