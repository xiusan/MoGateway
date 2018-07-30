package com.mogateway.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TaskCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TaskCriteria() {
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

        public Criteria andTimedTaskIdIsNull() {
            addCriterion("timed_task_id is null");
            return (Criteria) this;
        }

        public Criteria andTimedTaskIdIsNotNull() {
            addCriterion("timed_task_id is not null");
            return (Criteria) this;
        }

        public Criteria andTimedTaskIdEqualTo(String value) {
            addCriterion("timed_task_id =", value, "timedTaskId");
            return (Criteria) this;
        }

        public Criteria andTimedTaskIdNotEqualTo(String value) {
            addCriterion("timed_task_id <>", value, "timedTaskId");
            return (Criteria) this;
        }

        public Criteria andTimedTaskIdGreaterThan(String value) {
            addCriterion("timed_task_id >", value, "timedTaskId");
            return (Criteria) this;
        }

        public Criteria andTimedTaskIdGreaterThanOrEqualTo(String value) {
            addCriterion("timed_task_id >=", value, "timedTaskId");
            return (Criteria) this;
        }

        public Criteria andTimedTaskIdLessThan(String value) {
            addCriterion("timed_task_id <", value, "timedTaskId");
            return (Criteria) this;
        }

        public Criteria andTimedTaskIdLessThanOrEqualTo(String value) {
            addCriterion("timed_task_id <=", value, "timedTaskId");
            return (Criteria) this;
        }

        public Criteria andTimedTaskIdLike(String value) {
            addCriterion("timed_task_id like", value, "timedTaskId");
            return (Criteria) this;
        }

        public Criteria andTimedTaskIdNotLike(String value) {
            addCriterion("timed_task_id not like", value, "timedTaskId");
            return (Criteria) this;
        }

        public Criteria andTimedTaskIdIn(List<String> values) {
            addCriterion("timed_task_id in", values, "timedTaskId");
            return (Criteria) this;
        }

        public Criteria andTimedTaskIdNotIn(List<String> values) {
            addCriterion("timed_task_id not in", values, "timedTaskId");
            return (Criteria) this;
        }

        public Criteria andTimedTaskIdBetween(String value1, String value2) {
            addCriterion("timed_task_id between", value1, value2, "timedTaskId");
            return (Criteria) this;
        }

        public Criteria andTimedTaskIdNotBetween(String value1, String value2) {
            addCriterion("timed_task_id not between", value1, value2, "timedTaskId");
            return (Criteria) this;
        }

        public Criteria andTimedTaskNameIsNull() {
            addCriterion("timed_task_name is null");
            return (Criteria) this;
        }

        public Criteria andTimedTaskNameIsNotNull() {
            addCriterion("timed_task_name is not null");
            return (Criteria) this;
        }

        public Criteria andTimedTaskNameEqualTo(String value) {
            addCriterion("timed_task_name =", value, "timedTaskName");
            return (Criteria) this;
        }

        public Criteria andTimedTaskNameNotEqualTo(String value) {
            addCriterion("timed_task_name <>", value, "timedTaskName");
            return (Criteria) this;
        }

        public Criteria andTimedTaskNameGreaterThan(String value) {
            addCriterion("timed_task_name >", value, "timedTaskName");
            return (Criteria) this;
        }

        public Criteria andTimedTaskNameGreaterThanOrEqualTo(String value) {
            addCriterion("timed_task_name >=", value, "timedTaskName");
            return (Criteria) this;
        }

        public Criteria andTimedTaskNameLessThan(String value) {
            addCriterion("timed_task_name <", value, "timedTaskName");
            return (Criteria) this;
        }

        public Criteria andTimedTaskNameLessThanOrEqualTo(String value) {
            addCriterion("timed_task_name <=", value, "timedTaskName");
            return (Criteria) this;
        }

        public Criteria andTimedTaskNameLike(String value) {
            addCriterion("timed_task_name like", value, "timedTaskName");
            return (Criteria) this;
        }

        public Criteria andTimedTaskNameNotLike(String value) {
            addCriterion("timed_task_name not like", value, "timedTaskName");
            return (Criteria) this;
        }

        public Criteria andTimedTaskNameIn(List<String> values) {
            addCriterion("timed_task_name in", values, "timedTaskName");
            return (Criteria) this;
        }

        public Criteria andTimedTaskNameNotIn(List<String> values) {
            addCriterion("timed_task_name not in", values, "timedTaskName");
            return (Criteria) this;
        }

        public Criteria andTimedTaskNameBetween(String value1, String value2) {
            addCriterion("timed_task_name between", value1, value2, "timedTaskName");
            return (Criteria) this;
        }

        public Criteria andTimedTaskNameNotBetween(String value1, String value2) {
            addCriterion("timed_task_name not between", value1, value2, "timedTaskName");
            return (Criteria) this;
        }

        public Criteria andLastExecuTimeIsNull() {
            addCriterion("last_execu_time is null");
            return (Criteria) this;
        }

        public Criteria andLastExecuTimeIsNotNull() {
            addCriterion("last_execu_time is not null");
            return (Criteria) this;
        }

        public Criteria andLastExecuTimeEqualTo(Date value) {
            addCriterion("last_execu_time =", value, "lastExecuTime");
            return (Criteria) this;
        }

        public Criteria andLastExecuTimeNotEqualTo(Date value) {
            addCriterion("last_execu_time <>", value, "lastExecuTime");
            return (Criteria) this;
        }

        public Criteria andLastExecuTimeGreaterThan(Date value) {
            addCriterion("last_execu_time >", value, "lastExecuTime");
            return (Criteria) this;
        }

        public Criteria andLastExecuTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("last_execu_time >=", value, "lastExecuTime");
            return (Criteria) this;
        }

        public Criteria andLastExecuTimeLessThan(Date value) {
            addCriterion("last_execu_time <", value, "lastExecuTime");
            return (Criteria) this;
        }

        public Criteria andLastExecuTimeLessThanOrEqualTo(Date value) {
            addCriterion("last_execu_time <=", value, "lastExecuTime");
            return (Criteria) this;
        }

        public Criteria andLastExecuTimeIn(List<Date> values) {
            addCriterion("last_execu_time in", values, "lastExecuTime");
            return (Criteria) this;
        }

        public Criteria andLastExecuTimeNotIn(List<Date> values) {
            addCriterion("last_execu_time not in", values, "lastExecuTime");
            return (Criteria) this;
        }

        public Criteria andLastExecuTimeBetween(Date value1, Date value2) {
            addCriterion("last_execu_time between", value1, value2, "lastExecuTime");
            return (Criteria) this;
        }

        public Criteria andLastExecuTimeNotBetween(Date value1, Date value2) {
            addCriterion("last_execu_time not between", value1, value2, "lastExecuTime");
            return (Criteria) this;
        }

        public Criteria andNextExecuTimeIsNull() {
            addCriterion("next_execu_time is null");
            return (Criteria) this;
        }

        public Criteria andNextExecuTimeIsNotNull() {
            addCriterion("next_execu_time is not null");
            return (Criteria) this;
        }

        public Criteria andNextExecuTimeEqualTo(Date value) {
            addCriterion("next_execu_time =", value, "nextExecuTime");
            return (Criteria) this;
        }

        public Criteria andNextExecuTimeNotEqualTo(Date value) {
            addCriterion("next_execu_time <>", value, "nextExecuTime");
            return (Criteria) this;
        }

        public Criteria andNextExecuTimeGreaterThan(Date value) {
            addCriterion("next_execu_time >", value, "nextExecuTime");
            return (Criteria) this;
        }

        public Criteria andNextExecuTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("next_execu_time >=", value, "nextExecuTime");
            return (Criteria) this;
        }

        public Criteria andNextExecuTimeLessThan(Date value) {
            addCriterion("next_execu_time <", value, "nextExecuTime");
            return (Criteria) this;
        }

        public Criteria andNextExecuTimeLessThanOrEqualTo(Date value) {
            addCriterion("next_execu_time <=", value, "nextExecuTime");
            return (Criteria) this;
        }

        public Criteria andNextExecuTimeIn(List<Date> values) {
            addCriterion("next_execu_time in", values, "nextExecuTime");
            return (Criteria) this;
        }

        public Criteria andNextExecuTimeNotIn(List<Date> values) {
            addCriterion("next_execu_time not in", values, "nextExecuTime");
            return (Criteria) this;
        }

        public Criteria andNextExecuTimeBetween(Date value1, Date value2) {
            addCriterion("next_execu_time between", value1, value2, "nextExecuTime");
            return (Criteria) this;
        }

        public Criteria andNextExecuTimeNotBetween(Date value1, Date value2) {
            addCriterion("next_execu_time not between", value1, value2, "nextExecuTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNull() {
            addCriterion("start_time is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("start_time is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(Date value) {
            addCriterion("start_time =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(Date value) {
            addCriterion("start_time <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(Date value) {
            addCriterion("start_time >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("start_time >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(Date value) {
            addCriterion("start_time <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("start_time <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<Date> values) {
            addCriterion("start_time in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<Date> values) {
            addCriterion("start_time not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(Date value1, Date value2) {
            addCriterion("start_time between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("start_time not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStopTimeIsNull() {
            addCriterion("stop_time is null");
            return (Criteria) this;
        }

        public Criteria andStopTimeIsNotNull() {
            addCriterion("stop_time is not null");
            return (Criteria) this;
        }

        public Criteria andStopTimeEqualTo(Date value) {
            addCriterion("stop_time =", value, "stopTime");
            return (Criteria) this;
        }

        public Criteria andStopTimeNotEqualTo(Date value) {
            addCriterion("stop_time <>", value, "stopTime");
            return (Criteria) this;
        }

        public Criteria andStopTimeGreaterThan(Date value) {
            addCriterion("stop_time >", value, "stopTime");
            return (Criteria) this;
        }

        public Criteria andStopTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("stop_time >=", value, "stopTime");
            return (Criteria) this;
        }

        public Criteria andStopTimeLessThan(Date value) {
            addCriterion("stop_time <", value, "stopTime");
            return (Criteria) this;
        }

        public Criteria andStopTimeLessThanOrEqualTo(Date value) {
            addCriterion("stop_time <=", value, "stopTime");
            return (Criteria) this;
        }

        public Criteria andStopTimeIn(List<Date> values) {
            addCriterion("stop_time in", values, "stopTime");
            return (Criteria) this;
        }

        public Criteria andStopTimeNotIn(List<Date> values) {
            addCriterion("stop_time not in", values, "stopTime");
            return (Criteria) this;
        }

        public Criteria andStopTimeBetween(Date value1, Date value2) {
            addCriterion("stop_time between", value1, value2, "stopTime");
            return (Criteria) this;
        }

        public Criteria andStopTimeNotBetween(Date value1, Date value2) {
            addCriterion("stop_time not between", value1, value2, "stopTime");
            return (Criteria) this;
        }

        public Criteria andTaskMethodIsNull() {
            addCriterion("task_method is null");
            return (Criteria) this;
        }

        public Criteria andTaskMethodIsNotNull() {
            addCriterion("task_method is not null");
            return (Criteria) this;
        }

        public Criteria andTaskMethodEqualTo(String value) {
            addCriterion("task_method =", value, "taskMethod");
            return (Criteria) this;
        }

        public Criteria andTaskMethodNotEqualTo(String value) {
            addCriterion("task_method <>", value, "taskMethod");
            return (Criteria) this;
        }

        public Criteria andTaskMethodGreaterThan(String value) {
            addCriterion("task_method >", value, "taskMethod");
            return (Criteria) this;
        }

        public Criteria andTaskMethodGreaterThanOrEqualTo(String value) {
            addCriterion("task_method >=", value, "taskMethod");
            return (Criteria) this;
        }

        public Criteria andTaskMethodLessThan(String value) {
            addCriterion("task_method <", value, "taskMethod");
            return (Criteria) this;
        }

        public Criteria andTaskMethodLessThanOrEqualTo(String value) {
            addCriterion("task_method <=", value, "taskMethod");
            return (Criteria) this;
        }

        public Criteria andTaskMethodLike(String value) {
            addCriterion("task_method like", value, "taskMethod");
            return (Criteria) this;
        }

        public Criteria andTaskMethodNotLike(String value) {
            addCriterion("task_method not like", value, "taskMethod");
            return (Criteria) this;
        }

        public Criteria andTaskMethodIn(List<String> values) {
            addCriterion("task_method in", values, "taskMethod");
            return (Criteria) this;
        }

        public Criteria andTaskMethodNotIn(List<String> values) {
            addCriterion("task_method not in", values, "taskMethod");
            return (Criteria) this;
        }

        public Criteria andTaskMethodBetween(String value1, String value2) {
            addCriterion("task_method between", value1, value2, "taskMethod");
            return (Criteria) this;
        }

        public Criteria andTaskMethodNotBetween(String value1, String value2) {
            addCriterion("task_method not between", value1, value2, "taskMethod");
            return (Criteria) this;
        }

        public Criteria andCronExpressionIsNull() {
            addCriterion("cron_expression is null");
            return (Criteria) this;
        }

        public Criteria andCronExpressionIsNotNull() {
            addCriterion("cron_expression is not null");
            return (Criteria) this;
        }

        public Criteria andCronExpressionEqualTo(String value) {
            addCriterion("cron_expression =", value, "cronExpression");
            return (Criteria) this;
        }

        public Criteria andCronExpressionNotEqualTo(String value) {
            addCriterion("cron_expression <>", value, "cronExpression");
            return (Criteria) this;
        }

        public Criteria andCronExpressionGreaterThan(String value) {
            addCriterion("cron_expression >", value, "cronExpression");
            return (Criteria) this;
        }

        public Criteria andCronExpressionGreaterThanOrEqualTo(String value) {
            addCriterion("cron_expression >=", value, "cronExpression");
            return (Criteria) this;
        }

        public Criteria andCronExpressionLessThan(String value) {
            addCriterion("cron_expression <", value, "cronExpression");
            return (Criteria) this;
        }

        public Criteria andCronExpressionLessThanOrEqualTo(String value) {
            addCriterion("cron_expression <=", value, "cronExpression");
            return (Criteria) this;
        }

        public Criteria andCronExpressionLike(String value) {
            addCriterion("cron_expression like", value, "cronExpression");
            return (Criteria) this;
        }

        public Criteria andCronExpressionNotLike(String value) {
            addCriterion("cron_expression not like", value, "cronExpression");
            return (Criteria) this;
        }

        public Criteria andCronExpressionIn(List<String> values) {
            addCriterion("cron_expression in", values, "cronExpression");
            return (Criteria) this;
        }

        public Criteria andCronExpressionNotIn(List<String> values) {
            addCriterion("cron_expression not in", values, "cronExpression");
            return (Criteria) this;
        }

        public Criteria andCronExpressionBetween(String value1, String value2) {
            addCriterion("cron_expression between", value1, value2, "cronExpression");
            return (Criteria) this;
        }

        public Criteria andCronExpressionNotBetween(String value1, String value2) {
            addCriterion("cron_expression not between", value1, value2, "cronExpression");
            return (Criteria) this;
        }

        public Criteria andExecuCountIsNull() {
            addCriterion("execu_count is null");
            return (Criteria) this;
        }

        public Criteria andExecuCountIsNotNull() {
            addCriterion("execu_count is not null");
            return (Criteria) this;
        }

        public Criteria andExecuCountEqualTo(Integer value) {
            addCriterion("execu_count =", value, "execuCount");
            return (Criteria) this;
        }

        public Criteria andExecuCountNotEqualTo(Integer value) {
            addCriterion("execu_count <>", value, "execuCount");
            return (Criteria) this;
        }

        public Criteria andExecuCountGreaterThan(Integer value) {
            addCriterion("execu_count >", value, "execuCount");
            return (Criteria) this;
        }

        public Criteria andExecuCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("execu_count >=", value, "execuCount");
            return (Criteria) this;
        }

        public Criteria andExecuCountLessThan(Integer value) {
            addCriterion("execu_count <", value, "execuCount");
            return (Criteria) this;
        }

        public Criteria andExecuCountLessThanOrEqualTo(Integer value) {
            addCriterion("execu_count <=", value, "execuCount");
            return (Criteria) this;
        }

        public Criteria andExecuCountIn(List<Integer> values) {
            addCriterion("execu_count in", values, "execuCount");
            return (Criteria) this;
        }

        public Criteria andExecuCountNotIn(List<Integer> values) {
            addCriterion("execu_count not in", values, "execuCount");
            return (Criteria) this;
        }

        public Criteria andExecuCountBetween(Integer value1, Integer value2) {
            addCriterion("execu_count between", value1, value2, "execuCount");
            return (Criteria) this;
        }

        public Criteria andExecuCountNotBetween(Integer value1, Integer value2) {
            addCriterion("execu_count not between", value1, value2, "execuCount");
            return (Criteria) this;
        }

        public Criteria andFailCountIsNull() {
            addCriterion("fail_count is null");
            return (Criteria) this;
        }

        public Criteria andFailCountIsNotNull() {
            addCriterion("fail_count is not null");
            return (Criteria) this;
        }

        public Criteria andFailCountEqualTo(Integer value) {
            addCriterion("fail_count =", value, "failCount");
            return (Criteria) this;
        }

        public Criteria andFailCountNotEqualTo(Integer value) {
            addCriterion("fail_count <>", value, "failCount");
            return (Criteria) this;
        }

        public Criteria andFailCountGreaterThan(Integer value) {
            addCriterion("fail_count >", value, "failCount");
            return (Criteria) this;
        }

        public Criteria andFailCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("fail_count >=", value, "failCount");
            return (Criteria) this;
        }

        public Criteria andFailCountLessThan(Integer value) {
            addCriterion("fail_count <", value, "failCount");
            return (Criteria) this;
        }

        public Criteria andFailCountLessThanOrEqualTo(Integer value) {
            addCriterion("fail_count <=", value, "failCount");
            return (Criteria) this;
        }

        public Criteria andFailCountIn(List<Integer> values) {
            addCriterion("fail_count in", values, "failCount");
            return (Criteria) this;
        }

        public Criteria andFailCountNotIn(List<Integer> values) {
            addCriterion("fail_count not in", values, "failCount");
            return (Criteria) this;
        }

        public Criteria andFailCountBetween(Integer value1, Integer value2) {
            addCriterion("fail_count between", value1, value2, "failCount");
            return (Criteria) this;
        }

        public Criteria andFailCountNotBetween(Integer value1, Integer value2) {
            addCriterion("fail_count not between", value1, value2, "failCount");
            return (Criteria) this;
        }

        public Criteria andMissCountIsNull() {
            addCriterion("miss_count is null");
            return (Criteria) this;
        }

        public Criteria andMissCountIsNotNull() {
            addCriterion("miss_count is not null");
            return (Criteria) this;
        }

        public Criteria andMissCountEqualTo(Integer value) {
            addCriterion("miss_count =", value, "missCount");
            return (Criteria) this;
        }

        public Criteria andMissCountNotEqualTo(Integer value) {
            addCriterion("miss_count <>", value, "missCount");
            return (Criteria) this;
        }

        public Criteria andMissCountGreaterThan(Integer value) {
            addCriterion("miss_count >", value, "missCount");
            return (Criteria) this;
        }

        public Criteria andMissCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("miss_count >=", value, "missCount");
            return (Criteria) this;
        }

        public Criteria andMissCountLessThan(Integer value) {
            addCriterion("miss_count <", value, "missCount");
            return (Criteria) this;
        }

        public Criteria andMissCountLessThanOrEqualTo(Integer value) {
            addCriterion("miss_count <=", value, "missCount");
            return (Criteria) this;
        }

        public Criteria andMissCountIn(List<Integer> values) {
            addCriterion("miss_count in", values, "missCount");
            return (Criteria) this;
        }

        public Criteria andMissCountNotIn(List<Integer> values) {
            addCriterion("miss_count not in", values, "missCount");
            return (Criteria) this;
        }

        public Criteria andMissCountBetween(Integer value1, Integer value2) {
            addCriterion("miss_count between", value1, value2, "missCount");
            return (Criteria) this;
        }

        public Criteria andMissCountNotBetween(Integer value1, Integer value2) {
            addCriterion("miss_count not between", value1, value2, "missCount");
            return (Criteria) this;
        }

        public Criteria andExecuCycleIsNull() {
            addCriterion("execu_cycle is null");
            return (Criteria) this;
        }

        public Criteria andExecuCycleIsNotNull() {
            addCriterion("execu_cycle is not null");
            return (Criteria) this;
        }

        public Criteria andExecuCycleEqualTo(Integer value) {
            addCriterion("execu_cycle =", value, "execuCycle");
            return (Criteria) this;
        }

        public Criteria andExecuCycleNotEqualTo(Integer value) {
            addCriterion("execu_cycle <>", value, "execuCycle");
            return (Criteria) this;
        }

        public Criteria andExecuCycleGreaterThan(Integer value) {
            addCriterion("execu_cycle >", value, "execuCycle");
            return (Criteria) this;
        }

        public Criteria andExecuCycleGreaterThanOrEqualTo(Integer value) {
            addCriterion("execu_cycle >=", value, "execuCycle");
            return (Criteria) this;
        }

        public Criteria andExecuCycleLessThan(Integer value) {
            addCriterion("execu_cycle <", value, "execuCycle");
            return (Criteria) this;
        }

        public Criteria andExecuCycleLessThanOrEqualTo(Integer value) {
            addCriterion("execu_cycle <=", value, "execuCycle");
            return (Criteria) this;
        }

        public Criteria andExecuCycleIn(List<Integer> values) {
            addCriterion("execu_cycle in", values, "execuCycle");
            return (Criteria) this;
        }

        public Criteria andExecuCycleNotIn(List<Integer> values) {
            addCriterion("execu_cycle not in", values, "execuCycle");
            return (Criteria) this;
        }

        public Criteria andExecuCycleBetween(Integer value1, Integer value2) {
            addCriterion("execu_cycle between", value1, value2, "execuCycle");
            return (Criteria) this;
        }

        public Criteria andExecuCycleNotBetween(Integer value1, Integer value2) {
            addCriterion("execu_cycle not between", value1, value2, "execuCycle");
            return (Criteria) this;
        }

        public Criteria andCycleIsNull() {
            addCriterion("cycle is null");
            return (Criteria) this;
        }

        public Criteria andCycleIsNotNull() {
            addCriterion("cycle is not null");
            return (Criteria) this;
        }

        public Criteria andCycleEqualTo(Integer value) {
            addCriterion("cycle =", value, "cycle");
            return (Criteria) this;
        }

        public Criteria andCycleNotEqualTo(Integer value) {
            addCriterion("cycle <>", value, "cycle");
            return (Criteria) this;
        }

        public Criteria andCycleGreaterThan(Integer value) {
            addCriterion("cycle >", value, "cycle");
            return (Criteria) this;
        }

        public Criteria andCycleGreaterThanOrEqualTo(Integer value) {
            addCriterion("cycle >=", value, "cycle");
            return (Criteria) this;
        }

        public Criteria andCycleLessThan(Integer value) {
            addCriterion("cycle <", value, "cycle");
            return (Criteria) this;
        }

        public Criteria andCycleLessThanOrEqualTo(Integer value) {
            addCriterion("cycle <=", value, "cycle");
            return (Criteria) this;
        }

        public Criteria andCycleIn(List<Integer> values) {
            addCriterion("cycle in", values, "cycle");
            return (Criteria) this;
        }

        public Criteria andCycleNotIn(List<Integer> values) {
            addCriterion("cycle not in", values, "cycle");
            return (Criteria) this;
        }

        public Criteria andCycleBetween(Integer value1, Integer value2) {
            addCriterion("cycle between", value1, value2, "cycle");
            return (Criteria) this;
        }

        public Criteria andCycleNotBetween(Integer value1, Integer value2) {
            addCriterion("cycle not between", value1, value2, "cycle");
            return (Criteria) this;
        }

        public Criteria andTaskStatusIsNull() {
            addCriterion("task_status is null");
            return (Criteria) this;
        }

        public Criteria andTaskStatusIsNotNull() {
            addCriterion("task_status is not null");
            return (Criteria) this;
        }

        public Criteria andTaskStatusEqualTo(Integer value) {
            addCriterion("task_status =", value, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusNotEqualTo(Integer value) {
            addCriterion("task_status <>", value, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusGreaterThan(Integer value) {
            addCriterion("task_status >", value, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("task_status >=", value, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusLessThan(Integer value) {
            addCriterion("task_status <", value, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusLessThanOrEqualTo(Integer value) {
            addCriterion("task_status <=", value, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusIn(List<Integer> values) {
            addCriterion("task_status in", values, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusNotIn(List<Integer> values) {
            addCriterion("task_status not in", values, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusBetween(Integer value1, Integer value2) {
            addCriterion("task_status between", value1, value2, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("task_status not between", value1, value2, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIsNull() {
            addCriterion("create_user_id is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIsNotNull() {
            addCriterion("create_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdEqualTo(String value) {
            addCriterion("create_user_id =", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotEqualTo(String value) {
            addCriterion("create_user_id <>", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdGreaterThan(String value) {
            addCriterion("create_user_id >", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("create_user_id >=", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdLessThan(String value) {
            addCriterion("create_user_id <", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdLessThanOrEqualTo(String value) {
            addCriterion("create_user_id <=", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdLike(String value) {
            addCriterion("create_user_id like", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotLike(String value) {
            addCriterion("create_user_id not like", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIn(List<String> values) {
            addCriterion("create_user_id in", values, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotIn(List<String> values) {
            addCriterion("create_user_id not in", values, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdBetween(String value1, String value2) {
            addCriterion("create_user_id between", value1, value2, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotBetween(String value1, String value2) {
            addCriterion("create_user_id not between", value1, value2, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreadateIsNull() {
            addCriterion("creadate is null");
            return (Criteria) this;
        }

        public Criteria andCreadateIsNotNull() {
            addCriterion("creadate is not null");
            return (Criteria) this;
        }

        public Criteria andCreadateEqualTo(Date value) {
            addCriterion("creadate =", value, "creadate");
            return (Criteria) this;
        }

        public Criteria andCreadateNotEqualTo(Date value) {
            addCriterion("creadate <>", value, "creadate");
            return (Criteria) this;
        }

        public Criteria andCreadateGreaterThan(Date value) {
            addCriterion("creadate >", value, "creadate");
            return (Criteria) this;
        }

        public Criteria andCreadateGreaterThanOrEqualTo(Date value) {
            addCriterion("creadate >=", value, "creadate");
            return (Criteria) this;
        }

        public Criteria andCreadateLessThan(Date value) {
            addCriterion("creadate <", value, "creadate");
            return (Criteria) this;
        }

        public Criteria andCreadateLessThanOrEqualTo(Date value) {
            addCriterion("creadate <=", value, "creadate");
            return (Criteria) this;
        }

        public Criteria andCreadateIn(List<Date> values) {
            addCriterion("creadate in", values, "creadate");
            return (Criteria) this;
        }

        public Criteria andCreadateNotIn(List<Date> values) {
            addCriterion("creadate not in", values, "creadate");
            return (Criteria) this;
        }

        public Criteria andCreadateBetween(Date value1, Date value2) {
            addCriterion("creadate between", value1, value2, "creadate");
            return (Criteria) this;
        }

        public Criteria andCreadateNotBetween(Date value1, Date value2) {
            addCriterion("creadate not between", value1, value2, "creadate");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdIsNull() {
            addCriterion("update_user_id is null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdIsNotNull() {
            addCriterion("update_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdEqualTo(String value) {
            addCriterion("update_user_id =", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdNotEqualTo(String value) {
            addCriterion("update_user_id <>", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdGreaterThan(String value) {
            addCriterion("update_user_id >", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("update_user_id >=", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdLessThan(String value) {
            addCriterion("update_user_id <", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdLessThanOrEqualTo(String value) {
            addCriterion("update_user_id <=", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdLike(String value) {
            addCriterion("update_user_id like", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdNotLike(String value) {
            addCriterion("update_user_id not like", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdIn(List<String> values) {
            addCriterion("update_user_id in", values, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdNotIn(List<String> values) {
            addCriterion("update_user_id not in", values, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdBetween(String value1, String value2) {
            addCriterion("update_user_id between", value1, value2, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdNotBetween(String value1, String value2) {
            addCriterion("update_user_id not between", value1, value2, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNull() {
            addCriterion("update_date is null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNotNull() {
            addCriterion("update_date is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateEqualTo(Date value) {
            addCriterion("update_date =", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotEqualTo(Date value) {
            addCriterion("update_date <>", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThan(Date value) {
            addCriterion("update_date >", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("update_date >=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThan(Date value) {
            addCriterion("update_date <", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThanOrEqualTo(Date value) {
            addCriterion("update_date <=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIn(List<Date> values) {
            addCriterion("update_date in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotIn(List<Date> values) {
            addCriterion("update_date not in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateBetween(Date value1, Date value2) {
            addCriterion("update_date between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotBetween(Date value1, Date value2) {
            addCriterion("update_date not between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andJobGroupNameIsNull() {
            addCriterion("job_group_name is null");
            return (Criteria) this;
        }

        public Criteria andJobGroupNameIsNotNull() {
            addCriterion("job_group_name is not null");
            return (Criteria) this;
        }

        public Criteria andJobGroupNameEqualTo(String value) {
            addCriterion("job_group_name =", value, "jobGroupName");
            return (Criteria) this;
        }

        public Criteria andJobGroupNameNotEqualTo(String value) {
            addCriterion("job_group_name <>", value, "jobGroupName");
            return (Criteria) this;
        }

        public Criteria andJobGroupNameGreaterThan(String value) {
            addCriterion("job_group_name >", value, "jobGroupName");
            return (Criteria) this;
        }

        public Criteria andJobGroupNameGreaterThanOrEqualTo(String value) {
            addCriterion("job_group_name >=", value, "jobGroupName");
            return (Criteria) this;
        }

        public Criteria andJobGroupNameLessThan(String value) {
            addCriterion("job_group_name <", value, "jobGroupName");
            return (Criteria) this;
        }

        public Criteria andJobGroupNameLessThanOrEqualTo(String value) {
            addCriterion("job_group_name <=", value, "jobGroupName");
            return (Criteria) this;
        }

        public Criteria andJobGroupNameLike(String value) {
            addCriterion("job_group_name like", value, "jobGroupName");
            return (Criteria) this;
        }

        public Criteria andJobGroupNameNotLike(String value) {
            addCriterion("job_group_name not like", value, "jobGroupName");
            return (Criteria) this;
        }

        public Criteria andJobGroupNameIn(List<String> values) {
            addCriterion("job_group_name in", values, "jobGroupName");
            return (Criteria) this;
        }

        public Criteria andJobGroupNameNotIn(List<String> values) {
            addCriterion("job_group_name not in", values, "jobGroupName");
            return (Criteria) this;
        }

        public Criteria andJobGroupNameBetween(String value1, String value2) {
            addCriterion("job_group_name between", value1, value2, "jobGroupName");
            return (Criteria) this;
        }

        public Criteria andJobGroupNameNotBetween(String value1, String value2) {
            addCriterion("job_group_name not between", value1, value2, "jobGroupName");
            return (Criteria) this;
        }

        public Criteria andMethodIsNull() {
            addCriterion("method is null");
            return (Criteria) this;
        }

        public Criteria andMethodIsNotNull() {
            addCriterion("method is not null");
            return (Criteria) this;
        }

        public Criteria andMethodEqualTo(String value) {
            addCriterion("method =", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodNotEqualTo(String value) {
            addCriterion("method <>", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodGreaterThan(String value) {
            addCriterion("method >", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodGreaterThanOrEqualTo(String value) {
            addCriterion("method >=", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodLessThan(String value) {
            addCriterion("method <", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodLessThanOrEqualTo(String value) {
            addCriterion("method <=", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodLike(String value) {
            addCriterion("method like", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodNotLike(String value) {
            addCriterion("method not like", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodIn(List<String> values) {
            addCriterion("method in", values, "method");
            return (Criteria) this;
        }

        public Criteria andMethodNotIn(List<String> values) {
            addCriterion("method not in", values, "method");
            return (Criteria) this;
        }

        public Criteria andMethodBetween(String value1, String value2) {
            addCriterion("method between", value1, value2, "method");
            return (Criteria) this;
        }

        public Criteria andMethodNotBetween(String value1, String value2) {
            addCriterion("method not between", value1, value2, "method");
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