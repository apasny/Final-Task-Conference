package com.epam.conference.mapper;

import com.epam.conference.entity.*;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DtoMapper implements Mapper<Dto> {
    @Override
    public Dto map(ResultSet resultSet) throws SQLException {
        Request request = new RequestMapper().map(resultSet);
        User user = new UserMapper().map(resultSet);
        Section section = new SectionMapper().map(resultSet);
        Conference conference = new ConferenceMapper().map(resultSet);
        return new Dto(request,user,section,conference);
    }
}
