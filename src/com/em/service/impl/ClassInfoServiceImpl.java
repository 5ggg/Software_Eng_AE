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
public class ClassInfoServiceImpl implements ClassInfoService {
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
    @Autowired
    ClassInfoMapper classInfoMapper;

    /**
      ADD
    */
    @Override
    public String add(ClassInfo model, LoginModel login) {
        model.setCreateTime(sdf1.format(new Date())); //Current time format
        classInfoMapper.insertSelective(model); //Insert data

        return "";
    }

    /**
      UPDATE
    */
    @Override
    public String update(ClassInfo model, LoginModel login) {
        ClassInfo preModel = classInfoMapper.selectByPrimaryKey(model.getId());
        preModel.setName(model.getName());
        classInfoMapper.updateByPrimaryKey(preModel); //update the data

        return "";
    }

    /**
    *Query class list data based on parameters
    */
    @Override
    public Map<String, Object> getDataList(ClassInfo queryModel, Integer page,
        Integer pageSize, LoginModel login) {
        ClassInfoExample se = new ClassInfoExample();
        ClassInfoExample.Criteria sc = se.createCriteria();
        se.setOrderByClause("id desc"); //Sort by ID in reverse order by default

        int count = (int) classInfoMapper.countByExample(se);
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

        List<ClassInfo> list = classInfoMapper.selectByExample(se); //Execute query
        Map<String, Object> rs = new HashMap<String, Object>();
        List<Map<String, Object>> list2 = new ArrayList<Map<String, Object>>();

        for (ClassInfo model : list) {
            list2.add(getClassInfoModel(model, login));
        }

        rs.put("list", list2); //Data list
        rs.put("count", count); //Data count
        rs.put("totalPage", totalPage); //The total page

        return rs;
    }

    /**
      Encapsulate the data form that the class displays for the front
    */
    @Override
    public Map<String, Object> getClassInfoModel(ClassInfo model,
        LoginModel login) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("classInfo", model);

        return map;
    }

    /**
    * Delete the data
    */
    @Override
    public void delete(Integer id) {
        classInfoMapper.deleteByPrimaryKey(id);
    }
}

