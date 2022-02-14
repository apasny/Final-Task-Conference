package com.epam.conference.entity;

import java.sql.Timestamp;
import java.util.Objects;

public class Request implements Identifiable {

    public static final String TABLE = "request";

    private final Long id;
    private final String topic;
    private final Timestamp time;
    private final Long userId;
    private final Long sectionId;
    private final String status;

    public Request(Long id, String topic, Timestamp time, Long userId, Long sectionId, String status) {
        this.id = id;
        this.topic = topic;
        this.time = time;
        this.userId = userId;
        this.sectionId = sectionId;
        this.status = status;
    }

    @Override
    public Long getId() {
        return id;
    }

    public String getTopic() {
        return topic;
    }

    public Timestamp getTime() {
        return time;
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
                Objects.equals(topic, request.topic) &&
                Objects.equals(time, request.time) &&
                Objects.equals(userId, request.userId) &&
                Objects.equals(sectionId, request.sectionId) &&
                Objects.equals(status, request.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, topic, time, userId, sectionId, status);
    }

    @Override
    public String toString() {
        return "Request{" +
                "id=" + id +
                ", topic='" + topic + '\'' +
                ", time=" + time +
                ", userId=" + userId +
                ", sectionId=" + sectionId +
                ", status='" + status + '\'' +
                '}';
    }
}
