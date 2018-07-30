package com.mogateway.controller;

import com.alibaba.fastjson.JSONObject;
import com.mogateway.entity.EquipmentCriteria;
import com.mogateway.mapper.ChargingProcessFileMapper;
import com.mogateway.mapper.EquipmentMapper;
import com.mogateway.mapper.ProcessMapper;
import com.mogateway.util.PageUtil;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * 创建用户:杨辽
 * 创建时间: 2018-04-09 09:11
 * 描   述:
 **/
@Api(value="ProcessController", description="充电过程")
@RestController
@RequestMapping("/process")
public class ProcessController extends DefaultController {

    @Autowired
    private ProcessMapper processMapper;

    @Autowired
    private EquipmentMapper equipmentMapper;

    @Autowired
    private ChargingProcessFileMapper chargingProcessFileMapper;

    @PostMapping("/select")
    public JSONObject select() {
        return new JSONObject(){
            {
                put("list", equipmentMapper.selectByExample(new EquipmentCriteria()));
            }
        };
    }

    @PostMapping("/list")
    public JSONObject list(@RequestBody final JSONObject object) {
        object.put("currentPage", null == object.get("currentPage") ? 1 : object.get("currentPage"));
        object.put("rowsPerPage", null == object.get("rowsPerPage") ? 10 : object.get("rowsPerPage"));
        return new JSONObject(){
            {
                put("list", processMapper.list(object));
                put("page", new PageUtil(object.getInteger("rowsPerPage"), object.getInteger("currentPage"), processMapper.listCount(object)));
            }
        };
    }


    @PostMapping("/processFileDownLoad")
    public ResponseEntity<byte[]> fileDownLoad(HttpServletRequest request, Integer id) throws Exception {
        String realPath = chargingProcessFileMapper.selectByPrimaryKey(id).getFilePath();
        InputStream in = new FileInputStream(new File(realPath));
        byte[] body = new byte[in.available()];
        in.read(body);
        String fileName = new String(realPath.substring(realPath.length() - new StringBuilder(realPath).reverse().toString().indexOf("/"), realPath.length()).getBytes("gbk"), "iso8859-1");
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment;filename=" + fileName);
        HttpStatus statusCode = HttpStatus.OK;
        return new ResponseEntity<byte[]>(body, headers, statusCode);
    }

}
