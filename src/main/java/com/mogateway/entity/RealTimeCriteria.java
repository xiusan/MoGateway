package com.mogateway.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class RealTimeCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RealTimeCriteria() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andCommunicateStatusIsNull() {
            addCriterion("communicate_status is null");
            return (Criteria) this;
        }

        public Criteria andCommunicateStatusIsNotNull() {
            addCriterion("communicate_status is not null");
            return (Criteria) this;
        }

        public Criteria andCommunicateStatusEqualTo(Integer value) {
            addCriterion("communicate_status =", value, "communicateStatus");
            return (Criteria) this;
        }

        public Criteria andCommunicateStatusNotEqualTo(Integer value) {
            addCriterion("communicate_status <>", value, "communicateStatus");
            return (Criteria) this;
        }

        public Criteria andCommunicateStatusGreaterThan(Integer value) {
            addCriterion("communicate_status >", value, "communicateStatus");
            return (Criteria) this;
        }

        public Criteria andCommunicateStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("communicate_status >=", value, "communicateStatus");
            return (Criteria) this;
        }

        public Criteria andCommunicateStatusLessThan(Integer value) {
            addCriterion("communicate_status <", value, "communicateStatus");
            return (Criteria) this;
        }

        public Criteria andCommunicateStatusLessThanOrEqualTo(Integer value) {
            addCriterion("communicate_status <=", value, "communicateStatus");
            return (Criteria) this;
        }

        public Criteria andCommunicateStatusIn(List<Integer> values) {
            addCriterion("communicate_status in", values, "communicateStatus");
            return (Criteria) this;
        }

        public Criteria andCommunicateStatusNotIn(List<Integer> values) {
            addCriterion("communicate_status not in", values, "communicateStatus");
            return (Criteria) this;
        }

        public Criteria andCommunicateStatusBetween(Integer value1, Integer value2) {
            addCriterion("communicate_status between", value1, value2, "communicateStatus");
            return (Criteria) this;
        }

        public Criteria andCommunicateStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("communicate_status not between", value1, value2, "communicateStatus");
            return (Criteria) this;
        }

        public Criteria andWorkStatusIsNull() {
            addCriterion("work_status is null");
            return (Criteria) this;
        }

        public Criteria andWorkStatusIsNotNull() {
            addCriterion("work_status is not null");
            return (Criteria) this;
        }

        public Criteria andWorkStatusEqualTo(Integer value) {
            addCriterion("work_status =", value, "workStatus");
            return (Criteria) this;
        }

        public Criteria andWorkStatusNotEqualTo(Integer value) {
            addCriterion("work_status <>", value, "workStatus");
            return (Criteria) this;
        }

        public Criteria andWorkStatusGreaterThan(Integer value) {
            addCriterion("work_status >", value, "workStatus");
            return (Criteria) this;
        }

        public Criteria andWorkStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("work_status >=", value, "workStatus");
            return (Criteria) this;
        }

        public Criteria andWorkStatusLessThan(Integer value) {
            addCriterion("work_status <", value, "workStatus");
            return (Criteria) this;
        }

        public Criteria andWorkStatusLessThanOrEqualTo(Integer value) {
            addCriterion("work_status <=", value, "workStatus");
            return (Criteria) this;
        }

        public Criteria andWorkStatusIn(List<Integer> values) {
            addCriterion("work_status in", values, "workStatus");
            return (Criteria) this;
        }

        public Criteria andWorkStatusNotIn(List<Integer> values) {
            addCriterion("work_status not in", values, "workStatus");
            return (Criteria) this;
        }

        public Criteria andWorkStatusBetween(Integer value1, Integer value2) {
            addCriterion("work_status between", value1, value2, "workStatus");
            return (Criteria) this;
        }

        public Criteria andWorkStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("work_status not between", value1, value2, "workStatus");
            return (Criteria) this;
        }

        public Criteria andChargingGunStatusIsNull() {
            addCriterion("charging_gun_status is null");
            return (Criteria) this;
        }

        public Criteria andChargingGunStatusIsNotNull() {
            addCriterion("charging_gun_status is not null");
            return (Criteria) this;
        }

        public Criteria andChargingGunStatusEqualTo(Integer value) {
            addCriterion("charging_gun_status =", value, "chargingGunStatus");
            return (Criteria) this;
        }

        public Criteria andChargingGunStatusNotEqualTo(Integer value) {
            addCriterion("charging_gun_status <>", value, "chargingGunStatus");
            return (Criteria) this;
        }

        public Criteria andChargingGunStatusGreaterThan(Integer value) {
            addCriterion("charging_gun_status >", value, "chargingGunStatus");
            return (Criteria) this;
        }

        public Criteria andChargingGunStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("charging_gun_status >=", value, "chargingGunStatus");
            return (Criteria) this;
        }

        public Criteria andChargingGunStatusLessThan(Integer value) {
            addCriterion("charging_gun_status <", value, "chargingGunStatus");
            return (Criteria) this;
        }

        public Criteria andChargingGunStatusLessThanOrEqualTo(Integer value) {
            addCriterion("charging_gun_status <=", value, "chargingGunStatus");
            return (Criteria) this;
        }

        public Criteria andChargingGunStatusIn(List<Integer> values) {
            addCriterion("charging_gun_status in", values, "chargingGunStatus");
            return (Criteria) this;
        }

        public Criteria andChargingGunStatusNotIn(List<Integer> values) {
            addCriterion("charging_gun_status not in", values, "chargingGunStatus");
            return (Criteria) this;
        }

        public Criteria andChargingGunStatusBetween(Integer value1, Integer value2) {
            addCriterion("charging_gun_status between", value1, value2, "chargingGunStatus");
            return (Criteria) this;
        }

        public Criteria andChargingGunStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("charging_gun_status not between", value1, value2, "chargingGunStatus");
            return (Criteria) this;
        }

        public Criteria andOutputVoltageIsNull() {
            addCriterion("output_voltage is null");
            return (Criteria) this;
        }

        public Criteria andOutputVoltageIsNotNull() {
            addCriterion("output_voltage is not null");
            return (Criteria) this;
        }

        public Criteria andOutputVoltageEqualTo(Double value) {
            addCriterion("output_voltage =", value, "outputVoltage");
            return (Criteria) this;
        }

        public Criteria andOutputVoltageNotEqualTo(Double value) {
            addCriterion("output_voltage <>", value, "outputVoltage");
            return (Criteria) this;
        }

        public Criteria andOutputVoltageGreaterThan(Double value) {
            addCriterion("output_voltage >", value, "outputVoltage");
            return (Criteria) this;
        }

        public Criteria andOutputVoltageGreaterThanOrEqualTo(Double value) {
            addCriterion("output_voltage >=", value, "outputVoltage");
            return (Criteria) this;
        }

        public Criteria andOutputVoltageLessThan(Double value) {
            addCriterion("output_voltage <", value, "outputVoltage");
            return (Criteria) this;
        }

        public Criteria andOutputVoltageLessThanOrEqualTo(Double value) {
            addCriterion("output_voltage <=", value, "outputVoltage");
            return (Criteria) this;
        }

        public Criteria andOutputVoltageIn(List<Double> values) {
            addCriterion("output_voltage in", values, "outputVoltage");
            return (Criteria) this;
        }

        public Criteria andOutputVoltageNotIn(List<Double> values) {
            addCriterion("output_voltage not in", values, "outputVoltage");
            return (Criteria) this;
        }

        public Criteria andOutputVoltageBetween(Double value1, Double value2) {
            addCriterion("output_voltage between", value1, value2, "outputVoltage");
            return (Criteria) this;
        }

        public Criteria andOutputVoltageNotBetween(Double value1, Double value2) {
            addCriterion("output_voltage not between", value1, value2, "outputVoltage");
            return (Criteria) this;
        }

        public Criteria andOutputCurrentIsNull() {
            addCriterion("output_current is null");
            return (Criteria) this;
        }

        public Criteria andOutputCurrentIsNotNull() {
            addCriterion("output_current is not null");
            return (Criteria) this;
        }

        public Criteria andOutputCurrentEqualTo(Double value) {
            addCriterion("output_current =", value, "outputCurrent");
            return (Criteria) this;
        }

        public Criteria andOutputCurrentNotEqualTo(Double value) {
            addCriterion("output_current <>", value, "outputCurrent");
            return (Criteria) this;
        }

        public Criteria andOutputCurrentGreaterThan(Double value) {
            addCriterion("output_current >", value, "outputCurrent");
            return (Criteria) this;
        }

        public Criteria andOutputCurrentGreaterThanOrEqualTo(Double value) {
            addCriterion("output_current >=", value, "outputCurrent");
            return (Criteria) this;
        }

        public Criteria andOutputCurrentLessThan(Double value) {
            addCriterion("output_current <", value, "outputCurrent");
            return (Criteria) this;
        }

        public Criteria andOutputCurrentLessThanOrEqualTo(Double value) {
            addCriterion("output_current <=", value, "outputCurrent");
            return (Criteria) this;
        }

        public Criteria andOutputCurrentIn(List<Double> values) {
            addCriterion("output_current in", values, "outputCurrent");
            return (Criteria) this;
        }

        public Criteria andOutputCurrentNotIn(List<Double> values) {
            addCriterion("output_current not in", values, "outputCurrent");
            return (Criteria) this;
        }

        public Criteria andOutputCurrentBetween(Double value1, Double value2) {
            addCriterion("output_current between", value1, value2, "outputCurrent");
            return (Criteria) this;
        }

        public Criteria andOutputCurrentNotBetween(Double value1, Double value2) {
            addCriterion("output_current not between", value1, value2, "outputCurrent");
            return (Criteria) this;
        }

        public Criteria andOutputPowerIsNull() {
            addCriterion("output_power is null");
            return (Criteria) this;
        }

        public Criteria andOutputPowerIsNotNull() {
            addCriterion("output_power is not null");
            return (Criteria) this;
        }

        public Criteria andOutputPowerEqualTo(Double value) {
            addCriterion("output_power =", value, "outputPower");
            return (Criteria) this;
        }

        public Criteria andOutputPowerNotEqualTo(Double value) {
            addCriterion("output_power <>", value, "outputPower");
            return (Criteria) this;
        }

        public Criteria andOutputPowerGreaterThan(Double value) {
            addCriterion("output_power >", value, "outputPower");
            return (Criteria) this;
        }

        public Criteria andOutputPowerGreaterThanOrEqualTo(Double value) {
            addCriterion("output_power >=", value, "outputPower");
            return (Criteria) this;
        }

        public Criteria andOutputPowerLessThan(Double value) {
            addCriterion("output_power <", value, "outputPower");
            return (Criteria) this;
        }

        public Criteria andOutputPowerLessThanOrEqualTo(Double value) {
            addCriterion("output_power <=", value, "outputPower");
            return (Criteria) this;
        }

        public Criteria andOutputPowerIn(List<Double> values) {
            addCriterion("output_power in", values, "outputPower");
            return (Criteria) this;
        }

        public Criteria andOutputPowerNotIn(List<Double> values) {
            addCriterion("output_power not in", values, "outputPower");
            return (Criteria) this;
        }

        public Criteria andOutputPowerBetween(Double value1, Double value2) {
            addCriterion("output_power between", value1, value2, "outputPower");
            return (Criteria) this;
        }

        public Criteria andOutputPowerNotBetween(Double value1, Double value2) {
            addCriterion("output_power not between", value1, value2, "outputPower");
            return (Criteria) this;
        }

        public Criteria andAmmeterNoIsNull() {
            addCriterion("ammeter_no is null");
            return (Criteria) this;
        }

        public Criteria andAmmeterNoIsNotNull() {
            addCriterion("ammeter_no is not null");
            return (Criteria) this;
        }

        public Criteria andAmmeterNoEqualTo(Double value) {
            addCriterion("ammeter_no =", value, "ammeterNo");
            return (Criteria) this;
        }

        public Criteria andAmmeterNoNotEqualTo(Double value) {
            addCriterion("ammeter_no <>", value, "ammeterNo");
            return (Criteria) this;
        }

        public Criteria andAmmeterNoGreaterThan(Double value) {
            addCriterion("ammeter_no >", value, "ammeterNo");
            return (Criteria) this;
        }

        public Criteria andAmmeterNoGreaterThanOrEqualTo(Double value) {
            addCriterion("ammeter_no >=", value, "ammeterNo");
            return (Criteria) this;
        }

        public Criteria andAmmeterNoLessThan(Double value) {
            addCriterion("ammeter_no <", value, "ammeterNo");
            return (Criteria) this;
        }

        public Criteria andAmmeterNoLessThanOrEqualTo(Double value) {
            addCriterion("ammeter_no <=", value, "ammeterNo");
            return (Criteria) this;
        }

        public Criteria andAmmeterNoIn(List<Double> values) {
            addCriterion("ammeter_no in", values, "ammeterNo");
            return (Criteria) this;
        }

        public Criteria andAmmeterNoNotIn(List<Double> values) {
            addCriterion("ammeter_no not in", values, "ammeterNo");
            return (Criteria) this;
        }

        public Criteria andAmmeterNoBetween(Double value1, Double value2) {
            addCriterion("ammeter_no between", value1, value2, "ammeterNo");
            return (Criteria) this;
        }

        public Criteria andAmmeterNoNotBetween(Double value1, Double value2) {
            addCriterion("ammeter_no not between", value1, value2, "ammeterNo");
            return (Criteria) this;
        }

        public Criteria andCurrentSocIsNull() {
            addCriterion("current_soc is null");
            return (Criteria) this;
        }

        public Criteria andCurrentSocIsNotNull() {
            addCriterion("current_soc is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentSocEqualTo(Double value) {
            addCriterion("current_soc =", value, "currentSoc");
            return (Criteria) this;
        }

        public Criteria andCurrentSocNotEqualTo(Double value) {
            addCriterion("current_soc <>", value, "currentSoc");
            return (Criteria) this;
        }

        public Criteria andCurrentSocGreaterThan(Double value) {
            addCriterion("current_soc >", value, "currentSoc");
            return (Criteria) this;
        }

        public Criteria andCurrentSocGreaterThanOrEqualTo(Double value) {
            addCriterion("current_soc >=", value, "currentSoc");
            return (Criteria) this;
        }

        public Criteria andCurrentSocLessThan(Double value) {
            addCriterion("current_soc <", value, "currentSoc");
            return (Criteria) this;
        }

        public Criteria andCurrentSocLessThanOrEqualTo(Double value) {
            addCriterion("current_soc <=", value, "currentSoc");
            return (Criteria) this;
        }

        public Criteria andCurrentSocIn(List<Double> values) {
            addCriterion("current_soc in", values, "currentSoc");
            return (Criteria) this;
        }

        public Criteria andCurrentSocNotIn(List<Double> values) {
            addCriterion("current_soc not in", values, "currentSoc");
            return (Criteria) this;
        }

        public Criteria andCurrentSocBetween(Double value1, Double value2) {
            addCriterion("current_soc between", value1, value2, "currentSoc");
            return (Criteria) this;
        }

        public Criteria andCurrentSocNotBetween(Double value1, Double value2) {
            addCriterion("current_soc not between", value1, value2, "currentSoc");
            return (Criteria) this;
        }

        public Criteria andFaultStatusIsNull() {
            addCriterion("fault_status is null");
            return (Criteria) this;
        }

        public Criteria andFaultStatusIsNotNull() {
            addCriterion("fault_status is not null");
            return (Criteria) this;
        }

        public Criteria andFaultStatusEqualTo(Integer value) {
            addCriterion("fault_status =", value, "faultStatus");
            return (Criteria) this;
        }

        public Criteria andFaultStatusNotEqualTo(Integer value) {
            addCriterion("fault_status <>", value, "faultStatus");
            return (Criteria) this;
        }

        public Criteria andFaultStatusGreaterThan(Integer value) {
            addCriterion("fault_status >", value, "faultStatus");
            return (Criteria) this;
        }

        public Criteria andFaultStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("fault_status >=", value, "faultStatus");
            return (Criteria) this;
        }

        public Criteria andFaultStatusLessThan(Integer value) {
            addCriterion("fault_status <", value, "faultStatus");
            return (Criteria) this;
        }

        public Criteria andFaultStatusLessThanOrEqualTo(Integer value) {
            addCriterion("fault_status <=", value, "faultStatus");
            return (Criteria) this;
        }

        public Criteria andFaultStatusIn(List<Integer> values) {
            addCriterion("fault_status in", values, "faultStatus");
            return (Criteria) this;
        }

        public Criteria andFaultStatusNotIn(List<Integer> values) {
            addCriterion("fault_status not in", values, "faultStatus");
            return (Criteria) this;
        }

        public Criteria andFaultStatusBetween(Integer value1, Integer value2) {
            addCriterion("fault_status between", value1, value2, "faultStatus");
            return (Criteria) this;
        }

        public Criteria andFaultStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("fault_status not between", value1, value2, "faultStatus");
            return (Criteria) this;
        }

        public Criteria andFaultDescIsNull() {
            addCriterion("fault_desc is null");
            return (Criteria) this;
        }

        public Criteria andFaultDescIsNotNull() {
            addCriterion("fault_desc is not null");
            return (Criteria) this;
        }

        public Criteria andFaultDescEqualTo(String value) {
            addCriterion("fault_desc =", value, "faultDesc");
            return (Criteria) this;
        }

        public Criteria andFaultDescNotEqualTo(String value) {
            addCriterion("fault_desc <>", value, "faultDesc");
            return (Criteria) this;
        }

        public Criteria andFaultDescGreaterThan(String value) {
            addCriterion("fault_desc >", value, "faultDesc");
            return (Criteria) this;
        }

        public Criteria andFaultDescGreaterThanOrEqualTo(String value) {
            addCriterion("fault_desc >=", value, "faultDesc");
            return (Criteria) this;
        }

        public Criteria andFaultDescLessThan(String value) {
            addCriterion("fault_desc <", value, "faultDesc");
            return (Criteria) this;
        }

        public Criteria andFaultDescLessThanOrEqualTo(String value) {
            addCriterion("fault_desc <=", value, "faultDesc");
            return (Criteria) this;
        }

        public Criteria andFaultDescLike(String value) {
            addCriterion("fault_desc like", value, "faultDesc");
            return (Criteria) this;
        }

        public Criteria andFaultDescNotLike(String value) {
            addCriterion("fault_desc not like", value, "faultDesc");
            return (Criteria) this;
        }

        public Criteria andFaultDescIn(List<String> values) {
            addCriterion("fault_desc in", values, "faultDesc");
            return (Criteria) this;
        }

        public Criteria andFaultDescNotIn(List<String> values) {
            addCriterion("fault_desc not in", values, "faultDesc");
            return (Criteria) this;
        }

        public Criteria andFaultDescBetween(String value1, String value2) {
            addCriterion("fault_desc between", value1, value2, "faultDesc");
            return (Criteria) this;
        }

        public Criteria andFaultDescNotBetween(String value1, String value2) {
            addCriterion("fault_desc not between", value1, value2, "faultDesc");
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
            addCriterionForJDBCDate("start_charging_dttm =", value, "startChargingDttm");
            return (Criteria) this;
        }

        public Criteria andStartChargingDttmNotEqualTo(Date value) {
            addCriterionForJDBCDate("start_charging_dttm <>", value, "startChargingDttm");
            return (Criteria) this;
        }

        public Criteria andStartChargingDttmGreaterThan(Date value) {
            addCriterionForJDBCDate("start_charging_dttm >", value, "startChargingDttm");
            return (Criteria) this;
        }

        public Criteria andStartChargingDttmGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("start_charging_dttm >=", value, "startChargingDttm");
            return (Criteria) this;
        }

        public Criteria andStartChargingDttmLessThan(Date value) {
            addCriterionForJDBCDate("start_charging_dttm <", value, "startChargingDttm");
            return (Criteria) this;
        }

        public Criteria andStartChargingDttmLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("start_charging_dttm <=", value, "startChargingDttm");
            return (Criteria) this;
        }

        public Criteria andStartChargingDttmIn(List<Date> values) {
            addCriterionForJDBCDate("start_charging_dttm in", values, "startChargingDttm");
            return (Criteria) this;
        }

        public Criteria andStartChargingDttmNotIn(List<Date> values) {
            addCriterionForJDBCDate("start_charging_dttm not in", values, "startChargingDttm");
            return (Criteria) this;
        }

        public Criteria andStartChargingDttmBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("start_charging_dttm between", value1, value2, "startChargingDttm");
            return (Criteria) this;
        }

        public Criteria andStartChargingDttmNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("start_charging_dttm not between", value1, value2, "startChargingDttm");
            return (Criteria) this;
        }

        public Criteria andChargedTimeIsNull() {
            addCriterion("charged_time is null");
            return (Criteria) this;
        }

        public Criteria andChargedTimeIsNotNull() {
            addCriterion("charged_time is not null");
            return (Criteria) this;
        }

        public Criteria andChargedTimeEqualTo(String value) {
            addCriterion("charged_time =", value, "chargedTime");
            return (Criteria) this;
        }

        public Criteria andChargedTimeNotEqualTo(String value) {
            addCriterion("charged_time <>", value, "chargedTime");
            return (Criteria) this;
        }

        public Criteria andChargedTimeGreaterThan(String value) {
            addCriterion("charged_time >", value, "chargedTime");
            return (Criteria) this;
        }

        public Criteria andChargedTimeGreaterThanOrEqualTo(String value) {
            addCriterion("charged_time >=", value, "chargedTime");
            return (Criteria) this;
        }

        public Criteria andChargedTimeLessThan(String value) {
            addCriterion("charged_time <", value, "chargedTime");
            return (Criteria) this;
        }

        public Criteria andChargedTimeLessThanOrEqualTo(String value) {
            addCriterion("charged_time <=", value, "chargedTime");
            return (Criteria) this;
        }

        public Criteria andChargedTimeLike(String value) {
            addCriterion("charged_time like", value, "chargedTime");
            return (Criteria) this;
        }

        public Criteria andChargedTimeNotLike(String value) {
            addCriterion("charged_time not like", value, "chargedTime");
            return (Criteria) this;
        }

        public Criteria andChargedTimeIn(List<String> values) {
            addCriterion("charged_time in", values, "chargedTime");
            return (Criteria) this;
        }

        public Criteria andChargedTimeNotIn(List<String> values) {
            addCriterion("charged_time not in", values, "chargedTime");
            return (Criteria) this;
        }

        public Criteria andChargedTimeBetween(String value1, String value2) {
            addCriterion("charged_time between", value1, value2, "chargedTime");
            return (Criteria) this;
        }

        public Criteria andChargedTimeNotBetween(String value1, String value2) {
            addCriterion("charged_time not between", value1, value2, "chargedTime");
            return (Criteria) this;
        }

        public Criteria andStartChargingAmmeterNoIsNull() {
            addCriterion("start_charging_ammeter_no is null");
            return (Criteria) this;
        }

        public Criteria andStartChargingAmmeterNoIsNotNull() {
            addCriterion("start_charging_ammeter_no is not null");
            return (Criteria) this;
        }

        public Criteria andStartChargingAmmeterNoEqualTo(Double value) {
            addCriterion("start_charging_ammeter_no =", value, "startChargingAmmeterNo");
            return (Criteria) this;
        }

        public Criteria andStartChargingAmmeterNoNotEqualTo(Double value) {
            addCriterion("start_charging_ammeter_no <>", value, "startChargingAmmeterNo");
            return (Criteria) this;
        }

        public Criteria andStartChargingAmmeterNoGreaterThan(Double value) {
            addCriterion("start_charging_ammeter_no >", value, "startChargingAmmeterNo");
            return (Criteria) this;
        }

        public Criteria andStartChargingAmmeterNoGreaterThanOrEqualTo(Double value) {
            addCriterion("start_charging_ammeter_no >=", value, "startChargingAmmeterNo");
            return (Criteria) this;
        }

        public Criteria andStartChargingAmmeterNoLessThan(Double value) {
            addCriterion("start_charging_ammeter_no <", value, "startChargingAmmeterNo");
            return (Criteria) this;
        }

        public Criteria andStartChargingAmmeterNoLessThanOrEqualTo(Double value) {
            addCriterion("start_charging_ammeter_no <=", value, "startChargingAmmeterNo");
            return (Criteria) this;
        }

        public Criteria andStartChargingAmmeterNoIn(List<Double> values) {
            addCriterion("start_charging_ammeter_no in", values, "startChargingAmmeterNo");
            return (Criteria) this;
        }

        public Criteria andStartChargingAmmeterNoNotIn(List<Double> values) {
            addCriterion("start_charging_ammeter_no not in", values, "startChargingAmmeterNo");
            return (Criteria) this;
        }

        public Criteria andStartChargingAmmeterNoBetween(Double value1, Double value2) {
            addCriterion("start_charging_ammeter_no between", value1, value2, "startChargingAmmeterNo");
            return (Criteria) this;
        }

        public Criteria andStartChargingAmmeterNoNotBetween(Double value1, Double value2) {
            addCriterion("start_charging_ammeter_no not between", value1, value2, "startChargingAmmeterNo");
            return (Criteria) this;
        }

        public Criteria andHardwareVersionIsNull() {
            addCriterion("hardware_version is null");
            return (Criteria) this;
        }

        public Criteria andHardwareVersionIsNotNull() {
            addCriterion("hardware_version is not null");
            return (Criteria) this;
        }

        public Criteria andHardwareVersionEqualTo(String value) {
            addCriterion("hardware_version =", value, "hardwareVersion");
            return (Criteria) this;
        }

        public Criteria andHardwareVersionNotEqualTo(String value) {
            addCriterion("hardware_version <>", value, "hardwareVersion");
            return (Criteria) this;
        }

        public Criteria andHardwareVersionGreaterThan(String value) {
            addCriterion("hardware_version >", value, "hardwareVersion");
            return (Criteria) this;
        }

        public Criteria andHardwareVersionGreaterThanOrEqualTo(String value) {
            addCriterion("hardware_version >=", value, "hardwareVersion");
            return (Criteria) this;
        }

        public Criteria andHardwareVersionLessThan(String value) {
            addCriterion("hardware_version <", value, "hardwareVersion");
            return (Criteria) this;
        }

        public Criteria andHardwareVersionLessThanOrEqualTo(String value) {
            addCriterion("hardware_version <=", value, "hardwareVersion");
            return (Criteria) this;
        }

        public Criteria andHardwareVersionLike(String value) {
            addCriterion("hardware_version like", value, "hardwareVersion");
            return (Criteria) this;
        }

        public Criteria andHardwareVersionNotLike(String value) {
            addCriterion("hardware_version not like", value, "hardwareVersion");
            return (Criteria) this;
        }

        public Criteria andHardwareVersionIn(List<String> values) {
            addCriterion("hardware_version in", values, "hardwareVersion");
            return (Criteria) this;
        }

        public Criteria andHardwareVersionNotIn(List<String> values) {
            addCriterion("hardware_version not in", values, "hardwareVersion");
            return (Criteria) this;
        }

        public Criteria andHardwareVersionBetween(String value1, String value2) {
            addCriterion("hardware_version between", value1, value2, "hardwareVersion");
            return (Criteria) this;
        }

        public Criteria andHardwareVersionNotBetween(String value1, String value2) {
            addCriterion("hardware_version not between", value1, value2, "hardwareVersion");
            return (Criteria) this;
        }

        public Criteria andSoftwareVersionIsNull() {
            addCriterion("software_version is null");
            return (Criteria) this;
        }

        public Criteria andSoftwareVersionIsNotNull() {
            addCriterion("software_version is not null");
            return (Criteria) this;
        }

        public Criteria andSoftwareVersionEqualTo(String value) {
            addCriterion("software_version =", value, "softwareVersion");
            return (Criteria) this;
        }

        public Criteria andSoftwareVersionNotEqualTo(String value) {
            addCriterion("software_version <>", value, "softwareVersion");
            return (Criteria) this;
        }

        public Criteria andSoftwareVersionGreaterThan(String value) {
            addCriterion("software_version >", value, "softwareVersion");
            return (Criteria) this;
        }

        public Criteria andSoftwareVersionGreaterThanOrEqualTo(String value) {
            addCriterion("software_version >=", value, "softwareVersion");
            return (Criteria) this;
        }

        public Criteria andSoftwareVersionLessThan(String value) {
            addCriterion("software_version <", value, "softwareVersion");
            return (Criteria) this;
        }

        public Criteria andSoftwareVersionLessThanOrEqualTo(String value) {
            addCriterion("software_version <=", value, "softwareVersion");
            return (Criteria) this;
        }

        public Criteria andSoftwareVersionLike(String value) {
            addCriterion("software_version like", value, "softwareVersion");
            return (Criteria) this;
        }

        public Criteria andSoftwareVersionNotLike(String value) {
            addCriterion("software_version not like", value, "softwareVersion");
            return (Criteria) this;
        }

        public Criteria andSoftwareVersionIn(List<String> values) {
            addCriterion("software_version in", values, "softwareVersion");
            return (Criteria) this;
        }

        public Criteria andSoftwareVersionNotIn(List<String> values) {
            addCriterion("software_version not in", values, "softwareVersion");
            return (Criteria) this;
        }

        public Criteria andSoftwareVersionBetween(String value1, String value2) {
            addCriterion("software_version between", value1, value2, "softwareVersion");
            return (Criteria) this;
        }

        public Criteria andSoftwareVersionNotBetween(String value1, String value2) {
            addCriterion("software_version not between", value1, value2, "softwareVersion");
            return (Criteria) this;
        }

        public Criteria andChargedKwhIsNull() {
            addCriterion("charged_kwh is null");
            return (Criteria) this;
        }

        public Criteria andChargedKwhIsNotNull() {
            addCriterion("charged_kwh is not null");
            return (Criteria) this;
        }

        public Criteria andChargedKwhEqualTo(Double value) {
            addCriterion("charged_kwh =", value, "chargedKwh");
            return (Criteria) this;
        }

        public Criteria andChargedKwhNotEqualTo(Double value) {
            addCriterion("charged_kwh <>", value, "chargedKwh");
            return (Criteria) this;
        }

        public Criteria andChargedKwhGreaterThan(Double value) {
            addCriterion("charged_kwh >", value, "chargedKwh");
            return (Criteria) this;
        }

        public Criteria andChargedKwhGreaterThanOrEqualTo(Double value) {
            addCriterion("charged_kwh >=", value, "chargedKwh");
            return (Criteria) this;
        }

        public Criteria andChargedKwhLessThan(Double value) {
            addCriterion("charged_kwh <", value, "chargedKwh");
            return (Criteria) this;
        }

        public Criteria andChargedKwhLessThanOrEqualTo(Double value) {
            addCriterion("charged_kwh <=", value, "chargedKwh");
            return (Criteria) this;
        }

        public Criteria andChargedKwhIn(List<Double> values) {
            addCriterion("charged_kwh in", values, "chargedKwh");
            return (Criteria) this;
        }

        public Criteria andChargedKwhNotIn(List<Double> values) {
            addCriterion("charged_kwh not in", values, "chargedKwh");
            return (Criteria) this;
        }

        public Criteria andChargedKwhBetween(Double value1, Double value2) {
            addCriterion("charged_kwh between", value1, value2, "chargedKwh");
            return (Criteria) this;
        }

        public Criteria andChargedKwhNotBetween(Double value1, Double value2) {
            addCriterion("charged_kwh not between", value1, value2, "chargedKwh");
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