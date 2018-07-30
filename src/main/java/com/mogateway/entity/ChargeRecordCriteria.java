package com.mogateway.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ChargeRecordCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ChargeRecordCriteria() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andChargingRecordNoIsNull() {
            addCriterion("charging_record_no is null");
            return (Criteria) this;
        }

        public Criteria andChargingRecordNoIsNotNull() {
            addCriterion("charging_record_no is not null");
            return (Criteria) this;
        }

        public Criteria andChargingRecordNoEqualTo(String value) {
            addCriterion("charging_record_no =", value, "chargingRecordNo");
            return (Criteria) this;
        }

        public Criteria andChargingRecordNoNotEqualTo(String value) {
            addCriterion("charging_record_no <>", value, "chargingRecordNo");
            return (Criteria) this;
        }

        public Criteria andChargingRecordNoGreaterThan(String value) {
            addCriterion("charging_record_no >", value, "chargingRecordNo");
            return (Criteria) this;
        }

        public Criteria andChargingRecordNoGreaterThanOrEqualTo(String value) {
            addCriterion("charging_record_no >=", value, "chargingRecordNo");
            return (Criteria) this;
        }

        public Criteria andChargingRecordNoLessThan(String value) {
            addCriterion("charging_record_no <", value, "chargingRecordNo");
            return (Criteria) this;
        }

        public Criteria andChargingRecordNoLessThanOrEqualTo(String value) {
            addCriterion("charging_record_no <=", value, "chargingRecordNo");
            return (Criteria) this;
        }

        public Criteria andChargingRecordNoLike(String value) {
            addCriterion("charging_record_no like", value, "chargingRecordNo");
            return (Criteria) this;
        }

        public Criteria andChargingRecordNoNotLike(String value) {
            addCriterion("charging_record_no not like", value, "chargingRecordNo");
            return (Criteria) this;
        }

        public Criteria andChargingRecordNoIn(List<String> values) {
            addCriterion("charging_record_no in", values, "chargingRecordNo");
            return (Criteria) this;
        }

        public Criteria andChargingRecordNoNotIn(List<String> values) {
            addCriterion("charging_record_no not in", values, "chargingRecordNo");
            return (Criteria) this;
        }

        public Criteria andChargingRecordNoBetween(String value1, String value2) {
            addCriterion("charging_record_no between", value1, value2, "chargingRecordNo");
            return (Criteria) this;
        }

        public Criteria andChargingRecordNoNotBetween(String value1, String value2) {
            addCriterion("charging_record_no not between", value1, value2, "chargingRecordNo");
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

        public Criteria andCarNumberIsNull() {
            addCriterion("car_number is null");
            return (Criteria) this;
        }

        public Criteria andCarNumberIsNotNull() {
            addCriterion("car_number is not null");
            return (Criteria) this;
        }

        public Criteria andCarNumberEqualTo(String value) {
            addCriterion("car_number =", value, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberNotEqualTo(String value) {
            addCriterion("car_number <>", value, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberGreaterThan(String value) {
            addCriterion("car_number >", value, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberGreaterThanOrEqualTo(String value) {
            addCriterion("car_number >=", value, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberLessThan(String value) {
            addCriterion("car_number <", value, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberLessThanOrEqualTo(String value) {
            addCriterion("car_number <=", value, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberLike(String value) {
            addCriterion("car_number like", value, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberNotLike(String value) {
            addCriterion("car_number not like", value, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberIn(List<String> values) {
            addCriterion("car_number in", values, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberNotIn(List<String> values) {
            addCriterion("car_number not in", values, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberBetween(String value1, String value2) {
            addCriterion("car_number between", value1, value2, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberNotBetween(String value1, String value2) {
            addCriterion("car_number not between", value1, value2, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCardNumberIsNull() {
            addCriterion("card_number is null");
            return (Criteria) this;
        }

        public Criteria andCardNumberIsNotNull() {
            addCriterion("card_number is not null");
            return (Criteria) this;
        }

        public Criteria andCardNumberEqualTo(String value) {
            addCriterion("card_number =", value, "cardNumber");
            return (Criteria) this;
        }

        public Criteria andCardNumberNotEqualTo(String value) {
            addCriterion("card_number <>", value, "cardNumber");
            return (Criteria) this;
        }

        public Criteria andCardNumberGreaterThan(String value) {
            addCriterion("card_number >", value, "cardNumber");
            return (Criteria) this;
        }

        public Criteria andCardNumberGreaterThanOrEqualTo(String value) {
            addCriterion("card_number >=", value, "cardNumber");
            return (Criteria) this;
        }

        public Criteria andCardNumberLessThan(String value) {
            addCriterion("card_number <", value, "cardNumber");
            return (Criteria) this;
        }

        public Criteria andCardNumberLessThanOrEqualTo(String value) {
            addCriterion("card_number <=", value, "cardNumber");
            return (Criteria) this;
        }

        public Criteria andCardNumberLike(String value) {
            addCriterion("card_number like", value, "cardNumber");
            return (Criteria) this;
        }

        public Criteria andCardNumberNotLike(String value) {
            addCriterion("card_number not like", value, "cardNumber");
            return (Criteria) this;
        }

        public Criteria andCardNumberIn(List<String> values) {
            addCriterion("card_number in", values, "cardNumber");
            return (Criteria) this;
        }

        public Criteria andCardNumberNotIn(List<String> values) {
            addCriterion("card_number not in", values, "cardNumber");
            return (Criteria) this;
        }

        public Criteria andCardNumberBetween(String value1, String value2) {
            addCriterion("card_number between", value1, value2, "cardNumber");
            return (Criteria) this;
        }

        public Criteria andCardNumberNotBetween(String value1, String value2) {
            addCriterion("card_number not between", value1, value2, "cardNumber");
            return (Criteria) this;
        }

        public Criteria andStartChargingDttmIsNull() {
            addCriterion("start_charging_dttm is null");
            return (Criteria) this;
        }

        public Criteria andStartChargingDttmIsNotNull() {
            addCriterion("start_charging_dttm is not null");
            return (Criteria) this;
        }

        public Criteria andStartChargingDttmEqualTo(Date value) {
            addCriterion("start_charging_dttm =", value, "startChargingDttm");
            return (Criteria) this;
        }

        public Criteria andStartChargingDttmNotEqualTo(Date value) {
            addCriterion("start_charging_dttm <>", value, "startChargingDttm");
            return (Criteria) this;
        }

        public Criteria andStartChargingDttmGreaterThan(Date value) {
            addCriterion("start_charging_dttm >", value, "startChargingDttm");
            return (Criteria) this;
        }

        public Criteria andStartChargingDttmGreaterThanOrEqualTo(Date value) {
            addCriterion("start_charging_dttm >=", value, "startChargingDttm");
            return (Criteria) this;
        }

        public Criteria andStartChargingDttmLessThan(Date value) {
            addCriterion("start_charging_dttm <", value, "startChargingDttm");
            return (Criteria) this;
        }

        public Criteria andStartChargingDttmLessThanOrEqualTo(Date value) {
            addCriterion("start_charging_dttm <=", value, "startChargingDttm");
            return (Criteria) this;
        }

        public Criteria andStartChargingDttmIn(List<Date> values) {
            addCriterion("start_charging_dttm in", values, "startChargingDttm");
            return (Criteria) this;
        }

        public Criteria andStartChargingDttmNotIn(List<Date> values) {
            addCriterion("start_charging_dttm not in", values, "startChargingDttm");
            return (Criteria) this;
        }

        public Criteria andStartChargingDttmBetween(Date value1, Date value2) {
            addCriterion("start_charging_dttm between", value1, value2, "startChargingDttm");
            return (Criteria) this;
        }

        public Criteria andStartChargingDttmNotBetween(Date value1, Date value2) {
            addCriterion("start_charging_dttm not between", value1, value2, "startChargingDttm");
            return (Criteria) this;
        }

        public Criteria andEndChargingDttmIsNull() {
            addCriterion("end_charging_dttm is null");
            return (Criteria) this;
        }

        public Criteria andEndChargingDttmIsNotNull() {
            addCriterion("end_charging_dttm is not null");
            return (Criteria) this;
        }

        public Criteria andEndChargingDttmEqualTo(Date value) {
            addCriterion("end_charging_dttm =", value, "endChargingDttm");
            return (Criteria) this;
        }

        public Criteria andEndChargingDttmNotEqualTo(Date value) {
            addCriterion("end_charging_dttm <>", value, "endChargingDttm");
            return (Criteria) this;
        }

        public Criteria andEndChargingDttmGreaterThan(Date value) {
            addCriterion("end_charging_dttm >", value, "endChargingDttm");
            return (Criteria) this;
        }

        public Criteria andEndChargingDttmGreaterThanOrEqualTo(Date value) {
            addCriterion("end_charging_dttm >=", value, "endChargingDttm");
            return (Criteria) this;
        }

        public Criteria andEndChargingDttmLessThan(Date value) {
            addCriterion("end_charging_dttm <", value, "endChargingDttm");
            return (Criteria) this;
        }

        public Criteria andEndChargingDttmLessThanOrEqualTo(Date value) {
            addCriterion("end_charging_dttm <=", value, "endChargingDttm");
            return (Criteria) this;
        }

        public Criteria andEndChargingDttmIn(List<Date> values) {
            addCriterion("end_charging_dttm in", values, "endChargingDttm");
            return (Criteria) this;
        }

        public Criteria andEndChargingDttmNotIn(List<Date> values) {
            addCriterion("end_charging_dttm not in", values, "endChargingDttm");
            return (Criteria) this;
        }

        public Criteria andEndChargingDttmBetween(Date value1, Date value2) {
            addCriterion("end_charging_dttm between", value1, value2, "endChargingDttm");
            return (Criteria) this;
        }

        public Criteria andEndChargingDttmNotBetween(Date value1, Date value2) {
            addCriterion("end_charging_dttm not between", value1, value2, "endChargingDttm");
            return (Criteria) this;
        }

        public Criteria andTotalChargingDttmIsNull() {
            addCriterion("total_charging_dttm is null");
            return (Criteria) this;
        }

        public Criteria andTotalChargingDttmIsNotNull() {
            addCriterion("total_charging_dttm is not null");
            return (Criteria) this;
        }

        public Criteria andTotalChargingDttmEqualTo(Integer value) {
            addCriterion("total_charging_dttm =", value, "totalChargingDttm");
            return (Criteria) this;
        }

        public Criteria andTotalChargingDttmNotEqualTo(Integer value) {
            addCriterion("total_charging_dttm <>", value, "totalChargingDttm");
            return (Criteria) this;
        }

        public Criteria andTotalChargingDttmGreaterThan(Integer value) {
            addCriterion("total_charging_dttm >", value, "totalChargingDttm");
            return (Criteria) this;
        }

        public Criteria andTotalChargingDttmGreaterThanOrEqualTo(Integer value) {
            addCriterion("total_charging_dttm >=", value, "totalChargingDttm");
            return (Criteria) this;
        }

        public Criteria andTotalChargingDttmLessThan(Integer value) {
            addCriterion("total_charging_dttm <", value, "totalChargingDttm");
            return (Criteria) this;
        }

        public Criteria andTotalChargingDttmLessThanOrEqualTo(Integer value) {
            addCriterion("total_charging_dttm <=", value, "totalChargingDttm");
            return (Criteria) this;
        }

        public Criteria andTotalChargingDttmIn(List<Integer> values) {
            addCriterion("total_charging_dttm in", values, "totalChargingDttm");
            return (Criteria) this;
        }

        public Criteria andTotalChargingDttmNotIn(List<Integer> values) {
            addCriterion("total_charging_dttm not in", values, "totalChargingDttm");
            return (Criteria) this;
        }

        public Criteria andTotalChargingDttmBetween(Integer value1, Integer value2) {
            addCriterion("total_charging_dttm between", value1, value2, "totalChargingDttm");
            return (Criteria) this;
        }

        public Criteria andTotalChargingDttmNotBetween(Integer value1, Integer value2) {
            addCriterion("total_charging_dttm not between", value1, value2, "totalChargingDttm");
            return (Criteria) this;
        }

        public Criteria andStartAmmeterNoIsNull() {
            addCriterion("start_ammeter_no is null");
            return (Criteria) this;
        }

        public Criteria andStartAmmeterNoIsNotNull() {
            addCriterion("start_ammeter_no is not null");
            return (Criteria) this;
        }

        public Criteria andStartAmmeterNoEqualTo(Integer value) {
            addCriterion("start_ammeter_no =", value, "startAmmeterNo");
            return (Criteria) this;
        }

        public Criteria andStartAmmeterNoNotEqualTo(Integer value) {
            addCriterion("start_ammeter_no <>", value, "startAmmeterNo");
            return (Criteria) this;
        }

        public Criteria andStartAmmeterNoGreaterThan(Integer value) {
            addCriterion("start_ammeter_no >", value, "startAmmeterNo");
            return (Criteria) this;
        }

        public Criteria andStartAmmeterNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("start_ammeter_no >=", value, "startAmmeterNo");
            return (Criteria) this;
        }

        public Criteria andStartAmmeterNoLessThan(Integer value) {
            addCriterion("start_ammeter_no <", value, "startAmmeterNo");
            return (Criteria) this;
        }

        public Criteria andStartAmmeterNoLessThanOrEqualTo(Integer value) {
            addCriterion("start_ammeter_no <=", value, "startAmmeterNo");
            return (Criteria) this;
        }

        public Criteria andStartAmmeterNoIn(List<Integer> values) {
            addCriterion("start_ammeter_no in", values, "startAmmeterNo");
            return (Criteria) this;
        }

        public Criteria andStartAmmeterNoNotIn(List<Integer> values) {
            addCriterion("start_ammeter_no not in", values, "startAmmeterNo");
            return (Criteria) this;
        }

        public Criteria andStartAmmeterNoBetween(Integer value1, Integer value2) {
            addCriterion("start_ammeter_no between", value1, value2, "startAmmeterNo");
            return (Criteria) this;
        }

        public Criteria andStartAmmeterNoNotBetween(Integer value1, Integer value2) {
            addCriterion("start_ammeter_no not between", value1, value2, "startAmmeterNo");
            return (Criteria) this;
        }

        public Criteria andEntAmmeterNoIsNull() {
            addCriterion("ent_ammeter_no is null");
            return (Criteria) this;
        }

        public Criteria andEntAmmeterNoIsNotNull() {
            addCriterion("ent_ammeter_no is not null");
            return (Criteria) this;
        }

        public Criteria andEntAmmeterNoEqualTo(Integer value) {
            addCriterion("ent_ammeter_no =", value, "entAmmeterNo");
            return (Criteria) this;
        }

        public Criteria andEntAmmeterNoNotEqualTo(Integer value) {
            addCriterion("ent_ammeter_no <>", value, "entAmmeterNo");
            return (Criteria) this;
        }

        public Criteria andEntAmmeterNoGreaterThan(Integer value) {
            addCriterion("ent_ammeter_no >", value, "entAmmeterNo");
            return (Criteria) this;
        }

        public Criteria andEntAmmeterNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("ent_ammeter_no >=", value, "entAmmeterNo");
            return (Criteria) this;
        }

        public Criteria andEntAmmeterNoLessThan(Integer value) {
            addCriterion("ent_ammeter_no <", value, "entAmmeterNo");
            return (Criteria) this;
        }

        public Criteria andEntAmmeterNoLessThanOrEqualTo(Integer value) {
            addCriterion("ent_ammeter_no <=", value, "entAmmeterNo");
            return (Criteria) this;
        }

        public Criteria andEntAmmeterNoIn(List<Integer> values) {
            addCriterion("ent_ammeter_no in", values, "entAmmeterNo");
            return (Criteria) this;
        }

        public Criteria andEntAmmeterNoNotIn(List<Integer> values) {
            addCriterion("ent_ammeter_no not in", values, "entAmmeterNo");
            return (Criteria) this;
        }

        public Criteria andEntAmmeterNoBetween(Integer value1, Integer value2) {
            addCriterion("ent_ammeter_no between", value1, value2, "entAmmeterNo");
            return (Criteria) this;
        }

        public Criteria andEntAmmeterNoNotBetween(Integer value1, Integer value2) {
            addCriterion("ent_ammeter_no not between", value1, value2, "entAmmeterNo");
            return (Criteria) this;
        }

        public Criteria andTotalChargingKwhIsNull() {
            addCriterion("total_charging_kwh is null");
            return (Criteria) this;
        }

        public Criteria andTotalChargingKwhIsNotNull() {
            addCriterion("total_charging_kwh is not null");
            return (Criteria) this;
        }

        public Criteria andTotalChargingKwhEqualTo(Integer value) {
            addCriterion("total_charging_kwh =", value, "totalChargingKwh");
            return (Criteria) this;
        }

        public Criteria andTotalChargingKwhNotEqualTo(Integer value) {
            addCriterion("total_charging_kwh <>", value, "totalChargingKwh");
            return (Criteria) this;
        }

        public Criteria andTotalChargingKwhGreaterThan(Integer value) {
            addCriterion("total_charging_kwh >", value, "totalChargingKwh");
            return (Criteria) this;
        }

        public Criteria andTotalChargingKwhGreaterThanOrEqualTo(Integer value) {
            addCriterion("total_charging_kwh >=", value, "totalChargingKwh");
            return (Criteria) this;
        }

        public Criteria andTotalChargingKwhLessThan(Integer value) {
            addCriterion("total_charging_kwh <", value, "totalChargingKwh");
            return (Criteria) this;
        }

        public Criteria andTotalChargingKwhLessThanOrEqualTo(Integer value) {
            addCriterion("total_charging_kwh <=", value, "totalChargingKwh");
            return (Criteria) this;
        }

        public Criteria andTotalChargingKwhIn(List<Integer> values) {
            addCriterion("total_charging_kwh in", values, "totalChargingKwh");
            return (Criteria) this;
        }

        public Criteria andTotalChargingKwhNotIn(List<Integer> values) {
            addCriterion("total_charging_kwh not in", values, "totalChargingKwh");
            return (Criteria) this;
        }

        public Criteria andTotalChargingKwhBetween(Integer value1, Integer value2) {
            addCriterion("total_charging_kwh between", value1, value2, "totalChargingKwh");
            return (Criteria) this;
        }

        public Criteria andTotalChargingKwhNotBetween(Integer value1, Integer value2) {
            addCriterion("total_charging_kwh not between", value1, value2, "totalChargingKwh");
            return (Criteria) this;
        }

        public Criteria andStartSocIsNull() {
            addCriterion("start_soc is null");
            return (Criteria) this;
        }

        public Criteria andStartSocIsNotNull() {
            addCriterion("start_soc is not null");
            return (Criteria) this;
        }

        public Criteria andStartSocEqualTo(Integer value) {
            addCriterion("start_soc =", value, "startSoc");
            return (Criteria) this;
        }

        public Criteria andStartSocNotEqualTo(Integer value) {
            addCriterion("start_soc <>", value, "startSoc");
            return (Criteria) this;
        }

        public Criteria andStartSocGreaterThan(Integer value) {
            addCriterion("start_soc >", value, "startSoc");
            return (Criteria) this;
        }

        public Criteria andStartSocGreaterThanOrEqualTo(Integer value) {
            addCriterion("start_soc >=", value, "startSoc");
            return (Criteria) this;
        }

        public Criteria andStartSocLessThan(Integer value) {
            addCriterion("start_soc <", value, "startSoc");
            return (Criteria) this;
        }

        public Criteria andStartSocLessThanOrEqualTo(Integer value) {
            addCriterion("start_soc <=", value, "startSoc");
            return (Criteria) this;
        }

        public Criteria andStartSocIn(List<Integer> values) {
            addCriterion("start_soc in", values, "startSoc");
            return (Criteria) this;
        }

        public Criteria andStartSocNotIn(List<Integer> values) {
            addCriterion("start_soc not in", values, "startSoc");
            return (Criteria) this;
        }

        public Criteria andStartSocBetween(Integer value1, Integer value2) {
            addCriterion("start_soc between", value1, value2, "startSoc");
            return (Criteria) this;
        }

        public Criteria andStartSocNotBetween(Integer value1, Integer value2) {
            addCriterion("start_soc not between", value1, value2, "startSoc");
            return (Criteria) this;
        }

        public Criteria andEndSocIsNull() {
            addCriterion("end_soc is null");
            return (Criteria) this;
        }

        public Criteria andEndSocIsNotNull() {
            addCriterion("end_soc is not null");
            return (Criteria) this;
        }

        public Criteria andEndSocEqualTo(Integer value) {
            addCriterion("end_soc =", value, "endSoc");
            return (Criteria) this;
        }

        public Criteria andEndSocNotEqualTo(Integer value) {
            addCriterion("end_soc <>", value, "endSoc");
            return (Criteria) this;
        }

        public Criteria andEndSocGreaterThan(Integer value) {
            addCriterion("end_soc >", value, "endSoc");
            return (Criteria) this;
        }

        public Criteria andEndSocGreaterThanOrEqualTo(Integer value) {
            addCriterion("end_soc >=", value, "endSoc");
            return (Criteria) this;
        }

        public Criteria andEndSocLessThan(Integer value) {
            addCriterion("end_soc <", value, "endSoc");
            return (Criteria) this;
        }

        public Criteria andEndSocLessThanOrEqualTo(Integer value) {
            addCriterion("end_soc <=", value, "endSoc");
            return (Criteria) this;
        }

        public Criteria andEndSocIn(List<Integer> values) {
            addCriterion("end_soc in", values, "endSoc");
            return (Criteria) this;
        }

        public Criteria andEndSocNotIn(List<Integer> values) {
            addCriterion("end_soc not in", values, "endSoc");
            return (Criteria) this;
        }

        public Criteria andEndSocBetween(Integer value1, Integer value2) {
            addCriterion("end_soc between", value1, value2, "endSoc");
            return (Criteria) this;
        }

        public Criteria andEndSocNotBetween(Integer value1, Integer value2) {
            addCriterion("end_soc not between", value1, value2, "endSoc");
            return (Criteria) this;
        }

        public Criteria andTotalSocIsNull() {
            addCriterion("total_soc is null");
            return (Criteria) this;
        }

        public Criteria andTotalSocIsNotNull() {
            addCriterion("total_soc is not null");
            return (Criteria) this;
        }

        public Criteria andTotalSocEqualTo(Integer value) {
            addCriterion("total_soc =", value, "totalSoc");
            return (Criteria) this;
        }

        public Criteria andTotalSocNotEqualTo(Integer value) {
            addCriterion("total_soc <>", value, "totalSoc");
            return (Criteria) this;
        }

        public Criteria andTotalSocGreaterThan(Integer value) {
            addCriterion("total_soc >", value, "totalSoc");
            return (Criteria) this;
        }

        public Criteria andTotalSocGreaterThanOrEqualTo(Integer value) {
            addCriterion("total_soc >=", value, "totalSoc");
            return (Criteria) this;
        }

        public Criteria andTotalSocLessThan(Integer value) {
            addCriterion("total_soc <", value, "totalSoc");
            return (Criteria) this;
        }

        public Criteria andTotalSocLessThanOrEqualTo(Integer value) {
            addCriterion("total_soc <=", value, "totalSoc");
            return (Criteria) this;
        }

        public Criteria andTotalSocIn(List<Integer> values) {
            addCriterion("total_soc in", values, "totalSoc");
            return (Criteria) this;
        }

        public Criteria andTotalSocNotIn(List<Integer> values) {
            addCriterion("total_soc not in", values, "totalSoc");
            return (Criteria) this;
        }

        public Criteria andTotalSocBetween(Integer value1, Integer value2) {
            addCriterion("total_soc between", value1, value2, "totalSoc");
            return (Criteria) this;
        }

        public Criteria andTotalSocNotBetween(Integer value1, Integer value2) {
            addCriterion("total_soc not between", value1, value2, "totalSoc");
            return (Criteria) this;
        }

        public Criteria andEndReasonIsNull() {
            addCriterion("end_reason is null");
            return (Criteria) this;
        }

        public Criteria andEndReasonIsNotNull() {
            addCriterion("end_reason is not null");
            return (Criteria) this;
        }

        public Criteria andEndReasonEqualTo(Integer value) {
            addCriterion("end_reason =", value, "endReason");
            return (Criteria) this;
        }

        public Criteria andEndReasonNotEqualTo(Integer value) {
            addCriterion("end_reason <>", value, "endReason");
            return (Criteria) this;
        }

        public Criteria andEndReasonGreaterThan(Integer value) {
            addCriterion("end_reason >", value, "endReason");
            return (Criteria) this;
        }

        public Criteria andEndReasonGreaterThanOrEqualTo(Integer value) {
            addCriterion("end_reason >=", value, "endReason");
            return (Criteria) this;
        }

        public Criteria andEndReasonLessThan(Integer value) {
            addCriterion("end_reason <", value, "endReason");
            return (Criteria) this;
        }

        public Criteria andEndReasonLessThanOrEqualTo(Integer value) {
            addCriterion("end_reason <=", value, "endReason");
            return (Criteria) this;
        }

        public Criteria andEndReasonIn(List<Integer> values) {
            addCriterion("end_reason in", values, "endReason");
            return (Criteria) this;
        }

        public Criteria andEndReasonNotIn(List<Integer> values) {
            addCriterion("end_reason not in", values, "endReason");
            return (Criteria) this;
        }

        public Criteria andEndReasonBetween(Integer value1, Integer value2) {
            addCriterion("end_reason between", value1, value2, "endReason");
            return (Criteria) this;
        }

        public Criteria andEndReasonNotBetween(Integer value1, Integer value2) {
            addCriterion("end_reason not between", value1, value2, "endReason");
            return (Criteria) this;
        }

        public Criteria andMessageIsNull() {
            addCriterion("message is null");
            return (Criteria) this;
        }

        public Criteria andMessageIsNotNull() {
            addCriterion("message is not null");
            return (Criteria) this;
        }

        public Criteria andMessageEqualTo(String value) {
            addCriterion("message =", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotEqualTo(String value) {
            addCriterion("message <>", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageGreaterThan(String value) {
            addCriterion("message >", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageGreaterThanOrEqualTo(String value) {
            addCriterion("message >=", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageLessThan(String value) {
            addCriterion("message <", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageLessThanOrEqualTo(String value) {
            addCriterion("message <=", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageLike(String value) {
            addCriterion("message like", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotLike(String value) {
            addCriterion("message not like", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageIn(List<String> values) {
            addCriterion("message in", values, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotIn(List<String> values) {
            addCriterion("message not in", values, "message");
            return (Criteria) this;
        }

        public Criteria andMessageBetween(String value1, String value2) {
            addCriterion("message between", value1, value2, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotBetween(String value1, String value2) {
            addCriterion("message not between", value1, value2, "message");
            return (Criteria) this;
        }

        public Criteria andSharpStartChargingDttmIsNull() {
            addCriterion("sharp_start_charging_dttm is null");
            return (Criteria) this;
        }

        public Criteria andSharpStartChargingDttmIsNotNull() {
            addCriterion("sharp_start_charging_dttm is not null");
            return (Criteria) this;
        }

        public Criteria andSharpStartChargingDttmEqualTo(Date value) {
            addCriterion("sharp_start_charging_dttm =", value, "sharpStartChargingDttm");
            return (Criteria) this;
        }

        public Criteria andSharpStartChargingDttmNotEqualTo(Date value) {
            addCriterion("sharp_start_charging_dttm <>", value, "sharpStartChargingDttm");
            return (Criteria) this;
        }

        public Criteria andSharpStartChargingDttmGreaterThan(Date value) {
            addCriterion("sharp_start_charging_dttm >", value, "sharpStartChargingDttm");
            return (Criteria) this;
        }

        public Criteria andSharpStartChargingDttmGreaterThanOrEqualTo(Date value) {
            addCriterion("sharp_start_charging_dttm >=", value, "sharpStartChargingDttm");
            return (Criteria) this;
        }

        public Criteria andSharpStartChargingDttmLessThan(Date value) {
            addCriterion("sharp_start_charging_dttm <", value, "sharpStartChargingDttm");
            return (Criteria) this;
        }

        public Criteria andSharpStartChargingDttmLessThanOrEqualTo(Date value) {
            addCriterion("sharp_start_charging_dttm <=", value, "sharpStartChargingDttm");
            return (Criteria) this;
        }

        public Criteria andSharpStartChargingDttmIn(List<Date> values) {
            addCriterion("sharp_start_charging_dttm in", values, "sharpStartChargingDttm");
            return (Criteria) this;
        }

        public Criteria andSharpStartChargingDttmNotIn(List<Date> values) {
            addCriterion("sharp_start_charging_dttm not in", values, "sharpStartChargingDttm");
            return (Criteria) this;
        }

        public Criteria andSharpStartChargingDttmBetween(Date value1, Date value2) {
            addCriterion("sharp_start_charging_dttm between", value1, value2, "sharpStartChargingDttm");
            return (Criteria) this;
        }

        public Criteria andSharpStartChargingDttmNotBetween(Date value1, Date value2) {
            addCriterion("sharp_start_charging_dttm not between", value1, value2, "sharpStartChargingDttm");
            return (Criteria) this;
        }

        public Criteria andSharpEndChargingDttmIsNull() {
            addCriterion("sharp_end_charging_dttm is null");
            return (Criteria) this;
        }

        public Criteria andSharpEndChargingDttmIsNotNull() {
            addCriterion("sharp_end_charging_dttm is not null");
            return (Criteria) this;
        }

        public Criteria andSharpEndChargingDttmEqualTo(Date value) {
            addCriterion("sharp_end_charging_dttm =", value, "sharpEndChargingDttm");
            return (Criteria) this;
        }

        public Criteria andSharpEndChargingDttmNotEqualTo(Date value) {
            addCriterion("sharp_end_charging_dttm <>", value, "sharpEndChargingDttm");
            return (Criteria) this;
        }

        public Criteria andSharpEndChargingDttmGreaterThan(Date value) {
            addCriterion("sharp_end_charging_dttm >", value, "sharpEndChargingDttm");
            return (Criteria) this;
        }

        public Criteria andSharpEndChargingDttmGreaterThanOrEqualTo(Date value) {
            addCriterion("sharp_end_charging_dttm >=", value, "sharpEndChargingDttm");
            return (Criteria) this;
        }

        public Criteria andSharpEndChargingDttmLessThan(Date value) {
            addCriterion("sharp_end_charging_dttm <", value, "sharpEndChargingDttm");
            return (Criteria) this;
        }

        public Criteria andSharpEndChargingDttmLessThanOrEqualTo(Date value) {
            addCriterion("sharp_end_charging_dttm <=", value, "sharpEndChargingDttm");
            return (Criteria) this;
        }

        public Criteria andSharpEndChargingDttmIn(List<Date> values) {
            addCriterion("sharp_end_charging_dttm in", values, "sharpEndChargingDttm");
            return (Criteria) this;
        }

        public Criteria andSharpEndChargingDttmNotIn(List<Date> values) {
            addCriterion("sharp_end_charging_dttm not in", values, "sharpEndChargingDttm");
            return (Criteria) this;
        }

        public Criteria andSharpEndChargingDttmBetween(Date value1, Date value2) {
            addCriterion("sharp_end_charging_dttm between", value1, value2, "sharpEndChargingDttm");
            return (Criteria) this;
        }

        public Criteria andSharpEndChargingDttmNotBetween(Date value1, Date value2) {
            addCriterion("sharp_end_charging_dttm not between", value1, value2, "sharpEndChargingDttm");
            return (Criteria) this;
        }

        public Criteria andSharpStartAmmeterNoIsNull() {
            addCriterion("sharp_start_ammeter_no is null");
            return (Criteria) this;
        }

        public Criteria andSharpStartAmmeterNoIsNotNull() {
            addCriterion("sharp_start_ammeter_no is not null");
            return (Criteria) this;
        }

        public Criteria andSharpStartAmmeterNoEqualTo(Integer value) {
            addCriterion("sharp_start_ammeter_no =", value, "sharpStartAmmeterNo");
            return (Criteria) this;
        }

        public Criteria andSharpStartAmmeterNoNotEqualTo(Integer value) {
            addCriterion("sharp_start_ammeter_no <>", value, "sharpStartAmmeterNo");
            return (Criteria) this;
        }

        public Criteria andSharpStartAmmeterNoGreaterThan(Integer value) {
            addCriterion("sharp_start_ammeter_no >", value, "sharpStartAmmeterNo");
            return (Criteria) this;
        }

        public Criteria andSharpStartAmmeterNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("sharp_start_ammeter_no >=", value, "sharpStartAmmeterNo");
            return (Criteria) this;
        }

        public Criteria andSharpStartAmmeterNoLessThan(Integer value) {
            addCriterion("sharp_start_ammeter_no <", value, "sharpStartAmmeterNo");
            return (Criteria) this;
        }

        public Criteria andSharpStartAmmeterNoLessThanOrEqualTo(Integer value) {
            addCriterion("sharp_start_ammeter_no <=", value, "sharpStartAmmeterNo");
            return (Criteria) this;
        }

        public Criteria andSharpStartAmmeterNoIn(List<Integer> values) {
            addCriterion("sharp_start_ammeter_no in", values, "sharpStartAmmeterNo");
            return (Criteria) this;
        }

        public Criteria andSharpStartAmmeterNoNotIn(List<Integer> values) {
            addCriterion("sharp_start_ammeter_no not in", values, "sharpStartAmmeterNo");
            return (Criteria) this;
        }

        public Criteria andSharpStartAmmeterNoBetween(Integer value1, Integer value2) {
            addCriterion("sharp_start_ammeter_no between", value1, value2, "sharpStartAmmeterNo");
            return (Criteria) this;
        }

        public Criteria andSharpStartAmmeterNoNotBetween(Integer value1, Integer value2) {
            addCriterion("sharp_start_ammeter_no not between", value1, value2, "sharpStartAmmeterNo");
            return (Criteria) this;
        }

        public Criteria andSharpEndAmmeterNoIsNull() {
            addCriterion("sharp_end_ammeter_no is null");
            return (Criteria) this;
        }

        public Criteria andSharpEndAmmeterNoIsNotNull() {
            addCriterion("sharp_end_ammeter_no is not null");
            return (Criteria) this;
        }

        public Criteria andSharpEndAmmeterNoEqualTo(Integer value) {
            addCriterion("sharp_end_ammeter_no =", value, "sharpEndAmmeterNo");
            return (Criteria) this;
        }

        public Criteria andSharpEndAmmeterNoNotEqualTo(Integer value) {
            addCriterion("sharp_end_ammeter_no <>", value, "sharpEndAmmeterNo");
            return (Criteria) this;
        }

        public Criteria andSharpEndAmmeterNoGreaterThan(Integer value) {
            addCriterion("sharp_end_ammeter_no >", value, "sharpEndAmmeterNo");
            return (Criteria) this;
        }

        public Criteria andSharpEndAmmeterNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("sharp_end_ammeter_no >=", value, "sharpEndAmmeterNo");
            return (Criteria) this;
        }

        public Criteria andSharpEndAmmeterNoLessThan(Integer value) {
            addCriterion("sharp_end_ammeter_no <", value, "sharpEndAmmeterNo");
            return (Criteria) this;
        }

        public Criteria andSharpEndAmmeterNoLessThanOrEqualTo(Integer value) {
            addCriterion("sharp_end_ammeter_no <=", value, "sharpEndAmmeterNo");
            return (Criteria) this;
        }

        public Criteria andSharpEndAmmeterNoIn(List<Integer> values) {
            addCriterion("sharp_end_ammeter_no in", values, "sharpEndAmmeterNo");
            return (Criteria) this;
        }

        public Criteria andSharpEndAmmeterNoNotIn(List<Integer> values) {
            addCriterion("sharp_end_ammeter_no not in", values, "sharpEndAmmeterNo");
            return (Criteria) this;
        }

        public Criteria andSharpEndAmmeterNoBetween(Integer value1, Integer value2) {
            addCriterion("sharp_end_ammeter_no between", value1, value2, "sharpEndAmmeterNo");
            return (Criteria) this;
        }

        public Criteria andSharpEndAmmeterNoNotBetween(Integer value1, Integer value2) {
            addCriterion("sharp_end_ammeter_no not between", value1, value2, "sharpEndAmmeterNo");
            return (Criteria) this;
        }

        public Criteria andSharpTotalChargingKwhIsNull() {
            addCriterion("sharp_total_charging_kwh is null");
            return (Criteria) this;
        }

        public Criteria andSharpTotalChargingKwhIsNotNull() {
            addCriterion("sharp_total_charging_kwh is not null");
            return (Criteria) this;
        }

        public Criteria andSharpTotalChargingKwhEqualTo(Double value) {
            addCriterion("sharp_total_charging_kwh =", value, "sharpTotalChargingKwh");
            return (Criteria) this;
        }

        public Criteria andSharpTotalChargingKwhNotEqualTo(Double value) {
            addCriterion("sharp_total_charging_kwh <>", value, "sharpTotalChargingKwh");
            return (Criteria) this;
        }

        public Criteria andSharpTotalChargingKwhGreaterThan(Double value) {
            addCriterion("sharp_total_charging_kwh >", value, "sharpTotalChargingKwh");
            return (Criteria) this;
        }

        public Criteria andSharpTotalChargingKwhGreaterThanOrEqualTo(Double value) {
            addCriterion("sharp_total_charging_kwh >=", value, "sharpTotalChargingKwh");
            return (Criteria) this;
        }

        public Criteria andSharpTotalChargingKwhLessThan(Double value) {
            addCriterion("sharp_total_charging_kwh <", value, "sharpTotalChargingKwh");
            return (Criteria) this;
        }

        public Criteria andSharpTotalChargingKwhLessThanOrEqualTo(Double value) {
            addCriterion("sharp_total_charging_kwh <=", value, "sharpTotalChargingKwh");
            return (Criteria) this;
        }

        public Criteria andSharpTotalChargingKwhIn(List<Double> values) {
            addCriterion("sharp_total_charging_kwh in", values, "sharpTotalChargingKwh");
            return (Criteria) this;
        }

        public Criteria andSharpTotalChargingKwhNotIn(List<Double> values) {
            addCriterion("sharp_total_charging_kwh not in", values, "sharpTotalChargingKwh");
            return (Criteria) this;
        }

        public Criteria andSharpTotalChargingKwhBetween(Double value1, Double value2) {
            addCriterion("sharp_total_charging_kwh between", value1, value2, "sharpTotalChargingKwh");
            return (Criteria) this;
        }

        public Criteria andSharpTotalChargingKwhNotBetween(Double value1, Double value2) {
            addCriterion("sharp_total_charging_kwh not between", value1, value2, "sharpTotalChargingKwh");
            return (Criteria) this;
        }

        public Criteria andPeakStartChargingDttmIsNull() {
            addCriterion("peak_start_charging_dttm is null");
            return (Criteria) this;
        }

        public Criteria andPeakStartChargingDttmIsNotNull() {
            addCriterion("peak_start_charging_dttm is not null");
            return (Criteria) this;
        }

        public Criteria andPeakStartChargingDttmEqualTo(Date value) {
            addCriterion("peak_start_charging_dttm =", value, "peakStartChargingDttm");
            return (Criteria) this;
        }

        public Criteria andPeakStartChargingDttmNotEqualTo(Date value) {
            addCriterion("peak_start_charging_dttm <>", value, "peakStartChargingDttm");
            return (Criteria) this;
        }

        public Criteria andPeakStartChargingDttmGreaterThan(Date value) {
            addCriterion("peak_start_charging_dttm >", value, "peakStartChargingDttm");
            return (Criteria) this;
        }

        public Criteria andPeakStartChargingDttmGreaterThanOrEqualTo(Date value) {
            addCriterion("peak_start_charging_dttm >=", value, "peakStartChargingDttm");
            return (Criteria) this;
        }

        public Criteria andPeakStartChargingDttmLessThan(Date value) {
            addCriterion("peak_start_charging_dttm <", value, "peakStartChargingDttm");
            return (Criteria) this;
        }

        public Criteria andPeakStartChargingDttmLessThanOrEqualTo(Date value) {
            addCriterion("peak_start_charging_dttm <=", value, "peakStartChargingDttm");
            return (Criteria) this;
        }

        public Criteria andPeakStartChargingDttmIn(List<Date> values) {
            addCriterion("peak_start_charging_dttm in", values, "peakStartChargingDttm");
            return (Criteria) this;
        }

        public Criteria andPeakStartChargingDttmNotIn(List<Date> values) {
            addCriterion("peak_start_charging_dttm not in", values, "peakStartChargingDttm");
            return (Criteria) this;
        }

        public Criteria andPeakStartChargingDttmBetween(Date value1, Date value2) {
            addCriterion("peak_start_charging_dttm between", value1, value2, "peakStartChargingDttm");
            return (Criteria) this;
        }

        public Criteria andPeakStartChargingDttmNotBetween(Date value1, Date value2) {
            addCriterion("peak_start_charging_dttm not between", value1, value2, "peakStartChargingDttm");
            return (Criteria) this;
        }

        public Criteria andPeakEndChargingDttmIsNull() {
            addCriterion("peak_end_charging_dttm is null");
            return (Criteria) this;
        }

        public Criteria andPeakEndChargingDttmIsNotNull() {
            addCriterion("peak_end_charging_dttm is not null");
            return (Criteria) this;
        }

        public Criteria andPeakEndChargingDttmEqualTo(Date value) {
            addCriterion("peak_end_charging_dttm =", value, "peakEndChargingDttm");
            return (Criteria) this;
        }

        public Criteria andPeakEndChargingDttmNotEqualTo(Date value) {
            addCriterion("peak_end_charging_dttm <>", value, "peakEndChargingDttm");
            return (Criteria) this;
        }

        public Criteria andPeakEndChargingDttmGreaterThan(Date value) {
            addCriterion("peak_end_charging_dttm >", value, "peakEndChargingDttm");
            return (Criteria) this;
        }

        public Criteria andPeakEndChargingDttmGreaterThanOrEqualTo(Date value) {
            addCriterion("peak_end_charging_dttm >=", value, "peakEndChargingDttm");
            return (Criteria) this;
        }

        public Criteria andPeakEndChargingDttmLessThan(Date value) {
            addCriterion("peak_end_charging_dttm <", value, "peakEndChargingDttm");
            return (Criteria) this;
        }

        public Criteria andPeakEndChargingDttmLessThanOrEqualTo(Date value) {
            addCriterion("peak_end_charging_dttm <=", value, "peakEndChargingDttm");
            return (Criteria) this;
        }

        public Criteria andPeakEndChargingDttmIn(List<Date> values) {
            addCriterion("peak_end_charging_dttm in", values, "peakEndChargingDttm");
            return (Criteria) this;
        }

        public Criteria andPeakEndChargingDttmNotIn(List<Date> values) {
            addCriterion("peak_end_charging_dttm not in", values, "peakEndChargingDttm");
            return (Criteria) this;
        }

        public Criteria andPeakEndChargingDttmBetween(Date value1, Date value2) {
            addCriterion("peak_end_charging_dttm between", value1, value2, "peakEndChargingDttm");
            return (Criteria) this;
        }

        public Criteria andPeakEndChargingDttmNotBetween(Date value1, Date value2) {
            addCriterion("peak_end_charging_dttm not between", value1, value2, "peakEndChargingDttm");
            return (Criteria) this;
        }

        public Criteria andPeakStartAmmeterNoIsNull() {
            addCriterion("peak_start_ammeter_no is null");
            return (Criteria) this;
        }

        public Criteria andPeakStartAmmeterNoIsNotNull() {
            addCriterion("peak_start_ammeter_no is not null");
            return (Criteria) this;
        }

        public Criteria andPeakStartAmmeterNoEqualTo(Integer value) {
            addCriterion("peak_start_ammeter_no =", value, "peakStartAmmeterNo");
            return (Criteria) this;
        }

        public Criteria andPeakStartAmmeterNoNotEqualTo(Integer value) {
            addCriterion("peak_start_ammeter_no <>", value, "peakStartAmmeterNo");
            return (Criteria) this;
        }

        public Criteria andPeakStartAmmeterNoGreaterThan(Integer value) {
            addCriterion("peak_start_ammeter_no >", value, "peakStartAmmeterNo");
            return (Criteria) this;
        }

        public Criteria andPeakStartAmmeterNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("peak_start_ammeter_no >=", value, "peakStartAmmeterNo");
            return (Criteria) this;
        }

        public Criteria andPeakStartAmmeterNoLessThan(Integer value) {
            addCriterion("peak_start_ammeter_no <", value, "peakStartAmmeterNo");
            return (Criteria) this;
        }

        public Criteria andPeakStartAmmeterNoLessThanOrEqualTo(Integer value) {
            addCriterion("peak_start_ammeter_no <=", value, "peakStartAmmeterNo");
            return (Criteria) this;
        }

        public Criteria andPeakStartAmmeterNoIn(List<Integer> values) {
            addCriterion("peak_start_ammeter_no in", values, "peakStartAmmeterNo");
            return (Criteria) this;
        }

        public Criteria andPeakStartAmmeterNoNotIn(List<Integer> values) {
            addCriterion("peak_start_ammeter_no not in", values, "peakStartAmmeterNo");
            return (Criteria) this;
        }

        public Criteria andPeakStartAmmeterNoBetween(Integer value1, Integer value2) {
            addCriterion("peak_start_ammeter_no between", value1, value2, "peakStartAmmeterNo");
            return (Criteria) this;
        }

        public Criteria andPeakStartAmmeterNoNotBetween(Integer value1, Integer value2) {
            addCriterion("peak_start_ammeter_no not between", value1, value2, "peakStartAmmeterNo");
            return (Criteria) this;
        }

        public Criteria andPeakEndAmmeterNoIsNull() {
            addCriterion("peak_end_ammeter_no is null");
            return (Criteria) this;
        }

        public Criteria andPeakEndAmmeterNoIsNotNull() {
            addCriterion("peak_end_ammeter_no is not null");
            return (Criteria) this;
        }

        public Criteria andPeakEndAmmeterNoEqualTo(Integer value) {
            addCriterion("peak_end_ammeter_no =", value, "peakEndAmmeterNo");
            return (Criteria) this;
        }

        public Criteria andPeakEndAmmeterNoNotEqualTo(Integer value) {
            addCriterion("peak_end_ammeter_no <>", value, "peakEndAmmeterNo");
            return (Criteria) this;
        }

        public Criteria andPeakEndAmmeterNoGreaterThan(Integer value) {
            addCriterion("peak_end_ammeter_no >", value, "peakEndAmmeterNo");
            return (Criteria) this;
        }

        public Criteria andPeakEndAmmeterNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("peak_end_ammeter_no >=", value, "peakEndAmmeterNo");
            return (Criteria) this;
        }

        public Criteria andPeakEndAmmeterNoLessThan(Integer value) {
            addCriterion("peak_end_ammeter_no <", value, "peakEndAmmeterNo");
            return (Criteria) this;
        }

        public Criteria andPeakEndAmmeterNoLessThanOrEqualTo(Integer value) {
            addCriterion("peak_end_ammeter_no <=", value, "peakEndAmmeterNo");
            return (Criteria) this;
        }

        public Criteria andPeakEndAmmeterNoIn(List<Integer> values) {
            addCriterion("peak_end_ammeter_no in", values, "peakEndAmmeterNo");
            return (Criteria) this;
        }

        public Criteria andPeakEndAmmeterNoNotIn(List<Integer> values) {
            addCriterion("peak_end_ammeter_no not in", values, "peakEndAmmeterNo");
            return (Criteria) this;
        }

        public Criteria andPeakEndAmmeterNoBetween(Integer value1, Integer value2) {
            addCriterion("peak_end_ammeter_no between", value1, value2, "peakEndAmmeterNo");
            return (Criteria) this;
        }

        public Criteria andPeakEndAmmeterNoNotBetween(Integer value1, Integer value2) {
            addCriterion("peak_end_ammeter_no not between", value1, value2, "peakEndAmmeterNo");
            return (Criteria) this;
        }

        public Criteria andPeakTotalChargingKwhIsNull() {
            addCriterion("peak_total_charging_kwh is null");
            return (Criteria) this;
        }

        public Criteria andPeakTotalChargingKwhIsNotNull() {
            addCriterion("peak_total_charging_kwh is not null");
            return (Criteria) this;
        }

        public Criteria andPeakTotalChargingKwhEqualTo(Double value) {
            addCriterion("peak_total_charging_kwh =", value, "peakTotalChargingKwh");
            return (Criteria) this;
        }

        public Criteria andPeakTotalChargingKwhNotEqualTo(Double value) {
            addCriterion("peak_total_charging_kwh <>", value, "peakTotalChargingKwh");
            return (Criteria) this;
        }

        public Criteria andPeakTotalChargingKwhGreaterThan(Double value) {
            addCriterion("peak_total_charging_kwh >", value, "peakTotalChargingKwh");
            return (Criteria) this;
        }

        public Criteria andPeakTotalChargingKwhGreaterThanOrEqualTo(Double value) {
            addCriterion("peak_total_charging_kwh >=", value, "peakTotalChargingKwh");
            return (Criteria) this;
        }

        public Criteria andPeakTotalChargingKwhLessThan(Double value) {
            addCriterion("peak_total_charging_kwh <", value, "peakTotalChargingKwh");
            return (Criteria) this;
        }

        public Criteria andPeakTotalChargingKwhLessThanOrEqualTo(Double value) {
            addCriterion("peak_total_charging_kwh <=", value, "peakTotalChargingKwh");
            return (Criteria) this;
        }

        public Criteria andPeakTotalChargingKwhIn(List<Double> values) {
            addCriterion("peak_total_charging_kwh in", values, "peakTotalChargingKwh");
            return (Criteria) this;
        }

        public Criteria andPeakTotalChargingKwhNotIn(List<Double> values) {
            addCriterion("peak_total_charging_kwh not in", values, "peakTotalChargingKwh");
            return (Criteria) this;
        }

        public Criteria andPeakTotalChargingKwhBetween(Double value1, Double value2) {
            addCriterion("peak_total_charging_kwh between", value1, value2, "peakTotalChargingKwh");
            return (Criteria) this;
        }

        public Criteria andPeakTotalChargingKwhNotBetween(Double value1, Double value2) {
            addCriterion("peak_total_charging_kwh not between", value1, value2, "peakTotalChargingKwh");
            return (Criteria) this;
        }

        public Criteria andFlatStartChargingDttmIsNull() {
            addCriterion("flat_start_charging_dttm is null");
            return (Criteria) this;
        }

        public Criteria andFlatStartChargingDttmIsNotNull() {
            addCriterion("flat_start_charging_dttm is not null");
            return (Criteria) this;
        }

        public Criteria andFlatStartChargingDttmEqualTo(Date value) {
            addCriterion("flat_start_charging_dttm =", value, "flatStartChargingDttm");
            return (Criteria) this;
        }

        public Criteria andFlatStartChargingDttmNotEqualTo(Date value) {
            addCriterion("flat_start_charging_dttm <>", value, "flatStartChargingDttm");
            return (Criteria) this;
        }

        public Criteria andFlatStartChargingDttmGreaterThan(Date value) {
            addCriterion("flat_start_charging_dttm >", value, "flatStartChargingDttm");
            return (Criteria) this;
        }

        public Criteria andFlatStartChargingDttmGreaterThanOrEqualTo(Date value) {
            addCriterion("flat_start_charging_dttm >=", value, "flatStartChargingDttm");
            return (Criteria) this;
        }

        public Criteria andFlatStartChargingDttmLessThan(Date value) {
            addCriterion("flat_start_charging_dttm <", value, "flatStartChargingDttm");
            return (Criteria) this;
        }

        public Criteria andFlatStartChargingDttmLessThanOrEqualTo(Date value) {
            addCriterion("flat_start_charging_dttm <=", value, "flatStartChargingDttm");
            return (Criteria) this;
        }

        public Criteria andFlatStartChargingDttmIn(List<Date> values) {
            addCriterion("flat_start_charging_dttm in", values, "flatStartChargingDttm");
            return (Criteria) this;
        }

        public Criteria andFlatStartChargingDttmNotIn(List<Date> values) {
            addCriterion("flat_start_charging_dttm not in", values, "flatStartChargingDttm");
            return (Criteria) this;
        }

        public Criteria andFlatStartChargingDttmBetween(Date value1, Date value2) {
            addCriterion("flat_start_charging_dttm between", value1, value2, "flatStartChargingDttm");
            return (Criteria) this;
        }

        public Criteria andFlatStartChargingDttmNotBetween(Date value1, Date value2) {
            addCriterion("flat_start_charging_dttm not between", value1, value2, "flatStartChargingDttm");
            return (Criteria) this;
        }

        public Criteria andFlatEndChargingDttmIsNull() {
            addCriterion("flat_end_charging_dttm is null");
            return (Criteria) this;
        }

        public Criteria andFlatEndChargingDttmIsNotNull() {
            addCriterion("flat_end_charging_dttm is not null");
            return (Criteria) this;
        }

        public Criteria andFlatEndChargingDttmEqualTo(Date value) {
            addCriterion("flat_end_charging_dttm =", value, "flatEndChargingDttm");
            return (Criteria) this;
        }

        public Criteria andFlatEndChargingDttmNotEqualTo(Date value) {
            addCriterion("flat_end_charging_dttm <>", value, "flatEndChargingDttm");
            return (Criteria) this;
        }

        public Criteria andFlatEndChargingDttmGreaterThan(Date value) {
            addCriterion("flat_end_charging_dttm >", value, "flatEndChargingDttm");
            return (Criteria) this;
        }

        public Criteria andFlatEndChargingDttmGreaterThanOrEqualTo(Date value) {
            addCriterion("flat_end_charging_dttm >=", value, "flatEndChargingDttm");
            return (Criteria) this;
        }

        public Criteria andFlatEndChargingDttmLessThan(Date value) {
            addCriterion("flat_end_charging_dttm <", value, "flatEndChargingDttm");
            return (Criteria) this;
        }

        public Criteria andFlatEndChargingDttmLessThanOrEqualTo(Date value) {
            addCriterion("flat_end_charging_dttm <=", value, "flatEndChargingDttm");
            return (Criteria) this;
        }

        public Criteria andFlatEndChargingDttmIn(List<Date> values) {
            addCriterion("flat_end_charging_dttm in", values, "flatEndChargingDttm");
            return (Criteria) this;
        }

        public Criteria andFlatEndChargingDttmNotIn(List<Date> values) {
            addCriterion("flat_end_charging_dttm not in", values, "flatEndChargingDttm");
            return (Criteria) this;
        }

        public Criteria andFlatEndChargingDttmBetween(Date value1, Date value2) {
            addCriterion("flat_end_charging_dttm between", value1, value2, "flatEndChargingDttm");
            return (Criteria) this;
        }

        public Criteria andFlatEndChargingDttmNotBetween(Date value1, Date value2) {
            addCriterion("flat_end_charging_dttm not between", value1, value2, "flatEndChargingDttm");
            return (Criteria) this;
        }

        public Criteria andFlatStartAmmeterNoIsNull() {
            addCriterion("flat_start_ammeter_no is null");
            return (Criteria) this;
        }

        public Criteria andFlatStartAmmeterNoIsNotNull() {
            addCriterion("flat_start_ammeter_no is not null");
            return (Criteria) this;
        }

        public Criteria andFlatStartAmmeterNoEqualTo(Integer value) {
            addCriterion("flat_start_ammeter_no =", value, "flatStartAmmeterNo");
            return (Criteria) this;
        }

        public Criteria andFlatStartAmmeterNoNotEqualTo(Integer value) {
            addCriterion("flat_start_ammeter_no <>", value, "flatStartAmmeterNo");
            return (Criteria) this;
        }

        public Criteria andFlatStartAmmeterNoGreaterThan(Integer value) {
            addCriterion("flat_start_ammeter_no >", value, "flatStartAmmeterNo");
            return (Criteria) this;
        }

        public Criteria andFlatStartAmmeterNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("flat_start_ammeter_no >=", value, "flatStartAmmeterNo");
            return (Criteria) this;
        }

        public Criteria andFlatStartAmmeterNoLessThan(Integer value) {
            addCriterion("flat_start_ammeter_no <", value, "flatStartAmmeterNo");
            return (Criteria) this;
        }

        public Criteria andFlatStartAmmeterNoLessThanOrEqualTo(Integer value) {
            addCriterion("flat_start_ammeter_no <=", value, "flatStartAmmeterNo");
            return (Criteria) this;
        }

        public Criteria andFlatStartAmmeterNoIn(List<Integer> values) {
            addCriterion("flat_start_ammeter_no in", values, "flatStartAmmeterNo");
            return (Criteria) this;
        }

        public Criteria andFlatStartAmmeterNoNotIn(List<Integer> values) {
            addCriterion("flat_start_ammeter_no not in", values, "flatStartAmmeterNo");
            return (Criteria) this;
        }

        public Criteria andFlatStartAmmeterNoBetween(Integer value1, Integer value2) {
            addCriterion("flat_start_ammeter_no between", value1, value2, "flatStartAmmeterNo");
            return (Criteria) this;
        }

        public Criteria andFlatStartAmmeterNoNotBetween(Integer value1, Integer value2) {
            addCriterion("flat_start_ammeter_no not between", value1, value2, "flatStartAmmeterNo");
            return (Criteria) this;
        }

        public Criteria andFlatEndAmmeterNoIsNull() {
            addCriterion("flat_end_ammeter_no is null");
            return (Criteria) this;
        }

        public Criteria andFlatEndAmmeterNoIsNotNull() {
            addCriterion("flat_end_ammeter_no is not null");
            return (Criteria) this;
        }

        public Criteria andFlatEndAmmeterNoEqualTo(Integer value) {
            addCriterion("flat_end_ammeter_no =", value, "flatEndAmmeterNo");
            return (Criteria) this;
        }

        public Criteria andFlatEndAmmeterNoNotEqualTo(Integer value) {
            addCriterion("flat_end_ammeter_no <>", value, "flatEndAmmeterNo");
            return (Criteria) this;
        }

        public Criteria andFlatEndAmmeterNoGreaterThan(Integer value) {
            addCriterion("flat_end_ammeter_no >", value, "flatEndAmmeterNo");
            return (Criteria) this;
        }

        public Criteria andFlatEndAmmeterNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("flat_end_ammeter_no >=", value, "flatEndAmmeterNo");
            return (Criteria) this;
        }

        public Criteria andFlatEndAmmeterNoLessThan(Integer value) {
            addCriterion("flat_end_ammeter_no <", value, "flatEndAmmeterNo");
            return (Criteria) this;
        }

        public Criteria andFlatEndAmmeterNoLessThanOrEqualTo(Integer value) {
            addCriterion("flat_end_ammeter_no <=", value, "flatEndAmmeterNo");
            return (Criteria) this;
        }

        public Criteria andFlatEndAmmeterNoIn(List<Integer> values) {
            addCriterion("flat_end_ammeter_no in", values, "flatEndAmmeterNo");
            return (Criteria) this;
        }

        public Criteria andFlatEndAmmeterNoNotIn(List<Integer> values) {
            addCriterion("flat_end_ammeter_no not in", values, "flatEndAmmeterNo");
            return (Criteria) this;
        }

        public Criteria andFlatEndAmmeterNoBetween(Integer value1, Integer value2) {
            addCriterion("flat_end_ammeter_no between", value1, value2, "flatEndAmmeterNo");
            return (Criteria) this;
        }

        public Criteria andFlatEndAmmeterNoNotBetween(Integer value1, Integer value2) {
            addCriterion("flat_end_ammeter_no not between", value1, value2, "flatEndAmmeterNo");
            return (Criteria) this;
        }

        public Criteria andFlatTotalChargingKwhIsNull() {
            addCriterion("flat_total_charging_kwh is null");
            return (Criteria) this;
        }

        public Criteria andFlatTotalChargingKwhIsNotNull() {
            addCriterion("flat_total_charging_kwh is not null");
            return (Criteria) this;
        }

        public Criteria andFlatTotalChargingKwhEqualTo(Double value) {
            addCriterion("flat_total_charging_kwh =", value, "flatTotalChargingKwh");
            return (Criteria) this;
        }

        public Criteria andFlatTotalChargingKwhNotEqualTo(Double value) {
            addCriterion("flat_total_charging_kwh <>", value, "flatTotalChargingKwh");
            return (Criteria) this;
        }

        public Criteria andFlatTotalChargingKwhGreaterThan(Double value) {
            addCriterion("flat_total_charging_kwh >", value, "flatTotalChargingKwh");
            return (Criteria) this;
        }

        public Criteria andFlatTotalChargingKwhGreaterThanOrEqualTo(Double value) {
            addCriterion("flat_total_charging_kwh >=", value, "flatTotalChargingKwh");
            return (Criteria) this;
        }

        public Criteria andFlatTotalChargingKwhLessThan(Double value) {
            addCriterion("flat_total_charging_kwh <", value, "flatTotalChargingKwh");
            return (Criteria) this;
        }

        public Criteria andFlatTotalChargingKwhLessThanOrEqualTo(Double value) {
            addCriterion("flat_total_charging_kwh <=", value, "flatTotalChargingKwh");
            return (Criteria) this;
        }

        public Criteria andFlatTotalChargingKwhIn(List<Double> values) {
            addCriterion("flat_total_charging_kwh in", values, "flatTotalChargingKwh");
            return (Criteria) this;
        }

        public Criteria andFlatTotalChargingKwhNotIn(List<Double> values) {
            addCriterion("flat_total_charging_kwh not in", values, "flatTotalChargingKwh");
            return (Criteria) this;
        }

        public Criteria andFlatTotalChargingKwhBetween(Double value1, Double value2) {
            addCriterion("flat_total_charging_kwh between", value1, value2, "flatTotalChargingKwh");
            return (Criteria) this;
        }

        public Criteria andFlatTotalChargingKwhNotBetween(Double value1, Double value2) {
            addCriterion("flat_total_charging_kwh not between", value1, value2, "flatTotalChargingKwh");
            return (Criteria) this;
        }

        public Criteria andValleyStartChargingDttmIsNull() {
            addCriterion("valley_start_charging_dttm is null");
            return (Criteria) this;
        }

        public Criteria andValleyStartChargingDttmIsNotNull() {
            addCriterion("valley_start_charging_dttm is not null");
            return (Criteria) this;
        }

        public Criteria andValleyStartChargingDttmEqualTo(Date value) {
            addCriterion("valley_start_charging_dttm =", value, "valleyStartChargingDttm");
            return (Criteria) this;
        }

        public Criteria andValleyStartChargingDttmNotEqualTo(Date value) {
            addCriterion("valley_start_charging_dttm <>", value, "valleyStartChargingDttm");
            return (Criteria) this;
        }

        public Criteria andValleyStartChargingDttmGreaterThan(Date value) {
            addCriterion("valley_start_charging_dttm >", value, "valleyStartChargingDttm");
            return (Criteria) this;
        }

        public Criteria andValleyStartChargingDttmGreaterThanOrEqualTo(Date value) {
            addCriterion("valley_start_charging_dttm >=", value, "valleyStartChargingDttm");
            return (Criteria) this;
        }

        public Criteria andValleyStartChargingDttmLessThan(Date value) {
            addCriterion("valley_start_charging_dttm <", value, "valleyStartChargingDttm");
            return (Criteria) this;
        }

        public Criteria andValleyStartChargingDttmLessThanOrEqualTo(Date value) {
            addCriterion("valley_start_charging_dttm <=", value, "valleyStartChargingDttm");
            return (Criteria) this;
        }

        public Criteria andValleyStartChargingDttmIn(List<Date> values) {
            addCriterion("valley_start_charging_dttm in", values, "valleyStartChargingDttm");
            return (Criteria) this;
        }

        public Criteria andValleyStartChargingDttmNotIn(List<Date> values) {
            addCriterion("valley_start_charging_dttm not in", values, "valleyStartChargingDttm");
            return (Criteria) this;
        }

        public Criteria andValleyStartChargingDttmBetween(Date value1, Date value2) {
            addCriterion("valley_start_charging_dttm between", value1, value2, "valleyStartChargingDttm");
            return (Criteria) this;
        }

        public Criteria andValleyStartChargingDttmNotBetween(Date value1, Date value2) {
            addCriterion("valley_start_charging_dttm not between", value1, value2, "valleyStartChargingDttm");
            return (Criteria) this;
        }

        public Criteria andValleyEndChargingDttmIsNull() {
            addCriterion("valley_end_charging_dttm is null");
            return (Criteria) this;
        }

        public Criteria andValleyEndChargingDttmIsNotNull() {
            addCriterion("valley_end_charging_dttm is not null");
            return (Criteria) this;
        }

        public Criteria andValleyEndChargingDttmEqualTo(Date value) {
            addCriterion("valley_end_charging_dttm =", value, "valleyEndChargingDttm");
            return (Criteria) this;
        }

        public Criteria andValleyEndChargingDttmNotEqualTo(Date value) {
            addCriterion("valley_end_charging_dttm <>", value, "valleyEndChargingDttm");
            return (Criteria) this;
        }

        public Criteria andValleyEndChargingDttmGreaterThan(Date value) {
            addCriterion("valley_end_charging_dttm >", value, "valleyEndChargingDttm");
            return (Criteria) this;
        }

        public Criteria andValleyEndChargingDttmGreaterThanOrEqualTo(Date value) {
            addCriterion("valley_end_charging_dttm >=", value, "valleyEndChargingDttm");
            return (Criteria) this;
        }

        public Criteria andValleyEndChargingDttmLessThan(Date value) {
            addCriterion("valley_end_charging_dttm <", value, "valleyEndChargingDttm");
            return (Criteria) this;
        }

        public Criteria andValleyEndChargingDttmLessThanOrEqualTo(Date value) {
            addCriterion("valley_end_charging_dttm <=", value, "valleyEndChargingDttm");
            return (Criteria) this;
        }

        public Criteria andValleyEndChargingDttmIn(List<Date> values) {
            addCriterion("valley_end_charging_dttm in", values, "valleyEndChargingDttm");
            return (Criteria) this;
        }

        public Criteria andValleyEndChargingDttmNotIn(List<Date> values) {
            addCriterion("valley_end_charging_dttm not in", values, "valleyEndChargingDttm");
            return (Criteria) this;
        }

        public Criteria andValleyEndChargingDttmBetween(Date value1, Date value2) {
            addCriterion("valley_end_charging_dttm between", value1, value2, "valleyEndChargingDttm");
            return (Criteria) this;
        }

        public Criteria andValleyEndChargingDttmNotBetween(Date value1, Date value2) {
            addCriterion("valley_end_charging_dttm not between", value1, value2, "valleyEndChargingDttm");
            return (Criteria) this;
        }

        public Criteria andValleyStartAmmeterNoIsNull() {
            addCriterion("valley_start_ammeter_no is null");
            return (Criteria) this;
        }

        public Criteria andValleyStartAmmeterNoIsNotNull() {
            addCriterion("valley_start_ammeter_no is not null");
            return (Criteria) this;
        }

        public Criteria andValleyStartAmmeterNoEqualTo(Integer value) {
            addCriterion("valley_start_ammeter_no =", value, "valleyStartAmmeterNo");
            return (Criteria) this;
        }

        public Criteria andValleyStartAmmeterNoNotEqualTo(Integer value) {
            addCriterion("valley_start_ammeter_no <>", value, "valleyStartAmmeterNo");
            return (Criteria) this;
        }

        public Criteria andValleyStartAmmeterNoGreaterThan(Integer value) {
            addCriterion("valley_start_ammeter_no >", value, "valleyStartAmmeterNo");
            return (Criteria) this;
        }

        public Criteria andValleyStartAmmeterNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("valley_start_ammeter_no >=", value, "valleyStartAmmeterNo");
            return (Criteria) this;
        }

        public Criteria andValleyStartAmmeterNoLessThan(Integer value) {
            addCriterion("valley_start_ammeter_no <", value, "valleyStartAmmeterNo");
            return (Criteria) this;
        }

        public Criteria andValleyStartAmmeterNoLessThanOrEqualTo(Integer value) {
            addCriterion("valley_start_ammeter_no <=", value, "valleyStartAmmeterNo");
            return (Criteria) this;
        }

        public Criteria andValleyStartAmmeterNoIn(List<Integer> values) {
            addCriterion("valley_start_ammeter_no in", values, "valleyStartAmmeterNo");
            return (Criteria) this;
        }

        public Criteria andValleyStartAmmeterNoNotIn(List<Integer> values) {
            addCriterion("valley_start_ammeter_no not in", values, "valleyStartAmmeterNo");
            return (Criteria) this;
        }

        public Criteria andValleyStartAmmeterNoBetween(Integer value1, Integer value2) {
            addCriterion("valley_start_ammeter_no between", value1, value2, "valleyStartAmmeterNo");
            return (Criteria) this;
        }

        public Criteria andValleyStartAmmeterNoNotBetween(Integer value1, Integer value2) {
            addCriterion("valley_start_ammeter_no not between", value1, value2, "valleyStartAmmeterNo");
            return (Criteria) this;
        }

        public Criteria andValleyEndAmmeterNoIsNull() {
            addCriterion("valley_end_ammeter_no is null");
            return (Criteria) this;
        }

        public Criteria andValleyEndAmmeterNoIsNotNull() {
            addCriterion("valley_end_ammeter_no is not null");
            return (Criteria) this;
        }

        public Criteria andValleyEndAmmeterNoEqualTo(Integer value) {
            addCriterion("valley_end_ammeter_no =", value, "valleyEndAmmeterNo");
            return (Criteria) this;
        }

        public Criteria andValleyEndAmmeterNoNotEqualTo(Integer value) {
            addCriterion("valley_end_ammeter_no <>", value, "valleyEndAmmeterNo");
            return (Criteria) this;
        }

        public Criteria andValleyEndAmmeterNoGreaterThan(Integer value) {
            addCriterion("valley_end_ammeter_no >", value, "valleyEndAmmeterNo");
            return (Criteria) this;
        }

        public Criteria andValleyEndAmmeterNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("valley_end_ammeter_no >=", value, "valleyEndAmmeterNo");
            return (Criteria) this;
        }

        public Criteria andValleyEndAmmeterNoLessThan(Integer value) {
            addCriterion("valley_end_ammeter_no <", value, "valleyEndAmmeterNo");
            return (Criteria) this;
        }

        public Criteria andValleyEndAmmeterNoLessThanOrEqualTo(Integer value) {
            addCriterion("valley_end_ammeter_no <=", value, "valleyEndAmmeterNo");
            return (Criteria) this;
        }

        public Criteria andValleyEndAmmeterNoIn(List<Integer> values) {
            addCriterion("valley_end_ammeter_no in", values, "valleyEndAmmeterNo");
            return (Criteria) this;
        }

        public Criteria andValleyEndAmmeterNoNotIn(List<Integer> values) {
            addCriterion("valley_end_ammeter_no not in", values, "valleyEndAmmeterNo");
            return (Criteria) this;
        }

        public Criteria andValleyEndAmmeterNoBetween(Integer value1, Integer value2) {
            addCriterion("valley_end_ammeter_no between", value1, value2, "valleyEndAmmeterNo");
            return (Criteria) this;
        }

        public Criteria andValleyEndAmmeterNoNotBetween(Integer value1, Integer value2) {
            addCriterion("valley_end_ammeter_no not between", value1, value2, "valleyEndAmmeterNo");
            return (Criteria) this;
        }

        public Criteria andValleyTotalChargingKwhIsNull() {
            addCriterion("valley_total_charging_kwh is null");
            return (Criteria) this;
        }

        public Criteria andValleyTotalChargingKwhIsNotNull() {
            addCriterion("valley_total_charging_kwh is not null");
            return (Criteria) this;
        }

        public Criteria andValleyTotalChargingKwhEqualTo(Double value) {
            addCriterion("valley_total_charging_kwh =", value, "valleyTotalChargingKwh");
            return (Criteria) this;
        }

        public Criteria andValleyTotalChargingKwhNotEqualTo(Double value) {
            addCriterion("valley_total_charging_kwh <>", value, "valleyTotalChargingKwh");
            return (Criteria) this;
        }

        public Criteria andValleyTotalChargingKwhGreaterThan(Double value) {
            addCriterion("valley_total_charging_kwh >", value, "valleyTotalChargingKwh");
            return (Criteria) this;
        }

        public Criteria andValleyTotalChargingKwhGreaterThanOrEqualTo(Double value) {
            addCriterion("valley_total_charging_kwh >=", value, "valleyTotalChargingKwh");
            return (Criteria) this;
        }

        public Criteria andValleyTotalChargingKwhLessThan(Double value) {
            addCriterion("valley_total_charging_kwh <", value, "valleyTotalChargingKwh");
            return (Criteria) this;
        }

        public Criteria andValleyTotalChargingKwhLessThanOrEqualTo(Double value) {
            addCriterion("valley_total_charging_kwh <=", value, "valleyTotalChargingKwh");
            return (Criteria) this;
        }

        public Criteria andValleyTotalChargingKwhIn(List<Double> values) {
            addCriterion("valley_total_charging_kwh in", values, "valleyTotalChargingKwh");
            return (Criteria) this;
        }

        public Criteria andValleyTotalChargingKwhNotIn(List<Double> values) {
            addCriterion("valley_total_charging_kwh not in", values, "valleyTotalChargingKwh");
            return (Criteria) this;
        }

        public Criteria andValleyTotalChargingKwhBetween(Double value1, Double value2) {
            addCriterion("valley_total_charging_kwh between", value1, value2, "valleyTotalChargingKwh");
            return (Criteria) this;
        }

        public Criteria andValleyTotalChargingKwhNotBetween(Double value1, Double value2) {
            addCriterion("valley_total_charging_kwh not between", value1, value2, "valleyTotalChargingKwh");
            return (Criteria) this;
        }

        public Criteria andSendFlagKjIsNull() {
            addCriterion("send_flag_kj is null");
            return (Criteria) this;
        }

        public Criteria andSendFlagKjIsNotNull() {
            addCriterion("send_flag_kj is not null");
            return (Criteria) this;
        }

        public Criteria andSendFlagKjEqualTo(Integer value) {
            addCriterion("send_flag_kj =", value, "sendFlagKj");
            return (Criteria) this;
        }

        public Criteria andSendFlagKjNotEqualTo(Integer value) {
            addCriterion("send_flag_kj <>", value, "sendFlagKj");
            return (Criteria) this;
        }

        public Criteria andSendFlagKjGreaterThan(Integer value) {
            addCriterion("send_flag_kj >", value, "sendFlagKj");
            return (Criteria) this;
        }

        public Criteria andSendFlagKjGreaterThanOrEqualTo(Integer value) {
            addCriterion("send_flag_kj >=", value, "sendFlagKj");
            return (Criteria) this;
        }

        public Criteria andSendFlagKjLessThan(Integer value) {
            addCriterion("send_flag_kj <", value, "sendFlagKj");
            return (Criteria) this;
        }

        public Criteria andSendFlagKjLessThanOrEqualTo(Integer value) {
            addCriterion("send_flag_kj <=", value, "sendFlagKj");
            return (Criteria) this;
        }

        public Criteria andSendFlagKjIn(List<Integer> values) {
            addCriterion("send_flag_kj in", values, "sendFlagKj");
            return (Criteria) this;
        }

        public Criteria andSendFlagKjNotIn(List<Integer> values) {
            addCriterion("send_flag_kj not in", values, "sendFlagKj");
            return (Criteria) this;
        }

        public Criteria andSendFlagKjBetween(Integer value1, Integer value2) {
            addCriterion("send_flag_kj between", value1, value2, "sendFlagKj");
            return (Criteria) this;
        }

        public Criteria andSendFlagKjNotBetween(Integer value1, Integer value2) {
            addCriterion("send_flag_kj not between", value1, value2, "sendFlagKj");
            return (Criteria) this;
        }

        public Criteria andSendFlagOtherIsNull() {
            addCriterion("send_flag_other is null");
            return (Criteria) this;
        }

        public Criteria andSendFlagOtherIsNotNull() {
            addCriterion("send_flag_other is not null");
            return (Criteria) this;
        }

        public Criteria andSendFlagOtherEqualTo(Integer value) {
            addCriterion("send_flag_other =", value, "sendFlagOther");
            return (Criteria) this;
        }

        public Criteria andSendFlagOtherNotEqualTo(Integer value) {
            addCriterion("send_flag_other <>", value, "sendFlagOther");
            return (Criteria) this;
        }

        public Criteria andSendFlagOtherGreaterThan(Integer value) {
            addCriterion("send_flag_other >", value, "sendFlagOther");
            return (Criteria) this;
        }

        public Criteria andSendFlagOtherGreaterThanOrEqualTo(Integer value) {
            addCriterion("send_flag_other >=", value, "sendFlagOther");
            return (Criteria) this;
        }

        public Criteria andSendFlagOtherLessThan(Integer value) {
            addCriterion("send_flag_other <", value, "sendFlagOther");
            return (Criteria) this;
        }

        public Criteria andSendFlagOtherLessThanOrEqualTo(Integer value) {
            addCriterion("send_flag_other <=", value, "sendFlagOther");
            return (Criteria) this;
        }

        public Criteria andSendFlagOtherIn(List<Integer> values) {
            addCriterion("send_flag_other in", values, "sendFlagOther");
            return (Criteria) this;
        }

        public Criteria andSendFlagOtherNotIn(List<Integer> values) {
            addCriterion("send_flag_other not in", values, "sendFlagOther");
            return (Criteria) this;
        }

        public Criteria andSendFlagOtherBetween(Integer value1, Integer value2) {
            addCriterion("send_flag_other between", value1, value2, "sendFlagOther");
            return (Criteria) this;
        }

        public Criteria andSendFlagOtherNotBetween(Integer value1, Integer value2) {
            addCriterion("send_flag_other not between", value1, value2, "sendFlagOther");
            return (Criteria) this;
        }

        public Criteria andAbnormalFlagIsNull() {
            addCriterion("abnormal_flag is null");
            return (Criteria) this;
        }

        public Criteria andAbnormalFlagIsNotNull() {
            addCriterion("abnormal_flag is not null");
            return (Criteria) this;
        }

        public Criteria andAbnormalFlagEqualTo(Integer value) {
            addCriterion("abnormal_flag =", value, "abnormalFlag");
            return (Criteria) this;
        }

        public Criteria andAbnormalFlagNotEqualTo(Integer value) {
            addCriterion("abnormal_flag <>", value, "abnormalFlag");
            return (Criteria) this;
        }

        public Criteria andAbnormalFlagGreaterThan(Integer value) {
            addCriterion("abnormal_flag >", value, "abnormalFlag");
            return (Criteria) this;
        }

        public Criteria andAbnormalFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("abnormal_flag >=", value, "abnormalFlag");
            return (Criteria) this;
        }

        public Criteria andAbnormalFlagLessThan(Integer value) {
            addCriterion("abnormal_flag <", value, "abnormalFlag");
            return (Criteria) this;
        }

        public Criteria andAbnormalFlagLessThanOrEqualTo(Integer value) {
            addCriterion("abnormal_flag <=", value, "abnormalFlag");
            return (Criteria) this;
        }

        public Criteria andAbnormalFlagIn(List<Integer> values) {
            addCriterion("abnormal_flag in", values, "abnormalFlag");
            return (Criteria) this;
        }

        public Criteria andAbnormalFlagNotIn(List<Integer> values) {
            addCriterion("abnormal_flag not in", values, "abnormalFlag");
            return (Criteria) this;
        }

        public Criteria andAbnormalFlagBetween(Integer value1, Integer value2) {
            addCriterion("abnormal_flag between", value1, value2, "abnormalFlag");
            return (Criteria) this;
        }

        public Criteria andAbnormalFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("abnormal_flag not between", value1, value2, "abnormalFlag");
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