package com.mogateway.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EquipmentCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EquipmentCriteria() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andEquipmentIdIsNull() {
            addCriterion("equipment_id is null");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdIsNotNull() {
            addCriterion("equipment_id is not null");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdEqualTo(String value) {
            addCriterion("equipment_id =", value, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdNotEqualTo(String value) {
            addCriterion("equipment_id <>", value, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdGreaterThan(String value) {
            addCriterion("equipment_id >", value, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdGreaterThanOrEqualTo(String value) {
            addCriterion("equipment_id >=", value, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdLessThan(String value) {
            addCriterion("equipment_id <", value, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdLessThanOrEqualTo(String value) {
            addCriterion("equipment_id <=", value, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdLike(String value) {
            addCriterion("equipment_id like", value, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdNotLike(String value) {
            addCriterion("equipment_id not like", value, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdIn(List<String> values) {
            addCriterion("equipment_id in", values, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdNotIn(List<String> values) {
            addCriterion("equipment_id not in", values, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdBetween(String value1, String value2) {
            addCriterion("equipment_id between", value1, value2, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdNotBetween(String value1, String value2) {
            addCriterion("equipment_id not between", value1, value2, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentNoIsNull() {
            addCriterion("equipment_no is null");
            return (Criteria) this;
        }

        public Criteria andEquipmentNoIsNotNull() {
            addCriterion("equipment_no is not null");
            return (Criteria) this;
        }

        public Criteria andEquipmentNoEqualTo(String value) {
            addCriterion("equipment_no =", value, "equipmentNo");
            return (Criteria) this;
        }

        public Criteria andEquipmentNoNotEqualTo(String value) {
            addCriterion("equipment_no <>", value, "equipmentNo");
            return (Criteria) this;
        }

        public Criteria andEquipmentNoGreaterThan(String value) {
            addCriterion("equipment_no >", value, "equipmentNo");
            return (Criteria) this;
        }

        public Criteria andEquipmentNoGreaterThanOrEqualTo(String value) {
            addCriterion("equipment_no >=", value, "equipmentNo");
            return (Criteria) this;
        }

        public Criteria andEquipmentNoLessThan(String value) {
            addCriterion("equipment_no <", value, "equipmentNo");
            return (Criteria) this;
        }

        public Criteria andEquipmentNoLessThanOrEqualTo(String value) {
            addCriterion("equipment_no <=", value, "equipmentNo");
            return (Criteria) this;
        }

        public Criteria andEquipmentNoLike(String value) {
            addCriterion("equipment_no like", value, "equipmentNo");
            return (Criteria) this;
        }

        public Criteria andEquipmentNoNotLike(String value) {
            addCriterion("equipment_no not like", value, "equipmentNo");
            return (Criteria) this;
        }

        public Criteria andEquipmentNoIn(List<String> values) {
            addCriterion("equipment_no in", values, "equipmentNo");
            return (Criteria) this;
        }

        public Criteria andEquipmentNoNotIn(List<String> values) {
            addCriterion("equipment_no not in", values, "equipmentNo");
            return (Criteria) this;
        }

        public Criteria andEquipmentNoBetween(String value1, String value2) {
            addCriterion("equipment_no between", value1, value2, "equipmentNo");
            return (Criteria) this;
        }

        public Criteria andEquipmentNoNotBetween(String value1, String value2) {
            addCriterion("equipment_no not between", value1, value2, "equipmentNo");
            return (Criteria) this;
        }

        public Criteria andEquipmentNameIsNull() {
            addCriterion("equipment_name is null");
            return (Criteria) this;
        }

        public Criteria andEquipmentNameIsNotNull() {
            addCriterion("equipment_name is not null");
            return (Criteria) this;
        }

        public Criteria andEquipmentNameEqualTo(String value) {
            addCriterion("equipment_name =", value, "equipmentName");
            return (Criteria) this;
        }

        public Criteria andEquipmentNameNotEqualTo(String value) {
            addCriterion("equipment_name <>", value, "equipmentName");
            return (Criteria) this;
        }

        public Criteria andEquipmentNameGreaterThan(String value) {
            addCriterion("equipment_name >", value, "equipmentName");
            return (Criteria) this;
        }

        public Criteria andEquipmentNameGreaterThanOrEqualTo(String value) {
            addCriterion("equipment_name >=", value, "equipmentName");
            return (Criteria) this;
        }

        public Criteria andEquipmentNameLessThan(String value) {
            addCriterion("equipment_name <", value, "equipmentName");
            return (Criteria) this;
        }

        public Criteria andEquipmentNameLessThanOrEqualTo(String value) {
            addCriterion("equipment_name <=", value, "equipmentName");
            return (Criteria) this;
        }

        public Criteria andEquipmentNameLike(String value) {
            addCriterion("equipment_name like", value, "equipmentName");
            return (Criteria) this;
        }

        public Criteria andEquipmentNameNotLike(String value) {
            addCriterion("equipment_name not like", value, "equipmentName");
            return (Criteria) this;
        }

        public Criteria andEquipmentNameIn(List<String> values) {
            addCriterion("equipment_name in", values, "equipmentName");
            return (Criteria) this;
        }

        public Criteria andEquipmentNameNotIn(List<String> values) {
            addCriterion("equipment_name not in", values, "equipmentName");
            return (Criteria) this;
        }

        public Criteria andEquipmentNameBetween(String value1, String value2) {
            addCriterion("equipment_name between", value1, value2, "equipmentName");
            return (Criteria) this;
        }

        public Criteria andEquipmentNameNotBetween(String value1, String value2) {
            addCriterion("equipment_name not between", value1, value2, "equipmentName");
            return (Criteria) this;
        }

        public Criteria andChargingStationIdIsNull() {
            addCriterion("charging_station_id is null");
            return (Criteria) this;
        }

        public Criteria andChargingStationIdIsNotNull() {
            addCriterion("charging_station_id is not null");
            return (Criteria) this;
        }

        public Criteria andChargingStationIdEqualTo(String value) {
            addCriterion("charging_station_id =", value, "chargingStationId");
            return (Criteria) this;
        }

        public Criteria andChargingStationIdNotEqualTo(String value) {
            addCriterion("charging_station_id <>", value, "chargingStationId");
            return (Criteria) this;
        }

        public Criteria andChargingStationIdGreaterThan(String value) {
            addCriterion("charging_station_id >", value, "chargingStationId");
            return (Criteria) this;
        }

        public Criteria andChargingStationIdGreaterThanOrEqualTo(String value) {
            addCriterion("charging_station_id >=", value, "chargingStationId");
            return (Criteria) this;
        }

        public Criteria andChargingStationIdLessThan(String value) {
            addCriterion("charging_station_id <", value, "chargingStationId");
            return (Criteria) this;
        }

        public Criteria andChargingStationIdLessThanOrEqualTo(String value) {
            addCriterion("charging_station_id <=", value, "chargingStationId");
            return (Criteria) this;
        }

        public Criteria andChargingStationIdLike(String value) {
            addCriterion("charging_station_id like", value, "chargingStationId");
            return (Criteria) this;
        }

        public Criteria andChargingStationIdNotLike(String value) {
            addCriterion("charging_station_id not like", value, "chargingStationId");
            return (Criteria) this;
        }

        public Criteria andChargingStationIdIn(List<String> values) {
            addCriterion("charging_station_id in", values, "chargingStationId");
            return (Criteria) this;
        }

        public Criteria andChargingStationIdNotIn(List<String> values) {
            addCriterion("charging_station_id not in", values, "chargingStationId");
            return (Criteria) this;
        }

        public Criteria andChargingStationIdBetween(String value1, String value2) {
            addCriterion("charging_station_id between", value1, value2, "chargingStationId");
            return (Criteria) this;
        }

        public Criteria andChargingStationIdNotBetween(String value1, String value2) {
            addCriterion("charging_station_id not between", value1, value2, "chargingStationId");
            return (Criteria) this;
        }

        public Criteria andActiveIsNull() {
            addCriterion("active is null");
            return (Criteria) this;
        }

        public Criteria andActiveIsNotNull() {
            addCriterion("active is not null");
            return (Criteria) this;
        }

        public Criteria andActiveEqualTo(Boolean value) {
            addCriterion("active =", value, "active");
            return (Criteria) this;
        }

        public Criteria andActiveNotEqualTo(Boolean value) {
            addCriterion("active <>", value, "active");
            return (Criteria) this;
        }

        public Criteria andActiveGreaterThan(Boolean value) {
            addCriterion("active >", value, "active");
            return (Criteria) this;
        }

        public Criteria andActiveGreaterThanOrEqualTo(Boolean value) {
            addCriterion("active >=", value, "active");
            return (Criteria) this;
        }

        public Criteria andActiveLessThan(Boolean value) {
            addCriterion("active <", value, "active");
            return (Criteria) this;
        }

        public Criteria andActiveLessThanOrEqualTo(Boolean value) {
            addCriterion("active <=", value, "active");
            return (Criteria) this;
        }

        public Criteria andActiveIn(List<Boolean> values) {
            addCriterion("active in", values, "active");
            return (Criteria) this;
        }

        public Criteria andActiveNotIn(List<Boolean> values) {
            addCriterion("active not in", values, "active");
            return (Criteria) this;
        }

        public Criteria andActiveBetween(Boolean value1, Boolean value2) {
            addCriterion("active between", value1, value2, "active");
            return (Criteria) this;
        }

        public Criteria andActiveNotBetween(Boolean value1, Boolean value2) {
            addCriterion("active not between", value1, value2, "active");
            return (Criteria) this;
        }

        public Criteria andEquipmentTypeIsNull() {
            addCriterion("equipment_type is null");
            return (Criteria) this;
        }

        public Criteria andEquipmentTypeIsNotNull() {
            addCriterion("equipment_type is not null");
            return (Criteria) this;
        }

        public Criteria andEquipmentTypeEqualTo(long value) {
            addCriterion("equipment_type =", value, "equipmentType");
            return (Criteria) this;
        }

        public Criteria andEquipmentTypeNotEqualTo(long value) {
            addCriterion("equipment_type <>", value, "equipmentType");
            return (Criteria) this;
        }

        public Criteria andEquipmentTypeGreaterThan(long value) {
            addCriterion("equipment_type >", value, "equipmentType");
            return (Criteria) this;
        }

        public Criteria andEquipmentTypeGreaterThanOrEqualTo(long value) {
            addCriterion("equipment_type >=", value, "equipmentType");
            return (Criteria) this;
        }

        public Criteria andEquipmentTypeLessThan(long value) {
            addCriterion("equipment_type <", value, "equipmentType");
            return (Criteria) this;
        }

        public Criteria andEquipmentTypeLessThanOrEqualTo(long value) {
            addCriterion("equipment_type <=", value, "equipmentType");
            return (Criteria) this;
        }

        public Criteria andEquipmentTypeLike(long value) {
            addCriterion("equipment_type like", value, "equipmentType");
            return (Criteria) this;
        }

        public Criteria andEquipmentTypeNotLike(long value) {
            addCriterion("equipment_type not like", value, "equipmentType");
            return (Criteria) this;
        }

        public Criteria andEquipmentTypeIn(List<String> values) {
            addCriterion("equipment_type in", values, "equipmentType");
            return (Criteria) this;
        }

        public Criteria andEquipmentTypeNotIn(List<String> values) {
            addCriterion("equipment_type not in", values, "equipmentType");
            return (Criteria) this;
        }

        public Criteria andEquipmentTypeBetween(long value1, long value2) {
            addCriterion("equipment_type between", value1, value2, "equipmentType");
            return (Criteria) this;
        }

        public Criteria andEquipmentTypeNotBetween(long value1, long value2) {
            addCriterion("equipment_type not between", value1, value2, "equipmentType");
            return (Criteria) this;
        }

        public Criteria andAgreementIdIsNull() {
            addCriterion("agreement_id is null");
            return (Criteria) this;
        }

        public Criteria andAgreementIdIsNotNull() {
            addCriterion("agreement_id is not null");
            return (Criteria) this;
        }

        public Criteria andAgreementIdEqualTo(String value) {
            addCriterion("agreement_id =", value, "agreementId");
            return (Criteria) this;
        }

        public Criteria andAgreementIdEqualTo1(String value) {
            addCriterion("e.agreement_id =", value, "agreementId");
            return (Criteria) this;
        }

        public Criteria andAgreementIdNotEqualTo(String value) {
            addCriterion("agreement_id <>", value, "agreementId");
            return (Criteria) this;
        }

        public Criteria andAgreementIdGreaterThan(String value) {
            addCriterion("agreement_id >", value, "agreementId");
            return (Criteria) this;
        }

        public Criteria andAgreementIdGreaterThanOrEqualTo(String value) {
            addCriterion("agreement_id >=", value, "agreementId");
            return (Criteria) this;
        }

        public Criteria andAgreementIdLessThan(String value) {
            addCriterion("agreement_id <", value, "agreementId");
            return (Criteria) this;
        }

        public Criteria andAgreementIdLessThanOrEqualTo(String value) {
            addCriterion("agreement_id <=", value, "agreementId");
            return (Criteria) this;
        }

        public Criteria andAgreementIdLike(String value) {
            addCriterion("agreement_id like", value, "agreementId");
            return (Criteria) this;
        }

        public Criteria andAgreementIdNotLike(String value) {
            addCriterion("agreement_id not like", value, "agreementId");
            return (Criteria) this;
        }

        public Criteria andAgreementIdIn(List<String> values) {
            addCriterion("agreement_id in", values, "agreementId");
            return (Criteria) this;
        }

        public Criteria andAgreementIdNotIn(List<String> values) {
            addCriterion("agreement_id not in", values, "agreementId");
            return (Criteria) this;
        }

        public Criteria andAgreementIdBetween(String value1, String value2) {
            addCriterion("agreement_id between", value1, value2, "agreementId");
            return (Criteria) this;
        }

        public Criteria andAgreementIdNotBetween(String value1, String value2) {
            addCriterion("agreement_id not between", value1, value2, "agreementId");
            return (Criteria) this;
        }

        public Criteria andAmmeterIdIsNull() {
            addCriterion("ammeter_id is null");
            return (Criteria) this;
        }

        public Criteria andAmmeterIdIsNotNull() {
            addCriterion("ammeter_id is not null");
            return (Criteria) this;
        }

        public Criteria andAmmeterIdEqualTo(String value) {
            addCriterion("ammeter_id =", value, "ammeterId");
            return (Criteria) this;
        }

        public Criteria andAmmeterIdNotEqualTo(String value) {
            addCriterion("ammeter_id <>", value, "ammeterId");
            return (Criteria) this;
        }

        public Criteria andAmmeterIdGreaterThan(String value) {
            addCriterion("ammeter_id >", value, "ammeterId");
            return (Criteria) this;
        }

        public Criteria andAmmeterIdGreaterThanOrEqualTo(String value) {
            addCriterion("ammeter_id >=", value, "ammeterId");
            return (Criteria) this;
        }

        public Criteria andAmmeterIdLessThan(String value) {
            addCriterion("ammeter_id <", value, "ammeterId");
            return (Criteria) this;
        }

        public Criteria andAmmeterIdLessThanOrEqualTo(String value) {
            addCriterion("ammeter_id <=", value, "ammeterId");
            return (Criteria) this;
        }

        public Criteria andAmmeterIdLike(String value) {
            addCriterion("ammeter_id like", value, "ammeterId");
            return (Criteria) this;
        }

        public Criteria andAmmeterIdNotLike(String value) {
            addCriterion("ammeter_id not like", value, "ammeterId");
            return (Criteria) this;
        }

        public Criteria andAmmeterIdIn(List<String> values) {
            addCriterion("ammeter_id in", values, "ammeterId");
            return (Criteria) this;
        }

        public Criteria andAmmeterIdNotIn(List<String> values) {
            addCriterion("ammeter_id not in", values, "ammeterId");
            return (Criteria) this;
        }

        public Criteria andAmmeterIdBetween(String value1, String value2) {
            addCriterion("ammeter_id between", value1, value2, "ammeterId");
            return (Criteria) this;
        }

        public Criteria andAmmeterIdNotBetween(String value1, String value2) {
            addCriterion("ammeter_id not between", value1, value2, "ammeterId");
            return (Criteria) this;
        }

        public Criteria andConnectorTypeIsNull() {
            addCriterion("connector_type is null");
            return (Criteria) this;
        }

        public Criteria andConnectorTypeIsNotNull() {
            addCriterion("connector_type is not null");
            return (Criteria) this;
        }

        public Criteria andConnectorTypeEqualTo(Long value) {
            addCriterion("connector_type =", value, "connectorType");
            return (Criteria) this;
        }

        public Criteria andConnectorTypeNotEqualTo(Long value) {
            addCriterion("connector_type <>", value, "connectorType");
            return (Criteria) this;
        }

        public Criteria andConnectorTypeGreaterThan(Long value) {
            addCriterion("connector_type >", value, "connectorType");
            return (Criteria) this;
        }

        public Criteria andConnectorTypeGreaterThanOrEqualTo(Long value) {
            addCriterion("connector_type >=", value, "connectorType");
            return (Criteria) this;
        }

        public Criteria andConnectorTypeLessThan(Long value) {
            addCriterion("connector_type <", value, "connectorType");
            return (Criteria) this;
        }

        public Criteria andConnectorTypeLessThanOrEqualTo(Long value) {
            addCriterion("connector_type <=", value, "connectorType");
            return (Criteria) this;
        }

        public Criteria andConnectorTypeIn(List<Long> values) {
            addCriterion("connector_type in", values, "connectorType");
            return (Criteria) this;
        }

        public Criteria andConnectorTypeNotIn(List<Long> values) {
            addCriterion("connector_type not in", values, "connectorType");
            return (Criteria) this;
        }

        public Criteria andConnectorTypeBetween(Long value1, Long value2) {
            addCriterion("connector_type between", value1, value2, "connectorType");
            return (Criteria) this;
        }

        public Criteria andConnectorTypeNotBetween(Long value1, Long value2) {
            addCriterion("connector_type not between", value1, value2, "connectorType");
            return (Criteria) this;
        }

        public Criteria andVoltageUpperLimitsIsNull() {
            addCriterion("voltage_upper_limits is null");
            return (Criteria) this;
        }

        public Criteria andVoltageUpperLimitsIsNotNull() {
            addCriterion("voltage_upper_limits is not null");
            return (Criteria) this;
        }

        public Criteria andVoltageUpperLimitsEqualTo(Long value) {
            addCriterion("voltage_upper_limits =", value, "voltageUpperLimits");
            return (Criteria) this;
        }

        public Criteria andVoltageUpperLimitsNotEqualTo(Long value) {
            addCriterion("voltage_upper_limits <>", value, "voltageUpperLimits");
            return (Criteria) this;
        }

        public Criteria andVoltageUpperLimitsGreaterThan(Long value) {
            addCriterion("voltage_upper_limits >", value, "voltageUpperLimits");
            return (Criteria) this;
        }

        public Criteria andVoltageUpperLimitsGreaterThanOrEqualTo(Long value) {
            addCriterion("voltage_upper_limits >=", value, "voltageUpperLimits");
            return (Criteria) this;
        }

        public Criteria andVoltageUpperLimitsLessThan(Long value) {
            addCriterion("voltage_upper_limits <", value, "voltageUpperLimits");
            return (Criteria) this;
        }

        public Criteria andVoltageUpperLimitsLessThanOrEqualTo(Long value) {
            addCriterion("voltage_upper_limits <=", value, "voltageUpperLimits");
            return (Criteria) this;
        }

        public Criteria andVoltageUpperLimitsIn(List<Long> values) {
            addCriterion("voltage_upper_limits in", values, "voltageUpperLimits");
            return (Criteria) this;
        }

        public Criteria andVoltageUpperLimitsNotIn(List<Long> values) {
            addCriterion("voltage_upper_limits not in", values, "voltageUpperLimits");
            return (Criteria) this;
        }

        public Criteria andVoltageUpperLimitsBetween(Long value1, Long value2) {
            addCriterion("voltage_upper_limits between", value1, value2, "voltageUpperLimits");
            return (Criteria) this;
        }

        public Criteria andVoltageUpperLimitsNotBetween(Long value1, Long value2) {
            addCriterion("voltage_upper_limits not between", value1, value2, "voltageUpperLimits");
            return (Criteria) this;
        }

        public Criteria andVoltageLowerLimitsIsNull() {
            addCriterion("voltage_lower_limits is null");
            return (Criteria) this;
        }

        public Criteria andVoltageLowerLimitsIsNotNull() {
            addCriterion("voltage_lower_limits is not null");
            return (Criteria) this;
        }

        public Criteria andVoltageLowerLimitsEqualTo(Long value) {
            addCriterion("voltage_lower_limits =", value, "voltageLowerLimits");
            return (Criteria) this;
        }

        public Criteria andVoltageLowerLimitsNotEqualTo(Long value) {
            addCriterion("voltage_lower_limits <>", value, "voltageLowerLimits");
            return (Criteria) this;
        }

        public Criteria andVoltageLowerLimitsGreaterThan(Long value) {
            addCriterion("voltage_lower_limits >", value, "voltageLowerLimits");
            return (Criteria) this;
        }

        public Criteria andVoltageLowerLimitsGreaterThanOrEqualTo(Long value) {
            addCriterion("voltage_lower_limits >=", value, "voltageLowerLimits");
            return (Criteria) this;
        }

        public Criteria andVoltageLowerLimitsLessThan(Long value) {
            addCriterion("voltage_lower_limits <", value, "voltageLowerLimits");
            return (Criteria) this;
        }

        public Criteria andVoltageLowerLimitsLessThanOrEqualTo(Long value) {
            addCriterion("voltage_lower_limits <=", value, "voltageLowerLimits");
            return (Criteria) this;
        }

        public Criteria andVoltageLowerLimitsIn(List<Long> values) {
            addCriterion("voltage_lower_limits in", values, "voltageLowerLimits");
            return (Criteria) this;
        }

        public Criteria andVoltageLowerLimitsNotIn(List<Long> values) {
            addCriterion("voltage_lower_limits not in", values, "voltageLowerLimits");
            return (Criteria) this;
        }

        public Criteria andVoltageLowerLimitsBetween(Long value1, Long value2) {
            addCriterion("voltage_lower_limits between", value1, value2, "voltageLowerLimits");
            return (Criteria) this;
        }

        public Criteria andVoltageLowerLimitsNotBetween(Long value1, Long value2) {
            addCriterion("voltage_lower_limits not between", value1, value2, "voltageLowerLimits");
            return (Criteria) this;
        }

        public Criteria andCurrentIsNull() {
            addCriterion("current is null");
            return (Criteria) this;
        }

        public Criteria andCurrentIsNotNull() {
            addCriterion("current is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentEqualTo(Long value) {
            addCriterion("current =", value, "current");
            return (Criteria) this;
        }

        public Criteria andCurrentNotEqualTo(Long value) {
            addCriterion("current <>", value, "current");
            return (Criteria) this;
        }

        public Criteria andCurrentGreaterThan(Long value) {
            addCriterion("current >", value, "current");
            return (Criteria) this;
        }

        public Criteria andCurrentGreaterThanOrEqualTo(Long value) {
            addCriterion("current >=", value, "current");
            return (Criteria) this;
        }

        public Criteria andCurrentLessThan(Long value) {
            addCriterion("current <", value, "current");
            return (Criteria) this;
        }

        public Criteria andCurrentLessThanOrEqualTo(Long value) {
            addCriterion("current <=", value, "current");
            return (Criteria) this;
        }

        public Criteria andCurrentIn(List<Long> values) {
            addCriterion("current in", values, "current");
            return (Criteria) this;
        }

        public Criteria andCurrentNotIn(List<Long> values) {
            addCriterion("current not in", values, "current");
            return (Criteria) this;
        }

        public Criteria andCurrentBetween(Long value1, Long value2) {
            addCriterion("current between", value1, value2, "current");
            return (Criteria) this;
        }

        public Criteria andCurrentNotBetween(Long value1, Long value2) {
            addCriterion("current not between", value1, value2, "current");
            return (Criteria) this;
        }

        public Criteria andPowerIsNull() {
            addCriterion("power is null");
            return (Criteria) this;
        }

        public Criteria andPowerIsNotNull() {
            addCriterion("power is not null");
            return (Criteria) this;
        }

        public Criteria andPowerEqualTo(Float value) {
            addCriterion("power =", value, "power");
            return (Criteria) this;
        }

        public Criteria andPowerNotEqualTo(Float value) {
            addCriterion("power <>", value, "power");
            return (Criteria) this;
        }

        public Criteria andPowerGreaterThan(Float value) {
            addCriterion("power >", value, "power");
            return (Criteria) this;
        }

        public Criteria andPowerGreaterThanOrEqualTo(Float value) {
            addCriterion("power >=", value, "power");
            return (Criteria) this;
        }

        public Criteria andPowerLessThan(Float value) {
            addCriterion("power <", value, "power");
            return (Criteria) this;
        }

        public Criteria andPowerLessThanOrEqualTo(Float value) {
            addCriterion("power <=", value, "power");
            return (Criteria) this;
        }

        public Criteria andPowerIn(List<Float> values) {
            addCriterion("power in", values, "power");
            return (Criteria) this;
        }

        public Criteria andPowerNotIn(List<Float> values) {
            addCriterion("power not in", values, "power");
            return (Criteria) this;
        }

        public Criteria andPowerBetween(Float value1, Float value2) {
            addCriterion("power between", value1, value2, "power");
            return (Criteria) this;
        }

        public Criteria andPowerNotBetween(Float value1, Float value2) {
            addCriterion("power not between", value1, value2, "power");
            return (Criteria) this;
        }

        public Criteria andParkNoIsNull() {
            addCriterion("park_no is null");
            return (Criteria) this;
        }

        public Criteria andParkNoIsNotNull() {
            addCriterion("park_no is not null");
            return (Criteria) this;
        }

        public Criteria andParkNoEqualTo(String value) {
            addCriterion("park_no =", value, "parkNo");
            return (Criteria) this;
        }

        public Criteria andParkNoNotEqualTo(String value) {
            addCriterion("park_no <>", value, "parkNo");
            return (Criteria) this;
        }

        public Criteria andParkNoGreaterThan(String value) {
            addCriterion("park_no >", value, "parkNo");
            return (Criteria) this;
        }

        public Criteria andParkNoGreaterThanOrEqualTo(String value) {
            addCriterion("park_no >=", value, "parkNo");
            return (Criteria) this;
        }

        public Criteria andParkNoLessThan(String value) {
            addCriterion("park_no <", value, "parkNo");
            return (Criteria) this;
        }

        public Criteria andParkNoLessThanOrEqualTo(String value) {
            addCriterion("park_no <=", value, "parkNo");
            return (Criteria) this;
        }

        public Criteria andParkNoLike(String value) {
            addCriterion("park_no like", value, "parkNo");
            return (Criteria) this;
        }

        public Criteria andParkNoNotLike(String value) {
            addCriterion("park_no not like", value, "parkNo");
            return (Criteria) this;
        }

        public Criteria andParkNoIn(List<String> values) {
            addCriterion("park_no in", values, "parkNo");
            return (Criteria) this;
        }

        public Criteria andParkNoNotIn(List<String> values) {
            addCriterion("park_no not in", values, "parkNo");
            return (Criteria) this;
        }

        public Criteria andParkNoBetween(String value1, String value2) {
            addCriterion("park_no between", value1, value2, "parkNo");
            return (Criteria) this;
        }

        public Criteria andParkNoNotBetween(String value1, String value2) {
            addCriterion("park_no not between", value1, value2, "parkNo");
            return (Criteria) this;
        }

        public Criteria andNationalStandardIsNull() {
            addCriterion("national_standard is null");
            return (Criteria) this;
        }

        public Criteria andNationalStandardIsNotNull() {
            addCriterion("national_standard is not null");
            return (Criteria) this;
        }

        public Criteria andNationalStandardEqualTo(Long value) {
            addCriterion("national_standard =", value, "nationalStandard");
            return (Criteria) this;
        }

        public Criteria andNationalStandardNotEqualTo(Long value) {
            addCriterion("national_standard <>", value, "nationalStandard");
            return (Criteria) this;
        }

        public Criteria andNationalStandardGreaterThan(Long value) {
            addCriterion("national_standard >", value, "nationalStandard");
            return (Criteria) this;
        }

        public Criteria andNationalStandardGreaterThanOrEqualTo(Long value) {
            addCriterion("national_standard >=", value, "nationalStandard");
            return (Criteria) this;
        }

        public Criteria andNationalStandardLessThan(Long value) {
            addCriterion("national_standard <", value, "nationalStandard");
            return (Criteria) this;
        }

        public Criteria andNationalStandardLessThanOrEqualTo(Long value) {
            addCriterion("national_standard <=", value, "nationalStandard");
            return (Criteria) this;
        }

        public Criteria andNationalStandardIn(List<Long> values) {
            addCriterion("national_standard in", values, "nationalStandard");
            return (Criteria) this;
        }

        public Criteria andNationalStandardNotIn(List<Long> values) {
            addCriterion("national_standard not in", values, "nationalStandard");
            return (Criteria) this;
        }

        public Criteria andNationalStandardBetween(Long value1, Long value2) {
            addCriterion("national_standard between", value1, value2, "nationalStandard");
            return (Criteria) this;
        }

        public Criteria andNationalStandardNotBetween(Long value1, Long value2) {
            addCriterion("national_standard not between", value1, value2, "nationalStandard");
            return (Criteria) this;
        }

        public Criteria andManufacturerIsNull() {
            addCriterion("manufacturer is null");
            return (Criteria) this;
        }

        public Criteria andManufacturerIsNotNull() {
            addCriterion("manufacturer is not null");
            return (Criteria) this;
        }

        public Criteria andManufacturerEqualTo(String value) {
            addCriterion("manufacturer =", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerNotEqualTo(String value) {
            addCriterion("manufacturer <>", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerGreaterThan(String value) {
            addCriterion("manufacturer >", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerGreaterThanOrEqualTo(String value) {
            addCriterion("manufacturer >=", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerLessThan(String value) {
            addCriterion("manufacturer <", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerLessThanOrEqualTo(String value) {
            addCriterion("manufacturer <=", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerLike(String value) {
            addCriterion("manufacturer like", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerNotLike(String value) {
            addCriterion("manufacturer not like", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerIn(List<String> values) {
            addCriterion("manufacturer in", values, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerNotIn(List<String> values) {
            addCriterion("manufacturer not in", values, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerBetween(String value1, String value2) {
            addCriterion("manufacturer between", value1, value2, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerNotBetween(String value1, String value2) {
            addCriterion("manufacturer not between", value1, value2, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerNameIsNull() {
            addCriterion("manufacturer_name is null");
            return (Criteria) this;
        }

        public Criteria andManufacturerNameIsNotNull() {
            addCriterion("manufacturer_name is not null");
            return (Criteria) this;
        }

        public Criteria andManufacturerNameEqualTo(String value) {
            addCriterion("manufacturer_name =", value, "manufacturerName");
            return (Criteria) this;
        }

        public Criteria andManufacturerNameNotEqualTo(String value) {
            addCriterion("manufacturer_name <>", value, "manufacturerName");
            return (Criteria) this;
        }

        public Criteria andManufacturerNameGreaterThan(String value) {
            addCriterion("manufacturer_name >", value, "manufacturerName");
            return (Criteria) this;
        }

        public Criteria andManufacturerNameGreaterThanOrEqualTo(String value) {
            addCriterion("manufacturer_name >=", value, "manufacturerName");
            return (Criteria) this;
        }

        public Criteria andManufacturerNameLessThan(String value) {
            addCriterion("manufacturer_name <", value, "manufacturerName");
            return (Criteria) this;
        }

        public Criteria andManufacturerNameLessThanOrEqualTo(String value) {
            addCriterion("manufacturer_name <=", value, "manufacturerName");
            return (Criteria) this;
        }

        public Criteria andManufacturerNameLike(String value) {
            addCriterion("manufacturer_name like", value, "manufacturerName");
            return (Criteria) this;
        }

        public Criteria andManufacturerNameNotLike(String value) {
            addCriterion("manufacturer_name not like", value, "manufacturerName");
            return (Criteria) this;
        }

        public Criteria andManufacturerNameIn(List<String> values) {
            addCriterion("manufacturer_name in", values, "manufacturerName");
            return (Criteria) this;
        }

        public Criteria andManufacturerNameNotIn(List<String> values) {
            addCriterion("manufacturer_name not in", values, "manufacturerName");
            return (Criteria) this;
        }

        public Criteria andManufacturerNameBetween(String value1, String value2) {
            addCriterion("manufacturer_name between", value1, value2, "manufacturerName");
            return (Criteria) this;
        }

        public Criteria andManufacturerNameNotBetween(String value1, String value2) {
            addCriterion("manufacturer_name not between", value1, value2, "manufacturerName");
            return (Criteria) this;
        }

        public Criteria andManufacturerDttmIsNull() {
            addCriterion("manufacturer_dttm is null");
            return (Criteria) this;
        }

        public Criteria andManufacturerDttmIsNotNull() {
            addCriterion("manufacturer_dttm is not null");
            return (Criteria) this;
        }

        public Criteria andManufacturerDttmEqualTo(Date value) {
            addCriterion("manufacturer_dttm =", value, "manufacturerDttm");
            return (Criteria) this;
        }

        public Criteria andManufacturerDttmNotEqualTo(Date value) {
            addCriterion("manufacturer_dttm <>", value, "manufacturerDttm");
            return (Criteria) this;
        }

        public Criteria andManufacturerDttmGreaterThan(Date value) {
            addCriterion("manufacturer_dttm >", value, "manufacturerDttm");
            return (Criteria) this;
        }

        public Criteria andManufacturerDttmGreaterThanOrEqualTo(Date value) {
            addCriterion("manufacturer_dttm >=", value, "manufacturerDttm");
            return (Criteria) this;
        }

        public Criteria andManufacturerDttmLessThan(Date value) {
            addCriterion("manufacturer_dttm <", value, "manufacturerDttm");
            return (Criteria) this;
        }

        public Criteria andManufacturerDttmLessThanOrEqualTo(Date value) {
            addCriterion("manufacturer_dttm <=", value, "manufacturerDttm");
            return (Criteria) this;
        }

        public Criteria andManufacturerDttmIn(List<Date> values) {
            addCriterion("manufacturer_dttm in", values, "manufacturerDttm");
            return (Criteria) this;
        }

        public Criteria andManufacturerDttmNotIn(List<Date> values) {
            addCriterion("manufacturer_dttm not in", values, "manufacturerDttm");
            return (Criteria) this;
        }

        public Criteria andManufacturerDttmBetween(Date value1, Date value2) {
            addCriterion("manufacturer_dttm between", value1, value2, "manufacturerDttm");
            return (Criteria) this;
        }

        public Criteria andManufacturerDttmNotBetween(Date value1, Date value2) {
            addCriterion("manufacturer_dttm not between", value1, value2, "manufacturerDttm");
            return (Criteria) this;
        }

        public Criteria andDeliveryDttmIsNull() {
            addCriterion("delivery_dttm is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryDttmIsNotNull() {
            addCriterion("delivery_dttm is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryDttmEqualTo(Date value) {
            addCriterion("delivery_dttm =", value, "deliveryDttm");
            return (Criteria) this;
        }

        public Criteria andDeliveryDttmNotEqualTo(Date value) {
            addCriterion("delivery_dttm <>", value, "deliveryDttm");
            return (Criteria) this;
        }

        public Criteria andDeliveryDttmGreaterThan(Date value) {
            addCriterion("delivery_dttm >", value, "deliveryDttm");
            return (Criteria) this;
        }

        public Criteria andDeliveryDttmGreaterThanOrEqualTo(Date value) {
            addCriterion("delivery_dttm >=", value, "deliveryDttm");
            return (Criteria) this;
        }

        public Criteria andDeliveryDttmLessThan(Date value) {
            addCriterion("delivery_dttm <", value, "deliveryDttm");
            return (Criteria) this;
        }

        public Criteria andDeliveryDttmLessThanOrEqualTo(Date value) {
            addCriterion("delivery_dttm <=", value, "deliveryDttm");
            return (Criteria) this;
        }

        public Criteria andDeliveryDttmIn(List<Date> values) {
            addCriterion("delivery_dttm in", values, "deliveryDttm");
            return (Criteria) this;
        }

        public Criteria andDeliveryDttmNotIn(List<Date> values) {
            addCriterion("delivery_dttm not in", values, "deliveryDttm");
            return (Criteria) this;
        }

        public Criteria andDeliveryDttmBetween(Date value1, Date value2) {
            addCriterion("delivery_dttm between", value1, value2, "deliveryDttm");
            return (Criteria) this;
        }

        public Criteria andDeliveryDttmNotBetween(Date value1, Date value2) {
            addCriterion("delivery_dttm not between", value1, value2, "deliveryDttm");
            return (Criteria) this;
        }

        public Criteria andDeviceIdIsNull() {
            addCriterion("device_id is null");
            return (Criteria) this;
        }

        public Criteria andDeviceIdIsNotNull() {
            addCriterion("device_id is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceIdEqualTo(String value) {
            addCriterion("device_id =", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdNotEqualTo(String value) {
            addCriterion("device_id <>", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdGreaterThan(String value) {
            addCriterion("device_id >", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdGreaterThanOrEqualTo(String value) {
            addCriterion("device_id >=", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdLessThan(String value) {
            addCriterion("device_id <", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdLessThanOrEqualTo(String value) {
            addCriterion("device_id <=", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdLike(String value) {
            addCriterion("device_id like", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdNotLike(String value) {
            addCriterion("device_id not like", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdIn(List<String> values) {
            addCriterion("device_id in", values, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdNotIn(List<String> values) {
            addCriterion("device_id not in", values, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdBetween(String value1, String value2) {
            addCriterion("device_id between", value1, value2, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdNotBetween(String value1, String value2) {
            addCriterion("device_id not between", value1, value2, "deviceId");
            return (Criteria) this;
        }

        public Criteria andChargingGunNoIsNull() {
            addCriterion("charging_gun_no is null");
            return (Criteria) this;
        }

        public Criteria andChargingGunNoIsNotNull() {
            addCriterion("charging_gun_no is not null");
            return (Criteria) this;
        }

        public Criteria andChargingGunNoEqualTo(Integer value) {
            addCriterion("charging_gun_no =", value, "chargingGunNo");
            return (Criteria) this;
        }

        public Criteria andChargingGunNoNotEqualTo(Integer value) {
            addCriterion("charging_gun_no <>", value, "chargingGunNo");
            return (Criteria) this;
        }

        public Criteria andChargingGunNoGreaterThan(Integer value) {
            addCriterion("charging_gun_no >", value, "chargingGunNo");
            return (Criteria) this;
        }

        public Criteria andChargingGunNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("charging_gun_no >=", value, "chargingGunNo");
            return (Criteria) this;
        }

        public Criteria andChargingGunNoLessThan(Integer value) {
            addCriterion("charging_gun_no <", value, "chargingGunNo");
            return (Criteria) this;
        }

        public Criteria andChargingGunNoLessThanOrEqualTo(Integer value) {
            addCriterion("charging_gun_no <=", value, "chargingGunNo");
            return (Criteria) this;
        }

        public Criteria andChargingGunNoIn(List<Integer> values) {
            addCriterion("charging_gun_no in", values, "chargingGunNo");
            return (Criteria) this;
        }

        public Criteria andChargingGunNoNotIn(List<Integer> values) {
            addCriterion("charging_gun_no not in", values, "chargingGunNo");
            return (Criteria) this;
        }

        public Criteria andChargingGunNoBetween(Integer value1, Integer value2) {
            addCriterion("charging_gun_no between", value1, value2, "chargingGunNo");
            return (Criteria) this;
        }

        public Criteria andChargingGunNoNotBetween(Integer value1, Integer value2) {
            addCriterion("charging_gun_no not between", value1, value2, "chargingGunNo");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNull() {
            addCriterion("create_user is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNotNull() {
            addCriterion("create_user is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserEqualTo(String value) {
            addCriterion("create_user =", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotEqualTo(String value) {
            addCriterion("create_user <>", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThan(String value) {
            addCriterion("create_user >", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThanOrEqualTo(String value) {
            addCriterion("create_user >=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThan(String value) {
            addCriterion("create_user <", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThanOrEqualTo(String value) {
            addCriterion("create_user <=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLike(String value) {
            addCriterion("create_user like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotLike(String value) {
            addCriterion("create_user not like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserIn(List<String> values) {
            addCriterion("create_user in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotIn(List<String> values) {
            addCriterion("create_user not in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserBetween(String value1, String value2) {
            addCriterion("create_user between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotBetween(String value1, String value2) {
            addCriterion("create_user not between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateDttmIsNull() {
            addCriterion("create_dttm is null");
            return (Criteria) this;
        }

        public Criteria andCreateDttmIsNotNull() {
            addCriterion("create_dttm is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDttmEqualTo(Date value) {
            addCriterion("create_dttm =", value, "createDttm");
            return (Criteria) this;
        }

        public Criteria andCreateDttmNotEqualTo(Date value) {
            addCriterion("create_dttm <>", value, "createDttm");
            return (Criteria) this;
        }

        public Criteria andCreateDttmGreaterThan(Date value) {
            addCriterion("create_dttm >", value, "createDttm");
            return (Criteria) this;
        }

        public Criteria andCreateDttmGreaterThanOrEqualTo(Date value) {
            addCriterion("create_dttm >=", value, "createDttm");
            return (Criteria) this;
        }

        public Criteria andCreateDttmLessThan(Date value) {
            addCriterion("create_dttm <", value, "createDttm");
            return (Criteria) this;
        }

        public Criteria andCreateDttmLessThanOrEqualTo(Date value) {
            addCriterion("create_dttm <=", value, "createDttm");
            return (Criteria) this;
        }

        public Criteria andCreateDttmIn(List<Date> values) {
            addCriterion("create_dttm in", values, "createDttm");
            return (Criteria) this;
        }

        public Criteria andCreateDttmNotIn(List<Date> values) {
            addCriterion("create_dttm not in", values, "createDttm");
            return (Criteria) this;
        }

        public Criteria andCreateDttmBetween(Date value1, Date value2) {
            addCriterion("create_dttm between", value1, value2, "createDttm");
            return (Criteria) this;
        }

        public Criteria andCreateDttmNotBetween(Date value1, Date value2) {
            addCriterion("create_dttm not between", value1, value2, "createDttm");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIsNull() {
            addCriterion("update_user is null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIsNotNull() {
            addCriterion("update_user is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserEqualTo(String value) {
            addCriterion("update_user =", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotEqualTo(String value) {
            addCriterion("update_user <>", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThan(String value) {
            addCriterion("update_user >", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThanOrEqualTo(String value) {
            addCriterion("update_user >=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThan(String value) {
            addCriterion("update_user <", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThanOrEqualTo(String value) {
            addCriterion("update_user <=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLike(String value) {
            addCriterion("update_user like", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotLike(String value) {
            addCriterion("update_user not like", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIn(List<String> values) {
            addCriterion("update_user in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotIn(List<String> values) {
            addCriterion("update_user not in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserBetween(String value1, String value2) {
            addCriterion("update_user between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotBetween(String value1, String value2) {
            addCriterion("update_user not between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateDttmIsNull() {
            addCriterion("update_dttm is null");
            return (Criteria) this;
        }

        public Criteria andUpdateDttmIsNotNull() {
            addCriterion("update_dttm is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateDttmEqualTo(Date value) {
            addCriterion("update_dttm =", value, "updateDttm");
            return (Criteria) this;
        }

        public Criteria andUpdateDttmNotEqualTo(Date value) {
            addCriterion("update_dttm <>", value, "updateDttm");
            return (Criteria) this;
        }

        public Criteria andUpdateDttmGreaterThan(Date value) {
            addCriterion("update_dttm >", value, "updateDttm");
            return (Criteria) this;
        }

        public Criteria andUpdateDttmGreaterThanOrEqualTo(Date value) {
            addCriterion("update_dttm >=", value, "updateDttm");
            return (Criteria) this;
        }

        public Criteria andUpdateDttmLessThan(Date value) {
            addCriterion("update_dttm <", value, "updateDttm");
            return (Criteria) this;
        }

        public Criteria andUpdateDttmLessThanOrEqualTo(Date value) {
            addCriterion("update_dttm <=", value, "updateDttm");
            return (Criteria) this;
        }

        public Criteria andUpdateDttmIn(List<Date> values) {
            addCriterion("update_dttm in", values, "updateDttm");
            return (Criteria) this;
        }

        public Criteria andUpdateDttmNotIn(List<Date> values) {
            addCriterion("update_dttm not in", values, "updateDttm");
            return (Criteria) this;
        }

        public Criteria andUpdateDttmBetween(Date value1, Date value2) {
            addCriterion("update_dttm between", value1, value2, "updateDttm");
            return (Criteria) this;
        }

        public Criteria andUpdateDttmNotBetween(Date value1, Date value2) {
            addCriterion("update_dttm not between", value1, value2, "updateDttm");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}