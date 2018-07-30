package com.mogateway.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2017/11/15 0015.
 */
@Controller
public class IndexController extends BaseController {

    @RequestMapping("")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("/index")
    public String doLogin(){
        return "index";
    }

    @RequestMapping("/connectManage")
    public String toConnectManage(){
        return "connectManage";
    }

    @RequestMapping("/logHistory")
    public String toLogHistory(){
        return "logHistory";
    }

    @RequestMapping("/logSetting")
    public String toLogSetting(){
        return "logSetting";
    }

    @RequestMapping("/eventType")
    public String toEventType(){
        return "eventType";
    }

    @RequestMapping("/eventRecord")
    public String toEventRecord(){
        return "eventRecord";
    }


    /**
     * 设备管理
     * @return
     */
    @RequestMapping("/equipment-list")
    public String equipmentlist() {
        return "equipment_list";
    }


    @RequestMapping("/agreementManage")
    public String toAgreementManage(){
        return "agreementManage";
    }
    /**
     * 定时任务
     * @return
     */
    @RequestMapping("/taskList")
    public String taskList() {
        return "task_list";
    }
    /**
     * 表达式生成器
     * @return
     */
    @RequestMapping("/cron")
    public String cron() {
        return "cron";
    }

    /**
     * 实时状态
     * @return
     */
    @RequestMapping("/realTimeList")
    public String realTimeList() {
        return "real_time_list";
    }

    /**
     * 实时状态视图
     * @return
     */
    @RequestMapping("/realTimeListView")
    public String realTimeListView() {
        return "real_time_list_view";
    }

    /**
     * c充电记录
     * @return
     */
    @RequestMapping("/chargeRecordList")
    public String chargeRecordList() {
        return "charge_record_list";
    }

    /**
     * c充电异常记录
     * @return
     */
    @RequestMapping("/abnormalChargeRecordList")
    public String abnormalChargeRecordList() {
        return "charge_record_list_abnormal";
    }

    /**
     * 云平台地址管理
     * @return
     */
    @RequestMapping("/addCloudAddressManager")
    public String addCloudAddressManager() {
        return "cloud_address_manager_add";
    }

    /**
     * 云平台地址管理
     * @return
     */
    @RequestMapping("/dataManagerRealTime")
    public String dataManagerRealTime() {
        return "data_manager_real_time";
    }

    /**
     * 历史数据
     * @return
     */
    @RequestMapping("/queryHistoryDataList")
    public String queryHistoryDataList() {
        return "data_manager_history_data";
    }

    @GetMapping("/carProcess")
    public String layouts() {
        return "process";
    }

    @GetMapping("/equipmentProcess")
    public String pile() {
        return "pile";
    }


    /**
     * 电表管理
     * @return
     */
    @RequestMapping("/amterList")
    public String amterList() {
        return "ammter_list";
    }

    /**
     * 电表配置
     * @return
     */
    @RequestMapping("/serialConfigList")
    public String serialConfigList() {
        return "serial_config_list";
    }
}
