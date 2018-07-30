package com.mogateway.service;

import com.github.pagehelper.PageInfo;
import com.mogateway.entity.SerialConfig;
import com.mogateway.entity.SerialConfigCriteria;

import java.util.List;

/**
 * @author weizheng
 * @create 2018-05-15 15:07
 * @desc 电表配置
 **/
public interface SerialConfigService {

    /**
     * 删除
     * @param serialName
     * @return
     */
    int deleteByPrimaryKey(String serialName);

    /**
     * 添加
     * @param record
     * @return
     */
    int insertSelective(SerialConfig record);

    /**
     * 修改
     * @param record
     * @return
     */
    int updateByPrimaryKey(SerialConfig record);

    /**
     * 分页列表
     * @param record
     * @param start
     * @param length
     * @return
     */
    PageInfo<SerialConfig> selectByExample(SerialConfig record, int start, int length);


    /**
     * 查询全部列表信息
     * @return
     */
    List<SerialConfig> selectByExample();

    /**
     * 查询详情
     * @param serialName
     * @return
     */
    SerialConfig selectByPrimaryKey(String serialName);
}
