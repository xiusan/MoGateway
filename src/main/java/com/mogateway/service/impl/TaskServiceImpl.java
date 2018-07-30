package com.mogateway.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mogateway.contans.Constants;
import com.mogateway.entity.JobAndTrigger;
import com.mogateway.entity.Task;
import com.mogateway.entity.TaskCriteria;
import com.mogateway.mapper.JobAndTriggerMapper;
import com.mogateway.mapper.TaskMapper;
import com.mogateway.redis.RedisUtil;
import com.mogateway.service.TaskService;
import com.mogateway.util.DateUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author weizheng
 * @create 2018-03-29 10:00
 * @desc 定时任务实现类
 **/
@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskMapper mapper;
    @Autowired
    private RedisUtil redisService;
    @Autowired
    private JobAndTriggerMapper jobAndTriggerMapper;



    @Override
    public PageInfo<Map<String, Object>> queryList(Task task, int pageNum, int pageSize) {


        //分页查询
        PageHelper.startPage(pageNum,pageSize);

        //查询数据库之前先查询缓存，如果有直接返回
        /**
         *
         *         try {
         //从redis中取缓存数据
         String json  = JsonUtils.objectToJson(redisService.get(Constants.RDDIS_TASK_PAGEINFO+String.valueOf(pageNum)));

         if (!StringUtils.isBlank(json) && !json.equals("null")) {
         //把json转换成对象
         PageInfo pageInfo  =  JsonUtils.jsonToPojo(json,PageInfo.class);
         return pageInfo;
         }
         } catch (Exception e) {
         e.printStackTrace();
         }
         */


        TaskCriteria example = new TaskCriteria();
        TaskCriteria.Criteria criteria = example.createCriteria();

        if (StringUtils.isNotEmpty(task.getTimedTaskName())){
            criteria.andTimedTaskNameEqualTo(task.getTimedTaskName());
        }
        example.setOrderByClause(" creadate desc ");

        List<Task> tasks = mapper.selectByExample(example);
        List list = new ArrayList<>();
        List<Map<String, Object>> taskList = new ArrayList<Map<String, Object>>();
        for (Task task1: tasks) {
            Map<String,Object> map = new HashMap<>();

            List<JobAndTrigger> jobAndTriggerList= jobAndTriggerMapper.getJobAndTriggerDetails(task1.getJobGroupName());
            if (jobAndTriggerList.size()==0){
                int count = mapper.deleteByPrimaryJobGroupName(task1.getJobGroupName());
                if (count>0){
                    continue;
                }
            }

            map.put("timedTaskId", task1.getTimedTaskId());
            map.put("timedTaskName", task1.getTimedTaskName());

            map.put("lastExecuTime",DateUtil.stampToDate(jobAndTriggerList.get(0).getPREV_FIRE_TIME()) );
            map.put("nextExecuTime", DateUtil.stampToDate(jobAndTriggerList.get(0).getNEXT_FIRE_TIME()));

            map.put("startTime", task1.getStartTime());
            map.put("stopTime", task1.getStopTime());
            map.put("taskMethod", task1.getTaskMethod());
            map.put("cronExpression", task1.getCronExpression());
            try {
                map.put("execuCount", redisService.getValue(Constants.EXECUT_COUNT+task1.getJobGroupName()));
            } catch (Exception e) {
                e.printStackTrace();
            }


            map.put("failCount",jobAndTriggerList.get(0).getMISFIRE_INSTR() );
            map.put("missCount", task1.getMissCount());
            map.put("taskStatus", task1.getTaskStatus());
            map.put("jobGroupName", task1.getJobGroupName());
            map.put("method", task1.getMethod());
            taskList.add(map);
        }


        //返回结果之前，向缓存中添加数据
        /**
         *         try {
         redisService.set(Constants.RDDIS_TASK_PAGEINFO+String.valueOf(pageNum),  new PageInfo<>(taskList));
         } catch (Exception e) {
         e.printStackTrace();
         }
         */


        return new PageInfo<>(taskList);
    }

    @Override
    public List<Task> selectByExample(Task task) {
        TaskCriteria example = new TaskCriteria();
        TaskCriteria.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotEmpty(task.getTaskMethod())){
            criteria.andTaskMethodEqualTo(task.getTaskMethod());
        }
        if (StringUtils.isNotEmpty(task.getJobGroupName())){
            criteria.andJobGroupNameEqualTo(task.getJobGroupName());
        }
        List<Task> tasks = mapper.selectByExample(example);
        return tasks;
    }

    @Override
    public int insertSelective(Task record) {
        //添加数据之前清空缓存


        return mapper.insertSelective(record);
    }

    @Override
    public Task selectByPrimaryKey(String timedTaskId) {
        return mapper.selectByPrimaryKey(timedTaskId);
    }

    @Override
    public int updateByPrimaryKeySelective(Task record) {
        //修改数据之前清空缓存


        return mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int deleteByPrimaryKey(String timedTaskId) {
        //删除数据之前清空缓存

        return mapper.deleteByPrimaryKey(timedTaskId);
    }


}
