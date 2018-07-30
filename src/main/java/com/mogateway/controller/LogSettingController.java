package com.mogateway.controller;

import com.mogateway.entity.LogSetting;
import com.mogateway.redis.RedisUtil;
import com.mogateway.service.LogSettingService;
import com.mogateway.util.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by Administrator on 2018-04-27.
 */
@RestController
public class LogSettingController extends BaseController {

    @Autowired
    private LogSettingService logSettingService;

    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping("/getLogSetting")
    public Map<String, Object> getLogSetting() {
        map.clear();
        try {
            map.put("logSettings", logSettingService.getLogSetting());
            map.put("result", "success");
        } catch (Exception e) {
            map.put("result", "error");
            redisUtil.pubLog("LogManage", "日志管理", "admin", CommonUtils.exception2Str(e));
        }
        return map;
    }

    @RequestMapping("/addLogSetting")
    public Map<String, Object> addLogSetting(LogSetting logSetting) {
        map.clear();
        redisUtil.pubLog("LogManage", "日志管理", "admin", "添加日志配置:" + logSetting.getModuleID() + "开始");
        try {
            int exCnt = logSettingService.addLogSetting(logSetting, "admin");
            if (exCnt > 0) {
                map.put("result", "success");
                redisUtil.pubLog("LogManage", "日志管理", "admin", "添加日志配置:" + logSetting.getModuleID() + "成功");
            } else {
                map.put("result", "failed");
                redisUtil.pubLog("LogManage", "日志管理", "admin", "添加日志配置:" + logSetting.getModuleID() + "失败");
            }
        } catch (Exception e) {
            map.put("result", "error");
            redisUtil.pubLog("LogManage", "日志管理", "admin", CommonUtils.exception2Str(e));
        }
        return map;
    }

    @RequestMapping("/updateLogSetting")
    public Map<String, Object> updateLogSetting(LogSetting logSetting) {
        map.clear();
        redisUtil.pubLog("LogManage", "日志管理", "admin", "修改日志配置:" + logSetting.getModuleID() + "开始");
        try {
            int exCnt = logSettingService.updateLogSetting(logSetting, "admin");
            if (exCnt > 0) {
                map.put("result", "success");
                redisUtil.pubLog("LogManage", "日志管理", "admin", "修改日志配置:" + logSetting.getModuleID() + "成功");
            } else {
                map.put("result", "failed");
                redisUtil.pubLog("LogManage", "日志管理", "admin", "修改日志配置:" + logSetting.getModuleID() + "失败");
            }
        } catch (Exception e) {
            map.put("result", "error");
            redisUtil.pubLog("LogManage", "日志管理", "admin", CommonUtils.exception2Str(e));
        }
        return map;
    }

    @RequestMapping("/deleteLogSetting")
    public Map<String, Object> deleteLogSetting(String moduleIDs) {
        map.clear();
        redisUtil.pubLog("LogManage", "日志管理", "admin", "删除日志配置:" + moduleIDs + "开始");
        try {
            int exCnt = logSettingService.deleteLogSetting(moduleIDs);
            if (exCnt > 0) {
                map.put("result", "success");
                redisUtil.pubLog("LogManage", "日志管理", "admin", "删除日志配置:" + moduleIDs + "成功");
            } else {
                map.put("result", "failed");
                redisUtil.pubLog("LogManage", "日志管理", "admin", "删除日志配置:" + moduleIDs + "失败");
            }
        } catch (Exception e) {
            map.put("result", "error");
            redisUtil.pubLog("LogManage", "日志管理", "admin", CommonUtils.exception2Str(e));
        }
        return map;
    }
}
