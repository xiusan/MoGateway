package com.mogateway.mapper;

import com.mogateway.entity.LogSetting;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by Administrator on 2018-04-27.
 */
@Mapper
public interface LogSettingMapper {

    @Select("select a.*, b.module_name from log_setting a left join module b on a.module_id = b.module_id order by a.update_dttm desc")
    List<LogSetting> getLogSetting();

    @Insert("insert into log_setting(" +
            "module_id," +
            "log_flag," +
            "store_style," +
            "store_period," +
            "store_file_size," +
            "compress_flag," +
            "compress_style," +
            "create_user," +
            "create_dttm," +
            "update_user," +
            "update_dttm) values (" +
            "#{moduleID}," +
            "#{logFlag}," +
            "#{storeStyle}," +
            "#{storePeriod}," +
            "#{storeFileSize}," +
            "#{compressFlag}," +
            "#{compressStyle}," +
            "#{createUser}," +
            "now()," +
            "#{updateUser}," +
            "now())")
    int addLogSetting(LogSetting logSetting);

    @Update("update log_setting set " +
            "log_flag = #{logFlag}," +
            "store_style = #{storeStyle}," +
            "store_period = #{storePeriod}," +
            "store_file_size = #{storeFileSize}," +
            "compress_flag = #{compressFlag}," +
            "update_user = #{updateUser}," +
            "update_dttm = now() where module_id = #{moduleID}")
    int updateLogSetting(LogSetting logSetting);

    @Delete("<script>delete from log_setting where module_id in <foreach collection='moduleIDS' index='index' item='item' open='(' separator=',' close=')'>#{item}</foreach></script>")
    int deleteLogSetting(@Param("moduleIDS") String[] moduleIDS);
}
