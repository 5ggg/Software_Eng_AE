package com.em.model;
import java.util.ArrayList;
import java.util.List;
public class TeachingRequestExample {
    protected String orderByClause;
    protected boolean distinct;
    protected int startRow;
    protected int pageRows;
    protected List<Criteria> oredCriteria;
    public TeachingRequestExample() {
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
 public Criteria andSubjectIdIsNull() {
		 addCriterion("subject_id is null");
		return (Criteria) this;
		}
  public Criteria andSubjectIdIsNotNull(){
		addCriterion("subject_id is not null");
		return (Criteria) this;
		}
  public Criteria andSubjectIdEqualTo(Integer value) {
		  addCriterion("subject_id =", value, "subjectId");
		return (Criteria) this;
		}
   public Criteria andSubjectIdNotEqualTo(Integer value) {
		  addCriterion("subject_id <>", value, "subjectId");
		return (Criteria) this;
		}
    public Criteria andSubjectIdGreaterThan(Integer value) {
		 addCriterion("subject_id >", value, "subjectId");
		return (Criteria) this;
		}
  public Criteria andSubjectIdGreaterThanOrEqualTo(Integer value) {
		  addCriterion("subject_id >=", value, "SubjectId");
		return (Criteria) this;
		}
   public Criteria andSubjectIdLessThan(Integer value) {
		  addCriterion("subject_id <", value, "subjectId");
		return (Criteria) this;
		}
    public Criteria andSubjectIdLessThanOrEqualTo(Integer value) {
		  addCriterion("subject_id <=", value, "subjectId");
		return (Criteria) this;
		}
    public Criteria andSubjectIdIn(List<Integer> values) {
		  addCriterion("subject_id in", values, "subjectId");
		return (Criteria) this;
		}
    public Criteria andSubjectIdNotIn(List<Integer> values) {
		  addCriterion("subject_id not in", values, "subjectId");
		return (Criteria) this;
		}
     public Criteria andSubjectIdBetween(Integer value1, Integer value2) {
		   addCriterion("subject_id between", value1, value2, "subjectId");
		return (Criteria) this;
		}
     public Criteria andSubjectIdNotBetween(Integer value1, Integer value2) {
		   addCriterion("subject_id not between", value1, value2, "subjectId");
		return (Criteria) this;
		}
    public Criteria andSubjectIdLike(Integer value) {
		  addCriterion("subject_id like", value, "subjectId");
		return (Criteria) this;
		}
    public Criteria andSubjectIdNotLike(Integer value) {
		  addCriterion("subject_id not like", value, "subjectId");
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
 public Criteria andTeaherIdIsNull() {
		 addCriterion("teaher_id is null");
		return (Criteria) this;
		}
  public Criteria andTeaherIdIsNotNull(){
		addCriterion("teaher_id is not null");
		return (Criteria) this;
		}
  public Criteria andTeaherIdEqualTo(Integer value) {
		  addCriterion("teaher_id =", value, "teaherId");
		return (Criteria) this;
		}
   public Criteria andTeaherIdNotEqualTo(Integer value) {
		  addCriterion("teaher_id <>", value, "teaherId");
		return (Criteria) this;
		}
    public Criteria andTeaherIdGreaterThan(Integer value) {
		 addCriterion("teaher_id >", value, "teaherId");
		return (Criteria) this;
		}
  public Criteria andTeaherIdGreaterThanOrEqualTo(Integer value) {
		  addCriterion("teaher_id >=", value, "TeaherId");
		return (Criteria) this;
		}
   public Criteria andTeaherIdLessThan(Integer value) {
		  addCriterion("teaher_id <", value, "teaherId");
		return (Criteria) this;
		}
    public Criteria andTeaherIdLessThanOrEqualTo(Integer value) {
		  addCriterion("teaher_id <=", value, "teaherId");
		return (Criteria) this;
		}
    public Criteria andTeaherIdIn(List<Integer> values) {
		  addCriterion("teaher_id in", values, "teaherId");
		return (Criteria) this;
		}
    public Criteria andTeaherIdNotIn(List<Integer> values) {
		  addCriterion("teaher_id not in", values, "teaherId");
		return (Criteria) this;
		}
     public Criteria andTeaherIdBetween(Integer value1, Integer value2) {
		   addCriterion("teaher_id between", value1, value2, "teaherId");
		return (Criteria) this;
		}
     public Criteria andTeaherIdNotBetween(Integer value1, Integer value2) {
		   addCriterion("teaher_id not between", value1, value2, "teaherId");
		return (Criteria) this;
		}
    public Criteria andTeaherIdLike(Integer value) {
		  addCriterion("teaher_id like", value, "teaherId");
		return (Criteria) this;
		}
    public Criteria andTeaherIdNotLike(Integer value) {
		  addCriterion("teaher_id not like", value, "teaherId");
		return (Criteria) this;
		}
 public Criteria andTeachDescIsNull() {
		 addCriterion("teach_desc is null");
		return (Criteria) this;
		}
  public Criteria andTeachDescIsNotNull(){
		addCriterion("teach_desc is not null");
		return (Criteria) this;
		}
  public Criteria andTeachDescEqualTo(String value) {
		  addCriterion("teach_desc =", value, "teachDesc");
		return (Criteria) this;
		}
   public Criteria andTeachDescNotEqualTo(String value) {
		  addCriterion("teach_desc <>", value, "teachDesc");
		return (Criteria) this;
		}
    public Criteria andTeachDescGreaterThan(String value) {
		 addCriterion("teach_desc >", value, "teachDesc");
		return (Criteria) this;
		}
  public Criteria andTeachDescGreaterThanOrEqualTo(String value) {
		  addCriterion("teach_desc >=", value, "TeachDesc");
		return (Criteria) this;
		}
   public Criteria andTeachDescLessThan(String value) {
		  addCriterion("teach_desc <", value, "teachDesc");
		return (Criteria) this;
		}
    public Criteria andTeachDescLessThanOrEqualTo(String value) {
		  addCriterion("teach_desc <=", value, "teachDesc");
		return (Criteria) this;
		}
    public Criteria andTeachDescIn(List<String> values) {
		  addCriterion("teach_desc in", values, "teachDesc");
		return (Criteria) this;
		}
    public Criteria andTeachDescNotIn(List<String> values) {
		  addCriterion("teach_desc not in", values, "teachDesc");
		return (Criteria) this;
		}
     public Criteria andTeachDescBetween(String value1, String value2) {
		   addCriterion("teach_desc between", value1, value2, "teachDesc");
		return (Criteria) this;
		}
     public Criteria andTeachDescNotBetween(String value1, String value2) {
		   addCriterion("teach_desc not between", value1, value2, "teachDesc");
		return (Criteria) this;
		}
    public Criteria andTeachDescLike(String value) {
		  addCriterion("teach_desc like", value, "teachDesc");
		return (Criteria) this;
		}
    public Criteria andTeachDescNotLike(String value) {
		  addCriterion("teach_desc not like", value, "teachDesc");
		return (Criteria) this;
		}
 public Criteria andCheckStatusIsNull() {
		 addCriterion("check_status is null");
		return (Criteria) this;
		}
  public Criteria andCheckStatusIsNotNull(){
		addCriterion("check_status is not null");
		return (Criteria) this;
		}
  public Criteria andCheckStatusEqualTo(Integer value) {
		  addCriterion("check_status =", value, "checkStatus");
		return (Criteria) this;
		}
   public Criteria andCheckStatusNotEqualTo(Integer value) {
		  addCriterion("check_status <>", value, "checkStatus");
		return (Criteria) this;
		}
    public Criteria andCheckStatusGreaterThan(Integer value) {
		 addCriterion("check_status >", value, "checkStatus");
		return (Criteria) this;
		}
  public Criteria andCheckStatusGreaterThanOrEqualTo(Integer value) {
		  addCriterion("check_status >=", value, "CheckStatus");
		return (Criteria) this;
		}
   public Criteria andCheckStatusLessThan(Integer value) {
		  addCriterion("check_status <", value, "checkStatus");
		return (Criteria) this;
		}
    public Criteria andCheckStatusLessThanOrEqualTo(Integer value) {
		  addCriterion("check_status <=", value, "checkStatus");
		return (Criteria) this;
		}
    public Criteria andCheckStatusIn(List<Integer> values) {
		  addCriterion("check_status in", values, "checkStatus");
		return (Criteria) this;
		}
    public Criteria andCheckStatusNotIn(List<Integer> values) {
		  addCriterion("check_status not in", values, "checkStatus");
		return (Criteria) this;
		}
     public Criteria andCheckStatusBetween(Integer value1, Integer value2) {
		   addCriterion("check_status between", value1, value2, "checkStatus");
		return (Criteria) this;
		}
     public Criteria andCheckStatusNotBetween(Integer value1, Integer value2) {
		   addCriterion("check_status not between", value1, value2, "checkStatus");
		return (Criteria) this;
		}
    public Criteria andCheckStatusLike(Integer value) {
		  addCriterion("check_status like", value, "checkStatus");
		return (Criteria) this;
		}
    public Criteria andCheckStatusNotLike(Integer value) {
		  addCriterion("check_status not like", value, "checkStatus");
		return (Criteria) this;
		}
 public Criteria andCheckRemarkIsNull() {
		 addCriterion("check_remark is null");
		return (Criteria) this;
		}
  public Criteria andCheckRemarkIsNotNull(){
		addCriterion("check_remark is not null");
		return (Criteria) this;
		}
  public Criteria andCheckRemarkEqualTo(String value) {
		  addCriterion("check_remark =", value, "checkRemark");
		return (Criteria) this;
		}
   public Criteria andCheckRemarkNotEqualTo(String value) {
		  addCriterion("check_remark <>", value, "checkRemark");
		return (Criteria) this;
		}
    public Criteria andCheckRemarkGreaterThan(String value) {
		 addCriterion("check_remark >", value, "checkRemark");
		return (Criteria) this;
		}
  public Criteria andCheckRemarkGreaterThanOrEqualTo(String value) {
		  addCriterion("check_remark >=", value, "CheckRemark");
		return (Criteria) this;
		}
   public Criteria andCheckRemarkLessThan(String value) {
		  addCriterion("check_remark <", value, "checkRemark");
		return (Criteria) this;
		}
    public Criteria andCheckRemarkLessThanOrEqualTo(String value) {
		  addCriterion("check_remark <=", value, "checkRemark");
		return (Criteria) this;
		}
    public Criteria andCheckRemarkIn(List<String> values) {
		  addCriterion("check_remark in", values, "checkRemark");
		return (Criteria) this;
		}
    public Criteria andCheckRemarkNotIn(List<String> values) {
		  addCriterion("check_remark not in", values, "checkRemark");
		return (Criteria) this;
		}
     public Criteria andCheckRemarkBetween(String value1, String value2) {
		   addCriterion("check_remark between", value1, value2, "checkRemark");
		return (Criteria) this;
		}
     public Criteria andCheckRemarkNotBetween(String value1, String value2) {
		   addCriterion("check_remark not between", value1, value2, "checkRemark");
		return (Criteria) this;
		}
    public Criteria andCheckRemarkLike(String value) {
		  addCriterion("check_remark like", value, "checkRemark");
		return (Criteria) this;
		}
    public Criteria andCheckRemarkNotLike(String value) {
		  addCriterion("check_remark not like", value, "checkRemark");
		return (Criteria) this;
		}
 public Criteria andSubjectNameIsNull() {
		 addCriterion("subject_name is null");
		return (Criteria) this;
		}
  public Criteria andSubjectNameIsNotNull(){
		addCriterion("subject_name is not null");
		return (Criteria) this;
		}
  public Criteria andSubjectNameEqualTo(String value) {
		  addCriterion("subject_name =", value, "subjectName");
		return (Criteria) this;
		}
   public Criteria andSubjectNameNotEqualTo(String value) {
		  addCriterion("subject_name <>", value, "subjectName");
		return (Criteria) this;
		}
    public Criteria andSubjectNameGreaterThan(String value) {
		 addCriterion("subject_name >", value, "subjectName");
		return (Criteria) this;
		}
  public Criteria andSubjectNameGreaterThanOrEqualTo(String value) {
		  addCriterion("subject_name >=", value, "SubjectName");
		return (Criteria) this;
		}
   public Criteria andSubjectNameLessThan(String value) {
		  addCriterion("subject_name <", value, "subjectName");
		return (Criteria) this;
		}
    public Criteria andSubjectNameLessThanOrEqualTo(String value) {
		  addCriterion("subject_name <=", value, "subjectName");
		return (Criteria) this;
		}
    public Criteria andSubjectNameIn(List<String> values) {
		  addCriterion("subject_name in", values, "subjectName");
		return (Criteria) this;
		}
    public Criteria andSubjectNameNotIn(List<String> values) {
		  addCriterion("subject_name not in", values, "subjectName");
		return (Criteria) this;
		}
     public Criteria andSubjectNameBetween(String value1, String value2) {
		   addCriterion("subject_name between", value1, value2, "subjectName");
		return (Criteria) this;
		}
     public Criteria andSubjectNameNotBetween(String value1, String value2) {
		   addCriterion("subject_name not between", value1, value2, "subjectName");
		return (Criteria) this;
		}
    public Criteria andSubjectNameLike(String value) {
		  addCriterion("subject_name like", value, "subjectName");
		return (Criteria) this;
		}
    public Criteria andSubjectNameNotLike(String value) {
		  addCriterion("subject_name not like", value, "subjectName");
		return (Criteria) this;
		}
 public Criteria andSemesterNameIsNull() {
		 addCriterion("semester_name is null");
		return (Criteria) this;
		}
  public Criteria andSemesterNameIsNotNull(){
		addCriterion("semester_name is not null");
		return (Criteria) this;
		}
  public Criteria andSemesterNameEqualTo(String value) {
		  addCriterion("semester_name =", value, "semesterName");
		return (Criteria) this;
		}
   public Criteria andSemesterNameNotEqualTo(String value) {
		  addCriterion("semester_name <>", value, "semesterName");
		return (Criteria) this;
		}
    public Criteria andSemesterNameGreaterThan(String value) {
		 addCriterion("semester_name >", value, "semesterName");
		return (Criteria) this;
		}
  public Criteria andSemesterNameGreaterThanOrEqualTo(String value) {
		  addCriterion("semester_name >=", value, "SemesterName");
		return (Criteria) this;
		}
   public Criteria andSemesterNameLessThan(String value) {
		  addCriterion("semester_name <", value, "semesterName");
		return (Criteria) this;
		}
    public Criteria andSemesterNameLessThanOrEqualTo(String value) {
		  addCriterion("semester_name <=", value, "semesterName");
		return (Criteria) this;
		}
    public Criteria andSemesterNameIn(List<String> values) {
		  addCriterion("semester_name in", values, "semesterName");
		return (Criteria) this;
		}
    public Criteria andSemesterNameNotIn(List<String> values) {
		  addCriterion("semester_name not in", values, "semesterName");
		return (Criteria) this;
		}
     public Criteria andSemesterNameBetween(String value1, String value2) {
		   addCriterion("semester_name between", value1, value2, "semesterName");
		return (Criteria) this;
		}
     public Criteria andSemesterNameNotBetween(String value1, String value2) {
		   addCriterion("semester_name not between", value1, value2, "semesterName");
		return (Criteria) this;
		}
    public Criteria andSemesterNameLike(String value) {
		  addCriterion("semester_name like", value, "semesterName");
		return (Criteria) this;
		}
    public Criteria andSemesterNameNotLike(String value) {
		  addCriterion("semester_name not like", value, "semesterName");
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
