package com.epam.conference.mapper;

import com.epam.conference.entity.Section;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SectionMapper implements Mapper<Section> {
    @Override
    public Section map(ResultSet resultSet) throws SQLException {
        return new Section(
                resultSet.getLong("id"),
                resultSet.getString("topic"),
                resultSet.getDate("start_date"),
                resultSet.getDate("end_date"),
                resultSet.getTime("start_time"),
                resultSet.getTime("end_time"),
                resultSet.getInt("max_attendees"),
                resultSet.getBoolean("is_available")
        );
    }
}
