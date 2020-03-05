package com.em.service.impl;

import com.em.controller.LoginModel;

import com.em.dao.*;

import com.em.model.*;

import com.em.service.*;

import com.em.util.*;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.ui.ModelMap;

import java.io.IOException;
import java.io.InputStream;

import java.text.SimpleDateFormat;

import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Service
public class TeachingRequirementServiceImpl
    implements TeachingRequirementService {
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
    @Autowired
    TeachingRequirementMapper teachingRequirementMapper;
    @Autowired
    SemesterInfoMapper semesterInfoMapper;
    @Autowired
    SubjectInfoMapper subjectInfoMapper;
    @Autowired
    ClassDirectorMapper classDirectorMapper;
    @Autowired
    ClassInfoMapper classInfoMapper;

    /**
      Add
    */
    @Override
    public String add(TeachingRequirement model, LoginModel login) {
        model.setManageId(login.getId()); //Login ID
        model.setCreateTime(sdf1.format(new Date())); //Current time format

        SemesterInfo semesterInfo = semesterInfoMapper.selectByPrimaryKey(model.getSemesterId()); //Query semester for filling in other fields below
        SubjectInfo subjectInfo = subjectInfoMapper.selectByPrimaryKey(model.getSubjectId()); //Query subject for filling in other fields below
        ClassDirector classDirector = classDirectorMapper.selectByPrimaryKey(model.getManageId()); //Query class director for filling in other fields below

        if (semesterInfo != null) {
            model.setSemesterName(semesterInfo.getName());
        }

        if (subjectInfo != null) {
            model.setSubjectName(subjectInfo.getName());
        }

        if (classDirector != null) {
            model.setClassId(classDirector.getClassId());
        }

        teachingRequirementMapper.insertSelective(model); //insert the data

        return "";
    }

    /**
      Update
    */
    @Override
    public String update(TeachingRequirement model, LoginModel login) {
        TeachingRequirement preModel = teachingRequirementMapper.selectByPrimaryKey(model.getId());
        preModel.setSemesterId(model.getSemesterId());
        preModel.setSubjectId(model.getSubjectId());
        preModel.setRequiredRemark(model.getRequiredRemark());

        SemesterInfo semesterInfo = semesterInfoMapper.selectByPrimaryKey(model.getSemesterId()); //Check semester for the following fields
        SubjectInfo subjectInfo = subjectInfoMapper.selectByPrimaryKey(model.getSubjectId()); //Query subject for filling in other fields below
        ClassDirector classDirector = classDirectorMapper.selectByPrimaryKey(model.getManageId()); //Query class director for filling in other fields below
        model.setSemesterName(semesterInfo.getName());
        model.setSubjectName(subjectInfo.getName());
        model.setClassId(classDirector.getClassId());
        teachingRequirementMapper.updateByPrimaryKey(preModel); //update the data

        return "";
    }

    /**
    *Query teaching requirement list data according to parameters
    */
    @Override
    public Map<String, Object> getDataList(TeachingRequirement queryModel,
        Integer page, Integer pageSize, LoginModel login) {
        TeachingRequirementExample se = new TeachingRequirementExample();
        TeachingRequirementExample.Criteria sc = se.createCriteria();
        se.setOrderByClause("id desc"); //Sort by ID in reverse order by default

        if ((queryModel.getSubjectName() != null) &&
                (queryModel.getSubjectName().equals("") == false)) {
            sc.andSubjectNameLike("%" + queryModel.getSubjectName() + "%"); //Fuzzy query
        }

        if (queryModel.getManageId() != null) {
            sc.andManageIdEqualTo(queryModel.getManageId());
        }

        int count = (int) teachingRequirementMapper.countByExample(se);
        int totalPage = 0;

        if ((page != null) && (pageSize != null)) { //Pagination

            if ((count > 0) && ((count % pageSize) == 0)) {
                totalPage = count / pageSize;
            } else {
                totalPage = (count / pageSize) + 1;
            }

            se.setPageRows(pageSize);
            se.setStartRow((page - 1) * pageSize);
        }

        List<TeachingRequirement> list = teachingRequirementMapper.selectByExample(se); //Execute query
        Map<String, Object> rs = new HashMap<String, Object>();
        List<Map<String, Object>> list2 = new ArrayList<Map<String, Object>>();

        for (TeachingRequirement model : list) {
            list2.add(getTeachingRequirementModel(model, login));
        }

        rs.put("list", list2); //Data list
        rs.put("count", count); //Data count
        rs.put("totalPage", totalPage); //Total page

        return rs;
    }

    /**
      Encapsulate teaching requirement as a form of data displayed in the foreground
    */
    @Override
    public Map<String, Object> getTeachingRequirementModel(
        TeachingRequirement model, LoginModel login) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("teachingRequirement", model);

        if (model.getSemesterId() != null) {
            SemesterInfo semesterInfo = semesterInfoMapper.selectByPrimaryKey(model.getSemesterId());
            // The semester id is an external field, 
            // which needs to be associated with the semester to explain the field

            if (semesterInfo != null) {
                map.put("semesterIdStr", semesterInfo.getName());
            }
        }

        if (model.getSubjectId() != null) {
            SubjectInfo subjectInfo = subjectInfoMapper.selectByPrimaryKey(model.getSubjectId());
            // The subject id is an external field, 
            // which needs to be associated with the subject to explain the field

            if (subjectInfo != null) {
                map.put("subjectIdStr", subjectInfo.getName());
            }
        }

        if (model.getManageId() != null) {
            ClassDirector classDirector = classDirectorMapper.selectByPrimaryKey(model.getManageId());
            // The Class director id is an external field, 
            // which needs to be associated with the class director to explain the field

            if (classDirector != null) {
                map.put("manageIdStr", classDirector.getName());
            }
        }

        if (model.getClassId() != null) {
            ClassInfo classInfo = classInfoMapper.selectByPrimaryKey(model.getClassId());
            // The class id is an external field, 
            // which needs to be associated with the class ID to explain the field

            if (classInfo != null) {
                map.put("classIdStr", classInfo.getName());
            }
        }

        return map;
    }

    /**
    * Delete data
    */
    @Override
    public void delete(Integer id) {
        teachingRequirementMapper.deleteByPrimaryKey(id);
    }
}

