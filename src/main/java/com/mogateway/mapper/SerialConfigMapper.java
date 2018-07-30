package com.mogateway.mapper;

import com.mogateway.entity.SerialConfig;
import com.mogateway.entity.SerialConfigCriteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface SerialConfigMapper {
    long countByExample(SerialConfigCriteria example);

    int deleteByExample(SerialConfigCriteria example);

    int deleteByPrimaryKey(String serialName);

    int insert(SerialConfig record);

    int insertSelective(SerialConfig record);

    List<SerialConfig> selectByExample(SerialConfigCriteria example);

    SerialConfig selectByPrimaryKey(String serialName);

    int updateByExampleSelective(@Param("record") SerialConfig record, @Param("example") SerialConfigCriteria example);

    int updateByExample(@Param("record") SerialConfig record, @Param("example") SerialConfigCriteria example);

    int updateByPrimaryKeySelective(SerialConfig record);

    int updateByPrimaryKey(SerialConfig record);
}