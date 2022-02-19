package com.epam.conference.entity;

import java.sql.Date;
import java.util.Objects;

public class Conference implements Identifiable {

    public static final String TABLE = "conference";

    private final Long id;
    private final String topic;
    private final Date startDate;
    private final Date endDate;
    private final String place;
    private final boolean isAvailable;

    public Conference(Long id, String topic, Date startDate, Date endDate, String place, boolean isAvailable) {
        this.id = id;
        this.topic = topic;
        this.startDate = startDate;
        this.endDate = endDate;
        this.place = place;
        this.isAvailable = isAvailable;
    }

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

    public String getPlace() {
        return place;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Conference that = (Conference) object;
        return isAvailable == that.isAvailable &&
                Objects.equals(id, that.id) &&
                Objects.equals(topic, that.topic) &&
                Objects.equals(startDate, that.startDate) &&
                Objects.equals(endDate, that.endDate) &&
                Objects.equals(place, that.place);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, topic, startDate, endDate, place, isAvailable);
    }

    @Override
    public String toString() {
        return "Conference{" +
                "id=" + id +
                ", topic='" + topic + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", place='" + place + '\'' +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
