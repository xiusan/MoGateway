package com.mogateway.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mogateway.entity.Ammeter;
import com.mogateway.entity.AmmeterCriteria;
import com.mogateway.mapper.AmmeterMapper;
import com.mogateway.service.AmmeterService;
import com.mogateway.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author weizheng
 * @create 2018-05-15 11:23
 * @desc 电表
 **/
@Service
public class AmmeterServiceImpl implements AmmeterService {

    @Autowired
    private AmmeterMapper ammeterMapper;

    @Override
    public int insertSelective(Ammeter record) {
        return ammeterMapper.insertSelective(record);
    }

    @Override
    public int deleteByPrimaryKey(String ammeterId) {
        return ammeterMapper.deleteByPrimaryKey(ammeterId);
    }

    @Override
    public int updateByPrimaryKey(Ammeter record) {
        return ammeterMapper.updateByPrimaryKey(record);
    }


    @Override
    public PageInfo<Ammeter> queryList(Ammeter ammeter, int start, int length) {
        AmmeterCriteria example = new AmmeterCriteria();
        AmmeterCriteria.Criteria criteria = example.createCriteria();
        if(StringUtils.isNotEmpty(ammeter.getAmmeterId())){
            criteria.andAmmeterIdEqualTo(ammeter.getAmmeterId());
        }
        if (StringUtils.isNotEmpty(ammeter.getAgreementId())){
            criteria.andAgreementIdEqualTo1(ammeter.getAgreementId());
        }
        //分页查询
        PageHelper.startPage(start, length);

        example.setOrderByClause("  amm.create_dttm ASC  ");
        List<Ammeter> ammeters = ammeterMapper.queryList(example);

        return new PageInfo<>(ammeters);
    }

    @Override
    public Ammeter selectByPrimaryKey(String ammeterId) {
        return ammeterMapper.selectByPrimaryKey(ammeterId);
    }
}
