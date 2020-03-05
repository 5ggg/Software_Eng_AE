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
public class PptDirectorServiceImpl implements PptDirectorService {
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
    @Autowired
    PptDirectorMapper pptDirectorMapper;

    /**
      Add
    */
    @Override
    public String add(PptDirector model, LoginModel login) {
        model.setCreateTime(sdf1.format(new Date())); //Current time format
        pptDirectorMapper.insertSelective(model); //Insert the data

        return "";
    }

    /**
      update
    */
    @Override
    public String update(PptDirector model, LoginModel login) {
        PptDirector preModel = pptDirectorMapper.selectByPrimaryKey(model.getId());
        preModel.setName(model.getName());
        preModel.setPassWord(model.getPassWord());
        pptDirectorMapper.updateByPrimaryKey(preModel); //update the data

        return "";
    }

    /**
    *Query PTT director list data according to parameters
    */
    @Override
    public Map<String, Object> getDataList(PptDirector queryModel,
        Integer page, Integer pageSize, LoginModel login) {
        PptDirectorExample se = new PptDirectorExample();
        PptDirectorExample.Criteria sc = se.createCriteria();
        se.setOrderByClause("id desc"); //Sort by ID in reverse order by default

        int count = (int) pptDirectorMapper.countByExample(se);
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

        List<PptDirector> list = pptDirectorMapper.selectByExample(se); //Execute query
        Map<String, Object> rs = new HashMap<String, Object>();
        List<Map<String, Object>> list2 = new ArrayList<Map<String, Object>>();

        for (PptDirector model : list) {
            list2.add(getPptDirectorModel(model, login));
        }

        rs.put("list", list2); //Data list
        rs.put("count", count); //Data count
        rs.put("totalPage", totalPage); //The total page

        return rs;
    }

    /**
      Encapsulate the data form that PTT Director displays for the front
    */
    @Override
    public Map<String, Object> getPptDirectorModel(PptDirector model,
        LoginModel login) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("pptDirector", model);

        return map;
    }

    /**
    * Delete the data
    */
    @Override
    public void delete(Integer id) {
        pptDirectorMapper.deleteByPrimaryKey(id);
    }
}

