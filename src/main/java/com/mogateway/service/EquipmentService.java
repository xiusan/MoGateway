package com.mogateway.service;

import com.github.pagehelper.PageInfo;
import com.mogateway.entity.Ammeter;
import com.mogateway.entity.AmmeterCriteria;
import com.mogateway.entity.Equipment;

import java.util.List;

public interface EquipmentService {
    /**
     * 根据设备id查询设备详细信息
     * @param equipmentid
     * @return
     */
    Equipment selectByPrimaryKey(String equipmentid);

    /**
     * 根据设备no查询设备详细信息
     * @param equipmentNo
     * @return
     */
    Equipment selectByNo(String equipmentNo);

    /**
     * 查询设备数据集合
     * @param equipment
     * @return
     */
    PageInfo<Equipment> queryList(Equipment equipment, int start, int length, String sortColumnsName, String sortOrder);

    /**
     * 查询设备数据集合
     * @param equipment
     * @return
     */
    List<Equipment> queryList(Equipment equipment);

    /**
     * 添加设备信息
     * @param record
     * @return
     */
    int insertSelective(Equipment record);

    /**
     * 修改设备信息
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Equipment record);

    /**
     * 查询电表列表
     * @param ammeter
     * @return
     */
    List<Ammeter> selectAmmeterByExample(Ammeter ammeter);
}
