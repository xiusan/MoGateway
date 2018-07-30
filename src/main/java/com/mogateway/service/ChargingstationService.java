package com.mogateway.service;



import com.mogateway.entity.Chargingstation;

import java.util.List;

public interface ChargingstationService {

    /**
     * 查询充电桩数据集合
     * @param chargingstation
     * @return
     */
    List<Chargingstation> selectByExample(Chargingstation chargingstation);




}
