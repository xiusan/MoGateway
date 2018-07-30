package com.mogateway.provider;

import com.mogateway.entity.EquipmentType;
import com.mogateway.util.StringUtils;
import org.apache.ibatis.jdbc.SQL;

/**
 * @author weizheng
 * @create 2018-07-11 11:52
 * @desc 设备类型Provider
 **/
public class EquipmentTypeProvider {

    public String getEquipmentTypeList(EquipmentType equipmentType) {

        String newSql = " equipment_type," +
                " equipment_type_name," +
                " create_user," +
                " create_dttm," +
                " update_user," +
                " update_dttm" +
                " from equipment_type" +
                " where 1=1";
        if (StringUtils.isNotEmpty(equipmentType.getEquipmentType())) {
            newSql += " and  equipment_type = #{equipmentType} ";
        }

        if (StringUtils.isNotEmpty(equipmentType.getEquipmentTypeName())) {
            newSql += " and equipment_type_name = #{equipmentTypeName}";
        }

        SQL sql = new SQL().SELECT(newSql);
        sql.ORDER_BY("equipment_type ");
        return sql.toString();
    }

}
