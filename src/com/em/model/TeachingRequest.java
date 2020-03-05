package com.em.model;

public class TeachingRequest {
    private Integer id;
    private String createTime;
    private Integer subjectId;
    private Integer semesterId;
    private Integer teaherId;
    private String teachDesc;
    private Integer checkStatus;
    private String checkRemark;
    private String subjectName;
    private String semesterName;

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

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public Integer getSemesterId() {
        return semesterId;
    }

    public void setSemesterId(Integer semesterId) {
        this.semesterId = semesterId;
    }

    public Integer getTeaherId() {
        return teaherId;
    }

    public void setTeaherId(Integer teaherId) {
        this.teaherId = teaherId;
    }

    public String getTeachDesc() {
        return teachDesc;
    }

    public void setTeachDesc(String teachDesc) {
        this.teachDesc = (teachDesc == null) ? null : teachDesc.trim();
    }

    public Integer getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(Integer checkStatus) {
        this.checkStatus = checkStatus;
    }

    public String getCheckRemark() {
        return checkRemark;
    }

    public void setCheckRemark(String checkRemark) {
        this.checkRemark = (checkRemark == null) ? null : checkRemark.trim();
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = (subjectName == null) ? null : subjectName.trim();
    }

    public String getSemesterName() {
        return semesterName;
    }

    public void setSemesterName(String semesterName) {
        this.semesterName = (semesterName == null) ? null : semesterName.trim();
    }
}

