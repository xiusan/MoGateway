package com.mogateway.mapper;

import com.mogateway.entity.ChargeRecord;
import com.mogateway.entity.ChargeRecordCriteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ChargeRecordMapper {
    long countByExample(ChargeRecordCriteria example);

    int deleteByExample(ChargeRecordCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(ChargeRecord record);

    int insertSelective(ChargeRecord record);

    List<ChargeRecord> selectByExample(ChargeRecordCriteria example);

    ChargeRecord selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ChargeRecord record, @Param("example") ChargeRecordCriteria example);

    int updateByExample(@Param("record") ChargeRecord record, @Param("example") ChargeRecordCriteria example);

    int updateByPrimaryKeySelective(ChargeRecord record);

    int updateByPrimaryKey(ChargeRecord record);

    ChargeRecord chargeRecordStatistics(Integer abnormalFlag);
}