package com.epam.conference.service;

import com.epam.conference.dao.SectionDao;
import com.epam.conference.entity.Section;
import com.epam.conference.exception.DaoException;
import com.epam.conference.exception.ServiceException;

import java.util.List;

public class SectionServiceImpl implements SectionService {

    private final SectionDao dao;

    public SectionServiceImpl(SectionDao dao) {
        this.dao = dao;
    }

    @Override
    public void create(Section section) throws ServiceException {
        try {
            dao.createSection(section);
        } catch (DaoException e) {
            throw new ServiceException("Cannot create section",e);
        }
    }

    @Override
    public void delete(Long id) throws ServiceException {

    }

    @Override
    public List<Section> sections(String id) throws ServiceException {
        try {
            return dao.getAllSectionsByConferenceId(id);
        } catch (DaoException e) {
            throw new ServiceException("Cannot get sections" + e.getMessage(),e);
        }
    }

    @Override
    public void close() throws ServiceException {
        try {
            dao.close();
        } catch (DaoException e) {
            throw new ServiceException("Cannot close connection",e);
        }
    }
}
