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
public class ClassDirectorServiceImpl implements ClassDirectorService {
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
    @Autowired
    ClassDirectorMapper classDirectorMapper;
    @Autowired
    ClassInfoMapper classInfoMapper;

    /**
      ADD
    */
    @Override
    public String add(ClassDirector model, LoginModel login) {
        model.setCreateTime(sdf1.format(new Date())); //Current time format
        classDirectorMapper.insertSelective(model); //Insert the data

        return "";
    }

    /**
      Update
    */
    @Override
    public String update(ClassDirector model, LoginModel login) {
        ClassDirector preModel = classDirectorMapper.selectByPrimaryKey(model.getId());
        preModel.setName(model.getName());
        preModel.setPassWord(model.getPassWord());
        preModel.setClassId(model.getClassId());
        classDirectorMapper.updateByPrimaryKey(preModel); //Update the data here

        return "";
    }

    /**
    *Query class director list data based on parameters
    */
    @Override
    public Map<String, Object> getDataList(ClassDirector queryModel,
        Integer page, Integer pageSize, LoginModel login) {
        ClassDirectorExample se = new ClassDirectorExample();
        ClassDirectorExample.Criteria sc = se.createCriteria();
        se.setOrderByClause("id desc"); //Sort by ID in reverse order by default

        int count = (int) classDirectorMapper.countByExample(se);
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

        List<ClassDirector> list = classDirectorMapper.selectByExample(se); //Execute query
        Map<String, Object> rs = new HashMap<String, Object>();
        List<Map<String, Object>> list2 = new ArrayList<Map<String, Object>>();

        for (ClassDirector model : list) {
            list2.add(getClassDirectorModel(model, login));
        }

        rs.put("list", list2); //Data list
        rs.put("count", count); //Data count
        rs.put("totalPage", totalPage); //The total page number

        return rs;
    }

    /**
      Encapsulate the data format presented by the class supervisor for the front
    */
    @Override
    public Map<String, Object> getClassDirectorModel(ClassDirector model,
        LoginModel login) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("classDirector", model);

        if (model.getClassId() != null) {
            ClassInfo classInfo = classInfoMapper.selectByPrimaryKey(model.getClassId()); 
            // The class belongs to an external field, 
            // which needs to be associated with the class to explain the field
            

            if (classInfo != null) {
                map.put("classIdStr", classInfo.getName());
            }
        }

        return map;
    }

    /**
    * Delete the data
    */
    @Override
    public void delete(Integer id) {
        classDirectorMapper.deleteByPrimaryKey(id);
    }
}

