package com.mogateway.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mogateway.entity.OperatorInfo;
import com.mogateway.mapper.OperatorInfoMapper;



/**
 * @author xiaojinlu
 * @create 2018-07-11 9:09
 * @desc 运营管理-运营厂商
 **/
@Service("operatorInfoService")
public class  OperatorInfoService {

    @Autowired
    private OperatorInfoMapper operatorInfoMapper;

    /**
     * 查询列表
     * @param operatorInfo
     * @return
     */
    public List<OperatorInfo> getOperatorInfoList(OperatorInfo operatorInfo) {
        return operatorInfoMapper.getOperatorInfoList(operatorInfo);
    }


    public int saveOperatorInfo(OperatorInfo operatorInfo) {
        return operatorInfoMapper.saveOperatorInfo(operatorInfo);
    }

    public int updateOperatorInfo(OperatorInfo operatorInfo) {
        return operatorInfoMapper.updateOperatorInfo(operatorInfo);
    }

    public int delOperatorInfo(OperatorInfo operatorInfo) {
        return operatorInfoMapper.delOperatorInfo(operatorInfo);
    }
}