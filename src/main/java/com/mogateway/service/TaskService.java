package com.mogateway.service;

import com.github.pagehelper.PageInfo;
import com.mogateway.entity.Task;
import com.mogateway.entity.TaskCriteria;

import java.util.List;
import java.util.Map;

/**
 * @author weizheng
 * @create 2018-03-29 9:57
 * @desc 定时任务
 **/
public interface TaskService {

    /**
     * 查询设备数据集合
     * @param task
     * @return
     */
    PageInfo<Map<String, Object>> queryList(Task task, int pageNum, int pageSize);

    /**
     * 查询设备数据集合
     * @param task
     * @return
     */
    List<Task> selectByExample(Task task);

    /**
     * 添加定时任务
     * @param record
     * @return
     */
    int insertSelective(Task record);

    /**
     * 查询定时任务详情
     * @param timedTaskId
     * @return
     */
    Task selectByPrimaryKey(String timedTaskId);

    /**
     * 修改定时任务
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Task record);

    /**
     * 删除定时任务
     * @param timedTaskId
     * @return
     */
    int deleteByPrimaryKey(String timedTaskId);

}
