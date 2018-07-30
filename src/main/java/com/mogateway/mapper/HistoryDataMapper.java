package com.mogateway.mapper;

import com.mogateway.entity.HistoryData;
import com.mogateway.entity.HistoryDataCriteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface HistoryDataMapper {
    long countByExample(HistoryDataCriteria example);

    int deleteByExample(HistoryDataCriteria example);

    int deleteByPrimaryKey(String historyId);

    int insert(HistoryData record);

    int insertSelective(HistoryData record);

    List<HistoryData> selectByExample(HistoryDataCriteria example);

    HistoryData selectByPrimaryKey(String historyId);

    int updateByExampleSelective(@Param("record") HistoryData record, @Param("example") HistoryDataCriteria example);

    int updateByExample(@Param("record") HistoryData record, @Param("example") HistoryDataCriteria example);

    int updateByPrimaryKeySelective(HistoryData record);

    int updateByPrimaryKey(HistoryData record);
}