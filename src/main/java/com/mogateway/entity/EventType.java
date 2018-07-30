package com.mogateway.entity;

import java.util.Date;

/**
 * Created by Administrator on 2018-04-18.
 */
public class EventType {

    private String EventType;

    private String EventTypeName;

    private String EventDescription;

    private Date CreateDTTM;

    private String CreateUser;

    private Date UpdateDTTM;

    private String UpdateUser;

    public String getEventType() {
        return EventType;
    }

    public void setEventType(String eventType) {
        EventType = eventType;
    }

    public String getEventTypeName() {
        return EventTypeName;
    }

    public void setEventTypeName(String eventTypeName) {
        EventTypeName = eventTypeName;
    }

    public String getEventDescription() {
        return EventDescription;
    }

    public void setEventDescription(String eventDescription) {
        EventDescription = eventDescription;
    }

    public Date getCreateDTTM() {
        return CreateDTTM;
    }

    public void setCreateDTTM(Date createDTTM) {
        CreateDTTM = createDTTM;
    }

    public String getCreateUser() {
        return CreateUser;
    }

    public void setCreateUser(String createUser) {
        CreateUser = createUser;
    }

    public Date getUpdateDTTM() {
        return UpdateDTTM;
    }

    public void setUpdateDTTM(Date updateDTTM) {
        UpdateDTTM = updateDTTM;
    }

    public String getUpdateUser() {
        return UpdateUser;
    }

    public void setUpdateUser(String updateUser) {
        UpdateUser = updateUser;
    }
}
