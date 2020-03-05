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
public class AdminInfoServiceImpl implements AdminInfoService {
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
    @Autowired
    AdminInfoMapper adminInfoMapper;

    /**
    *Query administrator list data based on parameters
    */
    @Override
    public Map<String, Object> getDataList(AdminInfo queryModel, Integer page,
        Integer pageSize, LoginModel login) {
        AdminInfoExample se = new AdminInfoExample();
        AdminInfoExample.Criteria sc = se.createCriteria();
        se.setOrderByClause("id desc"); //Sort by ID in reverse order by default

        int count = (int) adminInfoMapper.countByExample(se);
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

        List<AdminInfo> list = adminInfoMapper.selectByExample(se); //Execute query statement
        Map<String, Object> rs = new HashMap<String, Object>();
        List<Map<String, Object>> list2 = new ArrayList<Map<String, Object>>();

        for (AdminInfo model : list) {
            list2.add(getAdminInfoModel(model, login));
        }

        rs.put("list", list2); //Data list
        rs.put("count", count); //Data number/count
        rs.put("totalPage", totalPage); //total page

        return rs;
    }

    /**
      Encapsulate the data form displayed by the administrator for the front end
    */
    @Override
    public Map<String, Object> getAdminInfoModel(AdminInfo model,
        LoginModel login) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("adminInfo", model);

        return map;
    }
}

