package com.mogateway.service;

import com.github.pagehelper.PageInfo;
import com.mogateway.entity.ChargeRecord;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import javax.servlet.http.HttpServletResponse;
import java.util.List;


/**
 * @author weizheng
 * @create 2018-04-09 18:23
 * @desc 充电记录
 **/
public interface ChargeRecordService {

    /**
     * 查询充电记录分页数据
     * @param chargeRecord
     * @return
     */
    PageInfo<ChargeRecord> selectByExample(ChargeRecord chargeRecord, int start, int length);

    /**
     * 查询充电记录分页数据数据集合
     * @param chargeRecord
     * @return
     */
    List<ChargeRecord> queryList(ChargeRecord chargeRecord);

    /**
     * 修改充电记录同步状态
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(ChargeRecord record);


    /**
     * 查询充电度数,次数，时长
     * @return
     */
    ChargeRecord chargeRecordStatistics(Integer abnormalFlag);

    /**
     * 插入充电记录
     * @param record
     * @return
     */
    int insertSelective(ChargeRecord record);

    //创建表头
    public void createTitle(HSSFWorkbook workbook, HSSFSheet sheet);

    //生成excel文件
    public void buildExcelFile(String filename, HSSFWorkbook workbook) throws Exception;

    //浏览器下载excel
    public void buildExcelDocument(String filename, HSSFWorkbook workbook, HttpServletResponse response) throws Exception;
}