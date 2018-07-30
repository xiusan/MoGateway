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

import com.mogateway.entity.ConstructionInfo;
import com.mogateway.service.ConstructionInfoService;


/**
* 类名称：ConstructionInfoController
* 创建人：
* 创建时间：2018-07-18
* 描   述: 建设场所管理
*/
@Controller
public class ConstructionInfoController {


    @Autowired
    private ConstructionInfoService constructioninfoService;

    /**
    *  建设场所管理映射到Html
    * @return
    */
    @RequestMapping(value = "/constructioninfo")
            public String constructioninfoPage(){
                return "ConstructionInfo";
            }

    /**
    * 建设场所管理查询List
    * @param pageNum
    * @param pageSize
    * @return
    */
    @RequestMapping("/getConstructionInfoList")
    @ResponseBody
    public Object getConstructionInfoList(
    ConstructionInfo constructioninfo, @RequestParam(value="pageNum", defaultValue="1") Integer pageNum,
    @RequestParam(value="pageSize", defaultValue="10") Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<ConstructionInfo> constructioninfoList = constructioninfoService.getConstructionInfoList(constructioninfo);
        PageInfo pageInfo = new PageInfo(constructioninfoList);

        return pageInfo;
    }

    /**
    * 添加
    * @param
    * @return
    */
    @PostMapping("/saveConstructionInfo")
    @ResponseBody
    public Object saveConstructionInfo(ConstructionInfo constructioninfo) {

    Map<String, Object> map = new HashMap<String, Object>();
    try {
        int count = constructioninfoService.saveConstructionInfo(constructioninfo);
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
    @PostMapping("/updateConstructionInfo")
    @ResponseBody
    public Object updateOperatorInfo(ConstructionInfo constructioninfo) {

    Map<String, Object> map = new HashMap<String, Object>();

    /* 需要单独实现ID判定
    if (StringUtils.isEmpty(operatorInfo.getOperatorId())) {
        map.put("result", "OperatorIdEmpty");
        return map;
    }
    */
    try {
        int count = constructioninfoService.updateConstructionInfo(constructioninfo);
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
    @RequestMapping(value = "/delConstructionInfo")
    @ResponseBody
    public Object delOperatorInfo(ConstructionInfo constructioninfo) {

    Map<String, Object> map = new HashMap<String, Object>();
    /* 需要单独实现ID判定
    if (StringUtils.isEmpty(operatorInfo.getOperatorId())) {
        map.put("result", "OperatorIdEmpty");
        return map;
    }
    */
    try {
        int count = constructioninfoService.delConstructionInfo(constructioninfo);
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