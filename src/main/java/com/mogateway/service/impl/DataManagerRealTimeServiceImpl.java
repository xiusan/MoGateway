package com.mogateway.service.impl;

import com.mogateway.entity.DataManagerRealTime;
import com.mogateway.entity.DataManagerRealTimeCriteria;
import com.mogateway.mapper.DataManagerRealTimeMapper;
import com.mogateway.service.DataManagerRealTimeService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author weizheng
 * @create 2018-04-13 9:11
 * @desc 数据管理-实时状态
 **/
@Service
public class DataManagerRealTimeServiceImpl implements DataManagerRealTimeService {

    @Autowired
    private DataManagerRealTimeMapper dataManagerRealTimeMapper;

    @Override
    public int insertSelective(DataManagerRealTime record) {
        return dataManagerRealTimeMapper.insertSelective(record);
    }

    @Override
    public List<DataManagerRealTime> selectByExample(DataManagerRealTime record) {
        DataManagerRealTimeCriteria example = new DataManagerRealTimeCriteria();
        DataManagerRealTimeCriteria.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotEmpty(record.getKeyName())){
            criteria.andKeyNameEqualTo(record.getKeyName());
        }
        List<DataManagerRealTime> dataManagerRealTimes = dataManagerRealTimeMapper.selectByExample(example);
        return dataManagerRealTimes;
    }

    @Override
    public int deleteTable() {
        return dataManagerRealTimeMapper.deleteTable();
    }

    @Override
    public int updateRealTime() {
        DataManagerRealTimeCriteria example = new DataManagerRealTimeCriteria();
        DataManagerRealTimeCriteria.Criteria criteria = example.createCriteria();

        List<DataManagerRealTime> dataManagerRealTimes = dataManagerRealTimeMapper.selectByExample(example);
        for (DataManagerRealTime dataManagerRealTime :dataManagerRealTimes) {
            dataManagerRealTime.setIsSynchronization(0);
            dataManagerRealTimeMapper.updateByPrimaryKeySelective(dataManagerRealTime);
        }
        return 1;
    }

    @Override
    public int updateByPrimaryKey(DataManagerRealTime record) {
        return dataManagerRealTimeMapper.updateByPrimaryKeySelective(record);
    }
}
