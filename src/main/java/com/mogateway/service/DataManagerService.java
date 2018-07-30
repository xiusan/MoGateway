package com.mogateway.service;


import com.mogateway.entity.CloudAddressManager;
import com.mogateway.entity.DataManagerRealTime;
import com.mogateway.entity.DataManagerRealTimeCriteria;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.List;
import java.util.Map;

/**
 * @author weizheng
 * @create 2018-04-12 9:23
 * @desc 数据转发
 **/
public interface DataManagerService {

    /**
     * 添加云平台地址
     * @param record
     * @return
     */
    int insertSelective(CloudAddressManager record);

    /**
     * 修改云地址
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(CloudAddressManager record);

    /**
     * 查询云平台地址
     * @return
     */
    List<CloudAddressManager> queryCloudAddressManager(CloudAddressManager record);

    /**
     * 查询数据管理-获取实时状态字段key
     * @return
     */
    Map<String,Object> selectRealTimeKey();

    /**
     * 查询实时状态key集合
     * @return
     */
    List<DataManagerRealTime> selectByExample();



    /**
     * 数据管理-实时状态字段同步
     * @return
     */
    public JSONArray synchronizationRealTime();


}
