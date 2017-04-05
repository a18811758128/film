package com.ln.film.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrdersExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrdersExample() {
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

        public Criteria andOidIsNull() {
            addCriterion("Oid is null");
            return (Criteria) this;
        }

        public Criteria andOidIsNotNull() {
            addCriterion("Oid is not null");
            return (Criteria) this;
        }

        public Criteria andOidEqualTo(Integer value) {
            addCriterion("Oid =", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidNotEqualTo(Integer value) {
            addCriterion("Oid <>", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidGreaterThan(Integer value) {
            addCriterion("Oid >", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidGreaterThanOrEqualTo(Integer value) {
            addCriterion("Oid >=", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidLessThan(Integer value) {
            addCriterion("Oid <", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidLessThanOrEqualTo(Integer value) {
            addCriterion("Oid <=", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidIn(List<Integer> values) {
            addCriterion("Oid in", values, "oid");
            return (Criteria) this;
        }

        public Criteria andOidNotIn(List<Integer> values) {
            addCriterion("Oid not in", values, "oid");
            return (Criteria) this;
        }

        public Criteria andOidBetween(Integer value1, Integer value2) {
            addCriterion("Oid between", value1, value2, "oid");
            return (Criteria) this;
        }

        public Criteria andOidNotBetween(Integer value1, Integer value2) {
            addCriterion("Oid not between", value1, value2, "oid");
            return (Criteria) this;
        }

        public Criteria andOuidIsNull() {
            addCriterion("OUid is null");
            return (Criteria) this;
        }

        public Criteria andOuidIsNotNull() {
            addCriterion("OUid is not null");
            return (Criteria) this;
        }

        public Criteria andOuidEqualTo(Integer value) {
            addCriterion("OUid =", value, "ouid");
            return (Criteria) this;
        }

        public Criteria andOuidNotEqualTo(Integer value) {
            addCriterion("OUid <>", value, "ouid");
            return (Criteria) this;
        }

        public Criteria andOuidGreaterThan(Integer value) {
            addCriterion("OUid >", value, "ouid");
            return (Criteria) this;
        }

        public Criteria andOuidGreaterThanOrEqualTo(Integer value) {
            addCriterion("OUid >=", value, "ouid");
            return (Criteria) this;
        }

        public Criteria andOuidLessThan(Integer value) {
            addCriterion("OUid <", value, "ouid");
            return (Criteria) this;
        }

        public Criteria andOuidLessThanOrEqualTo(Integer value) {
            addCriterion("OUid <=", value, "ouid");
            return (Criteria) this;
        }

        public Criteria andOuidIn(List<Integer> values) {
            addCriterion("OUid in", values, "ouid");
            return (Criteria) this;
        }

        public Criteria andOuidNotIn(List<Integer> values) {
            addCriterion("OUid not in", values, "ouid");
            return (Criteria) this;
        }

        public Criteria andOuidBetween(Integer value1, Integer value2) {
            addCriterion("OUid between", value1, value2, "ouid");
            return (Criteria) this;
        }

        public Criteria andOuidNotBetween(Integer value1, Integer value2) {
            addCriterion("OUid not between", value1, value2, "ouid");
            return (Criteria) this;
        }

        public Criteria andOdateIsNull() {
            addCriterion("Odate is null");
            return (Criteria) this;
        }

        public Criteria andOdateIsNotNull() {
            addCriterion("Odate is not null");
            return (Criteria) this;
        }

        public Criteria andOdateEqualTo(Date value) {
            addCriterion("Odate =", value, "odate");
            return (Criteria) this;
        }

        public Criteria andOdateNotEqualTo(Date value) {
            addCriterion("Odate <>", value, "odate");
            return (Criteria) this;
        }

        public Criteria andOdateGreaterThan(Date value) {
            addCriterion("Odate >", value, "odate");
            return (Criteria) this;
        }

        public Criteria andOdateGreaterThanOrEqualTo(Date value) {
            addCriterion("Odate >=", value, "odate");
            return (Criteria) this;
        }

        public Criteria andOdateLessThan(Date value) {
            addCriterion("Odate <", value, "odate");
            return (Criteria) this;
        }

        public Criteria andOdateLessThanOrEqualTo(Date value) {
            addCriterion("Odate <=", value, "odate");
            return (Criteria) this;
        }

        public Criteria andOdateIn(List<Date> values) {
            addCriterion("Odate in", values, "odate");
            return (Criteria) this;
        }

        public Criteria andOdateNotIn(List<Date> values) {
            addCriterion("Odate not in", values, "odate");
            return (Criteria) this;
        }

        public Criteria andOdateBetween(Date value1, Date value2) {
            addCriterion("Odate between", value1, value2, "odate");
            return (Criteria) this;
        }

        public Criteria andOdateNotBetween(Date value1, Date value2) {
            addCriterion("Odate not between", value1, value2, "odate");
            return (Criteria) this;
        }

        public Criteria andOstateIsNull() {
            addCriterion("OState is null");
            return (Criteria) this;
        }

        public Criteria andOstateIsNotNull() {
            addCriterion("OState is not null");
            return (Criteria) this;
        }

        public Criteria andOstateEqualTo(String value) {
            addCriterion("OState =", value, "ostate");
            return (Criteria) this;
        }

        public Criteria andOstateNotEqualTo(String value) {
            addCriterion("OState <>", value, "ostate");
            return (Criteria) this;
        }

        public Criteria andOstateGreaterThan(String value) {
            addCriterion("OState >", value, "ostate");
            return (Criteria) this;
        }

        public Criteria andOstateGreaterThanOrEqualTo(String value) {
            addCriterion("OState >=", value, "ostate");
            return (Criteria) this;
        }

        public Criteria andOstateLessThan(String value) {
            addCriterion("OState <", value, "ostate");
            return (Criteria) this;
        }

        public Criteria andOstateLessThanOrEqualTo(String value) {
            addCriterion("OState <=", value, "ostate");
            return (Criteria) this;
        }

        public Criteria andOstateLike(String value) {
            addCriterion("OState like", value, "ostate");
            return (Criteria) this;
        }

        public Criteria andOstateNotLike(String value) {
            addCriterion("OState not like", value, "ostate");
            return (Criteria) this;
        }

        public Criteria andOstateIn(List<String> values) {
            addCriterion("OState in", values, "ostate");
            return (Criteria) this;
        }

        public Criteria andOstateNotIn(List<String> values) {
            addCriterion("OState not in", values, "ostate");
            return (Criteria) this;
        }

        public Criteria andOstateBetween(String value1, String value2) {
            addCriterion("OState between", value1, value2, "ostate");
            return (Criteria) this;
        }

        public Criteria andOstateNotBetween(String value1, String value2) {
            addCriterion("OState not between", value1, value2, "ostate");
            return (Criteria) this;
        }

        public Criteria andOtidIsNull() {
            addCriterion("OTid is null");
            return (Criteria) this;
        }

        public Criteria andOtidIsNotNull() {
            addCriterion("OTid is not null");
            return (Criteria) this;
        }

        public Criteria andOtidEqualTo(Integer value) {
            addCriterion("OTid =", value, "otid");
            return (Criteria) this;
        }

        public Criteria andOtidNotEqualTo(Integer value) {
            addCriterion("OTid <>", value, "otid");
            return (Criteria) this;
        }

        public Criteria andOtidGreaterThan(Integer value) {
            addCriterion("OTid >", value, "otid");
            return (Criteria) this;
        }

        public Criteria andOtidGreaterThanOrEqualTo(Integer value) {
            addCriterion("OTid >=", value, "otid");
            return (Criteria) this;
        }

        public Criteria andOtidLessThan(Integer value) {
            addCriterion("OTid <", value, "otid");
            return (Criteria) this;
        }

        public Criteria andOtidLessThanOrEqualTo(Integer value) {
            addCriterion("OTid <=", value, "otid");
            return (Criteria) this;
        }

        public Criteria andOtidIn(List<Integer> values) {
            addCriterion("OTid in", values, "otid");
            return (Criteria) this;
        }

        public Criteria andOtidNotIn(List<Integer> values) {
            addCriterion("OTid not in", values, "otid");
            return (Criteria) this;
        }

        public Criteria andOtidBetween(Integer value1, Integer value2) {
            addCriterion("OTid between", value1, value2, "otid");
            return (Criteria) this;
        }

        public Criteria andOtidNotBetween(Integer value1, Integer value2) {
            addCriterion("OTid not between", value1, value2, "otid");
            return (Criteria) this;
        }

        public Criteria andOpriceIsNull() {
            addCriterion("OPrice is null");
            return (Criteria) this;
        }

        public Criteria andOpriceIsNotNull() {
            addCriterion("OPrice is not null");
            return (Criteria) this;
        }

        public Criteria andOpriceEqualTo(Double value) {
            addCriterion("OPrice =", value, "oprice");
            return (Criteria) this;
        }

        public Criteria andOpriceNotEqualTo(Double value) {
            addCriterion("OPrice <>", value, "oprice");
            return (Criteria) this;
        }

        public Criteria andOpriceGreaterThan(Double value) {
            addCriterion("OPrice >", value, "oprice");
            return (Criteria) this;
        }

        public Criteria andOpriceGreaterThanOrEqualTo(Double value) {
            addCriterion("OPrice >=", value, "oprice");
            return (Criteria) this;
        }

        public Criteria andOpriceLessThan(Double value) {
            addCriterion("OPrice <", value, "oprice");
            return (Criteria) this;
        }

        public Criteria andOpriceLessThanOrEqualTo(Double value) {
            addCriterion("OPrice <=", value, "oprice");
            return (Criteria) this;
        }

        public Criteria andOpriceIn(List<Double> values) {
            addCriterion("OPrice in", values, "oprice");
            return (Criteria) this;
        }

        public Criteria andOpriceNotIn(List<Double> values) {
            addCriterion("OPrice not in", values, "oprice");
            return (Criteria) this;
        }

        public Criteria andOpriceBetween(Double value1, Double value2) {
            addCriterion("OPrice between", value1, value2, "oprice");
            return (Criteria) this;
        }

        public Criteria andOpriceNotBetween(Double value1, Double value2) {
            addCriterion("OPrice not between", value1, value2, "oprice");
            return (Criteria) this;
        }

        public Criteria andSeatCountIsNull() {
            addCriterion("seat_count is null");
            return (Criteria) this;
        }

        public Criteria andSeatCountIsNotNull() {
            addCriterion("seat_count is not null");
            return (Criteria) this;
        }

        public Criteria andSeatCountEqualTo(Integer value) {
            addCriterion("seat_count =", value, "seatCount");
            return (Criteria) this;
        }

        public Criteria andSeatCountNotEqualTo(Integer value) {
            addCriterion("seat_count <>", value, "seatCount");
            return (Criteria) this;
        }

        public Criteria andSeatCountGreaterThan(Integer value) {
            addCriterion("seat_count >", value, "seatCount");
            return (Criteria) this;
        }

        public Criteria andSeatCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("seat_count >=", value, "seatCount");
            return (Criteria) this;
        }

        public Criteria andSeatCountLessThan(Integer value) {
            addCriterion("seat_count <", value, "seatCount");
            return (Criteria) this;
        }

        public Criteria andSeatCountLessThanOrEqualTo(Integer value) {
            addCriterion("seat_count <=", value, "seatCount");
            return (Criteria) this;
        }

        public Criteria andSeatCountIn(List<Integer> values) {
            addCriterion("seat_count in", values, "seatCount");
            return (Criteria) this;
        }

        public Criteria andSeatCountNotIn(List<Integer> values) {
            addCriterion("seat_count not in", values, "seatCount");
            return (Criteria) this;
        }

        public Criteria andSeatCountBetween(Integer value1, Integer value2) {
            addCriterion("seat_count between", value1, value2, "seatCount");
            return (Criteria) this;
        }

        public Criteria andSeatCountNotBetween(Integer value1, Integer value2) {
            addCriterion("seat_count not between", value1, value2, "seatCount");
            return (Criteria) this;
        }

        public Criteria andTicketCodeIsNull() {
            addCriterion("ticket_code is null");
            return (Criteria) this;
        }

        public Criteria andTicketCodeIsNotNull() {
            addCriterion("ticket_code is not null");
            return (Criteria) this;
        }

        public Criteria andTicketCodeEqualTo(String value) {
            addCriterion("ticket_code =", value, "ticketCode");
            return (Criteria) this;
        }

        public Criteria andTicketCodeNotEqualTo(String value) {
            addCriterion("ticket_code <>", value, "ticketCode");
            return (Criteria) this;
        }

        public Criteria andTicketCodeGreaterThan(String value) {
            addCriterion("ticket_code >", value, "ticketCode");
            return (Criteria) this;
        }

        public Criteria andTicketCodeGreaterThanOrEqualTo(String value) {
            addCriterion("ticket_code >=", value, "ticketCode");
            return (Criteria) this;
        }

        public Criteria andTicketCodeLessThan(String value) {
            addCriterion("ticket_code <", value, "ticketCode");
            return (Criteria) this;
        }

        public Criteria andTicketCodeLessThanOrEqualTo(String value) {
            addCriterion("ticket_code <=", value, "ticketCode");
            return (Criteria) this;
        }

        public Criteria andTicketCodeLike(String value) {
            addCriterion("ticket_code like", value, "ticketCode");
            return (Criteria) this;
        }

        public Criteria andTicketCodeNotLike(String value) {
            addCriterion("ticket_code not like", value, "ticketCode");
            return (Criteria) this;
        }

        public Criteria andTicketCodeIn(List<String> values) {
            addCriterion("ticket_code in", values, "ticketCode");
            return (Criteria) this;
        }

        public Criteria andTicketCodeNotIn(List<String> values) {
            addCriterion("ticket_code not in", values, "ticketCode");
            return (Criteria) this;
        }

        public Criteria andTicketCodeBetween(String value1, String value2) {
            addCriterion("ticket_code between", value1, value2, "ticketCode");
            return (Criteria) this;
        }

        public Criteria andTicketCodeNotBetween(String value1, String value2) {
            addCriterion("ticket_code not between", value1, value2, "ticketCode");
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