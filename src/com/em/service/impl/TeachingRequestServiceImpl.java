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
public class TeachingRequestServiceImpl implements TeachingRequestService {
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
    @Autowired
    TeachingRequestMapper teachingRequestMapper;
    @Autowired
    SubjectInfoMapper subjectInfoMapper;
    @Autowired
    SemesterInfoMapper semesterInfoMapper;
    @Autowired
    TeacherMapper teacherMapper;

    /**
      ADD
    */
    @Override
    public String add(TeachingRequest model, LoginModel login) {
        model.setTeaherId(login.getId()); //Login ID
        model.setCheckStatus(1); //waiting for confirm (default)
        model.setCreateTime(sdf1.format(new Date())); //Current time format

        SubjectInfo subjectInfo = subjectInfoMapper.selectByPrimaryKey(model.getSubjectId()); //Query subject for filling in other fields below
        SemesterInfo semesterInfo = semesterInfoMapper.selectByPrimaryKey(model.getSemesterId()); //Check semester for the following fields

        if (subjectInfo != null) {
            model.setSubjectName(subjectInfo.getName());
        }

        if (semesterInfo != null) {
            model.setSemesterName(semesterInfo.getName());
        }

        teachingRequestMapper.insertSelective(model); //insert the data

        return "";
    }

    /**
      Update
    */
    @Override
    public String update(TeachingRequest model, LoginModel login) {
        TeachingRequest preModel = teachingRequestMapper.selectByPrimaryKey(model.getId());
        preModel.setSubjectId(model.getSubjectId());
        preModel.setSemesterId(model.getSemesterId());
        preModel.setTeachDesc(model.getTeachDesc());

        SubjectInfo subjectInfo = subjectInfoMapper.selectByPrimaryKey(model.getSubjectId()); //Query subject for filling in other fields below
        SemesterInfo semesterInfo = semesterInfoMapper.selectByPrimaryKey(model.getSemesterId()); //Check semester for the following fields
        model.setSubjectName(subjectInfo.getName());
        model.setSemesterName(semesterInfo.getName());
        teachingRequestMapper.updateByPrimaryKey(preModel); //Update the data

        return "";
    }

    /**
      Remark
    */
    @Override
    public String remark(TeachingRequest model, LoginModel login) {
        TeachingRequest preModel = teachingRequestMapper.selectByPrimaryKey(model.getId());
        preModel.setCheckRemark(model.getCheckRemark());
        teachingRequestMapper.updateByPrimaryKey(preModel); //update the data

        return "";
    }

    /**
    *Query teaching request list data according to parameters
    */
    @Override
    public Map<String, Object> getDataList(TeachingRequest queryModel,
        Integer page, Integer pageSize, LoginModel login) {
        TeachingRequestExample se = new TeachingRequestExample();
        TeachingRequestExample.Criteria sc = se.createCriteria();
        se.setOrderByClause("id desc"); //Sort by ID in reverse order by default

        if ((queryModel.getSubjectName() != null) &&
                (queryModel.getSubjectName().equals("") == false)) {
            sc.andSubjectNameLike("%" + queryModel.getSubjectName() + "%"); //Fuzzy query,avoid small mistakes when write subject
        }

        if ((queryModel.getSemesterName() != null) &&
                (queryModel.getSemesterName().equals("") == false)) {
            sc.andSemesterNameLike("%" + queryModel.getSemesterName() + "%"); //Fuzzy query
        }

        if (queryModel.getTeaherId() != null) {
            sc.andTeaherIdEqualTo(queryModel.getTeaherId());
        }

        if (queryModel.getCheckStatus() != null) {
            sc.andCheckStatusEqualTo(queryModel.getCheckStatus());
        }

        int count = (int) teachingRequestMapper.countByExample(se);
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

        List<TeachingRequest> list = teachingRequestMapper.selectByExample(se); //Execute query statement
        Map<String, Object> rs = new HashMap<String, Object>();
        List<Map<String, Object>> list2 = new ArrayList<Map<String, Object>>();

        for (TeachingRequest model : list) {
            list2.add(getTeachingRequestModel(model, login));
        }

        rs.put("list", list2); //Data list
        rs.put("count", count); //Data count
        rs.put("totalPage", totalPage); //Total page

        return rs;
    }

    /**
      Encapsulate the data format for teaching requests to be displayed in the foreground
    */
    @Override
    public Map<String, Object> getTeachingRequestModel(TeachingRequest model,
        LoginModel login) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("teachingRequest", model);

        if (model.getSubjectId() != null) {
            SubjectInfo subjectInfo = subjectInfoMapper.selectByPrimaryKey(model.getSubjectId());
            // The subject id is an external field, 
            // which needs to be associated with the subject to explain the field

            if (subjectInfo != null) {
                map.put("subjectIdStr", subjectInfo.getName());
            }
        }

        if (model.getSemesterId() != null) {
            SemesterInfo semesterInfo = semesterInfoMapper.selectByPrimaryKey(model.getSemesterId());
            // The semester id is an external field, 
            // which needs to be associated with the semester to explain the field

            if (semesterInfo != null) {
                map.put("semesterIdStr", semesterInfo.getName());
            }
        }

        if (model.getTeaherId() != null) {
            Teacher teacher = teacherMapper.selectByPrimaryKey(model.getTeaherId());
            // The Teacher id is an external field, 
            // which needs to be associated with the teacher to explain the field

            if (teacher != null) {
                map.put("teaherIdStr", teacher.getName());
            }
        }

        map.put("checkStatusStr",
            DataListUtils.getCheckStatusNameById(model.getCheckStatus() + "")); //Explain check status field

        return map;
    }

    /**
    * Delete the data 
    */
    @Override
    public void delete(Integer id) {
        teachingRequestMapper.deleteByPrimaryKey(id);
    }
}

