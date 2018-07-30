package com.mogateway.service.impl;

import com.mogateway.entity.Periodrule;
import com.mogateway.entity.PeriodruleCriteria;
import com.mogateway.mapper.PeriodruleMapper;
import com.mogateway.service.PeriodruleService;
import com.mogateway.util.DateUtil;
import com.mogateway.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author weizheng
 * @create 2018-05-30 13:51
 * @desc
 **/
@Service
public class PeriodruleServiceImpl implements PeriodruleService {
    @Autowired
    private PeriodruleMapper periodruleMapper;

    @Override
    public List<Periodrule> selectByExample(Time time) {
        PeriodruleCriteria example = new PeriodruleCriteria();
        PeriodruleCriteria.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotEmpty(time)){
            criteria.andPeriodstartdttmLessThanOrEqualTo(time);
            criteria.andPeriodenddttmGreaterThan(time);

        }
        return periodruleMapper.selectByExample(example);
    }

    @Override
    public List<Map<String,Object>> findLIstAll() {
        PeriodruleCriteria example = new PeriodruleCriteria();
        PeriodruleCriteria.Criteria criteria = example.createCriteria();
        List<Periodrule> periodruleList = periodruleMapper.finListAll(example);

        List<Map<String,Object>> mapList = new ArrayList<>();
        for (Periodrule per : periodruleList) {
            Map<String,Object> map = new HashMap<>();
            map.put("periodStartDTTM", DateUtil.formatDate3ShortStringNoStr(per.getPeriodstartdttm()) );
            map.put("periodEndDTTM",DateUtil.formatDate3ShortStringNoStr(per.getPeriodenddttm()));
            map.put("PeriodID",per.getPeriodstartid());
            mapList.add(map);
        }
        return mapList;
    }
}
