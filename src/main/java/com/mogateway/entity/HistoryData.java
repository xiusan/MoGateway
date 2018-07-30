package com.mogateway.entity;

public class HistoryData {
    private String historyId;

    private String instructionsName;

    private Integer isEnable;

    private Integer isFlangKj;

    private Integer isFlangCust;

    public String getHistoryId() {
        return historyId;
    }

    public void setHistoryId(String historyId) {
        this.historyId = historyId == null ? null : historyId.trim();
    }

    public String getInstructionsName() {
        return instructionsName;
    }

    public void setInstructionsName(String instructionsName) {
        this.instructionsName = instructionsName == null ? null : instructionsName.trim();
    }

    public Integer getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(Integer isEnable) {
        this.isEnable = isEnable;
    }

    public Integer getIsFlangKj() {
        return isFlangKj;
    }

    public void setIsFlangKj(Integer isFlangKj) {
        this.isFlangKj = isFlangKj;
    }

    public Integer getIsFlangCust() {
        return isFlangCust;
    }

    public void setIsFlangCust(Integer isFlangCust) {
        this.isFlangCust = isFlangCust;
    }
}