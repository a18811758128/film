package com.ln.film.model;

import java.util.ArrayList;
import java.util.List;

public class SeatExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SeatExample() {
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

        public Criteria andSeidIsNull() {
            addCriterion("Seid is null");
            return (Criteria) this;
        }

        public Criteria andSeidIsNotNull() {
            addCriterion("Seid is not null");
            return (Criteria) this;
        }

        public Criteria andSeidEqualTo(Integer value) {
            addCriterion("Seid =", value, "seid");
            return (Criteria) this;
        }

        public Criteria andSeidNotEqualTo(Integer value) {
            addCriterion("Seid <>", value, "seid");
            return (Criteria) this;
        }

        public Criteria andSeidGreaterThan(Integer value) {
            addCriterion("Seid >", value, "seid");
            return (Criteria) this;
        }

        public Criteria andSeidGreaterThanOrEqualTo(Integer value) {
            addCriterion("Seid >=", value, "seid");
            return (Criteria) this;
        }

        public Criteria andSeidLessThan(Integer value) {
            addCriterion("Seid <", value, "seid");
            return (Criteria) this;
        }

        public Criteria andSeidLessThanOrEqualTo(Integer value) {
            addCriterion("Seid <=", value, "seid");
            return (Criteria) this;
        }

        public Criteria andSeidIn(List<Integer> values) {
            addCriterion("Seid in", values, "seid");
            return (Criteria) this;
        }

        public Criteria andSeidNotIn(List<Integer> values) {
            addCriterion("Seid not in", values, "seid");
            return (Criteria) this;
        }

        public Criteria andSeidBetween(Integer value1, Integer value2) {
            addCriterion("Seid between", value1, value2, "seid");
            return (Criteria) this;
        }

        public Criteria andSeidNotBetween(Integer value1, Integer value2) {
            addCriterion("Seid not between", value1, value2, "seid");
            return (Criteria) this;
        }

        public Criteria andSehallidIsNull() {
            addCriterion("SeHallID is null");
            return (Criteria) this;
        }

        public Criteria andSehallidIsNotNull() {
            addCriterion("SeHallID is not null");
            return (Criteria) this;
        }

        public Criteria andSehallidEqualTo(Integer value) {
            addCriterion("SeHallID =", value, "sehallid");
            return (Criteria) this;
        }

        public Criteria andSehallidNotEqualTo(Integer value) {
            addCriterion("SeHallID <>", value, "sehallid");
            return (Criteria) this;
        }

        public Criteria andSehallidGreaterThan(Integer value) {
            addCriterion("SeHallID >", value, "sehallid");
            return (Criteria) this;
        }

        public Criteria andSehallidGreaterThanOrEqualTo(Integer value) {
            addCriterion("SeHallID >=", value, "sehallid");
            return (Criteria) this;
        }

        public Criteria andSehallidLessThan(Integer value) {
            addCriterion("SeHallID <", value, "sehallid");
            return (Criteria) this;
        }

        public Criteria andSehallidLessThanOrEqualTo(Integer value) {
            addCriterion("SeHallID <=", value, "sehallid");
            return (Criteria) this;
        }

        public Criteria andSehallidIn(List<Integer> values) {
            addCriterion("SeHallID in", values, "sehallid");
            return (Criteria) this;
        }

        public Criteria andSehallidNotIn(List<Integer> values) {
            addCriterion("SeHallID not in", values, "sehallid");
            return (Criteria) this;
        }

        public Criteria andSehallidBetween(Integer value1, Integer value2) {
            addCriterion("SeHallID between", value1, value2, "sehallid");
            return (Criteria) this;
        }

        public Criteria andSehallidNotBetween(Integer value1, Integer value2) {
            addCriterion("SeHallID not between", value1, value2, "sehallid");
            return (Criteria) this;
        }

        public Criteria andSerowIsNull() {
            addCriterion("Serow is null");
            return (Criteria) this;
        }

        public Criteria andSerowIsNotNull() {
            addCriterion("Serow is not null");
            return (Criteria) this;
        }

        public Criteria andSerowEqualTo(String value) {
            addCriterion("Serow =", value, "serow");
            return (Criteria) this;
        }

        public Criteria andSerowNotEqualTo(String value) {
            addCriterion("Serow <>", value, "serow");
            return (Criteria) this;
        }

        public Criteria andSerowGreaterThan(String value) {
            addCriterion("Serow >", value, "serow");
            return (Criteria) this;
        }

        public Criteria andSerowGreaterThanOrEqualTo(String value) {
            addCriterion("Serow >=", value, "serow");
            return (Criteria) this;
        }

        public Criteria andSerowLessThan(String value) {
            addCriterion("Serow <", value, "serow");
            return (Criteria) this;
        }

        public Criteria andSerowLessThanOrEqualTo(String value) {
            addCriterion("Serow <=", value, "serow");
            return (Criteria) this;
        }

        public Criteria andSerowLike(String value) {
            addCriterion("Serow like", value, "serow");
            return (Criteria) this;
        }

        public Criteria andSerowNotLike(String value) {
            addCriterion("Serow not like", value, "serow");
            return (Criteria) this;
        }

        public Criteria andSerowIn(List<String> values) {
            addCriterion("Serow in", values, "serow");
            return (Criteria) this;
        }

        public Criteria andSerowNotIn(List<String> values) {
            addCriterion("Serow not in", values, "serow");
            return (Criteria) this;
        }

        public Criteria andSerowBetween(String value1, String value2) {
            addCriterion("Serow between", value1, value2, "serow");
            return (Criteria) this;
        }

        public Criteria andSerowNotBetween(String value1, String value2) {
            addCriterion("Serow not between", value1, value2, "serow");
            return (Criteria) this;
        }

        public Criteria andSenumIsNull() {
            addCriterion("Senum is null");
            return (Criteria) this;
        }

        public Criteria andSenumIsNotNull() {
            addCriterion("Senum is not null");
            return (Criteria) this;
        }

        public Criteria andSenumEqualTo(String value) {
            addCriterion("Senum =", value, "senum");
            return (Criteria) this;
        }

        public Criteria andSenumNotEqualTo(String value) {
            addCriterion("Senum <>", value, "senum");
            return (Criteria) this;
        }

        public Criteria andSenumGreaterThan(String value) {
            addCriterion("Senum >", value, "senum");
            return (Criteria) this;
        }

        public Criteria andSenumGreaterThanOrEqualTo(String value) {
            addCriterion("Senum >=", value, "senum");
            return (Criteria) this;
        }

        public Criteria andSenumLessThan(String value) {
            addCriterion("Senum <", value, "senum");
            return (Criteria) this;
        }

        public Criteria andSenumLessThanOrEqualTo(String value) {
            addCriterion("Senum <=", value, "senum");
            return (Criteria) this;
        }

        public Criteria andSenumLike(String value) {
            addCriterion("Senum like", value, "senum");
            return (Criteria) this;
        }

        public Criteria andSenumNotLike(String value) {
            addCriterion("Senum not like", value, "senum");
            return (Criteria) this;
        }

        public Criteria andSenumIn(List<String> values) {
            addCriterion("Senum in", values, "senum");
            return (Criteria) this;
        }

        public Criteria andSenumNotIn(List<String> values) {
            addCriterion("Senum not in", values, "senum");
            return (Criteria) this;
        }

        public Criteria andSenumBetween(String value1, String value2) {
            addCriterion("Senum between", value1, value2, "senum");
            return (Criteria) this;
        }

        public Criteria andSenumNotBetween(String value1, String value2) {
            addCriterion("Senum not between", value1, value2, "senum");
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