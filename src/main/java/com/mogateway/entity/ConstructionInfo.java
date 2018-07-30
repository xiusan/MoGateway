package com.mogateway.entity;




/**
* 建设场所管理实体
* 类名 ConstructionInfo
*
*/

public class ConstructionInfo {
	private String id;

    private Integer construction; // 建设场所ID
    private String constructionName; // 建设场所名称
    private String createUser; // 创建者
    private String createDttm; // 创建时间
    private String updateUser; // 更新者
    private String updateDttm; // 更新时间
		public String getId() {
		return id;
		}

		public void setId(String id) {
		this.id = id;
		}
        public Integer getConstruction() {
        return construction;
        }
        public void  setConstruction(Integer construction) {
        this.construction = construction;
        }






        public String getConstructionName() {
        return constructionName;
        }
        public void  setConstructionName(String constructionName) {
        this.constructionName = constructionName;
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
