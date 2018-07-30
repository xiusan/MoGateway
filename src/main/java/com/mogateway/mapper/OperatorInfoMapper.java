package com.mogateway.mapper;

import com.mogateway.entity.OperatorInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by xiaojinlu on 2018-07-11.
 */
@Mapper
public interface OperatorInfoMapper {


    @SelectProvider(type = OperatorInfoProvider.class, method = "getOperatorInfoList")
    List<OperatorInfo> getOperatorInfoList(OperatorInfo operatorInfo);


    @InsertProvider(type = OperatorInfoProvider.class, method = "saveOperatorInfo")
    int saveOperatorInfo(OperatorInfo operatorInfo);


    @UpdateProvider(type = OperatorInfoProvider.class, method = "updateOperatorInfo")
    int updateOperatorInfo(OperatorInfo operatorInfo);


    @DeleteProvider(type = OperatorInfoProvider.class, method = "delOperatorInfo")
    int delOperatorInfo(OperatorInfo operatorInfo);
}
