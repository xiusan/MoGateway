package com.mogateway.entity;

import java.util.Date;

/**
 * Created by Administrator on 2018-04-26.
 */
public class LogHistory {

    private Integer ID;

    private String ModuleID;

    private Date FileDateStart;

    private Date FileDateEnd;

    private String FileAddress;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getModuleID() {
        return ModuleID;
    }

    public void setModuleID(String moduleID) {
        ModuleID = moduleID;
    }

    public Date getFileDateStart() {
        return FileDateStart;
    }

    public void setFileDateStart(Date fileDateStart) {
        FileDateStart = fileDateStart;
    }

    public Date getFileDateEnd() {
        return FileDateEnd;
    }

    public void setFileDateEnd(Date fileDateEnd) {
        FileDateEnd = fileDateEnd;
    }

    public String getFileAddress() {
        return FileAddress;
    }

    public void setFileAddress(String fileAddress) {
        FileAddress = fileAddress;
    }
}
