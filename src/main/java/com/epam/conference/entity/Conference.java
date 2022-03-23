package com.epam.conference.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

public class Conference implements Identifiable, Serializable {

    public static final String TABLE = "conference";
    public static final String ID = "id";
    public static final String TOPICS = "topic";
    public static final String STARTDATE = "start_date";
    public static final String ENDDATE = "end_date";
    public static final String PLACE = "place";
    public static final String ISAVAILABLE = "is_available";
    public static final String ISDELETED = "is_deleted";

    private final Long id;
    private final String topics;
    private final Date startDate;
    private final Date endDate;
    private final String place;
    private final boolean isAvailable;
    private final boolean isDeleted;

    public Conference(Long id, String topics, Date startDate, Date endDate, String place, boolean isAvailable, boolean isDeleted) {
        this.id = id;
        this.topics = topics;
        this.startDate = startDate;
        this.endDate = endDate;
        this.place = place;
        this.isAvailable = isAvailable;
        this.isDeleted = isDeleted;

    }

    @Override
    public Long getId() {
        return id;
    }

    public String getTopics() {
        return topics;
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

    public boolean getIsAvailable() {
        return isAvailable;
    }

    public boolean getIsDeleted() {
        return isDeleted;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Conference that = (Conference) object;
        return isAvailable == that.isAvailable &&
                isDeleted == that.isDeleted &&
                Objects.equals(id, that.id) &&
                Objects.equals(topics, that.topics) &&
                Objects.equals(startDate, that.startDate) &&
                Objects.equals(endDate, that.endDate) &&
                Objects.equals(place, that.place);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, topics, startDate, endDate, place, isAvailable, isDeleted);
    }

    @Override
    public String toString() {
        return "Conference{" +
                "id=" + id +
                ", topic='" + topics + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", place='" + place + '\'' +
                ", isAvailable=" + isAvailable +
                ", isAvailable=" + isDeleted +
                '}';
    }
}
