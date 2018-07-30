package com.mogateway.mapper;

import com.mogateway.entity.DataManagerRealTime;
import com.mogateway.entity.DataManagerRealTimeCriteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DataManagerRealTimeMapper {
    long countByExample(DataManagerRealTimeCriteria example);

    int deleteByExample(DataManagerRealTimeCriteria example);

    int deleteByPrimaryKey(String id);

    int deleteTable();

    int insert(DataManagerRealTime record);

    int insertSelective(DataManagerRealTime record);

    List<DataManagerRealTime> selectByExample(DataManagerRealTimeCriteria example);

    DataManagerRealTime selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") DataManagerRealTime record, @Param("example") DataManagerRealTimeCriteria example);

    int updateByExample(@Param("record") DataManagerRealTime record, @Param("example") DataManagerRealTimeCriteria example);

    int updateByPrimaryKeySelective(DataManagerRealTime record);

    int updateByPrimaryKey(DataManagerRealTime record);
}