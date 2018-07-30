package com.mogateway.redis;

import com.mogateway.entity.EventRecord;
import com.mogateway.service.EventRecordService;
import com.mogateway.util.CommonUtils;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2018-04-28.
 */
@Component
public class EventReceiver implements MessageListener {

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private EventRecordService eventRecordService;

    @Override
    public void onMessage(Message message, byte[] pattern) {
        String msg = CommonUtils.convertMsg(redisUtil.getRedisTemplate(), message);
        if ("".equals(message) || message == null) {
            return;
        }
        JSONObject json = JSONObject.fromObject(message);
        EventRecord eventRecord = new EventRecord();
        if (json.has("event")) {
            eventRecord.setEvent(json.getString("event"));
        }
        if (json.has("eventType")) {
            eventRecord.setEventType(json.getString("eventType"));
        }
        if (json.has("eventDTTM")) {
            eventRecord.setEventDTTM(CommonUtils.parseDate(json.getString("eventDTTM"), "yyyy-MM-dd HH:mm:ss"));
        }
        eventRecordService.addEventRecord(eventRecord);
    }
}
