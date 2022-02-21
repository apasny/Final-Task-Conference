package com.epam.conference.mapper;

import com.epam.conference.entity.Request;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RequestMapper implements Mapper<Request> {
    @Override
    public Request map(ResultSet resultSet) throws SQLException {
        return new Request(
                resultSet.getLong("id"),
                resultSet.getString("topic"),
                resultSet.getTimestamp("time"),
                resultSet.getLong("user_id"),
                resultSet.getLong("section_id"),
                resultSet.getString("status")
        );
    }
}
