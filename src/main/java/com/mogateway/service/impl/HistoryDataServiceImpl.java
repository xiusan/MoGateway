package com.mogateway.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mogateway.entity.HistoryData;
import com.mogateway.entity.HistoryDataCriteria;
import com.mogateway.mapper.HistoryDataMapper;
import com.mogateway.service.HistoryDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author weizheng
 * @create 2018-04-18 11:12
 * @desc 数据管理-历史数据
 **/
@Service
public class HistoryDataServiceImpl implements HistoryDataService {

    @Autowired
    private HistoryDataMapper historyDataMapper;

    @Override
    public PageInfo<HistoryData> queryList(HistoryData historyData, int start, int length) {
        HistoryDataCriteria example = new HistoryDataCriteria();
        HistoryDataCriteria.Criteria criteria = example.createCriteria();

        //分页查询
        PageHelper.startPage(start, length);
        List<HistoryData> historyDataList = historyDataMapper.selectByExample(example);

        return new PageInfo<>(historyDataList);
    }

    @Override
    public int updateByPrimaryKeySelective(HistoryData record) {
        return historyDataMapper.updateByPrimaryKeySelective(record);
    }
}
