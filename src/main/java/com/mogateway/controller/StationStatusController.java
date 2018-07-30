package com.mogateway.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mogateway.entity.StationStatus;
import com.mogateway.service.StationStatusService;


/**
* 类名称：StationStatusController
* 创建人：
* 创建时间：2018-07-18
* 描   述: 站点状态管理
*/
@Controller
public class StationStatusController {


    @Autowired
    private StationStatusService stationstatusService;

    /**
    *  站点状态管理映射到Html
    * @return
    */
    @RequestMapping(value = "/stationstatus")
            public String stationstatusPage(){
                return "StationStatus";
            }

    /**
    * 站点状态管理查询List
    * @param pageNum
    * @param pageSize
    * @return
    */
    @RequestMapping("/getStationStatusList")
    @ResponseBody
    public Object getStationStatusList(
    StationStatus stationstatus, @RequestParam(value="pageNum", defaultValue="1") Integer pageNum,
    @RequestParam(value="pageSize", defaultValue="10") Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<StationStatus> stationstatusList = stationstatusService.getStationStatusList(stationstatus);
        PageInfo pageInfo = new PageInfo(stationstatusList);

        return pageInfo;
    }

    /**
    * 添加
    * @param
    * @return
    */
    @PostMapping("/saveStationStatus")
    @ResponseBody
    public Object saveStationStatus(StationStatus stationstatus) {

    Map<String, Object> map = new HashMap<String, Object>();
    try {
        int count = stationstatusService.saveStationStatus(stationstatus);
        if (count > 0) {
            map.put("result", "Success");
        } else {
            map.put("result", "Error");
        }
    }  catch (DuplicateKeyException ex) {
        ex.printStackTrace();
        String[] error = ex.getCause().getMessage().split("'");
        if ("PRIMARY".equals(error[3].trim())) {
            map.put("result", "EquipmentIDExist");
        } else if ("EquipmentName".equals(error[3].trim())) {
            map.put("result", "EquipmentNameExist");
        } else {
            map.put("result", "DuplicateError");
        }
    } catch (Throwable e) {
        e.printStackTrace();
        map.put("result", "Error");
    }
    return map;
    }

    /**
    * 更新
    * @param
    * @return
    */
    @PostMapping("/updateStationStatus")
    @ResponseBody
    public Object updateOperatorInfo(StationStatus stationstatus) {

    Map<String, Object> map = new HashMap<String, Object>();

    /* 需要单独实现ID判定
    if (StringUtils.isEmpty(operatorInfo.getOperatorId())) {
        map.put("result", "OperatorIdEmpty");
        return map;
    }
    */
    try {
        int count = stationstatusService.updateStationStatus(stationstatus);
        if (count > 0) {
            map.put("result", "Success");
        } else {
            map.put("result", "NotFound");
        }
    }  catch (DuplicateKeyException ex) {
        String[] error = ex.getCause().getMessage().split("'");
        if ("EquipmentName".equals(error[3].trim())) {
            map.put("result", "EquipmentNameExist");
        } else {
            map.put("result", "DuplicateError");
        }
    } catch (Exception e) {
        e.printStackTrace();
        map.put("result", "Error");

    }
    return map;
    }

    /**
    * 删除
    * @param
    * @return
    */
    @RequestMapping(value = "/delStationStatus")
    @ResponseBody
    public Object delOperatorInfo(StationStatus stationstatus) {

    Map<String, Object> map = new HashMap<String, Object>();
    /* 需要单独实现ID判定
    if (StringUtils.isEmpty(operatorInfo.getOperatorId())) {
        map.put("result", "OperatorIdEmpty");
        return map;
    }
    */
    try {
        int count = stationstatusService.delStationStatus(stationstatus);
        if (count > 0) {
            map.put("result", "Success");
        } else {
            map.put("result", "NotFound");
        }
    } catch (Exception e) {
        e.printStackTrace();
        map.put("result", "Error");
    }
    return map;
    }

    }