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

import com.mogateway.entity.Shengdaojia;
import com.mogateway.service.ShengdaojiaService;


/**
* 类名称：ShengdaojiaController
* 创建人：
* 创建时间：2018-07-31
* 描   述: 添加商品信息
*/
@Controller
public class ShengdaojiaController {


    @Autowired
    private ShengdaojiaService shengdaojiaService;

    /**
    *  添加商品信息映射到Html
    * @return
    */
    @RequestMapping(value = "/shengdaojia")
            public String shengdaojiaPage(){
                return "Shengdaojia";
            }

    /**
    * 添加商品信息查询List
    * @param pageNum
    * @param pageSize
    * @return
    */
    @RequestMapping("/getShengdaojiaList")
    @ResponseBody
    public Object getShengdaojiaList(
    Shengdaojia shengdaojia, @RequestParam(value="pageNum", defaultValue="1") Integer pageNum,
    @RequestParam(value="pageSize", defaultValue="10") Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Shengdaojia> shengdaojiaList = shengdaojiaService.getShengdaojiaList(shengdaojia);
        PageInfo pageInfo = new PageInfo(shengdaojiaList);

        return pageInfo;
    }

    /**
    * 添加
    * @param
    * @return
    */
    @PostMapping("/saveShengdaojia")
    @ResponseBody
    public Object saveShengdaojia(Shengdaojia shengdaojia) {

    Map<String, Object> map = new HashMap<String, Object>();
    try {
        int count = shengdaojiaService.saveShengdaojia(shengdaojia);
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
    @PostMapping("/updateShengdaojia")
    @ResponseBody
    public Object updateOperatorInfo(Shengdaojia shengdaojia) {

    Map<String, Object> map = new HashMap<String, Object>();

    /* 需要单独实现ID判定
    if (StringUtils.isEmpty(operatorInfo.getOperatorId())) {
        map.put("result", "OperatorIdEmpty");
        return map;
    }
    */
    try {
        int count = shengdaojiaService.updateShengdaojia(shengdaojia);
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
    @RequestMapping(value = "/delShengdaojia")
    @ResponseBody
    public Object delOperatorInfo(Shengdaojia shengdaojia) {

    Map<String, Object> map = new HashMap<String, Object>();
    /* 需要单独实现ID判定
    if (StringUtils.isEmpty(operatorInfo.getOperatorId())) {
        map.put("result", "OperatorIdEmpty");
        return map;
    }
    */
    try {
        int count = shengdaojiaService.delShengdaojia(shengdaojia);
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