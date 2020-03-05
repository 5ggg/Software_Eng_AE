package com.em.model;

public class TeachingRequirement {
    private Integer id;
    private String createTime;
    private Integer semesterId;
    private Integer subjectId;
    private Integer manageId;
    private Integer classId;
    private String requiredRemark;
    private String semesterName;
    private String subjectName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = (createTime == null) ? null : createTime.trim();
    }

    public Integer getSemesterId() {
        return semesterId;
    }

    public void setSemesterId(Integer semesterId) {
        this.semesterId = semesterId;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public Integer getManageId() {
        return manageId;
    }

    public void setManageId(Integer manageId) {
        this.manageId = manageId;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public String getRequiredRemark() {
        return requiredRemark;
    }

    public void setRequiredRemark(String requiredRemark) {
        this.requiredRemark = (requiredRemark == null) ? null
                                                       : requiredRemark.trim();
    }

    public String getSemesterName() {
        return semesterName;
    }

    public void setSemesterName(String semesterName) {
        this.semesterName = (semesterName == null) ? null : semesterName.trim();
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = (subjectName == null) ? null : subjectName.trim();
    }
}

