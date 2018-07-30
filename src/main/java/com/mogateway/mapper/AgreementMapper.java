package com.mogateway.mapper;

import com.mogateway.entity.Agreement;
import com.mogateway.entity.AgreementCriteria;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by Administrator on 2018-04-11.
 */
@Mapper
public interface AgreementMapper {

    @Select("select * from agreement")
    public List<Agreement> getAgreements();

    @Insert("insert into agreement(" +
            "agreement_id," +
            "agreement_name," +
            "agreement_addr," +
            "enabled," +
            "agreement_sub_channel," +
            "agreement_pub_channel," +
            "agreement_home_url," +
            "create_user," +
            "create_dttm," +
            "update_user," +
            "update_dttm) values (" +
            "#{AgreementID}," +
            "#{AgreementName}," +
            "#{AgreementAddr}," +
            "#{Enabled}," +
            "#{AgreementSubChannel}," +
            "#{AgreementPubChannel}," +
            "#{AgreementHomeUrl}," +
            "#{CreateUser}," +
            "now()," +
            "#{UpdateUser}," +
            "now())")
    public int addAgreement(Agreement agreement);

    @Update("update agreement set enabled=#{enabled},update_user=#{userID},update_dttm=now() where agreement_id = #{agreementID}")
    int updateAgreement(@Param("userID") String userID, @Param("enabled") Integer enabled, @Param("agreementID") String agreementID);

    @Delete("delete from agreement where agreement_id = #{agreementID}")
    int deleteAgreement(@Param("agreementID") String agreementID);

    long countByExample(AgreementCriteria example);

    int deleteByExample(AgreementCriteria example);

    int deleteByPrimaryKey(String agreementId);

    int insert(Agreement record);

    int insertSelective(Agreement record);

    List<Agreement> selectByExample(AgreementCriteria example);

    Agreement selectByPrimaryKey(String agreementId);

    int updateByExampleSelective(@Param("record") Agreement record, @Param("example") AgreementCriteria example);

    int updateByExample(@Param("record") Agreement record, @Param("example") AgreementCriteria example);

    int updateByPrimaryKeySelective(Agreement record);

    int updateByPrimaryKey(Agreement record);

    @Update("update agreement set enabled=1")
    int disableAgreement();
}
