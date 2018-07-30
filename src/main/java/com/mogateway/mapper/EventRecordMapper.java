package com.mogateway.mapper;

import com.mogateway.entity.EventRecord;
import com.mogateway.provider.EventRecordProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * Created by Administrator on 2018-04-19.
 */
@Mapper
public interface EventRecordMapper {

    @SelectProvider(type =EventRecordProvider.class, method = "getEventRecords")
    List<EventRecord> getEventRecords(EventRecord eventRecord);

    @Insert("insert into event_record(" +
            "event," +
            "event_type," +
            "event_dttm) values (" +
            "#{Event}," +
            "#{EventType}," +
            "#{EventDTTM})")
    void addEventRecord(EventRecord eventRecord);
}
