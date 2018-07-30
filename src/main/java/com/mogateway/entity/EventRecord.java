package com.mogateway.entity;

import java.util.Date;

/**
 * Created by Administrator on 2018-04-19.
 */
public class EventRecord {

    private long ID;

    private String Event;

    private String  EventType;

    private Date EventDTTM;

    private Date StartDTTM;

    private Date EndDTTM;

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getEvent() {
        return Event;
    }

    public void setEvent(String event) {
        Event = event;
    }

    public String getEventType() {
        return EventType;
    }

    public void setEventType(String eventType) {
        EventType = eventType;
    }

    public Date getEventDTTM() {
        return EventDTTM;
    }

    public void setEventDTTM(Date eventDTTM) {
        EventDTTM = eventDTTM;
    }

    public Date getStartDTTM() {
        return StartDTTM;
    }

    public void setStartDTTM(Date startDTTM) {
        StartDTTM = startDTTM;
    }

    public Date getEndDTTM() {
        return EndDTTM;
    }

    public void setEndDTTM(Date endDTTM) {
        EndDTTM = endDTTM;
    }
}
