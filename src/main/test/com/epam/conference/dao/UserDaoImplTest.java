package com.epam.conference.dao;

import com.epam.conference.connection.ConnectionFactory;
import com.epam.conference.connection.DatabaseConnector;
import com.epam.conference.entity.User;
import com.epam.conference.exception.DaoException;
import com.epam.conference.exception.DatabaseConnectorException;
import com.epam.conference.mapper.UserMapper;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

public class UserDaoImplTest {

//    @Test
//    public void getAll() throws DaoException {
//
//        UserDaoImpl userDao = new UserDaoImpl(ConnectionFactory.create());
//
//        List<User> user = userDao.getAll();
//
//        Assert.assertEquals(user.size(), 3);
//    }

//    @Test
//    public void findUserByLoginAndPassword() throws DaoException {
//        String login = "admin";
//        String password = "admin";
//
//        UserDaoImpl userDao = new UserDaoImpl(ConnectionFactory.create());
//
//        Optional<User> user = userDao.findUserByLoginAndPassword(login, password);
//
//        user.ifPresent(value -> Assert.assertEquals(value.getSurname(), "chan"));
//
//    }
//
//    @Test
//    public void executeQuery() throws DaoException {
//        String query = "SELECT * FROM user WHERE login = ? and password = ?";
//        String login = "admin";
//        String password = "qwerty123";
//
//        UserDaoImpl userDao = new UserDaoImpl(ConnectionFactory.create());
//
//        List<User> user = userDao.executeQuery(query, new UserMapper(), login, password);
//
//        Assert.assertEquals(user.get(0).getName(), "иван");
//
//    }
//
//    @Test(expected = IllegalArgumentException.class)
//    public void executeForSingleResult() throws DaoException {
//        String query = "SELECT * FROM user WHERE login = ?";
//        String login = "admin";
//
//        UserDaoImpl userDao = new UserDaoImpl(ConnectionFactory.create());
//
//        Optional<User> user = userDao.executeForSingleResult(query, new UserMapper(), login);
//
//        user.ifPresent(value -> Assert.assertEquals(value.getLogin(), "admin"));
//    }
}