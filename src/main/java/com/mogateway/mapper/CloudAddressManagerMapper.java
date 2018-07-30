package com.mogateway.mapper;

import com.mogateway.entity.CloudAddressManager;
import com.mogateway.entity.CloudAddressManagerCriteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CloudAddressManagerMapper {
    long countByExample(CloudAddressManagerCriteria example);

    int deleteByExample(CloudAddressManagerCriteria example);

    int deleteByPrimaryKey(String cloudId);

    int insert(CloudAddressManager record);

    int insertSelective(CloudAddressManager record);

    List<CloudAddressManager> selectByExample(CloudAddressManagerCriteria example);

    CloudAddressManager selectByPrimaryKey(String cloudId);

    int updateByExampleSelective(@Param("record") CloudAddressManager record, @Param("example") CloudAddressManagerCriteria example);

    int updateByExample(@Param("record") CloudAddressManager record, @Param("example") CloudAddressManagerCriteria example);

    int updateByPrimaryKeySelective(CloudAddressManager record);

    int updateByPrimaryKey(CloudAddressManager record);
}