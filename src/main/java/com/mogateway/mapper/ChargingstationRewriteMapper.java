package com.mogateway.mapper;


import com.mogateway.entity.ChargingstationRewrite;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by xiaojinlu on 2018/7/12.
 */
@Mapper
public interface ChargingstationRewriteMapper {

    @SelectProvider(type = ChargingstationRewriteProvider.class, method = "getChargingstationList")
    List<ChargingstationRewrite> getChargingstationList(ChargingstationRewrite chargingstation);


    @InsertProvider(type = ChargingstationRewriteProvider.class, method = "saveChargingstation")
    int saveChargingstation(ChargingstationRewrite chargingstation);


    @UpdateProvider(type = ChargingstationRewriteProvider.class, method = "updateChargingstation")
    int updateChargingstation(ChargingstationRewrite chargingstation);


    @DeleteProvider(type = ChargingstationRewriteProvider.class, method = "delChargingstation")
    int delChargingstation(ChargingstationRewrite chargingstation);

    @SelectProvider(type = ChargingstationRewriteProvider.class, method = "getSelectList")
    List<ChargingstationRewrite> getSelectList(ChargingstationRewrite chargingstation);

}
