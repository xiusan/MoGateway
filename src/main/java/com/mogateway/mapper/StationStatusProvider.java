package com.mogateway.mapper;


import com.mogateway.entity.StationStatus;
import com.mogateway.entity.User;
import com.mogateway.util.DateUtils;
import com.mogateway.util.Tools;
import org.apache.ibatis.jdbc.SQL;

import java.util.Date;

/**
* 类名称：StationStatusProvider
* 创建人：
* 创建时间：2018-07-18
* 描   述:
*/


public class StationStatusProvider {
	User user = Tools.getUser();
public String getStationStatusList(StationStatus stationstatus){

	StringBuffer sql = new StringBuffer();

		sql.append("SELECT  ");
		sql.append("  STATION_STATUS, " );
		sql.append("  STATION_STATUS_NAME, " );
		sql.append("  CREATE_USER, " );
		sql.append("  CREATE_DTTM, " );
		sql.append("  UPDATE_USER, " );
		sql.append("  UPDATE_DTTM, " );
		sql.append("  '' as addnullvalue ");
		sql.append("  FROM STATION_STATUS  ");//表名
	return sql.toString();

}



public String saveStationStatus(StationStatus stationstatus){

			StringBuffer sql = new StringBuffer();
			sql.append("insert into STATION_STATUS");
			sql.append("(" );
			sql.append("STATION_STATUS,");
			sql.append("STATION_STATUS_NAME,");
			sql.append("CREATE_USER,");
			sql.append("CREATE_DTTM,");
			sql.append("UPDATE_USER,");
			sql.append("UPDATE_DTTM");
			sql.append(") values ( " );
			sql.append("#{stationStatus},");
			sql.append("#{stationStatusName},");
			sql.append("'"+user.getUserName()+"',");
			sql.append("'"+ DateUtils.getNowString(new Date())+"',");
			sql.append("'"+user.getUserName()+"',");
			sql.append("'"+ DateUtils.getNowString(new Date())+"'");
			sql.append(")" );
		return sql.toString();
}


public String updateStationStatus(StationStatus stationstatus){

			StringBuffer sql = new StringBuffer();
			sql.append("update STATION_STATUS set ");
                    sql.append("STATION_STATUS=#{stationStatus},");
                    sql.append("STATION_STATUS_NAME=#{stationStatusName},");
                    sql.append("UPDATE_USER='"+user.getUserName()+"',");
                    sql.append("UPDATE_DTTM='"+ DateUtils.getNowString(new Date())+"' ");
					sql.append(" where  STATION_STATUS=#{stationStatus}");
		return sql.toString();
}


public String delStationStatus(StationStatus stationstatus) {
				String newSql = "  STATION_STATUS  where   STATION_STATUS in (";
			String[] split = stationstatus.getId().split(",");
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

}
