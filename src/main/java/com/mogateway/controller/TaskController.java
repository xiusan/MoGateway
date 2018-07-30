package com.mogateway.controller;

import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageInfo;
import com.mogateway.entity.Task;
import com.mogateway.redis.RedisUtil;
import com.mogateway.service.IJobAndTriggerService;
import com.mogateway.service.TaskService;
import com.mogateway.util.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author weizheng
 * @create 2018-03-29 10:17
 * @desc 定时任务管理接口
 **/
@Api(value="TaskController", description="定时任务管理接口")
@RestController
@RequestMapping(value = "/task")
public class TaskController {

    @Autowired
    private TaskService taskService;
    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private IJobAndTriggerService jobAndTriggerService;

    @ApiOperation(value = "定时任务详细信息", notes = "定时任务详细信息")
    @RequestMapping(value="/{timedTaskId}", method= RequestMethod.POST)
    public Result getTaskInfo(@PathVariable String timedTaskId) {
        Result res = new Result();
        if (StringUtils.isEmpty(timedTaskId)){
            res.addError("DS1001","timedTaskId为空");
            redisUtil.pubLog("TaskManage", "定时任务管理", "admin", "timedTaskId为空");
            return res;
        }
        try{
            Task task = taskService.selectByPrimaryKey(timedTaskId);
            res.addSuccess(task);
            redisUtil.pubLog("TaskManage", "定时任务管理", "admin", "定时任务详细信息成功");
        }catch (Exception e){
            redisUtil.pubLog("TaskManage", "定时任务管理", "admin", CommonUtils.exception2Str(e));
            res.addError(ErrorCode.SYS40005,ErrorCode.SYS40005_INFO);
        }
        return res;
    }

    @ApiOperation(value = "获取定时任务列表信息", notes = "获取定时任务列表信息")
    @ApiImplicitParams({
            @ApiImplicitParam(  paramType = "body", dataType = "MessageParam", name = "pageNum", value = "当前页"),
            @ApiImplicitParam(  paramType = "body", dataType = "MessageParam", name = "pageSize", value = "每页条数")
    })
    @RequestMapping("/taskList")
    public Result taskList(Task task,
                           @RequestParam(required = false,defaultValue = "1") int pageNum,
                           @RequestParam(required = false,defaultValue = "100")int pageSize
                           ){
        Result res = new Result();
        Map<String,Object> map = new HashMap<>();
        try{
            PageInfo pageInfo = taskService.queryList(task,pageNum,pageSize);
            map.put("recordsTotal",pageInfo.getTotal());

            map.put("list",pageInfo.getList());
            res.addSuccess(map);
            redisUtil.pubLog("TaskManage", "定时任务管理", "admin", "获取定时任务列表信息成功");
        }catch (Exception e){
            redisUtil.pubLog("TaskManage", "定时任务管理", "admin", CommonUtils.exception2Str(e));
            res.addError(ErrorCode.SYS40005,ErrorCode.SYS40005_INFO);
        }
        return res;
    }

    @ApiOperation(value = "添加定时任务", notes = "添加定时任务")
    @ApiImplicitParams({
            @ApiImplicitParam(  paramType = "body", dataType = "MessageParam", name = "timedTaskName", value = "任务名称"),
            @ApiImplicitParam(  paramType = "body", dataType = "MessageParam", name = "cycle", value = "周期  0：一次性；1：周期性"),
            @ApiImplicitParam(  paramType = "body", dataType = "MessageParam", name = "startDateTime", value = "开始时间"),
            @ApiImplicitParam(  paramType = "body", dataType = "MessageParam", name = "execuCycle", value = "执行周期"),
            @ApiImplicitParam(  paramType = "body", dataType = "MessageParam", name = "stopDateTime", value = "过期时间"),
            @ApiImplicitParam(  paramType = "body", dataType = "MessageParam", name = "taskMethod", value = "任务方法")
    })
    @RequestMapping(value="/addTask", method= RequestMethod.POST)
    @Transactional
    public Result addTask(Task task,
                          String startDateTime,
                          String stopDateTime){
        redisUtil.pubLog("TaskManage", "定时任务管理", "admin", "添加定时任务开始");
        Result res = new Result();
        try {
            /**
             *             List<Task> taskList = taskService.selectByExample(task);
             if (taskList.size()!=0){
             res.addError("TASK1001","已添加过该定时方法"+task.getTaskMethod()+"，请重新添加");
             redisUtil.pubLog("TaskManage", "定时任务管理", "admin", "已添加过该定时方法"+task.getTaskMethod()+"，请重新添加");
             return res;
             }
             */
            if (StringUtils.isNotEmpty(startDateTime)){
                task.setStartTime(DateUtil.praseString2LongDate(startDateTime));
            }
            if (StringUtils.isNotEmpty(stopDateTime)){
                task.setStopTime(DateUtil.praseString2LongDate(stopDateTime));
            }
            task.setTimedTaskId(OrderUtils.getOrderNo());


            task.setCreadate(new Date());
            task.setJobGroupName(OrderUtils.getOrderNo());
            //task.setCreateUserId("");
            task.setTaskStatus(1);
            task.setTaskMethod("com.mogateway.quartzJob.ExecutJob");
            res = jobAndTriggerService.addJob(task);
            redisUtil.pubLog("TaskManage", "定时任务管理", "admin", "添加定时任务成功");
        } catch (Exception e) {
            redisUtil.pubLog("TaskManage", "定时任务管理", "admin", CommonUtils.exception2Str(e));
            res.addError(ErrorCode.SYS40002,ErrorCode.SYS40002_INFO);
            return res;
        }
        return res;
    }



    @ApiOperation(value = "修改定时任务信息", notes = "修改定时任务信息")
    @RequestMapping(value="/putTask", method= RequestMethod.POST)
    public Result putTask(Task task, String startDateTime,
                          String stopDateTime){
        redisUtil.pubLog("TaskManage", "定时任务管理", "admin", "修改定时任务开始");
        Result res = new Result();
        try {

            if (StringUtils.isNotEmpty(startDateTime)){
                task.setStartTime(DateUtil.praseString2LongDate(startDateTime));
            }
            if (StringUtils.isNotEmpty(stopDateTime)){
                task.setStopTime(DateUtil.praseString2LongDate(stopDateTime));
            }

            //jobAndTriggerService.jobreschedule(task);
            jobAndTriggerService.jobdelete(task);
            task.setCreadate(new Date());
            task.setJobGroupName(OrderUtils.getOrderNo());
            task.setCreateUserId("");
            task.setTaskStatus(1);
            task.setTaskMethod("com.mogateway.quartzJob.ExecutJob");
            jobAndTriggerService.addJob(task);
            redisUtil.pubLog("TaskManage", "定时任务管理", "admin", "修改定时任务成功");
            res.addSuccess(null);
        } catch (Exception e) {
            redisUtil.pubLog("TaskManage", "定时任务管理", "admin", CommonUtils.exception2Str(e));
            res.addError(ErrorCode.SYS40003,ErrorCode.SYS40003_INFO);
            return res;
        }
        return res;
    }



    @ApiOperation(value = "删除定时任务", notes = "删除定时任务")
    @RequestMapping(value="/delTask", method= RequestMethod.POST)
    public Result delTask(@RequestParam(required = false, defaultValue = "")String idArray){
        redisUtil.pubLog("TaskManage", "定时任务管理", "admin", "删除定时任务开始");
        Result res = new Result();
        try {
            JSONArray json = JSONArray.parseArray(idArray);
            Object[] jsonArray =  json.toArray();
            for (int i=0;i<jsonArray.length;i++){
                Task task = taskService.selectByPrimaryKey(jsonArray[i].toString());
                jobAndTriggerService.jobdelete(task);
                res.addSuccess(null);
                redisUtil.pubLog("TaskManage", "定时任务管理", "admin", "删除定时任务成功");
            }
            res.addSuccess(0);
            return res;
        } catch (Exception e) {
            redisUtil.pubLog("TaskManage", "定时任务管理", "admin", CommonUtils.exception2Str(e));
            res.addError(ErrorCode.SYS40004,ErrorCode.SYS40004_INFO);
        }
        return res;
    }





    @ApiOperation(value = "暂停/恢复  定时任务", notes = "暂停/恢复 定时任务")
    @ApiImplicitParams({
            @ApiImplicitParam(  paramType = "body", dataType = "MessageParam", name = "idArray", value = "timedTaskId id数组"),
            @ApiImplicitParam(  paramType = "body", dataType = "MessageParam", name = "taskStatus", value = "任务状态：0已禁用；1：运行中； 2：过期； 3：等待中; "),
    })
    @RequestMapping(value="/putTaskStatus", method= RequestMethod.POST)
    public Result putTaskStatus(Task task,
                                @RequestParam(required = false, defaultValue = "")String idArray,
                                @RequestParam int taskStatus){
        redisUtil.pubLog("TaskManage", "定时任务管理", "admin", "暂停/恢复 定时任务开始");
        Result res = new Result();
        try {
            JSONArray json = JSONArray.parseArray(idArray);
            Object[] jsonArray =  json.toArray();
            for (int i=0;i<jsonArray.length;i++){
                task.setTimedTaskId(jsonArray[i].toString());
                //task.setTaskStatus(taskStatus);
                task = taskService.selectByPrimaryKey(jsonArray[i].toString());
                if (taskStatus == 1){//恢复
                    task.setTaskStatus(0);
                    jobAndTriggerService.jobPause(task);
                    redisUtil.pubLog("TaskManage", "定时任务管理", "admin", "恢复 定时任务开始");
                }
                if (taskStatus == 0){//暂停
                    task.setTaskStatus(1);
                    jobAndTriggerService.jobresume(task);
                    redisUtil.pubLog("TaskManage", "定时任务管理", "admin", "暂停 定时任务开始");
                }

            }
            res.addSuccess(0);
            return res;
        } catch (Exception e) {
            redisUtil.pubLog("TaskManage", "定时任务管理", "admin", CommonUtils.exception2Str(e));
            res.addError(ErrorCode.SYS40003,ErrorCode.SYS40003_INFO);
        }
        return res;
    }





}
