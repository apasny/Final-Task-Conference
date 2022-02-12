package com.epam.conference.service;

import com.epam.conference.dao.UserDao;
import com.epam.conference.entity.User;
import com.epam.conference.exception.DaoException;
import com.epam.conference.exception.ServiceException;

import java.util.Optional;

public class UserServiceImpl implements UserService {

    private final UserDao dao;

    public UserServiceImpl(UserDao userDao) {
        this.dao = userDao;
    }

    @Override
    public Optional<User> login(String login, String password) throws ServiceException {

        Optional<User> user;
        try {
            user = dao.findUserByLoginAndPassword(login,password);
        } catch (DaoException e) {
            throw new NullPointerException("findUserByLoginAndPassword error");
        }

        return user;
    }
}
