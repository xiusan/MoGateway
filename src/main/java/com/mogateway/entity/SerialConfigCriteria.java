package com.mogateway.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SerialConfigCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SerialConfigCriteria() {
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

        public Criteria andSerialNameIsNull() {
            addCriterion("serial_name is null");
            return (Criteria) this;
        }

        public Criteria andSerialNameIsNotNull() {
            addCriterion("serial_name is not null");
            return (Criteria) this;
        }

        public Criteria andSerialNameEqualTo(String value) {
            addCriterion("serial_name =", value, "serialName");
            return (Criteria) this;
        }

        public Criteria andSerialNameNotEqualTo(String value) {
            addCriterion("serial_name <>", value, "serialName");
            return (Criteria) this;
        }

        public Criteria andSerialNameGreaterThan(String value) {
            addCriterion("serial_name >", value, "serialName");
            return (Criteria) this;
        }

        public Criteria andSerialNameGreaterThanOrEqualTo(String value) {
            addCriterion("serial_name >=", value, "serialName");
            return (Criteria) this;
        }

        public Criteria andSerialNameLessThan(String value) {
            addCriterion("serial_name <", value, "serialName");
            return (Criteria) this;
        }

        public Criteria andSerialNameLessThanOrEqualTo(String value) {
            addCriterion("serial_name <=", value, "serialName");
            return (Criteria) this;
        }

        public Criteria andSerialNameLike(String value) {
            addCriterion("serial_name like", value, "serialName");
            return (Criteria) this;
        }

        public Criteria andSerialNameNotLike(String value) {
            addCriterion("serial_name not like", value, "serialName");
            return (Criteria) this;
        }

        public Criteria andSerialNameIn(List<String> values) {
            addCriterion("serial_name in", values, "serialName");
            return (Criteria) this;
        }

        public Criteria andSerialNameNotIn(List<String> values) {
            addCriterion("serial_name not in", values, "serialName");
            return (Criteria) this;
        }

        public Criteria andSerialNameBetween(String value1, String value2) {
            addCriterion("serial_name between", value1, value2, "serialName");
            return (Criteria) this;
        }

        public Criteria andSerialNameNotBetween(String value1, String value2) {
            addCriterion("serial_name not between", value1, value2, "serialName");
            return (Criteria) this;
        }

        public Criteria andSerialBaudRateIsNull() {
            addCriterion("serial_baud_rate is null");
            return (Criteria) this;
        }

        public Criteria andSerialBaudRateIsNotNull() {
            addCriterion("serial_baud_rate is not null");
            return (Criteria) this;
        }

        public Criteria andSerialBaudRateEqualTo(Integer value) {
            addCriterion("serial_baud_rate =", value, "serialBaudRate");
            return (Criteria) this;
        }

        public Criteria andSerialBaudRateNotEqualTo(Integer value) {
            addCriterion("serial_baud_rate <>", value, "serialBaudRate");
            return (Criteria) this;
        }

        public Criteria andSerialBaudRateGreaterThan(Integer value) {
            addCriterion("serial_baud_rate >", value, "serialBaudRate");
            return (Criteria) this;
        }

        public Criteria andSerialBaudRateGreaterThanOrEqualTo(Integer value) {
            addCriterion("serial_baud_rate >=", value, "serialBaudRate");
            return (Criteria) this;
        }

        public Criteria andSerialBaudRateLessThan(Integer value) {
            addCriterion("serial_baud_rate <", value, "serialBaudRate");
            return (Criteria) this;
        }

        public Criteria andSerialBaudRateLessThanOrEqualTo(Integer value) {
            addCriterion("serial_baud_rate <=", value, "serialBaudRate");
            return (Criteria) this;
        }

        public Criteria andSerialBaudRateIn(List<Integer> values) {
            addCriterion("serial_baud_rate in", values, "serialBaudRate");
            return (Criteria) this;
        }

        public Criteria andSerialBaudRateNotIn(List<Integer> values) {
            addCriterion("serial_baud_rate not in", values, "serialBaudRate");
            return (Criteria) this;
        }

        public Criteria andSerialBaudRateBetween(Integer value1, Integer value2) {
            addCriterion("serial_baud_rate between", value1, value2, "serialBaudRate");
            return (Criteria) this;
        }

        public Criteria andSerialBaudRateNotBetween(Integer value1, Integer value2) {
            addCriterion("serial_baud_rate not between", value1, value2, "serialBaudRate");
            return (Criteria) this;
        }

        public Criteria andSerialCheckoutIdIsNull() {
            addCriterion("serial_checkout_id is null");
            return (Criteria) this;
        }

        public Criteria andSerialCheckoutIdIsNotNull() {
            addCriterion("serial_checkout_id is not null");
            return (Criteria) this;
        }

        public Criteria andSerialCheckoutIdEqualTo(Boolean value) {
            addCriterion("serial_checkout_id =", value, "serialCheckoutId");
            return (Criteria) this;
        }

        public Criteria andSerialCheckoutIdNotEqualTo(Boolean value) {
            addCriterion("serial_checkout_id <>", value, "serialCheckoutId");
            return (Criteria) this;
        }

        public Criteria andSerialCheckoutIdGreaterThan(Boolean value) {
            addCriterion("serial_checkout_id >", value, "serialCheckoutId");
            return (Criteria) this;
        }

        public Criteria andSerialCheckoutIdGreaterThanOrEqualTo(Boolean value) {
            addCriterion("serial_checkout_id >=", value, "serialCheckoutId");
            return (Criteria) this;
        }

        public Criteria andSerialCheckoutIdLessThan(Boolean value) {
            addCriterion("serial_checkout_id <", value, "serialCheckoutId");
            return (Criteria) this;
        }

        public Criteria andSerialCheckoutIdLessThanOrEqualTo(Boolean value) {
            addCriterion("serial_checkout_id <=", value, "serialCheckoutId");
            return (Criteria) this;
        }

        public Criteria andSerialCheckoutIdIn(List<Boolean> values) {
            addCriterion("serial_checkout_id in", values, "serialCheckoutId");
            return (Criteria) this;
        }

        public Criteria andSerialCheckoutIdNotIn(List<Boolean> values) {
            addCriterion("serial_checkout_id not in", values, "serialCheckoutId");
            return (Criteria) this;
        }

        public Criteria andSerialCheckoutIdBetween(Boolean value1, Boolean value2) {
            addCriterion("serial_checkout_id between", value1, value2, "serialCheckoutId");
            return (Criteria) this;
        }

        public Criteria andSerialCheckoutIdNotBetween(Boolean value1, Boolean value2) {
            addCriterion("serial_checkout_id not between", value1, value2, "serialCheckoutId");
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