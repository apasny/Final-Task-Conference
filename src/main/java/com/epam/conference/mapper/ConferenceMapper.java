package com.epam.conference.mapper;

import com.epam.conference.entity.Conference;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ConferenceMapper implements Mapper<Conference>{
    @Override
    public Conference map(ResultSet resultSet) throws SQLException {
        return new Conference(
                resultSet.getLong("id"),
                resultSet.getString("topic"),
                resultSet.getDate("start_date"),
                resultSet.getDate("end_date"),
                resultSet.getString("place"),
                resultSet.getBoolean("is_available")
        );
    }
}
