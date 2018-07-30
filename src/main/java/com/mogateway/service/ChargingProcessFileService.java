package com.mogateway.service;


import com.mogateway.entity.ChargingProcessFile;

import java.util.List;

/**
 * @author weizheng
 * @create 2018-04-18 16:29
 * @desc 充电过程
 **/
public interface ChargingProcessFileService {

    /**
     * 查询充电过程集合
     * @param chargingProcessFile
     * @return
     */
    List<ChargingProcessFile> selectByExample(ChargingProcessFile chargingProcessFile);

    /**
     * 修改充电过程集合同步状态
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(ChargingProcessFile record);

}
