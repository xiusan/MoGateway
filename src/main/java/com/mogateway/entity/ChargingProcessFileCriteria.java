package com.mogateway.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ChargingProcessFileCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ChargingProcessFileCriteria() {
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andFielTypeIsNull() {
            addCriterion("fiel_type is null");
            return (Criteria) this;
        }

        public Criteria andFielTypeIsNotNull() {
            addCriterion("fiel_type is not null");
            return (Criteria) this;
        }

        public Criteria andFielTypeEqualTo(String value) {
            addCriterion("fiel_type =", value, "fielType");
            return (Criteria) this;
        }

        public Criteria andFielTypeNotEqualTo(String value) {
            addCriterion("fiel_type <>", value, "fielType");
            return (Criteria) this;
        }

        public Criteria andFielTypeGreaterThan(String value) {
            addCriterion("fiel_type >", value, "fielType");
            return (Criteria) this;
        }

        public Criteria andFielTypeGreaterThanOrEqualTo(String value) {
            addCriterion("fiel_type >=", value, "fielType");
            return (Criteria) this;
        }

        public Criteria andFielTypeLessThan(String value) {
            addCriterion("fiel_type <", value, "fielType");
            return (Criteria) this;
        }

        public Criteria andFielTypeLessThanOrEqualTo(String value) {
            addCriterion("fiel_type <=", value, "fielType");
            return (Criteria) this;
        }

        public Criteria andFielTypeLike(String value) {
            addCriterion("fiel_type like", value, "fielType");
            return (Criteria) this;
        }

        public Criteria andFielTypeNotLike(String value) {
            addCriterion("fiel_type not like", value, "fielType");
            return (Criteria) this;
        }

        public Criteria andFielTypeIn(List<String> values) {
            addCriterion("fiel_type in", values, "fielType");
            return (Criteria) this;
        }

        public Criteria andFielTypeNotIn(List<String> values) {
            addCriterion("fiel_type not in", values, "fielType");
            return (Criteria) this;
        }

        public Criteria andFielTypeBetween(String value1, String value2) {
            addCriterion("fiel_type between", value1, value2, "fielType");
            return (Criteria) this;
        }

        public Criteria andFielTypeNotBetween(String value1, String value2) {
            addCriterion("fiel_type not between", value1, value2, "fielType");
            return (Criteria) this;
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

        public Criteria andCurrentDttmIsNull() {
            addCriterion("current_dttm is null");
            return (Criteria) this;
        }

        public Criteria andCurrentDttmIsNotNull() {
            addCriterion("current_dttm is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentDttmEqualTo(Date value) {
            addCriterion("current_dttm =", value, "currentDttm");
            return (Criteria) this;
        }

        public Criteria andCurrentDttmNotEqualTo(Date value) {
            addCriterion("current_dttm <>", value, "currentDttm");
            return (Criteria) this;
        }

        public Criteria andCurrentDttmGreaterThan(Date value) {
            addCriterion("current_dttm >", value, "currentDttm");
            return (Criteria) this;
        }

        public Criteria andCurrentDttmGreaterThanOrEqualTo(Date value) {
            addCriterion("current_dttm >=", value, "currentDttm");
            return (Criteria) this;
        }

        public Criteria andCurrentDttmLessThan(Date value) {
            addCriterion("current_dttm <", value, "currentDttm");
            return (Criteria) this;
        }

        public Criteria andCurrentDttmLessThanOrEqualTo(Date value) {
            addCriterion("current_dttm <=", value, "currentDttm");
            return (Criteria) this;
        }

        public Criteria andCurrentDttmIn(List<Date> values) {
            addCriterion("current_dttm in", values, "currentDttm");
            return (Criteria) this;
        }

        public Criteria andCurrentDttmNotIn(List<Date> values) {
            addCriterion("current_dttm not in", values, "currentDttm");
            return (Criteria) this;
        }

        public Criteria andCurrentDttmBetween(Date value1, Date value2) {
            addCriterion("current_dttm between", value1, value2, "currentDttm");
            return (Criteria) this;
        }

        public Criteria andCurrentDttmNotBetween(Date value1, Date value2) {
            addCriterion("current_dttm not between", value1, value2, "currentDttm");
            return (Criteria) this;
        }

        public Criteria andFileSizeIsNull() {
            addCriterion("file_size is null");
            return (Criteria) this;
        }

        public Criteria andFileSizeIsNotNull() {
            addCriterion("file_size is not null");
            return (Criteria) this;
        }

        public Criteria andFileSizeEqualTo(String value) {
            addCriterion("file_size =", value, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeNotEqualTo(String value) {
            addCriterion("file_size <>", value, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeGreaterThan(String value) {
            addCriterion("file_size >", value, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeGreaterThanOrEqualTo(String value) {
            addCriterion("file_size >=", value, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeLessThan(String value) {
            addCriterion("file_size <", value, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeLessThanOrEqualTo(String value) {
            addCriterion("file_size <=", value, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeLike(String value) {
            addCriterion("file_size like", value, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeNotLike(String value) {
            addCriterion("file_size not like", value, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeIn(List<String> values) {
            addCriterion("file_size in", values, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeNotIn(List<String> values) {
            addCriterion("file_size not in", values, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeBetween(String value1, String value2) {
            addCriterion("file_size between", value1, value2, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeNotBetween(String value1, String value2) {
            addCriterion("file_size not between", value1, value2, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFilePathIsNull() {
            addCriterion("file_path is null");
            return (Criteria) this;
        }

        public Criteria andFilePathIsNotNull() {
            addCriterion("file_path is not null");
            return (Criteria) this;
        }

        public Criteria andFilePathEqualTo(String value) {
            addCriterion("file_path =", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathNotEqualTo(String value) {
            addCriterion("file_path <>", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathGreaterThan(String value) {
            addCriterion("file_path >", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathGreaterThanOrEqualTo(String value) {
            addCriterion("file_path >=", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathLessThan(String value) {
            addCriterion("file_path <", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathLessThanOrEqualTo(String value) {
            addCriterion("file_path <=", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathLike(String value) {
            addCriterion("file_path like", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathNotLike(String value) {
            addCriterion("file_path not like", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathIn(List<String> values) {
            addCriterion("file_path in", values, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathNotIn(List<String> values) {
            addCriterion("file_path not in", values, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathBetween(String value1, String value2) {
            addCriterion("file_path between", value1, value2, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathNotBetween(String value1, String value2) {
            addCriterion("file_path not between", value1, value2, "filePath");
            return (Criteria) this;
        }

        public Criteria andFileCreateTimeIsNull() {
            addCriterion("file_create_time is null");
            return (Criteria) this;
        }

        public Criteria andFileCreateTimeIsNotNull() {
            addCriterion("file_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andFileCreateTimeEqualTo(Date value) {
            addCriterion("file_create_time =", value, "fileCreateTime");
            return (Criteria) this;
        }

        public Criteria andFileCreateTimeNotEqualTo(Date value) {
            addCriterion("file_create_time <>", value, "fileCreateTime");
            return (Criteria) this;
        }

        public Criteria andFileCreateTimeGreaterThan(Date value) {
            addCriterion("file_create_time >", value, "fileCreateTime");
            return (Criteria) this;
        }

        public Criteria andFileCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("file_create_time >=", value, "fileCreateTime");
            return (Criteria) this;
        }

        public Criteria andFileCreateTimeLessThan(Date value) {
            addCriterion("file_create_time <", value, "fileCreateTime");
            return (Criteria) this;
        }

        public Criteria andFileCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("file_create_time <=", value, "fileCreateTime");
            return (Criteria) this;
        }

        public Criteria andFileCreateTimeIn(List<Date> values) {
            addCriterion("file_create_time in", values, "fileCreateTime");
            return (Criteria) this;
        }

        public Criteria andFileCreateTimeNotIn(List<Date> values) {
            addCriterion("file_create_time not in", values, "fileCreateTime");
            return (Criteria) this;
        }

        public Criteria andFileCreateTimeBetween(Date value1, Date value2) {
            addCriterion("file_create_time between", value1, value2, "fileCreateTime");
            return (Criteria) this;
        }

        public Criteria andFileCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("file_create_time not between", value1, value2, "fileCreateTime");
            return (Criteria) this;
        }

        public Criteria andIsFlangIsNull() {
            addCriterion("is_flang is null");
            return (Criteria) this;
        }

        public Criteria andIsFlangIsNotNull() {
            addCriterion("is_flang is not null");
            return (Criteria) this;
        }

        public Criteria andIsFlangEqualTo(Integer value) {
            addCriterion("is_flang =", value, "isFlang");
            return (Criteria) this;
        }

        public Criteria andIsFlangNotEqualTo(Integer value) {
            addCriterion("is_flang <>", value, "isFlang");
            return (Criteria) this;
        }

        public Criteria andIsFlangGreaterThan(Integer value) {
            addCriterion("is_flang >", value, "isFlang");
            return (Criteria) this;
        }

        public Criteria andIsFlangGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_flang >=", value, "isFlang");
            return (Criteria) this;
        }

        public Criteria andIsFlangLessThan(Integer value) {
            addCriterion("is_flang <", value, "isFlang");
            return (Criteria) this;
        }

        public Criteria andIsFlangLessThanOrEqualTo(Integer value) {
            addCriterion("is_flang <=", value, "isFlang");
            return (Criteria) this;
        }

        public Criteria andIsFlangIn(List<Integer> values) {
            addCriterion("is_flang in", values, "isFlang");
            return (Criteria) this;
        }

        public Criteria andIsFlangNotIn(List<Integer> values) {
            addCriterion("is_flang not in", values, "isFlang");
            return (Criteria) this;
        }

        public Criteria andIsFlangBetween(Integer value1, Integer value2) {
            addCriterion("is_flang between", value1, value2, "isFlang");
            return (Criteria) this;
        }

        public Criteria andIsFlangNotBetween(Integer value1, Integer value2) {
            addCriterion("is_flang not between", value1, value2, "isFlang");
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