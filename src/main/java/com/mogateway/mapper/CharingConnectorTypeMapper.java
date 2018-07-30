package com.mogateway.mapper;

import com.mogateway.entity.CharingConnectorType;
import com.mogateway.entity.EquipmentType;
import com.mogateway.provider.CharingConnectorTypeProvider;
import com.mogateway.provider.EquipmentTypeProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * @author weizheng
 * @create 2018-07-11 11:48
 * @desc 充电设备接口类型mapper
 **/
@Mapper
public interface CharingConnectorTypeMapper {
    @SelectProvider(type = CharingConnectorTypeProvider.class, method = "getCharingConnectorTypeList")
    List<CharingConnectorType> getCharingConnectorTypeList(CharingConnectorType charingConnectorType);
}