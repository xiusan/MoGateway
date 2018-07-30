package com.mogateway.service.impl;

import com.mogateway.contans.Constants;
import com.mogateway.entity.*;
import com.mogateway.mapper.CloudAddressManagerMapper;
import com.mogateway.mapper.DataManagerRealTimeMapper;
import com.mogateway.mapper.EquipmentMapper;
import com.mogateway.redis.RedisUtil;
import com.mogateway.service.DataManagerService;
import com.mogateway.util.JsonUtils;
import com.mogateway.util.StringTool;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author weizheng
 * @create 2018-04-12 9:24
 * @desc 数据转发管理实现类
 **/
@Service
public class DataManagerServiceImpl implements DataManagerService {
    private static Logger logger = Logger.getLogger(DataManagerServiceImpl.class);
    @Autowired
    RedisUtil redisService;

    @Autowired
    private CloudAddressManagerMapper cloudAddressManagerMapper;

    @Autowired
    private DataManagerRealTimeMapper dataManagerRealTimeMapper;

    @Autowired
    private EquipmentMapper equipmentMapper;

    private List<DataManagerRealTime> dataManagerRealTimes = null;

    private List<Equipment> equipmentList = null;

    @Override
    public int insertSelective(CloudAddressManager record) {
        return cloudAddressManagerMapper.insertSelective(record);
    }

    @Override
    public int updateByPrimaryKeySelective(CloudAddressManager record) {
        redisService.remove(Constants.CLOUD_ADDRESS_MANAGER);
        return cloudAddressManagerMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<CloudAddressManager> queryCloudAddressManager(CloudAddressManager record) {
        JSONObject jsonObject = JSONObject.fromObject(redisService.getValue(Constants.CLOUD_ADDRESS_MANAGER));
        if (StringTool.isNotEmpty(jsonObject)){
            record.setCloudId(jsonObject.getString("cloudId"));
            record.setCustomerCloudAddress(jsonObject.getString("customerCloudAddress"));
            record.setIsCertificate(jsonObject.getInt("isCertificate"));
            record.setIsSynchronization(jsonObject.getInt("isSynchronization"));
            record.setKjCloudAddress(jsonObject.getString("kjCloudAddress"));
            List<CloudAddressManager> cloudAddressManagerList = new ArrayList<>();
            cloudAddressManagerList.add(record);
            return cloudAddressManagerList;
        }

        CloudAddressManagerCriteria example = new CloudAddressManagerCriteria();
        CloudAddressManagerCriteria.Criteria criteria = example.createCriteria();
        List<CloudAddressManager> cloudAddressManagers = cloudAddressManagerMapper.selectByExample(example);
        redisService.setValue(Constants.CLOUD_ADDRESS_MANAGER,cloudAddressManagers);
        return cloudAddressManagers;
    }

    @Override
    public Map<String,Object> selectRealTimeKey() {
        Map<String,Object> modelMap = new HashMap<>();
        String realTimestr = JsonUtils.objectToJson(redisService.getValue(Constants.DATA_MANAGER_REAL_TIME));
        List<RealTime> list2=(List<RealTime>)JSONArray.toList(JSONArray.fromObject(realTimestr), RealTime.class);

        List<String> keyList = new ArrayList<>();
        net.sf.json.JSONObject json= net.sf.json.JSONObject.fromObject(list2.get(0));
        Map<String, Object> map =json;
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            keyList.add(entry.getKey());
        }
        modelMap.put("workStatus",keyList.get(0));
        modelMap.put("chargedKwh",keyList.get(1));
        modelMap.put("chargedTime",keyList.get(2));
        modelMap.put("outputPower",keyList.get(3));
        modelMap.put("chargingGunStatus",keyList.get(4));
        modelMap.put("outputVoltage",keyList.get(5));
        modelMap.put("faultStatus",keyList.get(6));
        modelMap.put("equipmentNo",keyList.get(7));
        modelMap.put("faultDesc",keyList.get(8));
        modelMap.put("outputCurrent",keyList.get(9));
        modelMap.put("startChargingAmmeterNo",keyList.get(10));
        modelMap.put("communicateStatus",keyList.get(11));
        modelMap.put("startChargingDttm",keyList.get(12));
        modelMap.put("currentSoc",keyList.get(13));
        modelMap.put("hardwareVersion",keyList.get(14));
        modelMap.put("softwareVersion",keyList.get(15));
        modelMap.put("ammeterNo",keyList.get(16));
        return modelMap;
    }

    @Override
    public List<DataManagerRealTime> selectByExample() {
        DataManagerRealTimeCriteria example = new DataManagerRealTimeCriteria();
        DataManagerRealTimeCriteria.Criteria criteria = example.createCriteria();
        List<DataManagerRealTime> dataManagerRealTimes = dataManagerRealTimeMapper.selectByExample(example);
        return dataManagerRealTimes;
    }

    @Override
    public JSONArray synchronizationRealTime(){
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = new JSONObject();
        DataManagerRealTimeCriteria example = new DataManagerRealTimeCriteria();
        DataManagerRealTimeCriteria.Criteria criteria = example.createCriteria();
        criteria.andIsSynchronizationEqualTo(1);
        if (dataManagerRealTimes == null) {
            dataManagerRealTimes = dataManagerRealTimeMapper.selectByExample(example);
        }
        StringBuffer stringBuffer = new StringBuffer();
        int num=0;
        EquipmentCriteria equipmentCriteria= new EquipmentCriteria();
        EquipmentCriteria.Criteria criteria1 = equipmentCriteria.createCriteria();
            equipmentList = equipmentMapper.selectByExample(equipmentCriteria);
        for (Equipment equipment:equipmentList) {
            if ( !redisService.exists(Constants.DATA_MANAGER_REAL_TIME + equipment.getEquipmentNo())){
                continue;
            }
            JSONObject realTimeJsonObject = JSONObject.fromObject(redisService.getValue(Constants.DATA_MANAGER_REAL_TIME + equipment.getEquipmentNo()));
            if (StringTool.isNotEmpty(realTimeJsonObject)) {
                for (DataManagerRealTime dataManagerRealTime : dataManagerRealTimes) {
                    if (realTimeJsonObject.has(dataManagerRealTime.getKeyName())) {
                        if ("communicateStatus".equals(dataManagerRealTime.getKeyName())) {
                            if (Integer.parseInt(realTimeJsonObject.getString(dataManagerRealTime.getKeyName())) == 0) {
                                jsonObject.put("communicationState", "正常");
                            } else {
                                jsonObject.put("communicationState", "断开");
                            }
                        } else if ("workStatus".equals(dataManagerRealTime.getKeyName())) {
                            String value = realTimeJsonObject.getString(dataManagerRealTime.getKeyName());
                            if ("-".equals(value)) {
                                jsonObject.put("deviceState", "故障");
                            } else {
                                if (Integer.parseInt(value) == 1) {
                                    jsonObject.put("deviceState", "充电中");
                                } else if (Integer.parseInt(value) == 2) {
                                    jsonObject.put("deviceState", "充电结束");
                                } else if (Integer.parseInt(value) == 3) {
                                    jsonObject.put("deviceState", "空闲");
                                }  else if (Integer.parseInt(value) == 0) {
                                    jsonObject.put("deviceState", "空闲");
                                }  else {
                                    jsonObject.put("deviceState", "故障");
                                }
                            }
                        } else if ("outputCurrent".equals(dataManagerRealTime.getKeyName())) {
                            jsonObject.put("outputElectric" ,realTimeJsonObject.getString(dataManagerRealTime.getKeyName()));
                        }else if ("faultStatus".equals(dataManagerRealTime.getKeyName())){
                            String value = realTimeJsonObject.getString(dataManagerRealTime.getKeyName());
                            if ("-".equals(value)) {
                                jsonObject.put("faultStatus", "故障");
                            } else {
                                if (Integer.parseInt(value) == 1) {
                                    jsonObject.put("faultStatus", "故障");
                                } else if (Integer.parseInt(value) == 0) {
                                    jsonObject.put("faultStatus", "正常");
                                }
                            }
                        }else if ("chargingGunStatus".equals(dataManagerRealTime.getKeyName())){
                            String value = realTimeJsonObject.getString(dataManagerRealTime.getKeyName());
                            if ("-".equals(value)) {
                                jsonObject.put("chargingGunStatus", "无");
                            } else {
                                if (Integer.parseInt(value) == 1) {
                                    jsonObject.put("chargingGun", "已连接");
                                } else if (Integer.parseInt(value) == 0) {
                                    jsonObject.put("chargingGun", "未连接");
                                }
                            }
                        } else {
                            jsonObject.put(dataManagerRealTime.getKeyName(), realTimeJsonObject.getString(dataManagerRealTime.getKeyName()));
                        }
                    }
                }
            }
            jsonArray.add(jsonObject);
        }

        System.out.println(jsonArray.toString());
        return jsonArray;
    }
}
