package com.mogateway.service;

import com.mogateway.entity.EventType;
import com.mogateway.mapper.EventTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Administrator on 2018-04-18.
 */
@Component
public class EventTypeService {

    @Autowired
    private EventTypeMapper eventTypeMapper;

    public List<EventType> getEventTypes() {
        return eventTypeMapper.getEventTypes();
    }

    public int addEventType(EventType eventType, String userID) {
        eventType.setCreateUser(userID);
        eventType.setUpdateUser(userID);
        return eventTypeMapper.addEventType(eventType);
    }

    public int updateEventType(EventType eventType, String userID) {
        eventType.setUpdateUser(userID);
        return eventTypeMapper.updateEventType(eventType);
    }

    public int deleteEventType(String eventTypes) {
        return eventTypeMapper.deleteEventType(eventTypes.split(","));
    }
}
