package com.mogateway.controller;

import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageInfo;
import com.mogateway.entity.SerialConfig;
import com.mogateway.redis.RedisUtil;
import com.mogateway.service.SerialConfigService;
import com.mogateway.util.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author weizheng
 * @create 2018-05-15 15:15
 * @desc 电表配置管理
 **/
@Api(value="SerialConfigController", description ="电表配置管理")
@RestController
@RequestMapping(value="/serialConfig")
public class SerialConfigController {

    @Autowired
    private SerialConfigService serialConfigService;
    @Autowired
    private RedisUtil redisUtil;


    @ApiOperation(value = "电表配置列表", notes = "电表配置列表")
    @RequestMapping(value="/serialConfigs", method= RequestMethod.POST)
    public Result serialConfigs(
            SerialConfig serialConfig,
            @RequestParam(required = false, defaultValue = "1") int pageNumber,
            @RequestParam(required = false, defaultValue = "100") int pageSize) {
        Result res = new Result();
        Map<String,Object> map = new HashMap<>();
        try {
            PageInfo<SerialConfig> pageInfo = serialConfigService.selectByExample(serialConfig,pageNumber,pageSize);
            map.put("recordsTotal",pageInfo.getTotal());
            map.put("recordsFiltered",pageInfo.getTotal());
            map.put("list", pageInfo.getList());
            res.addSuccess(map);
        } catch (Exception e) {
            redisUtil.pubLog("SerialConfigManage", "电表配置管理", "admin", CommonUtils.exception2Str(e));
            res.addError(ErrorCode.SYS40005,ErrorCode.SYS40005_INFO);
        }
        return res;
    }

    @ApiOperation(value = "电表配置名称列表", notes = "电表配置名称列表")
    @RequestMapping(value="/serialConfigNames", method= RequestMethod.POST)
    public Result serialConfigNames() {
        Result res = new Result();
        Map<String,Object> map = new HashMap<>();
        try {
            List<SerialConfig> serialConfigs = serialConfigService.selectByExample();
            map.put("serialConfigs", serialConfigs);
            res.addSuccess(map);
        } catch (Exception e) {
            redisUtil.pubLog("SerialConfigManage", "电表配置管理", "admin", CommonUtils.exception2Str(e));
            res.addError(ErrorCode.SYS40005,ErrorCode.SYS40005_INFO);
        }
        return res;
    }

    @ApiOperation(value = "添加电表配置", notes = "添加电表配置")
    @RequestMapping(value="/addSerialConfig", method= RequestMethod.POST)
    public Result addSerialConfig(SerialConfig serialConfig) {
        redisUtil.pubLog("SerialConfigManage", "电表配置管理", "admin", "添加电表配置开始");
        Result res = new Result();
        Map<String,Object> map = new HashMap<>();
        try {
            SerialConfig serialConfig1 = serialConfigService.selectByPrimaryKey(serialConfig.getSerialName());
            if (StringTool.isNotEmpty(serialConfig1)){
                redisUtil.pubLog("SerialConfigManage", "电表配置管理", "admin", "该串口号已存在");
                res.addError("serialConfig1001","该串口号已存在");
                return res;
            }
            serialConfig.setCreateDttm(new Date());
            serialConfig.setCreateUser("admin");
            int count = serialConfigService.insertSelective(serialConfig);
            if (count>0){
                redisUtil.pubLog("SerialConfigManage", "电表配置管理", "admin", "添加电表配置成功");
                res.addSuccess(count);
                return res;
            }
            res.addSuccess(map);
        } catch (Exception e) {
            redisUtil.pubLog("SerialConfigManage", "电表配置管理", "admin", CommonUtils.exception2Str(e));
            res.addError(ErrorCode.SYS40002,ErrorCode.SYS40002_INFO);
            return res;
        }
        return res;
    }

    @ApiOperation(value = "修改电表配置", notes = "修改电表配置")
    @RequestMapping(value="/putSerialConfig", method= RequestMethod.POST)
    public Result putSerialConfig(SerialConfig serialConfig) {
        redisUtil.pubLog("SerialConfigManage", "电表配置管理", "admin", "修改电表配置开始");
        Result res = new Result();
        Map<String,Object> map = new HashMap<>();
        try {

            serialConfig.setUpdateDttm(new Date());
            serialConfig.setUpdateUser("admin");
            int count = serialConfigService.updateByPrimaryKey(serialConfig);
            if (count>0){
                redisUtil.pubLog("SerialConfigManage", "电表配置管理", "admin", "修改电表配置成功");
                res.addSuccess(count);
                return res;
            }
            res.addSuccess(map);
        } catch (Exception e) {
            redisUtil.pubLog("SerialConfigManage", "电表配置管理", "admin", CommonUtils.exception2Str(e));
            res.addError(ErrorCode.SYS40003,ErrorCode.SYS40003_INFO);
            return res;
        }
        return res;
    }

    @ApiOperation(value = "删除电表配置", notes = "删除电表配置")
    @RequestMapping(value="/delSerialConfig", method= RequestMethod.POST)
    public Result delSerialConfig(@RequestParam(required = false, defaultValue = "")String idArray){
        redisUtil.pubLog("SerialConfigManage", "电表配置管理", "admin", "删除电表配置开始");
        Result res = new Result();
        try {
            JSONArray json = JSONArray.parseArray(idArray);
            Object[] jsonArray =  json.toArray();
            for (int i=0;i<jsonArray.length;i++){
                int count = serialConfigService.deleteByPrimaryKey(jsonArray[i].toString());
                if (count>0){
                    redisUtil.pubLog("SerialConfigManage", "电表配置管理", "admin", "删除电表配置成功");
                    res.addSuccess(count);
                }
            }
            return res;
        } catch (Exception e) {
            redisUtil.pubLog("SerialConfigManage", "电表配置管理", "admin", CommonUtils.exception2Str(e));
            res.addError(ErrorCode.SYS40004,ErrorCode.SYS40004_INFO);
            return res;
        }
    }

}
