package com.mogateway.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mogateway.util.CinTxt;
import com.mogateway.util.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class DefaultController {


    protected HttpHeaders httpHeaders = new HttpHeaders();

    @Autowired
    private StringRedisTemplate template;

    @Value("${spring.redis.address}")
    private String address;
    @Value("${spring.redis.logSubChannel}")
    private String logSubChannel;

    @Value("${moduleID}")
    private String moduleID;
    @Value("${moduleName}")
    private String moduleName;
    @Value("${userID}")
    private String userID;

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<String> exceptionHandler(Exception ex) {
        JSONObject result = new JSONObject();
        result.put("success", false);
        result.put("message", ex.getMessage());

        JSONObject message = new JSONObject();
        message.put("moduleID", moduleID);
        message.put("moduleName", moduleName);
        message.put("userID", userID);
        message.put("content", ex.getMessage());
        message.put("time", DateUtils.toString(new Date()));
        try {
            JSONObject redisConfigObj = JSON.parseObject(CinTxt.getTxtData(address));
            template.convertAndSend(redisConfigObj.getString("log_sub_channel"), message.toJSONString());
        } catch (Exception e) {
            template.convertAndSend(logSubChannel, message.toJSONString());
        }

        return new ResponseEntity<>(result.toJSONString(), httpHeaders, HttpStatus.OK);
    }


}
