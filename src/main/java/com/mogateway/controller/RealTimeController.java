package com.mogateway.controller;

import com.github.pagehelper.PageInfo;
import com.mogateway.contans.Constants;
import com.mogateway.entity.RealTime;
import com.mogateway.redis.RedisUtil;
import com.mogateway.service.RealTimeService;
import com.mogateway.util.CommonUtils;
import com.mogateway.util.ErrorCode;
import com.mogateway.util.JsonUtils;
import com.mogateway.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author weizheng
 * @create 2018-04-04 11:57
 * @desc 实时状态
 **/
@Api(value="RealTimeController", description="实时状态接口")
@RestController
@RequestMapping(value="/realTime")
public class RealTimeController {


    @Autowired
    private RealTimeService realTimeService;

    @Autowired
    private RedisUtil redisUtil;

    @ApiOperation(value = "实时状态列表信息", notes = "实时状态列表信息")
    @ApiImplicitParams({
            @ApiImplicitParam(  paramType = "body", dataType = "MessageParam", name = "pageNumber", value = "当前页"),
            @ApiImplicitParam(  paramType = "body", dataType = "MessageParam", name = "pageSize", value = "每页条数"),
    })
    @RequestMapping(value="/realTimeList", method= RequestMethod.POST)
    public Result RealTimeList(String equipmentNo, String communicateStatus, String workStatus,
                               @RequestParam(required = false, defaultValue = "1") int pageNumber,
                               @RequestParam(required = false, defaultValue = "100") int pageSize)
    {
        Result res = new Result();
        Map<String,Object> map = new HashMap<>();
        map.put("equipmentNo",equipmentNo);
        map.put("communicateStatus",communicateStatus);
        map.put("workStatus",workStatus);
        try {
            PageInfo<RealTime> pageInfo = realTimeService.queryList(map,pageNumber,pageSize);
            //System.out.println("pageInfo.getTotal():"+pageInfo.getTotal());
            map.put("recordsTotal",pageInfo.getTotal());
            map.put("recordsFiltered",pageInfo.getTotal());
            map.put("list", pageInfo.getList());
            res.addSuccess(map);
        } catch (Exception e) {
            redisUtil.pubLog("RealTimeManage", "实时状态管理", "admin", CommonUtils.exception2Str(e));
            res.addError(ErrorCode.SYS40005,ErrorCode.SYS40005_INFO);
        }
        return res;
    }


    @ApiOperation(value = "实时状态列表信息", notes = "实时状态列表信息")
    @RequestMapping(value="/TestRealTimeList", method= RequestMethod.POST)
    public Result TestRealTimeList()
    {
        Result res = new Result();
        try {
            RealTime realTime = new RealTime();
            res.addSuccess(realTimeService.queryList1(realTime));
        } catch (Exception e) {
            redisUtil.pubLog("RealTimeManage", "实时状态管理", "admin", CommonUtils.exception2Str(e));
            res.addError(ErrorCode.SYS40005,ErrorCode.SYS40005_INFO);
        }
        return res;
    }



}
