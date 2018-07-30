package com.mogateway.entity;

import java.util.Date;

public class Task {
    private String timedTaskId;

    private String timedTaskName;

    private Date lastExecuTime;

    private Date nextExecuTime;

    private Date startTime;

    private Date stopTime;

    private String taskMethod;

    private String cronExpression;

    private Integer execuCount;

    private Integer failCount;

    private Integer missCount;

    private Integer execuCycle;

    private Integer cycle;

    private Integer taskStatus;

    private String createUserId;

    private Date creadate;

    private String updateUserId;

    private Date updateDate;

    private String jobGroupName;

    private String method;

    public String getTimedTaskId() {
        return timedTaskId;
    }

    public void setTimedTaskId(String timedTaskId) {
        this.timedTaskId = timedTaskId == null ? null : timedTaskId.trim();
    }

    public String getTimedTaskName() {
        return timedTaskName;
    }

    public void setTimedTaskName(String timedTaskName) {
        this.timedTaskName = timedTaskName == null ? null : timedTaskName.trim();
    }

    public Date getLastExecuTime() {
        return lastExecuTime;
    }

    public void setLastExecuTime(Date lastExecuTime) {
        this.lastExecuTime = lastExecuTime;
    }

    public Date getNextExecuTime() {
        return nextExecuTime;
    }

    public void setNextExecuTime(Date nextExecuTime) {
        this.nextExecuTime = nextExecuTime;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getStopTime() {
        return stopTime;
    }

    public void setStopTime(Date stopTime) {
        this.stopTime = stopTime;
    }

    public String getTaskMethod() {
        return taskMethod;
    }

    public void setTaskMethod(String taskMethod) {
        this.taskMethod = taskMethod == null ? null : taskMethod.trim();
    }

    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression == null ? null : cronExpression.trim();
    }

    public Integer getExecuCount() {
        return execuCount;
    }

    public void setExecuCount(Integer execuCount) {
        this.execuCount = execuCount;
    }

    public Integer getFailCount() {
        return failCount;
    }

    public void setFailCount(Integer failCount) {
        this.failCount = failCount;
    }

    public Integer getMissCount() {
        return missCount;
    }

    public void setMissCount(Integer missCount) {
        this.missCount = missCount;
    }

    public Integer getExecuCycle() {
        return execuCycle;
    }

    public void setExecuCycle(Integer execuCycle) {
        this.execuCycle = execuCycle;
    }

    public Integer getCycle() {
        return cycle;
    }

    public void setCycle(Integer cycle) {
        this.cycle = cycle;
    }

    public Integer getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(Integer taskStatus) {
        this.taskStatus = taskStatus;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId == null ? null : createUserId.trim();
    }

    public Date getCreadate() {
        return creadate;
    }

    public void setCreadate(Date creadate) {
        this.creadate = creadate;
    }

    public String getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(String updateUserId) {
        this.updateUserId = updateUserId == null ? null : updateUserId.trim();
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getJobGroupName() {
        return jobGroupName;
    }

    public void setJobGroupName(String jobGroupName) {
        this.jobGroupName = jobGroupName == null ? null : jobGroupName.trim();
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method == null ? null : method.trim();
    }
}