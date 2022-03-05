package com.epam.conference.dao;

import com.epam.conference.connection.ProxyConnection;
import com.epam.conference.entity.User;
import com.epam.conference.exception.DaoException;
import com.epam.conference.mapper.UserMapper;

import java.util.LinkedHashMap;
import java.util.Map;
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
    protected Map<String, Object> getFields(User item) {
        Map<String, Object> userFields = new LinkedHashMap<>();
        userFields.put(User.ID,item.getId());
        userFields.put(User.NAME,item.getName());
        userFields.put(User.SURNAME,item.getSurname());
        userFields.put(User.LOGIN,item.getLogin());
        userFields.put(User.ISADMIN,item.getIsAdmin());
        return userFields;
    }
}
