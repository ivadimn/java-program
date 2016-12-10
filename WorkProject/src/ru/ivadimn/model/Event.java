package ru.ivadimn.model;

import java.util.Date;

/**
 * Created by vadim on 10.12.16.
 */
public class Event {
    private Date time;
    private String place;
    private String description;

    public Event(Date time, String place, String description) {
        this.time = time;
        this.place = place;
        this.description = description;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
