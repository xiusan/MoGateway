package com.mogateway.entity;

import java.util.Date;

public class SerialConfig {
    private String serialName;

    private Integer serialBaudRate;

    private Integer serialCheckoutId;

    private Date createDttm;

    private String createUser;

    private Date updateDttm;

    private String updateUser;

    public String getSerialName() {
        return serialName;
    }

    public void setSerialName(String serialName) {
        this.serialName = serialName == null ? null : serialName.trim();
    }

    public Integer getSerialBaudRate() {
        return serialBaudRate;
    }

    public void setSerialBaudRate(Integer serialBaudRate) {
        this.serialBaudRate = serialBaudRate;
    }



    public Date getCreateDttm() {
        return createDttm;
    }

    public void setCreateDttm(Date createDttm) {
        this.createDttm = createDttm;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public Date getUpdateDttm() {
        return updateDttm;
    }

    public void setUpdateDttm(Date updateDttm) {
        this.updateDttm = updateDttm;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
    }

    public Integer getSerialCheckoutId() {
        return serialCheckoutId;
    }

    public void setSerialCheckoutId(Integer serialCheckoutId) {
        this.serialCheckoutId = serialCheckoutId;
    }
}