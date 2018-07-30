package com.mogateway.service;


import com.mogateway.entity.ChargingstationRewrite;
import com.mogateway.mapper.ChargingstationRewriteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/7/12.
 */

@Service("chargingstationRewriteService")
public class ChargingstationRewriteService {

    @Autowired
    private ChargingstationRewriteMapper chargingstationRewriteMapper;

    /**
     * 查询列表
     * @param chargingstation
     * @return
     */
    public List<ChargingstationRewrite> getChargingstationList(ChargingstationRewrite chargingstation) {
        return chargingstationRewriteMapper.getChargingstationList(chargingstation);
    }


    public int saveChargingstation(ChargingstationRewrite chargingstation) {
        return chargingstationRewriteMapper.saveChargingstation(chargingstation);
    }

    public int updateChargingstation(ChargingstationRewrite chargingstation) {
        return chargingstationRewriteMapper.updateChargingstation(chargingstation);
    }

    public int delChargingstation(ChargingstationRewrite chargingstation) {
        return chargingstationRewriteMapper.delChargingstation(chargingstation);
    }


    public List<ChargingstationRewrite> getSelectList(ChargingstationRewrite chargingstation) {
        return chargingstationRewriteMapper.getSelectList(chargingstation);
    }
}
