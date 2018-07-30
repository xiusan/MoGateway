package com.mogateway.controller;

import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageInfo;
import com.mogateway.contans.Constants;
import com.mogateway.entity.*;
import com.mogateway.mapper.ChargingstationMapper;
import com.mogateway.quartzJob.ExecutJob;
import com.mogateway.redis.RedisUtil;
import com.mogateway.service.*;
import com.mogateway.util.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author weizheng
 * @create 2018-04-12 9:26
 * @desc 数据转发管理接口
 **/
@Api(value="DataManagerController", description ="数据转发管理接口")
@RestController
@RequestMapping(value = "/dataManager")
public class DataManagerController {

    @Autowired
    private DataManagerService dataManagerService;
    @Autowired
    private DataManagerRealTimeService dataManagerRealTimeService;

    @Autowired
    private HistoryDataService historyDataService;

    @Autowired
    private ChargeRecordService chargeRecordService;

    @Autowired
    private ChargingProcessFileService chargingProcessFileService;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private ChargingstationMapper chargingstationMapper;

    private static Logger log = LoggerFactory.getLogger(DataManagerController.class);


    @ApiOperation(value = "添加云平台地址", notes = "添加云平台地址")
    @RequestMapping(value="/addCloudAddressManager", method= RequestMethod.POST)
    public Result addCloudAddressManager(CloudAddressManager cloudAddressManager){
        redisUtil.pubLog("CloudAddressManager", "数据转发", "admin", "添加云平台地址开始");
        Result res = new Result();
        try {
            if (cloudAddressManager.getCustomerCloudAddress()==null){
                res.addError("cloud1001","客户平台地址不能为空");
                return res;
            }
            if (cloudAddressManager.getKjCloudAddress()==null){
                res.addError("cloud1002","科佳云平台地址不能为空");
                return res;
            }

            if (cloudAddressManager.getIsCertificate()==null){
                res.addError("cloud1004","证书不能为空");
                return res;
            }

            cloudAddressManager.setCloudId(OrderUtils.getOrderNo());
            int count = dataManagerService.insertSelective(cloudAddressManager);
            if (count>0){
                res.addSuccess(count);
                redisUtil.pubLog("CloudAddressManager", "数据转发", "admin", "添加云平台地址成功");
                return res;
            }
        } catch (Exception e) {
            redisUtil.pubLog("CloudAddressManager", "数据转发", "admin", CommonUtils.exception2Str(e));
            res.addError(ErrorCode.SYS40002,ErrorCode.SYS40002_INFO);
        }
        return res;
    }

    @ApiOperation(value = "查询云平台地址", notes = "查询云平台地址")
    @RequestMapping(value="/queryCloudAddressManager", method= RequestMethod.POST)
    public Result queryCloudAddressManager(CloudAddressManager cloudAddressManager){

        Result res = new Result();
        try {
             List<CloudAddressManager> cloudAddressManagerList = dataManagerService.queryCloudAddressManager(cloudAddressManager);
             res.addSuccess(cloudAddressManagerList);
             return res;
        } catch (Exception e) {
            redisUtil.pubLog("CloudAddressManager", "数据转发", "admin", CommonUtils.exception2Str(e));
            res.addError(ErrorCode.SYS40005,ErrorCode.SYS40005_INFO);
        }
        return res;
    }

    @ApiOperation(value = "修改云平台地址", notes = "修改云平台地址")
    @RequestMapping(value="/putCloudAddressManager", method= RequestMethod.POST)
    public Result putCloudAddressManager(CloudAddressManager cloudAddressManager){
        redisUtil.pubLog("CloudAddressManager", "数据转发", "admin", "修改云平台地址开始");
        Result res = new Result();
        try {
            if (cloudAddressManager.getCustomerCloudAddress()==null){
                res.addError("cloud1001","客户平台地址不能为空");
                return res;
            }
            if (cloudAddressManager.getKjCloudAddress()==null){
                res.addError("cloud1002","科佳云平台地址不能为空");
                return res;
            }

            if (cloudAddressManager.getIsCertificate()==null){
                res.addError("cloud1004","证书不能为空");
                return res;
            }

            int count = dataManagerService.updateByPrimaryKeySelective(cloudAddressManager);
            if (count>0){
                res.addSuccess(count);
                redisUtil.pubLog("CloudAddressManager", "数据转发", "admin", "修改云平台地址成功");
                return res;
            }
        } catch (Exception e) {
            redisUtil.pubLog("CloudAddressManager", "数据转发", "admin", CommonUtils.exception2Str(e));
            res.addError(ErrorCode.SYS40003,ErrorCode.SYS40003_INFO);
        }
        return res;
    }

    @ApiOperation(value = "数据管理-实时状态列表", notes = "数据管理-实时状态列表")
    @RequestMapping(value="/dataManagerRealTime", method= RequestMethod.POST)
    public Result dataManagerRealTime(){
        Map<String,Object> map = new HashMap<>();
        Result res = new Result();
        try {
            //map = dataManagerService.selectRealTimeKey();
            DataManagerRealTime dataManagerRealTime = new DataManagerRealTime();
            List<DataManagerRealTime> dataManagerRealTimes = dataManagerRealTimeService.selectByExample(dataManagerRealTime );
            res.addSuccess(dataManagerRealTimes);
        } catch (Exception e) {
            redisUtil.pubLog("CloudAddressManager", "数据转发", "admin", CommonUtils.exception2Str(e));
            res.addError(ErrorCode.SYS40005,ErrorCode.SYS40005_INFO);
        }
        return res;
    }


    @ApiOperation(value = "数据管理-添加实时状态字段", notes = "数据管理-添加实时状态字段")
    @RequestMapping(value="/addDataManagerRealTime", method= RequestMethod.POST)
    public Result adddataManagerRealTime(DataManagerRealTime dataManagerRealTime, @RequestParam(required = false, defaultValue = "")String checkVal){
        redisUtil.pubLog("CloudAddressManager", "数据转发", "admin", "添加实时状态开始");
        Result res = new Result();
        try {
            if ("[]".equals(checkVal)){
                res.addError("realTime1001","选项不能为空");
                return res;
            }

            JSONArray json = JSONArray.parseArray(checkVal);
            Object[] jsonArray =  json.toArray();
            int delCount = dataManagerRealTimeService.deleteTable();
            if (delCount>0){
                res.addSuccess(delCount);
            }
            for (int i=0;i<jsonArray.length;i++){
                dataManagerRealTime.setKeyName(jsonArray[i].toString());
                List<DataManagerRealTime> dataManagerRealTimes = dataManagerRealTimeService.selectByExample(dataManagerRealTime);
                dataManagerRealTime.setId(OrderUtils.getOrderNo());
                dataManagerRealTime.setIsSynchronization(1);
                if(dataManagerRealTimes.size()!=0){
                    res.addError(ErrorCode.PUB10003,ErrorCode.PUB10003_INFO);
                    return res;
                }
                int count = dataManagerRealTimeService.insertSelective(dataManagerRealTime);
                if (count>0){
                    res.addSuccess(count);
                    redisUtil.pubLog("CloudAddressManager", "数据转发", "admin", "添加实时状态成功");
                }
            }
            return res;
        } catch (Exception e) {
            redisUtil.pubLog("CloudAddressManager", "数据转发", "admin", CommonUtils.exception2Str(e));
            res.addError(ErrorCode.SYS40002,ErrorCode.SYS40002_INFO);
        }
        return res;
    }

    @ApiOperation(value = "数据管理-修改实时状态字段", notes = "数据管理-修改实时状态字段")
    @RequestMapping(value="/putDataManagerRealTime", method= RequestMethod.POST)
    public Result putDataManagerRealTime(DataManagerRealTime realTime ,@RequestParam(required = false, defaultValue = "")String checkVal){
        redisUtil.pubLog("CloudAddressManager", "数据转发", "admin", "添加实时状态开始");
        Result res = new Result();
        try {
            if ("[]".equals(checkVal)){
                res.addError("realTime1001","选项不能为空");
                return res;
            }

            JSONArray json = JSONArray.parseArray(checkVal);
            Object[] jsonArray =  json.toArray();
            int putCount = dataManagerRealTimeService.updateRealTime();
            if (putCount>0){
                res.addSuccess(putCount);
            }
            for (int i=0;i<jsonArray.length;i++){
                realTime.setId(jsonArray[i].toString());
                realTime.setIsSynchronization(1);
                int count = dataManagerRealTimeService.updateByPrimaryKey(realTime);
                if (count>0){
                    res.addSuccess(count);
                    redisUtil.pubLog("CloudAddressManager", "数据转发", "admin", "修改实时状态成功");
                }
            }
            return res;
        } catch (Exception e) {
            redisUtil.pubLog("CloudAddressManager", "数据转发", "admin", CommonUtils.exception2Str(e));
            res.addError(ErrorCode.SYS40003,ErrorCode.SYS40003_INFO);
        }
        return res;
    }

    @ApiOperation(value = "数据管理-实时状态字段科佳云地址同步", notes = "数据管理-实时状态字段同步")
    @RequestMapping(value="/dataManagerRealTimeCloudSyn", method= RequestMethod.POST)
    public Result dataManagerRealTimeCloudSyn(){
        redisUtil.pubLog("CloudAddressManager", "数据转发", "admin", "实时状态字段同步开始");
        Result res = new Result();
        try {
            //查询云地址
            JSONObject cloudAddressJsonObject = JSONObject.fromObject(redisUtil.getValue(Constants.CLOUD_ADDRESS_MANAGER));
            Map<String, Object> map = new HashMap<>();
            net.sf.json.JSONArray jsonArray = dataManagerService.synchronizationRealTime();
            map.put("equipmentData",jsonArray);
            map.put("chargingStationID", chargingstationMapper.getChargingstationID());
            map.put("currentVersion", "0.0.1");
            Map<String, Object> requestMap = new HashMap<String, Object>();
            EncrypDES encrypDES = new EncrypDES();
            requestMap.put("realTimeData", CommonUtils.byte2HexStr(encrypDES.Encrytor(JSONObject.fromObject(map, new JsonConfig()).toString())));
            requestMap.put("deskey", CommonUtils.byte2HexStr(encrypDES.getDeskey().getEncoded()));
            if (cloudAddressJsonObject.getString("kjCloudAddress").indexOf("https") >= 0  ) {
                JSONObject resultJsonObject = RequestUtil.requestHttps(cloudAddressJsonObject.getString("kjCloudAddress")+ Constants.KJ_CLOUD_ADDRESS_URL, requestMap);
                if (resultJsonObject != null && resultJsonObject.has("chargingRequestInfo")) {
                    JSONObject chargingRequestInfo = JSONObject.fromObject(resultJsonObject.getString("chargingRequestInfo"));
                    log.info("https:同步云平台返回的数据"+resultJsonObject.toString());
                    System.out.println("https:同步云平台返回的数据"+resultJsonObject.toString());
                    redisUtil.pubMsg(chargingRequestInfo.toString(), "station_response_channel");
                }
            }else {
                JSONObject resultJsonObject = RequestUtil.requestHttpUrl(cloudAddressJsonObject.getString("kjCloudAddress")+ Constants.KJ_CLOUD_ADDRESS_URL, requestMap);
                if (resultJsonObject != null && resultJsonObject.has("chargingRequestInfo")) {
                    JSONObject chargingRequestInfo = JSONObject.fromObject(resultJsonObject.getString("chargingRequestInfo"));
                    log.info("http:同步云平台返回的数据"+resultJsonObject.toString());
                    System.out.println("http:同步云平台返回的数据"+resultJsonObject.toString());
                    redisUtil.pubMsg(chargingRequestInfo.toString(), "station_response_channel");
                }
            }
            res.addSuccess(jsonArray);
            log.info("同步云平台返回的数据"+jsonArray.toString());
            redisUtil.pubLog("CloudAddressManager", "数据转发", "admin", "实时状态字段同步成功");
            return res;
        } catch (Exception e) {
            e.printStackTrace();
            redisUtil.pubLog("CloudAddressManager", "数据转发", "admin", CommonUtils.exception2Str(e));
            res.addError(ErrorCode.SYS40006,ErrorCode.SYS40006_INFO);
        }
        return res;
    }

    @ApiOperation(value = "数据管理-实时状态字段客户地址同步", notes = "数据管理-实时状态字段同步")
    @RequestMapping(value="/dataManagerRealTimeCustSyn", method= RequestMethod.POST)
    public Result dataManagerRealTimeCustSyn(){
        redisUtil.pubLog("CloudAddressManager", "数据转发", "admin", "实时状态字段同步开始");
        Result res = new Result();
        try {
            //查询云地址
            JSONObject cloudAddressJsonObject = JSONObject.fromObject(redisUtil.getValue(Constants.CLOUD_ADDRESS_MANAGER));
            Map<String, Object> map = new HashMap<>();
            net.sf.json.JSONArray jsonArray = dataManagerService.synchronizationRealTime();
            map.put("realTimeSyn",jsonArray);

            if (cloudAddressJsonObject.getString("customerCloudAddress").indexOf("https") >= 0   ) {
                RequestUtil.requestHttps(cloudAddressJsonObject.getString("customerCloudAddress")+ Constants.KJ_CLOUD_ADDRESS_URL,map);
            }else {
                RequestUtil.requestHttpUrl(cloudAddressJsonObject.getString("customerCloudAddress")+ Constants.KJ_CLOUD_ADDRESS_URL,map);
            }
            res.addSuccess(jsonArray);
            redisUtil.pubLog("CloudAddressManager", "数据转发", "admin", "实时状态字段同步成功");
            return res;
        } catch (Exception e) {
            redisUtil.pubLog("CloudAddressManager", "数据转发", "admin", CommonUtils.exception2Str(e));
            res.addError(ErrorCode.SYS40006,ErrorCode.SYS40006_INFO);
        }
        return res;
    }

    @ApiOperation(value = "数据管理-充电记录科佳云地址同步", notes = "数据管理-充电记录同步")
    @RequestMapping(value="/dataManagerChargeRecordCloudSyn", method= RequestMethod.POST)
    public Result dataManagerChargeRecordCloudSyn(){
        redisUtil.pubLog("CloudAddressManager", "数据转发", "admin", "充电记录同步开始");
        Result res = new Result();
        try {
            //查询云地址
            CloudAddressManager cloudAddressManager = new CloudAddressManager();
            JSONObject cloudAddressJsonObject = JSONObject.fromObject(redisUtil.getValue(Constants.CLOUD_ADDRESS_MANAGER));

            Map<String, Object> map = new HashMap<>();
            ChargeRecord chargeRecord = new ChargeRecord();

            int pageSize=10;
            chargeRecord.setSendFlagKj(0);
            PageInfo<ChargeRecord> pageInfo = chargeRecordService.selectByExample(chargeRecord,1,pageSize);
            int totalPage=pageInfo.getPages();

            for (int i=1;i<=totalPage;i++){
                if (pageInfo.getList().size()==0){
                    break;
                }

               // totalPage = pageInfo.getPages();
                map.put("chargeRecordList",pageInfo.getList());

                if (cloudAddressJsonObject.getString("kjCloudAddress").indexOf("https") >= 0  ) {
                    RequestUtil.requestHttps(cloudAddressJsonObject.getString("kjCloudAddress")+ Constants.KJ_CLOUD_ADDRESS_URL,map);
                }else {
                    RequestUtil.requestHttpUrl(cloudAddressJsonObject.getString("kjCloudAddress")+ Constants.KJ_CLOUD_ADDRESS_URL,map);
                }
                for (int j=0;j<pageInfo.getList().size();j++){
                    pageInfo.getList().get(j).setSendFlagKj(1);
                    int count = chargeRecordService.updateByPrimaryKeySelective(pageInfo.getList().get(j));
                    if (count!=1){

                        res.addError("SYN1001","同步后同步状态未改变错误");
                        return res;
                    }
                }
                if (i==pageInfo.getPages()){
                    break;
                }
            }
            res.addSuccess(null);
            redisUtil.pubLog("CloudAddressManager", "数据转发", "admin", "充电记录同步成功");
            return res;
        } catch (Exception e) {
            redisUtil.pubLog("CloudAddressManager", "数据转发", "admin", CommonUtils.exception2Str(e));
            res.addError(ErrorCode.SYS40006,ErrorCode.SYS40006_INFO);
        }
        return res;
    }

    @ApiOperation(value = "数据管理-充电记录客户地址同步", notes = "数据管理-充电记录同步")
    @RequestMapping(value="/dataManagerChargeRecordCustSyn", method= RequestMethod.POST)
    public Result dataManagerChargeRecordCustSyn(){
        redisUtil.pubLog("CloudAddressManager", "数据转发", "admin", "充电记录同步开始");
        Result res = new Result();
        try {
            //查询云地址
            CloudAddressManager cloudAddressManager = new CloudAddressManager();
            JSONObject cloudAddressJsonObject = JSONObject.fromObject(redisUtil.getValue(Constants.CLOUD_ADDRESS_MANAGER));

            Map<String, Object> map = new HashMap<>();
            ChargeRecord chargeRecord = new ChargeRecord();

            int pageSize=10;
            chargeRecord.setSendFlagOther(0);
            PageInfo<ChargeRecord> pageInfo = chargeRecordService.selectByExample(chargeRecord,1,pageSize);
            int totalPage=pageInfo.getPages();

            for (int i=1;i<=totalPage;i++){
                if (pageInfo.getList().size()==0){
                    break;
                }

                map.put("chargeRecordList",pageInfo.getList());

                if (cloudAddressJsonObject.getString("customerCloudAddress").indexOf("https") >= 0   ) {
                    RequestUtil.requestHttps(cloudAddressJsonObject.getString("customerCloudAddress")+ Constants.KJ_CLOUD_ADDRESS_URL,map);
                }else {
                    RequestUtil.requestHttpUrl(cloudAddressJsonObject.getString("customerCloudAddress")+ Constants.KJ_CLOUD_ADDRESS_URL,map);
                }
                for (int j=0;j<pageInfo.getList().size();j++){
                    pageInfo.getList().get(j).setSendFlagOther(1);
                    int count = chargeRecordService.updateByPrimaryKeySelective(pageInfo.getList().get(j));
                    if (count!=1){
                        res.addError("SYN1002","同步后同步状态未改变错误");
                        return res;
                    }
                }
                if (i==pageInfo.getPages()){
                    break;
                }
            }
            res.addSuccess(null);
            redisUtil.pubLog("CloudAddressManager", "数据转发", "admin", "充电记录同步成功");
            return res;
        } catch (Exception e) {
            redisUtil.pubLog("CloudAddressManager", "数据转发", "admin", CommonUtils.exception2Str(e));
            res.addError(ErrorCode.SYS40006,ErrorCode.SYS40006_INFO);
        }
        return res;
    }


    @ApiOperation(value = "数据管理-充电过程文件科佳云地址同步", notes = "数据管理-充电过程文件同步")
    @RequestMapping(value="/dataManagerChargingProcessFileSyn", method= RequestMethod.POST)
    public Result dataManagerChargingProcessFileSyn(){
        redisUtil.pubLog("CloudAddressManager", "数据转发", "admin", "充电过程文件同步开始");
        Result res = new Result();
        try {
            //查询云地址
            CloudAddressManager cloudAddressManager = new CloudAddressManager();
            List<CloudAddressManager> cloudAddressManagers = dataManagerService.queryCloudAddressManager(cloudAddressManager);

            ChargingProcessFile chargingProcessFile = new ChargingProcessFile();
            chargingProcessFile.setIsFlang(0);
            List<ChargingProcessFile> chargingProcessFileList = chargingProcessFileService.selectByExample(chargingProcessFile);

            for (ChargingProcessFile chargingProcessFile1 : chargingProcessFileList){
                Object result = null;
                if (cloudAddressManagers.get(0).getKjCloudAddress().indexOf("https") >= 0  && cloudAddressManagers.get(0).getCustomerCloudAddress().indexOf("https") >= 0 ) {
                    result =  RequestUtil.uploadHttpsUrl(cloudAddressManagers.get(0).getKjCloudAddress()+ Constants.KJ_CLOUD_ADDRESS_URL,chargingProcessFile1.getFilePath(), DateUtil.formatDate2Long(new Date()));
                }else {
                    result = RequestUtil.uploadHttpUrl(cloudAddressManagers.get(0).getKjCloudAddress()+ Constants.KJ_CLOUD_ADDRESS_URL,chargingProcessFile1.getFilePath(), DateUtil.formatDate2Long(new Date()));
                }

                if (!"NotFound".equals(result) && !"Timeout".equals(result) && !"error".equals(result)) {
                    JSONObject json = JSONObject.fromObject(result);
                    if (json.has("result")) {
                        if ("Success".equals(json.get("result").toString())) {
                            chargingProcessFile1.setIsFlang(1);
                            chargingProcessFileService.updateByPrimaryKeySelective(chargingProcessFile);
                        } else if ("Failed".equals(json.get("result").toString())) {
                            redisUtil.pubLog("CloudAddressManager", "数据转发", "admin", "第" + chargingProcessFile1.getId() + "条充电过程ID 上传到云平台失败,文件名称格式不正确！");
                        } else if ("SendFailed".equals(json.get("result").toString())) {
                            redisUtil.pubLog("CloudAddressManager", "数据转发", "admin", "第" + chargingProcessFile1.getId() + "条条充电过程ID 上传到云平台失败！");
                        }
                    }
                }
            }

            res.addSuccess(null);
            redisUtil.pubLog("CloudAddressManager", "数据转发", "admin", "充电过程文件同步成功");
            return res;
        } catch (Exception e) {
            redisUtil.pubLog("CloudAddressManager", "数据转发", "admin", CommonUtils.exception2Str(e));
            res.addError(ErrorCode.SYS40006,ErrorCode.SYS40006_INFO);
        }
        return res;
    }


    @ApiOperation(value = "数据管理-充电过程文件同步", notes = "数据管理-充电过程文件同步")
    @RequestMapping(value="/dataManagerChargingProcessFileCustSyn", method= RequestMethod.POST)
    public Result dataManagerChargingProcessFileCustSyn(){
        redisUtil.pubLog("CloudAddressManager", "数据转发", "admin", "充电过程文件同步开始");
        Result res = new Result();
        try {
            //查询云地址
            CloudAddressManager cloudAddressManager = new CloudAddressManager();
            List<CloudAddressManager> cloudAddressManagers = dataManagerService.queryCloudAddressManager(cloudAddressManager);

            ChargingProcessFile chargingProcessFile = new ChargingProcessFile();
            chargingProcessFile.setIsFlang(0);
            List<ChargingProcessFile> chargingProcessFileList = chargingProcessFileService.selectByExample(chargingProcessFile);

            for (ChargingProcessFile chargingProcessFile1 : chargingProcessFileList){
                Object result = null;
                if (cloudAddressManagers.get(0).getKjCloudAddress().indexOf("https") >= 0  && cloudAddressManagers.get(0).getCustomerCloudAddress().indexOf("https") >= 0 ) {
                    result =  RequestUtil.uploadHttpsUrl(cloudAddressManagers.get(0).getCustomerCloudAddress()+ Constants.CUST_CLOUD_ADDRESS_URL,chargingProcessFile1.getFilePath(), DateUtil.formatDate2Long(new Date()));
                }else {
                    result = RequestUtil.uploadHttpUrl(cloudAddressManagers.get(0).getCustomerCloudAddress()+ Constants.CUST_CLOUD_ADDRESS_URL,chargingProcessFile1.getFilePath(), DateUtil.formatDate2Long(new Date()));
                }

                if (!"NotFound".equals(result) && !"Timeout".equals(result) && !"error".equals(result)) {
                    JSONObject json = JSONObject.fromObject(result);
                    if (json.has("result")) {
                        if ("Success".equals(json.get("result").toString())) {
                            chargingProcessFile1.setIsFlang(1);
                            chargingProcessFileService.updateByPrimaryKeySelective(chargingProcessFile);
                        } else if ("Failed".equals(json.get("result").toString())) {
                            redisUtil.pubLog("CloudAddressManager", "数据转发", "admin", "第" + chargingProcessFile1.getId() + "条充电过程ID 上传到云平台失败,文件名称格式不正确！");
                        } else if ("SendFailed".equals(json.get("result").toString())) {
                            redisUtil.pubLog("CloudAddressManager", "数据转发", "admin", "第" + chargingProcessFile1.getId() + "条条充电过程ID 上传到云平台失败！");
                        }
                    }
                }

            }

            res.addSuccess(null);
            redisUtil.pubLog("CloudAddressManager", "数据转发", "admin", "充电过程文件同步成功");
            return res;
        } catch (Exception e) {
            redisUtil.pubLog("CloudAddressManager", "数据转发", "admin", CommonUtils.exception2Str(e));
            res.addError(ErrorCode.SYS40006,ErrorCode.SYS40006_INFO);
        }
        return res;
    }

    @ApiOperation(value = "查询数据管理-历史数据", notes = "历史数据")
    @RequestMapping(value="/queryHistoryDataList", method= RequestMethod.POST)
    public Result queryHistoryDataList(HistoryData historyData,
                                       @RequestParam(required = false, defaultValue = "1") int pageNumber,
                                       @RequestParam(required = false, defaultValue = "3") int pageSize){

        Result res = new Result();
        Map<String,Object> map = new HashMap<>();
        try {
            PageInfo<HistoryData> pageInfo = historyDataService.queryList(historyData,pageNumber,pageSize);
            System.out.println("pageInfo.getTotal():"+pageInfo.getTotal());
            map.put("recordsTotal",pageInfo.getTotal());
            map.put("recordsFiltered",pageInfo.getTotal());
            map.put("list", pageInfo.getList());
            res.addSuccess(map);
        } catch (Exception e) {
            redisUtil.pubLog("CloudAddressManager", "数据转发", "admin", CommonUtils.exception2Str(e));
            res.addError(ErrorCode.SYS40005,ErrorCode.SYS40005_INFO);
        }
        return res;
    }

    @ApiOperation(value = "修改数据管理-历史数据", notes = "修改历史数据")
    @RequestMapping(value="/putHistoryDataList", method= RequestMethod.POST)
    public Result putHistoryDataList(HistoryData historyData, @RequestParam(required = false, defaultValue = "")String idArray){
        redisUtil.pubLog("CloudAddressManager", "数据转发", "admin", "修改历史数据开始");
        Result res = new Result();
        try {
            JSONArray json = JSONArray.parseArray(idArray);
            Object[] jsonArray =  json.toArray();
            for (int i=0;i<jsonArray.length;i++){
                historyData.setHistoryId(jsonArray[i].toString());
                int count = historyDataService.updateByPrimaryKeySelective(historyData);
                if (count > 0){
                    res.addSuccess(0);
                }
            }
            res.addSuccess(0);

            return res;
        } catch (Exception e) {
            redisUtil.pubLog("CloudAddressManager", "数据转发", "admin", CommonUtils.exception2Str(e));
            res.addError(ErrorCode.SYS40003,ErrorCode.SYS40003_INFO);
        }
        return res;
    }
}
