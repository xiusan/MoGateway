package com.mogateway.entity;




/**
* 站点类型管理实体
* 类名 StationType
*
*/

public class StationType {
    private String id; // id
    private Integer stationType; // 站点类型ID
    private String stationTypeName; // 站点类型名称
    private String createUser; // 创建者
    private String createDttm; // 创建时间
    private String updateUser; // 更新者
    private String updateDttm; // 更新时间


        public String getId() {
        return id;
        }
        public void  setId(String id) {
        this.id = id;
        }





        public Integer getStationType() {
        return stationType;
        }
        public void  setStationType(Integer stationType) {
        this.stationType = stationType;
        }






        public String getStationTypeName() {
        return stationTypeName;
        }
        public void  setStationTypeName(String stationTypeName) {
        this.stationTypeName = stationTypeName;
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






}
