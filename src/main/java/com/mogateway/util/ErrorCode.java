package com.mogateway.util;

import java.io.Serializable;

/**
 * @author weizheng
 * @create 2018-07-17 9:02
 * @desc 错误码
 **/
public class ErrorCode implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -2924805354832531156L;

    public final static String PUB10000 = "10000";
    public final static String PUB10000_INFO = "查询数据不存在";

    public final static String PUB10001 = "10001";
    public final static String PUB10001_INFO = "请求数据为空";

    public final static String PUB10002 = "10002";
    public final static String PUB10002_INFO = "修改信息失败";

    public final static String PUB10003 = "10003";
    public final static String PUB10003_INFO = "添加的数据已经存在请重新添加";

    /**
     * 系统内部故障
     */
    public final static String SYS40001 = "40001";
    public final static String SYS40001_INFO = "系统内部故障";
    /**
     * 新增数据异常
     */
    public final static String SYS40002 = "40002";
    public final static String SYS40002_INFO = "新增数据异常";
    /**
     * 更新数据异常
     */
    public final static String SYS40003 = "40003";
    public final static String SYS40003_INFO = "更新数据异常";
    /**
     * 删除数据异常
     */
    public final static String SYS40004 = "40004";
    public final static String SYS40004_INFO = "删除数据异常";
    /**
     * 查询数据异常
     */
    public final static String SYS40005 = "40005";
    public final static String SYS40005_INFO = "查询数据异常";


    /**
     * 查询数据异常
     */
    public final static String SYS40006 = "40006";
    public final static String SYS40006_INFO = "同步数据异常";



}
