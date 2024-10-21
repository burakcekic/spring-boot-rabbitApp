package com.burak.RabbitThirdConsumerConsumerApp;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "pg_rabbit_trancastion")
public class PgRabbitTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String queueName;
    private String eventId;
    private String eventPayload;
    private Date sendDate;
    private Date reciveDate;
    private boolean sendCheck;
    private boolean reciveCheck;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQueueName() {
        return queueName;
    }

    public void setQueueName(String queueName) {
        this.queueName = queueName;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getEventPayload() {
        return eventPayload;
    }

    public void setEventPayload(String eventPayload) {
        this.eventPayload = eventPayload;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    public Date getReciveDate() {
        return reciveDate;
    }

    public void setReciveDate(Date reciveDate) {
        this.reciveDate = reciveDate;
    }

    public boolean isSendCheck() {
        return sendCheck;
    }

    public void setSendCheck(boolean sendCheck) {
        this.sendCheck = sendCheck;
    }

    public boolean isReciveCheck() {
        return reciveCheck;
    }

    public void setReciveCheck(boolean reciveCheck) {
        this.reciveCheck = reciveCheck;
    }
}
