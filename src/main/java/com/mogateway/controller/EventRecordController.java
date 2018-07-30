package com.mogateway.controller;

import com.github.pagehelper.PageInfo;
import com.mogateway.entity.EventRecord;
import com.mogateway.redis.RedisUtil;
import com.mogateway.service.EventRecordService;
import com.mogateway.util.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by Administrator on 2018-04-19.
 */
@RestController
public class EventRecordController extends BaseController {

    @Autowired
    private EventRecordService eventRecordService;

    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping(value = "/getEventRecord")
    public Map<String, Object> getEventRecord(EventRecord eventRecord, Integer pageNum, Integer pageSize) {
        map.clear();
        try {
            PageInfo<EventRecord> eventRecordPageInfo = eventRecordService.getEventRecord(eventRecord, pageNum, pageSize);
            map.put("eventRecords", eventRecordPageInfo.getList());
            map.put("totalCnt", eventRecordPageInfo.getTotal());
            map.put("result", "success");
        } catch (Exception e) {
            map.put("result", "error");
            redisUtil.pubLog("Event", "事件告警", "admin", CommonUtils.exception2Str(e));
        }
        return map;
    }
}
