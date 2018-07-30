package com.mogateway.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AmmeterCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AmmeterCriteria() {
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

        public Criteria andAmmeterNameIsNull() {
            addCriterion("ammeter_name is null");
            return (Criteria) this;
        }

        public Criteria andAmmeterNameIsNotNull() {
            addCriterion("ammeter_name is not null");
            return (Criteria) this;
        }

        public Criteria andAmmeterNameEqualTo(String value) {
            addCriterion("ammeter_name =", value, "ammeterName");
            return (Criteria) this;
        }

        public Criteria andAmmeterNameNotEqualTo(String value) {
            addCriterion("ammeter_name <>", value, "ammeterName");
            return (Criteria) this;
        }

        public Criteria andAmmeterNameGreaterThan(String value) {
            addCriterion("ammeter_name >", value, "ammeterName");
            return (Criteria) this;
        }

        public Criteria andAmmeterNameGreaterThanOrEqualTo(String value) {
            addCriterion("ammeter_name >=", value, "ammeterName");
            return (Criteria) this;
        }

        public Criteria andAmmeterNameLessThan(String value) {
            addCriterion("ammeter_name <", value, "ammeterName");
            return (Criteria) this;
        }

        public Criteria andAmmeterNameLessThanOrEqualTo(String value) {
            addCriterion("ammeter_name <=", value, "ammeterName");
            return (Criteria) this;
        }

        public Criteria andAmmeterNameLike(String value) {
            addCriterion("ammeter_name like", value, "ammeterName");
            return (Criteria) this;
        }

        public Criteria andAmmeterNameNotLike(String value) {
            addCriterion("ammeter_name not like", value, "ammeterName");
            return (Criteria) this;
        }

        public Criteria andAmmeterNameIn(List<String> values) {
            addCriterion("ammeter_name in", values, "ammeterName");
            return (Criteria) this;
        }

        public Criteria andAmmeterNameNotIn(List<String> values) {
            addCriterion("ammeter_name not in", values, "ammeterName");
            return (Criteria) this;
        }

        public Criteria andAmmeterNameBetween(String value1, String value2) {
            addCriterion("ammeter_name between", value1, value2, "ammeterName");
            return (Criteria) this;
        }

        public Criteria andAmmeterNameNotBetween(String value1, String value2) {
            addCriterion("ammeter_name not between", value1, value2, "ammeterName");
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
            addCriterion(" amm.agreement_id =", value, "agreementId");
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

        public Criteria andEnableIsNull() {
            addCriterion("enable is null");
            return (Criteria) this;
        }

        public Criteria andEnableIsNotNull() {
            addCriterion("enable is not null");
            return (Criteria) this;
        }

        public Criteria andEnableEqualTo(Byte value) {
            addCriterion("enable =", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableNotEqualTo(Byte value) {
            addCriterion("enable <>", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableGreaterThan(Byte value) {
            addCriterion("enable >", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableGreaterThanOrEqualTo(Byte value) {
            addCriterion("enable >=", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableLessThan(Byte value) {
            addCriterion("enable <", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableLessThanOrEqualTo(Byte value) {
            addCriterion("enable <=", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableIn(List<Byte> values) {
            addCriterion("enable in", values, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableNotIn(List<Byte> values) {
            addCriterion("enable not in", values, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableBetween(Byte value1, Byte value2) {
            addCriterion("enable between", value1, value2, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableNotBetween(Byte value1, Byte value2) {
            addCriterion("enable not between", value1, value2, "enable");
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