package com.mogateway.provider;

import com.mogateway.entity.CharingConnectorType;
import com.mogateway.entity.EquipmentType;
import com.mogateway.util.StringUtils;
import org.apache.ibatis.jdbc.SQL;

/**
 * @author weizheng
 * @create 2018-07-11 11:52
 * @desc 充电设备接口类型Provider
 **/
public class CharingConnectorTypeProvider {

    public String getCharingConnectorTypeList(CharingConnectorType charingConnectorType) {

        String newSql = " charging_connector_type," +
                " charging_connector_name," +
                " create_user," +
                " create_dttm," +
                " update_user," +
                " update_dttm" +
                " from charing_connector_type" +
                " where 1=1";
        if (StringUtils.isNotEmpty(charingConnectorType.getChargingConnectorType())) {
            newSql += " and  charging_connector_type = #{chargingConnectorType} ";
        }

        if (StringUtils.isNotEmpty(charingConnectorType.getChargingConnectorName())) {
            newSql += " and charging_connector_name = #{chargingConnectorName}";
        }

        SQL sql = new SQL().SELECT(newSql);
        sql.ORDER_BY("charging_connector_type ");
        return sql.toString();
    }

}
