package com.epam.conference.dao;

import com.epam.conference.connection.DatabaseConnector;
import com.epam.conference.entity.User;
import com.epam.conference.mapper.UserMapper;
import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

public class UserDaoImplTest {

    @Test
    public void getAll() {

    }

    @Test
    public void findUserByLoginAndPassword() throws SQLException {

        String login = "admin";
        String password = "admin";

        UserDaoImpl userDao = new UserDaoImpl(DatabaseConnector.getConnection());

        Optional<User> user = userDao.findUserByLoginAndPassword(login, password);

        if (user.isPresent()) {
            Assert.assertEquals(user.get().getSurname(), "chan");
        } else {
            throw new NullPointerException("No user");
        }
    }

    @Test
    public void executeQuery() throws SQLException {

        String query = "SELECT * FROM user WHERE login = ? and password = ?";

        String login = "admin";
        String password = "qwerty123";

        UserDaoImpl userDao = new UserDaoImpl(DatabaseConnector.getConnection());

        List<User> user = userDao.executeQuery(query, new UserMapper(), login, password);

        Assert.assertEquals(user.get(0).getName(), "иван");

    }

    @Test(expected = IllegalArgumentException.class)
    public void executeForSingleResult() throws SQLException {

        String query = "SELECT * FROM user WHERE login = ?";

        String login = "admin";

        UserDaoImpl userDao = new UserDaoImpl(DatabaseConnector.getConnection());

        Optional<User> user = userDao.executeForSingleResult(query, new UserMapper(), login);

        if (user.isPresent()) {
            Assert.assertEquals(user.get().getLogin(), "admin");
        } else {
            throw new NullPointerException("No user");
        }
    }
}