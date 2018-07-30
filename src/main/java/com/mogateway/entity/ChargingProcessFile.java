package com.mogateway.entity;

import java.util.Date;

public class ChargingProcessFile {
    private Integer id;

    private String fielType;

    private String equipmentId;

    private Date currentDttm;

    private String fileSize;

    private String filePath;

    private Date fileCreateTime;

    private Integer isFlang;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFielType() {
        return fielType;
    }

    public void setFielType(String fielType) {
        this.fielType = fielType == null ? null : fielType.trim();
    }

    public String getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(String equipmentId) {
        this.equipmentId = equipmentId == null ? null : equipmentId.trim();
    }

    public Date getCurrentDttm() {
        return currentDttm;
    }

    public void setCurrentDttm(Date currentDttm) {
        this.currentDttm = currentDttm;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize == null ? null : fileSize.trim();
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath == null ? null : filePath.trim();
    }

    public Date getFileCreateTime() {
        return fileCreateTime;
    }

    public void setFileCreateTime(Date fileCreateTime) {
        this.fileCreateTime = fileCreateTime;
    }

    public Integer getIsFlang() {
        return isFlang;
    }

    public void setIsFlang(Integer isFlang) {
        this.isFlang = isFlang;
    }
}