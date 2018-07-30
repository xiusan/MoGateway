package com.mogateway.mapper;

import com.mogateway.entity.ChargingProcessFile;
import com.mogateway.entity.ChargingProcessFileCriteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ChargingProcessFileMapper {
    long countByExample(ChargingProcessFileCriteria example);

    int deleteByExample(ChargingProcessFileCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(ChargingProcessFile record);

    int insertSelective(ChargingProcessFile record);

    List<ChargingProcessFile> selectByExample(ChargingProcessFileCriteria example);

    ChargingProcessFile selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ChargingProcessFile record, @Param("example") ChargingProcessFileCriteria example);

    int updateByExample(@Param("record") ChargingProcessFile record, @Param("example") ChargingProcessFileCriteria example);

    int updateByPrimaryKeySelective(ChargingProcessFile record);

    int updateByPrimaryKey(ChargingProcessFile record);
}