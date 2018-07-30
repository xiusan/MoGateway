package com.mogateway.mapper;

import com.mogateway.entity.LogHistory;
import com.mogateway.provider.LogHistoryProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * Created by Administrator on 2018-04-26.
 */
@Mapper
public interface LogHistoryMapper {

    @SelectProvider(type = LogHistoryProvider.class, method = "getLogHistorys")
    List<LogHistory> getLogHistory(LogHistory logHistory);

    @Insert("insert into log_history(" +
            "module_id," +
            "file_date_start," +
            "file_date_end," +
            "file_address) values (" +
            "#{ModuleID}," +
            "#{FileDateStart}," +
            "#{FileDateEnd}," +
            "#{FileAddress})")
    int addLogHistory(LogHistory logHistory);
}
