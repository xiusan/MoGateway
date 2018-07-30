package com.mogateway.service;

import com.github.pagehelper.PageInfo;
import com.mogateway.entity.RealTime;

import java.util.List;
import java.util.Map;

/**
 * @author weizheng
 * @create 2018-04-04 11:24
 * @desc 实时状态
 **/
public interface RealTimeService {

    /**
     * 查询实时状态数据集合
     * @param realTime
     * @return
     */
    PageInfo<RealTime> queryList(Map<String, Object> map, int start, int length);

    /**
     * 根据设备no查询实时状态详细信息
     * @param equipmentNo
     * @return
     */
    RealTime selectByNo(String equipmentNo);

    public List<RealTime> queryList1(RealTime realTime);
}
