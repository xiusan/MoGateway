package com.mogateway.service.impl;

import com.mogateway.entity.ChargingProcessFile;
import com.mogateway.entity.ChargingProcessFileCriteria;
import com.mogateway.mapper.ChargingProcessFileMapper;
import com.mogateway.service.ChargingProcessFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author weizheng
 * @create 2018-04-18 16:32
 * @desc 充电过程
 **/
@Service
public class ChargingProcessFileServiceImpl implements ChargingProcessFileService {


    @Autowired
    private ChargingProcessFileMapper chargingProcessFileMapper;

    @Override
    public List<ChargingProcessFile> selectByExample(ChargingProcessFile chargingProcessFile) {
        ChargingProcessFileCriteria example = new ChargingProcessFileCriteria();
        ChargingProcessFileCriteria.Criteria criteria = example.createCriteria();
        List<ChargingProcessFile> chargingProcessFiles = chargingProcessFileMapper.selectByExample(example);
        return chargingProcessFiles;
    }

    @Override
    public int updateByPrimaryKeySelective(ChargingProcessFile record) {
        return chargingProcessFileMapper.updateByPrimaryKeySelective(record);
    }
}
