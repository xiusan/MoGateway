package com.mogateway.service;

import com.mogateway.entity.LogSetting;
import com.mogateway.mapper.LogSettingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018-04-27.
 */
@Service
public class LogSettingService {

    @Autowired
    private LogSettingMapper logSettingMapper;

    public List<LogSetting> getLogSetting() {
        return logSettingMapper.getLogSetting();
    }

    public int addLogSetting(LogSetting logSetting, String userID) {
        logSetting.setCreateUser(userID);
        logSetting.setUpdateUser(userID);
        return logSettingMapper.addLogSetting(logSetting);
    }

    public int updateLogSetting(LogSetting logSetting, String userID) {
        logSetting.setUpdateUser(userID);
        return logSettingMapper.updateLogSetting(logSetting);
    }

    public int deleteLogSetting(String moduleIDs) {
        return logSettingMapper.deleteLogSetting(moduleIDs.split(","));
    }
}
