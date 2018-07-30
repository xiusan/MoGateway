package com.mogateway.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AgreementCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AgreementCriteria() {
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

        public Criteria andAgreementNameIsNull() {
            addCriterion("agreement_name is null");
            return (Criteria) this;
        }

        public Criteria andAgreementNameIsNotNull() {
            addCriterion("agreement_name is not null");
            return (Criteria) this;
        }

        public Criteria andAgreementNameEqualTo(String value) {
            addCriterion("agreement_name =", value, "agreementName");
            return (Criteria) this;
        }

        public Criteria andAgreementNameNotEqualTo(String value) {
            addCriterion("agreement_name <>", value, "agreementName");
            return (Criteria) this;
        }

        public Criteria andAgreementNameGreaterThan(String value) {
            addCriterion("agreement_name >", value, "agreementName");
            return (Criteria) this;
        }

        public Criteria andAgreementNameGreaterThanOrEqualTo(String value) {
            addCriterion("agreement_name >=", value, "agreementName");
            return (Criteria) this;
        }

        public Criteria andAgreementNameLessThan(String value) {
            addCriterion("agreement_name <", value, "agreementName");
            return (Criteria) this;
        }

        public Criteria andAgreementNameLessThanOrEqualTo(String value) {
            addCriterion("agreement_name <=", value, "agreementName");
            return (Criteria) this;
        }

        public Criteria andAgreementNameLike(String value) {
            addCriterion("agreement_name like", value, "agreementName");
            return (Criteria) this;
        }

        public Criteria andAgreementNameNotLike(String value) {
            addCriterion("agreement_name not like", value, "agreementName");
            return (Criteria) this;
        }

        public Criteria andAgreementNameIn(List<String> values) {
            addCriterion("agreement_name in", values, "agreementName");
            return (Criteria) this;
        }

        public Criteria andAgreementNameNotIn(List<String> values) {
            addCriterion("agreement_name not in", values, "agreementName");
            return (Criteria) this;
        }

        public Criteria andAgreementNameBetween(String value1, String value2) {
            addCriterion("agreement_name between", value1, value2, "agreementName");
            return (Criteria) this;
        }

        public Criteria andAgreementNameNotBetween(String value1, String value2) {
            addCriterion("agreement_name not between", value1, value2, "agreementName");
            return (Criteria) this;
        }

        public Criteria andAgreementAddrIsNull() {
            addCriterion("agreement_addr is null");
            return (Criteria) this;
        }

        public Criteria andAgreementAddrIsNotNull() {
            addCriterion("agreement_addr is not null");
            return (Criteria) this;
        }

        public Criteria andAgreementAddrEqualTo(String value) {
            addCriterion("agreement_addr =", value, "agreementAddr");
            return (Criteria) this;
        }

        public Criteria andAgreementAddrNotEqualTo(String value) {
            addCriterion("agreement_addr <>", value, "agreementAddr");
            return (Criteria) this;
        }

        public Criteria andAgreementAddrGreaterThan(String value) {
            addCriterion("agreement_addr >", value, "agreementAddr");
            return (Criteria) this;
        }

        public Criteria andAgreementAddrGreaterThanOrEqualTo(String value) {
            addCriterion("agreement_addr >=", value, "agreementAddr");
            return (Criteria) this;
        }

        public Criteria andAgreementAddrLessThan(String value) {
            addCriterion("agreement_addr <", value, "agreementAddr");
            return (Criteria) this;
        }

        public Criteria andAgreementAddrLessThanOrEqualTo(String value) {
            addCriterion("agreement_addr <=", value, "agreementAddr");
            return (Criteria) this;
        }

        public Criteria andAgreementAddrLike(String value) {
            addCriterion("agreement_addr like", value, "agreementAddr");
            return (Criteria) this;
        }

        public Criteria andAgreementAddrNotLike(String value) {
            addCriterion("agreement_addr not like", value, "agreementAddr");
            return (Criteria) this;
        }

        public Criteria andAgreementAddrIn(List<String> values) {
            addCriterion("agreement_addr in", values, "agreementAddr");
            return (Criteria) this;
        }

        public Criteria andAgreementAddrNotIn(List<String> values) {
            addCriterion("agreement_addr not in", values, "agreementAddr");
            return (Criteria) this;
        }

        public Criteria andAgreementAddrBetween(String value1, String value2) {
            addCriterion("agreement_addr between", value1, value2, "agreementAddr");
            return (Criteria) this;
        }

        public Criteria andAgreementAddrNotBetween(String value1, String value2) {
            addCriterion("agreement_addr not between", value1, value2, "agreementAddr");
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

        public Criteria andAgreementSubChannelIsNull() {
            addCriterion("agreement_sub_channel is null");
            return (Criteria) this;
        }

        public Criteria andAgreementSubChannelIsNotNull() {
            addCriterion("agreement_sub_channel is not null");
            return (Criteria) this;
        }

        public Criteria andAgreementSubChannelEqualTo(String value) {
            addCriterion("agreement_sub_channel =", value, "agreementSubChannel");
            return (Criteria) this;
        }

        public Criteria andAgreementSubChannelNotEqualTo(String value) {
            addCriterion("agreement_sub_channel <>", value, "agreementSubChannel");
            return (Criteria) this;
        }

        public Criteria andAgreementSubChannelGreaterThan(String value) {
            addCriterion("agreement_sub_channel >", value, "agreementSubChannel");
            return (Criteria) this;
        }

        public Criteria andAgreementSubChannelGreaterThanOrEqualTo(String value) {
            addCriterion("agreement_sub_channel >=", value, "agreementSubChannel");
            return (Criteria) this;
        }

        public Criteria andAgreementSubChannelLessThan(String value) {
            addCriterion("agreement_sub_channel <", value, "agreementSubChannel");
            return (Criteria) this;
        }

        public Criteria andAgreementSubChannelLessThanOrEqualTo(String value) {
            addCriterion("agreement_sub_channel <=", value, "agreementSubChannel");
            return (Criteria) this;
        }

        public Criteria andAgreementSubChannelLike(String value) {
            addCriterion("agreement_sub_channel like", value, "agreementSubChannel");
            return (Criteria) this;
        }

        public Criteria andAgreementSubChannelNotLike(String value) {
            addCriterion("agreement_sub_channel not like", value, "agreementSubChannel");
            return (Criteria) this;
        }

        public Criteria andAgreementSubChannelIn(List<String> values) {
            addCriterion("agreement_sub_channel in", values, "agreementSubChannel");
            return (Criteria) this;
        }

        public Criteria andAgreementSubChannelNotIn(List<String> values) {
            addCriterion("agreement_sub_channel not in", values, "agreementSubChannel");
            return (Criteria) this;
        }

        public Criteria andAgreementSubChannelBetween(String value1, String value2) {
            addCriterion("agreement_sub_channel between", value1, value2, "agreementSubChannel");
            return (Criteria) this;
        }

        public Criteria andAgreementSubChannelNotBetween(String value1, String value2) {
            addCriterion("agreement_sub_channel not between", value1, value2, "agreementSubChannel");
            return (Criteria) this;
        }

        public Criteria andAgreementPubChannelIsNull() {
            addCriterion("agreement_pub_channel is null");
            return (Criteria) this;
        }

        public Criteria andAgreementPubChannelIsNotNull() {
            addCriterion("agreement_pub_channel is not null");
            return (Criteria) this;
        }

        public Criteria andAgreementPubChannelEqualTo(String value) {
            addCriterion("agreement_pub_channel =", value, "agreementPubChannel");
            return (Criteria) this;
        }

        public Criteria andAgreementPubChannelNotEqualTo(String value) {
            addCriterion("agreement_pub_channel <>", value, "agreementPubChannel");
            return (Criteria) this;
        }

        public Criteria andAgreementPubChannelGreaterThan(String value) {
            addCriterion("agreement_pub_channel >", value, "agreementPubChannel");
            return (Criteria) this;
        }

        public Criteria andAgreementPubChannelGreaterThanOrEqualTo(String value) {
            addCriterion("agreement_pub_channel >=", value, "agreementPubChannel");
            return (Criteria) this;
        }

        public Criteria andAgreementPubChannelLessThan(String value) {
            addCriterion("agreement_pub_channel <", value, "agreementPubChannel");
            return (Criteria) this;
        }

        public Criteria andAgreementPubChannelLessThanOrEqualTo(String value) {
            addCriterion("agreement_pub_channel <=", value, "agreementPubChannel");
            return (Criteria) this;
        }

        public Criteria andAgreementPubChannelLike(String value) {
            addCriterion("agreement_pub_channel like", value, "agreementPubChannel");
            return (Criteria) this;
        }

        public Criteria andAgreementPubChannelNotLike(String value) {
            addCriterion("agreement_pub_channel not like", value, "agreementPubChannel");
            return (Criteria) this;
        }

        public Criteria andAgreementPubChannelIn(List<String> values) {
            addCriterion("agreement_pub_channel in", values, "agreementPubChannel");
            return (Criteria) this;
        }

        public Criteria andAgreementPubChannelNotIn(List<String> values) {
            addCriterion("agreement_pub_channel not in", values, "agreementPubChannel");
            return (Criteria) this;
        }

        public Criteria andAgreementPubChannelBetween(String value1, String value2) {
            addCriterion("agreement_pub_channel between", value1, value2, "agreementPubChannel");
            return (Criteria) this;
        }

        public Criteria andAgreementPubChannelNotBetween(String value1, String value2) {
            addCriterion("agreement_pub_channel not between", value1, value2, "agreementPubChannel");
            return (Criteria) this;
        }

        public Criteria andAgreementHomeUrlIsNull() {
            addCriterion("agreement_home_url is null");
            return (Criteria) this;
        }

        public Criteria andAgreementHomeUrlIsNotNull() {
            addCriterion("agreement_home_url is not null");
            return (Criteria) this;
        }

        public Criteria andAgreementHomeUrlEqualTo(String value) {
            addCriterion("agreement_home_url =", value, "agreementHomeUrl");
            return (Criteria) this;
        }

        public Criteria andAgreementHomeUrlNotEqualTo(String value) {
            addCriterion("agreement_home_url <>", value, "agreementHomeUrl");
            return (Criteria) this;
        }

        public Criteria andAgreementHomeUrlGreaterThan(String value) {
            addCriterion("agreement_home_url >", value, "agreementHomeUrl");
            return (Criteria) this;
        }

        public Criteria andAgreementHomeUrlGreaterThanOrEqualTo(String value) {
            addCriterion("agreement_home_url >=", value, "agreementHomeUrl");
            return (Criteria) this;
        }

        public Criteria andAgreementHomeUrlLessThan(String value) {
            addCriterion("agreement_home_url <", value, "agreementHomeUrl");
            return (Criteria) this;
        }

        public Criteria andAgreementHomeUrlLessThanOrEqualTo(String value) {
            addCriterion("agreement_home_url <=", value, "agreementHomeUrl");
            return (Criteria) this;
        }

        public Criteria andAgreementHomeUrlLike(String value) {
            addCriterion("agreement_home_url like", value, "agreementHomeUrl");
            return (Criteria) this;
        }

        public Criteria andAgreementHomeUrlNotLike(String value) {
            addCriterion("agreement_home_url not like", value, "agreementHomeUrl");
            return (Criteria) this;
        }

        public Criteria andAgreementHomeUrlIn(List<String> values) {
            addCriterion("agreement_home_url in", values, "agreementHomeUrl");
            return (Criteria) this;
        }

        public Criteria andAgreementHomeUrlNotIn(List<String> values) {
            addCriterion("agreement_home_url not in", values, "agreementHomeUrl");
            return (Criteria) this;
        }

        public Criteria andAgreementHomeUrlBetween(String value1, String value2) {
            addCriterion("agreement_home_url between", value1, value2, "agreementHomeUrl");
            return (Criteria) this;
        }

        public Criteria andAgreementHomeUrlNotBetween(String value1, String value2) {
            addCriterion("agreement_home_url not between", value1, value2, "agreementHomeUrl");
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