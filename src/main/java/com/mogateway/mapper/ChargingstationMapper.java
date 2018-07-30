package com.mogateway.mapper;

import com.mogateway.entity.Chargingstation;
import com.mogateway.entity.ChargingstationCriteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ChargingstationMapper {
    long countByExample(ChargingstationCriteria example);

    int deleteByExample(ChargingstationCriteria example);

    int deleteByPrimaryKey(String chargingStationId);

    int insert(Chargingstation record);

    int insertSelective(Chargingstation record);

    List<Chargingstation> selectByExample(ChargingstationCriteria example);

    Chargingstation selectByPrimaryKey(String chargingStationId);

    int updateByExampleSelective(@Param("record") Chargingstation record, @Param("example") ChargingstationCriteria example);

    int updateByExample(@Param("record") Chargingstation record, @Param("example") ChargingstationCriteria example);

    int updateByPrimaryKeySelective(Chargingstation record);

    int updateByPrimaryKey(Chargingstation record);

    @Select("select charging_station_id from chargingstation")
    String getChargingstationID();

    @Select("select * from chargingstation")
    Chargingstation getChargingstation();
}