package com.mogateway.mapper;

import com.mogateway.entity.Task;
import com.mogateway.entity.TaskCriteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TaskMapper {



    long countByExample(TaskCriteria example);

    int deleteByExample(TaskCriteria example);

    int deleteByPrimaryKey(String timedTaskId);

    int deleteByPrimaryJobGroupName(String jobGroupName);

    int insert(Task record);

    int insertSelective(Task record);

    List<Task> selectByExample(TaskCriteria example);

    Task selectByPrimaryKey(String timedTaskId);

    int updateByExampleSelective(@Param("record") Task record, @Param("example") TaskCriteria example);

    int updateByExample(@Param("record") Task record, @Param("example") TaskCriteria example);

    int updateByPrimaryKeySelective(Task record);

    int updateByPrimaryKey(Task record);
}