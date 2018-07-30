package com.mogateway.entity;

import java.io.Serializable;

public class CloudAddressManager implements Serializable{
    private String cloudId;

    private String kjCloudAddress;

    private String customerCloudAddress;

    private Integer isSynchronization;

    private Integer isCertificate;

    public String getCloudId() {
        return cloudId;
    }

    public void setCloudId(String cloudId) {
        this.cloudId = cloudId == null ? null : cloudId.trim();
    }

    public String getKjCloudAddress() {
        return kjCloudAddress;
    }

    public void setKjCloudAddress(String kjCloudAddress) {
        this.kjCloudAddress = kjCloudAddress == null ? null : kjCloudAddress.trim();
    }

    public String getCustomerCloudAddress() {
        return customerCloudAddress;
    }

    public void setCustomerCloudAddress(String customerCloudAddress) {
        this.customerCloudAddress = customerCloudAddress == null ? null : customerCloudAddress.trim();
    }

    public Integer getIsSynchronization() {
        return isSynchronization;
    }

    public void setIsSynchronization(Integer isSynchronization) {
        this.isSynchronization = isSynchronization;
    }

    public Integer getIsCertificate() {
        return isCertificate;
    }

    public void setIsCertificate(Integer isCertificate) {
        this.isCertificate = isCertificate;
    }
}