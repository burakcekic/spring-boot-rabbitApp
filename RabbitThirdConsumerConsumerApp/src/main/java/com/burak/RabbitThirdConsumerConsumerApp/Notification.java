package com.burak.RabbitThirdConsumerConsumerApp;

import java.io.Serializable;
import java.util.Date;

public class Notification implements Serializable {
    private int id;
    private Date date;
    private String eventId;

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "id=" + id +
                ", date=" + date +
                ", eventId='" + eventId + '\'' +
                '}';
    }
}
