package com.mogateway.entity;

import java.util.Date;

/**
 * Created by Administrator on 2018-04-26.
 */
public class Module {

    private String ModuleID;

    private String ModuleName;

    private String CreateUser;

    private Date CreateDTTM;

    public String getModuleID() {
        return ModuleID;
    }

    public void setModuleID(String moduleID) {
        ModuleID = moduleID;
    }

    public String getModuleName() {
        return ModuleName;
    }

    public void setModuleName(String moduleName) {
        ModuleName = moduleName;
    }

    public String getCreateUser() {
        return CreateUser;
    }

    public void setCreateUser(String createUser) {
        CreateUser = createUser;
    }

    public Date getCreateDTTM() {
        return CreateDTTM;
    }

    public void setCreateDTTM(Date createDTTM) {
        CreateDTTM = createDTTM;
    }
}
