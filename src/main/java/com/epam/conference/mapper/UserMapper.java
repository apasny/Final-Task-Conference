package com.epam.conference.mapper;

import com.epam.conference.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements Mapper<User> {
    @Override
    public User map(ResultSet resultSet) throws SQLException {
        return new User(
                resultSet.getLong("id"),
                resultSet.getString("name"),
                resultSet.getString("surname"),
                resultSet.getString("login"),
                resultSet.getBoolean("is_admin")
        );
    }
}
