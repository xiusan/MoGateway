package com.mogateway.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mogateway.contans.Constants;
import com.mogateway.entity.Equipment;
import com.mogateway.entity.EquipmentCriteria;
import com.mogateway.entity.RealTime;
import com.mogateway.entity.RealTimeCriteria;
import com.mogateway.mapper.EquipmentMapper;
import com.mogateway.mapper.RealTimeMapper;
import com.mogateway.redis.RedisUtil;
import com.mogateway.service.RealTimeService;
import com.mogateway.util.DateUtil;
import com.mogateway.util.StringUtils;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author weizheng
 * @create 2018-04-04 11:28
 * @desc
 **/
@Service
public class RealTimeServiceImpl implements RealTimeService {
    private static Logger logger = Logger.getLogger(RealTimeServiceImpl.class);

    @Autowired
    private RealTimeMapper realTimeMapper;
    @Autowired
    private RedisUtil redisService;
    @Autowired
    private EquipmentMapper equipmentMapper;

    @Override
    public PageInfo<RealTime> queryList(Map<String,Object> map , int start, int length)  {
        //查询设备号数据集合
        EquipmentCriteria equipmentExample = new EquipmentCriteria();
        EquipmentCriteria.Criteria equipmentCriteria = equipmentExample.createCriteria();

        List<RealTime> realTimeList = new ArrayList();
        List<Equipment> equipmentList = equipmentMapper.queryList(equipmentExample);
        for (Equipment equ: equipmentList) {
                RealTime realTime = new RealTime();
                JSONObject jsonObject = JSONObject.fromObject(redisService.getValue(Constants.DATA_MANAGER_REAL_TIME+equ.getEquipmentNo()));
                //System.out.println(jsonObject.toString());
                if (StringUtils.isNotEmpty(jsonObject.toString())){
                    if (jsonObject.has("equipmentID")) {
                        realTime.setEquipmentNo(jsonObject.getString("equipmentID"));
                    }



                    //realTime.setFaultDesc(jsonObject.getString("faultDesc"));
                    //realTime.setHardwareVersion(jsonObject.getString("hardwareVersion"));
                    //realTime.setSoftwareVersion(jsonObject.getString("softwareVersion"));
                    if (jsonObject.has("chargedTime")) {
                        realTime.setChargedTime(jsonObject.getString("chargedTime"));
                    }
                    if (jsonObject.has("ammeterNo")) {
                        if(jsonObject.getString("ammeterNo") !=null && !"-".equals(jsonObject.getString("ammeterNo"))  && !"null".equals(jsonObject.getString("ammeterNo")) ){
                            realTime.setAmmeterNo(Double.valueOf(jsonObject.getString("ammeterNo")));
                        }else {
                            realTime.setAmmeterNo(0.0);
                        }
                    }
                    if (jsonObject.has("chargedKWH")) {
                        if(jsonObject.getString("chargedKWH") !=null && !"-".equals(jsonObject.getString("chargedKWH"))  && !"null".equals(jsonObject.getString("chargedKWH")) ){
                            realTime.setChargedKwh(Double.valueOf(jsonObject.getString("chargedKWH")));
                        }else {
                            realTime.setChargedKwh(0.0);
                        }
                    }
                    if (jsonObject.has("currentSOC")) {
                        if(jsonObject.getString("currentSOC") !=null && !"-".equals(jsonObject.getString("currentSOC"))  && !"null".equals(jsonObject.getString("currentSOC")) ){
                            realTime.setCurrentSoc(Double.valueOf(jsonObject.getString("currentSOC")));
                        }else {
                            realTime.setCurrentSoc(0.0);
                        }
                    }
                    if (jsonObject.has("outputPower")) {
                        if(jsonObject.getString("outputPower") !=null && !"-".equals(jsonObject.getString("outputPower"))  && !"null".equals(jsonObject.getString("outputPower")) ){
                            realTime.setOutputPower(Double.valueOf(jsonObject.getString("outputPower")));
                        }else {
                            realTime.setOutputPower(0.0);
                        }
                    }
                    if (jsonObject.has("outputVoltage")) {
                        if(jsonObject.getString("outputVoltage") !=null && !"-".equals(jsonObject.getString("outputVoltage"))  && !"null".equals(jsonObject.getString("outputVoltage")) ){
                            realTime.setOutputVoltage(Double.valueOf(jsonObject.getString("outputVoltage")));
                        }else {
                            realTime.setOutputVoltage(0.0);
                        }
                    }
                    if (jsonObject.has("outputCurrent")) {
                        if(jsonObject.getString("outputCurrent") !=null && !"-".equals(jsonObject.getString("outputCurrent"))  && !"null".equals(jsonObject.getString("outputCurrent")) ){
                            realTime.setOutputCurrent(Double.valueOf(jsonObject.getString("outputCurrent")));
                        }else {
                            realTime.setOutputCurrent(0.0);
                        }
                    }
                    if (jsonObject.has("startChargingAmmeterNo")) {
                        if(jsonObject.getString("startChargingAmmeterNo") !=null && !"-".equals(jsonObject.getString("startChargingAmmeterNo"))  && !"null".equals(jsonObject.getString("startChargingAmmeterNo")) ){
                            realTime.setStartChargingAmmeterNo(Double.valueOf(jsonObject.getString("startChargingAmmeterNo")));
                        }else {
                            realTime.setStartChargingAmmeterNo(0.0);
                        }
                    }
                    if (jsonObject.has("lastRequestDTTM")) {
                        if(jsonObject.getString("lastRequestDTTM") !=null && !"-".equals(jsonObject.getString("lastRequestDTTM"))  && !"null".equals(jsonObject.getString("lastRequestDTTM")) ){
                            try {
                                realTime.setStartChargingDttm(DateUtil.praseString2LongDate(jsonObject.getString("lastRequestDTTM").toString()));
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    if (jsonObject.has("chargingGunStatus")) {
                        if(jsonObject.getString("chargingGunStatus") !=null && !"-".equals(jsonObject.getString("chargingGunStatus"))  && !"null".equals(jsonObject.getString("chargingGunStatus")) ){
                            realTime.setChargingGunStatus(Integer.valueOf(jsonObject.getString("chargingGunStatus")));
                        }else {
                            realTime.setChargingGunStatus(3);
                        }
                    }
                    if (jsonObject.has("communicateStatus")) {
                        if(jsonObject.getString("communicateStatus") !=null && !"-".equals(jsonObject.getString("communicateStatus"))  && !"null".equals(jsonObject.getString("communicateStatus")) ){
                            realTime.setCommunicateStatus(Integer.valueOf(jsonObject.getString("communicateStatus")));
                        }else {
                            realTime.setCommunicateStatus(3);
                        }
                    }
                    if (jsonObject.has("faultStatus")) {
                        if(jsonObject.getString("faultStatus") !=null && !"-".equals(jsonObject.getString("faultStatus"))  && !"null".equals(jsonObject.getString("faultStatus")) ){
                            realTime.setFaultStatus(Integer.valueOf(jsonObject.getString("faultStatus")));
                        }else {
                            realTime.setFaultStatus(3);
                        }
                    }
                    if (jsonObject.has("workStatus")) {
                        if(jsonObject.getString("workStatus") !=null && !"-".equals(jsonObject.getString("workStatus"))  && !"null".equals(jsonObject.getString("workStatus")) ){
                            realTime.setWorkStatus(Integer.valueOf(jsonObject.getString("workStatus")));
                        }else {
                            realTime.setWorkStatus(6);
                        }
                    }
                    realTimeList.add(realTime);
                }
        }

        List<RealTime> realTimes = new ArrayList<>();
        if (StringUtils.isNotEmpty(map.get("equipmentNo")) || StringUtils.isNotEmpty(map.get("communicateStatus")) || StringUtils.isNotEmpty(map.get("workStatus")) ){
            for (int i=0;i<realTimeList.size();i++) {
                if (map.get("equipmentNo").equals(realTimeList.get(i).getEquipmentNo()) || map.get("communicateStatus").equals(realTimeList.get(i).getCommunicateStatus().toString())  || map.get("workStatus").equals(realTimeList.get(i).getWorkStatus().toString())){
                    realTimes.add(realTimeList.get(i));
                }
            }
        }

        //分页查询
        PageHelper.startPage(start, length);
        if (realTimes.size()==0){
            return new PageInfo<>(realTimeList);
        }
        return  new PageInfo<>(realTimes);
    }
    @Override
    public List<RealTime> queryList1(RealTime realTime )  {


         RealTimeCriteria example = new RealTimeCriteria();
         RealTimeCriteria.Criteria  criteria = example.createCriteria();

         if (StringUtils.isNotEmpty(realTime.getEquipmentNo())){
         criteria.andEquipmentNoEqualTo(realTime.getEquipmentNo());
         }
         if(!"null".equals(realTime.getCommunicateStatus()) && null != realTime.getCommunicateStatus()){
         criteria.andCommunicateStatusEqualTo(realTime.getCommunicateStatus());
         }
         if (!"null".equals(realTime.getWorkStatus()) && null != realTime.getWorkStatus()){
         criteria.andWorkStatusEqualTo(realTime.getWorkStatus());
         }
         example.setOrderByClause(" equipment_no  DESC  ");



         List<RealTime> realTimes = realTimeMapper.selectByExample(example);

         //返回结果之前，向缓存中添加数据
         try {
         redisService.setValue(Constants.DATA_MANAGER_REAL_TIME, realTimes);
         } catch (Exception e) {
         e.printStackTrace();
         }
        return  realTimes;
    }
    @Override
    public RealTime selectByNo(String equipmentNo) {
        return realTimeMapper.selectByNo(equipmentNo);
    }
}
