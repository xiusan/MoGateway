package com.mogateway.controller;

import com.mogateway.entity.CharingConnectorType;
import com.mogateway.entity.EquipmentType;
import com.mogateway.redis.RedisUtil;
import com.mogateway.service.CharingConnectorTypeService;
import com.mogateway.service.EquipmentTypeService;
import com.mogateway.util.CommonUtils;
import com.mogateway.util.ErrorCode;
import com.mogateway.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author weizheng
 * @create 2018-07-11 12:00
 * @desc 充电设备接口类型
 **/
@Api(value="CharingConnectorTypeController", description ="充电设备接口类型接口")
@RestController
@RequestMapping(value="/charingConnectorType")
public class CharingConnectorTypeController {
    private static Logger logger = Logger.getLogger(CharingConnectorTypeController.class);

    @Autowired
    private CharingConnectorTypeService charingConnectorTypeService;

    @Autowired
    private RedisUtil redisUtil;


    @ApiOperation(value = "充电设备接口类型列表", notes = "充电设备接口类型列表")
    @RequestMapping(value="/getCharingConnectorTypeList", method= RequestMethod.POST)
    public Result getCharingConnectorTypeList(CharingConnectorType charingConnectorType) {
        Result res = new Result();
        Map<String,Object> map = new HashMap<>();
        try{
            List<CharingConnectorType> charingConnectorTypes = charingConnectorTypeService.getCharingConnectorTypeList(charingConnectorType);
            map.put("charingConnectorTypes",charingConnectorTypes);
            res.addSuccess(map);
        }catch (Exception e){
            redisUtil.pubLog("CharingConnectorTypeManage", "充电设备接口类型", "admin", CommonUtils.exception2Str(e));
            res.addError(ErrorCode.SYS40005,ErrorCode.SYS40005_INFO);
        }
        return res;
    }

}
