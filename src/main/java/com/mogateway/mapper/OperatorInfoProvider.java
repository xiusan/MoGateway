package com.mogateway.mapper;


import com.mogateway.entity.OperatorInfo;
import org.apache.ibatis.jdbc.SQL;

/**
 * @program:org.kjtc.mapper
 * @description:yunyingshang
 * @author: xiaojinlu
 */


public class OperatorInfoProvider {

    public String getOperatorInfoList(OperatorInfo operatorInfo){

        StringBuffer sql = new StringBuffer();

            sql.append("SELECT operator_id,");
            sql.append("operator_name,\n" );
            sql.append("operator_tel1,\n" );
            sql.append("operator_tel2,\n" );
            sql.append("operator_note,\n" );
            sql.append("operator_reg_address,\n" );
            sql.append("operator_note ,\n ");
            sql.append("aes_secret ,\n ");
            sql.append("operator_secret ,\n ");
            sql.append("aes_iv ,\n ");
            sql.append("sig_secret   ");
            sql.append("FROM operator_info  ");

        return sql.toString();

    }



    public String saveOperatorInfo(OperatorInfo operatorInfo){

        StringBuffer sql = new StringBuffer();

        sql.append("insert into operator_info");
        sql.append("(operator_id,\n" );
        sql.append("operator_name,\n" );
        sql.append("operator_tel1,\n" );
        sql.append("operator_tel2,\n" );
        sql.append("operator_note,\n" );
        sql.append("aes_secret,\n" );
        sql.append("operator_secret,\n" );
        sql.append("aes_iv,\n" );
        sql.append("sig_secret,\n" );
        sql.append("operator_reg_address\n" );
        sql.append(") values (\n" );
        sql.append("#{operatorId},\n" );
        sql.append("#{operatorName},\n" );
        sql.append("#{operatorTel1},\n" );
        sql.append("#{operatorTel2},\n" );
        sql.append( "#{operatorNote},\n");
        sql.append( "#{aesSecret},\n");
        sql.append( "#{operatorSecret},\n");
        sql.append( "#{aesIv},\n");
        sql.append( "#{sigSecret},\n");
        sql.append( "#{operatorRegAddress} ) ");

        return sql.toString();
    }


    public String updateOperatorInfo(OperatorInfo operatorInfo){

        StringBuffer sql = new StringBuffer();

                    sql.append("update operator_info set ");
                    sql.append("operator_name = #{operatorName},\n");
                    sql.append("operator_tel1 = #{operatorTel1},\n");
                    sql.append("operator_tel2 = #{operatorTel2},\n" );
                    sql.append("operator_reg_address = #{operatorRegAddress},\n" );
                    sql.append("operator_note = #{operatorNote},\n" );
                    sql.append("aes_secret = #{aesSecret},\n" );
                    sql.append("operator_secret = #{operatorSecret},\n" );
                    sql.append("aes_iv = #{aesIv},\n" );
                    sql.append("sig_secret = #{sigSecret},\n" );
                    sql.append("operator_id = #{operatorId}\n" );
                    sql.append("  where operator_id = #{operatorId}  ");

        return sql.toString();
    }


    public String delOperatorInfo(OperatorInfo operatorInfo) {
        String newSql = " operator_info where operator_id in (";
        String[] split = operatorInfo.getOperatorId().split(",");
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
