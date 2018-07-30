package com.mogateway.entity;

import java.util.Date;

public class CharingConnectorType {
    private Long chargingConnectorType;

    private String chargingConnectorName;

    private String createUser;

    private Date createDttm;

    private String updateUser;

    private Date updateDttm;

    public Long getChargingConnectorType() {
        return chargingConnectorType;
    }

    public void setChargingConnectorType(Long chargingConnectorType) {
        this.chargingConnectorType = chargingConnectorType;
    }

    public String getChargingConnectorName() {
        return chargingConnectorName;
    }

    public void setChargingConnectorName(String chargingConnectorName) {
        this.chargingConnectorName = chargingConnectorName == null ? null : chargingConnectorName.trim();
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