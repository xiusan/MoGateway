package com.mogateway.provider;

import com.mogateway.entity.EventRecord;
import org.apache.ibatis.jdbc.SQL;

/**
 * Created by Administrator on 2018-04-19.
 */
public class EventRecordProvider {

    public String getEventRecords(EventRecord eventRecord){
        SQL sql = new SQL().SELECT("a.event," +
                "b.event_type_name as event_type," +
                "a.event_dttm ").FROM("event_record a")
                .LEFT_OUTER_JOIN("event_type b ON a.event_type = b.event_type");
        if(eventRecord.getEventType() != null && !"".equals(eventRecord.getEventType())){
            sql.WHERE("a.event_type  = #{EventType}");
        }
        if (eventRecord.getStartDTTM() != null) {
            sql.WHERE("a.event_dttm >= #{StartDTTM}");
        }
        if (eventRecord.getEndDTTM() != null) {
            sql.WHERE("a.event_dttm <= #{EndDTTM}");
        }
        sql.ORDER_BY("a.event_dttm desc");
        return sql.toString();
    }
}
