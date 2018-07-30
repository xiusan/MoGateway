package com.mogateway.controller;

import com.mogateway.contans.Constants;
import com.mogateway.entity.Equipment;
import com.mogateway.mapper.ChargingstationMapper;
import com.mogateway.redis.RedisUtil;
import com.mogateway.service.EquipmentService;
import com.mogateway.util.Const;
import com.mogateway.util.RequestUtil;
import com.mogateway.util.Tools;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018-05-08.
 */
@RestController
public class LongPollingController {

    @Autowired
    private RedisUtil redisUtil;

    private Map<String, Object> map = new HashMap<String, Object>();

    private String chargingStationID = null;

    @Autowired
    private ChargingstationMapper chargingstationMapper;

    @Autowired
    private EquipmentService equipmentService;

    @Value("${spring.redis.stationResponseChannel}")
    private String stationResponseChannel;

    @RequestMapping("/requestHomePolling")
    public void requestHomePolling() throws Exception {
        if (!map.containsKey("chargingStationID")) {
            if (chargingStationID == null) {
                chargingStationID = chargingstationMapper.getChargingstationID();
            }
            map.put("chargingStationID", chargingStationID);
        }
        JSONObject cloudAddress = null;
        try {
            cloudAddress = JSONObject.fromObject(redisUtil.getValue(Constants.CLOUD_ADDRESS_MANAGER).toString());
        } catch (Exception e) {
        }
        if (cloudAddress == null) {
            return;
        }
        String url = cloudAddress.getString("kjCloudAddress") + Const.CLOUD_ASKFORCOMMAND_URL;
        JSONObject result = RequestUtil.requestHttpUrl(url, map);
        if (result != null && result.has("chargingRequestInfo")) {
            JSONObject chargingRequestInfo = JSONObject.fromObject(result.getString("chargingRequestInfo"));
            if (chargingRequestInfo.has("operation")) {
                if (chargingRequestInfo.has("equipmentID")){
                    Equipment equipment = equipmentService.selectByPrimaryKey(chargingRequestInfo.getString("equipmentID"));
                    if ("97".equals(equipment.getAgreementId())){
                        redisUtil.pubMsg(chargingRequestInfo.toString(), Const.OPERATE_AMMETER_CHANNEL);
                    }else if ("9".equals(equipment.getAgreementId())){
                        redisUtil.pubMsg(chargingRequestInfo.toString(), stationResponseChannel);
                        //云返回服务费
                        if(chargingRequestInfo.has("serviceCharge")){
                            String serviceCharge = chargingRequestInfo.getString("serviceCharge");
                            redisUtil.setValue(Tools.getKey(equipment.getEquipmentId(),"serviceCharge"), serviceCharge);
                        }
                    }
                }
            }
        }
    }
}
