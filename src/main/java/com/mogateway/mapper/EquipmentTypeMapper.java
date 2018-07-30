package com.mogateway.mapper;

import com.mogateway.entity.EquipmentType;
import com.mogateway.provider.EquipmentTypeProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * @author weizheng
 * @create 2018-07-11 11:48
 * @desc 设备类型mapper
 **/
@Mapper
public interface EquipmentTypeMapper {

    @SelectProvider(type = EquipmentTypeProvider.class, method = "getEquipmentTypeList")
    List<EquipmentType> getEquipmentTypeList(EquipmentType equipmentType);

}