package com.burak.RabbitFirstProducerApp;

import java.io.Serializable;
import java.util.Date;

public class Notification implements Serializable {

    private int id;
    private Date date = new Date();

    private String eventId;

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
                '}';
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }
}
