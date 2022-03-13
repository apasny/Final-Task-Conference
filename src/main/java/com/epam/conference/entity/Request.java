package com.epam.conference.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

public class Request implements Identifiable, Serializable {

    public static final String TABLE = "request";
    public static final String ID = "id";
    public static final String TIME = "time";
    public static final String USER_ID = "user_id";
    public static final String SECTION_ID = "section_id";
    public static final String STATUS = "status";

    private final Long id;
    private final Long userId;
    private final Long sectionId;
    private final String status;

    public Request(Long id, Long userId, Long sectionId, String status) {
        this.id = id;
        this.userId = userId;
        this.sectionId = sectionId;
        this.status = status;
    }

    @Override
    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getSectionId() {
        return sectionId;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Request request = (Request) object;
        return Objects.equals(id, request.id) &&
                Objects.equals(userId, request.userId) &&
                Objects.equals(sectionId, request.sectionId) &&
                Objects.equals(status, request.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, sectionId, status);
    }

    @Override
    public String toString() {
        return "Request{" +
                "id=" + id +
                ", userId=" + userId +
                ", sectionId=" + sectionId +
                ", status='" + status + '\'' +
                '}';
    }
}
