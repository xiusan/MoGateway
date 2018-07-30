package com.mogateway.mapper;

import com.mogateway.entity.RealTime;
import com.mogateway.entity.RealTimeCriteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RealTimeMapper {
    long countByExample(RealTimeCriteria example);

    int deleteByExample(RealTimeCriteria example);

    int deleteByPrimaryKey(String equipmentNo);

    int insert(RealTime record);

    int insertSelective(RealTime record);

    List<RealTime> selectByExample(RealTimeCriteria example);

    RealTime selectByPrimaryKey(String equipmentNo);

    RealTime selectByNo(String equipmentNo);

    int updateByExampleSelective(@Param("record") RealTime record, @Param("example") RealTimeCriteria example);

    int updateByExample(@Param("record") RealTime record, @Param("example") RealTimeCriteria example);

    int updateByPrimaryKeySelective(RealTime record);

    int updateByPrimaryKey(RealTime record);
}