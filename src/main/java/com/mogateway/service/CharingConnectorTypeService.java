package com.mogateway.service;

import com.mogateway.entity.CharingConnectorType;
import com.mogateway.entity.EquipmentType;
import com.mogateway.mapper.CharingConnectorTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author weizheng
 * @create 2018-07-11 11:57
 * @desc 充电设备接口类型Service
 **/
@Service("charingConnectorTypeService")
public class CharingConnectorTypeService {

    @Autowired
    private CharingConnectorTypeMapper charingConnectorTypeMapper;

    public List<CharingConnectorType> getCharingConnectorTypeList(CharingConnectorType charingConnectorType){
         return  charingConnectorTypeMapper.getCharingConnectorTypeList(charingConnectorType);
    }

}
