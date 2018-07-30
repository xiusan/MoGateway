package com.mogateway.entity;

import java.util.Date;

public class LogSetting {
    private String moduleID;

    private String moduleName;

    private Integer logFlag;

    private Integer storeStyle;

    private Integer storePeriod;

    private Integer storeFileSize;

    private Integer compressFlag;

    private Integer compressStyle;

    private String createUser;

    private Date createDTTM;

    private String updateUser;

    private Date updateDTTM;

    public String getModuleID() {
        return moduleID;
    }

    public void setModuleID(String moduleID) {
        this.moduleID = moduleID == null ? null : moduleID.trim();
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName == null ? null : moduleName.trim();
    }

    public Integer getLogFlag() {
        return logFlag;
    }

    public void setLogFlag(Integer logFlag) {
        this.logFlag = logFlag;
    }

    public Integer getStoreStyle() {
        return storeStyle;
    }

    public void setStoreStyle(Integer storeStyle) {
        this.storeStyle = storeStyle;
    }

    public Integer getStorePeriod() {
        return storePeriod;
    }

    public void setStorePeriod(Integer storePeriod) {
        this.storePeriod = storePeriod;
    }

    public Integer getStoreFileSize() {
        return storeFileSize;
    }

    public void setStoreFileSize(Integer storeFileSize) {
        this.storeFileSize = storeFileSize;
    }

    public Integer getCompressFlag() {
        return compressFlag;
    }

    public void setCompressFlag(Integer compressFlag) {
        this.compressFlag = compressFlag;
    }

    public Integer getCompressStyle() {
        return compressStyle;
    }

    public void setCompressStyle(Integer compressStyle) {
        this.compressStyle = compressStyle;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getCreateDTTM() {
        return createDTTM;
    }

    public void setCreateDTTM(Date createDTTM) {
        this.createDTTM = createDTTM;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public Date getUpdateDTTM() {
        return updateDTTM;
    }

    public void setUpdateDTTM(Date updateDTTM) {
        this.updateDTTM = updateDTTM;
    }
}