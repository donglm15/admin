package com.unicom.admin.model;

import java.util.ArrayList;
import java.util.List;

public class MarketExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MarketExample() {
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

        public Criteria andIdEqualTo(tinyint value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(tinyint value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(tinyint value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(tinyint value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(tinyint value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(tinyint value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<tinyint> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<tinyint> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(tinyint value1, tinyint value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(tinyint value1, tinyint value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(varchar value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(varchar value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(varchar value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(varchar value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(varchar value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(varchar value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(varchar value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(varchar value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<varchar> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<varchar> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(varchar value1, varchar value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(varchar value1, varchar value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andStartDateIsNull() {
            addCriterion("startDate is null");
            return (Criteria) this;
        }

        public Criteria andStartDateIsNotNull() {
            addCriterion("startDate is not null");
            return (Criteria) this;
        }

        public Criteria andStartDateEqualTo(datetime value) {
            addCriterion("startDate =", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotEqualTo(datetime value) {
            addCriterion("startDate <>", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateGreaterThan(datetime value) {
            addCriterion("startDate >", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateGreaterThanOrEqualTo(datetime value) {
            addCriterion("startDate >=", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateLessThan(datetime value) {
            addCriterion("startDate <", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateLessThanOrEqualTo(datetime value) {
            addCriterion("startDate <=", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateIn(List<datetime> values) {
            addCriterion("startDate in", values, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotIn(List<datetime> values) {
            addCriterion("startDate not in", values, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateBetween(datetime value1, datetime value2) {
            addCriterion("startDate between", value1, value2, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotBetween(datetime value1, datetime value2) {
            addCriterion("startDate not between", value1, value2, "startDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNull() {
            addCriterion("endDate is null");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNotNull() {
            addCriterion("endDate is not null");
            return (Criteria) this;
        }

        public Criteria andEndDateEqualTo(datetime value) {
            addCriterion("endDate =", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotEqualTo(datetime value) {
            addCriterion("endDate <>", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThan(datetime value) {
            addCriterion("endDate >", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThanOrEqualTo(datetime value) {
            addCriterion("endDate >=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThan(datetime value) {
            addCriterion("endDate <", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThanOrEqualTo(datetime value) {
            addCriterion("endDate <=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIn(List<datetime> values) {
            addCriterion("endDate in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotIn(List<datetime> values) {
            addCriterion("endDate not in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateBetween(datetime value1, datetime value2) {
            addCriterion("endDate between", value1, value2, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotBetween(datetime value1, datetime value2) {
            addCriterion("endDate not between", value1, value2, "endDate");
            return (Criteria) this;
        }

        public Criteria andEmployNameIsNull() {
            addCriterion("employName is null");
            return (Criteria) this;
        }

        public Criteria andEmployNameIsNotNull() {
            addCriterion("employName is not null");
            return (Criteria) this;
        }

        public Criteria andEmployNameEqualTo(varchar value) {
            addCriterion("employName =", value, "employName");
            return (Criteria) this;
        }

        public Criteria andEmployNameNotEqualTo(varchar value) {
            addCriterion("employName <>", value, "employName");
            return (Criteria) this;
        }

        public Criteria andEmployNameGreaterThan(varchar value) {
            addCriterion("employName >", value, "employName");
            return (Criteria) this;
        }

        public Criteria andEmployNameGreaterThanOrEqualTo(varchar value) {
            addCriterion("employName >=", value, "employName");
            return (Criteria) this;
        }

        public Criteria andEmployNameLessThan(varchar value) {
            addCriterion("employName <", value, "employName");
            return (Criteria) this;
        }

        public Criteria andEmployNameLessThanOrEqualTo(varchar value) {
            addCriterion("employName <=", value, "employName");
            return (Criteria) this;
        }

        public Criteria andEmployNameLike(varchar value) {
            addCriterion("employName like", value, "employName");
            return (Criteria) this;
        }

        public Criteria andEmployNameNotLike(varchar value) {
            addCriterion("employName not like", value, "employName");
            return (Criteria) this;
        }

        public Criteria andEmployNameIn(List<varchar> values) {
            addCriterion("employName in", values, "employName");
            return (Criteria) this;
        }

        public Criteria andEmployNameNotIn(List<varchar> values) {
            addCriterion("employName not in", values, "employName");
            return (Criteria) this;
        }

        public Criteria andEmployNameBetween(varchar value1, varchar value2) {
            addCriterion("employName between", value1, value2, "employName");
            return (Criteria) this;
        }

        public Criteria andEmployNameNotBetween(varchar value1, varchar value2) {
            addCriterion("employName not between", value1, value2, "employName");
            return (Criteria) this;
        }

        public Criteria andImportanceIsNull() {
            addCriterion("importance is null");
            return (Criteria) this;
        }

        public Criteria andImportanceIsNotNull() {
            addCriterion("importance is not null");
            return (Criteria) this;
        }

        public Criteria andImportanceEqualTo(tinyint value) {
            addCriterion("importance =", value, "importance");
            return (Criteria) this;
        }

        public Criteria andImportanceNotEqualTo(tinyint value) {
            addCriterion("importance <>", value, "importance");
            return (Criteria) this;
        }

        public Criteria andImportanceGreaterThan(tinyint value) {
            addCriterion("importance >", value, "importance");
            return (Criteria) this;
        }

        public Criteria andImportanceGreaterThanOrEqualTo(tinyint value) {
            addCriterion("importance >=", value, "importance");
            return (Criteria) this;
        }

        public Criteria andImportanceLessThan(tinyint value) {
            addCriterion("importance <", value, "importance");
            return (Criteria) this;
        }

        public Criteria andImportanceLessThanOrEqualTo(tinyint value) {
            addCriterion("importance <=", value, "importance");
            return (Criteria) this;
        }

        public Criteria andImportanceIn(List<tinyint> values) {
            addCriterion("importance in", values, "importance");
            return (Criteria) this;
        }

        public Criteria andImportanceNotIn(List<tinyint> values) {
            addCriterion("importance not in", values, "importance");
            return (Criteria) this;
        }

        public Criteria andImportanceBetween(tinyint value1, tinyint value2) {
            addCriterion("importance between", value1, value2, "importance");
            return (Criteria) this;
        }

        public Criteria andImportanceNotBetween(tinyint value1, tinyint value2) {
            addCriterion("importance not between", value1, value2, "importance");
            return (Criteria) this;
        }

        public Criteria andJobPlaceIsNull() {
            addCriterion("jobPlace is null");
            return (Criteria) this;
        }

        public Criteria andJobPlaceIsNotNull() {
            addCriterion("jobPlace is not null");
            return (Criteria) this;
        }

        public Criteria andJobPlaceEqualTo(varchar value) {
            addCriterion("jobPlace =", value, "jobPlace");
            return (Criteria) this;
        }

        public Criteria andJobPlaceNotEqualTo(varchar value) {
            addCriterion("jobPlace <>", value, "jobPlace");
            return (Criteria) this;
        }

        public Criteria andJobPlaceGreaterThan(varchar value) {
            addCriterion("jobPlace >", value, "jobPlace");
            return (Criteria) this;
        }

        public Criteria andJobPlaceGreaterThanOrEqualTo(varchar value) {
            addCriterion("jobPlace >=", value, "jobPlace");
            return (Criteria) this;
        }

        public Criteria andJobPlaceLessThan(varchar value) {
            addCriterion("jobPlace <", value, "jobPlace");
            return (Criteria) this;
        }

        public Criteria andJobPlaceLessThanOrEqualTo(varchar value) {
            addCriterion("jobPlace <=", value, "jobPlace");
            return (Criteria) this;
        }

        public Criteria andJobPlaceLike(varchar value) {
            addCriterion("jobPlace like", value, "jobPlace");
            return (Criteria) this;
        }

        public Criteria andJobPlaceNotLike(varchar value) {
            addCriterion("jobPlace not like", value, "jobPlace");
            return (Criteria) this;
        }

        public Criteria andJobPlaceIn(List<varchar> values) {
            addCriterion("jobPlace in", values, "jobPlace");
            return (Criteria) this;
        }

        public Criteria andJobPlaceNotIn(List<varchar> values) {
            addCriterion("jobPlace not in", values, "jobPlace");
            return (Criteria) this;
        }

        public Criteria andJobPlaceBetween(varchar value1, varchar value2) {
            addCriterion("jobPlace between", value1, value2, "jobPlace");
            return (Criteria) this;
        }

        public Criteria andJobPlaceNotBetween(varchar value1, varchar value2) {
            addCriterion("jobPlace not between", value1, value2, "jobPlace");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(varchar value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(varchar value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(varchar value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(varchar value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(varchar value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(varchar value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(varchar value) {
            addCriterion("content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(varchar value) {
            addCriterion("content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<varchar> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<varchar> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(varchar value1, varchar value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(varchar value1, varchar value2) {
            addCriterion("content not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andMarketTypeIdIsNull() {
            addCriterion("marketTypeId is null");
            return (Criteria) this;
        }

        public Criteria andMarketTypeIdIsNotNull() {
            addCriterion("marketTypeId is not null");
            return (Criteria) this;
        }

        public Criteria andMarketTypeIdEqualTo(tinyint value) {
            addCriterion("marketTypeId =", value, "marketTypeId");
            return (Criteria) this;
        }

        public Criteria andMarketTypeIdNotEqualTo(tinyint value) {
            addCriterion("marketTypeId <>", value, "marketTypeId");
            return (Criteria) this;
        }

        public Criteria andMarketTypeIdGreaterThan(tinyint value) {
            addCriterion("marketTypeId >", value, "marketTypeId");
            return (Criteria) this;
        }

        public Criteria andMarketTypeIdGreaterThanOrEqualTo(tinyint value) {
            addCriterion("marketTypeId >=", value, "marketTypeId");
            return (Criteria) this;
        }

        public Criteria andMarketTypeIdLessThan(tinyint value) {
            addCriterion("marketTypeId <", value, "marketTypeId");
            return (Criteria) this;
        }

        public Criteria andMarketTypeIdLessThanOrEqualTo(tinyint value) {
            addCriterion("marketTypeId <=", value, "marketTypeId");
            return (Criteria) this;
        }

        public Criteria andMarketTypeIdIn(List<tinyint> values) {
            addCriterion("marketTypeId in", values, "marketTypeId");
            return (Criteria) this;
        }

        public Criteria andMarketTypeIdNotIn(List<tinyint> values) {
            addCriterion("marketTypeId not in", values, "marketTypeId");
            return (Criteria) this;
        }

        public Criteria andMarketTypeIdBetween(tinyint value1, tinyint value2) {
            addCriterion("marketTypeId between", value1, value2, "marketTypeId");
            return (Criteria) this;
        }

        public Criteria andMarketTypeIdNotBetween(tinyint value1, tinyint value2) {
            addCriterion("marketTypeId not between", value1, value2, "marketTypeId");
            return (Criteria) this;
        }

        public Criteria andStatusIdIsNull() {
            addCriterion("statusId is null");
            return (Criteria) this;
        }

        public Criteria andStatusIdIsNotNull() {
            addCriterion("statusId is not null");
            return (Criteria) this;
        }

        public Criteria andStatusIdEqualTo(tinyint value) {
            addCriterion("statusId =", value, "statusId");
            return (Criteria) this;
        }

        public Criteria andStatusIdNotEqualTo(tinyint value) {
            addCriterion("statusId <>", value, "statusId");
            return (Criteria) this;
        }

        public Criteria andStatusIdGreaterThan(tinyint value) {
            addCriterion("statusId >", value, "statusId");
            return (Criteria) this;
        }

        public Criteria andStatusIdGreaterThanOrEqualTo(tinyint value) {
            addCriterion("statusId >=", value, "statusId");
            return (Criteria) this;
        }

        public Criteria andStatusIdLessThan(tinyint value) {
            addCriterion("statusId <", value, "statusId");
            return (Criteria) this;
        }

        public Criteria andStatusIdLessThanOrEqualTo(tinyint value) {
            addCriterion("statusId <=", value, "statusId");
            return (Criteria) this;
        }

        public Criteria andStatusIdIn(List<tinyint> values) {
            addCriterion("statusId in", values, "statusId");
            return (Criteria) this;
        }

        public Criteria andStatusIdNotIn(List<tinyint> values) {
            addCriterion("statusId not in", values, "statusId");
            return (Criteria) this;
        }

        public Criteria andStatusIdBetween(tinyint value1, tinyint value2) {
            addCriterion("statusId between", value1, value2, "statusId");
            return (Criteria) this;
        }

        public Criteria andStatusIdNotBetween(tinyint value1, tinyint value2) {
            addCriterion("statusId not between", value1, value2, "statusId");
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