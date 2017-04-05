package com.ln.film.model;

import java.util.ArrayList;
import java.util.List;

public class FilmExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FilmExample() {
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

        public Criteria andFidIsNull() {
            addCriterion("FID is null");
            return (Criteria) this;
        }

        public Criteria andFidIsNotNull() {
            addCriterion("FID is not null");
            return (Criteria) this;
        }

        public Criteria andFidEqualTo(Integer value) {
            addCriterion("FID =", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidNotEqualTo(Integer value) {
            addCriterion("FID <>", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidGreaterThan(Integer value) {
            addCriterion("FID >", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidGreaterThanOrEqualTo(Integer value) {
            addCriterion("FID >=", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidLessThan(Integer value) {
            addCriterion("FID <", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidLessThanOrEqualTo(Integer value) {
            addCriterion("FID <=", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidIn(List<Integer> values) {
            addCriterion("FID in", values, "fid");
            return (Criteria) this;
        }

        public Criteria andFidNotIn(List<Integer> values) {
            addCriterion("FID not in", values, "fid");
            return (Criteria) this;
        }

        public Criteria andFidBetween(Integer value1, Integer value2) {
            addCriterion("FID between", value1, value2, "fid");
            return (Criteria) this;
        }

        public Criteria andFidNotBetween(Integer value1, Integer value2) {
            addCriterion("FID not between", value1, value2, "fid");
            return (Criteria) this;
        }

        public Criteria andFsortidIsNull() {
            addCriterion("FSortID is null");
            return (Criteria) this;
        }

        public Criteria andFsortidIsNotNull() {
            addCriterion("FSortID is not null");
            return (Criteria) this;
        }

        public Criteria andFsortidEqualTo(Integer value) {
            addCriterion("FSortID =", value, "fsortid");
            return (Criteria) this;
        }

        public Criteria andFsortidNotEqualTo(Integer value) {
            addCriterion("FSortID <>", value, "fsortid");
            return (Criteria) this;
        }

        public Criteria andFsortidGreaterThan(Integer value) {
            addCriterion("FSortID >", value, "fsortid");
            return (Criteria) this;
        }

        public Criteria andFsortidGreaterThanOrEqualTo(Integer value) {
            addCriterion("FSortID >=", value, "fsortid");
            return (Criteria) this;
        }

        public Criteria andFsortidLessThan(Integer value) {
            addCriterion("FSortID <", value, "fsortid");
            return (Criteria) this;
        }

        public Criteria andFsortidLessThanOrEqualTo(Integer value) {
            addCriterion("FSortID <=", value, "fsortid");
            return (Criteria) this;
        }

        public Criteria andFsortidIn(List<Integer> values) {
            addCriterion("FSortID in", values, "fsortid");
            return (Criteria) this;
        }

        public Criteria andFsortidNotIn(List<Integer> values) {
            addCriterion("FSortID not in", values, "fsortid");
            return (Criteria) this;
        }

        public Criteria andFsortidBetween(Integer value1, Integer value2) {
            addCriterion("FSortID between", value1, value2, "fsortid");
            return (Criteria) this;
        }

        public Criteria andFsortidNotBetween(Integer value1, Integer value2) {
            addCriterion("FSortID not between", value1, value2, "fsortid");
            return (Criteria) this;
        }

        public Criteria andFaidIsNull() {
            addCriterion("FAid is null");
            return (Criteria) this;
        }

        public Criteria andFaidIsNotNull() {
            addCriterion("FAid is not null");
            return (Criteria) this;
        }

        public Criteria andFaidEqualTo(Integer value) {
            addCriterion("FAid =", value, "faid");
            return (Criteria) this;
        }

        public Criteria andFaidNotEqualTo(Integer value) {
            addCriterion("FAid <>", value, "faid");
            return (Criteria) this;
        }

        public Criteria andFaidGreaterThan(Integer value) {
            addCriterion("FAid >", value, "faid");
            return (Criteria) this;
        }

        public Criteria andFaidGreaterThanOrEqualTo(Integer value) {
            addCriterion("FAid >=", value, "faid");
            return (Criteria) this;
        }

        public Criteria andFaidLessThan(Integer value) {
            addCriterion("FAid <", value, "faid");
            return (Criteria) this;
        }

        public Criteria andFaidLessThanOrEqualTo(Integer value) {
            addCriterion("FAid <=", value, "faid");
            return (Criteria) this;
        }

        public Criteria andFaidIn(List<Integer> values) {
            addCriterion("FAid in", values, "faid");
            return (Criteria) this;
        }

        public Criteria andFaidNotIn(List<Integer> values) {
            addCriterion("FAid not in", values, "faid");
            return (Criteria) this;
        }

        public Criteria andFaidBetween(Integer value1, Integer value2) {
            addCriterion("FAid between", value1, value2, "faid");
            return (Criteria) this;
        }

        public Criteria andFaidNotBetween(Integer value1, Integer value2) {
            addCriterion("FAid not between", value1, value2, "faid");
            return (Criteria) this;
        }

        public Criteria andFfilmnameIsNull() {
            addCriterion("FFilmName is null");
            return (Criteria) this;
        }

        public Criteria andFfilmnameIsNotNull() {
            addCriterion("FFilmName is not null");
            return (Criteria) this;
        }

        public Criteria andFfilmnameEqualTo(String value) {
            addCriterion("FFilmName =", value, "ffilmname");
            return (Criteria) this;
        }

        public Criteria andFfilmnameNotEqualTo(String value) {
            addCriterion("FFilmName <>", value, "ffilmname");
            return (Criteria) this;
        }

        public Criteria andFfilmnameGreaterThan(String value) {
            addCriterion("FFilmName >", value, "ffilmname");
            return (Criteria) this;
        }

        public Criteria andFfilmnameGreaterThanOrEqualTo(String value) {
            addCriterion("FFilmName >=", value, "ffilmname");
            return (Criteria) this;
        }

        public Criteria andFfilmnameLessThan(String value) {
            addCriterion("FFilmName <", value, "ffilmname");
            return (Criteria) this;
        }

        public Criteria andFfilmnameLessThanOrEqualTo(String value) {
            addCriterion("FFilmName <=", value, "ffilmname");
            return (Criteria) this;
        }

        public Criteria andFfilmnameLike(String value) {
            addCriterion("FFilmName like", value, "ffilmname");
            return (Criteria) this;
        }

        public Criteria andFfilmnameNotLike(String value) {
            addCriterion("FFilmName not like", value, "ffilmname");
            return (Criteria) this;
        }

        public Criteria andFfilmnameIn(List<String> values) {
            addCriterion("FFilmName in", values, "ffilmname");
            return (Criteria) this;
        }

        public Criteria andFfilmnameNotIn(List<String> values) {
            addCriterion("FFilmName not in", values, "ffilmname");
            return (Criteria) this;
        }

        public Criteria andFfilmnameBetween(String value1, String value2) {
            addCriterion("FFilmName between", value1, value2, "ffilmname");
            return (Criteria) this;
        }

        public Criteria andFfilmnameNotBetween(String value1, String value2) {
            addCriterion("FFilmName not between", value1, value2, "ffilmname");
            return (Criteria) this;
        }

        public Criteria andFdiretorIsNull() {
            addCriterion("FDiretor is null");
            return (Criteria) this;
        }

        public Criteria andFdiretorIsNotNull() {
            addCriterion("FDiretor is not null");
            return (Criteria) this;
        }

        public Criteria andFdiretorEqualTo(String value) {
            addCriterion("FDiretor =", value, "fdiretor");
            return (Criteria) this;
        }

        public Criteria andFdiretorNotEqualTo(String value) {
            addCriterion("FDiretor <>", value, "fdiretor");
            return (Criteria) this;
        }

        public Criteria andFdiretorGreaterThan(String value) {
            addCriterion("FDiretor >", value, "fdiretor");
            return (Criteria) this;
        }

        public Criteria andFdiretorGreaterThanOrEqualTo(String value) {
            addCriterion("FDiretor >=", value, "fdiretor");
            return (Criteria) this;
        }

        public Criteria andFdiretorLessThan(String value) {
            addCriterion("FDiretor <", value, "fdiretor");
            return (Criteria) this;
        }

        public Criteria andFdiretorLessThanOrEqualTo(String value) {
            addCriterion("FDiretor <=", value, "fdiretor");
            return (Criteria) this;
        }

        public Criteria andFdiretorLike(String value) {
            addCriterion("FDiretor like", value, "fdiretor");
            return (Criteria) this;
        }

        public Criteria andFdiretorNotLike(String value) {
            addCriterion("FDiretor not like", value, "fdiretor");
            return (Criteria) this;
        }

        public Criteria andFdiretorIn(List<String> values) {
            addCriterion("FDiretor in", values, "fdiretor");
            return (Criteria) this;
        }

        public Criteria andFdiretorNotIn(List<String> values) {
            addCriterion("FDiretor not in", values, "fdiretor");
            return (Criteria) this;
        }

        public Criteria andFdiretorBetween(String value1, String value2) {
            addCriterion("FDiretor between", value1, value2, "fdiretor");
            return (Criteria) this;
        }

        public Criteria andFdiretorNotBetween(String value1, String value2) {
            addCriterion("FDiretor not between", value1, value2, "fdiretor");
            return (Criteria) this;
        }

        public Criteria andFplayIsNull() {
            addCriterion("FPlay is null");
            return (Criteria) this;
        }

        public Criteria andFplayIsNotNull() {
            addCriterion("FPlay is not null");
            return (Criteria) this;
        }

        public Criteria andFplayEqualTo(String value) {
            addCriterion("FPlay =", value, "fplay");
            return (Criteria) this;
        }

        public Criteria andFplayNotEqualTo(String value) {
            addCriterion("FPlay <>", value, "fplay");
            return (Criteria) this;
        }

        public Criteria andFplayGreaterThan(String value) {
            addCriterion("FPlay >", value, "fplay");
            return (Criteria) this;
        }

        public Criteria andFplayGreaterThanOrEqualTo(String value) {
            addCriterion("FPlay >=", value, "fplay");
            return (Criteria) this;
        }

        public Criteria andFplayLessThan(String value) {
            addCriterion("FPlay <", value, "fplay");
            return (Criteria) this;
        }

        public Criteria andFplayLessThanOrEqualTo(String value) {
            addCriterion("FPlay <=", value, "fplay");
            return (Criteria) this;
        }

        public Criteria andFplayLike(String value) {
            addCriterion("FPlay like", value, "fplay");
            return (Criteria) this;
        }

        public Criteria andFplayNotLike(String value) {
            addCriterion("FPlay not like", value, "fplay");
            return (Criteria) this;
        }

        public Criteria andFplayIn(List<String> values) {
            addCriterion("FPlay in", values, "fplay");
            return (Criteria) this;
        }

        public Criteria andFplayNotIn(List<String> values) {
            addCriterion("FPlay not in", values, "fplay");
            return (Criteria) this;
        }

        public Criteria andFplayBetween(String value1, String value2) {
            addCriterion("FPlay between", value1, value2, "fplay");
            return (Criteria) this;
        }

        public Criteria andFplayNotBetween(String value1, String value2) {
            addCriterion("FPlay not between", value1, value2, "fplay");
            return (Criteria) this;
        }

        public Criteria andFintroIsNull() {
            addCriterion("FIntro is null");
            return (Criteria) this;
        }

        public Criteria andFintroIsNotNull() {
            addCriterion("FIntro is not null");
            return (Criteria) this;
        }

        public Criteria andFintroEqualTo(String value) {
            addCriterion("FIntro =", value, "fintro");
            return (Criteria) this;
        }

        public Criteria andFintroNotEqualTo(String value) {
            addCriterion("FIntro <>", value, "fintro");
            return (Criteria) this;
        }

        public Criteria andFintroGreaterThan(String value) {
            addCriterion("FIntro >", value, "fintro");
            return (Criteria) this;
        }

        public Criteria andFintroGreaterThanOrEqualTo(String value) {
            addCriterion("FIntro >=", value, "fintro");
            return (Criteria) this;
        }

        public Criteria andFintroLessThan(String value) {
            addCriterion("FIntro <", value, "fintro");
            return (Criteria) this;
        }

        public Criteria andFintroLessThanOrEqualTo(String value) {
            addCriterion("FIntro <=", value, "fintro");
            return (Criteria) this;
        }

        public Criteria andFintroLike(String value) {
            addCriterion("FIntro like", value, "fintro");
            return (Criteria) this;
        }

        public Criteria andFintroNotLike(String value) {
            addCriterion("FIntro not like", value, "fintro");
            return (Criteria) this;
        }

        public Criteria andFintroIn(List<String> values) {
            addCriterion("FIntro in", values, "fintro");
            return (Criteria) this;
        }

        public Criteria andFintroNotIn(List<String> values) {
            addCriterion("FIntro not in", values, "fintro");
            return (Criteria) this;
        }

        public Criteria andFintroBetween(String value1, String value2) {
            addCriterion("FIntro between", value1, value2, "fintro");
            return (Criteria) this;
        }

        public Criteria andFintroNotBetween(String value1, String value2) {
            addCriterion("FIntro not between", value1, value2, "fintro");
            return (Criteria) this;
        }

        public Criteria andFlanguageIsNull() {
            addCriterion("FLanguage is null");
            return (Criteria) this;
        }

        public Criteria andFlanguageIsNotNull() {
            addCriterion("FLanguage is not null");
            return (Criteria) this;
        }

        public Criteria andFlanguageEqualTo(String value) {
            addCriterion("FLanguage =", value, "flanguage");
            return (Criteria) this;
        }

        public Criteria andFlanguageNotEqualTo(String value) {
            addCriterion("FLanguage <>", value, "flanguage");
            return (Criteria) this;
        }

        public Criteria andFlanguageGreaterThan(String value) {
            addCriterion("FLanguage >", value, "flanguage");
            return (Criteria) this;
        }

        public Criteria andFlanguageGreaterThanOrEqualTo(String value) {
            addCriterion("FLanguage >=", value, "flanguage");
            return (Criteria) this;
        }

        public Criteria andFlanguageLessThan(String value) {
            addCriterion("FLanguage <", value, "flanguage");
            return (Criteria) this;
        }

        public Criteria andFlanguageLessThanOrEqualTo(String value) {
            addCriterion("FLanguage <=", value, "flanguage");
            return (Criteria) this;
        }

        public Criteria andFlanguageLike(String value) {
            addCriterion("FLanguage like", value, "flanguage");
            return (Criteria) this;
        }

        public Criteria andFlanguageNotLike(String value) {
            addCriterion("FLanguage not like", value, "flanguage");
            return (Criteria) this;
        }

        public Criteria andFlanguageIn(List<String> values) {
            addCriterion("FLanguage in", values, "flanguage");
            return (Criteria) this;
        }

        public Criteria andFlanguageNotIn(List<String> values) {
            addCriterion("FLanguage not in", values, "flanguage");
            return (Criteria) this;
        }

        public Criteria andFlanguageBetween(String value1, String value2) {
            addCriterion("FLanguage between", value1, value2, "flanguage");
            return (Criteria) this;
        }

        public Criteria andFlanguageNotBetween(String value1, String value2) {
            addCriterion("FLanguage not between", value1, value2, "flanguage");
            return (Criteria) this;
        }

        public Criteria andFlongIsNull() {
            addCriterion("FLong is null");
            return (Criteria) this;
        }

        public Criteria andFlongIsNotNull() {
            addCriterion("FLong is not null");
            return (Criteria) this;
        }

        public Criteria andFlongEqualTo(Integer value) {
            addCriterion("FLong =", value, "flong");
            return (Criteria) this;
        }

        public Criteria andFlongNotEqualTo(Integer value) {
            addCriterion("FLong <>", value, "flong");
            return (Criteria) this;
        }

        public Criteria andFlongGreaterThan(Integer value) {
            addCriterion("FLong >", value, "flong");
            return (Criteria) this;
        }

        public Criteria andFlongGreaterThanOrEqualTo(Integer value) {
            addCriterion("FLong >=", value, "flong");
            return (Criteria) this;
        }

        public Criteria andFlongLessThan(Integer value) {
            addCriterion("FLong <", value, "flong");
            return (Criteria) this;
        }

        public Criteria andFlongLessThanOrEqualTo(Integer value) {
            addCriterion("FLong <=", value, "flong");
            return (Criteria) this;
        }

        public Criteria andFlongIn(List<Integer> values) {
            addCriterion("FLong in", values, "flong");
            return (Criteria) this;
        }

        public Criteria andFlongNotIn(List<Integer> values) {
            addCriterion("FLong not in", values, "flong");
            return (Criteria) this;
        }

        public Criteria andFlongBetween(Integer value1, Integer value2) {
            addCriterion("FLong between", value1, value2, "flong");
            return (Criteria) this;
        }

        public Criteria andFlongNotBetween(Integer value1, Integer value2) {
            addCriterion("FLong not between", value1, value2, "flong");
            return (Criteria) this;
        }

        public Criteria andFdateIsNull() {
            addCriterion("FDate is null");
            return (Criteria) this;
        }

        public Criteria andFdateIsNotNull() {
            addCriterion("FDate is not null");
            return (Criteria) this;
        }

        public Criteria andFdateEqualTo(String value) {
            addCriterion("FDate =", value, "fdate");
            return (Criteria) this;
        }

        public Criteria andFdateNotEqualTo(String value) {
            addCriterion("FDate <>", value, "fdate");
            return (Criteria) this;
        }

        public Criteria andFdateGreaterThan(String value) {
            addCriterion("FDate >", value, "fdate");
            return (Criteria) this;
        }

        public Criteria andFdateGreaterThanOrEqualTo(String value) {
            addCriterion("FDate >=", value, "fdate");
            return (Criteria) this;
        }

        public Criteria andFdateLessThan(String value) {
            addCriterion("FDate <", value, "fdate");
            return (Criteria) this;
        }

        public Criteria andFdateLessThanOrEqualTo(String value) {
            addCriterion("FDate <=", value, "fdate");
            return (Criteria) this;
        }

        public Criteria andFdateLike(String value) {
            addCriterion("FDate like", value, "fdate");
            return (Criteria) this;
        }

        public Criteria andFdateNotLike(String value) {
            addCriterion("FDate not like", value, "fdate");
            return (Criteria) this;
        }

        public Criteria andFdateIn(List<String> values) {
            addCriterion("FDate in", values, "fdate");
            return (Criteria) this;
        }

        public Criteria andFdateNotIn(List<String> values) {
            addCriterion("FDate not in", values, "fdate");
            return (Criteria) this;
        }

        public Criteria andFdateBetween(String value1, String value2) {
            addCriterion("FDate between", value1, value2, "fdate");
            return (Criteria) this;
        }

        public Criteria andFdateNotBetween(String value1, String value2) {
            addCriterion("FDate not between", value1, value2, "fdate");
            return (Criteria) this;
        }

        public Criteria andFtypeIsNull() {
            addCriterion("FType is null");
            return (Criteria) this;
        }

        public Criteria andFtypeIsNotNull() {
            addCriterion("FType is not null");
            return (Criteria) this;
        }

        public Criteria andFtypeEqualTo(String value) {
            addCriterion("FType =", value, "ftype");
            return (Criteria) this;
        }

        public Criteria andFtypeNotEqualTo(String value) {
            addCriterion("FType <>", value, "ftype");
            return (Criteria) this;
        }

        public Criteria andFtypeGreaterThan(String value) {
            addCriterion("FType >", value, "ftype");
            return (Criteria) this;
        }

        public Criteria andFtypeGreaterThanOrEqualTo(String value) {
            addCriterion("FType >=", value, "ftype");
            return (Criteria) this;
        }

        public Criteria andFtypeLessThan(String value) {
            addCriterion("FType <", value, "ftype");
            return (Criteria) this;
        }

        public Criteria andFtypeLessThanOrEqualTo(String value) {
            addCriterion("FType <=", value, "ftype");
            return (Criteria) this;
        }

        public Criteria andFtypeLike(String value) {
            addCriterion("FType like", value, "ftype");
            return (Criteria) this;
        }

        public Criteria andFtypeNotLike(String value) {
            addCriterion("FType not like", value, "ftype");
            return (Criteria) this;
        }

        public Criteria andFtypeIn(List<String> values) {
            addCriterion("FType in", values, "ftype");
            return (Criteria) this;
        }

        public Criteria andFtypeNotIn(List<String> values) {
            addCriterion("FType not in", values, "ftype");
            return (Criteria) this;
        }

        public Criteria andFtypeBetween(String value1, String value2) {
            addCriterion("FType between", value1, value2, "ftype");
            return (Criteria) this;
        }

        public Criteria andFtypeNotBetween(String value1, String value2) {
            addCriterion("FType not between", value1, value2, "ftype");
            return (Criteria) this;
        }

        public Criteria andFphotoIsNull() {
            addCriterion("FPhoto is null");
            return (Criteria) this;
        }

        public Criteria andFphotoIsNotNull() {
            addCriterion("FPhoto is not null");
            return (Criteria) this;
        }

        public Criteria andFphotoEqualTo(String value) {
            addCriterion("FPhoto =", value, "fphoto");
            return (Criteria) this;
        }

        public Criteria andFphotoNotEqualTo(String value) {
            addCriterion("FPhoto <>", value, "fphoto");
            return (Criteria) this;
        }

        public Criteria andFphotoGreaterThan(String value) {
            addCriterion("FPhoto >", value, "fphoto");
            return (Criteria) this;
        }

        public Criteria andFphotoGreaterThanOrEqualTo(String value) {
            addCriterion("FPhoto >=", value, "fphoto");
            return (Criteria) this;
        }

        public Criteria andFphotoLessThan(String value) {
            addCriterion("FPhoto <", value, "fphoto");
            return (Criteria) this;
        }

        public Criteria andFphotoLessThanOrEqualTo(String value) {
            addCriterion("FPhoto <=", value, "fphoto");
            return (Criteria) this;
        }

        public Criteria andFphotoLike(String value) {
            addCriterion("FPhoto like", value, "fphoto");
            return (Criteria) this;
        }

        public Criteria andFphotoNotLike(String value) {
            addCriterion("FPhoto not like", value, "fphoto");
            return (Criteria) this;
        }

        public Criteria andFphotoIn(List<String> values) {
            addCriterion("FPhoto in", values, "fphoto");
            return (Criteria) this;
        }

        public Criteria andFphotoNotIn(List<String> values) {
            addCriterion("FPhoto not in", values, "fphoto");
            return (Criteria) this;
        }

        public Criteria andFphotoBetween(String value1, String value2) {
            addCriterion("FPhoto between", value1, value2, "fphoto");
            return (Criteria) this;
        }

        public Criteria andFphotoNotBetween(String value1, String value2) {
            addCriterion("FPhoto not between", value1, value2, "fphoto");
            return (Criteria) this;
        }

        public Criteria andFvideoIsNull() {
            addCriterion("FVideo is null");
            return (Criteria) this;
        }

        public Criteria andFvideoIsNotNull() {
            addCriterion("FVideo is not null");
            return (Criteria) this;
        }

        public Criteria andFvideoEqualTo(String value) {
            addCriterion("FVideo =", value, "fvideo");
            return (Criteria) this;
        }

        public Criteria andFvideoNotEqualTo(String value) {
            addCriterion("FVideo <>", value, "fvideo");
            return (Criteria) this;
        }

        public Criteria andFvideoGreaterThan(String value) {
            addCriterion("FVideo >", value, "fvideo");
            return (Criteria) this;
        }

        public Criteria andFvideoGreaterThanOrEqualTo(String value) {
            addCriterion("FVideo >=", value, "fvideo");
            return (Criteria) this;
        }

        public Criteria andFvideoLessThan(String value) {
            addCriterion("FVideo <", value, "fvideo");
            return (Criteria) this;
        }

        public Criteria andFvideoLessThanOrEqualTo(String value) {
            addCriterion("FVideo <=", value, "fvideo");
            return (Criteria) this;
        }

        public Criteria andFvideoLike(String value) {
            addCriterion("FVideo like", value, "fvideo");
            return (Criteria) this;
        }

        public Criteria andFvideoNotLike(String value) {
            addCriterion("FVideo not like", value, "fvideo");
            return (Criteria) this;
        }

        public Criteria andFvideoIn(List<String> values) {
            addCriterion("FVideo in", values, "fvideo");
            return (Criteria) this;
        }

        public Criteria andFvideoNotIn(List<String> values) {
            addCriterion("FVideo not in", values, "fvideo");
            return (Criteria) this;
        }

        public Criteria andFvideoBetween(String value1, String value2) {
            addCriterion("FVideo between", value1, value2, "fvideo");
            return (Criteria) this;
        }

        public Criteria andFvideoNotBetween(String value1, String value2) {
            addCriterion("FVideo not between", value1, value2, "fvideo");
            return (Criteria) this;
        }

        public Criteria andFpriceIsNull() {
            addCriterion("FPrice is null");
            return (Criteria) this;
        }

        public Criteria andFpriceIsNotNull() {
            addCriterion("FPrice is not null");
            return (Criteria) this;
        }

        public Criteria andFpriceEqualTo(Double value) {
            addCriterion("FPrice =", value, "fprice");
            return (Criteria) this;
        }

        public Criteria andFpriceNotEqualTo(Double value) {
            addCriterion("FPrice <>", value, "fprice");
            return (Criteria) this;
        }

        public Criteria andFpriceGreaterThan(Double value) {
            addCriterion("FPrice >", value, "fprice");
            return (Criteria) this;
        }

        public Criteria andFpriceGreaterThanOrEqualTo(Double value) {
            addCriterion("FPrice >=", value, "fprice");
            return (Criteria) this;
        }

        public Criteria andFpriceLessThan(Double value) {
            addCriterion("FPrice <", value, "fprice");
            return (Criteria) this;
        }

        public Criteria andFpriceLessThanOrEqualTo(Double value) {
            addCriterion("FPrice <=", value, "fprice");
            return (Criteria) this;
        }

        public Criteria andFpriceIn(List<Double> values) {
            addCriterion("FPrice in", values, "fprice");
            return (Criteria) this;
        }

        public Criteria andFpriceNotIn(List<Double> values) {
            addCriterion("FPrice not in", values, "fprice");
            return (Criteria) this;
        }

        public Criteria andFpriceBetween(Double value1, Double value2) {
            addCriterion("FPrice between", value1, value2, "fprice");
            return (Criteria) this;
        }

        public Criteria andFpriceNotBetween(Double value1, Double value2) {
            addCriterion("FPrice not between", value1, value2, "fprice");
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