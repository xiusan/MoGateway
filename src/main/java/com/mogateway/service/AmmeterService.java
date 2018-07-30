package com.mogateway.service;

import com.github.pagehelper.PageInfo;
import com.mogateway.entity.Ammeter;

/**
 * @author weizheng
 * @create 2018-05-15 11:21
 * @desc 电表
 **/
public interface AmmeterService {

    int insertSelective(Ammeter record);

    int deleteByPrimaryKey(String ammeterId);

    int updateByPrimaryKey(Ammeter record);

    PageInfo<Ammeter> queryList(Ammeter ammeter, int start, int length);

    Ammeter selectByPrimaryKey(String ammeterId);
}