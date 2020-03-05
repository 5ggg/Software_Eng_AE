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
public class SubjectInfoServiceImpl implements SubjectInfoService {
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
    @Autowired
    SubjectInfoMapper subjectInfoMapper;

    /**
      ADD
    */
    @Override
    public String add(SubjectInfo model, LoginModel login) {
        model.setCreateTime(sdf1.format(new Date())); //Current time format
        subjectInfoMapper.insertSelective(model); //Insert data

        return "";
    }

    /**
      Update
    */
    @Override
    public String update(SubjectInfo model, LoginModel login) {
        SubjectInfo preModel = subjectInfoMapper.selectByPrimaryKey(model.getId());
        preModel.setName(model.getName());
        subjectInfoMapper.updateByPrimaryKey(preModel); //update data

        return "";
    }

    /**
    *Query subject list data based on parameters
    */
    @Override
    public Map<String, Object> getDataList(SubjectInfo queryModel,
        Integer page, Integer pageSize, LoginModel login) {
        SubjectInfoExample se = new SubjectInfoExample();
        SubjectInfoExample.Criteria sc = se.createCriteria();
        se.setOrderByClause("id desc"); //Sort by ID in reverse order by default

        if ((queryModel.getName() != null) &&
                (queryModel.getName().equals("") == false)) {
            sc.andNameLike("%" + queryModel.getName() + "%"); 
            //Fuzzy query, because sometimes people's input about the subject may be different
        }

        int count = (int) subjectInfoMapper.countByExample(se);
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

        List<SubjectInfo> list = subjectInfoMapper.selectByExample(se); //Execute query statement
        Map<String, Object> rs = new HashMap<String, Object>();
        List<Map<String, Object>> list2 = new ArrayList<Map<String, Object>>();

        for (SubjectInfo model : list) {
            list2.add(getSubjectInfoModel(model, login));
        }

        rs.put("list", list2); //Data list
        rs.put("count", count); //Data count
        rs.put("totalPage", totalPage); //The total page

        return rs;
    }

    /**
      Encapsulate the data form that the semester displays for the front
    */
    @Override
    public Map<String, Object> getSubjectInfoModel(SubjectInfo model,
        LoginModel login) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("subjectInfo", model);

        return map;
    }

    /**
    * Delete
    */
    @Override
    public void delete(Integer id) {
        subjectInfoMapper.deleteByPrimaryKey(id);
    }
}

