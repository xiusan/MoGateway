package com.mogateway.mapper;


import com.mogateway.entity.StationType;
import com.mogateway.entity.User;
import com.mogateway.util.DateUtils;
import com.mogateway.util.Tools;
import org.apache.ibatis.jdbc.SQL;

import java.util.Date;

/**
* 类名称：StationTypeProvider
* 创建人：
* 创建时间：2018-07-18
* 描   述:
*/


public class StationTypeProvider {
	User user = Tools.getUser();
public String getStationTypeList(StationType stationtype){

	StringBuffer sql = new StringBuffer();

		sql.append("SELECT  ");
		sql.append("  STATION_TYPE, " );
		sql.append("  STATION_TYPE_NAME, " );
		sql.append("  CREATE_USER, " );
		sql.append("  CREATE_DTTM, " );
		sql.append("  UPDATE_USER, " );
		sql.append("  UPDATE_DTTM, " );
		sql.append("  '' as addnullvalue ");
		sql.append("  FROM STATION_TYPE  ");//表名
	return sql.toString();

}



public String saveStationType(StationType stationtype){

			StringBuffer sql = new StringBuffer();
			sql.append("insert into STATION_TYPE");
			sql.append("(" );
			sql.append("STATION_TYPE,");
			sql.append("STATION_TYPE_NAME,");
			sql.append("CREATE_USER,");
			sql.append("CREATE_DTTM,");
			sql.append("UPDATE_USER,");
			sql.append("UPDATE_DTTM");
			sql.append(") values ( " );
			sql.append("#{stationType},");
			sql.append("#{stationTypeName},");
			sql.append("'"+user.getUserName()+"',");
			sql.append("'"+ DateUtils.getNowString(new Date())+"',");
			sql.append("'"+user.getUserName()+"',");
			sql.append("'"+ DateUtils.getNowString(new Date())+"' ");
			sql.append(")" );
		return sql.toString();
}


public String updateStationType(StationType stationtype){

			StringBuffer sql = new StringBuffer();
			sql.append("update STATION_TYPE set ");
                    sql.append("STATION_TYPE_NAME=#{stationTypeName},");
					sql.append("UPDATE_USER='"+user.getUserName()+"',");
					sql.append("UPDATE_DTTM='"+ DateUtils.getNowString(new Date())+"' ");
					sql.append(" where  STATION_TYPE=#{stationType}");
		return sql.toString();
}


public String delStationType(StationType stationtype) {
				String newSql = "  STATION_TYPE  where   STATION_TYPE in (";
			String[] split = stationtype.getId().split(",");
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
