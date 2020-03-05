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
public class MatchInfoServiceImpl implements MatchInfoService {
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
    @Autowired
    MatchInfoMapper matchInfoMapper;
    @Autowired
    TeachingRequirementMapper teachingRequirementMapper;
    @Autowired
    TeachingRequestMapper teachingRequestMapper;
    @Autowired
    TeacherMapper teacherMapper;
    @Autowired
    ClassInfoMapper classInfoMapper;
    @Autowired
    ClassDirectorMapper classDirectorMapper;
    @Autowired
    SemesterInfoMapper semesterInfoMapper;

    /**
      "MATCH" here
    */
    @Override
    public String add(MatchInfo model, LoginModel login) {
        model.setCreateTime(sdf1.format(new Date())); //Current time format

        TeachingRequest teachingRequest = teachingRequestMapper.selectByPrimaryKey(model.getRequestId()); //Query teaching request for the following fields
        TeachingRequirement teachingRequirement = teachingRequirementMapper.selectByPrimaryKey(model.getRequireId()); //Query teaching requirements for the following fields

        if (teachingRequest != null) {
            model.setTeacherId(teachingRequest.getTeaherId());
        }

        if (teachingRequirement != null) {
            model.setClassId(teachingRequirement.getClassId());
        }

        if (teachingRequirement != null) {
            model.setManageId(teachingRequirement.getManageId());
        }

        if (teachingRequirement != null) {
            model.setSemesterId(teachingRequirement.getSemesterId());
        }

        matchInfoMapper.insertSelective(model); //Insert the data 

        return "";
    }

    /**
    *Query requirements based on parameters-request match list data
    */
    @Override
    public Map<String, Object> getDataList(MatchInfo queryModel, Integer page,
        Integer pageSize, LoginModel login) {
        MatchInfoExample se = new MatchInfoExample();
        MatchInfoExample.Criteria sc = se.createCriteria();
        se.setOrderByClause("id desc"); //Sort by ID in reverse order by default

        if (queryModel.getClassId() != null) {
            sc.andClassIdEqualTo(queryModel.getClassId()); //Query the teaching class is equal to the specified value
        }

        if (queryModel.getSemesterId() != null) {
            sc.andSemesterIdEqualTo(queryModel.getSemesterId()); //Query the semester is equal to specified value
        }

        if (queryModel.getTeacherId() != null) {
            sc.andTeacherIdEqualTo(queryModel.getTeacherId());
        }

        if (queryModel.getManageId() != null) {
            sc.andManageIdEqualTo(queryModel.getManageId());
        }

        int count = (int) matchInfoMapper.countByExample(se);
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

        List<MatchInfo> list = matchInfoMapper.selectByExample(se); //Execute query
        Map<String, Object> rs = new HashMap<String, Object>();
        List<Map<String, Object>> list2 = new ArrayList<Map<String, Object>>();

        for (MatchInfo model : list) {
            list2.add(getMatchInfoModel(model, login));
        }

        rs.put("list", list2); //Data list / Datasheets
        rs.put("count", count); //Data count
        rs.put("totalPage", totalPage); //overall page

        return rs;
    }

    /**
      Encapsulation requirements-request matches the data form displayed in the front
    */
    @Override
    public Map<String, Object> getMatchInfoModel(MatchInfo model,
        LoginModel login) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("matchInfo", model);

        if (model.getRequireId() != null) {
            TeachingRequirement teachingRequirement = teachingRequirementMapper.selectByPrimaryKey(model.getRequireId()); 
            //The requirement is an external field, 
            //which needs to be related to teaching requirement to explain the field
            

            if (teachingRequirement != null) {
                map.put("requireIdStr",
                    teachingRequirement.getSemesterName() + "+" +
                    teachingRequirement.getSubjectName());
            }
        }

        if (model.getRequestId() != null) {
            TeachingRequest teachingRequest = teachingRequestMapper.selectByPrimaryKey(model.getRequestId()); 
          //The request is an external field, 
          //which needs to be related to teaching request to explain the field

            if (teachingRequest != null) {
                map.put("requestIdStr",
                    teachingRequest.getSubjectName() + "+" +
                    teachingRequest.getSemesterName());
            }
        }

        if (model.getTeacherId() != null) {
            Teacher teacher = teacherMapper.selectByPrimaryKey(model.getTeacherId()); 
            // The Teacher is an external field 
            // it need to be associated with the teacher to explain the field


            if (teacher != null) {
                map.put("teacherIdStr", teacher.getName());
            }
        }

        if (model.getClassId() != null) {
            ClassInfo classInfo = classInfoMapper.selectByPrimaryKey(model.getClassId()); 
            // The teaching class is an external field, 
            // the class needs to be associated to explain the field

            if (classInfo != null) {
                map.put("classIdStr", classInfo.getName());
            }
        }

        if (model.getManageId() != null) {
            ClassDirector classDirector = classDirectorMapper.selectByPrimaryKey(model.getManageId()); 
            // The Class Director is an external field, 
            // the C_D needs to be associated to explain the field

            if (classDirector != null) {
                map.put("manageIdStr", classDirector.getName());
            }
        }

        if (model.getSemesterId() != null) {
            SemesterInfo semesterInfo = semesterInfoMapper.selectByPrimaryKey(model.getSemesterId()); 
            // The Semester is an external field, 
            // the Semester needs to be associated to explain the field

            if (semesterInfo != null) {
                map.put("semesterIdStr", semesterInfo.getName());
            }
        }

        return map;
    }

    /**
    * Delete the data 
    */
    @Override
    public void delete(Integer id) {
        matchInfoMapper.deleteByPrimaryKey(id);
    }
}

