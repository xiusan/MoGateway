package com.mogateway.mapper;

import com.mogateway.entity.EventType;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by Administrator on 2018-04-18.
 */
@Mapper
public interface EventTypeMapper {

    @Select("select * from event_type")
    List<EventType> getEventTypes();

    @Insert("insert into event_type(" +
            "event_type," +
            "event_type_name," +
            "event_description," +
            "create_dttm," +
            "create_user," +
            "update_dttm," +
            "update_user) values (" +
            "#{EventType}," +
            "#{EventTypeName}," +
            "#{EventDescription}," +
            "now()," +
            "#{CreateUser}," +
            "now()," +
            "#{UpdateUser})")
    int addEventType(EventType eventType);

    @Update("update event_type set " +
            "event_type_name = #{EventTypeName}," +
            "event_description = #{EventDescription}," +
            "update_dttm = now()," +
            "update_user = #{UpdateUser} where " +
            "event_type = #{EventType}")
    int updateEventType(EventType eventType);

    @Delete("<script>delete from event_type where event_type in <foreach collection='eventTypes' index='index' item='item' open='(' separator=',' close=')'>#{item}</foreach></script>")
    int deleteEventType(@Param("eventTypes") String[] eventTypes);
}
