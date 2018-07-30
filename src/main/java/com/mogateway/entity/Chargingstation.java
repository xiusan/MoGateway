package com.mogateway.entity;

import java.util.Date;

public class Chargingstation {
    private String chargingStationId;

    private String chargingStationName;

    private String chargingStationAddr;

    private Boolean enabled;

    private String createUser;

    private Date createDttm;

    private String updateUser;

    private Date updateDttm;

    public String getChargingStationId() {
        return chargingStationId;
    }

    public void setChargingStationId(String chargingStationId) {
        this.chargingStationId = chargingStationId == null ? null : chargingStationId.trim();
    }

    public String getChargingStationName() {
        return chargingStationName;
    }

    public void setChargingStationName(String chargingStationName) {
        this.chargingStationName = chargingStationName == null ? null : chargingStationName.trim();
    }

    public String getChargingStationAddr() {
        return chargingStationAddr;
    }

    public void setChargingStationAddr(String chargingStationAddr) {
        this.chargingStationAddr = chargingStationAddr == null ? null : chargingStationAddr.trim();
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public Date getCreateDttm() {
        return createDttm;
    }

    public void setCreateDttm(Date createDttm) {
        this.createDttm = createDttm;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
    }

    public Date getUpdateDttm() {
        return updateDttm;
    }

    public void setUpdateDttm(Date updateDttm) {
        this.updateDttm = updateDttm;
    }
}