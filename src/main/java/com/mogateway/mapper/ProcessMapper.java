package com.mogateway.mapper;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

/**
 * 创建用户:杨辽
 * 创建时间: 2018-04-10 09:25
 * 描   述:
 **/
@Mapper
public interface ProcessMapper {

    @Select(" SELECT" +
            "   equipment_id" +
            " FROM" +
            "   charging_process_file" +
            " GROUP BY" +
            "   equipment_id")
    List<String> getEquipmentId();

    @SelectProvider(method = "listSql", type = ProcessMapperProvider.class)
    List<Map<String, Object>> list(JSONObject object);

    @SelectProvider(method = "listCountSql", type = ProcessMapperProvider.class)
    Integer listCount(JSONObject object);

    class ProcessMapperProvider {
        public String listSql(JSONObject object) {
            return "select *, DATE_FORMAT(file_create_time, '%Y-%c-%d %h:%i:%s') as fc from `charging_process_file` " + wh(object) + " limit " + ((object.getInteger("currentPage") - 1) * object.getInteger("rowsPerPage")) + "," + object.getInteger("rowsPerPage");
        }
        public String listCountSql(JSONObject object) {
            return "select count(1) from `charging_process_file` " + wh(object);
        }

        private String wh(JSONObject object) {
            String sql = " WHERE  " +
                   "   1 = 1  ";
            if (StringUtils.isNotBlank(object.getString("type"))) {
                if (object.getString("type").equals("car")) {
                    sql += " AND fiel_type = 'car'";
                } else {
                    sql += " AND fiel_type != 'car'";
                }
            }

            if (StringUtils.isNotBlank(object.getString("startDate"))) {
                sql += " AND file_create_time >= '" + object.getString("startDate") + "'";
            }
            if (StringUtils.isNotBlank(object.getString("endDate"))) {
                sql += " AND file_create_time <= '" + object.getString("endDate") + "'";
            }
            if (StringUtils.isNotBlank(object.getString("mk")) && !"全部".equals(object.getString("mk"))) {
                sql += " AND equipment_id = '" + object.getString("mk") + "'";
            }
            return sql;
        }
    }
}
