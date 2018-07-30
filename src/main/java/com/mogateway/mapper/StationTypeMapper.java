package com.mogateway.mapper;

import com.mogateway.entity.StationType;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
* 类名称：StationTypeMapper
* 创建人：
* 创建时间：2018-07-18
* 描   述: {objectRemark}
*/

@Mapper
public interface StationTypeMapper {


@SelectProvider(type = StationTypeProvider.class, method = "getStationTypeList")
List<StationType> getStationTypeList(StationType stationtype);


    @InsertProvider(type = StationTypeProvider.class, method = "saveStationType")
    int saveStationType(StationType stationtype);


    @UpdateProvider(type = StationTypeProvider.class, method = "updateStationType")
    int updateStationType(StationType stationtype);


    @DeleteProvider(type = StationTypeProvider.class, method = "delStationType")
    int delStationType(StationType stationtype);
    }
