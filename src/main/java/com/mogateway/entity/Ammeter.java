package com.mogateway.entity;

import java.util.Date;

public class Ammeter {
    private String ammeterId;

    private String ammeterName;

    private String agreementId;

    private Byte enable;

    private Date createDttm;

    private String createUser;

    private String agreementName;

    public String getAmmeterId() {
        return ammeterId;
    }

    public void setAmmeterId(String ammeterId) {
        this.ammeterId = ammeterId == null ? null : ammeterId.trim();
    }

    public String getAmmeterName() {
        return ammeterName;
    }

    public void setAmmeterName(String ammeterName) {
        this.ammeterName = ammeterName == null ? null : ammeterName.trim();
    }

    public String getAgreementId() {
        return agreementId;
    }

    public void setAgreementId(String agreementId) {
        this.agreementId = agreementId == null ? null : agreementId.trim();
    }

    public Byte getEnable() {
        return enable;
    }

    public void setEnable(Byte enable) {
        this.enable = enable;
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

    public String getAgreementName() {
        return agreementName;
    }

    public void setAgreementName(String agreementName) {
        this.agreementName = agreementName;
    }
}