package com.epam.conference.service;

import com.epam.conference.connection.DatabaseConnector;
import com.epam.conference.dao.UserDao;
import com.epam.conference.dao.UserDaoImpl;
import com.epam.conference.entity.User;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

public class UserServiceImplTest {

    @Test
    public void login() throws SQLException {

        String login = "admin";
        String password = "admin";

        Connection connection = DatabaseConnector.getConnection();

        UserDao userDao = new UserDaoImpl(connection);

        UserServiceImpl userService = new UserServiceImpl(userDao);

        Optional<User> user = userService.login(login, password);

        if (user.isPresent()) {
            Assert.assertEquals(user.get().getLogin(), login);
        } else {
            throw new NullPointerException("No user");
        }
    }
}