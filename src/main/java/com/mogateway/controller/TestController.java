package com.mogateway.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mogateway.redis.RedisUtil;
import com.mogateway.service.PeriodruleService;
import com.mogateway.util.CinTxt;
import com.mogateway.util.CommonUtils;
import com.mogateway.util.JsonUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Api(value="TestController", description ="测试测试")
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private StringRedisTemplate template;

    @Value("${spring.redis.address}")
    private String address;

    @Autowired
    private RedisUtil redisUtil;


    @Autowired
    private PeriodruleService periodruleService;

    @ApiOperation(value = "test", notes = "test")
    @GetMapping("/test")
    public JSONObject testRedis(@RequestParam String equNo) {
        JSONObject redisConfigObj = JSON.parseObject(CinTxt.getTxtData(address));

        String s = "{  " +
                "    \"fielType\": \"car\",  " +
                "    \"equipmentID\": \"00101\",  " +
                "    \"currentDTTM\": \"2018-04-09 16:57:26\",  " +
                "    \"message\": \"88 01 00 08 10 4C 1a bb 00 00 00\"  " +
                "}";

        String a ="{\n" +
                "                \"chargingRecordNo\": \"6\",\n" +
                "                \"equipmentNo\": \"2\",\n" +
                "                \"carNumber\": \"2\",\n" +
                "                \"cardNumber\": \"2\",\n" +
                "                \"startChargingDttm\": 1523247562000,\n" +
                "                \"endChargingDttm\": 1523247564000,\n" +
                "                \"totalChargingDttm\": 6000,\n" +
                "                \"startAmmeterNo\": 2,\n" +
                "                \"entAmmeterNo\": 2,\n" +
                "                \"totalChargingKwh\": 2,\n" +
                "                \"startSoc\": 2,\n" +
                "                \"endSoc\": 2,\n" +
                "                \"totalSoc\": 2,\n" +
                "                \"endReason\": 2,\n" +
                "                \"message\": \"2651845245265184524522651845245226518452452265184524522\",\n" +
                "                \"sharpStartChargingDttm\": 1523333977000,\n" +
                "                \"sharpEndChargingDttm\": 1523333979000,\n" +
                "                \"sharpStartAmmeterNo\": 2,\n" +
                "                \"sharpEndAmmeterNo\": 2,\n" +
                "                \"sharpTotalChargingKwh\": 2,\n" +
                "                \"peakStartChargingDttm\": 1523333985000,\n" +
                "                \"peakEndChargingDttm\": 1523333992000,\n" +
                "                \"peakStartAmmeterNo\": 2,\n" +
                "                \"peakEndAmmeterNo\": 2,\n" +
                "                \"peakTotalChargingKwh\": 2,\n" +
                "                \"flatStartChargingDttm\": 1523333999000,\n" +
                "                \"flatEndChargingDttm\": 1523334003000,\n" +
                "                \"flatStartAmmeterNo\": 2,\n" +
                "                \"flatEndAmmeterNo\": 2,\n" +
                "                \"flatTotalChargingKwh\": 2,\n" +
                "                \"valleyStartChargingDttm\": 1523334008000,\n" +
                "                \"valleyEndChargingDttm\": 1523334011000,\n" +
                "                \"valleyStartAmmeterNo\": 2,\n" +
                "                \"valleyEndAmmeterNo\": 2,\n" +
                "                \"valleyTotalChargingKwh\": 2,\n" +
                "                \"sendFlagKj\": 2,\n" +
                "                \"sendFlagOther\": 2,\n" +
                "                \"abnormalFlag\": 2,\n" +
                "                \"createUser\": \"2\",\n" +
                "                \"createDttm\": 1523334022000,\n" +
                "                \"updateUser\": \"2\",\n" +
                "                \"updateDttm\": 1523337484000,\n" +
                "                \"isAbnormal\": 1,\n" +
                "                \"isFlang\": 1,\n" +
                "                \"chargeCount\": 10\n" +
                "      }"   ;

        String conntype="        {\n" +
                "            \"connectBaudrate\": null,\n" +
                "            \"connectDirection\": 0,\n" +
                "            \"connectFile\": \"/home/pm.jar\",\n" +
                "            \"connectHomeUrl\": \"http://localhost:9090/PM\",\n" +
                "            \"connectIp\": \"127.0.0.1\",\n" +
                "            \"connectPort\": 8002,\n" +
                "            \"connectPubRedisChannel\": \"pubchannel\",\n" +
                "            \"connectSerialPort\": \"\",\n" +
                "            \"connectSubRedisChannel\": \"subchannel\",\n" +
                "            \"connectType\": \"tcpServer\",\n" +
                "            \"createDttm\": [\n" +
                "                \"java.util.Date\",\n" +
                "                1522839826000\n" +
                "            ],\n" +
                "            \"createUser\": \"admin\",\n" +
                "            \"enabled\": 1,\n" +
                "            \"id\": 45,\n" +
                "            \"updateDttm\": [\n" +
                "                \"java.util.Date\",\n" +
                "                1523261619000\n" +
                "            ],\n" +
                "            \"updateUser\": \"admin\"\n" +
                "        }";

String str= "{\n" +
        "  \"ammeterNo\": \"0\",\n" +
        "  \"chargedKwh\": \"36\",\n" +
        "  \"chargedTime\": \"23分15秒\",\n" +
        "  \"chargingGunStatus\": \"0\",\n" +
        "  \"communicateStatus\": \"0\",\n" +
        "  \"currentSoc\": \"89\",\n" +
        "  \"equipmentNo\": \"004\",\n" +
        "  \"faultDesc\": \"折了\",\n" +
        "  \"faultStatus\": \"0\",\n" +
        "  \"hardwareVersion\": \"0.3.6(20180226)\",\n" +
        "  \"outputCurrent\": \"0\",\n" +
        "  \"outputPower\": \"0\",\n" +
        "  \"outputVoltage\": \"0\",\n" +
        "  \"softwareVersion\": \"0.3.6(20180226)\",\n" +
        "  \"startChargingAmmeterNo\": 36524,\n" +
        "  \"startChargingDttm\": \"1524672000000\",\n" +
        "  \"workStatus\": \"0\"\n" +
        "}";
            net.sf.json.JSONObject realtimejson = new net.sf.json.JSONObject();
            realtimejson.put("ammeterNo","-");
        String realtime= "{  " +
                "            \"ammeterNo\": \"0\", "+
                "            \"chargedKwh\": \"36\", "+
                "            \"chargedTime\": \"23分15秒\"," +
                "            \"chargingGunStatus\": \"0\", "+
                "            \"communicateStatus\": \"0\", "+
                "            \"currentSoc\": \"89\", "+
                "            \"equipmentID\": \"08701\"," +
                "            \"faultDesc\": \"折了\"," +
                "            \"faultStatus\": \"0\", "+
                "            \"hardwareVersion\": \"0.3.6(20180226)\"," +
                "            \"outputCurrent\": \"0\", "+
                "            \"outputPower\": \"0\", "+
                "            \"outputVoltage\": \"0\", "+
                "            \"softwareVersion\": \"0.3.6(20180226)\"," +
                "            \"startChargingAmmeterNo\": 36524," +
                "            \"startChargingDttm\": \"1524672000000\"," +
                "            \"workStatus\": \"0\" "+
                "        }";

        net.sf.json.JSONObject json = new net.sf.json.JSONObject();
        /**
         *         json.put("ammeterNo", 0);
         json.put("chargedKwh", 0);
         json.put("chargedTime", 0);
         json.put("chargingGunStatus", 0);
         json.put("communicateStatus", 0);
         json.put("currentSoc", 0);
         json.put("equipmentNo", "004");
         json.put("faultDesc", 0);
         json.put("faultStatus", 0);
         json.put("hardwareVersion", 0);
         json.put("outputCurrent", 0);
         json.put("outputPower", 0);
         json.put("outputVoltage", 0);
         json.put("softwareVersion", 0);
         json.put("startChargingAmmeterNo", 0);
         json.put("startChargingDttm", 0);
         json.put("workStatus", 0);
         */

        json.put("ammeterNo","0");
        json.put("chargedKWH", "0");
        json.put("chargedTime", "0");
        json.put("chargingGunStatus", "0");
        json.put("communicateStatus", "0");
        json.put("currentSOC", "55");
        json.put("equipmentID", equNo);
        json.put("faultStatus", "0");
        json.put("outputCurrent", "100");
        json.put("outputPower","0");
        json.put("outputVoltage", "99");
        json.put("startChargingAmmeterNo", "0");
        json.put("startChargingDTTM", "0");
        json.put("workStatus","0");



        net.sf.json.JSONObject chargeRecordjson = new net.sf.json.JSONObject();
        chargeRecordjson.put("chargingRecordNo","-");
        chargeRecordjson.put("equipmentNo","-");
        chargeRecordjson.put("carNumber","-");
        chargeRecordjson.put("cardNumber","-");
        chargeRecordjson.put("startChargingDttm","-");
        chargeRecordjson.put("endChargingDttm","-");
        chargeRecordjson.put("totalChargingDttm","-");
        chargeRecordjson.put("startAmmeterNo","-");
        chargeRecordjson.put("entAmmeterNo","-");
        chargeRecordjson.put("totalChargingKwh","-");
        chargeRecordjson.put("startSoc","-");
        chargeRecordjson.put("endSoc","-");
        chargeRecordjson.put("totalSoc","-");
        chargeRecordjson.put("endReason","-");
        chargeRecordjson.put("message","-");
        chargeRecordjson.put("sharpStartChargingDttm","-");
        chargeRecordjson.put("sharpEndChargingDttm","-");
        chargeRecordjson.put("sharpStartAmmeterNo","-");
        chargeRecordjson.put("sharpEndAmmeterNo","-");
        chargeRecordjson.put("sharpTotalChargingKwh","-");
        chargeRecordjson.put("peakStartChargingDttm","-");
        chargeRecordjson.put("peakEndChargingDttm","-");
        chargeRecordjson.put("peakStartAmmeterNo","-");
        chargeRecordjson.put("peakEndAmmeterNo","-");
        chargeRecordjson.put("peakTotalChargingKwh","-");
        chargeRecordjson.put("flatStartChargingDttm","-");
        chargeRecordjson.put("flatEndChargingDttm","-");
        chargeRecordjson.put("flatStartAmmeterNo","-");
        chargeRecordjson.put("flatEndAmmeterNo","-");
        chargeRecordjson.put("flatTotalChargingKwh","-");
        chargeRecordjson.put("valleyStartChargingDttm","-");
        chargeRecordjson.put("valleyEndChargingDttm","-");
        chargeRecordjson.put("valleyStartAmmeterNo","-");
        chargeRecordjson.put("valleyEndAmmeterNo","-");
        chargeRecordjson.put("valleyTotalChargingKwh","-");
        chargeRecordjson.put("sendFlagKj","-");
        chargeRecordjson.put("sendFlagOther","-");
        chargeRecordjson.put("abnormalFlag","-");
        chargeRecordjson.put("createUser","-");
        chargeRecordjson.put("createDttm","-");
        chargeRecordjson.put("updateUser","-");
        chargeRecordjson.put("updateDttm","-");
        chargeRecordjson.put("isAbnormal","-");
        chargeRecordjson.put("isFlang","-");
        chargeRecordjson.put("chargeCount","-");
        //template.convertAndSend(redisConfigObj.getString("realTime_sub_channel"),json.toString());

        //template.convertAndSend(redisConfigObj.getString("realTime_sub_channel"),json.toString());
        List<Map<String,Object>> periodruleList = periodruleService.findLIstAll();
        String periodruleLists = JsonUtils.objectToJson(periodruleList);
        //periodrulejson.put("timePeriodRule", periodruleLists );
        redisUtil.setValue("chargingPeroidRules",periodruleLists);
        return null;
    }

}
