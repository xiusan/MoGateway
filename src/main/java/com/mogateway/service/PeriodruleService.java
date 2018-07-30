package com.mogateway.service;


import com.mogateway.entity.Periodrule;

import java.sql.Time;
import java.util.List;
import java.util.Map;

/**
 * @author weizheng
 * @create 2018-05-30 13:50
 * @desc
 **/
public interface PeriodruleService {
    List<Periodrule> selectByExample(Time time);

    List<Map<String,Object>> findLIstAll();
}
