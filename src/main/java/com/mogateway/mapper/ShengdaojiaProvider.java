package com.mogateway.mapper;


import com.mogateway.entity.Shengdaojia;
import org.apache.ibatis.jdbc.SQL;

/**
* 类名称：ShengdaojiaProvider
* 创建人：
* 创建时间：2018-07-31
* 描   述:
*/


public class ShengdaojiaProvider {

public String getShengdaojiaList(Shengdaojia shengdaojia){

	StringBuffer sql = new StringBuffer();

		sql.append("SELECT  ");
		sql.append("  NUM_ID, " );
		sql.append("  TITLE, " );
		sql.append("  PICT_URL, " );
		sql.append("  SMALL_IMAGES, " );
		sql.append("  RESERVE_PRICE, " );
		sql.append("  ZK_FINAL_PRICE, " );
		sql.append("  USER_TYPE, " );
		sql.append("  PROVCITY, " );
		sql.append("  ITEM_URL, " );
		sql.append("  NICK, " );
		sql.append("  SELLER_ID, " );
		sql.append("  VOLUME, " );
		sql.append("  CREAT_TIME, " );
		sql.append("  POPULARITY, " );
		sql.append("  VOUCHER_ADDRESS, " );
		sql.append("  CREAT_USER, " );
		sql.append("  '' as addnullvalue ");
		sql.append("  FROM  commodity_table ");//表名
	return sql.toString();

}



public String saveShengdaojia(Shengdaojia shengdaojia){

			StringBuffer sql = new StringBuffer();
			sql.append("insert into commodity_table");
			sql.append("(" );
			sql.append("NUM_ID,");
			sql.append("TITLE,");
			sql.append("PICT_URL,");
			sql.append("SMALL_IMAGES,");
			sql.append("RESERVE_PRICE,");
			sql.append("ZK_FINAL_PRICE,");
			sql.append("USER_TYPE,");
			sql.append("PROVCITY,");
			sql.append("ITEM_URL,");
			sql.append("NICK,");
			sql.append("SELLER_ID,");
			sql.append("VOLUME,");
			sql.append("CREAT_TIME,");
			sql.append("POPULARITY,");
			sql.append("VOUCHER_ADDRESS,");
			sql.append("CREAT_USER");
			sql.append(") values ( " );
			sql.append("#{numId},");
			sql.append("#{title},");
			sql.append("#{pictUrl},");
			sql.append("#{smallImages},");
			sql.append("#{reservePrice},");
			sql.append("#{zkFinalPrice},");
			sql.append("#{userType},");
			sql.append("#{provcity},");
			sql.append("#{itemUrl},");
			sql.append("#{nick},");
			sql.append("#{sellerId},");
			sql.append("#{volume},");
			sql.append("#{creatTime},");
			sql.append("#{popularity},");
			sql.append("#{voucherAddress},");
			sql.append("#{creatUser}");
			sql.append(")" );
		return sql.toString();
}


public String updateShengdaojia(Shengdaojia shengdaojia){

			StringBuffer sql = new StringBuffer();
			sql.append("update commodity_table set ");
                    sql.append("NUM_ID=#{creatUser},");
                    sql.append("TITLE=#{CreatUser},");
                    sql.append("PICT_URL=#{CreatUser},");
                    sql.append("SMALL_IMAGES=#{CreatUser},");
                    sql.append("RESERVE_PRICE=#{CreatUser},");
                    sql.append("ZK_FINAL_PRICE=#{CreatUser}");
                    sql.append("USER_TYPE=#{CreatUser},");
                    sql.append("PROVCITY=#{CreatUser},");
                    sql.append("ITEM_URL=#{CreatUser},");
                    sql.append("NICK=#{CreatUser},");
                    sql.append("SELLER_ID=#{CreatUser},");
                    sql.append("VOLUME=#{CreatUser},");
                    sql.append("CREAT_TIME=#{CreatUser},");
                    sql.append("POPULARITY=#{CreatUser},");
                    sql.append("VOUCHER_ADDRESS=#{CreatUser},");
                    sql.append("CREAT_USER=#{CreatUser},");
					sql.append(" where  NUM_ID=#{CreatUser}");
		return sql.toString();
}


public String delShengdaojia(Shengdaojia shengdaojia) {
				String newSql = "  commodity_table  where   NUM_ID in (";
			String[] split =  shengdaojia.getNumId().split(",");
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
