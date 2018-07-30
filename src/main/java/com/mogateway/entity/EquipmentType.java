package com.mogateway.entity;

import java.util.Date;

public class EquipmentType {
    private Long equipmentType;

    private String equipmentTypeName;

    private String createUser;

    private Date createDttm;

    private String updateUser;

    private Date updateDttm;

    public Long getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(Long equipmentType) {
        this.equipmentType = equipmentType;
    }

    public String getEquipmentTypeName() {
        return equipmentTypeName;
    }

    public void setEquipmentTypeName(String equipmentTypeName) {
        this.equipmentTypeName = equipmentTypeName == null ? null : equipmentTypeName.trim();
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