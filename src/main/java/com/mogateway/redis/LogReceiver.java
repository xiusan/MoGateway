package com.mogateway.redis;

import com.mogateway.entity.LogHistory;
import com.mogateway.entity.LogSetting;
import com.mogateway.mapper.LogHistoryMapper;
import com.mogateway.service.LogSettingService;
import com.mogateway.util.CinTxt;
import com.mogateway.util.CommonUtils;
import com.mogateway.util.FileUtils;
import com.mogateway.util.ZUtils;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Administrator on 2018-04-26.
 */
@Component
public class LogReceiver implements MessageListener {

    @Autowired
    private RedisUtil redisUtil;

    @Value("${log_path}")
    private String logPath;

    @Autowired
    private LogSettingService logSettingService;

    @Autowired
    private LogHistoryMapper logHistoryMapper;

    private static List<LogSetting> logSettings = null;

    public static Lock lock = new ReentrantLock();

    @Override
    public void onMessage(Message message, byte[] bytes) {
        String msg = CommonUtils.convertMsg(redisUtil.getRedisTemplate(), message);
        logStore(msg);
    }

    private void logStore(String msg) {
        try {
            if (logSettings == null) {
                logSettings = logSettingService.getLogSetting();
            }
            if (msg == null || "".equals(msg)) {
                return;
            }
            JSONObject json = JSONObject.fromObject(msg);
            if (json == null) {
                return;
            }
            String moduleID = null, moduleName = null, userID = null, content = null, time = null;
            if (json.has("moduleID")) {
                moduleID = json.getString("moduleID");
            }
            if (json.has("moduleName")) {
                moduleName = json.getString("moduleName");
            }
            if (json.has("userID")) {
                userID = json.getString("userID");
            }
            if (json.has("content")) {
                content = json.getString("content");
            }
            if (json.has("time")) {
                time = json.getString("time");
            }
            StringBuilder data = new StringBuilder().append(time).append(":").append(moduleID).append(":").append(moduleName).append(":").append(userID).append(":").append(content);
            LogSetting setting = null;
            for (LogSetting logSetting : logSettings) {
                if (logSetting.getModuleID().equals(moduleID)) {
                    setting = logSetting;
                    break;
                }
            }
            if (null == setting) {
                return;
            }
            if (setting.getLogFlag() == 1) {
                return;
            }
            StringBuffer databasesFilePath = new StringBuffer();
            lock.lock();
            //不压缩
            if (setting.getCompressFlag().equals(1)) {
                cf(json, setting, data, databasesFilePath);
            }
            //压缩
            if (setting.getCompressFlag().equals(0)) {
                if (setting.getCompressStyle().equals(0)) {
                    cf(json, setting, data, databasesFilePath, true, "7z");
                }

                if (setting.getCompressStyle().equals(1)) {
                    cf(json, setting, data, databasesFilePath, true, "zip");
                }
                if (setting.getCompressStyle().equals(2)) {
                    cf(json, setting, data, databasesFilePath, true, "tar");
                }
            }

            if (StringUtils.isNotBlank(databasesFilePath.toString())) {
                LogHistory logHistory = new LogHistory();
                logHistory.setModuleID(moduleID);
                logHistory.setFileDateStart(FileUtils.getCreateTime(databasesFilePath.toString()));
                logHistory.setFileDateEnd(CommonUtils.parseDate(time, "yyyy-MM-dd HH:mm:ss"));
                logHistory.setFileAddress(databasesFilePath.toString());
                logHistoryMapper.addLogHistory(logHistory);
            }
        } catch (Exception e) {
        } finally {
            lock.unlock();
        }
    }

    private void cf(JSONObject object, LogSetting setting, StringBuilder data, StringBuffer databasesFilePath) {
        cf(object, setting, data, databasesFilePath, false, null);
    }

    private void cf(JSONObject object, LogSetting setting, StringBuilder data, StringBuffer databasesFilePath, Boolean b, String fileSuffix) {
        try {
            String moduleID = object.getString("moduleID");

            String filePathDate = CommonUtils.date2Str(new Date(), "yyyy-MM-dd");
            String filePath = logPath + moduleID + "/" + filePathDate;
            String fileName = moduleID + ".log";
            String fileNamePath = filePath + "/" + fileName;

            //按时间存储
            if (setting.getStoreStyle().equals(1)) {
                FileUtils.createFile(filePath, fileName);
                CinTxt.setTxtData(fileNamePath, data.toString());

                long interval = (FileUtils.getModifiedTime(fileNamePath).getTime() - FileUtils.getCreateTime(fileNamePath).getTime()) / 1000;
                if (interval >= setting.getStorePeriod()) {
                    z(fileNamePath, filePath, b, fileSuffix, databasesFilePath);
                }
                FileUtils.createFile(filePath, fileName);
            }

            //按文件大小存储
            if (setting.getStoreStyle().equals(2)) {
                FileUtils.createFile(filePath, fileName);
                //判断文件大小
                Integer fileSize = FileUtils.getFileSize(new File(fileNamePath));
                if (fileSize >= setting.getStoreFileSize()) {
                    z(fileNamePath, filePath, b, fileSuffix, databasesFilePath);
                }
                FileUtils.createFile(filePath, fileName);
                CinTxt.setTxtData(fileNamePath, data.toString());
            }
        } catch (Exception e) {
        }
    }

    private void z(String fileNamePath, String filePath, Boolean b, String fileSuffix, StringBuffer databasesFilePath) {
        File file = new File(fileNamePath);
        if (file.exists()) {
            String newFleName = UUID.randomUUID().toString() + ".log";
            String fileNewPath = filePath + "/" + newFleName;
            file.renameTo(new File(fileNewPath));
            zf(filePath, fileNewPath, newFleName, fileNamePath, b, fileSuffix, databasesFilePath);
        }
    }

    private void zf(String filePath, String fileNewPath, String fileName, String fileNamePath, Boolean b, String fileSuffix, StringBuffer databasesFilePath) {
        try {
            //压缩文件
            if (b) {
                if (fileSuffix.equals("zip")) {
                    String fileZipPath = filePath + "/" + UUID.randomUUID().toString() + ".zip";
                    ZUtils.toZip(Collections.singletonList(new File(fileNewPath)), new FileOutputStream(new File(fileZipPath)));
                    databasesFilePath.append(fileZipPath);
                    new File(fileNewPath).delete();
                }

                if (fileSuffix.equals("7z")) {
                    String file7zPath = filePath + "/" + UUID.randomUUID().toString() + ".7z";
                    ZUtils.z7z(filePath, fileName, file7zPath);
                    databasesFilePath.append(file7zPath);
                    new File(filePath + "/" + fileName).delete();
                }
                if (fileSuffix.equals("tar")) {
                    try {
                        String fileTarPath = ZUtils.archive(filePath + "/" + fileName);
                        databasesFilePath.append(fileTarPath);
                        new File(filePath + "/" + fileName).delete();
                    } catch (Exception e) {
                    }
                }
            } else {
                databasesFilePath.append(fileNewPath);
            }
        } catch (Exception e) {
        }
    }
}
