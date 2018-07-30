package com.mogateway.controller;

import com.github.pagehelper.PageInfo;
import com.mogateway.contans.Constants;
import com.mogateway.entity.ChargeRecord;
import com.mogateway.redis.RedisUtil;
import com.mogateway.service.ChargeRecordService;
import com.mogateway.util.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author weizheng
 * @create 2018-04-10 9:53
 * @desc 充电记录管理接口
 **/
@Api(value="ChargeRecordController", description ="充电记录管理接口")
@RestController
@RequestMapping(value="/chargeRecord")
public class ChargeRecordController {


    @Autowired
    private ChargeRecordService chargeRecordService;

    @Autowired
    private RedisUtil redisUtil;



    @ApiOperation(value = "充电记录列表信息", notes = "充电记录列表信息")
    @ApiImplicitParams({
            @ApiImplicitParam(  paramType = "body", dataType = "MessageParam", name = "pageNumber", value = "当前页"),
            @ApiImplicitParam(  paramType = "body", dataType = "MessageParam", name = "pageSize", value = "每页条数"),
    })
    @RequestMapping(value="/chargeRecordList", method= RequestMethod.POST)
    public Result chargeRecordList(ChargeRecord chargeRecord,
                                   @RequestParam(required = false, defaultValue = "1") int pageNumber,
                                   @RequestParam(required = false, defaultValue = "3") int pageSize,
                                   @RequestParam(required = false, defaultValue = "") String startChargingDate,
                                   @RequestParam(required = false, defaultValue = "") String endChargingDate)
    {
        Result res = new Result();
        Map<String,Object> map = new HashMap<>();
        try {
            if (StringUtils.isNotEmpty(startChargingDate) && StringUtils.isNotEmpty(endChargingDate)){
                chargeRecord.setStartChargingDttm(DateUtil.praseString2LongDate(startChargingDate));
                chargeRecord.setEndChargingDttm(DateUtil.praseString2LongDate(endChargingDate));
            }
            chargeRecord.setAbnormalFlag(1);
            PageInfo<ChargeRecord> pageInfo = chargeRecordService.selectByExample(chargeRecord,pageNumber,pageSize);
            System.out.println("pageInfo.getTotal():"+pageInfo.getTotal());
            map.put("recordsTotal",pageInfo.getTotal());
            map.put("recordsFiltered",pageInfo.getTotal());
            map.put("list", pageInfo.getList());
            res.addSuccess(map);
        } catch (Exception e) {
            redisUtil.pubLog("ChargeRecordManage", "正常充电记录管理", "admin", CommonUtils.exception2Str(e));
            res.addError(ErrorCode.SYS40005,ErrorCode.SYS40005_INFO);
        }
        return res;
    }

    @ApiOperation(value = "异常充电记录列表信息", notes = "异常充电记录列表信息")
    @ApiImplicitParams({
            @ApiImplicitParam(  paramType = "body", dataType = "MessageParam", name = "pageNumber", value = "当前页"),
            @ApiImplicitParam(  paramType = "body", dataType = "MessageParam", name = "pageSize", value = "每页条数"),
    })
    @RequestMapping(value="/abnormalChargeRecordList", method= RequestMethod.POST)
    public Result abnormalChargeRecordList(ChargeRecord chargeRecord,
                                           @RequestParam(required = false, defaultValue = "1") int pageNumber,
                                           @RequestParam(required = false, defaultValue = "3") int pageSize,
                                           @RequestParam(required = false, defaultValue = "") String startChargingDate,
                                           @RequestParam(required = false, defaultValue = "") String endChargingDate)
    {
        Result res = new Result();
        Map<String,Object> map = new HashMap<>();
        try {
            if (StringUtils.isNotEmpty(startChargingDate) && StringUtils.isNotEmpty(endChargingDate)){
                chargeRecord.setStartChargingDttm(DateUtil.praseString2Date(startChargingDate));
                chargeRecord.setEndChargingDttm(DateUtil.praseString2Date(endChargingDate));
            }
            chargeRecord.setAbnormalFlag(0);
            PageInfo<ChargeRecord> pageInfo = chargeRecordService.selectByExample(chargeRecord,pageNumber,pageSize);
            System.out.println("pageInfo.getTotal():"+pageInfo.getTotal());
            map.put("recordsTotal",pageInfo.getTotal());
            map.put("recordsFiltered",pageInfo.getTotal());
            map.put("list", pageInfo.getList());
            res.addSuccess(map);
        } catch (Exception e) {
            redisUtil.pubLog("ChargeRecordManage", "异常充电记录管理", "admin", CommonUtils.exception2Str(e));
            res.addError(ErrorCode.SYS40005,ErrorCode.SYS40005_INFO);
        }
        return res;
    }

    @ApiOperation(value = "充电记录度数，次数，时长统计", notes = "充电记录度数，次数，时长统计")
    @RequestMapping(value="/chargeRecordStatistics", method= RequestMethod.POST)
    public Result chargeRecordStatistics(@RequestParam Integer abnormalFlag )
    {
        Result res = new Result();
        Map<String,Object> map = new HashMap<>();
        try {
            ChargeRecord chargeRecord = chargeRecordService.chargeRecordStatistics(abnormalFlag);
            map.put("totalChargingKwh",chargeRecord.getTotalChargingKwh());
            map.put("chargeCount",chargeRecord.getChargeCount());
            String totalChargingDttm = DateUtil.secToTime(chargeRecord.getTotalChargingDttm());
            map.put("totalChargingDttm",totalChargingDttm);
            res.addSuccess(map);
        } catch (Exception e) {
            redisUtil.pubLog("ChargeRecordManage", "充电记录度数，次数，时长统计", "admin", CommonUtils.exception2Str(e));
            res.addError(ErrorCode.SYS40005,ErrorCode.SYS40005_INFO);
        }
        return res;
    }



    //生成表excel
    @ApiOperation(value = "生成表excel", notes = "生成表excel")
    @RequestMapping(value = "/export", method = RequestMethod.POST,produces="text/html;charset=UTF-8")
    public void export(HttpServletResponse response, HttpServletRequest request,
                       ChargeRecord chargeRecord,
                       @RequestParam(required = false, defaultValue = "") String startChargingDate,
                       @RequestParam(required = false, defaultValue = "") String endChargingDate) throws Exception {
        if (StringUtils.isNotEmpty(startChargingDate) && StringUtils.isNotEmpty(endChargingDate)){
            chargeRecord.setStartChargingDttm(DateUtil.praseString2Date(startChargingDate));
            chargeRecord.setEndChargingDttm(DateUtil.praseString2Date(endChargingDate));
        }

        Result res =new Result();

        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("充电记录");
        chargeRecordService.createTitle(workbook,sheet);
        List<ChargeRecord> chargeRecordList = chargeRecordService.queryList(chargeRecord);




        //设置日期格式
        HSSFCellStyle style = workbook.createCellStyle();
        style.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy h:mm"));

        //新增数据行，并且设置单元格数据
        int rowNum=1;
        for(ChargeRecord chargeRecord1:chargeRecordList){

                HSSFRow row = sheet.createRow(rowNum);
                row.createCell(0).setCellValue(chargeRecord1.getChargingRecordNo());
                row.createCell(1).setCellValue(chargeRecord1.getEquipmentNo());
                row.createCell(2).setCellValue(chargeRecord1.getCarNumber());
                HSSFCell cell = row.createCell(3);
                cell.setCellValue(chargeRecord1.getCardNumber());

                row.createCell(4).setCellValue(chargeRecord1.getStartChargingDttm());
                row.createCell(5).setCellValue(chargeRecord1.getEndChargingDttm());
                row.createCell(6).setCellValue(chargeRecord1.getTotalChargingDttm());
                row.createCell(7).setCellValue(chargeRecord1.getStartAmmeterNo());
                row.createCell(8).setCellValue(chargeRecord1.getEntAmmeterNo());
                row.createCell(9).setCellValue(chargeRecord1.getTotalChargingKwh());
                row.createCell(10).setCellValue(chargeRecord1.getStartSoc());
                row.createCell(11).setCellValue(chargeRecord1.getEndSoc());
                row.createCell(12).setCellValue(chargeRecord1.getTotalSoc());
                row.createCell(13).setCellValue(chargeRecord1.getEndReason());
                row.createCell(14).setCellValue(chargeRecord1.getMessage());

                row.createCell(15).setCellValue(chargeRecord1.getSharpStartChargingDttm());
                row.createCell(16).setCellValue(chargeRecord1.getSharpEndChargingDttm());
                row.createCell(17).setCellValue(chargeRecord1.getSharpStartAmmeterNo());
                row.createCell(18).setCellValue(chargeRecord1.getSharpEndAmmeterNo());
                row.createCell(19).setCellValue(chargeRecord1.getSharpTotalChargingKwh());

                row.createCell(20).setCellValue(chargeRecord1.getPeakStartChargingDttm());
                row.createCell(21).setCellValue(chargeRecord1.getPeakEndChargingDttm());
                row.createCell(22).setCellValue(chargeRecord1.getPeakStartAmmeterNo());
                row.createCell(23).setCellValue(chargeRecord1.getPeakEndAmmeterNo());
                row.createCell(24).setCellValue(chargeRecord1.getPeakTotalChargingKwh());

                row.createCell(25).setCellValue(chargeRecord1.getFlatStartChargingDttm());
                row.createCell(26).setCellValue(chargeRecord1.getFlatEndChargingDttm());
                row.createCell(27).setCellValue(chargeRecord1.getFlatStartAmmeterNo());
                row.createCell(28).setCellValue(chargeRecord1.getFlatEndAmmeterNo());
                row.createCell(29).setCellValue(chargeRecord1.getFlatTotalChargingKwh());

                row.createCell(30).setCellValue(chargeRecord1.getValleyStartChargingDttm());
                row.createCell(31).setCellValue(chargeRecord1.getValleyEndChargingDttm());
                row.createCell(32).setCellValue(chargeRecord1.getValleyStartAmmeterNo());
                row.createCell(33).setCellValue(chargeRecord1.getValleyEndAmmeterNo());
                row.createCell(34).setCellValue(chargeRecord1.getValleyTotalChargingKwh());

                cell.setCellStyle(style);
                rowNum++;
                if (rowNum>=1000){
                    break;
                }
        }

        String fileName = "充电记录.xls";

        //生成excel文件
        chargeRecordService.buildExcelFile(fileName, workbook);

        //浏览器下载excel
        chargeRecordService.buildExcelDocument(fileName,workbook,response);

        response.setContentType("text/xml;charset=UTF-8");
        response.setHeader("Cache-Control", "no-cache");
        response.setCharacterEncoding("UTF-8");

        res.addSuccess(null);
        workbook.write(response.getOutputStream());
    }







}
