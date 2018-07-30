package com.mogateway.entity;

import java.util.Date;

public class Equipment {
    private String equipmentId;

    private String equipmentNo;

    private String equipmentName;

    private String chargingStationId;

    private Boolean active;

    private Long equipmentType;

    private String agreementId;

    private String ammeterId;

    private Long connectorType;

    private Long voltageUpperLimits;

    private Long voltageLowerLimits;

    private Long current;

    private Float power;

    private String parkNo;

    private Long nationalStandard;

    private String manufacturer;

    private String manufacturerName;

    private Date manufacturerDttm;

    private Date deliveryDttm;

    private String deviceId;

    private Integer chargingGunNo;

    private String createUser;

    private Date createDttm;

    private String updateUser;

    private Date updateDttm;

    private String agreementName;

    private String chargingStatioNname;

    private String ammeterName;

    private String equipmentTypeName;

    private String chargingConnectorName;

    public String getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(String equipmentId) {
        this.equipmentId = equipmentId == null ? null : equipmentId.trim();
    }

    public String getEquipmentNo() {
        return equipmentNo;
    }

    public void setEquipmentNo(String equipmentNo) {
        this.equipmentNo = equipmentNo == null ? null : equipmentNo.trim();
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName == null ? null : equipmentName.trim();
    }

    public String getChargingStationId() {
        return chargingStationId;
    }

    public void setChargingStationId(String chargingStationId) {
        this.chargingStationId = chargingStationId == null ? null : chargingStationId.trim();
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }



    public String getAgreementId() {
        return agreementId;
    }

    public void setAgreementId(String agreementId) {
        this.agreementId = agreementId == null ? null : agreementId.trim();
    }

    public String getAmmeterId() {
        return ammeterId;
    }

    public void setAmmeterId(String ammeterId) {
        this.ammeterId = ammeterId == null ? null : ammeterId.trim();
    }

    public Long getConnectorType() {
        return connectorType;
    }

    public void setConnectorType(Long connectorType) {
        this.connectorType = connectorType;
    }

    public Long getVoltageUpperLimits() {
        return voltageUpperLimits;
    }

    public void setVoltageUpperLimits(Long voltageUpperLimits) {
        this.voltageUpperLimits = voltageUpperLimits;
    }

    public Long getVoltageLowerLimits() {
        return voltageLowerLimits;
    }

    public void setVoltageLowerLimits(Long voltageLowerLimits) {
        this.voltageLowerLimits = voltageLowerLimits;
    }

    public Long getCurrent() {
        return current;
    }

    public void setCurrent(Long current) {
        this.current = current;
    }

    public Float getPower() {
        return power;
    }

    public void setPower(Float power) {
        this.power = power;
    }

    public String getParkNo() {
        return parkNo;
    }

    public void setParkNo(String parkNo) {
        this.parkNo = parkNo == null ? null : parkNo.trim();
    }

    public Long getNationalStandard() {
        return nationalStandard;
    }

    public void setNationalStandard(Long nationalStandard) {
        this.nationalStandard = nationalStandard;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer == null ? null : manufacturer.trim();
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName == null ? null : manufacturerName.trim();
    }

    public Date getManufacturerDttm() {
        return manufacturerDttm;
    }

    public void setManufacturerDttm(Date manufacturerDttm) {
        this.manufacturerDttm = manufacturerDttm;
    }

    public Date getDeliveryDttm() {
        return deliveryDttm;
    }

    public void setDeliveryDttm(Date deliveryDttm) {
        this.deliveryDttm = deliveryDttm;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId == null ? null : deviceId.trim();
    }

    public Integer getChargingGunNo() {
        return chargingGunNo;
    }

    public void setChargingGunNo(Integer chargingGunNo) {
        this.chargingGunNo = chargingGunNo;
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

    public String getAgreementName() {
        return agreementName;
    }

    public void setAgreementName(String agreementName) {
        this.agreementName = agreementName;
    }


    public String getChargingStatioNname() {
        return chargingStatioNname;
    }

    public void setChargingStatioNname(String chargingStatioNname) {
        this.chargingStatioNname = chargingStatioNname;
    }

    public String getAmmeterName() {
        return ammeterName;
    }

    public void setAmmeterName(String ammeterName) {
        this.ammeterName = ammeterName;
    }

    public String getEquipmentTypeName() {
        return equipmentTypeName;
    }

    public void setEquipmentTypeName(String equipmentTypeName) {
        this.equipmentTypeName = equipmentTypeName;
    }

    public String getChargingConnectorName() {
        return chargingConnectorName;
    }

    public void setChargingConnectorName(String chargingConnectorName) {
        this.chargingConnectorName = chargingConnectorName;
    }

    public Long getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(Long equipmentType) {
        this.equipmentType = equipmentType;
    }
}