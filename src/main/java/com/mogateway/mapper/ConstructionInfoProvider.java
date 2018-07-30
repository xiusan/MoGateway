package com.mogateway.mapper;


import com.mogateway.entity.ConstructionInfo;
import com.mogateway.entity.User;
import com.mogateway.util.DateUtils;
import com.mogateway.util.Tools;
import org.apache.ibatis.jdbc.SQL;

import java.util.Date;

/**
* 类名称：ConstructionInfoProvider
* 创建人：
* 创建时间：2018-07-18
* 描   述:
*/


public class ConstructionInfoProvider {
	User user = Tools.getUser();
public String getConstructionInfoList(ConstructionInfo constructioninfo){

	StringBuffer sql = new StringBuffer();

		sql.append("SELECT  ");
		sql.append("  CONSTRUCTION, " );
		sql.append("  CONSTRUCTION_NAME, " );
		sql.append("  CREATE_USER, " );
		sql.append("  CREATE_DTTM, " );
		sql.append("  UPDATE_USER, " );
		sql.append("  UPDATE_DTTM, " );
		sql.append("  '' as addnullvalue ");
		sql.append("  FROM CONSTRUCTION_INFO  ");//表名
	return sql.toString();

}



public String saveConstructionInfo(ConstructionInfo constructioninfo){

			StringBuffer sql = new StringBuffer();
			sql.append("insert into CONSTRUCTION_INFO");
			sql.append("(" );
			sql.append("CONSTRUCTION,");
			sql.append("CONSTRUCTION_NAME,");
			sql.append("CREATE_USER,");
			sql.append("CREATE_DTTM,");
			sql.append("UPDATE_USER,");
			sql.append("UPDATE_DTTM");
			sql.append(") values ( " );
			sql.append("#{construction},");
			sql.append("#{constructionName},");
			sql.append("'"+user.getUserName()+"',");
			sql.append("'"+ DateUtils.getNowString(new Date())+"',");
			sql.append("'"+user.getUserName()+"',");
			sql.append("'"+ DateUtils.getNowString(new Date())+"' ");
			sql.append(")" );
		return sql.toString();
}


public String updateConstructionInfo(ConstructionInfo constructioninfo){

			StringBuffer sql = new StringBuffer();
			sql.append("update CONSTRUCTION_INFO set ");
                    sql.append("CONSTRUCTION_NAME=#{constructionName},");
					sql.append("UPDATE_USER='"+user.getUserName()+"',");
					sql.append("UPDATE_DTTM='"+ DateUtils.getNowString(new Date())+"' ");
					sql.append(" where  CONSTRUCTION=#{construction}");
		return sql.toString();
}


public String delConstructionInfo(ConstructionInfo constructioninfo) {
				String newSql = "  CONSTRUCTION_INFO  where   CONSTRUCTION in (";
			String[] split =  constructioninfo.getId().split(",");
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
