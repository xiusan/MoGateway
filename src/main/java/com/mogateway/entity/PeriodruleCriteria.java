package com.mogateway.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class PeriodruleCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PeriodruleCriteria() {
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

        protected void addCriterionForJDBCTime(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Time(value.getTime()), property);
        }

        protected void addCriterionForJDBCTime(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Time> timeList = new ArrayList<java.sql.Time>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                timeList.add(new java.sql.Time(iter.next().getTime()));
            }
            addCriterion(condition, timeList, property);
        }

        protected void addCriterionForJDBCTime(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Time(value1.getTime()), new java.sql.Time(value2.getTime()), property);
        }

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andRuleidIsNull() {
            addCriterion("RuleID is null");
            return (Criteria) this;
        }

        public Criteria andRuleidIsNotNull() {
            addCriterion("RuleID is not null");
            return (Criteria) this;
        }

        public Criteria andRuleidEqualTo(String value) {
            addCriterion("RuleID =", value, "ruleid");
            return (Criteria) this;
        }

        public Criteria andRuleidNotEqualTo(String value) {
            addCriterion("RuleID <>", value, "ruleid");
            return (Criteria) this;
        }

        public Criteria andRuleidGreaterThan(String value) {
            addCriterion("RuleID >", value, "ruleid");
            return (Criteria) this;
        }

        public Criteria andRuleidGreaterThanOrEqualTo(String value) {
            addCriterion("RuleID >=", value, "ruleid");
            return (Criteria) this;
        }

        public Criteria andRuleidLessThan(String value) {
            addCriterion("RuleID <", value, "ruleid");
            return (Criteria) this;
        }

        public Criteria andRuleidLessThanOrEqualTo(String value) {
            addCriterion("RuleID <=", value, "ruleid");
            return (Criteria) this;
        }

        public Criteria andRuleidLike(String value) {
            addCriterion("RuleID like", value, "ruleid");
            return (Criteria) this;
        }

        public Criteria andRuleidNotLike(String value) {
            addCriterion("RuleID not like", value, "ruleid");
            return (Criteria) this;
        }

        public Criteria andRuleidIn(List<String> values) {
            addCriterion("RuleID in", values, "ruleid");
            return (Criteria) this;
        }

        public Criteria andRuleidNotIn(List<String> values) {
            addCriterion("RuleID not in", values, "ruleid");
            return (Criteria) this;
        }

        public Criteria andRuleidBetween(String value1, String value2) {
            addCriterion("RuleID between", value1, value2, "ruleid");
            return (Criteria) this;
        }

        public Criteria andRuleidNotBetween(String value1, String value2) {
            addCriterion("RuleID not between", value1, value2, "ruleid");
            return (Criteria) this;
        }

        public Criteria andPeriodstartdttmIsNull() {
            addCriterion("PeriodStartDTTM is null");
            return (Criteria) this;
        }

        public Criteria andPeriodstartdttmIsNotNull() {
            addCriterion("PeriodStartDTTM is not null");
            return (Criteria) this;
        }

        public Criteria andPeriodstartdttmEqualTo(Date value) {
            addCriterionForJDBCTime("PeriodStartDTTM =", value, "periodstartdttm");
            return (Criteria) this;
        }

        public Criteria andPeriodstartdttmNotEqualTo(Date value) {
            addCriterionForJDBCTime("PeriodStartDTTM <>", value, "periodstartdttm");
            return (Criteria) this;
        }

        public Criteria andPeriodstartdttmGreaterThan(Date value) {
            addCriterionForJDBCTime("PeriodStartDTTM >", value, "periodstartdttm");
            return (Criteria) this;
        }

        public Criteria andPeriodstartdttmGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("PeriodStartDTTM >=", value, "periodstartdttm");
            return (Criteria) this;
        }

        public Criteria andPeriodstartdttmLessThan(Date value) {
            addCriterionForJDBCTime("PeriodStartDTTM <", value, "periodstartdttm");
            return (Criteria) this;
        }

        public Criteria andPeriodstartdttmLessThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("PeriodStartDTTM <=", value, "periodstartdttm");
            return (Criteria) this;
        }

        public Criteria andPeriodstartdttmIn(List<Date> values) {
            addCriterionForJDBCTime("PeriodStartDTTM in", values, "periodstartdttm");
            return (Criteria) this;
        }

        public Criteria andPeriodstartdttmNotIn(List<Date> values) {
            addCriterionForJDBCTime("PeriodStartDTTM not in", values, "periodstartdttm");
            return (Criteria) this;
        }

        public Criteria andPeriodstartdttmBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("PeriodStartDTTM between", value1, value2, "periodstartdttm");
            return (Criteria) this;
        }

        public Criteria andPeriodstartdttmNotBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("PeriodStartDTTM not between", value1, value2, "periodstartdttm");
            return (Criteria) this;
        }

        public Criteria andPeriodenddttmIsNull() {
            addCriterion("PeriodEndDTTM is null");
            return (Criteria) this;
        }

        public Criteria andPeriodenddttmIsNotNull() {
            addCriterion("PeriodEndDTTM is not null");
            return (Criteria) this;
        }

        public Criteria andPeriodenddttmEqualTo(Date value) {
            addCriterionForJDBCTime("PeriodEndDTTM =", value, "periodenddttm");
            return (Criteria) this;
        }

        public Criteria andPeriodenddttmNotEqualTo(Date value) {
            addCriterionForJDBCTime("PeriodEndDTTM <>", value, "periodenddttm");
            return (Criteria) this;
        }

        public Criteria andPeriodenddttmGreaterThan(Date value) {
            addCriterionForJDBCTime("PeriodEndDTTM >", value, "periodenddttm");
            return (Criteria) this;
        }

        public Criteria andPeriodenddttmGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("PeriodEndDTTM >=", value, "periodenddttm");
            return (Criteria) this;
        }

        public Criteria andPeriodenddttmLessThan(Date value) {
            addCriterionForJDBCTime("PeriodEndDTTM <", value, "periodenddttm");
            return (Criteria) this;
        }

        public Criteria andPeriodenddttmLessThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("PeriodEndDTTM <=", value, "periodenddttm");
            return (Criteria) this;
        }

        public Criteria andPeriodenddttmIn(List<Date> values) {
            addCriterionForJDBCTime("PeriodEndDTTM in", values, "periodenddttm");
            return (Criteria) this;
        }

        public Criteria andPeriodenddttmNotIn(List<Date> values) {
            addCriterionForJDBCTime("PeriodEndDTTM not in", values, "periodenddttm");
            return (Criteria) this;
        }

        public Criteria andPeriodenddttmBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("PeriodEndDTTM between", value1, value2, "periodenddttm");
            return (Criteria) this;
        }

        public Criteria andPeriodenddttmNotBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("PeriodEndDTTM not between", value1, value2, "periodenddttm");
            return (Criteria) this;
        }

        public Criteria andPeriodstartidIsNull() {
            addCriterion("PeriodStartID is null");
            return (Criteria) this;
        }

        public Criteria andPeriodstartidIsNotNull() {
            addCriterion("PeriodStartID is not null");
            return (Criteria) this;
        }

        public Criteria andPeriodstartidEqualTo(Boolean value) {
            addCriterion("PeriodStartID =", value, "periodstartid");
            return (Criteria) this;
        }

        public Criteria andPeriodstartidNotEqualTo(Boolean value) {
            addCriterion("PeriodStartID <>", value, "periodstartid");
            return (Criteria) this;
        }

        public Criteria andPeriodstartidGreaterThan(Boolean value) {
            addCriterion("PeriodStartID >", value, "periodstartid");
            return (Criteria) this;
        }

        public Criteria andPeriodstartidGreaterThanOrEqualTo(Boolean value) {
            addCriterion("PeriodStartID >=", value, "periodstartid");
            return (Criteria) this;
        }

        public Criteria andPeriodstartidLessThan(Boolean value) {
            addCriterion("PeriodStartID <", value, "periodstartid");
            return (Criteria) this;
        }

        public Criteria andPeriodstartidLessThanOrEqualTo(Boolean value) {
            addCriterion("PeriodStartID <=", value, "periodstartid");
            return (Criteria) this;
        }

        public Criteria andPeriodstartidIn(List<Boolean> values) {
            addCriterion("PeriodStartID in", values, "periodstartid");
            return (Criteria) this;
        }

        public Criteria andPeriodstartidNotIn(List<Boolean> values) {
            addCriterion("PeriodStartID not in", values, "periodstartid");
            return (Criteria) this;
        }

        public Criteria andPeriodstartidBetween(Boolean value1, Boolean value2) {
            addCriterion("PeriodStartID between", value1, value2, "periodstartid");
            return (Criteria) this;
        }

        public Criteria andPeriodstartidNotBetween(Boolean value1, Boolean value2) {
            addCriterion("PeriodStartID not between", value1, value2, "periodstartid");
            return (Criteria) this;
        }

        public Criteria andPeriodpriceIsNull() {
            addCriterion("PeriodPrice is null");
            return (Criteria) this;
        }

        public Criteria andPeriodpriceIsNotNull() {
            addCriterion("PeriodPrice is not null");
            return (Criteria) this;
        }

        public Criteria andPeriodpriceEqualTo(Double value) {
            addCriterion("PeriodPrice =", value, "periodprice");
            return (Criteria) this;
        }

        public Criteria andPeriodpriceNotEqualTo(Double value) {
            addCriterion("PeriodPrice <>", value, "periodprice");
            return (Criteria) this;
        }

        public Criteria andPeriodpriceGreaterThan(Double value) {
            addCriterion("PeriodPrice >", value, "periodprice");
            return (Criteria) this;
        }

        public Criteria andPeriodpriceGreaterThanOrEqualTo(Double value) {
            addCriterion("PeriodPrice >=", value, "periodprice");
            return (Criteria) this;
        }

        public Criteria andPeriodpriceLessThan(Double value) {
            addCriterion("PeriodPrice <", value, "periodprice");
            return (Criteria) this;
        }

        public Criteria andPeriodpriceLessThanOrEqualTo(Double value) {
            addCriterion("PeriodPrice <=", value, "periodprice");
            return (Criteria) this;
        }

        public Criteria andPeriodpriceIn(List<Double> values) {
            addCriterion("PeriodPrice in", values, "periodprice");
            return (Criteria) this;
        }

        public Criteria andPeriodpriceNotIn(List<Double> values) {
            addCriterion("PeriodPrice not in", values, "periodprice");
            return (Criteria) this;
        }

        public Criteria andPeriodpriceBetween(Double value1, Double value2) {
            addCriterion("PeriodPrice between", value1, value2, "periodprice");
            return (Criteria) this;
        }

        public Criteria andPeriodpriceNotBetween(Double value1, Double value2) {
            addCriterion("PeriodPrice not between", value1, value2, "periodprice");
            return (Criteria) this;
        }

        public Criteria andCreateuserIsNull() {
            addCriterion("CreateUser is null");
            return (Criteria) this;
        }

        public Criteria andCreateuserIsNotNull() {
            addCriterion("CreateUser is not null");
            return (Criteria) this;
        }

        public Criteria andCreateuserEqualTo(String value) {
            addCriterion("CreateUser =", value, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserNotEqualTo(String value) {
            addCriterion("CreateUser <>", value, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserGreaterThan(String value) {
            addCriterion("CreateUser >", value, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserGreaterThanOrEqualTo(String value) {
            addCriterion("CreateUser >=", value, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserLessThan(String value) {
            addCriterion("CreateUser <", value, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserLessThanOrEqualTo(String value) {
            addCriterion("CreateUser <=", value, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserLike(String value) {
            addCriterion("CreateUser like", value, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserNotLike(String value) {
            addCriterion("CreateUser not like", value, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserIn(List<String> values) {
            addCriterion("CreateUser in", values, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserNotIn(List<String> values) {
            addCriterion("CreateUser not in", values, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserBetween(String value1, String value2) {
            addCriterion("CreateUser between", value1, value2, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserNotBetween(String value1, String value2) {
            addCriterion("CreateUser not between", value1, value2, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreatedttmIsNull() {
            addCriterion("CreateDTTM is null");
            return (Criteria) this;
        }

        public Criteria andCreatedttmIsNotNull() {
            addCriterion("CreateDTTM is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedttmEqualTo(Date value) {
            addCriterion("CreateDTTM =", value, "createdttm");
            return (Criteria) this;
        }

        public Criteria andCreatedttmNotEqualTo(Date value) {
            addCriterion("CreateDTTM <>", value, "createdttm");
            return (Criteria) this;
        }

        public Criteria andCreatedttmGreaterThan(Date value) {
            addCriterion("CreateDTTM >", value, "createdttm");
            return (Criteria) this;
        }

        public Criteria andCreatedttmGreaterThanOrEqualTo(Date value) {
            addCriterion("CreateDTTM >=", value, "createdttm");
            return (Criteria) this;
        }

        public Criteria andCreatedttmLessThan(Date value) {
            addCriterion("CreateDTTM <", value, "createdttm");
            return (Criteria) this;
        }

        public Criteria andCreatedttmLessThanOrEqualTo(Date value) {
            addCriterion("CreateDTTM <=", value, "createdttm");
            return (Criteria) this;
        }

        public Criteria andCreatedttmIn(List<Date> values) {
            addCriterion("CreateDTTM in", values, "createdttm");
            return (Criteria) this;
        }

        public Criteria andCreatedttmNotIn(List<Date> values) {
            addCriterion("CreateDTTM not in", values, "createdttm");
            return (Criteria) this;
        }

        public Criteria andCreatedttmBetween(Date value1, Date value2) {
            addCriterion("CreateDTTM between", value1, value2, "createdttm");
            return (Criteria) this;
        }

        public Criteria andCreatedttmNotBetween(Date value1, Date value2) {
            addCriterion("CreateDTTM not between", value1, value2, "createdttm");
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