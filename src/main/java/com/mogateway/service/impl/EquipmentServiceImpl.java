package com.mogateway.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mogateway.entity.Ammeter;
import com.mogateway.entity.AmmeterCriteria;
import com.mogateway.entity.Equipment;
import com.mogateway.entity.EquipmentCriteria;
import com.mogateway.mapper.AmmeterMapper;
import com.mogateway.mapper.EquipmentMapper;
import com.mogateway.service.EquipmentService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipmentServiceImpl implements EquipmentService {

    @Autowired
    private EquipmentMapper mapper;
    @Autowired
    private AmmeterMapper ammeterMapper;

    @Override
    public Equipment selectByPrimaryKey(String equipmentid) {
        return mapper.selectByPrimaryKey(equipmentid);
    }

    @Override
    public Equipment selectByNo(String equipmentNo) {
        return mapper.selectByNo(equipmentNo);
    }

    @Override
    public PageInfo<Equipment> queryList(Equipment equipment, int start, int length, String sortColumnsName, String sortOrder) {

        EquipmentCriteria example = new EquipmentCriteria();
        EquipmentCriteria.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotEmpty(equipment.getEquipmentNo())) {
            criteria.andEquipmentNoEqualTo(equipment.getEquipmentNo());
        }

        if (StringUtils.isNotEmpty(equipment.getAgreementId())){
            criteria.andAgreementIdEqualTo1(equipment.getAgreementId());
        }

        if (equipment.getActive() != null){
            criteria.andActiveEqualTo(equipment.getActive());
        }



        //分页查询
        PageHelper.startPage(start, length);
        if (StringUtils.isNotEmpty(sortColumnsName) && StringUtils.isNotEmpty(sortOrder)){
            if ( sortColumnsName.equals("equipmentName") && sortOrder.equals("asc")){
                example.setOrderByClause("  e.equipment_name asc  ");
            }
            if ( sortColumnsName.equals("equipmentName") && sortOrder.equals("desc")){
                example.setOrderByClause("  e.equipment_name desc  ");
            }
            if ( sortColumnsName.equals("equipmentNo") && sortOrder.equals("asc")){
                example.setOrderByClause("  e.equipment_no asc  ");
            }
            if ( sortColumnsName.equals("equipmentNo") && sortOrder.equals("desc")){
                example.setOrderByClause("  e.equipment_no desc  ");
            }
            if ( sortColumnsName.equals("chargingStatioNname") && sortOrder.equals("asc")){
                example.setOrderByClause("  e.charging_station_id asc  ");
            }
            if ( sortColumnsName.equals("chargingStatioNname") && sortOrder.equals("desc")){
                example.setOrderByClause("  e.charging_station_id desc  ");
            }
            if ( sortColumnsName.equals("active") && sortOrder.equals("asc")){
                example.setOrderByClause("  e.active asc  ");
            }
            if ( sortColumnsName.equals("active") && sortOrder.equals("desc")){
                example.setOrderByClause("  e.active desc  ");
            }
            if ( sortColumnsName.equals("equipmentType") && sortOrder.equals("asc")){
                example.setOrderByClause("  e.equipment_type asc  ");
            }
            if ( sortColumnsName.equals("equipmentType") && sortOrder.equals("desc")){
                example.setOrderByClause("  e.equipment_type desc  ");
            }
            if ( sortColumnsName.equals("agreementName") && sortOrder.equals("asc")){
                example.setOrderByClause("  e.agreement_id asc  ");
            }
            if ( sortColumnsName.equals("agreementName") && sortOrder.equals("desc")){
                example.setOrderByClause("  e.agreement_id desc  ");
            }
            if ( sortColumnsName.equals("manufacturer") && sortOrder.equals("asc")){
                example.setOrderByClause("  e.manufacturer asc  ");
            }
            if ( sortColumnsName.equals("manufacturer") && sortOrder.equals("desc")){
                example.setOrderByClause("  e.manufacturer desc  ");
            }
            if ( sortColumnsName.equals("manufacturerDttm") && sortOrder.equals("asc")){
                example.setOrderByClause("  e.manufacturer_dttm asc  ");
            }
            if ( sortColumnsName.equals("manufacturerDttm") && sortOrder.equals("desc")){
                example.setOrderByClause("  e.manufacturer_dttm desc  ");
            }
            if ( sortColumnsName.equals("deliveryDttm") && sortOrder.equals("asc")){
                example.setOrderByClause("  e.delivery_dttm asc  ");
            }
            if ( sortColumnsName.equals("deliveryDttm") && sortOrder.equals("desc")){
                example.setOrderByClause("  e.delivery_dttm desc  ");
            }
        }else {
            example.setOrderByClause("  e.equipment_no ASC  ");
        }



        List<Equipment> userList = mapper.queryList(example);
        return new PageInfo<>(userList);

    }

    @Override
    public List<Equipment> queryList(Equipment equipment) {
        EquipmentCriteria example = new EquipmentCriteria();
        EquipmentCriteria.Criteria criteria = example.createCriteria();

        return mapper.queryList(example);
    }

    @Override
    public int insertSelective(Equipment record) {
        return mapper.insertSelective(record);
    }

    @Override
    public int updateByPrimaryKeySelective(Equipment record) {
        return mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<Ammeter> selectAmmeterByExample(Ammeter ammeter) {
        AmmeterCriteria example = new AmmeterCriteria();
        AmmeterCriteria.Criteria criteria = example.createCriteria();
        example.setOrderByClause("  create_dttm  ");
        return ammeterMapper.selectByExample(example);
    }
}
