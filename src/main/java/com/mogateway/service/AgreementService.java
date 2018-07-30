package com.mogateway.service;

import com.mogateway.entity.Agreement;
import com.mogateway.entity.AgreementCriteria;
import com.mogateway.mapper.AgreementMapper;
import com.mogateway.redis.RedisUtil;
import com.mogateway.util.CmdUtil;
import com.mogateway.util.CommonUtils;
import com.mogateway.util.Const;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2018-04-11.
 */
@Component
public class AgreementService {

    @Autowired
    private AgreementMapper agreementMapper;

    @Autowired
    private AgreementRedis agreementRedis;

    @Autowired
    private RedisUtil redisUtil;

    public List<Agreement> getAgreements() {
        List<Agreement> agreements = agreementMapper.getAgreements();
        return  agreements;
    }

    public int addAgreement(Agreement agreement, String userID) {
        agreement.setCreateUser(userID);
        agreement.setUpdateUser(userID);
        agreement.setEnabled(1);
        int count = agreementMapper.addAgreement(agreement);
        if (count > 0) {
            setRedis(agreement);
        }
        return count;
    }

    public String addAgreementFile(MultipartFile fileSrc, String agreement) throws Exception {
        String filePath = Const.AGREEMENT_FILE_BASE_PATH + agreement + Const.FILE_SEPERATOR;
        File file = new File(filePath);
        if (!file.exists() && !file .isDirectory()) {
            file.mkdirs();
        }
        filePath += fileSrc.getOriginalFilename();
        file = new File(filePath);
        if (!file.exists()) {
            file.createNewFile();
        } else {
            file.delete();
            file.createNewFile();
        }
        FileOutputStream outputStream = new FileOutputStream(file, true);
        outputStream.write(fileSrc.getBytes());
        outputStream.flush();
        outputStream.close();
        return filePath;
    }

    private void setRedis(Agreement agreement) {
        List<Agreement> agreements = new ArrayList<Agreement>();
        agreements.add(agreement);
        agreementRedis.setAgreementRedis(agreements);
    }

    public void operateAgreement(String operation, String agreementID) throws Exception {
        JSONObject agreementJson = null;
        String key = CommonUtils.getKey("agreement", agreementID);
        if (redisUtil.exists(key)) {
            agreementJson = JSONObject.fromObject(redisUtil.getValue(key));
            if (agreementJson != null) {
                if ("start".equals(operation)) {
                    redisUtil.setValue("agreement:starting:key", key);
                    CmdUtil.startJar(agreementJson.getString("agreementAddr"));
                } else {
                    CmdUtil.killProcess(agreementJson.getInt("agreementPID"));
                }
            }
        }
    }

    public int updateAgreement(String operation, String agreementID, String userID) throws Exception {
        int excCnt = 0;
        JSONObject agreementJson = null;
        String key = CommonUtils.getKey("agreement", agreementID);
        if (!redisUtil.exists(key)) {
            return -1;
        }
        agreementJson = JSONObject.fromObject(redisUtil.getValue(key).toString());
        if (agreementJson == null) {
            return -1;
        }
        switch (operation) {
            case "start":
                agreementJson.put("enabled", "启用");
                agreementJson.put("agreementStatus", "正常");
                redisUtil.setValue(key, agreementJson.toString());
                excCnt = agreementMapper.updateAgreement(userID, 0, agreementID);
                break;
            case "stop":
                agreementJson.put("enabled", "禁用");
                agreementJson.put("agreementStatus", "异常");
                agreementJson.put("agreementPID", -1);
                agreementJson.put("agreementCount", 0);
                redisUtil.setValue(key, agreementJson.toString());
                excCnt = agreementMapper.updateAgreement(userID, 1, agreementID);
                break;
            case "delete":
                redisUtil.remove(key);
                excCnt = agreementMapper.deleteAgreement(agreementID);
                break;
            default:
                break;
        }
        return excCnt;
    }

    List<Agreement> selectByExample(Agreement agreement) {
        AgreementCriteria example = new AgreementCriteria();
        AgreementCriteria.Criteria criteria = example.createCriteria();

        if (StringUtils.isNotEmpty(agreement.getAgreementName())){
            criteria.andAgreementNameEqualTo(agreement.getAgreementName());
        }
        List<Agreement> agreements = agreementMapper.selectByExample(example);
        return agreements;
    };
}
