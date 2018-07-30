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

import com.mogateway.entity.StationType;
import com.mogateway.service.StationTypeService;


/**
* 类名称：StationTypeController
* 创建人：
* 创建时间：2018-07-18
* 描   述: 站点类型管理
*/
@Controller
public class StationTypeController {


    @Autowired
    private StationTypeService stationtypeService;

    /**
    *  站点类型管理映射到Html
    * @return
    */
    @RequestMapping(value = "/stationtype")
            public String stationtypePage(){
                return "StationType";
            }

    /**
    * 站点类型管理查询List
    * @param pageNum
    * @param pageSize
    * @return
    */
    @RequestMapping("/getStationTypeList")
    @ResponseBody
    public Object getStationTypeList(
    StationType stationtype, @RequestParam(value="pageNum", defaultValue="1") Integer pageNum,
    @RequestParam(value="pageSize", defaultValue="10") Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<StationType> stationtypeList = stationtypeService.getStationTypeList(stationtype);
        PageInfo pageInfo = new PageInfo(stationtypeList);

        return pageInfo;
    }

    /**
    * 添加
    * @param
    * @return
    */
    @PostMapping("/saveStationType")
    @ResponseBody
    public Object saveStationType(StationType stationtype) {

    Map<String, Object> map = new HashMap<String, Object>();
    try {
        int count = stationtypeService.saveStationType(stationtype);
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
    @PostMapping("/updateStationType")
    @ResponseBody
    public Object updateOperatorInfo(StationType stationtype) {

    Map<String, Object> map = new HashMap<String, Object>();

    /* 需要单独实现ID判定
    if (StringUtils.isEmpty(operatorInfo.getOperatorId())) {
        map.put("result", "OperatorIdEmpty");
        return map;
    }
    */
    try {
        int count = stationtypeService.updateStationType(stationtype);
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
    @RequestMapping(value = "/delStationType")
    @ResponseBody
    public Object delOperatorInfo(StationType stationtype) {

    Map<String, Object> map = new HashMap<String, Object>();
    /* 需要单独实现ID判定
    if (StringUtils.isEmpty(operatorInfo.getOperatorId())) {
        map.put("result", "OperatorIdEmpty");
        return map;
    }
    */
    try {
        int count = stationtypeService.delStationType(stationtype);
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