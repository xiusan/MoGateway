package com.mogateway.redis;

import com.mogateway.contans.Constants;
import com.mogateway.mapper.ChargingstationMapper;
import com.mogateway.util.CommonUtils;
import com.mogateway.util.Const;
import com.mogateway.util.EncrypDES;
import com.mogateway.util.RequestUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018-05-18.
 */
@Component
public class CloudResponseReceiver implements MessageListener {

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private ChargingstationMapper chargingstationMapper;

    @Override
    public void onMessage(Message message, byte[] pattern) {
        String msg = CommonUtils.convertMsg(redisUtil.getRedisTemplate(), message);
        JSONObject json = JSONObject.fromObject(msg);
        int requestCount = 1;
        Map<String, Object> chargingData = new HashMap<String, Object>();
        Map<String, Object> operateDeviceData = new HashMap<String, Object>();
        if ("Fail".equals(json.getString("result"))) {
            operateDeviceData.put("errorCode", 1);
        } else if ("Success".equals(json.getString("result"))) {
            operateDeviceData.put("errorCode", 0);
        }
        operateDeviceData.put("orderNumber", json.getString("orderNumber"));
        chargingData.put("operateDeviceData", operateDeviceData);
        chargingData.put("chargingStationID", chargingstationMapper.getChargingstationID());
        chargingData.put("equipmentID", json.getString("equipmentID"));
        JSONObject cloudAddress = null;
        try {
            cloudAddress = JSONObject.fromObject(redisUtil.getValue(Constants.CLOUD_ADDRESS_MANAGER).toString());
        } catch (Exception e) {
            redisUtil.pubLog("chargingRecord", "充电记录", "admin", CommonUtils.exception2Str(e));
        }
        if (cloudAddress == null) {
            return;
        }
        String url = cloudAddress.getString("kjCloudAddress") + Const.CHARGINGREQUET_URL;
        while (requestCount < 4) {
            try {
                EncrypDES encrypDES = new EncrypDES();
                chargingData.put("chargingData", CommonUtils.byte2HexStr(encrypDES.Encrytor(JSONObject.fromObject(chargingData, new JsonConfig()).toString())));
                chargingData.put("deskey", CommonUtils.byte2HexStr(encrypDES.getDeskey().getEncoded()));
                JSONObject resultJsonObject = RequestUtil.requestHttpUrl(url, chargingData);
                if (resultJsonObject != null && resultJsonObject.has("result")) {
                    String requestResult = resultJsonObject.getString("result");
                    if ("Success".equals(requestResult)) {
                        redisUtil.pubLog("chargeAmount", "计费", "admin", "回复" + operateDeviceData.get("orderNumber").toString() + "启停机机命令成功," + JSONObject.fromObject(chargingData).toString());
                        break;
                    } else if ("error".equals(requestResult)) {
                        requestCount++;
                    }
                }
                redisUtil.pubLog("chargingRecord", "充电记录", "admin", "回复" + operateDeviceData.get("orderNumber").toString() + "启停机机命令失败!");
            } catch (Exception e) {
                redisUtil.pubLog("chargingRecord", "充电记录", "admin", "回复" + operateDeviceData.get("orderNumber").toString() + "启停机机命令失败!");
                redisUtil.pubLog("chargingRecord", "充电记录", "admin", CommonUtils.exception2Str(e));
            }
        }
    }
}
