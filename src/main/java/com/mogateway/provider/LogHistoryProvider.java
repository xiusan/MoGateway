package com.mogateway.provider;

import com.mogateway.entity.LogHistory;
import org.apache.ibatis.jdbc.SQL;

/**
 * Created by Administrator on 2018-04-26.
 */
public class LogHistoryProvider {

    public String getLogHistorys(LogHistory logHistory){
        SQL sql = new SQL().SELECT("b.module_name as ModuleID," +
                "a.file_date_start as FileDateStart," +
                "a.file_date_end as FileDateEnd," +
                "a.file_address as FileAddress ").FROM("log_history a")
                .LEFT_OUTER_JOIN("module b ON a.module_id = b.module_id");
        if(logHistory.getModuleID() != null && !"".equals(logHistory.getModuleID())){
            sql.WHERE("a.module_id  = #{ModuleID}");
        }
        if (logHistory.getFileDateStart() != null) {
            sql.WHERE("a.file_date_start >= #{FileDateStart}");
        }
        if (logHistory.getFileDateEnd() != null) {
            sql.WHERE("a.file_date_start <= #{FileDateEnd}");
        }
        sql.ORDER_BY("a.file_date_start desc");
        return sql.toString();
    }
}
