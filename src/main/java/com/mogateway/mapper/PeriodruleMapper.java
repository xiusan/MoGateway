package com.mogateway.mapper;

import com.mogateway.entity.Periodrule;
import com.mogateway.entity.PeriodruleCriteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PeriodruleMapper {
    long countByExample(PeriodruleCriteria example);

    int deleteByExample(PeriodruleCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(Periodrule record);

    int insertSelective(Periodrule record);

    List<Periodrule> selectByExample(PeriodruleCriteria example);

    List<Periodrule> finListAll(PeriodruleCriteria example);

    Periodrule selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Periodrule record, @Param("example") PeriodruleCriteria example);

    int updateByExample(@Param("record") Periodrule record, @Param("example") PeriodruleCriteria example);

    int updateByPrimaryKeySelective(Periodrule record);

    int updateByPrimaryKey(Periodrule record);
}