package com.epam.conference.service;

import com.epam.conference.entity.Section;
import com.epam.conference.exception.DaoException;
import com.epam.conference.exception.ServiceException;

import java.util.List;

public interface SectionService {

    void create(Section section) throws ServiceException;
    void delete(Long id) throws ServiceException;
    List<Section> sections(String id) throws ServiceException;

    void close() throws ServiceException;
}
