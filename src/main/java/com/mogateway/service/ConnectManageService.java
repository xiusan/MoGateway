package com.mogateway.service;

import com.mogateway.entity.ConnectType;
import com.mogateway.mapper.ConnectTypeMapper;
import com.mogateway.redis.RedisUtil;
import com.mogateway.util.CmdUtil;
import com.mogateway.util.CommonUtils;
import com.mogateway.util.Const;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2018-03-29.
 */
@Service
public class ConnectManageService {

    @Autowired
    private ConnectTypeMapper connectTypeMapper;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private ConnectTypeRedis connectTypeRedis;

    private Logger logger = Logger.getLogger(this.getClass());

    public List<ConnectType> getConnectTypes() {
        return connectTypeMapper.getConnectTypes();
    }

    public int addConnectType(ConnectType connectType, String filePath, String userID) {
        connectType.setCreateUser(userID);
        connectType.setConnectFile(filePath);
        connectType.setEnabled(1);
        connectType.setUpdateUser(userID);
        int exCnt = connectTypeMapper.addConnectType(connectType);
        if (exCnt > 0) {
            List<ConnectType> connectTypes = new ArrayList<ConnectType>();
            connectTypes.add(connectType);
            if (connectTypes != null && connectTypes.size() > 0) {
                connectTypeRedis.setConnectRedis(connectTypes);
            }
        }
        return exCnt;
    }

    public String addConnectTypeFile(MultipartFile fileSrc, String connectType) throws Exception {
        String filePath = Const.CONNECTTYPE_FILE_BASE_PATH + connectType + Const.FILE_SEPERATOR;
        File file = new File(filePath);
        if (!file.exists() && !file .isDirectory()) {
            file.mkdirs();
        }
        filePath += fileSrc.getOriginalFilename();
        file = new File(filePath);
        if (!file.exists()) {
            file.createNewFile();
        } else {
            file.delete();
            file.createNewFile();
        }
        FileOutputStream outputStream = new FileOutputStream(file, true);
        outputStream.write(fileSrc.getBytes());
        outputStream.flush();
        outputStream.close();
        return filePath;
    }

    public void operateConnectType(String operation, String connectTypeID) throws Exception {
        String[] ids = connectTypeID.split(",");
        for (int i = 0;i < ids.length;i++) {
            String key = CommonUtils.getKey("connectType", ids[i]);
            if (redisUtil.exists(key)) {
                JSONObject connectTypeJson = JSONObject.fromObject(redisUtil.getValue(key).toString());
                if ("start".equals(operation)) {
                    redisUtil.setValue("connectType:starting:key", key);
                    CmdUtil.startJar(connectTypeJson.getString("connectFile"));
                } else {
                    CmdUtil.killProcess(connectTypeJson.getInt("connectPID"));
                }
            }
        }
    }

    public int updateConnectType(String connectTypeID, String operation, String userID) {
        int exCnt = 0;
        String[] ids = connectTypeID.split(",");
        for (int i = 0;i < ids.length;i++) {
            String key = CommonUtils.getKey("connectType", ids[i]);
            if (redisUtil.exists(key)) {
                JSONObject connectTypeJson = JSONObject.fromObject(redisUtil.getValue(key).toString());
                if (connectTypeJson == null) {
                    return  -1;
                }
                switch (operation) {
                    case "start":
                        connectTypeJson.put("enabled", "启用");
                        connectTypeJson.put("connectStatus", "正常");
                        redisUtil.setValue(key, connectTypeJson.toString());
                        break;
                    case "stop":
                        connectTypeJson.put("enabled", "禁用");
                        connectTypeJson.put("connectStatus", "异常");
                        connectTypeJson.put("connectPID", -1);
                        connectTypeJson.put("connectCount", 0);
                        redisUtil.setValue(key, connectTypeJson.toString());
                        break;
                    case "delete":
                        redisUtil.remove(key);
                        break;
                    default:
                        break;
                }
            }
        }
        switch (operation) {
            case "start":
                    exCnt = connectTypeMapper.updateConnectType(userID, 0, ids);
                    break;
                case "stop":
                    exCnt = connectTypeMapper.updateConnectType(userID, 1, ids);
                    break;
                case "delete":
                    exCnt = connectTypeMapper.deleteConnectType(ids);
                    break;
                default:
                    break;
        }
        return  exCnt;
    }
}
