package com.mogateway.entity;

import java.util.Date;

public class ChargeRecord {
    private Long id;

    private String chargingRecordNo;

    private String orderNumber;

    private String equipmentNo;

    private String carNumber;

    private String cardNumber;

    private String chargingStationId;

    private Date startChargingDttm;

    private Date endChargingDttm;

    private Double startAmmeterNo;

    private Double entAmmeterNo;

    private Double discountAmount;

    private Double chargedAmount;

    private Integer startSoc;

    private Integer endSoc;

    private Integer totalSoc;

    private Integer endReason;

    private String message;

    private Date sharpStartChargingDttm;

    private Date sharpEndChargingDttm;

    private Double sharpStartAmmeterNo;

    private Double sharpEndAmmeterNo;

    private Double sharpTotalChargingKwh;

    private int sharpTotalChargingDTTM;

    private Double sharpTotalChargingAmount;

    private Date peakStartChargingDttm;

    private Date peakEndChargingDttm;

    private Double peakStartAmmeterNo;

    private Double peakEndAmmeterNo;

    private Double peakTotalChargingKwh;

    private int peakTotalChargingDTTM;

    private Double peakTotalChargingAmount;

    private Date flatStartChargingDttm;

    private Date flatEndChargingDttm;

    private Double flatStartAmmeterNo;

    private Double flatEndAmmeterNo;

    private Double flatTotalChargingKwh;

    private int flatTotalChargingDTTM;

    private Double flatTotalChargingAmount;

    private Date valleyStartChargingDttm;

    private Date valleyEndChargingDttm;

    private Double valleyStartAmmeterNo;

    private Double valleyEndAmmeterNo;

    private Double valleyTotalChargingKwh;

    private int valleyTotalChargingDTTM;

    private Double valleyTotalChargingAmount;

    private Integer sendFlagKj;

    private Integer sendFlagOther;

    private Integer abnormalFlag;

    private String createUser;

    private Date createDttm;

    private String updateUser;

    private Date updateDttm;

    private Double totalChargingKwh;

    private Integer totalChargingDttm;

    private Integer chargeCount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getChargingRecordNo() {
        return chargingRecordNo;
    }

    public void setChargingRecordNo(String chargingRecordNo) {
        this.chargingRecordNo = chargingRecordNo == null ? null : chargingRecordNo.trim();
    }

    public String getEquipmentNo() {
        return equipmentNo;
    }

    public void setEquipmentNo(String equipmentNo) {
        this.equipmentNo = equipmentNo == null ? null : equipmentNo.trim();
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber == null ? null : carNumber.trim();
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber == null ? null : cardNumber.trim();
    }

    public Date getStartChargingDttm() {
        return startChargingDttm;
    }

    public void setStartChargingDttm(Date startChargingDttm) {
        this.startChargingDttm = startChargingDttm;
    }

    public Date getEndChargingDttm() {
        return endChargingDttm;
    }

    public void setEndChargingDttm(Date endChargingDttm) {
        this.endChargingDttm = endChargingDttm;
    }

    public Integer getTotalChargingDttm() {
        return totalChargingDttm;
    }

    public void setTotalChargingDttm(Integer totalChargingDttm) {
        this.totalChargingDttm = totalChargingDttm;
    }

    public Double getStartAmmeterNo() {
        return startAmmeterNo;
    }

    public void setStartAmmeterNo(Double startAmmeterNo) {
        this.startAmmeterNo = startAmmeterNo;
    }

    public Double getEntAmmeterNo() {
        return entAmmeterNo;
    }

    public void setEntAmmeterNo(Double entAmmeterNo) {
        this.entAmmeterNo = entAmmeterNo;
    }

    public Double getTotalChargingKwh() {
        return totalChargingKwh;
    }

    public void setTotalChargingKwh(Double totalChargingKwh) {
        this.totalChargingKwh = totalChargingKwh;
    }

    public Integer getStartSoc() {
        return startSoc;
    }

    public void setStartSoc(Integer startSoc) {
        this.startSoc = startSoc;
    }

    public Integer getEndSoc() {
        return endSoc;
    }

    public void setEndSoc(Integer endSoc) {
        this.endSoc = endSoc;
    }

    public Integer getTotalSoc() {
        return totalSoc;
    }

    public void setTotalSoc(Integer totalSoc) {
        this.totalSoc = totalSoc;
    }

    public Integer getEndReason() {
        return endReason;
    }

    public void setEndReason(Integer endReason) {
        this.endReason = endReason;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }

    public Date getSharpStartChargingDttm() {
        return sharpStartChargingDttm;
    }

    public void setSharpStartChargingDttm(Date sharpStartChargingDttm) {
        this.sharpStartChargingDttm = sharpStartChargingDttm;
    }

    public Date getSharpEndChargingDttm() {
        return sharpEndChargingDttm;
    }

    public void setSharpEndChargingDttm(Date sharpEndChargingDttm) {
        this.sharpEndChargingDttm = sharpEndChargingDttm;
    }

    public Double getSharpStartAmmeterNo() {
        return sharpStartAmmeterNo;
    }

    public void setSharpStartAmmeterNo(Double sharpStartAmmeterNo) {
        this.sharpStartAmmeterNo = sharpStartAmmeterNo;
    }

    public Double getSharpEndAmmeterNo() {
        return sharpEndAmmeterNo;
    }

    public void setSharpEndAmmeterNo(Double sharpEndAmmeterNo) {
        this.sharpEndAmmeterNo = sharpEndAmmeterNo;
    }

    public Double getSharpTotalChargingKwh() {
        return sharpTotalChargingKwh;
    }

    public void setSharpTotalChargingKwh(Double sharpTotalChargingKwh) {
        this.sharpTotalChargingKwh = sharpTotalChargingKwh;
    }

    public Date getPeakStartChargingDttm() {
        return peakStartChargingDttm;
    }

    public void setPeakStartChargingDttm(Date peakStartChargingDttm) {
        this.peakStartChargingDttm = peakStartChargingDttm;
    }

    public Date getPeakEndChargingDttm() {
        return peakEndChargingDttm;
    }

    public void setPeakEndChargingDttm(Date peakEndChargingDttm) {
        this.peakEndChargingDttm = peakEndChargingDttm;
    }

    public Double getPeakStartAmmeterNo() {
        return peakStartAmmeterNo;
    }

    public void setPeakStartAmmeterNo(Double peakStartAmmeterNo) {
        this.peakStartAmmeterNo = peakStartAmmeterNo;
    }

    public Double getPeakEndAmmeterNo() {
        return peakEndAmmeterNo;
    }

    public void setPeakEndAmmeterNo(Double peakEndAmmeterNo) {
        this.peakEndAmmeterNo = peakEndAmmeterNo;
    }

    public Double getPeakTotalChargingKwh() {
        return peakTotalChargingKwh;
    }

    public void setPeakTotalChargingKwh(Double peakTotalChargingKwh) {
        this.peakTotalChargingKwh = peakTotalChargingKwh;
    }

    public Date getFlatStartChargingDttm() {
        return flatStartChargingDttm;
    }

    public void setFlatStartChargingDttm(Date flatStartChargingDttm) {
        this.flatStartChargingDttm = flatStartChargingDttm;
    }

    public Date getFlatEndChargingDttm() {
        return flatEndChargingDttm;
    }

    public void setFlatEndChargingDttm(Date flatEndChargingDttm) {
        this.flatEndChargingDttm = flatEndChargingDttm;
    }

    public Double getFlatStartAmmeterNo() {
        return flatStartAmmeterNo;
    }

    public void setFlatStartAmmeterNo(Double flatStartAmmeterNo) {
        this.flatStartAmmeterNo = flatStartAmmeterNo;
    }

    public Double getFlatEndAmmeterNo() {
        return flatEndAmmeterNo;
    }

    public void setFlatEndAmmeterNo(Double flatEndAmmeterNo) {
        this.flatEndAmmeterNo = flatEndAmmeterNo;
    }

    public Double getFlatTotalChargingKwh() {
        return flatTotalChargingKwh;
    }

    public void setFlatTotalChargingKwh(Double flatTotalChargingKwh) {
        this.flatTotalChargingKwh = flatTotalChargingKwh;
    }

    public Date getValleyStartChargingDttm() {
        return valleyStartChargingDttm;
    }

    public void setValleyStartChargingDttm(Date valleyStartChargingDttm) {
        this.valleyStartChargingDttm = valleyStartChargingDttm;
    }

    public Date getValleyEndChargingDttm() {
        return valleyEndChargingDttm;
    }

    public void setValleyEndChargingDttm(Date valleyEndChargingDttm) {
        this.valleyEndChargingDttm = valleyEndChargingDttm;
    }

    public Double getValleyStartAmmeterNo() {
        return valleyStartAmmeterNo;
    }

    public void setValleyStartAmmeterNo(Double valleyStartAmmeterNo) {
        this.valleyStartAmmeterNo = valleyStartAmmeterNo;
    }

    public Double getValleyEndAmmeterNo() {
        return valleyEndAmmeterNo;
    }

    public void setValleyEndAmmeterNo(Double valleyEndAmmeterNo) {
        this.valleyEndAmmeterNo = valleyEndAmmeterNo;
    }

    public Double getValleyTotalChargingKwh() {
        return valleyTotalChargingKwh;
    }

    public void setValleyTotalChargingKwh(Double valleyTotalChargingKwh) {
        this.valleyTotalChargingKwh = valleyTotalChargingKwh;
    }

    public Integer getSendFlagKj() {
        return sendFlagKj;
    }

    public void setSendFlagKj(Integer sendFlagKj) {
        this.sendFlagKj = sendFlagKj;
    }

    public Integer getSendFlagOther() {
        return sendFlagOther;
    }

    public void setSendFlagOther(Integer sendFlagOther) {
        this.sendFlagOther = sendFlagOther;
    }

    public Integer getAbnormalFlag() {
        return abnormalFlag;
    }

    public void setAbnormalFlag(Integer abnormalFlag) {
        this.abnormalFlag = abnormalFlag;
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



    public Integer getChargeCount() {
        return chargeCount;
    }

    public void setChargeCount(Integer chargeCount) {
        this.chargeCount = chargeCount;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Double getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(Double discountAmount) {
        this.discountAmount = discountAmount;
    }

    public Double getChargedAmount() {
        return chargedAmount;
    }

    public void setChargedAmount(Double chargedAmount) {
        this.chargedAmount = chargedAmount;
    }


    public String getChargingStationId() {
        return chargingStationId;
    }

    public void setChargingStationId(String chargingStationId) {
        this.chargingStationId = chargingStationId == null ? null : chargingStationId.trim();
    }

    public int getSharpTotalChargingDTTM() {
        return sharpTotalChargingDTTM;
    }

    public void setSharpTotalChargingDTTM(int sharpTotalChargingDTTM) {
        this.sharpTotalChargingDTTM = sharpTotalChargingDTTM;
    }

    public Double getSharpTotalChargingAmount() {
        return sharpTotalChargingAmount;
    }

    public void setSharpTotalChargingAmount(Double sharpTotalChargingAmount) {
        this.sharpTotalChargingAmount = sharpTotalChargingAmount;
    }

    public int getPeakTotalChargingDTTM() {
        return peakTotalChargingDTTM;
    }

    public void setPeakTotalChargingDTTM(int peakTotalChargingDTTM) {
        this.peakTotalChargingDTTM = peakTotalChargingDTTM;
    }

    public Double getPeakTotalChargingAmount() {
        return peakTotalChargingAmount;
    }

    public void setPeakTotalChargingAmount(Double peakTotalChargingAmount) {
        this.peakTotalChargingAmount = peakTotalChargingAmount;
    }

    public int getFlatTotalChargingDTTM() {
        return flatTotalChargingDTTM;
    }

    public void setFlatTotalChargingDTTM(int flatTotalChargingDTTM) {
        this.flatTotalChargingDTTM = flatTotalChargingDTTM;
    }

    public Double getFlatTotalChargingAmount() {
        return flatTotalChargingAmount;
    }

    public void setFlatTotalChargingAmount(Double flatTotalChargingAmount) {
        this.flatTotalChargingAmount = flatTotalChargingAmount;
    }

    public int getValleyTotalChargingDTTM() {
        return valleyTotalChargingDTTM;
    }

    public void setValleyTotalChargingDTTM(int valleyTotalChargingDTTM) {
        this.valleyTotalChargingDTTM = valleyTotalChargingDTTM;
    }

    public Double getValleyTotalChargingAmount() {
        return valleyTotalChargingAmount;
    }

    public void setValleyTotalChargingAmount(Double valleyTotalChargingAmount) {
        this.valleyTotalChargingAmount = valleyTotalChargingAmount;
    }
}