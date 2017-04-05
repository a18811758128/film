package com.ln.film.model;

import java.util.ArrayList;
import java.util.List;

public class HallExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HallExample() {
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

        public Criteria andHidIsNull() {
            addCriterion("Hid is null");
            return (Criteria) this;
        }

        public Criteria andHidIsNotNull() {
            addCriterion("Hid is not null");
            return (Criteria) this;
        }

        public Criteria andHidEqualTo(Integer value) {
            addCriterion("Hid =", value, "hid");
            return (Criteria) this;
        }

        public Criteria andHidNotEqualTo(Integer value) {
            addCriterion("Hid <>", value, "hid");
            return (Criteria) this;
        }

        public Criteria andHidGreaterThan(Integer value) {
            addCriterion("Hid >", value, "hid");
            return (Criteria) this;
        }

        public Criteria andHidGreaterThanOrEqualTo(Integer value) {
            addCriterion("Hid >=", value, "hid");
            return (Criteria) this;
        }

        public Criteria andHidLessThan(Integer value) {
            addCriterion("Hid <", value, "hid");
            return (Criteria) this;
        }

        public Criteria andHidLessThanOrEqualTo(Integer value) {
            addCriterion("Hid <=", value, "hid");
            return (Criteria) this;
        }

        public Criteria andHidIn(List<Integer> values) {
            addCriterion("Hid in", values, "hid");
            return (Criteria) this;
        }

        public Criteria andHidNotIn(List<Integer> values) {
            addCriterion("Hid not in", values, "hid");
            return (Criteria) this;
        }

        public Criteria andHidBetween(Integer value1, Integer value2) {
            addCriterion("Hid between", value1, value2, "hid");
            return (Criteria) this;
        }

        public Criteria andHidNotBetween(Integer value1, Integer value2) {
            addCriterion("Hid not between", value1, value2, "hid");
            return (Criteria) this;
        }

        public Criteria andHhallIsNull() {
            addCriterion("HHall is null");
            return (Criteria) this;
        }

        public Criteria andHhallIsNotNull() {
            addCriterion("HHall is not null");
            return (Criteria) this;
        }

        public Criteria andHhallEqualTo(String value) {
            addCriterion("HHall =", value, "hhall");
            return (Criteria) this;
        }

        public Criteria andHhallNotEqualTo(String value) {
            addCriterion("HHall <>", value, "hhall");
            return (Criteria) this;
        }

        public Criteria andHhallGreaterThan(String value) {
            addCriterion("HHall >", value, "hhall");
            return (Criteria) this;
        }

        public Criteria andHhallGreaterThanOrEqualTo(String value) {
            addCriterion("HHall >=", value, "hhall");
            return (Criteria) this;
        }

        public Criteria andHhallLessThan(String value) {
            addCriterion("HHall <", value, "hhall");
            return (Criteria) this;
        }

        public Criteria andHhallLessThanOrEqualTo(String value) {
            addCriterion("HHall <=", value, "hhall");
            return (Criteria) this;
        }

        public Criteria andHhallLike(String value) {
            addCriterion("HHall like", value, "hhall");
            return (Criteria) this;
        }

        public Criteria andHhallNotLike(String value) {
            addCriterion("HHall not like", value, "hhall");
            return (Criteria) this;
        }

        public Criteria andHhallIn(List<String> values) {
            addCriterion("HHall in", values, "hhall");
            return (Criteria) this;
        }

        public Criteria andHhallNotIn(List<String> values) {
            addCriterion("HHall not in", values, "hhall");
            return (Criteria) this;
        }

        public Criteria andHhallBetween(String value1, String value2) {
            addCriterion("HHall between", value1, value2, "hhall");
            return (Criteria) this;
        }

        public Criteria andHhallNotBetween(String value1, String value2) {
            addCriterion("HHall not between", value1, value2, "hhall");
            return (Criteria) this;
        }

        public Criteria andHnumIsNull() {
            addCriterion("HNum is null");
            return (Criteria) this;
        }

        public Criteria andHnumIsNotNull() {
            addCriterion("HNum is not null");
            return (Criteria) this;
        }

        public Criteria andHnumEqualTo(String value) {
            addCriterion("HNum =", value, "hnum");
            return (Criteria) this;
        }

        public Criteria andHnumNotEqualTo(String value) {
            addCriterion("HNum <>", value, "hnum");
            return (Criteria) this;
        }

        public Criteria andHnumGreaterThan(String value) {
            addCriterion("HNum >", value, "hnum");
            return (Criteria) this;
        }

        public Criteria andHnumGreaterThanOrEqualTo(String value) {
            addCriterion("HNum >=", value, "hnum");
            return (Criteria) this;
        }

        public Criteria andHnumLessThan(String value) {
            addCriterion("HNum <", value, "hnum");
            return (Criteria) this;
        }

        public Criteria andHnumLessThanOrEqualTo(String value) {
            addCriterion("HNum <=", value, "hnum");
            return (Criteria) this;
        }

        public Criteria andHnumLike(String value) {
            addCriterion("HNum like", value, "hnum");
            return (Criteria) this;
        }

        public Criteria andHnumNotLike(String value) {
            addCriterion("HNum not like", value, "hnum");
            return (Criteria) this;
        }

        public Criteria andHnumIn(List<String> values) {
            addCriterion("HNum in", values, "hnum");
            return (Criteria) this;
        }

        public Criteria andHnumNotIn(List<String> values) {
            addCriterion("HNum not in", values, "hnum");
            return (Criteria) this;
        }

        public Criteria andHnumBetween(String value1, String value2) {
            addCriterion("HNum between", value1, value2, "hnum");
            return (Criteria) this;
        }

        public Criteria andHnumNotBetween(String value1, String value2) {
            addCriterion("HNum not between", value1, value2, "hnum");
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