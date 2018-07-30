package com.mogateway.contans;

/**
 * @author weizheng
 * @create 2018-03-29 19:16
 * @desc 常亮定义类
 **/
public class Constants {


    public static final String EXECUTION_COUNT = "COUNT";//第一次执行次数
    public static final String EXECUT_COUNT = "EXECUT_COUNT";//job执行次数
    public static final String JOB_MEHTOD = "JOB_MEHTOD";//job执行的url方法
    public static final String JOB_GROUP_NAME = "JOB_GROUP_NAME";//job分组名称


    public final static String DATA_MANAGER_REAL_TIME="DATA_MANAGER_REAL_TIME";//数据管理实时状态

    public final static String KJ_CLOUD_ADDRESS_URL="/subStation/request";//科佳云地址URL
    public final static String CUST_CLOUD_ADDRESS_URL="CUST_CLOUD_ADDRESS_URL";//客户云地址URL
    public final static String CLOUD_ADDRESS_MANAGER="CLOUD_ADDRESS_MANAGER";//云地址数据集

    public static final String CLOUD_ASKFORCOMMAND_URL = "/subStation/operate";






    private static final int SUBSTATION_TIMEOUT = 1000 * 5; 	//设置默认连接超时为5s
    private static final int SOCKET_TIMEOUT = 1000 * 30;        //设置默认读取超时为30s


}
