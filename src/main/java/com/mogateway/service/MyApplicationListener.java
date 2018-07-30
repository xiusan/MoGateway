package com.mogateway.service;

import com.mogateway.contans.Constants;
import com.mogateway.entity.*;
import com.mogateway.mapper.AgreementMapper;
import com.mogateway.mapper.ChargingstationMapper;
import com.mogateway.mapper.CloudAddressManagerMapper;
import com.mogateway.mapper.ConnectTypeMapper;
import com.mogateway.redis.RedisUtil;
import com.mogateway.util.JsonUtils;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018-03-27.
 */
@Component
public class MyApplicationListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private ConnectManageService connectManageService;

    @Autowired
    private ConnectTypeMapper connectTypeMapper;

    @Autowired
    private ConnectTypeRedis connectTypeRedis;

    @Autowired
    private AgreementMapper agreementMapper;

    @Autowired
    private AgreementRedis agreementRedis;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private CloudAddressManagerMapper cloudAddressManagerMapper;


    @Autowired
    private PeriodruleService periodruleService;

    @Autowired
    private ChargingstationMapper chargingstationMapper;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (event.getApplicationContext().getParent() == null) {
            connectTypeMapper.disableConnectType();
            List<ConnectType> connectTypes = connectManageService.getConnectTypes();
            if (connectTypes.size() == 0) {
                redisUtil.pubLog("main","主程序", "admin","没有连接类型");
            } else {
                connectTypeRedis.setConnectRedis(connectTypes);
            }
            agreementMapper.disableAgreement();
            List<Agreement> agreements = agreementMapper.getAgreements();
            if (agreements.size() == 0) {
                redisUtil.pubLog("main","主程序", "admin","没有协议类型");
            } else {
                agreementRedis.setAgreementRedis(agreements);
            }
            //缓存云地址
            CloudAddressManagerCriteria example = new CloudAddressManagerCriteria();
            CloudAddressManagerCriteria.Criteria criteria = example.createCriteria();
            List<CloudAddressManager> cloudAddressManagers = cloudAddressManagerMapper.selectByExample(example);
            JSONObject realTimeJsonObject = JSONObject.fromObject(cloudAddressManagers.get(0));
            redisUtil.setValue(Constants.CLOUD_ADDRESS_MANAGER,realTimeJsonObject.toString());

            Chargingstation chargingstation = chargingstationMapper.getChargingstation();
            redisUtil.setValue("chargingStationID", chargingstation.getChargingStationId());
            redisUtil.setValue("chargingStationName", chargingstation.getChargingStationName());

            //缓存尖峰时刻
            List<Map<String,Object>> periodruleList = periodruleService.findLIstAll();
            String periodruleLists = JsonUtils.objectToJson(periodruleList);
            //periodrulejson.put("timePeriodRule", periodruleLists );
            redisUtil.setValue("chargingPeroidRules",periodruleLists);
        }
    }
}
