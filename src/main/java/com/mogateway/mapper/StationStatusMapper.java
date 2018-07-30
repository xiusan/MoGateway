package com.mogateway.mapper;

import com.mogateway.entity.StationStatus;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
* 类名称：StationStatusMapper
* 创建人：
* 创建时间：2018-07-18
* 描   述: {objectRemark}
*/

@Mapper
public interface StationStatusMapper {


@SelectProvider(type = StationStatusProvider.class, method = "getStationStatusList")
List<StationStatus> getStationStatusList(StationStatus stationstatus);


    @InsertProvider(type = StationStatusProvider.class, method = "saveStationStatus")
    int saveStationStatus(StationStatus stationstatus);


    @UpdateProvider(type = StationStatusProvider.class, method = "updateStationStatus")
    int updateStationStatus(StationStatus stationstatus);


    @DeleteProvider(type = StationStatusProvider.class, method = "delStationStatus")
    int delStationStatus(StationStatus stationstatus);
    }
