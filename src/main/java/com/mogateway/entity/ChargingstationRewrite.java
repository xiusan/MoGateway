package com.mogateway.entity;


import java.util.Date;


public class ChargingstationRewrite {
    private String chargingStationId;

    private String chargingStationName;//名称

    private String chargingStationAddr;//详细地址

    private Boolean enabled;
    private String createUser;
    private Date createDttm;
    private String updateUser;
    private Date updateDttm;
    private String operatorId;
    private String equipmentOwnerId;
    private String countryCode;//国家代码
    private String areaCode;//省市辖区
    private String chargingStationTel;//站点电话
    private String chargingServiceTel;
    private Integer chargingStationType;
    private Integer chargingStationStatus;
    private Integer parkNums;//车位数量
    private Double chargingStationLng;//经度
    private Double chargingStationLat;//维度
    private String siteGuide;//站点引导
    private Integer construction;//建设场所
    private String pictures;
    private String matchCars;
    private String parkInfo;
    private String busineHoures;
    private String electricityFee;
    private String serviceFee;
    private String parkFee;
    private String payment;
    private Byte supportOrder;//是否支持预约
    private String remark;//备注
    private String operatorName;// 所属运营商
    private String stationTypeName;//  站点类型
    private String stationStatusName;// 站点状态
    private String constructionName;// 建设场所
    private String keyId;// select
    private String valueName;// select

    public String getKeyId() {
        return keyId;
    }

    public void setKeyId(String keyId) {
        this.keyId = keyId;
    }

    public String getValueName() {
        return valueName;
    }

    public void setValueName(String valueName) {
        this.valueName = valueName;
    }

    public String getConstructionName() {
        return constructionName;
    }

    public void setConstructionName(String constructionName) {
        this.constructionName = constructionName;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getStationTypeName() {
        return stationTypeName;
    }

    public void setStationTypeName(String stationTypeName) {
        this.stationTypeName = stationTypeName;
    }

    public String getStationStatusName() {
        return stationStatusName;
    }

    public void setStationStatusName(String stationStatusName) {
        this.stationStatusName = stationStatusName;
    }

    public String getChargingStationId() {
        return chargingStationId;
    }

    public void setChargingStationId(String chargingStationId) {
        this.chargingStationId = chargingStationId;
    }

    public String getChargingStationName() {
        return chargingStationName;
    }

    public void setChargingStationName(String chargingStationName) {
        this.chargingStationName = chargingStationName;
    }

    public String getChargingStationAddr() {
        return chargingStationAddr;
    }

    public void setChargingStationAddr(String chargingStationAddr) {
        this.chargingStationAddr = chargingStationAddr;
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
        this.createUser = createUser;
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
        this.updateUser = updateUser;
    }

    public Date getUpdateDttm() {
        return updateDttm;
    }

    public void setUpdateDttm(Date updateDttm) {
        this.updateDttm = updateDttm;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public String getEquipmentOwnerId() {
        return equipmentOwnerId;
    }

    public void setEquipmentOwnerId(String equipmentOwnerId) {
        this.equipmentOwnerId = equipmentOwnerId;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getChargingStationTel() {
        return chargingStationTel;
    }

    public void setChargingStationTel(String chargingStationTel) {
        this.chargingStationTel = chargingStationTel;
    }

    public String getChargingServiceTel() {
        return chargingServiceTel;
    }

    public void setChargingServiceTel(String chargingServiceTel) {
        this.chargingServiceTel = chargingServiceTel;
    }

    public Integer getChargingStationType() {
        return chargingStationType;
    }

    public void setChargingStationType(Integer chargingStationType) {
        this.chargingStationType = chargingStationType;
    }

    public Integer getChargingStationStatus() {
        return chargingStationStatus;
    }

    public void setChargingStationStatus(Integer chargingStationStatus) {
        this.chargingStationStatus = chargingStationStatus;
    }

    public Integer getParkNums() {
        return parkNums;
    }

    public void setParkNums(Integer parkNums) {
        this.parkNums = parkNums;
    }

    public Double getChargingStationLng() {
        return chargingStationLng;
    }

    public void setChargingStationLng(Double chargingStationLng) {
        this.chargingStationLng = chargingStationLng;
    }

    public Double getChargingStationLat() {
        return chargingStationLat;
    }

    public void setChargingStationLat(Double chargingStationLat) {
        this.chargingStationLat = chargingStationLat;
    }

    public String getSiteGuide() {
        return siteGuide;
    }

    public void setSiteGuide(String siteGuide) {
        this.siteGuide = siteGuide;
    }

    public Integer getConstruction() {
        return construction;
    }

    public void setConstruction(Integer construction) {
        this.construction = construction;
    }

    public String getPictures() {
        return pictures;
    }

    public void setPictures(String pictures) {
        this.pictures = pictures;
    }

    public String getMatchCars() {
        return matchCars;
    }

    public void setMatchCars(String matchCars) {
        this.matchCars = matchCars;
    }

    public String getParkInfo() {
        return parkInfo;
    }

    public void setParkInfo(String parkInfo) {
        this.parkInfo = parkInfo;
    }

    public String getBusineHoures() {
        return busineHoures;
    }

    public void setBusineHoures(String busineHoures) {
        this.busineHoures = busineHoures;
    }

    public String getElectricityFee() {
        return electricityFee;
    }

    public void setElectricityFee(String electricityFee) {
        this.electricityFee = electricityFee;
    }

    public String getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(String serviceFee) {
        this.serviceFee = serviceFee;
    }

    public String getParkFee() {
        return parkFee;
    }

    public void setParkFee(String parkFee) {
        this.parkFee = parkFee;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public Byte getSupportOrder() {
        return supportOrder;
    }

    public void setSupportOrder(Byte supportOrder) {
        this.supportOrder = supportOrder;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ChargingstationRewrite that = (ChargingstationRewrite) o;

        if (chargingStationId != null ? !chargingStationId.equals(that.chargingStationId) : that.chargingStationId != null)
            return false;
        if (chargingStationName != null ? !chargingStationName.equals(that.chargingStationName) : that.chargingStationName != null)
            return false;
        if (chargingStationAddr != null ? !chargingStationAddr.equals(that.chargingStationAddr) : that.chargingStationAddr != null)
            return false;
        if (enabled != null ? !enabled.equals(that.enabled) : that.enabled != null) return false;
        if (createUser != null ? !createUser.equals(that.createUser) : that.createUser != null) return false;
        if (createDttm != null ? !createDttm.equals(that.createDttm) : that.createDttm != null) return false;
        if (updateUser != null ? !updateUser.equals(that.updateUser) : that.updateUser != null) return false;
        if (updateDttm != null ? !updateDttm.equals(that.updateDttm) : that.updateDttm != null) return false;
        if (operatorId != null ? !operatorId.equals(that.operatorId) : that.operatorId != null) return false;
        if (equipmentOwnerId != null ? !equipmentOwnerId.equals(that.equipmentOwnerId) : that.equipmentOwnerId != null)
            return false;
        if (countryCode != null ? !countryCode.equals(that.countryCode) : that.countryCode != null) return false;
        if (areaCode != null ? !areaCode.equals(that.areaCode) : that.areaCode != null) return false;
        if (chargingStationTel != null ? !chargingStationTel.equals(that.chargingStationTel) : that.chargingStationTel != null)
            return false;
        if (chargingServiceTel != null ? !chargingServiceTel.equals(that.chargingServiceTel) : that.chargingServiceTel != null)
            return false;
        if (chargingStationType != null ? !chargingStationType.equals(that.chargingStationType) : that.chargingStationType != null)
            return false;
        if (chargingStationStatus != null ? !chargingStationStatus.equals(that.chargingStationStatus) : that.chargingStationStatus != null)
            return false;
        if (parkNums != null ? !parkNums.equals(that.parkNums) : that.parkNums != null) return false;
        if (chargingStationLng != null ? !chargingStationLng.equals(that.chargingStationLng) : that.chargingStationLng != null)
            return false;
        if (chargingStationLat != null ? !chargingStationLat.equals(that.chargingStationLat) : that.chargingStationLat != null)
            return false;
        if (siteGuide != null ? !siteGuide.equals(that.siteGuide) : that.siteGuide != null) return false;
        if (construction != null ? !construction.equals(that.construction) : that.construction != null) return false;
        if (pictures != null ? !pictures.equals(that.pictures) : that.pictures != null) return false;
        if (matchCars != null ? !matchCars.equals(that.matchCars) : that.matchCars != null) return false;
        if (parkInfo != null ? !parkInfo.equals(that.parkInfo) : that.parkInfo != null) return false;
        if (busineHoures != null ? !busineHoures.equals(that.busineHoures) : that.busineHoures != null) return false;
        if (electricityFee != null ? !electricityFee.equals(that.electricityFee) : that.electricityFee != null)
            return false;
        if (serviceFee != null ? !serviceFee.equals(that.serviceFee) : that.serviceFee != null) return false;
        if (parkFee != null ? !parkFee.equals(that.parkFee) : that.parkFee != null) return false;
        if (payment != null ? !payment.equals(that.payment) : that.payment != null) return false;
        if (supportOrder != null ? !supportOrder.equals(that.supportOrder) : that.supportOrder != null) return false;
        if (remark != null ? !remark.equals(that.remark) : that.remark != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = chargingStationId != null ? chargingStationId.hashCode() : 0;
        result = 31 * result + (operatorId != null ? operatorId.hashCode() : 0);
        result = 31 * result + (equipmentOwnerId != null ? equipmentOwnerId.hashCode() : 0);
        result = 31 * result + (countryCode != null ? countryCode.hashCode() : 0);
        result = 31 * result + (areaCode != null ? areaCode.hashCode() : 0);
        result = 31 * result + (chargingStationName != null ? chargingStationName.hashCode() : 0);
        result = 31 * result + (chargingStationAddr != null ? chargingStationAddr.hashCode() : 0);
        result = 31 * result + (chargingStationTel != null ? chargingStationTel.hashCode() : 0);
        result = 31 * result + (chargingServiceTel != null ? chargingServiceTel.hashCode() : 0);
        result = 31 * result + (chargingStationType != null ? chargingStationType.hashCode() : 0);
        result = 31 * result + (chargingStationStatus != null ? chargingStationStatus.hashCode() : 0);
        result = 31 * result + (parkNums != null ? parkNums.hashCode() : 0);
        result = 31 * result + (chargingStationLng != null ? chargingStationLng.hashCode() : 0);
        result = 31 * result + (chargingStationLat != null ? chargingStationLat.hashCode() : 0);
        result = 31 * result + (siteGuide != null ? siteGuide.hashCode() : 0);
        result = 31 * result + (construction != null ? construction.hashCode() : 0);
        result = 31 * result + (pictures != null ? pictures.hashCode() : 0);
        result = 31 * result + (matchCars != null ? matchCars.hashCode() : 0);
        result = 31 * result + (parkInfo != null ? parkInfo.hashCode() : 0);
        result = 31 * result + (busineHoures != null ? busineHoures.hashCode() : 0);
        result = 31 * result + (electricityFee != null ? electricityFee.hashCode() : 0);
        result = 31 * result + (serviceFee != null ? serviceFee.hashCode() : 0);
        result = 31 * result + (parkFee != null ? parkFee.hashCode() : 0);
        result = 31 * result + (payment != null ? payment.hashCode() : 0);
        result = 31 * result + (supportOrder != null ? supportOrder.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        result = 31 * result + (enabled != null ? enabled.hashCode() : 0);
        result = 31 * result + (createUser != null ? createUser.hashCode() : 0);
        result = 31 * result + (createDttm != null ? createDttm.hashCode() : 0);
        result = 31 * result + (updateUser != null ? updateUser.hashCode() : 0);
        result = 31 * result + (updateDttm != null ? updateDttm.hashCode() : 0);
        return result;
    }
}