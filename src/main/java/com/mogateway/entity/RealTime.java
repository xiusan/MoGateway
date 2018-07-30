package com.mogateway.entity;

import java.io.Serializable;
import java.util.Date;

public class RealTime implements Serializable{
    private String equipmentNo;

    private Integer communicateStatus;

    private Integer workStatus;

    private Integer chargingGunStatus;

    private Double outputVoltage;

    private Double outputCurrent;

    private Double outputPower;

    private Double ammeterNo;

    private Double currentSoc;

    private Integer faultStatus;

    private String faultDesc;

    private Date startChargingDttm;

    private String chargedTime;

    private Double startChargingAmmeterNo;

    private String hardwareVersion;

    private String softwareVersion;

    private Double chargedKwh;

    public String getEquipmentNo() {
        return equipmentNo;
    }

    public void setEquipmentNo(String equipmentNo) {
        this.equipmentNo = equipmentNo == null ? null : equipmentNo.trim();
    }

    public Integer getCommunicateStatus() {
        return communicateStatus;
    }

    public void setCommunicateStatus(Integer communicateStatus) {
        this.communicateStatus = communicateStatus;
    }

    public Integer getWorkStatus() {
        return workStatus;
    }

    public void setWorkStatus(Integer workStatus) {
        this.workStatus = workStatus;
    }

    public Integer getChargingGunStatus() {
        return chargingGunStatus;
    }

    public void setChargingGunStatus(Integer chargingGunStatus) {
        this.chargingGunStatus = chargingGunStatus;
    }

    public Double getOutputVoltage() {
        return outputVoltage;
    }

    public void setOutputVoltage(Double outputVoltage) {
        this.outputVoltage = outputVoltage;
    }

    public Double getOutputCurrent() {
        return outputCurrent;
    }

    public void setOutputCurrent(Double outputCurrent) {
        this.outputCurrent = outputCurrent;
    }

    public Double getOutputPower() {
        return outputPower;
    }

    public void setOutputPower(Double outputPower) {
        this.outputPower = outputPower;
    }

    public Double getAmmeterNo() {
        return ammeterNo;
    }

    public void setAmmeterNo(Double ammeterNo) {
        this.ammeterNo = ammeterNo;
    }

    public Double getCurrentSoc() {
        return currentSoc;
    }

    public void setCurrentSoc(Double currentSoc) {
        this.currentSoc = currentSoc;
    }

    public Integer getFaultStatus() {
        return faultStatus;
    }

    public void setFaultStatus(Integer faultStatus) {
        this.faultStatus = faultStatus;
    }

    public String getFaultDesc() {
        return faultDesc;
    }

    public void setFaultDesc(String faultDesc) {
        this.faultDesc = faultDesc == null ? null : faultDesc.trim();
    }

    public Date getStartChargingDttm() {
        return startChargingDttm;
    }

    public void setStartChargingDttm(Date startChargingDttm) {
        this.startChargingDttm = startChargingDttm;
    }

    public String getChargedTime() {
        return chargedTime;
    }

    public void setChargedTime(String chargedTime) {
        this.chargedTime = chargedTime == null ? null : chargedTime.trim();
    }

    public Double getStartChargingAmmeterNo() {
        return startChargingAmmeterNo;
    }

    public void setStartChargingAmmeterNo(Double startChargingAmmeterNo) {
        this.startChargingAmmeterNo = startChargingAmmeterNo;
    }

    public String getHardwareVersion() {
        return hardwareVersion;
    }

    public void setHardwareVersion(String hardwareVersion) {
        this.hardwareVersion = hardwareVersion == null ? null : hardwareVersion.trim();
    }

    public String getSoftwareVersion() {
        return softwareVersion;
    }

    public void setSoftwareVersion(String softwareVersion) {
        this.softwareVersion = softwareVersion == null ? null : softwareVersion.trim();
    }

    public Double getChargedKwh() {
        return chargedKwh;
    }

    public void setChargedKwh(Double chargedKwh) {
        this.chargedKwh = chargedKwh;
    }
}