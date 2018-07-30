package com.mogateway.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mogateway.entity.EventRecord;
import com.mogateway.mapper.EventRecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Administrator on 2018-04-19.
 */
@Component
public class EventRecordService {

    @Autowired
    private EventRecordMapper eventRecordMapper;

    public PageInfo<EventRecord> getEventRecord(EventRecord eventRecord, Integer page, Integer rows) {
        PageHelper.startPage(page, rows);
        List<EventRecord> eventRecords = eventRecordMapper.getEventRecords(eventRecord);
        return new PageInfo<>(eventRecords);
    }

    public void addEventRecord(EventRecord eventRecord) {
        eventRecordMapper.addEventRecord(eventRecord);
    }
}
