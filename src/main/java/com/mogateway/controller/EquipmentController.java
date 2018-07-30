package com.mogateway.controller;

import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageInfo;
import com.mogateway.entity.Ammeter;
import com.mogateway.entity.Chargingstation;
import com.mogateway.entity.Equipment;
import com.mogateway.redis.RedisUtil;
import com.mogateway.service.ChargingstationService;
import com.mogateway.service.EquipmentService;
import com.mogateway.util.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Api(value="EquipmentController", description ="设备管理接口")
@RestController
@RequestMapping(value="/equipment")
public class EquipmentController {


    @Autowired
    private EquipmentService equipmentService;
    @Autowired
    private ChargingstationService chargingstationService;
    @Autowired
    private RedisUtil redisUtil;

    @ApiOperation(value = "获取设备详细信息", notes = "根据url的id来获取设备详细信息")
    @RequestMapping(value="/{equipmentid}", method= RequestMethod.POST)
    public Result getEquipmentInfo(@PathVariable String equipmentid) {

        redisUtil.pubLog("EquipmentManage", "设备管理", "admin", "获取设备详细信息开始");

        Result res = new Result();
        if (StringUtils.isEmpty(equipmentid)){
            redisUtil.pubLog("EquipmentManage", "设备管理", "admin", "id为空");
            res.addError(ErrorCode.PUB10001,ErrorCode.PUB10001_INFO);
            return res;
        }
        try{
            Equipment equipment = equipmentService.selectByPrimaryKey(equipmentid);
            if (equipment!=null){
                res.addSuccess(equipment);
                redisUtil.pubLog("EquipmentManage", "设备管理", "admin", "获取设备详细信息成功");
                return res;
            }else {
                redisUtil.pubLog("EquipmentManage", "设备管理", "admin", "获取设备详细信息失败");
                res.addError(ErrorCode.PUB10000,ErrorCode.PUB10000_INFO);
                return res;
            }
        }catch (Exception e){
            redisUtil.pubLog("EquipmentManage", "设备管理", "admin", CommonUtils.exception2Str(e));
            res.addError(ErrorCode.SYS40005,ErrorCode.SYS40005_INFO);
        }
        return res;
    }


    @ApiOperation(value = "获取设备列表信息", notes = "获取设备列表信息")
    @ApiImplicitParams({
            @ApiImplicitParam(  paramType = "body", dataType = "MessageParam", name = "pageNumber", value = "当前页"),
            @ApiImplicitParam(  paramType = "body", dataType = "MessageParam", name = "pageSize", value = "每页条数"),
            @ApiImplicitParam(  paramType = "body", dataType = "MessageParam", name = "sortColumnsName", value = "要排序的列名"),
            @ApiImplicitParam(  paramType = "body", dataType = "MessageParam", name = "sortOrder", value = "排位命令（ desc or asc ）")
    })
    @RequestMapping(value="/equipmentList", method= RequestMethod.POST)
    public Result equipmentList(Equipment equipment,
                         @RequestParam(required = false, defaultValue = "1") int pageNumber,
                         @RequestParam(required = false, defaultValue = "100") int pageSize,
                         @RequestParam(required = false, defaultValue = "") String sortColumnsName,
                         @RequestParam(required = false, defaultValue = "") String sortOrder)
                        {
        Result res = new Result();
        Map<String,Object> map = new HashMap<>();
        try {
            PageInfo<Equipment> pageInfo = equipmentService.queryList(equipment,pageNumber,pageSize,sortColumnsName,sortOrder);
            if (pageInfo!=null){
                map.put("recordsTotal",pageInfo.getTotal());
                map.put("recordsFiltered",pageInfo.getTotal());
                map.put("list", pageInfo.getList());
                res.addSuccess(map);
            }else {
                redisUtil.pubLog("EquipmentManage", "设备管理", "admin", "获取设备列表失败");
                res.addError(ErrorCode.PUB10000,ErrorCode.PUB10000_INFO);
            }

        } catch (Exception e) {
            redisUtil.pubLog("EquipmentManage", "设备管理", "admin", CommonUtils.exception2Str(e));
            res.addError(ErrorCode.SYS40005,ErrorCode.SYS40005_INFO);
        }
        return res;
    }

    @ApiOperation(value = "修改设备信息", notes = "修改设备信息")
    @RequestMapping(value="/putEquipment", method= RequestMethod.POST)
    public Result putEquipment(Equipment equipment, @RequestParam(required = false, defaultValue = "")String idArray){
        redisUtil.pubLog("EquipmentManage", "设备管理", "admin", "修改设备信息开始");
        Result res = new Result();
        try {
                JSONArray json = JSONArray.parseArray(idArray);
                Object[] jsonArray =  json.toArray();
              for (int i=0;i<jsonArray.length;i++){
                  //equipment.setActive(true);
                  equipment.setEquipmentId(jsonArray[i].toString());
                  int count = equipmentService.updateByPrimaryKeySelective(equipment);
                  if (count > 0){
                      res.addSuccess(0);
                      redisUtil.pubLog("EquipmentManage", "设备管理", "admin", "修改设备信息成功");
                  }else {
                      res.addError(ErrorCode.PUB10002,ErrorCode.PUB10002_INFO);
                      redisUtil.pubLog("EquipmentManage", "设备管理", "admin", "修改设备信息失败");
                  }
              }
            return res;
        } catch (Exception e) {
            redisUtil.pubLog("EquipmentManage", "设备管理", "admin", CommonUtils.exception2Str(e));
            res.addError(ErrorCode.SYS40003,ErrorCode.SYS40003_INFO);
        }
        return res;
    }

    @ApiOperation(value = "添加设备信息", notes = "添加设备信息")
    @ApiImplicitParams({
            @ApiImplicitParam(  paramType = "body", dataType = "MessageParam", name = "count", value = "数量"),
            @ApiImplicitParam(  paramType = "body", dataType = "MessageParam", name = "equNo", value = "设备号"),
            @ApiImplicitParam(  paramType = "body", dataType = "MessageParam", name = "qeuName", value = "设备名称"),
            @ApiImplicitParam(  paramType = "body", dataType = "MessageParam", name = "manufacturerdttm_time", value = "生产日期"),
            @ApiImplicitParam(  paramType = "body", dataType = "MessageParam", name = "deliverydttm_time", value = "投运日期")
    })
    @RequestMapping(value="/addEquipment", method= RequestMethod.POST)
    public Result addEquipment(Equipment equipment,
                               @RequestParam(required = false, defaultValue = "1")int count,
                               //long equNo,
                               String equNo,
                               String equName,
                               String manufacturerdttm_time,
                               String deliverydttm_time){
        redisUtil.pubLog("EquipmentManage", "设备管理", "admin", "添加设备信息开始");
        Result res = new Result();
        try {
            Equipment equipment1= equipmentService.selectByNo(equNo);
            if (equipment1!=null){
                res.addError("1001","已经添加过该设备");
                return res;
            }

            String regEx="[^0-9]";
            Pattern p = Pattern.compile(regEx);
            Matcher m = p.matcher(equName);
            //System.out.print("--------------name-------------------"+m.replaceAll("").trim());
            long equNameCount = Long.valueOf(m.replaceAll("").trim());

                for (int i = 0; i <count; i++){
                    //equipment.setEquipmentId(OrderUtils.getOrderNo());
                    equipment.setEquipmentId(equNo);
                    equipment.setEquipmentNo(equNo);
                    String equipmentName= String.valueOf(equNameCount);
                    equipment.setEquipmentName(equipmentName+"#充电桩");
                    Chargingstation chargingstation = new Chargingstation();

                    List<Chargingstation> chargingstations = chargingstationService.selectByExample(chargingstation);
                    equipment.setChargingStationId(chargingstations.get(0).getChargingStationId());

                    equipment.setActive(true);
                    equipment.setManufacturerDttm(DateUtil.praseString2Date(manufacturerdttm_time));
                    equipment.setDeliveryDttm(DateUtil.praseString2Date(deliverydttm_time));
                    int num = equipmentService.insertSelective(equipment);
                    //equNo++;
                    equNameCount++;
                    if (num > 0){
                        res.addSuccess(0);
                        redisUtil.pubLog("EquipmentManage", "设备管理", "admin", "添加设备信息成功");
                    }
                }

            return res;
        } catch (Exception e) {
            redisUtil.pubLog("EquipmentManage", "设备管理", "admin", CommonUtils.exception2Str(e));
            res.addError(ErrorCode.SYS40002,ErrorCode.SYS40002_INFO);
        }
        return res;
    }


    @ApiOperation(value = "电表列表", notes = "电表列表")
    @RequestMapping(value="/ammters", method= RequestMethod.POST)
    public Result ammters() {
        Result res = new Result();
        Map<String,Object> map = new HashMap<>();
        try {
            Ammeter ammeter = new Ammeter();
            List<Ammeter> ammeters = equipmentService.selectAmmeterByExample(ammeter);
            map.put("ammeters", ammeters);
            res.addSuccess(map);

        } catch (Exception e) {
            redisUtil.pubLog("EquipmentManage", "设备管理", "admin", CommonUtils.exception2Str(e));
            res.addError(ErrorCode.SYS40005,ErrorCode.SYS40005_INFO);
        }
        return res;
    }

    @ApiOperation(value = "充电站列表", notes = "充电站列表")
    @RequestMapping(value="/chargingstations", method= RequestMethod.POST)
    public Result chargingstations(Chargingstation chargingstation) {
        Result res = new Result();
        Map<String,Object> map = new HashMap<>();
        try {
            List<Chargingstation> chargingstations = chargingstationService.selectByExample(chargingstation);
            map.put("chargingstations", chargingstations);
            res.addSuccess(map);
        } catch (Exception e) {
            redisUtil.pubLog("EquipmentManage", "设备管理", "admin", CommonUtils.exception2Str(e));
            res.addError(ErrorCode.SYS40005,ErrorCode.SYS40005_INFO);
        }
        return res;
    }

}
