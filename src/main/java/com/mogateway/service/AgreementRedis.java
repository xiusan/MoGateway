package com.mogateway.service;

import com.mogateway.entity.Agreement;
import com.mogateway.redis.RedisUtil;
import com.mogateway.util.CmdUtil;
import com.mogateway.util.CommonUtils;
import com.sun.jna.Platform;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2018-04-11.
 */
@Component
public class AgreementRedis {

    @Autowired
    private RedisUtil redisUtil;

    public void setAgreementRedis(List<Agreement> agreements) {
        for (Agreement agreement:agreements) {
            String key = CommonUtils.getKey("agreement", agreement.getAgreementID());
            if (redisUtil.exists(key)) {
                JSONObject oldJson = JSONObject.fromObject(redisUtil.getValue(key).toString());
                if (oldJson.has("agreementPID")) {
                    int pid = oldJson.getInt("agreementPID");
                    if (pid != -1) {
                        try {
                            CmdUtil.killProcess(pid);
                        } catch (Exception e) {
                            continue;
                        }
                    }
                }
            }
            JSONObject json = new JSONObject();
            json.put("agreementID", agreement.getAgreementID());
            json.put("agreementName", agreement.getAgreementName());
            if (agreement.getAgreementAddr() == null || "".equals(agreement.getAgreementAddr())) {
                json.put("agreementAddr", "-");
            } else {
                json.put("agreementAddr", agreement.getAgreementAddr());
            }
            if (agreement.getAgreementSubChannel() == null || "".equals(agreement.getAgreementSubChannel())) {
                json.put("agreementSubChannel", "-");
            } else {
                json.put("agreementSubChannel", agreement.getAgreementSubChannel());
            }
            if (agreement.getAgreementPubChannel() == null || "".equals(agreement.getAgreementPubChannel())) {
                json.put("agreementPubChannel", "-");
            } else {
                json.put("agreementPubChannel", agreement.getAgreementPubChannel());
            }
            if (agreement.getAgreementHomeUrl() == null || "".equals(agreement.getAgreementHomeUrl())) {
                json.put("agreementHomeUrl", "-");
            } else {
                json.put("agreementHomeUrl", agreement.getAgreementHomeUrl());
            }
            if (agreement.getEnabled() == 0) {
                json.put("enabled", "启用");
            } else {
                json.put("enabled", "禁用");
            }
            json.put("agreementStatus", "异常");
            json.put("agreementPID", -1);
            json.put("agreementCount", 0);
            redisUtil.setValue(key, json.toString());
            if (agreement.getEnabled() == 1) {
                continue;
            }
            if (CommonUtils.checkUrlConnection(agreement.getAgreementHomeUrl()) == 200) {
                continue;
            }
            if (!Platform.isWindows() && Platform.isLinux()) {
                redisUtil.pubLog("agreementManage", "协议管理", "admin", "启动" + agreement.getAgreementName() + "失败,系统不支持");
            } else {
                File file = new File(agreement.getAgreementAddr());
                if (!file.exists()) {
                    redisUtil.pubLog("agreementManage", "协议管理", "admin", agreement.getAgreementAddr() + "文件不存在");
                    continue;
                }
                try {
                    CmdUtil.startJar(agreement.getAgreementAddr());
                } catch (Exception e) {
                    redisUtil.pubLog("agreementManage", "协议管理", "admin", CommonUtils.exception2Str(e));
                }
            }
        }
    }
}
