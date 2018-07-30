package com.mogateway.service;


import com.mogateway.entity.DataManagerRealTime;

import java.util.List;

/**
 * @author weizheng
 * @create 2018-04-13 9:09
 * @desc 数据管理-实时状态
 **/
public interface DataManagerRealTimeService {

    /**
     * 添加实时状态地段
     * @param record
     * @return
     */
    int insertSelective(DataManagerRealTime record);

    /**
     * 查询实时状态信息
     * @param record
     * @return
     */
    List<DataManagerRealTime> selectByExample(DataManagerRealTime record);

    /**
     * 删除实时状态信息
     * @param
     * @return
     */
    int deleteTable();

    /**
     * 修改实时状态信息
     * @param
     * @return
     */
    int updateRealTime();

    int updateByPrimaryKey(DataManagerRealTime dataManagerRealTime);

}