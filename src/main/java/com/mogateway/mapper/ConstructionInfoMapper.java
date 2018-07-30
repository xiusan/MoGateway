package com.mogateway.mapper;

import com.mogateway.entity.ConstructionInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
* 类名称：ConstructionInfoMapper
* 创建人：
* 创建时间：2018-07-18
* 描   述: {objectRemark}
*/

@Mapper
public interface ConstructionInfoMapper {


@SelectProvider(type = ConstructionInfoProvider.class, method = "getConstructionInfoList")
List<ConstructionInfo> getConstructionInfoList(ConstructionInfo constructioninfo);


    @InsertProvider(type = ConstructionInfoProvider.class, method = "saveConstructionInfo")
    int saveConstructionInfo(ConstructionInfo constructioninfo);


    @UpdateProvider(type = ConstructionInfoProvider.class, method = "updateConstructionInfo")
    int updateConstructionInfo(ConstructionInfo constructioninfo);


    @DeleteProvider(type = ConstructionInfoProvider.class, method = "delConstructionInfo")
    int delConstructionInfo(ConstructionInfo constructioninfo);
    }
