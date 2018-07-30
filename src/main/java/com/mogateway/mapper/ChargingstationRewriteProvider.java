package com.mogateway.mapper;

import com.mogateway.entity.ChargingstationRewrite;
import com.mogateway.entity.User;
import com.mogateway.util.DateUtils;
import com.mogateway.util.Tools;
import org.apache.ibatis.jdbc.SQL;

import java.util.Date;

/**
 * Created by xiaojinlu on 2018/7/12.
 */

public class ChargingstationRewriteProvider {

    public String getChargingstationList(ChargingstationRewrite chargingstation){

        StringBuffer sql = new StringBuffer();

        sql.append("  SELECT   " );
        sql.append("  sc.charging_station_name ," );//名称
        sql.append("  sc.charging_station_id ," );//id
        sql.append("  oi.operator_name," );//所属运营商
        sql.append("  sc.country_code		," );//国家代码
        sql.append("  sc.area_code	," );//省市辖区
        sql.append("  sc.charging_station_addr	," );//详细地址
        sql.append("  sc.charging_station_tel	," );//站点电话
        sql.append("  st.station_type_name," );//站点类型
        sql.append("  ss.station_status_name," );//站点状态
        sql.append("  sc.park_nums		," );//车位数量
        sql.append("  sc.charging_station_lng	," );//经度'
        sql.append("  sc.charging_station_lat	," );//维度
        sql.append("  sc.site_guide	," );//站点引导
        sql.append("  sc.construction	," );//建设场所
        sql.append("  ci.construction_name	," );//建设场所
        sql.append("  sc.support_order ," );//是否支持预约
        sql.append("  sc.remark " ); //备注
        sql.append("  FROM  chargingstation  sc " );
        sql.append("  LEFT JOIN  operator_info oi  ON sc.operator_id = oi.operator_id " );
        sql.append("  LEFT JOIN  construction_info ci  ON sc.construction = ci.construction " );
        sql.append("  LEFT JOIN  station_status ss  ON sc.charging_station_status = ss.station_status " );
        sql.append("  LEFT JOIN  station_type st  ON sc.charging_station_type = st.station_type " );

        return sql.toString();

    }



    public String saveChargingstation(ChargingstationRewrite chargingstation){
        User user = Tools.getUser();

        StringBuffer sql = new StringBuffer();

        sql.append("   insert into chargingstation " );
        sql.append(" ( " );
        sql.append(" charging_station_name ," );//名称
        sql.append(" operator_id," );//所属运营商
        sql.append(" country_code ," );//国家代码
        sql.append(" area_code	," );//省市辖区
        sql.append(" charging_station_addr	," );//详细地址
        sql.append(" charging_station_tel	," );//站点电话
        sql.append(" charging_station_type," );//站点类型
        sql.append(" charging_station_status," );//站点状态
        sql.append(" park_nums  ," );//车位数量
        sql.append(" charging_station_lng	," );//经度'
        sql.append(" charging_station_lat	," );//维度
        sql.append(" site_guide	," );//站点引导
        sql.append(" construction	," );//建设场所
        sql.append(" support_order ," );//书否支持预约
        sql.append(" equipment_owner_id ," );//设备所属方ID(必填项)
        sql.append(" charging_service_tel ," );//服务电话<站点>(必填项)
        sql.append(" enabled ," );//  站点是否可用 (必填项)
        sql.append(" create_user ," );//  创建人 (必填项)
        sql.append(" create_dttm ," );//  创建时间 (必填项)
        sql.append(" update_user ," );//  更新人 (必填项)
        sql.append(" update_dttm ," );//  更新时间 (必填项)
        sql.append(" remark " ); //备注
        sql.append(" ) VALUES ( " );
        sql.append(" #{chargingStationName}," );
        sql.append(" #{operatorName}," );
        sql.append(" #{countryCode}," );
        sql.append(" #{areaCode}," );
        sql.append(" #{chargingStationAddr}," );
        sql.append(" #{chargingStationTel}," );
        sql.append(" #{stationTypeName}," );
        sql.append(" #{stationStatusName}," );
        sql.append(" #{parkNums}," );
        sql.append(" #{chargingStationLng}," );
        sql.append(" #{chargingStationLat}," );
        sql.append(" #{siteGuide}," );
        sql.append(" #{constructionName}," );
        sql.append(" #{supportOrder }," );
        sql.append(" '1'," );
        sql.append(" #{chargingStationTel}," );
        sql.append(" '1'," );
        sql.append(" '"+user.getUserName()+"'," );
        sql.append(" '"+ DateUtils.getNowString(new Date())+"'," );
        sql.append(" '"+user.getUserName()+"'," );
        sql.append(" '"+ DateUtils.getNowString(new Date())+"'," );
        sql.append(" #{remark}" );
        sql.append(" )" );

        return sql.toString();
    }


    public String updateChargingstation(ChargingstationRewrite chargingstation){
        User user = Tools.getUser();
        StringBuffer sql = new StringBuffer();

        sql.append("  update  chargingstation  set  ");//名称
        sql.append(" charging_station_name 	=	#{chargingStationName} 	,");//名称
        sql.append(" operator_id	=	  #{operatorName}	,");//所属运营商
        sql.append(" country_code 	=	  #{countryCode}	,");//国家代码
        sql.append(" area_code	=	  #{areaCode}	,");//省市辖区
        sql.append(" charging_station_addr	= #{chargingStationAddr}	,");//详细地址
        sql.append(" charging_station_tel	=	  #{chargingStationTel}	,");//站点电话
        sql.append(" charging_station_type	=	 #{stationTypeName}	,");//站点类型
        sql.append(" charging_station_status	=	  #{stationStatusName}	,");//站点状态
        sql.append(" park_nums  	=	  #{parkNums}	,");//车位数量
        sql.append(" charging_station_lng	=	 #{chargingStationLng}	,");//经度'
        sql.append(" charging_station_lat	=	  #{chargingStationLat}	,");//维度
        sql.append(" site_guide	=	  #{siteGuide}	,");//站点引导
        sql.append(" construction	=	  #{constructionName}	,");//建设场所
        sql.append(" support_order 	=	  #{supportOrder }	,");//书否支持预约
        sql.append(" equipment_owner_id 	=	  '1'	,");//设备所属方ID(必填项)
        sql.append(" charging_service_tel 	=	 #{chargingStationTel}	,");//服务电话<站点>(必填项)
        sql.append(" enabled 	=	  '1'	,");//  站点是否可用 (必填项)
        sql.append(" update_user 	=  '"+user.getUserName()+"'	,");//  更新人 (必填项)
        sql.append(" update_dttm 	=  '"+ DateUtils.getNowString(new Date())+"'	,");//  更新时间 (必填项)
        sql.append(" remark  	=	  #{remark}		 ");//备注
        sql.append(" where charging_station_id = #{chargingStationId}   ");

        return sql.toString();
    }


    public String delChargingstation(ChargingstationRewrite chargingstation) {
        String newSql = " chargingstation where charging_station_id in (";
        String[] split = chargingstation.getChargingStationId().split(",");
        for (int i = 0; i < split.length - 1; i++) {
            newSql += "'";
            newSql += split[i];
            newSql += "'";
            newSql += ",";
        }
        newSql += "'";
        newSql += split[split.length - 1];
        newSql += "'";
        newSql += ")";
        SQL sql = new SQL().DELETE_FROM(newSql);
        return sql.toString();
    }
    /**
     * 获取下来框的id名称
     * @param chargingstation  keyId 1 运营商表 2站点类型表  3站点状态表  4 建设场所表
     * @return
     */
    public String getSelectList(ChargingstationRewrite chargingstation) {
        StringBuffer sql = new StringBuffer();

        sql.append("  SELECT   " );
        if("1".equals(chargingstation.getKeyId())){
            sql.append("  operator_id AS key_id,operator_name AS value_name  FROM    operator_info  ");
        }else if ("2".equals(chargingstation.getKeyId())){
            sql.append(" station_type AS key_id,station_type_name AS value_name FROM  station_type ");
        }else if ("3".equals(chargingstation.getKeyId())){
            sql.append("  station_status AS key_id,station_status_name AS value_name FROM  station_status ");
        }else if ("4".equals(chargingstation.getKeyId())){
            sql.append(" construction AS key_id,construction_name AS value_name FROM   construction_info  ");
        }
        return sql.toString();

    }
}
