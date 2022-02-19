package com.epam.conference.service;

import com.epam.conference.connection.ConnectionFactory;
import com.epam.conference.connection.ProxyConnection;
import com.epam.conference.dao.UserDao;
import com.epam.conference.dao.UserDaoImpl;
import com.epam.conference.entity.User;
import com.epam.conference.exception.ServiceException;
import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

public class UserServiceImplTest {

    @Test
    public void login() throws ServiceException {

        String login = "admin";
        String password = "admin";

        ConnectionFactory connectionFactory = new ConnectionFactory();

        ProxyConnection connection = connectionFactory.create();

        UserDao userDao = new UserDaoImpl(connection);

        UserServiceImpl userService = new UserServiceImpl(userDao);

        Optional<User> user = userService.login(login, password);

        user.ifPresent(value -> Assert.assertEquals(value.getLogin(), "admin"));
    }
}