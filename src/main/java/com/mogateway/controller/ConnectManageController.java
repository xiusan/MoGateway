package com.mogateway.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.mogateway.entity.ConnectType;
import com.mogateway.redis.RedisUtil;
import com.mogateway.service.ConnectManageService;
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
 * Created by Administrator on 2018-01-09.
 */
@RestController
public class ConnectManageController extends BaseController {

    @Autowired
    private ConnectManageService connectManageService;

    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping("/getConnectTypes")
    public Map<String, Object> getLinkTypes() {
        map.clear();
        List<ConnectType> connectTypes = null;
        try {
            connectTypes = connectManageService.getConnectTypes();
            if (connectTypes != null) {
                JSONArray connectTypeJsons = new JSONArray();
                for (int i = 0;i < connectTypes.size();i++) {
                    JSONObject connectTypeJson = JSONObject.fromObject(redisUtil.getValue(CommonUtils.getKey("connectType",connectTypes.get(i).getConnectType())));
                    connectTypeJsons.add(connectTypeJson);
                }
                map.put("connectTypes", connectTypeJsons);
                map.put("result", "success");
            } else {
                map.put("result", "failed");
                map.put("connectTypes", null);
            }
        } catch (Exception e) {
            map.put("result", "error");
            redisUtil.pubLog("ConnectManage", "连接管理", "admin", CommonUtils.exception2Str(e));
        }
        return map;
    }

    @RequestMapping("/addConnectType")
    public Map<String, Object> addConnectType(ConnectType connectType, MultipartFile file) {
        map.clear();
        redisUtil.pubLog("ConnectManage", "连接管理", "admin", "添加连接类型开始");
        try {
            String filePath = connectManageService.addConnectTypeFile(file, connectType.getConnectType());
            int excCnt = connectManageService.addConnectType(connectType, filePath, "admin");
            if (excCnt > 0) {
                map.put("result", "success");
                redisUtil.pubLog("ConnectManage", "连接管理", "admin", "添加连接类型成功");
            } else {
                map.put("result", "failed");
                redisUtil.pubLog("ConnectManage", "连接管理", "admin", "添加连接类型失败");
            }
        } catch (Exception e) {
            redisUtil.pubLog("ConnectManage", "连接管理", "admin", CommonUtils.exception2Str(e));
            map.put("result", "error");
        }
        return map;
    }

    @RequestMapping("/operateConnectType")
    public Map<String, Object> operateConnectType (String operation, String connectTypeID) {
        redisUtil.pubLog("ConnectManage", "连接管理", "admin", operation + "设备类型:" + connectTypeID);
        map.clear();
        map.put("operation", operation);
        try {
            connectManageService.operateConnectType(operation, connectTypeID);
            map.put("result", "success");
        } catch (Exception e) {
            redisUtil.pubLog("ConnectManage", "连接管理", "admin", CommonUtils.exception2Str(e));
            map.put("result", "error");
        }
        return map;
    }

    @RequestMapping("/getOperateResult")
    public Map<String, Object> getOperateResult(String operation, String connectTypeID) {
        map.clear();
        String key = CommonUtils.getKey("connectType", connectTypeID);
        JSONObject json = null;
        if (redisUtil.exists(key)) {
            json =  JSONObject.fromObject(redisUtil.getValue(key).toString());
        }
        if ("start".equals(operation)) {
            if (CommonUtils.checkUrlConnection(json.getString("connectHomeUrl")) == 200) {
                int exeCnt = connectManageService.updateConnectType(connectTypeID, operation, "admin");
                if (exeCnt > 0) {
                    map.put("result", "success");
                } else {
                    map.put("result", "failed");
                }
            } else {
                map.put("result", "failed");
            }
        } else {
            if (CommonUtils.checkUrlConnection(json.getString("connectHomeUrl")) == -1) {
                int exeCnt = connectManageService.updateConnectType(connectTypeID, operation, "admin");
                if (exeCnt > 0) {
                    map.put("result", "success");
                } else {
                    map.put("result", "failed");
                }
            } else {
                map.put("result", "failed");
            }
        }
        map.put("operation", operation);
        return map;
    }
}
