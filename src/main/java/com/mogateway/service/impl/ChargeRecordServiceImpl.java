package com.mogateway.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mogateway.entity.ChargeRecord;
import com.mogateway.entity.ChargeRecordCriteria;
import com.mogateway.mapper.ChargeRecordMapper;
import com.mogateway.service.ChargeRecordService;
import com.mogateway.util.StringUtils;
import org.apache.poi.hssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

/**
 * @author weizheng
 * @create 2018-04-10 9:09
 * @desc 充电记录
 **/
@Service
public class ChargeRecordServiceImpl implements ChargeRecordService {

    @Autowired
    private ChargeRecordMapper chargeRecordMapper;

    @Override
    public PageInfo<ChargeRecord> selectByExample(ChargeRecord chargeRecord, int start, int length) {
        ChargeRecordCriteria example = new ChargeRecordCriteria();
        ChargeRecordCriteria.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotEmpty(chargeRecord.getEquipmentNo())) {
            criteria.andEquipmentNoEqualTo(chargeRecord.getEquipmentNo());
        }
        if (StringUtils.isNotEmpty(chargeRecord.getCarNumber())){
            criteria.andCarNumberLike(chargeRecord.getCarNumber());
        }
        if (StringUtils.isNotEmpty(chargeRecord.getCardNumber())){
            criteria.andCardNumberLessThanOrEqualTo(chargeRecord.getCardNumber());
        }
        if (StringUtils.isNotEmpty(chargeRecord.getAbnormalFlag())){
            criteria.andAbnormalFlagEqualTo(chargeRecord.getAbnormalFlag());
        }
        if (StringUtils.isNotEmpty(chargeRecord.getSendFlagKj())){
            criteria.andSendFlagKjEqualTo(chargeRecord.getSendFlagKj());
        }
        if (chargeRecord.getStartChargingDttm()!=null && !"null".equals(chargeRecord.getStartChargingDttm()) && !"0000-00-00 00:00:00".equals(chargeRecord.getStartChargingDttm())   && chargeRecord.getEndChargingDttm()!=null && !"null".equals(chargeRecord.getEndChargingDttm()) && !"0000-00-00 00:00:00".equals(chargeRecord.getEndChargingDttm())){
            criteria.andStartChargingDttmGreaterThanOrEqualTo(chargeRecord.getStartChargingDttm());
            criteria.andEndChargingDttmLessThanOrEqualTo(chargeRecord.getEndChargingDttm());
        }


        //分页查询
        PageHelper.startPage(start, length);

        example.setOrderByClause("  start_charging_dttm DESC  ");

        List<ChargeRecord> chargeRecordList = chargeRecordMapper.selectByExample(example);
        return new PageInfo<>(chargeRecordList);
    }

    @Override
    public List<ChargeRecord> queryList(ChargeRecord chargeRecord) {
        ChargeRecordCriteria example = new ChargeRecordCriteria();
        ChargeRecordCriteria.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotEmpty(chargeRecord.getEquipmentNo())) {
            criteria.andEquipmentNoEqualTo(chargeRecord.getEquipmentNo());
        }
        if (StringUtils.isNotEmpty(chargeRecord.getCarNumber())){
            criteria.andCarNumberEqualTo(chargeRecord.getCarNumber());
        }
        if (StringUtils.isNotEmpty(chargeRecord.getCardNumber())){
            criteria.andCardNumberEqualTo(chargeRecord.getCardNumber());
        }
        if (chargeRecord.getStartChargingDttm()!=null && !"null".equals(chargeRecord.getStartChargingDttm()) && !"0000-00-00 00:00:00".equals(chargeRecord.getStartChargingDttm())   && chargeRecord.getEndChargingDttm()!=null && !"null".equals(chargeRecord.getEndChargingDttm()) && !"0000-00-00 00:00:00".equals(chargeRecord.getEndChargingDttm())){
            criteria.andStartChargingDttmGreaterThanOrEqualTo(chargeRecord.getStartChargingDttm());
            criteria.andEndChargingDttmLessThanOrEqualTo(chargeRecord.getEndChargingDttm());
        }

        example.setOrderByClause("  start_charging_dttm DESC  ");

        List<ChargeRecord> chargeRecordList = chargeRecordMapper.selectByExample(example);
        return  chargeRecordList;
    }

    @Override
    public int updateByPrimaryKeySelective(ChargeRecord record) {
        return chargeRecordMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public ChargeRecord chargeRecordStatistics(Integer abnormalFlag) {
        ChargeRecord chargeRecord = chargeRecordMapper.chargeRecordStatistics( abnormalFlag);
        return chargeRecord;
    }

    @Override
    public int insertSelective(ChargeRecord record) {
        return chargeRecordMapper.insertSelective(record);
    }


    //创建表头
    @Override
    public void createTitle(HSSFWorkbook workbook, HSSFSheet sheet){
        HSSFRow row = sheet.createRow(0);
        //设置列宽，setColumnWidth的第二个参数要乘以256，这个参数的单位是1/256个字符宽度
        sheet.setColumnWidth(1,12*256);
        sheet.setColumnWidth(3,17*256);

        //设置为居中加粗
        HSSFCellStyle style = workbook.createCellStyle();
        HSSFFont font = workbook.createFont();
        // font.setBold(true);
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        style.setFont(font);

        HSSFCell cell;
        cell = row.createCell(0);
        cell.setCellValue("充电记录号");
        cell.setCellStyle(style);


        cell = row.createCell(1);
        cell.setCellValue("设备号");
        cell.setCellStyle(style);

        cell = row.createCell(2);
        cell.setCellValue("车号");
        cell.setCellStyle(style);

        cell = row.createCell(3);
        cell.setCellValue("卡号");
        cell.setCellStyle(style);


        cell = row.createCell(4);
        cell.setCellValue("开始充电时间");
        cell.setCellStyle(style);


        cell = row.createCell(5);
        cell.setCellValue("结束充电时间");
        cell.setCellStyle(style);

        cell = row.createCell(6);
        cell.setCellValue("总充电时间");
        cell.setCellStyle(style);

        cell = row.createCell(7);
        cell.setCellValue("开始电表数");
        cell.setCellStyle(style);

        cell = row.createCell(8);
        cell.setCellValue("结束电表数");
        cell.setCellStyle(style);

        cell = row.createCell(9);
        cell.setCellValue("总充电量（度）");
        cell.setCellStyle(style);

        cell = row.createCell(10);
        cell.setCellValue("开始SOC（%）");
        cell.setCellStyle(style);

        cell = row.createCell(11);
        cell.setCellValue("结束SOC（%）");
        cell.setCellStyle(style);

        cell = row.createCell(12);
        cell.setCellValue("实充SOC（%）");
        cell.setCellStyle(style);

        cell = row.createCell(13);
        cell.setCellValue("停止原因");
        cell.setCellStyle(style);

        cell = row.createCell(14);
        cell.setCellValue("相关报文");
        cell.setCellStyle(style);

        cell = row.createCell(15);
        cell.setCellValue("开始充电时间（尖）");
        cell.setCellStyle(style);

        cell = row.createCell(16);
        cell.setCellValue("结束充电时间（尖）");
        cell.setCellStyle(style);



        cell = row.createCell(17);
        cell.setCellValue("开始电表数（尖）");
        cell.setCellStyle(style);

        cell = row.createCell(18);
        cell.setCellValue("结束电表数（尖）");
        cell.setCellStyle(style);

        cell = row.createCell(19);
        cell.setCellValue("充电量（尖）");
        cell.setCellStyle(style);
        cell = row.createCell(20);
        cell.setCellValue("开始充电时间（峰）");
        cell.setCellStyle(style);


        cell = row.createCell(21);
        cell.setCellValue("结束充电时间（峰）");
        cell.setCellStyle(style);


        cell = row.createCell(22);
        cell.setCellValue("开始电表数（峰）");
        cell.setCellStyle(style);


        cell = row.createCell(23);
        cell.setCellValue("结束电表数（峰）");
        cell.setCellStyle(style);

        cell = row.createCell(24);
        cell.setCellValue("充电量（峰）");
        cell.setCellStyle(style);

        cell = row.createCell(25);
        cell.setCellValue("开始充电时间（平）");
        cell.setCellStyle(style);

        cell = row.createCell(26);
        cell.setCellValue("结束充电时间（平）");
        cell.setCellStyle(style);

        cell = row.createCell(27);
        cell.setCellValue("开始电表数（平）");
        cell.setCellStyle(style);

        cell = row.createCell(28);
        cell.setCellValue("结束电表数（平）");
        cell.setCellStyle(style);

        cell = row.createCell(29);
        cell.setCellValue("充电量（平）");
        cell.setCellStyle(style);

        cell = row.createCell(30);
        cell.setCellValue("开始充电时间（谷）");
        cell.setCellStyle(style);

        cell = row.createCell(31);
        cell.setCellValue("结束充电时间（谷）");
        cell.setCellStyle(style);

        cell = row.createCell(32);
        cell.setCellValue("开始电表数（谷）");
        cell.setCellStyle(style);

        cell = row.createCell(33);
        cell.setCellValue("结束电表数（谷）");
        cell.setCellStyle(style);

        cell = row.createCell(34);
        cell.setCellValue("充电量（谷）");
        cell.setCellStyle(style);
    }

    //生成excel文件
    @Override
    public void buildExcelFile(String filename, HSSFWorkbook workbook) throws Exception {
        FileOutputStream fos = new FileOutputStream("D:\\"+filename);
        workbook.write(fos);
        fos.flush();
        fos.close();
    }


    //浏览器下载excel
    @Override
    public void buildExcelDocument(String filename, HSSFWorkbook workbook, HttpServletResponse response) throws Exception {

        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache, must-revalidate");
        response.setHeader("Pragma", "no-cache");

        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment;filename="+ URLEncoder.encode(filename, "utf-8"));
        OutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        outputStream.flush();
        outputStream.close();
    }


}
