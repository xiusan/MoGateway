package com.mogateway.service;

import com.mogateway.entity.EquipmentType;
import com.mogateway.mapper.EquipmentTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author weizheng
 * @create 2018-07-11 11:57
 * @desc 设备类型Service
 **/
@Service("equipmentTypeService")
public class EquipmentTypeService {

    @Autowired
    private EquipmentTypeMapper equipmentTypeMapper;

    public List<EquipmentType> getEquipmentTypeList(EquipmentType equipmentType){
         return  equipmentTypeMapper.getEquipmentTypeList(equipmentType);
    }

}
