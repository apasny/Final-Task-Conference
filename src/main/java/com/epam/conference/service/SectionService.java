package com.epam.conference.service;

import com.epam.conference.entity.Section;
import com.epam.conference.exception.ServiceException;

import java.util.List;

public interface SectionService {

    void create(Section section) throws ServiceException;
    void delete(Long id) throws ServiceException;
    List<Section> allSections(String id) throws ServiceException;
    List<Section> notAppliedSections(String userId,String conferenceId) throws ServiceException;

    void close() throws ServiceException;
}
