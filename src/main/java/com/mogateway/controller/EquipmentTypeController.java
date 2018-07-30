package com.mogateway.controller;

import com.mogateway.entity.Equipment;
import com.mogateway.entity.EquipmentType;
import com.mogateway.redis.RedisUtil;
import com.mogateway.service.EquipmentTypeService;
import com.mogateway.util.CommonUtils;
import com.mogateway.util.ErrorCode;
import com.mogateway.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author weizheng
 * @create 2018-07-11 12:00
 * @desc 设备类型
 **/
@Api(value="EquipmentTypeController", description ="设备类型接口")
@RestController
@RequestMapping(value="/equipmentType")
public class EquipmentTypeController {
    private static Logger logger = Logger.getLogger(EquipmentTypeController.class);

    @Autowired
    private EquipmentTypeService equipmentTypeService;

    @Autowired
    private RedisUtil redisUtil;


    @ApiOperation(value = "获取设备类型列表", notes = "获取设备类型列表")
    @RequestMapping(value="/getEquipmentTypeList", method= RequestMethod.POST)
    public Result getEquipmentTypeList(EquipmentType equipmentType) {
        Result res = new Result();
        Map<String,Object> map = new HashMap<>();
        try{
            List<EquipmentType> equipmentTypes = equipmentTypeService.getEquipmentTypeList(equipmentType);
            map.put("equipmentTypes",equipmentTypes);
            res.addSuccess(map);
        }catch (Exception e){
            redisUtil.pubLog("EquipmentTypeManage", "设备类型", "admin", CommonUtils.exception2Str(e));
            res.addError(ErrorCode.SYS40005,ErrorCode.SYS40005_INFO);
        }
        return res;
    }

}
