package com.mogateway.redis;

import com.mogateway.contans.Constants;
import com.mogateway.entity.ChargeRecord;
import com.mogateway.service.ChargeRecordService;
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

import javax.crypto.NoSuchPaddingException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018-04-28.
 */
@Component
public class ChargeRecordReceiver implements MessageListener {

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private ChargeRecordService chargeRecordService;

    @Override
    public void onMessage(Message message, byte[] pattern) {

        String msg = CommonUtils.convertMsg(redisUtil.getRedisTemplate(), message);
        if ("".equals(message) || message == null) {
            return;
        }
        JSONObject json = JSONObject.fromObject(message.toString());
        ChargeRecord chargeRecord = new ChargeRecord();
        if (json.has("orderNumber")) {
            chargeRecord.setOrderNumber(json.getString("orderNumber"));
        }
        if (json.has("chargedAmount")) {
            if (json.get("chargedAmount") != null && !"".equals(json.getString("chargedAmount")) && !"-".equals(json.getString("chargedAmount"))){
                chargeRecord.setChargedAmount(Double.parseDouble(json.getString("chargedAmount")));
            }
        }
        if (json.has("discountAmount")) {
            if (json.get("discountAmount") != null && !"".equals(json.getString("discountAmount")) && !"-".equals(json.getString("discountAmount"))){
                chargeRecord.setDiscountAmount(Double.parseDouble(json.getString("discountAmount")));
            }
        }
        if (json.has("chargingRecordNo")) {
            chargeRecord.setChargingRecordNo(json.getString("chargingRecordNo"));
        }
        if (json.has("equipmentID")) {
            chargeRecord.setEquipmentNo(json.getString("equipmentID"));
        }
        if (json.has("chargingStationID")) {
            chargeRecord.setChargingStationId(json.getString("chargingStationID"));
        }
        if (json.has("carNumber")) {
            chargeRecord.setCarNumber(json.getString("carNumber"));
        }
        if (json.has("cardNumber")) {
            chargeRecord.setCardNumber(json.getString("cardNumber"));
        }
        if (json.has("startChargingDTTM")) {
            if (json.getString("startChargingDTTM") !=null && !"-".equals(json.getString("startChargingDTTM"))  && !"".equals(json.getString("startChargingDTTM")) ){
                chargeRecord.setStartChargingDttm(CommonUtils.parseDate(json.getString("startChargingDTTM"), "yyyy-MM-dd HH:mm:ss"));
            }
        }
        if (json.has("endChargingDTTM")) {
            if (json.getString("endChargingDTTM") !=null && !"-".equals(json.getString("endChargingDTTM"))  && !"".equals(json.getString("endChargingDTTM")) ){
                chargeRecord.setEndChargingDttm(CommonUtils.parseDate(json.getString("endChargingDTTM"), "yyyy-MM-dd HH:mm:ss"));
            }
        }
        if (json.has("totalChargingDTTM")) {
            if (json.getString("totalChargingDTTM") !=null && !"-".equals(json.getString("totalChargingDTTM"))  && !"".equals(json.getString("totalChargingDTTM")) ){
                chargeRecord.setTotalChargingDttm(Integer.parseInt(json.getString("totalChargingDTTM")));
            }
        }
        if (json.has("startAmmeterNo")) {
            if (json.getString("startAmmeterNo") !=null && !"-".equals(json.getString("startAmmeterNo"))  && !"".equals(json.getString("startAmmeterNo")) ){
                chargeRecord.setStartAmmeterNo(Double.parseDouble(json.getString("startAmmeterNo")));
            }
        }
        if (json.has("endAmmeterNo")) {
            if (json.getString("endAmmeterNo") !=null && !"-".equals(json.getString("endAmmeterNo"))  && !"".equals(json.getString("endAmmeterNo")) ){
                chargeRecord.setEntAmmeterNo(Double.parseDouble(json.getString("endAmmeterNo")));
            }
        }
        if (json.has("totalChargingKWH")) {
            if (json.getString("totalChargingKWH") !=null && !"-".equals(json.getString("totalChargingKWH"))  && !"".equals(json.getString("totalChargingKWH")) ){
                chargeRecord.setTotalChargingKwh(Double.parseDouble(json.getString("totalChargingKWH")));
            }
        }
        if (json.has("startSOC")) {
            if (json.getString("startSOC") !=null && !"-".equals(json.getString("startSOC"))  && !"".equals(json.getString("startSOC")) ){
                chargeRecord.setStartSoc(Integer.parseInt(json.getString("startSOC")));
            }
        }
        if (json.has("endSOC")) {
            if (json.getString("endSOC") !=null && !"-".equals(json.getString("endSOC"))  && !"".equals(json.getString("endSOC")) ){
                chargeRecord.setEndSoc(Integer.parseInt(json.getString("endSOC")));
            }
        }
        if (json.has("totalSOC")) {
            if (json.getString("totalSOC") !=null && !"-".equals(json.getString("totalSOC"))  && !"".equals(json.getString("totalSOC")) ){
                chargeRecord.setTotalSoc(Integer.parseInt(json.getString("totalSOC")));
            }
        }
        if (json.has("endReason")) {
            if (json.getString("endReason") !=null && !"-".equals(json.getString("endReason"))  && !"".equals(json.getString("endReason")) ){
                chargeRecord.setEndReason(Integer.parseInt(json.getString("endReason")));
            }
        }
        if (json.has("message")) {
            chargeRecord.setMessage(json.getString("message"));
        }
        if (json.has("sharpStartChargingDTTM")) {
            if (json.getString("sharpStartChargingDTTM") !=null && !"-".equals(json.getString("sharpStartChargingDTTM"))  && !"".equals(json.getString("sharpStartChargingDTTM")) ){
                chargeRecord.setSharpStartChargingDttm(CommonUtils.parseDate(json.getString("sharpStartChargingDTTM"), "yyyy-MM-dd HH:mm:ss"));
            }
        }
        if (json.has("sharpEndChargingDTTM")) {
            if (json.getString("sharpEndChargingDTTM") !=null && !"-".equals(json.getString("sharpEndChargingDTTM"))  && !"".equals(json.getString("sharpEndChargingDTTM")) ){
                chargeRecord.setSharpEndChargingDttm(CommonUtils.parseDate(json.getString("sharpEndChargingDTTM"), "yyyy-MM-dd HH:mm:ss"));
            }
        }
        if (json.has("sharpStartAmmeterNo")) {
            if (json.getString("sharpStartAmmeterNo") !=null && !"-".equals(json.getString("sharpStartAmmeterNo"))  && !"".equals(json.getString("sharpStartAmmeterNo")) ){
                chargeRecord.setSharpStartAmmeterNo(Double.parseDouble(json.getString("sharpStartAmmeterNo")));
            }
        }
        if (json.has("sharpEndAmmeterNo")) {
            if (json.getString("sharpEndAmmeterNo") !=null && !"-".equals(json.getString("sharpEndAmmeterNo"))  && !"".equals(json.getString("sharpEndAmmeterNo")) ){
                chargeRecord.setSharpEndAmmeterNo(Double.parseDouble(json.getString("sharpEndAmmeterNo")));
            }
        }
        if (json.has("sharpTotalChargingKWH")) {
            if (json.getString("sharpTotalChargingKWH") !=null && !"-".equals(json.getString("sharpTotalChargingKWH"))  && !"".equals(json.getString("sharpTotalChargingKWH")) ){
                chargeRecord.setSharpTotalChargingKwh(Double.valueOf(json.getString("sharpTotalChargingKWH")) );
            }
        }
        if (json.has("sharpTotalChargingDTTM")) {
            if (json.getString("sharpTotalChargingDTTM") !=null && !"-".equals(json.getString("sharpTotalChargingDTTM"))  && !"".equals(json.getString("sharpTotalChargingDTTM")) ){
                chargeRecord.setSharpTotalChargingDTTM(json.getInt("sharpTotalChargingDTTM"));
            }
        }
        if (json.has("sharpTotalChargingAmount")) {
            if (json.getString("sharpTotalChargingAmount") !=null && !"-".equals(json.getString("sharpTotalChargingAmount"))  && !"".equals(json.getString("sharpTotalChargingAmount")) ){
                chargeRecord.setSharpTotalChargingAmount(json.getDouble("sharpTotalChargingAmount"));
            }
        }
        if (json.has("peakStartChargingDTTM")) {
            if (json.getString("peakStartChargingDTTM") !=null && !"-".equals(json.getString("peakStartChargingDTTM"))  && !"".equals(json.getString("peakStartChargingDTTM")) ){
                chargeRecord.setPeakStartChargingDttm(CommonUtils.parseDate(json.getString("peakStartChargingDTTM"), "yyyy-MM-dd HH:mm:ss"));
            }
        }
        if (json.has("peakEndChargingDTTM")) {
            if (json.getString("peakEndChargingDTTM") !=null && !"-".equals(json.getString("peakEndChargingDTTM"))  && !"".equals(json.getString("peakEndChargingDTTM")) ){
                chargeRecord.setPeakEndChargingDttm(CommonUtils.parseDate(json.getString("peakEndChargingDTTM"), "yyyy-MM-dd HH:mm:ss"));
            }
        }
        if (json.has("peakStartAmmeterNo")) {
            if (json.getString("peakStartAmmeterNo") !=null && !"-".equals(json.getString("peakStartAmmeterNo"))  && !"".equals(json.getString("peakStartAmmeterNo")) ){
                chargeRecord.setPeakStartAmmeterNo(Double.parseDouble(json.getString("peakStartAmmeterNo")));
            }
        }
        if (json.has("peakEndAmmeterNo")) {
            if (json.getString("peakEndAmmeterNo") !=null && !"-".equals(json.getString("peakEndAmmeterNo"))  && !"".equals(json.getString("peakEndAmmeterNo")) ){
                chargeRecord.setPeakEndAmmeterNo(Double.parseDouble(json.getString("peakEndAmmeterNo")));
            }
        }
        if (json.has("peakTotalChargingKWH")) {
            if (json.getString("peakTotalChargingKWH") !=null && !"-".equals(json.getString("peakTotalChargingKWH"))  && !"".equals(json.getString("peakTotalChargingKWH")) ){
                chargeRecord.setPeakTotalChargingKwh(Double.valueOf(json.getString("peakTotalChargingKWH")) );
            }
        }
        if (json.has("peakTotalChargingDTTM")) {
            if (json.getString("peakTotalChargingDTTM") !=null && !"-".equals(json.getString("peakTotalChargingDTTM"))  && !"".equals(json.getString("peakTotalChargingDTTM")) ){
                chargeRecord.setSharpTotalChargingDTTM(json.getInt("peakTotalChargingDTTM"));
            }
        }
        if (json.has("peakTotalChargingAmount")) {
            if (json.getString("peakTotalChargingAmount") !=null && !"-".equals(json.getString("peakTotalChargingAmount"))  && !"".equals(json.getString("peakTotalChargingAmount")) ){
                chargeRecord.setSharpTotalChargingAmount(json.getDouble("peakTotalChargingAmount"));
            }
        }
        if (json.has("flatStartChargingDTTM")) {
            if (json.getString("flatStartChargingDTTM") !=null && !"-".equals(json.getString("flatStartChargingDTTM"))  && !"".equals(json.getString("flatStartChargingDTTM")) ){
                chargeRecord.setFlatStartChargingDttm(CommonUtils.parseDate(json.getString("flatStartChargingDTTM"), "yyyy-MM-dd HH:mm:ss"));
            }
        }
        if (json.has("flatEndChargingDTTM")) {
            if (json.getString("flatEndChargingDTTM") !=null && !"-".equals(json.getString("flatEndChargingDTTM"))  && !"".equals(json.getString("flatEndChargingDTTM")) ){
                chargeRecord.setFlatEndChargingDttm(CommonUtils.parseDate(json.getString("flatEndChargingDTTM"), "yyyy-MM-dd HH:mm:ss"));
            }
        }
        if (json.has("flatStartAmmeterNo")) {
            if (json.getString("flatStartAmmeterNo") !=null && !"-".equals(json.getString("flatStartAmmeterNo"))  && !"".equals(json.getString("flatStartAmmeterNo")) ){
                chargeRecord.setFlatStartAmmeterNo(Double.parseDouble(json.getString("flatStartAmmeterNo")));
            }
        }
        if (json.has("flatEndAmmeterNo")) {
            if (json.getString("flatEndAmmeterNo") !=null && !"-".equals(json.getString("flatEndAmmeterNo"))  && !"".equals(json.getString("flatEndAmmeterNo")) ){
                chargeRecord.setFlatEndAmmeterNo(Double.parseDouble(json.getString("flatEndAmmeterNo")));
            }
        }
        if (json.has("flatTotalChargingKWH")) {
            if (json.getString("flatTotalChargingKWH") !=null && !"-".equals(json.getString("flatTotalChargingKWH"))  && !"".equals(json.getString("flatTotalChargingKWH")) ){
                chargeRecord.setFlatTotalChargingKwh(Double.valueOf(json.getString("flatTotalChargingKWH")) );
            }
        }
        if (json.has("flatTotalChargingDTTM")) {
            if (json.getString("flatTotalChargingDTTM") !=null && !"-".equals(json.getString("flatTotalChargingDTTM"))  && !"".equals(json.getString("flatTotalChargingDTTM")) ){
                chargeRecord.setSharpTotalChargingDTTM(json.getInt("flatTotalChargingDTTM"));
            }
        }
        if (json.has("flatTotalChargingAmount")) {
            if (json.getString("flatTotalChargingAmount") !=null && !"-".equals(json.getString("flatTotalChargingAmount"))  && !"".equals(json.getString("flatTotalChargingAmount")) ){
                chargeRecord.setSharpTotalChargingAmount(json.getDouble("flatTotalChargingAmount"));
            }
        }
        if (json.has("valleyStartChargingDTTM")) {
            if (json.getString("valleyStartChargingDTTM") !=null && !"-".equals(json.getString("valleyStartChargingDTTM"))  && !"".equals(json.getString("valleyStartChargingDTTM")) ){
                chargeRecord.setValleyStartChargingDttm(CommonUtils.parseDate(json.getString("valleyStartChargingDTTM"), "yyyy-MM-dd HH:mm:ss"));
            }
        }
        if (json.has("valleyEndChargingDTTM")) {
            if (json.getString("valleyEndChargingDTTM") !=null && !"-".equals(json.getString("valleyEndChargingDTTM"))  && !"".equals(json.getString("valleyEndChargingDTTM")) ){
                chargeRecord.setValleyEndChargingDttm(CommonUtils.parseDate(json.getString("valleyEndChargingDTTM"), "yyyy-MM-dd HH:mm:ss"));
            }
        }

        if (json.has("valleyStartAmmeterNo")) {
            if (json.getString("valleyStartAmmeterNo") !=null && !"-".equals(json.getString("valleyStartAmmeterNo"))  && !"".equals(json.getString("valleyStartAmmeterNo")) ){
                chargeRecord.setValleyStartAmmeterNo(Double.parseDouble(json.getString("valleyStartAmmeterNo")));
            }
        }
        if (json.has("valleyEndAmmeterNo")) {
            if (json.getString("valleyEndAmmeterNo") !=null && !"-".equals(json.getString("valleyEndAmmeterNo"))  && !"".equals(json.getString("valleyEndAmmeterNo")) ){
                chargeRecord.setValleyEndAmmeterNo(Double.parseDouble(json.getString("valleyEndAmmeterNo")));
            }
        }
        if (json.has("valleyTotalChargingKWH")) {
            if (json.getString("valleyTotalChargingKWH") !=null && !"-".equals(json.getString("valleyTotalChargingKWH"))  && !"".equals(json.getString("valleyTotalChargingKWH")) ){
                chargeRecord.setValleyTotalChargingKwh(Double.valueOf(json.getString("valleyTotalChargingKWH")) );
            }
        }
        if (json.has("valleyTotalChargingDTTM")) {
            if (json.getString("valleyTotalChargingDTTM") !=null && !"-".equals(json.getString("valleyTotalChargingDTTM"))  && !"".equals(json.getString("valleyTotalChargingDTTM")) ){
                chargeRecord.setSharpTotalChargingDTTM(json.getInt("valleyTotalChargingDTTM"));
            }
        }
        if (json.has("valleyTotalChargingAmount")) {
            if (json.getString("valleyTotalChargingAmount") !=null && !"-".equals(json.getString("valleyTotalChargingAmount"))  && !"".equals(json.getString("valleyTotalChargingAmount")) ){
                chargeRecord.setSharpTotalChargingAmount(json.getDouble("valleyTotalChargingAmount"));
            }
        }
        if (json.has("sendFlagKJ")) {
            if (json.getString("sendFlagKJ") !=null && !"-".equals(json.getString("sendFlagKJ"))  && !"".equals(json.getString("sendFlagKJ")) ){
                chargeRecord.setSendFlagKj(Integer.parseInt(json.getString("sendFlagKJ")));
            }
        }
        chargeRecord.setSendFlagOther(1);
        if (json.has("abnormalFlag")) {
            if (json.getString("abnormalFlag") !=null && !"-".equals(json.getString("abnormalFlag"))  && !"".equals(json.getString("abnormalFlag")) ){
                chargeRecord.setAbnormalFlag(Integer.parseInt(json.getString("abnormalFlag")));
            }
        }
        if (json.has("createUser")) {
            chargeRecord.setCreateUser(json.getString("createUser"));
        }
        if (json.has("createDTTM")) {
            if (json.getString("createDTTM") !=null && !"-".equals(json.getString("createDTTM"))  && !"".equals(json.getString("createDTTM")) ){
                chargeRecord.setCreateDttm(CommonUtils.parseDate(json.getString("createDTTM"), "yyyy-MM-dd HH:mm:ss"));
            }
        }
        if (json.has("updateUser")) {
            chargeRecord.setUpdateUser(json.getString("updateUser"));
        }
        if (json.has("updateDTTM")) {
            if (json.getString("updateDTTM") !=null && !"-".equals(json.getString("updateDTTM"))  && !"".equals(json.getString("updateDTTM")) ){
                chargeRecord.setUpdateDttm(CommonUtils.parseDate(json.getString("updateDTTM"), "yyyy-MM-dd HH:mm:ss"));
            }
        }
        /*Map<String, Object> requestMap = new HashMap<String, Object>();
        try {
            EncrypDES encrypDES = new EncrypDES();
            JSONArray jsonArray = new JSONArray();
            jsonArray.add(json);
            requestMap.put("chargingRecordData", CommonUtils.byte2HexStr(encrypDES.Encrytor(JSONArray.fromObject(jsonArray, new JsonConfig()).toString())));
            requestMap.put("deskey", CommonUtils.byte2HexStr(encrypDES.getDeskey().getEncoded()));
            redisUtil.pubLog("chargingRecord", "充电记录", "admin", "结算请求数据:" + jsonArray.toString());
            JSONObject cloudAddress = JSONObject.fromObject(redisUtil.getValue(Constants.CLOUD_ADDRESS_MANAGER).toString());
            String url = cloudAddress.getString("kjCloudAddress") + Const.CHARGINGRECORD_URL_DT;
            JSONObject resultJsonObject = RequestUtil.requestHttpUrl(url, requestMap);
            if (resultJsonObject != null && resultJsonObject.has("result")) {
                if ("Success".equals(resultJsonObject.get("result"))) {
                    if (resultJsonObject.has("resultPay")) {
                        if ("Success".equals(resultJsonObject.getString("resultPay"))) {
                            redisUtil.pubLog("chargingRecord", "充电记录", "admin", "结算成功" + resultJsonObject.toString());
                        }
                    }
                    chargeRecord.setSendFlagKj(1);
                }
            }
        } catch (Exception e) {
            redisUtil.pubLog("chargingRecord", "充电记录", "admin", CommonUtils.exception2Str(e));
            chargeRecord.setSendFlagKj(0);
        }*/
        chargeRecord.setSendFlagKj(1);
        chargeRecord.setAbnormalFlag(1);
        chargeRecord.setCreateUser("admin");
        chargeRecord.setUpdateUser("admin");
        chargeRecordService.insertSelective(chargeRecord);
    }
}
