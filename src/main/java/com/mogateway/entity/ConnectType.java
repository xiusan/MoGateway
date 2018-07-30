package com.mogateway.entity;

import io.swagger.models.auth.In;

import java.util.Date;

/**
 * 连接管理实体类
 */
public class ConnectType {

    /**
     * 主键
     */
    private int ID;

    /**
     * 连接类型名称
     */
    private String ConnectType;

    /**
     * 连接IP
     */
    private String ConnectIP;

    /**
     * 连接端口
     */
    private Integer ConnectPort;

    /**
     * 连接波特率
     */
    private Integer ConnectBaudRate;

    private String ConnectSerialPort;

    private Integer ConnectSerialCheckID;

    /**
     * 连接方向
     */
    private int ConnectDirection;

    /**
     * 连接文件
     */
    private String ConnectFile;

    /**
     * 连接要发送的redis通道
     */
    private String ConnectPubRedisChannel;

    /**
     * 连接要监听的redis通道
     */
    private String ConnectSubRedisChannel;

    private String ConnectHomeUrl;

    public String getConnectHomeUrl() {
        return ConnectHomeUrl;
    }

    public void setConnectHomeUrl(String connectHomeUrl) {
        ConnectHomeUrl = connectHomeUrl;
    }

    /**
     * 是否可用
     */
    private int Enabled;

    /**
     * 创建者
     */
    private String CreateUser;

    /**
     * 创建时间
     */
    private Date CreateDTTM;

    /**
     * 更新者
     */
    private String UpdateUser;

    /**
     * 更新时间
     */
    private Date UpdateDTTM;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getConnectType() {
        return ConnectType;
    }

    public void setConnectType(String connectType) {
        ConnectType = connectType;
    }

    public String getConnectIP() {
        return ConnectIP;
    }

    public void setConnectIP(String connectIP) {
        ConnectIP = connectIP;
    }

    public Integer getConnectPort() {
        return ConnectPort;
    }

    public void setConnectPort(Integer connectPort) {
        ConnectPort = connectPort;
    }

    public Integer getConnectBaudRate() {
        return ConnectBaudRate;
    }

    public void setConnectBaudRate(Integer connectBaudRate) {
        ConnectBaudRate = connectBaudRate;
    }

    public int getConnectDirection() {
        return ConnectDirection;
    }

    public void setConnectDirection(int connectDirection) {
        ConnectDirection = connectDirection;
    }

    public String getConnectFile() {
        return ConnectFile;
    }

    public void setConnectFile(String connectFile) {
        ConnectFile = connectFile;
    }

    public String getPubConnectRedisChannel() {
        return ConnectPubRedisChannel;
    }

    public void setPubConnectRedisChannel(String connectPubRedisChannel) {
        ConnectPubRedisChannel = connectPubRedisChannel;
    }

    public int getEnabled() {
        return Enabled;
    }

    public void setEnabled(int enabled) {
        Enabled = enabled;
    }

    public String getCreateUser() {
        return CreateUser;
    }

    public void setCreateUser(String createUser) {
        CreateUser = createUser;
    }

    public String getConnectSerialPort() {
        return ConnectSerialPort;
    }

    public void setConnectSerialPort(String connectSerialPort) {
        ConnectSerialPort = connectSerialPort;
    }

    public String getConnectPubRedisChannel() {
        return ConnectPubRedisChannel;
    }

    public void setConnectPubRedisChannel(String connectPubRedisChannel) {
        ConnectPubRedisChannel = connectPubRedisChannel;
    }

    public String getConnectSubRedisChannel() {
        return ConnectSubRedisChannel;
    }

    public void setConnectSubRedisChannel(String connectSubRedisChannel) {
        ConnectSubRedisChannel = connectSubRedisChannel;
    }

    public Date getCreateDTTM() {
        return CreateDTTM;
    }

    public void setCreateDTTM(Date createDTTM) {
        CreateDTTM = createDTTM;
    }

    public String getUpdateUser() {
        return UpdateUser;
    }

    public void setUpdateUser(String updateUser) {
        UpdateUser = updateUser;
    }

    public Date getUpdateDTTM() {
        return UpdateDTTM;
    }

    public void setUpdateDTTM(Date updateDTTM) {
        UpdateDTTM = updateDTTM;
    }

    public Integer getConnectSerialCheckID() {
        return ConnectSerialCheckID;
    }

    public void setConnectSerialCheckID(Integer connectSerialCheckID) {
        ConnectSerialCheckID = connectSerialCheckID;
    }
}
