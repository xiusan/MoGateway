package com.mogateway.controller;

import com.mogateway.entity.Agreement;
import com.mogateway.redis.RedisUtil;
import com.mogateway.service.AgreementService;
import com.mogateway.util.CommonUtils;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018-04-10.
 */
@RestController
public class AgreementController extends BaseController {

    @Autowired
    private AgreementService agreementService;

    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping(value = "/getAgreements")
    public Map<String, Object> getAgreements() {
        map.clear();
        List<Agreement> agreements = null;
        try {
            agreements = agreementService.getAgreements();
            if (agreements != null) {
                JSONArray agreementJsonArrays = new JSONArray();
                for (int i = 0;i < agreements.size();i++) {
                    String key = CommonUtils.getKey("agreement",agreements.get(i).getAgreementID());
                    if (redisUtil.exists(key)) {
                        JSONObject agreementJson = JSONObject.fromObject(redisUtil.getValue(key));
                        agreementJsonArrays.add(agreementJson);
                    }
                }
                map.put("agreements", agreementJsonArrays);
                map.put("result", "success");
            } else {
                map.put("result", "failed");
                map.put("connectTypes", null);
            }
        } catch (Exception e) {
            redisUtil.pubLog("AgreementManage", "协议管理", "admin", CommonUtils.exception2Str(e));
            map.put("result", "error");
        }
        return map;
    }

    @RequestMapping(value = "/addAgreement")
    public Map<String, Object> addAgreement(Agreement agreement, MultipartFile file) {
        map.clear();
        try {
            String filePath = agreementService.addAgreementFile(file, agreement.getAgreementID());
            agreement.setAgreementAddr(filePath);
            int execCnt = agreementService.addAgreement(agreement, "admin");
            if (execCnt > 0) {
                map.put("result", "success");
                redisUtil.pubLog("AgreementManage", "协议管理", "admin", "添加协议类型成功");
            } else {
                map.put("result", "failed");
                redisUtil.pubLog("AgreementManage", "协议管理", "admin", "添加协议类型失败");
            }
        } catch (Exception e) {
            redisUtil.pubLog("AgreementManage", "协议管理", "admin", CommonUtils.exception2Str(e));
            map.put("result", "error");
        }
        return map;
    }

    @RequestMapping(value = "/operateAgreement")
    public Map<String, Object> operateAgreement(String operation, String agreementID) {
        redisUtil.pubLog("AgreementManage", "协议管理", "admin", operation + "协议类型:" + agreementID);
        map.clear();
        map.put("operation", operation);
        try {
            agreementService.operateAgreement(operation, agreementID);
            map.put("result", "success");
        } catch (Exception e) {
            redisUtil.pubLog("AgreementManage", "协议管理", "admin", CommonUtils.exception2Str(e));
            map.put("result", "error");
        }
        return map;
    }

    @RequestMapping("/getOperateAgreementResult")
    public Map<String, Object> getOperateAgreementResult(String operation, String agreementID) {
        map.clear();
        JSONObject json = null;
        String key = CommonUtils.getKey("agreement", agreementID);
        if (redisUtil.exists(key)) {
            json = JSONObject.fromObject(redisUtil.getValue(key).toString());
        }
        if ("start".equals(operation)) {
            if (CommonUtils.checkUrlConnection(json.getString("agreementHomeUrl")) == 200) {
                try {
                    int exCnt = agreementService.updateAgreement(operation, agreementID, "admin");
                    if (exCnt > 0) {
                        map.put("result", "success");
                    } else {
                        map.put("result", "failed");
                    }
                } catch (Exception e) {
                    map.put("result", "error");
                    redisUtil.pubLog("AgreementManage", "协议管理", "admin", CommonUtils.exception2Str(e));
                }
            } else {
                map.put("result", "failed");
            }
        } else {
            if (CommonUtils.checkUrlConnection(json.getString("agreementHomeUrl")) == -1) {
                try {
                    int exCnt = agreementService.updateAgreement(operation, agreementID, "admin");
                    if (exCnt > 0) {
                        map.put("result", "success");
                    } else {
                        map.put("result", "failed");
                    }
                } catch (Exception e) {
                    map.put("result", "failed");
                    redisUtil.pubLog("AgreementManage", "协议管理", "admin", CommonUtils.exception2Str(e));
                }
            } else {
                map.put("result", "failed");
            }
        }
        map.put("operation", operation);
        return map;
    }
}
