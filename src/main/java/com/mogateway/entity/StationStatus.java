package com.mogateway.entity;




/**
* 站点状态管理实体
* 类名 StationStatus
*
*/

public class StationStatus {
    private Integer stationStatus; // 站点状态ID
    private String id; // id
    private String stationStatusName; // 站点状态名称
    private String createUser; // 创建者
    private String createDttm; // 创建时间
    private String updateUser; // 更新者
    private String updateDttm; // 更新时间


        public Integer getStationStatus() {
        return stationStatus;
        }

        public void  setStationStatus(Integer stationStatus) {
        this.stationStatus = stationStatus;
        }


        public String getStationStatusName() {
        return stationStatusName;
        }

        public void  setStationStatusName(String stationStatusName) {
        this.stationStatusName = stationStatusName;
        }


        public String getCreateUser() {
        return createUser;
        }

        public void  setCreateUser(String createUser) {
        this.createUser = createUser;
        }



        public String getCreateDttm() {
        return createDttm;
        }

        public void  setCreateDttm(String createDttm) {
        this.createDttm = createDttm;
        }


        public String getUpdateUser() {
        return updateUser;
        }

        public void  setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
        }



        public String getUpdateDttm() {
        return updateDttm;
        }

        public void  setUpdateDttm(String updateDttm) {
        this.updateDttm = updateDttm;
        }


        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
}
