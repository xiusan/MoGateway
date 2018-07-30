package com.mogateway.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mogateway.entity.OperatorInfo;
import com.mogateway.service.OperatorInfoService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xiaojinlu on 2018-07-11.
 * 描   述: 运营管理 运营厂商
 **/
@Controller
public class OperatorInfoController {


    @Autowired
    private OperatorInfoService operatorInfoService;

    /**
     * 诊断历史映射到Html
     * @return
     */
    @RequestMapping(value = "/operatorInfo")
    public String operatorInfoPage(){
        return "operatorInfo";
    }

    /**
     * 查询运营厂商List
     * @param operatorInfo
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping("/getOperatorInfoList")
    @ResponseBody
    public Object getOperatorInfoList(
            OperatorInfo operatorInfo, @RequestParam(value="pageNum", defaultValue="1") Integer pageNum,
            @RequestParam(value="pageSize", defaultValue="10") Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<OperatorInfo> operatorInfoList = operatorInfoService.getOperatorInfoList(operatorInfo);
        PageInfo pageInfo = new PageInfo(operatorInfoList);

        return pageInfo;
    }

    /**
     * 添加运营厂商
     * @param operatorInfo
     * @return
     */
    @PostMapping("/saveOperatorInfo")
    @ResponseBody
    public Object saveOperatorInfo(OperatorInfo operatorInfo) {

        Map<String, Object> map = new HashMap<String, Object>();

        /*if (StringUtils.isEmpty(equipment.getEquipmentID())) {
            map.put("result", "EquipmentIDEmpty");
            return map;
        }*/

        try {
            //equipment.setCreateUser(Tools.getUser(redisTemplate));
            //equipment.setUpdateUser(Tools.getUser(redisTemplate));
            int count = operatorInfoService.saveOperatorInfo(operatorInfo);
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
     * 更新运营厂商
     * @param operatorInfo
     * @return
     */
    @PostMapping("/updateOperatorInfo")
    @ResponseBody
    public Object updateOperatorInfo(OperatorInfo operatorInfo) {

        Map<String, Object> map = new HashMap<String, Object>();

        if (StringUtils.isEmpty(operatorInfo.getOperatorId())) {
            map.put("result", "OperatorIdEmpty");
            return map;
        }
        try {
            //equipment.setUpdateUser(Tools.getUser(redisTemplate));
            int count = operatorInfoService.updateOperatorInfo(operatorInfo);
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
     * 删除运营厂商
     * @param operatorInfo
     * @return
     */
    @RequestMapping(value = "/delOperatorInfo")
    @ResponseBody
    public Object delOperatorInfo(OperatorInfo operatorInfo) {

        Map<String, Object> map = new HashMap<String, Object>();
        if (StringUtils.isEmpty(operatorInfo.getOperatorId())) {
            map.put("result", "OperatorIdEmpty");
            return map;
        }
        try {
            int count = operatorInfoService.delOperatorInfo(operatorInfo);
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