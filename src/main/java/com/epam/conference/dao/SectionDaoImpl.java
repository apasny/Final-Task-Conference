package com.epam.conference.dao;

import com.epam.conference.connection.ProxyConnection;
import com.epam.conference.entity.Section;
import com.epam.conference.exception.DaoException;
import com.epam.conference.mapper.SectionMapper;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SectionDaoImpl extends AbstractDao<Section> implements SectionDao {

    public SectionDaoImpl(ProxyConnection proxyConnection) {
        super(proxyConnection, new SectionMapper());
    }

    @Override
    public List<Section> getAllSectionsByConferenceId(String id) throws DaoException {
        return executeForColumnResult("conference_id",id);
    }

    @Override
    public void createSection(Section section) throws DaoException {
        create(section);
    }

    @Override
    public void close() throws DaoException {
        closeConnection();
    }

    @Override
    protected String getTableName() {
        return Section.TABLE;
    }

    @Override
    protected Map<String, Object> getFields(Section item) {
        Map<String, Object> sectionFields = new LinkedHashMap<>();
        sectionFields.put(Section.ID,item.getId());
        sectionFields.put(Section.TOPIC,item.getTopic());
        sectionFields.put(Section.STARTTIME,item.getStartTime());
        sectionFields.put(Section.ENDTIME,item.getEndTime());
        sectionFields.put(Section.MAXATTENDEES,item.getMaxAttendees());
        sectionFields.put(Section.ISAVAILABLE,item.getIsAvailable());
        sectionFields.put(Section.ISDELETED,item.getIsDeleted());
        sectionFields.put(Section.CONFERENCEID,item.getConferenceId());
        return sectionFields;
    }
}
