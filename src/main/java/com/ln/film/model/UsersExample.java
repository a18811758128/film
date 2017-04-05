package com.ln.film.model;

import java.util.ArrayList;
import java.util.List;

public class UsersExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UsersExample() {
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

        public Criteria andUseridIsNull() {
            addCriterion("userid is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userid is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(Integer value) {
            addCriterion("userid =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(Integer value) {
            addCriterion("userid <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(Integer value) {
            addCriterion("userid >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("userid >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(Integer value) {
            addCriterion("userid <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(Integer value) {
            addCriterion("userid <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<Integer> values) {
            addCriterion("userid in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<Integer> values) {
            addCriterion("userid not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(Integer value1, Integer value2) {
            addCriterion("userid between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("userid not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNull() {
            addCriterion("username is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("username is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("username =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("username <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("username >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("username >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("username <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("username <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("username like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("username not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("username in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("username not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("username between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("username not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andUrealnameIsNull() {
            addCriterion("URealName is null");
            return (Criteria) this;
        }

        public Criteria andUrealnameIsNotNull() {
            addCriterion("URealName is not null");
            return (Criteria) this;
        }

        public Criteria andUrealnameEqualTo(String value) {
            addCriterion("URealName =", value, "urealname");
            return (Criteria) this;
        }

        public Criteria andUrealnameNotEqualTo(String value) {
            addCriterion("URealName <>", value, "urealname");
            return (Criteria) this;
        }

        public Criteria andUrealnameGreaterThan(String value) {
            addCriterion("URealName >", value, "urealname");
            return (Criteria) this;
        }

        public Criteria andUrealnameGreaterThanOrEqualTo(String value) {
            addCriterion("URealName >=", value, "urealname");
            return (Criteria) this;
        }

        public Criteria andUrealnameLessThan(String value) {
            addCriterion("URealName <", value, "urealname");
            return (Criteria) this;
        }

        public Criteria andUrealnameLessThanOrEqualTo(String value) {
            addCriterion("URealName <=", value, "urealname");
            return (Criteria) this;
        }

        public Criteria andUrealnameLike(String value) {
            addCriterion("URealName like", value, "urealname");
            return (Criteria) this;
        }

        public Criteria andUrealnameNotLike(String value) {
            addCriterion("URealName not like", value, "urealname");
            return (Criteria) this;
        }

        public Criteria andUrealnameIn(List<String> values) {
            addCriterion("URealName in", values, "urealname");
            return (Criteria) this;
        }

        public Criteria andUrealnameNotIn(List<String> values) {
            addCriterion("URealName not in", values, "urealname");
            return (Criteria) this;
        }

        public Criteria andUrealnameBetween(String value1, String value2) {
            addCriterion("URealName between", value1, value2, "urealname");
            return (Criteria) this;
        }

        public Criteria andUrealnameNotBetween(String value1, String value2) {
            addCriterion("URealName not between", value1, value2, "urealname");
            return (Criteria) this;
        }

        public Criteria andUsexIsNull() {
            addCriterion("USex is null");
            return (Criteria) this;
        }

        public Criteria andUsexIsNotNull() {
            addCriterion("USex is not null");
            return (Criteria) this;
        }

        public Criteria andUsexEqualTo(String value) {
            addCriterion("USex =", value, "usex");
            return (Criteria) this;
        }

        public Criteria andUsexNotEqualTo(String value) {
            addCriterion("USex <>", value, "usex");
            return (Criteria) this;
        }

        public Criteria andUsexGreaterThan(String value) {
            addCriterion("USex >", value, "usex");
            return (Criteria) this;
        }

        public Criteria andUsexGreaterThanOrEqualTo(String value) {
            addCriterion("USex >=", value, "usex");
            return (Criteria) this;
        }

        public Criteria andUsexLessThan(String value) {
            addCriterion("USex <", value, "usex");
            return (Criteria) this;
        }

        public Criteria andUsexLessThanOrEqualTo(String value) {
            addCriterion("USex <=", value, "usex");
            return (Criteria) this;
        }

        public Criteria andUsexLike(String value) {
            addCriterion("USex like", value, "usex");
            return (Criteria) this;
        }

        public Criteria andUsexNotLike(String value) {
            addCriterion("USex not like", value, "usex");
            return (Criteria) this;
        }

        public Criteria andUsexIn(List<String> values) {
            addCriterion("USex in", values, "usex");
            return (Criteria) this;
        }

        public Criteria andUsexNotIn(List<String> values) {
            addCriterion("USex not in", values, "usex");
            return (Criteria) this;
        }

        public Criteria andUsexBetween(String value1, String value2) {
            addCriterion("USex between", value1, value2, "usex");
            return (Criteria) this;
        }

        public Criteria andUsexNotBetween(String value1, String value2) {
            addCriterion("USex not between", value1, value2, "usex");
            return (Criteria) this;
        }

        public Criteria andUphoneIsNull() {
            addCriterion("UPhone is null");
            return (Criteria) this;
        }

        public Criteria andUphoneIsNotNull() {
            addCriterion("UPhone is not null");
            return (Criteria) this;
        }

        public Criteria andUphoneEqualTo(String value) {
            addCriterion("UPhone =", value, "uphone");
            return (Criteria) this;
        }

        public Criteria andUphoneNotEqualTo(String value) {
            addCriterion("UPhone <>", value, "uphone");
            return (Criteria) this;
        }

        public Criteria andUphoneGreaterThan(String value) {
            addCriterion("UPhone >", value, "uphone");
            return (Criteria) this;
        }

        public Criteria andUphoneGreaterThanOrEqualTo(String value) {
            addCriterion("UPhone >=", value, "uphone");
            return (Criteria) this;
        }

        public Criteria andUphoneLessThan(String value) {
            addCriterion("UPhone <", value, "uphone");
            return (Criteria) this;
        }

        public Criteria andUphoneLessThanOrEqualTo(String value) {
            addCriterion("UPhone <=", value, "uphone");
            return (Criteria) this;
        }

        public Criteria andUphoneLike(String value) {
            addCriterion("UPhone like", value, "uphone");
            return (Criteria) this;
        }

        public Criteria andUphoneNotLike(String value) {
            addCriterion("UPhone not like", value, "uphone");
            return (Criteria) this;
        }

        public Criteria andUphoneIn(List<String> values) {
            addCriterion("UPhone in", values, "uphone");
            return (Criteria) this;
        }

        public Criteria andUphoneNotIn(List<String> values) {
            addCriterion("UPhone not in", values, "uphone");
            return (Criteria) this;
        }

        public Criteria andUphoneBetween(String value1, String value2) {
            addCriterion("UPhone between", value1, value2, "uphone");
            return (Criteria) this;
        }

        public Criteria andUphoneNotBetween(String value1, String value2) {
            addCriterion("UPhone not between", value1, value2, "uphone");
            return (Criteria) this;
        }

        public Criteria andUemailIsNull() {
            addCriterion("UEmail is null");
            return (Criteria) this;
        }

        public Criteria andUemailIsNotNull() {
            addCriterion("UEmail is not null");
            return (Criteria) this;
        }

        public Criteria andUemailEqualTo(String value) {
            addCriterion("UEmail =", value, "uemail");
            return (Criteria) this;
        }

        public Criteria andUemailNotEqualTo(String value) {
            addCriterion("UEmail <>", value, "uemail");
            return (Criteria) this;
        }

        public Criteria andUemailGreaterThan(String value) {
            addCriterion("UEmail >", value, "uemail");
            return (Criteria) this;
        }

        public Criteria andUemailGreaterThanOrEqualTo(String value) {
            addCriterion("UEmail >=", value, "uemail");
            return (Criteria) this;
        }

        public Criteria andUemailLessThan(String value) {
            addCriterion("UEmail <", value, "uemail");
            return (Criteria) this;
        }

        public Criteria andUemailLessThanOrEqualTo(String value) {
            addCriterion("UEmail <=", value, "uemail");
            return (Criteria) this;
        }

        public Criteria andUemailLike(String value) {
            addCriterion("UEmail like", value, "uemail");
            return (Criteria) this;
        }

        public Criteria andUemailNotLike(String value) {
            addCriterion("UEmail not like", value, "uemail");
            return (Criteria) this;
        }

        public Criteria andUemailIn(List<String> values) {
            addCriterion("UEmail in", values, "uemail");
            return (Criteria) this;
        }

        public Criteria andUemailNotIn(List<String> values) {
            addCriterion("UEmail not in", values, "uemail");
            return (Criteria) this;
        }

        public Criteria andUemailBetween(String value1, String value2) {
            addCriterion("UEmail between", value1, value2, "uemail");
            return (Criteria) this;
        }

        public Criteria andUemailNotBetween(String value1, String value2) {
            addCriterion("UEmail not between", value1, value2, "uemail");
            return (Criteria) this;
        }

        public Criteria andUqqIsNull() {
            addCriterion("Uqq is null");
            return (Criteria) this;
        }

        public Criteria andUqqIsNotNull() {
            addCriterion("Uqq is not null");
            return (Criteria) this;
        }

        public Criteria andUqqEqualTo(String value) {
            addCriterion("Uqq =", value, "uqq");
            return (Criteria) this;
        }

        public Criteria andUqqNotEqualTo(String value) {
            addCriterion("Uqq <>", value, "uqq");
            return (Criteria) this;
        }

        public Criteria andUqqGreaterThan(String value) {
            addCriterion("Uqq >", value, "uqq");
            return (Criteria) this;
        }

        public Criteria andUqqGreaterThanOrEqualTo(String value) {
            addCriterion("Uqq >=", value, "uqq");
            return (Criteria) this;
        }

        public Criteria andUqqLessThan(String value) {
            addCriterion("Uqq <", value, "uqq");
            return (Criteria) this;
        }

        public Criteria andUqqLessThanOrEqualTo(String value) {
            addCriterion("Uqq <=", value, "uqq");
            return (Criteria) this;
        }

        public Criteria andUqqLike(String value) {
            addCriterion("Uqq like", value, "uqq");
            return (Criteria) this;
        }

        public Criteria andUqqNotLike(String value) {
            addCriterion("Uqq not like", value, "uqq");
            return (Criteria) this;
        }

        public Criteria andUqqIn(List<String> values) {
            addCriterion("Uqq in", values, "uqq");
            return (Criteria) this;
        }

        public Criteria andUqqNotIn(List<String> values) {
            addCriterion("Uqq not in", values, "uqq");
            return (Criteria) this;
        }

        public Criteria andUqqBetween(String value1, String value2) {
            addCriterion("Uqq between", value1, value2, "uqq");
            return (Criteria) this;
        }

        public Criteria andUqqNotBetween(String value1, String value2) {
            addCriterion("Uqq not between", value1, value2, "uqq");
            return (Criteria) this;
        }

        public Criteria andUbirthIsNull() {
            addCriterion("UBirth is null");
            return (Criteria) this;
        }

        public Criteria andUbirthIsNotNull() {
            addCriterion("UBirth is not null");
            return (Criteria) this;
        }

        public Criteria andUbirthEqualTo(String value) {
            addCriterion("UBirth =", value, "ubirth");
            return (Criteria) this;
        }

        public Criteria andUbirthNotEqualTo(String value) {
            addCriterion("UBirth <>", value, "ubirth");
            return (Criteria) this;
        }

        public Criteria andUbirthGreaterThan(String value) {
            addCriterion("UBirth >", value, "ubirth");
            return (Criteria) this;
        }

        public Criteria andUbirthGreaterThanOrEqualTo(String value) {
            addCriterion("UBirth >=", value, "ubirth");
            return (Criteria) this;
        }

        public Criteria andUbirthLessThan(String value) {
            addCriterion("UBirth <", value, "ubirth");
            return (Criteria) this;
        }

        public Criteria andUbirthLessThanOrEqualTo(String value) {
            addCriterion("UBirth <=", value, "ubirth");
            return (Criteria) this;
        }

        public Criteria andUbirthLike(String value) {
            addCriterion("UBirth like", value, "ubirth");
            return (Criteria) this;
        }

        public Criteria andUbirthNotLike(String value) {
            addCriterion("UBirth not like", value, "ubirth");
            return (Criteria) this;
        }

        public Criteria andUbirthIn(List<String> values) {
            addCriterion("UBirth in", values, "ubirth");
            return (Criteria) this;
        }

        public Criteria andUbirthNotIn(List<String> values) {
            addCriterion("UBirth not in", values, "ubirth");
            return (Criteria) this;
        }

        public Criteria andUbirthBetween(String value1, String value2) {
            addCriterion("UBirth between", value1, value2, "ubirth");
            return (Criteria) this;
        }

        public Criteria andUbirthNotBetween(String value1, String value2) {
            addCriterion("UBirth not between", value1, value2, "ubirth");
            return (Criteria) this;
        }

        public Criteria andRoleidIsNull() {
            addCriterion("roleid is null");
            return (Criteria) this;
        }

        public Criteria andRoleidIsNotNull() {
            addCriterion("roleid is not null");
            return (Criteria) this;
        }

        public Criteria andRoleidEqualTo(Integer value) {
            addCriterion("roleid =", value, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidNotEqualTo(Integer value) {
            addCriterion("roleid <>", value, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidGreaterThan(Integer value) {
            addCriterion("roleid >", value, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidGreaterThanOrEqualTo(Integer value) {
            addCriterion("roleid >=", value, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidLessThan(Integer value) {
            addCriterion("roleid <", value, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidLessThanOrEqualTo(Integer value) {
            addCriterion("roleid <=", value, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidIn(List<Integer> values) {
            addCriterion("roleid in", values, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidNotIn(List<Integer> values) {
            addCriterion("roleid not in", values, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidBetween(Integer value1, Integer value2) {
            addCriterion("roleid between", value1, value2, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidNotBetween(Integer value1, Integer value2) {
            addCriterion("roleid not between", value1, value2, "roleid");
            return (Criteria) this;
        }

        public Criteria andUidcardIsNull() {
            addCriterion("UIDCard is null");
            return (Criteria) this;
        }

        public Criteria andUidcardIsNotNull() {
            addCriterion("UIDCard is not null");
            return (Criteria) this;
        }

        public Criteria andUidcardEqualTo(String value) {
            addCriterion("UIDCard =", value, "uidcard");
            return (Criteria) this;
        }

        public Criteria andUidcardNotEqualTo(String value) {
            addCriterion("UIDCard <>", value, "uidcard");
            return (Criteria) this;
        }

        public Criteria andUidcardGreaterThan(String value) {
            addCriterion("UIDCard >", value, "uidcard");
            return (Criteria) this;
        }

        public Criteria andUidcardGreaterThanOrEqualTo(String value) {
            addCriterion("UIDCard >=", value, "uidcard");
            return (Criteria) this;
        }

        public Criteria andUidcardLessThan(String value) {
            addCriterion("UIDCard <", value, "uidcard");
            return (Criteria) this;
        }

        public Criteria andUidcardLessThanOrEqualTo(String value) {
            addCriterion("UIDCard <=", value, "uidcard");
            return (Criteria) this;
        }

        public Criteria andUidcardLike(String value) {
            addCriterion("UIDCard like", value, "uidcard");
            return (Criteria) this;
        }

        public Criteria andUidcardNotLike(String value) {
            addCriterion("UIDCard not like", value, "uidcard");
            return (Criteria) this;
        }

        public Criteria andUidcardIn(List<String> values) {
            addCriterion("UIDCard in", values, "uidcard");
            return (Criteria) this;
        }

        public Criteria andUidcardNotIn(List<String> values) {
            addCriterion("UIDCard not in", values, "uidcard");
            return (Criteria) this;
        }

        public Criteria andUidcardBetween(String value1, String value2) {
            addCriterion("UIDCard between", value1, value2, "uidcard");
            return (Criteria) this;
        }

        public Criteria andUidcardNotBetween(String value1, String value2) {
            addCriterion("UIDCard not between", value1, value2, "uidcard");
            return (Criteria) this;
        }

        public Criteria andUphotoIsNull() {
            addCriterion("UPhoto is null");
            return (Criteria) this;
        }

        public Criteria andUphotoIsNotNull() {
            addCriterion("UPhoto is not null");
            return (Criteria) this;
        }

        public Criteria andUphotoEqualTo(String value) {
            addCriterion("UPhoto =", value, "uphoto");
            return (Criteria) this;
        }

        public Criteria andUphotoNotEqualTo(String value) {
            addCriterion("UPhoto <>", value, "uphoto");
            return (Criteria) this;
        }

        public Criteria andUphotoGreaterThan(String value) {
            addCriterion("UPhoto >", value, "uphoto");
            return (Criteria) this;
        }

        public Criteria andUphotoGreaterThanOrEqualTo(String value) {
            addCriterion("UPhoto >=", value, "uphoto");
            return (Criteria) this;
        }

        public Criteria andUphotoLessThan(String value) {
            addCriterion("UPhoto <", value, "uphoto");
            return (Criteria) this;
        }

        public Criteria andUphotoLessThanOrEqualTo(String value) {
            addCriterion("UPhoto <=", value, "uphoto");
            return (Criteria) this;
        }

        public Criteria andUphotoLike(String value) {
            addCriterion("UPhoto like", value, "uphoto");
            return (Criteria) this;
        }

        public Criteria andUphotoNotLike(String value) {
            addCriterion("UPhoto not like", value, "uphoto");
            return (Criteria) this;
        }

        public Criteria andUphotoIn(List<String> values) {
            addCriterion("UPhoto in", values, "uphoto");
            return (Criteria) this;
        }

        public Criteria andUphotoNotIn(List<String> values) {
            addCriterion("UPhoto not in", values, "uphoto");
            return (Criteria) this;
        }

        public Criteria andUphotoBetween(String value1, String value2) {
            addCriterion("UPhoto between", value1, value2, "uphoto");
            return (Criteria) this;
        }

        public Criteria andUphotoNotBetween(String value1, String value2) {
            addCriterion("UPhoto not between", value1, value2, "uphoto");
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