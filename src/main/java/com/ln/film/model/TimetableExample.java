package com.ln.film.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TimetableExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TimetableExample() {
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

        public Criteria andTidIsNull() {
            addCriterion("Tid is null");
            return (Criteria) this;
        }

        public Criteria andTidIsNotNull() {
            addCriterion("Tid is not null");
            return (Criteria) this;
        }

        public Criteria andTidEqualTo(Integer value) {
            addCriterion("Tid =", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotEqualTo(Integer value) {
            addCriterion("Tid <>", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidGreaterThan(Integer value) {
            addCriterion("Tid >", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidGreaterThanOrEqualTo(Integer value) {
            addCriterion("Tid >=", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidLessThan(Integer value) {
            addCriterion("Tid <", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidLessThanOrEqualTo(Integer value) {
            addCriterion("Tid <=", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidIn(List<Integer> values) {
            addCriterion("Tid in", values, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotIn(List<Integer> values) {
            addCriterion("Tid not in", values, "tid");
            return (Criteria) this;
        }

        public Criteria andTidBetween(Integer value1, Integer value2) {
            addCriterion("Tid between", value1, value2, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotBetween(Integer value1, Integer value2) {
            addCriterion("Tid not between", value1, value2, "tid");
            return (Criteria) this;
        }

        public Criteria andTfidIsNull() {
            addCriterion("TFid is null");
            return (Criteria) this;
        }

        public Criteria andTfidIsNotNull() {
            addCriterion("TFid is not null");
            return (Criteria) this;
        }

        public Criteria andTfidEqualTo(Integer value) {
            addCriterion("TFid =", value, "tfid");
            return (Criteria) this;
        }

        public Criteria andTfidNotEqualTo(Integer value) {
            addCriterion("TFid <>", value, "tfid");
            return (Criteria) this;
        }

        public Criteria andTfidGreaterThan(Integer value) {
            addCriterion("TFid >", value, "tfid");
            return (Criteria) this;
        }

        public Criteria andTfidGreaterThanOrEqualTo(Integer value) {
            addCriterion("TFid >=", value, "tfid");
            return (Criteria) this;
        }

        public Criteria andTfidLessThan(Integer value) {
            addCriterion("TFid <", value, "tfid");
            return (Criteria) this;
        }

        public Criteria andTfidLessThanOrEqualTo(Integer value) {
            addCriterion("TFid <=", value, "tfid");
            return (Criteria) this;
        }

        public Criteria andTfidIn(List<Integer> values) {
            addCriterion("TFid in", values, "tfid");
            return (Criteria) this;
        }

        public Criteria andTfidNotIn(List<Integer> values) {
            addCriterion("TFid not in", values, "tfid");
            return (Criteria) this;
        }

        public Criteria andTfidBetween(Integer value1, Integer value2) {
            addCriterion("TFid between", value1, value2, "tfid");
            return (Criteria) this;
        }

        public Criteria andTfidNotBetween(Integer value1, Integer value2) {
            addCriterion("TFid not between", value1, value2, "tfid");
            return (Criteria) this;
        }

        public Criteria andThallidIsNull() {
            addCriterion("THallID is null");
            return (Criteria) this;
        }

        public Criteria andThallidIsNotNull() {
            addCriterion("THallID is not null");
            return (Criteria) this;
        }

        public Criteria andThallidEqualTo(Integer value) {
            addCriterion("THallID =", value, "thallid");
            return (Criteria) this;
        }

        public Criteria andThallidNotEqualTo(Integer value) {
            addCriterion("THallID <>", value, "thallid");
            return (Criteria) this;
        }

        public Criteria andThallidGreaterThan(Integer value) {
            addCriterion("THallID >", value, "thallid");
            return (Criteria) this;
        }

        public Criteria andThallidGreaterThanOrEqualTo(Integer value) {
            addCriterion("THallID >=", value, "thallid");
            return (Criteria) this;
        }

        public Criteria andThallidLessThan(Integer value) {
            addCriterion("THallID <", value, "thallid");
            return (Criteria) this;
        }

        public Criteria andThallidLessThanOrEqualTo(Integer value) {
            addCriterion("THallID <=", value, "thallid");
            return (Criteria) this;
        }

        public Criteria andThallidIn(List<Integer> values) {
            addCriterion("THallID in", values, "thallid");
            return (Criteria) this;
        }

        public Criteria andThallidNotIn(List<Integer> values) {
            addCriterion("THallID not in", values, "thallid");
            return (Criteria) this;
        }

        public Criteria andThallidBetween(Integer value1, Integer value2) {
            addCriterion("THallID between", value1, value2, "thallid");
            return (Criteria) this;
        }

        public Criteria andThallidNotBetween(Integer value1, Integer value2) {
            addCriterion("THallID not between", value1, value2, "thallid");
            return (Criteria) this;
        }

        public Criteria andTdateIsNull() {
            addCriterion("TDate is null");
            return (Criteria) this;
        }

        public Criteria andTdateIsNotNull() {
            addCriterion("TDate is not null");
            return (Criteria) this;
        }

        public Criteria andTdateEqualTo(Date value) {
            addCriterionForJDBCDate("TDate =", value, "tdate");
            return (Criteria) this;
        }

        public Criteria andTdateNotEqualTo(Date value) {
            addCriterionForJDBCDate("TDate <>", value, "tdate");
            return (Criteria) this;
        }

        public Criteria andTdateGreaterThan(Date value) {
            addCriterionForJDBCDate("TDate >", value, "tdate");
            return (Criteria) this;
        }

        public Criteria andTdateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("TDate >=", value, "tdate");
            return (Criteria) this;
        }

        public Criteria andTdateLessThan(Date value) {
            addCriterionForJDBCDate("TDate <", value, "tdate");
            return (Criteria) this;
        }

        public Criteria andTdateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("TDate <=", value, "tdate");
            return (Criteria) this;
        }

        public Criteria andTdateIn(List<Date> values) {
            addCriterionForJDBCDate("TDate in", values, "tdate");
            return (Criteria) this;
        }

        public Criteria andTdateNotIn(List<Date> values) {
            addCriterionForJDBCDate("TDate not in", values, "tdate");
            return (Criteria) this;
        }

        public Criteria andTdateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("TDate between", value1, value2, "tdate");
            return (Criteria) this;
        }

        public Criteria andTdateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("TDate not between", value1, value2, "tdate");
            return (Criteria) this;
        }

        public Criteria andTtimeIsNull() {
            addCriterion("TTime is null");
            return (Criteria) this;
        }

        public Criteria andTtimeIsNotNull() {
            addCriterion("TTime is not null");
            return (Criteria) this;
        }

        public Criteria andTtimeEqualTo(Date value) {
            addCriterionForJDBCTime("TTime =", value, "ttime");
            return (Criteria) this;
        }

        public Criteria andTtimeNotEqualTo(Date value) {
            addCriterionForJDBCTime("TTime <>", value, "ttime");
            return (Criteria) this;
        }

        public Criteria andTtimeGreaterThan(Date value) {
            addCriterionForJDBCTime("TTime >", value, "ttime");
            return (Criteria) this;
        }

        public Criteria andTtimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("TTime >=", value, "ttime");
            return (Criteria) this;
        }

        public Criteria andTtimeLessThan(Date value) {
            addCriterionForJDBCTime("TTime <", value, "ttime");
            return (Criteria) this;
        }

        public Criteria andTtimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("TTime <=", value, "ttime");
            return (Criteria) this;
        }

        public Criteria andTtimeIn(List<Date> values) {
            addCriterionForJDBCTime("TTime in", values, "ttime");
            return (Criteria) this;
        }

        public Criteria andTtimeNotIn(List<Date> values) {
            addCriterionForJDBCTime("TTime not in", values, "ttime");
            return (Criteria) this;
        }

        public Criteria andTtimeBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("TTime between", value1, value2, "ttime");
            return (Criteria) this;
        }

        public Criteria andTtimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("TTime not between", value1, value2, "ttime");
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