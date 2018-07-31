package com.mogateway.mapper;

import com.mogateway.entity.Shengdaojia;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
* 类名称：ShengdaojiaMapper
* 创建人：
* 创建时间：2018-07-31
* 描   述: {objectRemark}
*/

@Mapper
public interface ShengdaojiaMapper {


@SelectProvider(type = ShengdaojiaProvider.class, method = "getShengdaojiaList")
List<Shengdaojia> getShengdaojiaList(Shengdaojia shengdaojia);


    @InsertProvider(type = ShengdaojiaProvider.class, method = "saveShengdaojia")
    int saveShengdaojia(Shengdaojia shengdaojia);


    @UpdateProvider(type = ShengdaojiaProvider.class, method = "updateShengdaojia")
    int updateShengdaojia(Shengdaojia shengdaojia);


    @DeleteProvider(type = ShengdaojiaProvider.class, method = "delShengdaojia")
    int delShengdaojia(Shengdaojia shengdaojia);
    }
