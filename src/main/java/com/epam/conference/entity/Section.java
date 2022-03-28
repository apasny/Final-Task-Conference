package com.epam.conference.entity;

import java.io.Serializable;
import java.sql.Time;
import java.util.Objects;

public class Section implements Identifiable, Serializable {

    public static final String TABLE = "section";
    public static final String ID = "id";
    public static final String TOPIC = "topic";
    public static final String STARTTIME = "start_time";
    public static final String ENDTIME = "end_time";
    public static final String MAXATTENDEES = "max_attendees";
    public static final String ISAVAILABLE = "is_available";
    public static final String ISDELETED = "is_deleted";
    public static final String CONFERENCEID = "conference_id";


    private final Long id;
    private final String topic;
    private final Time startTime;
    private final Time endTime;
    private final int maxAttendees;
    private final boolean isAvailable;
    private final boolean isDeleted;
    private final Long conferenceId;

    public Section(Long id, String topic, Time startTime, Time endTime, int maxAttendees, boolean isAvailable, boolean isDeleted, Long conferenceId) {
        this.id = id;
        this.topic = topic;
        this.startTime = startTime;
        this.endTime = endTime;
        this.maxAttendees = maxAttendees;
        this.isAvailable = isAvailable;
        this.isDeleted = isDeleted;
        this.conferenceId = conferenceId;
    }

    @Override
    public Long getId() {
        return id;
    }

    public String getTopic() {
        return topic;
    }

    public Time getStartTime() {
        return startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public int getMaxAttendees() {
        return maxAttendees;
    }

    public boolean getIsAvailable() {
        return isAvailable;
    }

    public boolean getIsDeleted() {
        return isDeleted;
    }

    public Long getConferenceId() {
        return conferenceId;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Section section = (Section) object;
        return maxAttendees == section.maxAttendees &&
                isAvailable == section.isAvailable &&
                isDeleted == section.isDeleted &&
                Objects.equals(id, section.id) &&
                Objects.equals(topic, section.topic) &&
                Objects.equals(startTime, section.startTime) &&
                Objects.equals(endTime, section.endTime) &&
                Objects.equals(conferenceId, section.conferenceId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, topic, startTime, endTime, maxAttendees, isAvailable, isDeleted, conferenceId);
    }

    @Override
    public String toString() {
        return "Section{" +
                "id=" + id +
                ", topic='" + topic + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", maxAttendees=" + maxAttendees +
                ", isAvailable=" + isAvailable +
                ", isDeleted=" + isDeleted +
                ", conferenceId=" + conferenceId +
                '}';
    }
}
