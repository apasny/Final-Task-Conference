package com.epam.conference.entity;

import java.sql.Time;
import java.util.Date;
import java.util.Objects;

public class Section implements Identifiable {

    public static final String TABLE = "section";

    private final Long id;
    private final String topic;
    private final Date startDate;
    private final Date endDate;
    private final Time startTime;
    private final Time endTime;
    private final int maxAttendees;
    private final boolean isAvailable;

    public Section(Long id, String topic, Date startDate, Date endDate, Time startTime, Time endTime, int maxAttendees, boolean isAvailable) {
        this.id = id;
        this.topic = topic;
        this.startDate = startDate;
        this.endDate = endDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.maxAttendees = maxAttendees;
        this.isAvailable = isAvailable;
    }

    @Override
    public Long getId() {
        return id;
    }

    public String getTopic() {
        return topic;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
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

    public boolean isAvailable() {
        return isAvailable;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Section section = (Section) object;
        return maxAttendees == section.maxAttendees &&
                isAvailable == section.isAvailable &&
                Objects.equals(id, section.id) &&
                Objects.equals(topic, section.topic) &&
                Objects.equals(startDate, section.startDate) &&
                Objects.equals(endDate, section.endDate) &&
                Objects.equals(startTime, section.startTime) &&
                Objects.equals(endTime, section.endTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, topic, startDate, endDate, startTime, endTime, maxAttendees, isAvailable);
    }

    @Override
    public String toString() {
        return "Section{" +
                "id=" + id +
                ", topic='" + topic + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", maxAttendees=" + maxAttendees +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
