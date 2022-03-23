package com.epam.conference.dao;

import com.epam.conference.entity.Section;
import com.epam.conference.exception.DaoException;

import java.util.List;

public interface SectionDao {

    List<Section> getAllSectionsByConferenceId(String id) throws DaoException;

    List<Section> getAllNotAppliedSections(String userId,String conferenceId) throws DaoException;

    void createSection(Section section) throws DaoException;

    void close() throws DaoException;
}
