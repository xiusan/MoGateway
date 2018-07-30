package com.mogateway.controller;

import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageInfo;
import com.mogateway.entity.Ammeter;
import com.mogateway.redis.RedisUtil;
import com.mogateway.service.AmmeterService;
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
import java.util.Map;

/**
 * @author weizheng
 * @create 2018-05-15 11:28
 * @desc 电表管理
 **/
@Api(value="AmmeterController", description ="电表管理")
@RestController
@RequestMapping(value="/ammter")
public class AmmeterController {

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private AmmeterService ammeterService;

    @ApiOperation(value = "电表列表", notes = "电表列表")
    @RequestMapping(value="/ammters", method= RequestMethod.POST)
    public Result ammters(
            Ammeter ammeter,
            @RequestParam(required = false, defaultValue = "1") int pageNumber,
            @RequestParam(required = false, defaultValue = "100") int pageSize) {
        Result res = new Result();
        Map<String,Object> map = new HashMap<>();
        try {
            PageInfo<Ammeter> pageInfo = ammeterService.queryList(ammeter,pageNumber,pageSize);
            map.put("recordsTotal",pageInfo.getTotal());
            map.put("recordsFiltered",pageInfo.getTotal());
            map.put("list", pageInfo.getList());
            res.addSuccess(map);
        } catch (Exception e) {
            redisUtil.pubLog("AmmterManage", "电表管理", "admin", CommonUtils.exception2Str(e));
            res.addError(ErrorCode.SYS40005,ErrorCode.SYS40005_INFO);
        }
        return res;
    }

    @ApiOperation(value = "添加电表", notes = "添加电表")
    @RequestMapping(value="/addAmmter", method= RequestMethod.POST)
    public Result addAmmter(
            Ammeter ammeter) {
        redisUtil.pubLog("AmmterManage", "电表管理", "admin", "添加电表开始");
        Result res = new Result();
        try {
            Ammeter ammeter1 = ammeterService.selectByPrimaryKey(ammeter.getAmmeterId());
            if (StringTool.isNotEmpty(ammeter1)){
                redisUtil.pubLog("AmmterManage", "电表管理", "admin", "电表号已存在");
                res.addError(ErrorCode.PUB10003,ErrorCode.PUB10003_INFO);
                return res;
            }
            ammeter.setCreateDttm(new Date());
            ammeter.setCreateUser("admin");
            int count = ammeterService.insertSelective(ammeter);
            if (count>0){
                redisUtil.pubLog("AmmterManage", "电表管理", "admin", "添加电表成功");
                res.addSuccess(count);
                return res;
            }

        } catch (Exception e) {
            redisUtil.pubLog("AmmterManage", "电表管理", "admin", CommonUtils.exception2Str(e));
            res.addError(ErrorCode.SYS40002,ErrorCode.SYS40002_INFO);
            return res;
        }
        return res;
    }


    @ApiOperation(value = "修改电表", notes = "修改电表")
    @RequestMapping(value="/putAmmter", method= RequestMethod.POST)
    public Result putAmmter(
            Ammeter ammeter) {
        redisUtil.pubLog("AmmterManage", "电表管理", "admin", "修改电表开始");
        Result res = new Result();
        try {
            ammeter.setCreateDttm(new Date());
            ammeter.setCreateUser("admin");
            int count = ammeterService.updateByPrimaryKey(ammeter);
            if (count>0){
                redisUtil.pubLog("AmmterManage", "电表管理", "admin", "修改电表成功");
                res.addSuccess(count);
                return res;
            }

        } catch (Exception e) {
            redisUtil.pubLog("AmmterManage", "电表管理", "admin", CommonUtils.exception2Str(e));
            res.addError(ErrorCode.SYS40003,ErrorCode.SYS40003_INFO);
            return res;
        }
        return res;
    }

    @ApiOperation(value = "删除电表", notes = "删除电表")
    @RequestMapping(value="/delAmmter", method= RequestMethod.POST)
    public Result delTask(@RequestParam(required = false, defaultValue = "")String idArray){
        redisUtil.pubLog("AmmterManage", "电表管理", "admin", "删除电表开始");
        Result res = new Result();
        try {
            JSONArray json = JSONArray.parseArray(idArray);
            Object[] jsonArray =  json.toArray();
            for (int i=0;i<jsonArray.length;i++){
               int count = ammeterService.deleteByPrimaryKey(jsonArray[i].toString());
               if (count>0){
                   redisUtil.pubLog("AmmterManage", "电表管理", "admin", "删除电表成功");
                   res.addSuccess(count);
               }

            }

            return res;
        } catch (Exception e) {
            redisUtil.pubLog("AmmterManage", "电表管理", "admin", CommonUtils.exception2Str(e));
            res.addError(ErrorCode.SYS40004,ErrorCode.SYS40004_INFO);
            return res;
        }
    }



}
