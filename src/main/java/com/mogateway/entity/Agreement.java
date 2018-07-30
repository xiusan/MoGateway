package com.mogateway.entity;

import java.util.Date;

/**
 * Created by Administrator on 2018-04-10.
 */
public class Agreement {

    private String AgreementID;

    private String AgreementName;

    private String AgreementAddr;

    private String AgreementPubChannel;

    private String AgreementSubChannel;

    private int Enabled;

    private String AgreementHomeUrl;

    private String CreateUser;

    private Date CreateDTTM;

    private String UpdateUser;

    private Date UpdateDTTM;

    public String getAgreementID() {
        return AgreementID;
    }

    public void setAgreementID(String agreementID) {
        AgreementID = agreementID;
    }

    public String getAgreementName() {
        return AgreementName;
    }

    public void setAgreementName(String agreementName) {
        AgreementName = agreementName;
    }

    public String getAgreementAddr() {
        return AgreementAddr;
    }

    public void setAgreementAddr(String agreementAddr) {
        AgreementAddr = agreementAddr;
    }

    public String getAgreementSubChannel() {
        return AgreementSubChannel;
    }

    public void setAgreementSubChannel(String agreementSubChannel) {
        AgreementSubChannel = agreementSubChannel;
    }

    public int getEnabled() {
        return Enabled;
    }

    public void setEnabled(int enabled) {
        Enabled = enabled;
    }

    public String getAgreementPubChannel() {
        return AgreementPubChannel;
    }

    public void setAgreementPubChannel(String agreementPubChannel) {
        AgreementPubChannel = agreementPubChannel;
    }

    public String getAgreementHomeUrl() {
        return AgreementHomeUrl;
    }

    public void setAgreementHomeUrl(String agreementHomeUrl) {
        AgreementHomeUrl = agreementHomeUrl;
    }

    public String getCreateUser() {
        return CreateUser;
    }

    public void setCreateUser(String createUser) {
        CreateUser = createUser;
    }

    public Date getCreateDTTM() {
        return CreateDTTM;
    }

    public void setCreateDTTM(Date createDTTM) {
        CreateDTTM = createDTTM;
    }

    public String getUpdateUser() {
        return UpdateUser;
    }

    public void setUpdateUser(String updateUser) {
        UpdateUser = updateUser;
    }

    public Date getUpdateDTTM() {
        return UpdateDTTM;
    }

    public void setUpdateDTTM(Date updateDTTM) {
        UpdateDTTM = updateDTTM;
    }
}
