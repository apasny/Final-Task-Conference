package com.epam.conference.dao;

import com.epam.conference.connection.ProxyConnection;
import com.epam.conference.entity.User;
import com.epam.conference.exception.DaoException;
import com.epam.conference.mapper.UserMapper;

import java.sql.Connection;
import java.util.Optional;

public class UserDaoImpl extends AbstractDao<User> implements UserDao {

    private static final String FIND_BY_LOGIN_AND_PASSWORD = "SELECT * FROM user WHERE login = ? AND password = ?";

    public UserDaoImpl(ProxyConnection proxyConnection) {
        super(proxyConnection, new UserMapper());
    }

    @Override
    public Optional<User> findUserByLoginAndPassword(String login, String password) throws DaoException {

        return executeForSingleResult(
                FIND_BY_LOGIN_AND_PASSWORD,
                login,
                password
        );
    }

    @Override
    protected String getTableName() {
        return User.TABLE;
    }

    @Override
    public void create() {

    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }
}
