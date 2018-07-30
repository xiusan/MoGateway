package com.mogateway.entity;

import java.util.ArrayList;
import java.util.List;

public class HistoryDataCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HistoryDataCriteria() {
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

        public Criteria andHistoryIdIsNull() {
            addCriterion("history_id is null");
            return (Criteria) this;
        }

        public Criteria andHistoryIdIsNotNull() {
            addCriterion("history_id is not null");
            return (Criteria) this;
        }

        public Criteria andHistoryIdEqualTo(String value) {
            addCriterion("history_id =", value, "historyId");
            return (Criteria) this;
        }

        public Criteria andHistoryIdNotEqualTo(String value) {
            addCriterion("history_id <>", value, "historyId");
            return (Criteria) this;
        }

        public Criteria andHistoryIdGreaterThan(String value) {
            addCriterion("history_id >", value, "historyId");
            return (Criteria) this;
        }

        public Criteria andHistoryIdGreaterThanOrEqualTo(String value) {
            addCriterion("history_id >=", value, "historyId");
            return (Criteria) this;
        }

        public Criteria andHistoryIdLessThan(String value) {
            addCriterion("history_id <", value, "historyId");
            return (Criteria) this;
        }

        public Criteria andHistoryIdLessThanOrEqualTo(String value) {
            addCriterion("history_id <=", value, "historyId");
            return (Criteria) this;
        }

        public Criteria andHistoryIdLike(String value) {
            addCriterion("history_id like", value, "historyId");
            return (Criteria) this;
        }

        public Criteria andHistoryIdNotLike(String value) {
            addCriterion("history_id not like", value, "historyId");
            return (Criteria) this;
        }

        public Criteria andHistoryIdIn(List<String> values) {
            addCriterion("history_id in", values, "historyId");
            return (Criteria) this;
        }

        public Criteria andHistoryIdNotIn(List<String> values) {
            addCriterion("history_id not in", values, "historyId");
            return (Criteria) this;
        }

        public Criteria andHistoryIdBetween(String value1, String value2) {
            addCriterion("history_id between", value1, value2, "historyId");
            return (Criteria) this;
        }

        public Criteria andHistoryIdNotBetween(String value1, String value2) {
            addCriterion("history_id not between", value1, value2, "historyId");
            return (Criteria) this;
        }

        public Criteria andInstructionsNameIsNull() {
            addCriterion("instructions_name is null");
            return (Criteria) this;
        }

        public Criteria andInstructionsNameIsNotNull() {
            addCriterion("instructions_name is not null");
            return (Criteria) this;
        }

        public Criteria andInstructionsNameEqualTo(String value) {
            addCriterion("instructions_name =", value, "instructionsName");
            return (Criteria) this;
        }

        public Criteria andInstructionsNameNotEqualTo(String value) {
            addCriterion("instructions_name <>", value, "instructionsName");
            return (Criteria) this;
        }

        public Criteria andInstructionsNameGreaterThan(String value) {
            addCriterion("instructions_name >", value, "instructionsName");
            return (Criteria) this;
        }

        public Criteria andInstructionsNameGreaterThanOrEqualTo(String value) {
            addCriterion("instructions_name >=", value, "instructionsName");
            return (Criteria) this;
        }

        public Criteria andInstructionsNameLessThan(String value) {
            addCriterion("instructions_name <", value, "instructionsName");
            return (Criteria) this;
        }

        public Criteria andInstructionsNameLessThanOrEqualTo(String value) {
            addCriterion("instructions_name <=", value, "instructionsName");
            return (Criteria) this;
        }

        public Criteria andInstructionsNameLike(String value) {
            addCriterion("instructions_name like", value, "instructionsName");
            return (Criteria) this;
        }

        public Criteria andInstructionsNameNotLike(String value) {
            addCriterion("instructions_name not like", value, "instructionsName");
            return (Criteria) this;
        }

        public Criteria andInstructionsNameIn(List<String> values) {
            addCriterion("instructions_name in", values, "instructionsName");
            return (Criteria) this;
        }

        public Criteria andInstructionsNameNotIn(List<String> values) {
            addCriterion("instructions_name not in", values, "instructionsName");
            return (Criteria) this;
        }

        public Criteria andInstructionsNameBetween(String value1, String value2) {
            addCriterion("instructions_name between", value1, value2, "instructionsName");
            return (Criteria) this;
        }

        public Criteria andInstructionsNameNotBetween(String value1, String value2) {
            addCriterion("instructions_name not between", value1, value2, "instructionsName");
            return (Criteria) this;
        }

        public Criteria andIsEnableIsNull() {
            addCriterion("is_enable is null");
            return (Criteria) this;
        }

        public Criteria andIsEnableIsNotNull() {
            addCriterion("is_enable is not null");
            return (Criteria) this;
        }

        public Criteria andIsEnableEqualTo(Integer value) {
            addCriterion("is_enable =", value, "isEnable");
            return (Criteria) this;
        }

        public Criteria andIsEnableNotEqualTo(Integer value) {
            addCriterion("is_enable <>", value, "isEnable");
            return (Criteria) this;
        }

        public Criteria andIsEnableGreaterThan(Integer value) {
            addCriterion("is_enable >", value, "isEnable");
            return (Criteria) this;
        }

        public Criteria andIsEnableGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_enable >=", value, "isEnable");
            return (Criteria) this;
        }

        public Criteria andIsEnableLessThan(Integer value) {
            addCriterion("is_enable <", value, "isEnable");
            return (Criteria) this;
        }

        public Criteria andIsEnableLessThanOrEqualTo(Integer value) {
            addCriterion("is_enable <=", value, "isEnable");
            return (Criteria) this;
        }

        public Criteria andIsEnableIn(List<Integer> values) {
            addCriterion("is_enable in", values, "isEnable");
            return (Criteria) this;
        }

        public Criteria andIsEnableNotIn(List<Integer> values) {
            addCriterion("is_enable not in", values, "isEnable");
            return (Criteria) this;
        }

        public Criteria andIsEnableBetween(Integer value1, Integer value2) {
            addCriterion("is_enable between", value1, value2, "isEnable");
            return (Criteria) this;
        }

        public Criteria andIsEnableNotBetween(Integer value1, Integer value2) {
            addCriterion("is_enable not between", value1, value2, "isEnable");
            return (Criteria) this;
        }

        public Criteria andIsFlangKjIsNull() {
            addCriterion("is_flang_kj is null");
            return (Criteria) this;
        }

        public Criteria andIsFlangKjIsNotNull() {
            addCriterion("is_flang_kj is not null");
            return (Criteria) this;
        }

        public Criteria andIsFlangKjEqualTo(Integer value) {
            addCriterion("is_flang_kj =", value, "isFlangKj");
            return (Criteria) this;
        }

        public Criteria andIsFlangKjNotEqualTo(Integer value) {
            addCriterion("is_flang_kj <>", value, "isFlangKj");
            return (Criteria) this;
        }

        public Criteria andIsFlangKjGreaterThan(Integer value) {
            addCriterion("is_flang_kj >", value, "isFlangKj");
            return (Criteria) this;
        }

        public Criteria andIsFlangKjGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_flang_kj >=", value, "isFlangKj");
            return (Criteria) this;
        }

        public Criteria andIsFlangKjLessThan(Integer value) {
            addCriterion("is_flang_kj <", value, "isFlangKj");
            return (Criteria) this;
        }

        public Criteria andIsFlangKjLessThanOrEqualTo(Integer value) {
            addCriterion("is_flang_kj <=", value, "isFlangKj");
            return (Criteria) this;
        }

        public Criteria andIsFlangKjIn(List<Integer> values) {
            addCriterion("is_flang_kj in", values, "isFlangKj");
            return (Criteria) this;
        }

        public Criteria andIsFlangKjNotIn(List<Integer> values) {
            addCriterion("is_flang_kj not in", values, "isFlangKj");
            return (Criteria) this;
        }

        public Criteria andIsFlangKjBetween(Integer value1, Integer value2) {
            addCriterion("is_flang_kj between", value1, value2, "isFlangKj");
            return (Criteria) this;
        }

        public Criteria andIsFlangKjNotBetween(Integer value1, Integer value2) {
            addCriterion("is_flang_kj not between", value1, value2, "isFlangKj");
            return (Criteria) this;
        }

        public Criteria andIsFlangCustIsNull() {
            addCriterion("is_flang_cust is null");
            return (Criteria) this;
        }

        public Criteria andIsFlangCustIsNotNull() {
            addCriterion("is_flang_cust is not null");
            return (Criteria) this;
        }

        public Criteria andIsFlangCustEqualTo(Integer value) {
            addCriterion("is_flang_cust =", value, "isFlangCust");
            return (Criteria) this;
        }

        public Criteria andIsFlangCustNotEqualTo(Integer value) {
            addCriterion("is_flang_cust <>", value, "isFlangCust");
            return (Criteria) this;
        }

        public Criteria andIsFlangCustGreaterThan(Integer value) {
            addCriterion("is_flang_cust >", value, "isFlangCust");
            return (Criteria) this;
        }

        public Criteria andIsFlangCustGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_flang_cust >=", value, "isFlangCust");
            return (Criteria) this;
        }

        public Criteria andIsFlangCustLessThan(Integer value) {
            addCriterion("is_flang_cust <", value, "isFlangCust");
            return (Criteria) this;
        }

        public Criteria andIsFlangCustLessThanOrEqualTo(Integer value) {
            addCriterion("is_flang_cust <=", value, "isFlangCust");
            return (Criteria) this;
        }

        public Criteria andIsFlangCustIn(List<Integer> values) {
            addCriterion("is_flang_cust in", values, "isFlangCust");
            return (Criteria) this;
        }

        public Criteria andIsFlangCustNotIn(List<Integer> values) {
            addCriterion("is_flang_cust not in", values, "isFlangCust");
            return (Criteria) this;
        }

        public Criteria andIsFlangCustBetween(Integer value1, Integer value2) {
            addCriterion("is_flang_cust between", value1, value2, "isFlangCust");
            return (Criteria) this;
        }

        public Criteria andIsFlangCustNotBetween(Integer value1, Integer value2) {
            addCriterion("is_flang_cust not between", value1, value2, "isFlangCust");
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