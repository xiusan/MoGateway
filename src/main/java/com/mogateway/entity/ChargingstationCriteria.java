package com.mogateway.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ChargingstationCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ChargingstationCriteria() {
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

        public Criteria andChargingStationIdIsNull() {
            addCriterion("charging_station__id is null");
            return (Criteria) this;
        }

        public Criteria andChargingStationIdIsNotNull() {
            addCriterion("charging_station__id is not null");
            return (Criteria) this;
        }

        public Criteria andChargingStationIdEqualTo(String value) {
            addCriterion("charging_station__id =", value, "chargingStationId");
            return (Criteria) this;
        }

        public Criteria andChargingStationIdNotEqualTo(String value) {
            addCriterion("charging_station__id <>", value, "chargingStationId");
            return (Criteria) this;
        }

        public Criteria andChargingStationIdGreaterThan(String value) {
            addCriterion("charging_station__id >", value, "chargingStationId");
            return (Criteria) this;
        }

        public Criteria andChargingStationIdGreaterThanOrEqualTo(String value) {
            addCriterion("charging_station__id >=", value, "chargingStationId");
            return (Criteria) this;
        }

        public Criteria andChargingStationIdLessThan(String value) {
            addCriterion("charging_station__id <", value, "chargingStationId");
            return (Criteria) this;
        }

        public Criteria andChargingStationIdLessThanOrEqualTo(String value) {
            addCriterion("charging_station__id <=", value, "chargingStationId");
            return (Criteria) this;
        }

        public Criteria andChargingStationIdLike(String value) {
            addCriterion("charging_station__id like", value, "chargingStationId");
            return (Criteria) this;
        }

        public Criteria andChargingStationIdNotLike(String value) {
            addCriterion("charging_station__id not like", value, "chargingStationId");
            return (Criteria) this;
        }

        public Criteria andChargingStationIdIn(List<String> values) {
            addCriterion("charging_station__id in", values, "chargingStationId");
            return (Criteria) this;
        }

        public Criteria andChargingStationIdNotIn(List<String> values) {
            addCriterion("charging_station__id not in", values, "chargingStationId");
            return (Criteria) this;
        }

        public Criteria andChargingStationIdBetween(String value1, String value2) {
            addCriterion("charging_station__id between", value1, value2, "chargingStationId");
            return (Criteria) this;
        }

        public Criteria andChargingStationIdNotBetween(String value1, String value2) {
            addCriterion("charging_station__id not between", value1, value2, "chargingStationId");
            return (Criteria) this;
        }

        public Criteria andChargingStationNameIsNull() {
            addCriterion("charging_station_name is null");
            return (Criteria) this;
        }

        public Criteria andChargingStationNameIsNotNull() {
            addCriterion("charging_station_name is not null");
            return (Criteria) this;
        }

        public Criteria andChargingStationNameEqualTo(String value) {
            addCriterion("charging_station_name =", value, "chargingStationName");
            return (Criteria) this;
        }

        public Criteria andChargingStationNameNotEqualTo(String value) {
            addCriterion("charging_station_name <>", value, "chargingStationName");
            return (Criteria) this;
        }

        public Criteria andChargingStationNameGreaterThan(String value) {
            addCriterion("charging_station_name >", value, "chargingStationName");
            return (Criteria) this;
        }

        public Criteria andChargingStationNameGreaterThanOrEqualTo(String value) {
            addCriterion("charging_station_name >=", value, "chargingStationName");
            return (Criteria) this;
        }

        public Criteria andChargingStationNameLessThan(String value) {
            addCriterion("charging_station_name <", value, "chargingStationName");
            return (Criteria) this;
        }

        public Criteria andChargingStationNameLessThanOrEqualTo(String value) {
            addCriterion("charging_station_name <=", value, "chargingStationName");
            return (Criteria) this;
        }

        public Criteria andChargingStationNameLike(String value) {
            addCriterion("charging_station_name like", value, "chargingStationName");
            return (Criteria) this;
        }

        public Criteria andChargingStationNameNotLike(String value) {
            addCriterion("charging_station_name not like", value, "chargingStationName");
            return (Criteria) this;
        }

        public Criteria andChargingStationNameIn(List<String> values) {
            addCriterion("charging_station_name in", values, "chargingStationName");
            return (Criteria) this;
        }

        public Criteria andChargingStationNameNotIn(List<String> values) {
            addCriterion("charging_station_name not in", values, "chargingStationName");
            return (Criteria) this;
        }

        public Criteria andChargingStationNameBetween(String value1, String value2) {
            addCriterion("charging_station_name between", value1, value2, "chargingStationName");
            return (Criteria) this;
        }

        public Criteria andChargingStationNameNotBetween(String value1, String value2) {
            addCriterion("charging_station_name not between", value1, value2, "chargingStationName");
            return (Criteria) this;
        }

        public Criteria andChargingStationAddrIsNull() {
            addCriterion("charging_station_addr is null");
            return (Criteria) this;
        }

        public Criteria andChargingStationAddrIsNotNull() {
            addCriterion("charging_station_addr is not null");
            return (Criteria) this;
        }

        public Criteria andChargingStationAddrEqualTo(String value) {
            addCriterion("charging_station_addr =", value, "chargingStationAddr");
            return (Criteria) this;
        }

        public Criteria andChargingStationAddrNotEqualTo(String value) {
            addCriterion("charging_station_addr <>", value, "chargingStationAddr");
            return (Criteria) this;
        }

        public Criteria andChargingStationAddrGreaterThan(String value) {
            addCriterion("charging_station_addr >", value, "chargingStationAddr");
            return (Criteria) this;
        }

        public Criteria andChargingStationAddrGreaterThanOrEqualTo(String value) {
            addCriterion("charging_station_addr >=", value, "chargingStationAddr");
            return (Criteria) this;
        }

        public Criteria andChargingStationAddrLessThan(String value) {
            addCriterion("charging_station_addr <", value, "chargingStationAddr");
            return (Criteria) this;
        }

        public Criteria andChargingStationAddrLessThanOrEqualTo(String value) {
            addCriterion("charging_station_addr <=", value, "chargingStationAddr");
            return (Criteria) this;
        }

        public Criteria andChargingStationAddrLike(String value) {
            addCriterion("charging_station_addr like", value, "chargingStationAddr");
            return (Criteria) this;
        }

        public Criteria andChargingStationAddrNotLike(String value) {
            addCriterion("charging_station_addr not like", value, "chargingStationAddr");
            return (Criteria) this;
        }

        public Criteria andChargingStationAddrIn(List<String> values) {
            addCriterion("charging_station_addr in", values, "chargingStationAddr");
            return (Criteria) this;
        }

        public Criteria andChargingStationAddrNotIn(List<String> values) {
            addCriterion("charging_station_addr not in", values, "chargingStationAddr");
            return (Criteria) this;
        }

        public Criteria andChargingStationAddrBetween(String value1, String value2) {
            addCriterion("charging_station_addr between", value1, value2, "chargingStationAddr");
            return (Criteria) this;
        }

        public Criteria andChargingStationAddrNotBetween(String value1, String value2) {
            addCriterion("charging_station_addr not between", value1, value2, "chargingStationAddr");
            return (Criteria) this;
        }

        public Criteria andEnabledIsNull() {
            addCriterion("enabled is null");
            return (Criteria) this;
        }

        public Criteria andEnabledIsNotNull() {
            addCriterion("enabled is not null");
            return (Criteria) this;
        }

        public Criteria andEnabledEqualTo(Boolean value) {
            addCriterion("enabled =", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledNotEqualTo(Boolean value) {
            addCriterion("enabled <>", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledGreaterThan(Boolean value) {
            addCriterion("enabled >", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledGreaterThanOrEqualTo(Boolean value) {
            addCriterion("enabled >=", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledLessThan(Boolean value) {
            addCriterion("enabled <", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledLessThanOrEqualTo(Boolean value) {
            addCriterion("enabled <=", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledIn(List<Boolean> values) {
            addCriterion("enabled in", values, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledNotIn(List<Boolean> values) {
            addCriterion("enabled not in", values, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledBetween(Boolean value1, Boolean value2) {
            addCriterion("enabled between", value1, value2, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledNotBetween(Boolean value1, Boolean value2) {
            addCriterion("enabled not between", value1, value2, "enabled");
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