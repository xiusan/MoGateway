package com.mogateway.controller;

import com.mogateway.redis.RedisUtil;
import com.mogateway.service.ModuleService;
import com.mogateway.util.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by Administrator on 2018-04-26.
 */
@RestController
public class ModuleController extends BaseController {

    @Autowired
    private ModuleService moduleService;

    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping("/moduleList")
    public Map<String, Object> getModule() {
        map.clear();
        try {
            map.put("modules", moduleService.getModule());
            map.put("result", "success");
        } catch (Exception e) {
            map.put("result", "error");
            redisUtil.pubLog("main", "主程序", "admin", CommonUtils.exception2Str(e));
        }
        return map;
    }
}
