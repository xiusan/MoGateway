package com.mogateway.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mogateway.entity.SerialConfig;
import com.mogateway.entity.SerialConfigCriteria;
import com.mogateway.mapper.SerialConfigMapper;
import com.mogateway.service.SerialConfigService;
import com.mogateway.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author weizheng
 * @create 2018-05-15 15:08
 * @desc 电表配置
 **/
@Service
public class SerialConfigServiceImpl implements SerialConfigService {
    @Autowired
    private SerialConfigMapper serialConfigMapper;

    @Override
    public int deleteByPrimaryKey(String serialName) {
        return serialConfigMapper.deleteByPrimaryKey(serialName);
    }

    @Override
    public int insertSelective(SerialConfig record) {
        return serialConfigMapper.insertSelective(record);
    }

    @Override
    public int updateByPrimaryKey(SerialConfig record) {
        return serialConfigMapper.updateByPrimaryKey(record);
    }

    @Override
    public PageInfo<SerialConfig> selectByExample(SerialConfig record, int start, int length) {
        SerialConfigCriteria example = new SerialConfigCriteria();
        SerialConfigCriteria.Criteria criteria = example.createCriteria();

        if (StringUtils.isNotEmpty(record.getSerialName())){
            criteria.andSerialNameEqualTo(record.getSerialName());
        }
        //分页查询
        PageHelper.startPage(start, length);
        example.setOrderByClause("  create_dttm ASC  ");
        List<SerialConfig> serialConfigs = serialConfigMapper.selectByExample(example);
        return new PageInfo<>(serialConfigs);
    }

    @Override
    public List<SerialConfig> selectByExample() {
        SerialConfigCriteria example = new SerialConfigCriteria();
        SerialConfigCriteria.Criteria criteria = example.createCriteria();
        List<SerialConfig> serialConfigs = serialConfigMapper.selectByExample(example);
        return serialConfigs;
    }

    @Override
    public SerialConfig selectByPrimaryKey(String serialName) {
        return serialConfigMapper.selectByPrimaryKey(serialName);
    }
}
