package com.em.model;
import java.util.ArrayList;
import java.util.List;
public class MatchInfoExample {
    protected String orderByClause;
    protected boolean distinct;
    protected int startRow;
    protected int pageRows;
    protected List<Criteria> oredCriteria;
    public MatchInfoExample() {
        oredCriteria = new ArrayList<>();
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
    public void setStartRow(int startRow) {
        this.startRow = startRow;
    }
    public int getStartRow() {
        return startRow;
    }
    public void setPageRows(int pageRows) {
        this.pageRows = pageRows;
    }
    public int getPageRows() {
        return pageRows;
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
            criteria = new ArrayList<>();
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
  public Criteria andIdIsNotNull(){
		addCriterion("id is not null");
		return (Criteria) this;
		}
  public Criteria andIdEqualTo(Integer value) {
		  addCriterion("id =", value, "id");
		return (Criteria) this;
		}
   public Criteria andIdNotEqualTo(Integer value) {
		  addCriterion("id <>", value, "id");
		return (Criteria) this;
		}
    public Criteria andIdGreaterThan(Integer value) {
		 addCriterion("id >", value, "id");
		return (Criteria) this;
		}
  public Criteria andIdGreaterThanOrEqualTo(Integer value) {
		  addCriterion("id >=", value, "Id");
		return (Criteria) this;
		}
   public Criteria andIdLessThan(Integer value) {
		  addCriterion("id <", value, "id");
		return (Criteria) this;
		}
    public Criteria andIdLessThanOrEqualTo(Integer value) {
		  addCriterion("id <=", value, "id");
		return (Criteria) this;
		}
    public Criteria andIdIn(List<Integer> values) {
		  addCriterion("id in", values, "id");
		return (Criteria) this;
		}
    public Criteria andIdNotIn(List<Integer> values) {
		  addCriterion("id not in", values, "id");
		return (Criteria) this;
		}
     public Criteria andIdBetween(Integer value1, Integer value2) {
		   addCriterion("id between", value1, value2, "id");
		return (Criteria) this;
		}
     public Criteria andIdNotBetween(Integer value1, Integer value2) {
		   addCriterion("id not between", value1, value2, "id");
		return (Criteria) this;
		}
    public Criteria andIdLike(Integer value) {
		  addCriterion("id like", value, "id");
		return (Criteria) this;
		}
    public Criteria andIdNotLike(Integer value) {
		  addCriterion("id not like", value, "id");
		return (Criteria) this;
		}
 public Criteria andCreateTimeIsNull() {
		 addCriterion("create_time is null");
		return (Criteria) this;
		}
  public Criteria andCreateTimeIsNotNull(){
		addCriterion("create_time is not null");
		return (Criteria) this;
		}
  public Criteria andCreateTimeEqualTo(String value) {
		  addCriterion("create_time =", value, "createTime");
		return (Criteria) this;
		}
   public Criteria andCreateTimeNotEqualTo(String value) {
		  addCriterion("create_time <>", value, "createTime");
		return (Criteria) this;
		}
    public Criteria andCreateTimeGreaterThan(String value) {
		 addCriterion("create_time >", value, "createTime");
		return (Criteria) this;
		}
  public Criteria andCreateTimeGreaterThanOrEqualTo(String value) {
		  addCriterion("create_time >=", value, "CreateTime");
		return (Criteria) this;
		}
   public Criteria andCreateTimeLessThan(String value) {
		  addCriterion("create_time <", value, "createTime");
		return (Criteria) this;
		}
    public Criteria andCreateTimeLessThanOrEqualTo(String value) {
		  addCriterion("create_time <=", value, "createTime");
		return (Criteria) this;
		}
    public Criteria andCreateTimeIn(List<String> values) {
		  addCriterion("create_time in", values, "createTime");
		return (Criteria) this;
		}
    public Criteria andCreateTimeNotIn(List<String> values) {
		  addCriterion("create_time not in", values, "createTime");
		return (Criteria) this;
		}
     public Criteria andCreateTimeBetween(String value1, String value2) {
		   addCriterion("create_time between", value1, value2, "createTime");
		return (Criteria) this;
		}
     public Criteria andCreateTimeNotBetween(String value1, String value2) {
		   addCriterion("create_time not between", value1, value2, "createTime");
		return (Criteria) this;
		}
    public Criteria andCreateTimeLike(String value) {
		  addCriterion("create_time like", value, "createTime");
		return (Criteria) this;
		}
    public Criteria andCreateTimeNotLike(String value) {
		  addCriterion("create_time not like", value, "createTime");
		return (Criteria) this;
		}
 public Criteria andRequireIdIsNull() {
		 addCriterion("require_id is null");
		return (Criteria) this;
		}
  public Criteria andRequireIdIsNotNull(){
		addCriterion("require_id is not null");
		return (Criteria) this;
		}
  public Criteria andRequireIdEqualTo(Integer value) {
		  addCriterion("require_id =", value, "requireId");
		return (Criteria) this;
		}
   public Criteria andRequireIdNotEqualTo(Integer value) {
		  addCriterion("require_id <>", value, "requireId");
		return (Criteria) this;
		}
    public Criteria andRequireIdGreaterThan(Integer value) {
		 addCriterion("require_id >", value, "requireId");
		return (Criteria) this;
		}
  public Criteria andRequireIdGreaterThanOrEqualTo(Integer value) {
		  addCriterion("require_id >=", value, "RequireId");
		return (Criteria) this;
		}
   public Criteria andRequireIdLessThan(Integer value) {
		  addCriterion("require_id <", value, "requireId");
		return (Criteria) this;
		}
    public Criteria andRequireIdLessThanOrEqualTo(Integer value) {
		  addCriterion("require_id <=", value, "requireId");
		return (Criteria) this;
		}
    public Criteria andRequireIdIn(List<Integer> values) {
		  addCriterion("require_id in", values, "requireId");
		return (Criteria) this;
		}
    public Criteria andRequireIdNotIn(List<Integer> values) {
		  addCriterion("require_id not in", values, "requireId");
		return (Criteria) this;
		}
     public Criteria andRequireIdBetween(Integer value1, Integer value2) {
		   addCriterion("require_id between", value1, value2, "requireId");
		return (Criteria) this;
		}
     public Criteria andRequireIdNotBetween(Integer value1, Integer value2) {
		   addCriterion("require_id not between", value1, value2, "requireId");
		return (Criteria) this;
		}
    public Criteria andRequireIdLike(Integer value) {
		  addCriterion("require_id like", value, "requireId");
		return (Criteria) this;
		}
    public Criteria andRequireIdNotLike(Integer value) {
		  addCriterion("require_id not like", value, "requireId");
		return (Criteria) this;
		}
 public Criteria andRequestIdIsNull() {
		 addCriterion("request_id is null");
		return (Criteria) this;
		}
  public Criteria andRequestIdIsNotNull(){
		addCriterion("request_id is not null");
		return (Criteria) this;
		}
  public Criteria andRequestIdEqualTo(Integer value) {
		  addCriterion("request_id =", value, "requestId");
		return (Criteria) this;
		}
   public Criteria andRequestIdNotEqualTo(Integer value) {
		  addCriterion("request_id <>", value, "requestId");
		return (Criteria) this;
		}
    public Criteria andRequestIdGreaterThan(Integer value) {
		 addCriterion("request_id >", value, "requestId");
		return (Criteria) this;
		}
  public Criteria andRequestIdGreaterThanOrEqualTo(Integer value) {
		  addCriterion("request_id >=", value, "RequestId");
		return (Criteria) this;
		}
   public Criteria andRequestIdLessThan(Integer value) {
		  addCriterion("request_id <", value, "requestId");
		return (Criteria) this;
		}
    public Criteria andRequestIdLessThanOrEqualTo(Integer value) {
		  addCriterion("request_id <=", value, "requestId");
		return (Criteria) this;
		}
    public Criteria andRequestIdIn(List<Integer> values) {
		  addCriterion("request_id in", values, "requestId");
		return (Criteria) this;
		}
    public Criteria andRequestIdNotIn(List<Integer> values) {
		  addCriterion("request_id not in", values, "requestId");
		return (Criteria) this;
		}
     public Criteria andRequestIdBetween(Integer value1, Integer value2) {
		   addCriterion("request_id between", value1, value2, "requestId");
		return (Criteria) this;
		}
     public Criteria andRequestIdNotBetween(Integer value1, Integer value2) {
		   addCriterion("request_id not between", value1, value2, "requestId");
		return (Criteria) this;
		}
    public Criteria andRequestIdLike(Integer value) {
		  addCriterion("request_id like", value, "requestId");
		return (Criteria) this;
		}
    public Criteria andRequestIdNotLike(Integer value) {
		  addCriterion("request_id not like", value, "requestId");
		return (Criteria) this;
		}
 public Criteria andTeacherIdIsNull() {
		 addCriterion("teacher_id is null");
		return (Criteria) this;
		}
  public Criteria andTeacherIdIsNotNull(){
		addCriterion("teacher_id is not null");
		return (Criteria) this;
		}
  public Criteria andTeacherIdEqualTo(Integer value) {
		  addCriterion("teacher_id =", value, "teacherId");
		return (Criteria) this;
		}
   public Criteria andTeacherIdNotEqualTo(Integer value) {
		  addCriterion("teacher_id <>", value, "teacherId");
		return (Criteria) this;
		}
    public Criteria andTeacherIdGreaterThan(Integer value) {
		 addCriterion("teacher_id >", value, "teacherId");
		return (Criteria) this;
		}
  public Criteria andTeacherIdGreaterThanOrEqualTo(Integer value) {
		  addCriterion("teacher_id >=", value, "TeacherId");
		return (Criteria) this;
		}
   public Criteria andTeacherIdLessThan(Integer value) {
		  addCriterion("teacher_id <", value, "teacherId");
		return (Criteria) this;
		}
    public Criteria andTeacherIdLessThanOrEqualTo(Integer value) {
		  addCriterion("teacher_id <=", value, "teacherId");
		return (Criteria) this;
		}
    public Criteria andTeacherIdIn(List<Integer> values) {
		  addCriterion("teacher_id in", values, "teacherId");
		return (Criteria) this;
		}
    public Criteria andTeacherIdNotIn(List<Integer> values) {
		  addCriterion("teacher_id not in", values, "teacherId");
		return (Criteria) this;
		}
     public Criteria andTeacherIdBetween(Integer value1, Integer value2) {
		   addCriterion("teacher_id between", value1, value2, "teacherId");
		return (Criteria) this;
		}
     public Criteria andTeacherIdNotBetween(Integer value1, Integer value2) {
		   addCriterion("teacher_id not between", value1, value2, "teacherId");
		return (Criteria) this;
		}
    public Criteria andTeacherIdLike(Integer value) {
		  addCriterion("teacher_id like", value, "teacherId");
		return (Criteria) this;
		}
    public Criteria andTeacherIdNotLike(Integer value) {
		  addCriterion("teacher_id not like", value, "teacherId");
		return (Criteria) this;
		}
 public Criteria andClassIdIsNull() {
		 addCriterion("class_id is null");
		return (Criteria) this;
		}
  public Criteria andClassIdIsNotNull(){
		addCriterion("class_id is not null");
		return (Criteria) this;
		}
  public Criteria andClassIdEqualTo(Integer value) {
		  addCriterion("class_id =", value, "classId");
		return (Criteria) this;
		}
   public Criteria andClassIdNotEqualTo(Integer value) {
		  addCriterion("class_id <>", value, "classId");
		return (Criteria) this;
		}
    public Criteria andClassIdGreaterThan(Integer value) {
		 addCriterion("class_id >", value, "classId");
		return (Criteria) this;
		}
  public Criteria andClassIdGreaterThanOrEqualTo(Integer value) {
		  addCriterion("class_id >=", value, "ClassId");
		return (Criteria) this;
		}
   public Criteria andClassIdLessThan(Integer value) {
		  addCriterion("class_id <", value, "classId");
		return (Criteria) this;
		}
    public Criteria andClassIdLessThanOrEqualTo(Integer value) {
		  addCriterion("class_id <=", value, "classId");
		return (Criteria) this;
		}
    public Criteria andClassIdIn(List<Integer> values) {
		  addCriterion("class_id in", values, "classId");
		return (Criteria) this;
		}
    public Criteria andClassIdNotIn(List<Integer> values) {
		  addCriterion("class_id not in", values, "classId");
		return (Criteria) this;
		}
     public Criteria andClassIdBetween(Integer value1, Integer value2) {
		   addCriterion("class_id between", value1, value2, "classId");
		return (Criteria) this;
		}
     public Criteria andClassIdNotBetween(Integer value1, Integer value2) {
		   addCriterion("class_id not between", value1, value2, "classId");
		return (Criteria) this;
		}
    public Criteria andClassIdLike(Integer value) {
		  addCriterion("class_id like", value, "classId");
		return (Criteria) this;
		}
    public Criteria andClassIdNotLike(Integer value) {
		  addCriterion("class_id not like", value, "classId");
		return (Criteria) this;
		}
 public Criteria andManageIdIsNull() {
		 addCriterion("manage_id is null");
		return (Criteria) this;
		}
  public Criteria andManageIdIsNotNull(){
		addCriterion("manage_id is not null");
		return (Criteria) this;
		}
  public Criteria andManageIdEqualTo(Integer value) {
		  addCriterion("manage_id =", value, "manageId");
		return (Criteria) this;
		}
   public Criteria andManageIdNotEqualTo(Integer value) {
		  addCriterion("manage_id <>", value, "manageId");
		return (Criteria) this;
		}
    public Criteria andManageIdGreaterThan(Integer value) {
		 addCriterion("manage_id >", value, "manageId");
		return (Criteria) this;
		}
  public Criteria andManageIdGreaterThanOrEqualTo(Integer value) {
		  addCriterion("manage_id >=", value, "ManageId");
		return (Criteria) this;
		}
   public Criteria andManageIdLessThan(Integer value) {
		  addCriterion("manage_id <", value, "manageId");
		return (Criteria) this;
		}
    public Criteria andManageIdLessThanOrEqualTo(Integer value) {
		  addCriterion("manage_id <=", value, "manageId");
		return (Criteria) this;
		}
    public Criteria andManageIdIn(List<Integer> values) {
		  addCriterion("manage_id in", values, "manageId");
		return (Criteria) this;
		}
    public Criteria andManageIdNotIn(List<Integer> values) {
		  addCriterion("manage_id not in", values, "manageId");
		return (Criteria) this;
		}
     public Criteria andManageIdBetween(Integer value1, Integer value2) {
		   addCriterion("manage_id between", value1, value2, "manageId");
		return (Criteria) this;
		}
     public Criteria andManageIdNotBetween(Integer value1, Integer value2) {
		   addCriterion("manage_id not between", value1, value2, "manageId");
		return (Criteria) this;
		}
    public Criteria andManageIdLike(Integer value) {
		  addCriterion("manage_id like", value, "manageId");
		return (Criteria) this;
		}
    public Criteria andManageIdNotLike(Integer value) {
		  addCriterion("manage_id not like", value, "manageId");
		return (Criteria) this;
		}
 public Criteria andSemesterIdIsNull() {
		 addCriterion("semester_id is null");
		return (Criteria) this;
		}
  public Criteria andSemesterIdIsNotNull(){
		addCriterion("semester_id is not null");
		return (Criteria) this;
		}
  public Criteria andSemesterIdEqualTo(Integer value) {
		  addCriterion("semester_id =", value, "semesterId");
		return (Criteria) this;
		}
   public Criteria andSemesterIdNotEqualTo(Integer value) {
		  addCriterion("semester_id <>", value, "semesterId");
		return (Criteria) this;
		}
    public Criteria andSemesterIdGreaterThan(Integer value) {
		 addCriterion("semester_id >", value, "semesterId");
		return (Criteria) this;
		}
  public Criteria andSemesterIdGreaterThanOrEqualTo(Integer value) {
		  addCriterion("semester_id >=", value, "SemesterId");
		return (Criteria) this;
		}
   public Criteria andSemesterIdLessThan(Integer value) {
		  addCriterion("semester_id <", value, "semesterId");
		return (Criteria) this;
		}
    public Criteria andSemesterIdLessThanOrEqualTo(Integer value) {
		  addCriterion("semester_id <=", value, "semesterId");
		return (Criteria) this;
		}
    public Criteria andSemesterIdIn(List<Integer> values) {
		  addCriterion("semester_id in", values, "semesterId");
		return (Criteria) this;
		}
    public Criteria andSemesterIdNotIn(List<Integer> values) {
		  addCriterion("semester_id not in", values, "semesterId");
		return (Criteria) this;
		}
     public Criteria andSemesterIdBetween(Integer value1, Integer value2) {
		   addCriterion("semester_id between", value1, value2, "semesterId");
		return (Criteria) this;
		}
     public Criteria andSemesterIdNotBetween(Integer value1, Integer value2) {
		   addCriterion("semester_id not between", value1, value2, "semesterId");
		return (Criteria) this;
		}
    public Criteria andSemesterIdLike(Integer value) {
		  addCriterion("semester_id like", value, "semesterId");
		return (Criteria) this;
		}
    public Criteria andSemesterIdNotLike(Integer value) {
		  addCriterion("semester_id not like", value, "semesterId");
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
