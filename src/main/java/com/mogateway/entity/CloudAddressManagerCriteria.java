package com.mogateway.entity;

import java.util.ArrayList;
import java.util.List;

public class CloudAddressManagerCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CloudAddressManagerCriteria() {
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

        public Criteria andCloudIdIsNull() {
            addCriterion("cloud_id is null");
            return (Criteria) this;
        }

        public Criteria andCloudIdIsNotNull() {
            addCriterion("cloud_id is not null");
            return (Criteria) this;
        }

        public Criteria andCloudIdEqualTo(String value) {
            addCriterion("cloud_id =", value, "cloudId");
            return (Criteria) this;
        }

        public Criteria andCloudIdNotEqualTo(String value) {
            addCriterion("cloud_id <>", value, "cloudId");
            return (Criteria) this;
        }

        public Criteria andCloudIdGreaterThan(String value) {
            addCriterion("cloud_id >", value, "cloudId");
            return (Criteria) this;
        }

        public Criteria andCloudIdGreaterThanOrEqualTo(String value) {
            addCriterion("cloud_id >=", value, "cloudId");
            return (Criteria) this;
        }

        public Criteria andCloudIdLessThan(String value) {
            addCriterion("cloud_id <", value, "cloudId");
            return (Criteria) this;
        }

        public Criteria andCloudIdLessThanOrEqualTo(String value) {
            addCriterion("cloud_id <=", value, "cloudId");
            return (Criteria) this;
        }

        public Criteria andCloudIdLike(String value) {
            addCriterion("cloud_id like", value, "cloudId");
            return (Criteria) this;
        }

        public Criteria andCloudIdNotLike(String value) {
            addCriterion("cloud_id not like", value, "cloudId");
            return (Criteria) this;
        }

        public Criteria andCloudIdIn(List<String> values) {
            addCriterion("cloud_id in", values, "cloudId");
            return (Criteria) this;
        }

        public Criteria andCloudIdNotIn(List<String> values) {
            addCriterion("cloud_id not in", values, "cloudId");
            return (Criteria) this;
        }

        public Criteria andCloudIdBetween(String value1, String value2) {
            addCriterion("cloud_id between", value1, value2, "cloudId");
            return (Criteria) this;
        }

        public Criteria andCloudIdNotBetween(String value1, String value2) {
            addCriterion("cloud_id not between", value1, value2, "cloudId");
            return (Criteria) this;
        }

        public Criteria andKjCloudAddressIsNull() {
            addCriterion("kj_cloud_address is null");
            return (Criteria) this;
        }

        public Criteria andKjCloudAddressIsNotNull() {
            addCriterion("kj_cloud_address is not null");
            return (Criteria) this;
        }

        public Criteria andKjCloudAddressEqualTo(String value) {
            addCriterion("kj_cloud_address =", value, "kjCloudAddress");
            return (Criteria) this;
        }

        public Criteria andKjCloudAddressNotEqualTo(String value) {
            addCriterion("kj_cloud_address <>", value, "kjCloudAddress");
            return (Criteria) this;
        }

        public Criteria andKjCloudAddressGreaterThan(String value) {
            addCriterion("kj_cloud_address >", value, "kjCloudAddress");
            return (Criteria) this;
        }

        public Criteria andKjCloudAddressGreaterThanOrEqualTo(String value) {
            addCriterion("kj_cloud_address >=", value, "kjCloudAddress");
            return (Criteria) this;
        }

        public Criteria andKjCloudAddressLessThan(String value) {
            addCriterion("kj_cloud_address <", value, "kjCloudAddress");
            return (Criteria) this;
        }

        public Criteria andKjCloudAddressLessThanOrEqualTo(String value) {
            addCriterion("kj_cloud_address <=", value, "kjCloudAddress");
            return (Criteria) this;
        }

        public Criteria andKjCloudAddressLike(String value) {
            addCriterion("kj_cloud_address like", value, "kjCloudAddress");
            return (Criteria) this;
        }

        public Criteria andKjCloudAddressNotLike(String value) {
            addCriterion("kj_cloud_address not like", value, "kjCloudAddress");
            return (Criteria) this;
        }

        public Criteria andKjCloudAddressIn(List<String> values) {
            addCriterion("kj_cloud_address in", values, "kjCloudAddress");
            return (Criteria) this;
        }

        public Criteria andKjCloudAddressNotIn(List<String> values) {
            addCriterion("kj_cloud_address not in", values, "kjCloudAddress");
            return (Criteria) this;
        }

        public Criteria andKjCloudAddressBetween(String value1, String value2) {
            addCriterion("kj_cloud_address between", value1, value2, "kjCloudAddress");
            return (Criteria) this;
        }

        public Criteria andKjCloudAddressNotBetween(String value1, String value2) {
            addCriterion("kj_cloud_address not between", value1, value2, "kjCloudAddress");
            return (Criteria) this;
        }

        public Criteria andCustomerCloudAddressIsNull() {
            addCriterion("customer_cloud_address is null");
            return (Criteria) this;
        }

        public Criteria andCustomerCloudAddressIsNotNull() {
            addCriterion("customer_cloud_address is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerCloudAddressEqualTo(String value) {
            addCriterion("customer_cloud_address =", value, "customerCloudAddress");
            return (Criteria) this;
        }

        public Criteria andCustomerCloudAddressNotEqualTo(String value) {
            addCriterion("customer_cloud_address <>", value, "customerCloudAddress");
            return (Criteria) this;
        }

        public Criteria andCustomerCloudAddressGreaterThan(String value) {
            addCriterion("customer_cloud_address >", value, "customerCloudAddress");
            return (Criteria) this;
        }

        public Criteria andCustomerCloudAddressGreaterThanOrEqualTo(String value) {
            addCriterion("customer_cloud_address >=", value, "customerCloudAddress");
            return (Criteria) this;
        }

        public Criteria andCustomerCloudAddressLessThan(String value) {
            addCriterion("customer_cloud_address <", value, "customerCloudAddress");
            return (Criteria) this;
        }

        public Criteria andCustomerCloudAddressLessThanOrEqualTo(String value) {
            addCriterion("customer_cloud_address <=", value, "customerCloudAddress");
            return (Criteria) this;
        }

        public Criteria andCustomerCloudAddressLike(String value) {
            addCriterion("customer_cloud_address like", value, "customerCloudAddress");
            return (Criteria) this;
        }

        public Criteria andCustomerCloudAddressNotLike(String value) {
            addCriterion("customer_cloud_address not like", value, "customerCloudAddress");
            return (Criteria) this;
        }

        public Criteria andCustomerCloudAddressIn(List<String> values) {
            addCriterion("customer_cloud_address in", values, "customerCloudAddress");
            return (Criteria) this;
        }

        public Criteria andCustomerCloudAddressNotIn(List<String> values) {
            addCriterion("customer_cloud_address not in", values, "customerCloudAddress");
            return (Criteria) this;
        }

        public Criteria andCustomerCloudAddressBetween(String value1, String value2) {
            addCriterion("customer_cloud_address between", value1, value2, "customerCloudAddress");
            return (Criteria) this;
        }

        public Criteria andCustomerCloudAddressNotBetween(String value1, String value2) {
            addCriterion("customer_cloud_address not between", value1, value2, "customerCloudAddress");
            return (Criteria) this;
        }

        public Criteria andIsSynchronizationIsNull() {
            addCriterion("is_synchronization is null");
            return (Criteria) this;
        }

        public Criteria andIsSynchronizationIsNotNull() {
            addCriterion("is_synchronization is not null");
            return (Criteria) this;
        }

        public Criteria andIsSynchronizationEqualTo(Integer value) {
            addCriterion("is_synchronization =", value, "isSynchronization");
            return (Criteria) this;
        }

        public Criteria andIsSynchronizationNotEqualTo(Integer value) {
            addCriterion("is_synchronization <>", value, "isSynchronization");
            return (Criteria) this;
        }

        public Criteria andIsSynchronizationGreaterThan(Integer value) {
            addCriterion("is_synchronization >", value, "isSynchronization");
            return (Criteria) this;
        }

        public Criteria andIsSynchronizationGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_synchronization >=", value, "isSynchronization");
            return (Criteria) this;
        }

        public Criteria andIsSynchronizationLessThan(Integer value) {
            addCriterion("is_synchronization <", value, "isSynchronization");
            return (Criteria) this;
        }

        public Criteria andIsSynchronizationLessThanOrEqualTo(Integer value) {
            addCriterion("is_synchronization <=", value, "isSynchronization");
            return (Criteria) this;
        }

        public Criteria andIsSynchronizationIn(List<Integer> values) {
            addCriterion("is_synchronization in", values, "isSynchronization");
            return (Criteria) this;
        }

        public Criteria andIsSynchronizationNotIn(List<Integer> values) {
            addCriterion("is_synchronization not in", values, "isSynchronization");
            return (Criteria) this;
        }

        public Criteria andIsSynchronizationBetween(Integer value1, Integer value2) {
            addCriterion("is_synchronization between", value1, value2, "isSynchronization");
            return (Criteria) this;
        }

        public Criteria andIsSynchronizationNotBetween(Integer value1, Integer value2) {
            addCriterion("is_synchronization not between", value1, value2, "isSynchronization");
            return (Criteria) this;
        }

        public Criteria andIsCertificateIsNull() {
            addCriterion("is_certificate is null");
            return (Criteria) this;
        }

        public Criteria andIsCertificateIsNotNull() {
            addCriterion("is_certificate is not null");
            return (Criteria) this;
        }

        public Criteria andIsCertificateEqualTo(Integer value) {
            addCriterion("is_certificate =", value, "isCertificate");
            return (Criteria) this;
        }

        public Criteria andIsCertificateNotEqualTo(Integer value) {
            addCriterion("is_certificate <>", value, "isCertificate");
            return (Criteria) this;
        }

        public Criteria andIsCertificateGreaterThan(Integer value) {
            addCriterion("is_certificate >", value, "isCertificate");
            return (Criteria) this;
        }

        public Criteria andIsCertificateGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_certificate >=", value, "isCertificate");
            return (Criteria) this;
        }

        public Criteria andIsCertificateLessThan(Integer value) {
            addCriterion("is_certificate <", value, "isCertificate");
            return (Criteria) this;
        }

        public Criteria andIsCertificateLessThanOrEqualTo(Integer value) {
            addCriterion("is_certificate <=", value, "isCertificate");
            return (Criteria) this;
        }

        public Criteria andIsCertificateIn(List<Integer> values) {
            addCriterion("is_certificate in", values, "isCertificate");
            return (Criteria) this;
        }

        public Criteria andIsCertificateNotIn(List<Integer> values) {
            addCriterion("is_certificate not in", values, "isCertificate");
            return (Criteria) this;
        }

        public Criteria andIsCertificateBetween(Integer value1, Integer value2) {
            addCriterion("is_certificate between", value1, value2, "isCertificate");
            return (Criteria) this;
        }

        public Criteria andIsCertificateNotBetween(Integer value1, Integer value2) {
            addCriterion("is_certificate not between", value1, value2, "isCertificate");
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