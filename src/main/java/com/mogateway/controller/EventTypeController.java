package com.mogateway.controller;

import com.mogateway.entity.EventType;
import com.mogateway.redis.RedisUtil;
import com.mogateway.service.EventTypeService;
import com.mogateway.util.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by Administrator on 2018-04-18.
 */
@RestController
public class EventTypeController extends BaseController {

    @Autowired
    private EventTypeService eventTypeService;

    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping(value = "/getEventTypes")
    public Map<String, Object> getEventTypes() {
        map.clear();
        try {
            map.put("eventTypes", eventTypeService.getEventTypes());
            map.put("result", "success");
        } catch (Exception e) {
            map.put("result", "error");
            redisUtil.pubLog("Event", "事件告警", "admin", CommonUtils.exception2Str(e));
        }
        return map;
    }

    @RequestMapping(value = "/addEventType")
    public Map<String, Object> addEventType(EventType eventType) {
        map.clear();
        redisUtil.pubLog("Event", "事件告警", "admin", "添加事件类型开始");
        try {
            int exeCnt = eventTypeService.addEventType(eventType, "admin");
            if (exeCnt > 0) {
                map.put("result", "success");
                redisUtil.pubLog("event", "事件告警", "admin", "添加事件类型成功");
            } else {
                map.put("result", "failed");
                redisUtil.pubLog("Event", "事件告警", "admin", "添加事件类型失败");
            }
        } catch (Exception e) {
            map.put("result", "error");
            redisUtil.pubLog("Event", "事件告警", "admin", CommonUtils.exception2Str(e));
        }
        return map;
    }

    @RequestMapping(value = "/updateEventType")
    public Map<String, Object> updateEventType(EventType eventType) {
        map.clear();
        redisUtil.pubLog("Event", "事件告警", "admin", "修改事件类型开始");
        try {
            int exeCnt = eventTypeService.updateEventType(eventType, "admin");
            if (exeCnt > 0) {
                map.put("result", "success");
                redisUtil.pubLog("Event", "事件告警", "admin", "修改事件类型成功");
            } else {
                map.put("result", "failed");
                redisUtil.pubLog("Event", "事件告警", "admin", "修改事件类型失败");
            }
        } catch (Exception e) {
            map.put("result", "error");
            redisUtil.pubLog("Event", "事件告警", "admin", CommonUtils.exception2Str(e));
        }
        return map;
    }

    @RequestMapping(value = "/deleteEventType")
    public Map<String, Object> deleteEvenType(String eventTypes) {
        map.clear();
        redisUtil.pubLog("Event", "事件告警", "admin", "删除事件类型" + eventTypes + "开始");
        try {
            int exeCnt = eventTypeService.deleteEventType(eventTypes);
            if (exeCnt > 0) {
                map.put("result", "success");
                redisUtil.pubLog("Event", "事件告警", "admin", "删除事件类型" + eventTypes + "成功");
            } else {
                map.put("result", "failed");
                redisUtil.pubLog("Event", "事件告警", "admin", "删除事件类型" + eventTypes + "失败");
            }
        } catch (Exception e) {
            map.put("result", "error");
            redisUtil.pubLog("Event", "事件告警", "admin", CommonUtils.exception2Str(e));
        }
        return map;
    }
}
