package com.mogateway.entity;

public class DataManagerRealTime {
    private String id;

    private String keyName;

    private Integer isSynchronization;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getKeyName() {
        return keyName;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName == null ? null : keyName.trim();
    }

    public Integer getIsSynchronization() {
        return isSynchronization;
    }

    public void setIsSynchronization(Integer isSynchronization) {
        this.isSynchronization = isSynchronization;
    }
}