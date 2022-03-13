package com.epam.conference.service;

import com.epam.conference.entity.User;
import com.epam.conference.exception.ServiceException;

import java.util.Optional;

public interface UserService {

    Optional<User> login(String login, String password) throws ServiceException;

    void close() throws ServiceException;
}
