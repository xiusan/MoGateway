package com.mogateway.mapper;

import com.mogateway.entity.Equipment;
import com.mogateway.entity.EquipmentCriteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EquipmentMapper {
    long countByExample(EquipmentCriteria example);

    int deleteByExample(EquipmentCriteria example);

    int deleteByPrimaryKey(String equipmentId);

    int insert(Equipment record);

    int insertSelective(Equipment record);

    List<Equipment> selectByExample(EquipmentCriteria example);

    List<Equipment> queryList(EquipmentCriteria example);

    Equipment selectByPrimaryKey(String equipmentId);
    Equipment selectByNo(String equipmentId);

    int updateByExampleSelective(@Param("record") Equipment record, @Param("example") EquipmentCriteria example);

    int updateByExample(@Param("record") Equipment record, @Param("example") EquipmentCriteria example);

    int updateByPrimaryKeySelective(Equipment record);

    int updateByPrimaryKey(Equipment record);
}