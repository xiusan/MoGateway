package com.mogateway.service;

import com.github.pagehelper.PageInfo;
import com.mogateway.entity.HistoryData;


/**
 * @author weizheng
 * @create 2018-04-18 11:09
 * @desc 数据管理-历史数据
 **/
public interface HistoryDataService {


    /**
     * 历史数据列表
     * @param historyData
     * @param start
     * @param length
     * @return
     */
    PageInfo<HistoryData> queryList(HistoryData historyData, int start, int length);

    /**
     * 修改历史数据
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(HistoryData record);

}