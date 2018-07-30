package com.mogateway.mapper;

import com.mogateway.entity.ConnectType;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 连接类型的Mapper
 */
@Mapper
public interface ConnectTypeMapper {

    @Select("select * from connect_type")
    List<ConnectType> getConnectTypes();

    @Insert("insert into connect_type (" +
            "connect_type," +
            "connect_ip," +
            "connect_port," +
            "connect_baudrate," +
            "connect_serial_port," +
            "connect_serial_check_id," +
            "connect_direction," +
            "connect_file," +
            "connect_pub_redis_channel," +
            "connect_sub_redis_channel," +
            "enabled," +
            "create_user," +
            "create_dttm," +
            "update_user," +
            "update_dttm) values (" +
            "#{ConnectType}," +
            "#{ConnectIP}," +
            "#{ConnectPort}," +
            "#{ConnectBaudRate}," +
            "#{ConnectSerialPort}," +
            "#{ConnectSerialCheckID}," +
            "#{ConnectDirection}," +
            "#{ConnectFile}," +
            "#{ConnectPubRedisChannel}," +
            "#{ConnectSubRedisChannel}," +
            "1," +
            "#{CreateUser}," +
            "now()," +
            "#{UpdateUser}," +
            "now()" +
            ")")
    int addConnectType(ConnectType connectType);

    @Update("<script>update connect_type set enabled=#{enabled},update_user=#{userID},update_dttm=now() where connect_type in <foreach collection='ids' index='index' item='item' open='(' separator=',' close=')'>#{item}</foreach></script>")
    int updateConnectType(@Param("userID") String userID, @Param("enabled") Integer enabled, @Param("ids") String[] ids);

    @Delete("<script>delete from connect_type where connect_type in <foreach collection='ids' index='index' item='item' open='(' separator=',' close=')'>#{item}</foreach></script>")
    int deleteConnectType(@Param("ids") String[] ids);

    @Update("update connect_type set enabled=1")
    int disableConnectType();
}
