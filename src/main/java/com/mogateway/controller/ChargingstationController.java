package com.mogateway.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mogateway.entity.ChargingstationRewrite;
import com.mogateway.service.ChargingstationRewriteService;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xiaojinlu on 2018/7/12.
 */

@Controller
public class ChargingstationController {

    private static Logger logger = Logger.getLogger(ChargingstationController.class);

    @Autowired
    private ChargingstationRewriteService chargingstationRewriteService;


    /**
     * 诊断历史映射到Html
     * @return
     */
    @RequestMapping(value = "/chargingstation")
    public String operatorInfoPage(){
        return "chargingstation";
    }

    /**
     * 查询运营厂商List
     * @param chargingstation
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping("/getChargingstationfoList")
    @ResponseBody
    public Object getOperatorInfoList(
            ChargingstationRewrite chargingstation, @RequestParam(value="pageNum", defaultValue="1") Integer pageNum,
            @RequestParam(value="pageSize", defaultValue="10") Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<ChargingstationRewrite> chargingstationList = chargingstationRewriteService.getChargingstationList(chargingstation);
        PageInfo pageInfo = new PageInfo(chargingstationList);

        return pageInfo;
    }

    /**
     * 添加充电站
     * @param chargingstation
     * @return
     */
    @PostMapping("/saveChargingstation")
    @ResponseBody
    public Object saveChargingstation(ChargingstationRewrite chargingstation) {

        Map<String, Object> map = new HashMap<String, Object>();

        /*if (StringUtils.isEmpty(equipment.getEquipmentID())) {
            map.put("result", "EquipmentIDEmpty");
            return map;
        }*/

        try {
            int count = chargingstationRewriteService.saveChargingstation(chargingstation);
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
     * 更新充电站
     * @param chargingstation
     * @return
     */
    @PostMapping("/updateChargingstation")
    @ResponseBody
    public Object updateChargingstation(ChargingstationRewrite chargingstation) {

        Map<String, Object> map = new HashMap<String, Object>();

        if (StringUtils.isEmpty(chargingstation.getChargingStationId())) {
            map.put("result", "OperatorIdEmpty");
            return map;
        }
        try {
            //equipment.setUpdateUser(Tools.getUser(redisTemplate));
            int count = chargingstationRewriteService.updateChargingstation(chargingstation);
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
     * @param chargingstation
     * @return
     */
    @RequestMapping(value = "/delChargingstation")
    @ResponseBody
    public Object delChargingstation(ChargingstationRewrite chargingstation) {

        Map<String, Object> map = new HashMap<String, Object>();
        if (StringUtils.isEmpty(chargingstation.getChargingStationId())) {
            map.put("result", "OperatorIdEmpty");
            return map;
        }
        try {
            int count = chargingstationRewriteService.delChargingstation(chargingstation);
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



    /**
     * 获取下来框的id名称
     * @param chargingstation  keyId 1 运营商表 2站点类型表  3站点状态表  4 建设场所表
     * @return
     */
    @RequestMapping("/getSelectChargingstation")
    @ResponseBody
    public List<Object> getChargingstation(ChargingstationRewrite chargingstation) {
        List<Object> list = new ArrayList<Object>();
        try {
            List<ChargingstationRewrite> chargingstationList = chargingstationRewriteService.getSelectList(chargingstation);
            for (ChargingstationRewrite chargingstationTemp : chargingstationList) {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("keyId", chargingstationTemp.getKeyId());
                map.put("valueName", chargingstationTemp.getValueName());
                list.add(map);
            }
        } catch (Exception e) {
            logger.error("下拉列表-查询异常:" + e.getMessage());
        }

        return list;
    }

}
