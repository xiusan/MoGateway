package com.mogateway.service.impl;

import com.mogateway.entity.Chargingstation;
import com.mogateway.entity.ChargingstationCriteria;
import com.mogateway.mapper.ChargingstationMapper;
import com.mogateway.service.ChargingstationService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChargingstationServiceImpl implements ChargingstationService {

    @Autowired
    private ChargingstationMapper chargingstationMapper;


    @Override
    public List<Chargingstation> selectByExample(Chargingstation chargingstation) {
        ChargingstationCriteria example = new ChargingstationCriteria();
        ChargingstationCriteria.Criteria criteria = example.createCriteria();

        if (StringUtils.isNotEmpty(chargingstation.getChargingStationName())){
            criteria.andChargingStationNameEqualTo(chargingstation.getChargingStationName());
        }

        List<Chargingstation> chargingstations = chargingstationMapper.selectByExample(example);
        return chargingstations;
    }
}
