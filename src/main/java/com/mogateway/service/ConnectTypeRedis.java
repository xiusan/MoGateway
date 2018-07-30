package com.mogateway.service;

import com.mogateway.entity.ConnectType;
import com.mogateway.redis.RedisUtil;
import com.mogateway.util.CmdUtil;
import com.mogateway.util.CommonUtils;
import com.mogateway.util.StringTool;
import com.sun.jna.Platform;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2018-04-08.
 */
@Component
public class ConnectTypeRedis {

    @Autowired
    private RedisUtil redisUtil;

    public void setConnectRedis (List<ConnectType> connectTypes) {
        for (int i = 0; i < connectTypes.size(); i++) {
            ConnectType connectType = connectTypes.get(i);
            String key = CommonUtils.getKey("connectType", connectType.getConnectType());
            if (redisUtil.exists(key)) {
                JSONObject oldJson = JSONObject.fromObject(redisUtil.getValue(key).toString());
                if (oldJson.has("connectPID")) {
                    int pid = oldJson.getInt("connectPID");
                    if (pid != -1) {
                        try {
                            CmdUtil.killProcess(pid);
                        } catch (Exception e) {
                            continue;
                        }
                    }
                }
            }
            JSONObject connectTypeJson = new JSONObject();
            connectTypeJson.put("connectType", connectType.getConnectType());
            if (connectType.getConnectIP() != null && !connectType.getConnectIP().isEmpty()) {
                connectTypeJson.put("connectIP", connectType.getConnectIP());
            } else {
                connectTypeJson.put("connectIP", "-");
            }
            if (connectType.getConnectPort() != null) {
                connectTypeJson.put("connectPort", connectType.getConnectPort());
            } else {
                connectTypeJson.put("connectPort", "-");
            }
            if (connectType.getConnectBaudRate() != null) {
                connectTypeJson.put("connectBaudRate", connectType.getConnectBaudRate());
            } else {
                connectTypeJson.put("connectBaudRate", "-");
            }
            if (connectType.getConnectSerialPort() != null && !connectType.getConnectSerialPort().isEmpty()) {
                connectTypeJson.put("connectSerialPort", connectType.getConnectSerialPort());
            } else {
                connectTypeJson.put("connectSerialPort", "-");
            }
            if (connectType.getConnectDirection() == 0) {
                connectTypeJson.put("connectDirection", "对内");
            } else {
                connectTypeJson.put("connectDirection", "对外");
            }
            if (connectType.getConnectSerialCheckID() != null) {
                connectTypeJson.put("connectSerialCheckID", connectType.getConnectSerialCheckID());
            } else {
                connectTypeJson.put("connectSerialCheckID", "-");
            }
            connectTypeJson.put("connectPubRedisChannel", connectType.getConnectPubRedisChannel());
            connectTypeJson.put("connectSubRedisChannel", connectType.getConnectSubRedisChannel());
            connectTypeJson.put("connectFile", connectType.getConnectFile());
            connectTypeJson.put("connectHomeUrl", StringTool.isEmpty(connectType.getConnectHomeUrl()) ? " ":connectType.getConnectHomeUrl());
            if (connectType.getEnabled() == 0) {
                connectTypeJson.put("enabled", "启用");
            } else {
                connectTypeJson.put("enabled", "禁用");
            }
            connectTypeJson.put("connectStatus", "异常");
            connectTypeJson.put("connectPID", -1);
            connectTypeJson.put("connectCount", 0);
            redisUtil.setValue(CommonUtils.getKey("connectType", connectType.getConnectType()), connectTypeJson.toString());
            if (connectType.getEnabled() == 1) {
                continue;
            }
            if (CommonUtils.checkUrlConnection(connectType.getConnectHomeUrl()) == 200) {
                continue;
            }
            if (Platform.isWindows() || Platform.isLinux()) {
                File file = new File(connectType.getConnectFile());
                if (!file.exists()) {
                    redisUtil.pubLog("connectManage", "连接管理", "admin", connectType.getConnectType() + "文件不存在");
                    continue;
                }
                try {
                    Process process = CmdUtil.startJar(connectType.getConnectFile());
                } catch (Exception e) {
                    redisUtil.pubLog("connectManage", "连接管理", "admin", CommonUtils.exception2Str(e));
                }
            } else {
                redisUtil.pubLog("connectManage", "连接管理", "admin", "启动" + connectType.getConnectType() + "失败,系统不支持");
            }
        }
    }
}
