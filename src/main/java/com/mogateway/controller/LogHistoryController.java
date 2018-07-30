package com.mogateway.controller;

import com.github.pagehelper.PageInfo;
import com.mogateway.entity.LogHistory;
import com.mogateway.redis.RedisUtil;
import com.mogateway.service.LogHistoryService;
import com.mogateway.util.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Map;

/**
 * Created by Administrator on 2018-04-26.
 */
@RestController
public class LogHistoryController extends BaseController {

    @Autowired
    private LogHistoryService logHistoryService;

    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping("/getLogHistory")
    public Map<String, Object> getLogHistory(LogHistory logHistory, Integer pageNum, Integer pageSize) {
        map.clear();
        try {
            PageInfo<LogHistory> eventRecordPageInfo = logHistoryService.getLogHistory(logHistory, pageNum, pageSize);
            map.put("logHistorys", eventRecordPageInfo.getList());
            map.put("totalCnt", eventRecordPageInfo.getTotal());
            map.put("result", "success");
        } catch (Exception e) {
            map.put("result", "error");
            redisUtil.pubLog("LogManage", "日志管理", "admin", CommonUtils.exception2Str(e));
        }
        return map;
    }

    @PostMapping("/logFileDownLoad")
    public ResponseEntity<byte[]> fileDownLoad(HttpServletRequest request, String filePath) throws Exception {
        InputStream in = new FileInputStream(new File(filePath));
        byte[] body = new byte[in.available()];
        in.read(body);
        String fileName = new String(filePath.substring(filePath.length() - new StringBuilder(filePath).reverse().toString().indexOf("/"), filePath.length()).getBytes("gbk"), "iso8859-1");
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment;filename=" + fileName);
        HttpStatus statusCode = HttpStatus.OK;
        return new ResponseEntity<byte[]>(body, headers, statusCode);
    }
}
