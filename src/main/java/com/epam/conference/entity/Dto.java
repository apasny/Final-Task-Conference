package com.epam.conference.entity;

import java.io.Serializable;
import java.util.Objects;

public class Dto implements Identifiable,Serializable {

    public static final String TABLE="request";

    private final Request request;
    private final User user;
    private final Section section;
    private final Conference conference;

    public Dto(Request request, User user, Section section, Conference conference) {
        this.request = request;
        this.user = user;
        this.section = section;
        this.conference = conference;
    }

    @Override
    public Long getId() {
        return null;
    }

    public Request getRequest() {
        return request;
    }

    public User getUser() {
        return user;
    }

    public Section getSection() {
        return section;
    }

    public Conference getConference() {
        return conference;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dto dto = (Dto) o;
        return Objects.equals(request, dto.request) && Objects.equals(user, dto.user) && Objects.equals(section, dto.section) && Objects.equals(conference, dto.conference);
    }

    @Override
    public int hashCode() {
        return Objects.hash(request, user, section, conference);
    }

    @Override
    public String toString() {
        return "Dto{" +
                "request=" + request +
                ", user=" + user +
                ", section=" + section +
                ", conference=" + conference +
                '}';
    }
}
