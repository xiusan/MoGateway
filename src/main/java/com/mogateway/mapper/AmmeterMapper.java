package com.mogateway.mapper;

import com.mogateway.entity.Ammeter;
import com.mogateway.entity.AmmeterCriteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface AmmeterMapper {
    long countByExample(AmmeterCriteria example);

    int deleteByExample(AmmeterCriteria example);

    int deleteByPrimaryKey(String ammeterId);

    int insert(Ammeter record);

    int insertSelective(Ammeter record);

    List<Ammeter> selectByExample(AmmeterCriteria example);
    List<Ammeter> queryList(AmmeterCriteria example);

    Ammeter selectByPrimaryKey(String ammeterId);

    int updateByExampleSelective(@Param("record") Ammeter record, @Param("example") AmmeterCriteria example);

    int updateByExample(@Param("record") Ammeter record, @Param("example") AmmeterCriteria example);

    int updateByPrimaryKeySelective(Ammeter record);

    int updateByPrimaryKey(Ammeter record);
}