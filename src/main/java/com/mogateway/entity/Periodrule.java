package com.mogateway.entity;

import java.util.Date;

public class Periodrule {
    private Integer id;

    private String ruleid;

    private Date periodstartdttm;

    private Date periodenddttm;

    private int periodstartid;

    private Double periodprice;

    private String createuser;

    private Date createdttm;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRuleid() {
        return ruleid;
    }

    public void setRuleid(String ruleid) {
        this.ruleid = ruleid == null ? null : ruleid.trim();
    }

    public Date getPeriodstartdttm() {
        return periodstartdttm;
    }

    public void setPeriodstartdttm(Date periodstartdttm) {
        this.periodstartdttm = periodstartdttm;
    }

    public Date getPeriodenddttm() {
        return periodenddttm;
    }

    public void setPeriodenddttm(Date periodenddttm) {
        this.periodenddttm = periodenddttm;
    }

    public int getPeriodstartid() {
        return periodstartid;
    }

    public void setPeriodstartid(int periodstartid) {
        this.periodstartid = periodstartid;
    }

    public Double getPeriodprice() {
        return periodprice;
    }

    public void setPeriodprice(Double periodprice) {
        this.periodprice = periodprice;
    }

    public String getCreateuser() {
        return createuser;
    }

    public void setCreateuser(String createuser) {
        this.createuser = createuser == null ? null : createuser.trim();
    }

    public Date getCreatedttm() {
        return createdttm;
    }

    public void setCreatedttm(Date createdttm) {
        this.createdttm = createdttm;
    }
}