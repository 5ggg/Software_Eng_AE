package com.em.service;

import com.em.controller.LoginModel;

import com.em.model.*;

import java.io.InputStream;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public interface AdminInfoService {
    /**
      Pagination query administrator data list
    */
    public Map<String, Object> getDataList(AdminInfo queryModel, Integer page,
        Integer pageSize, LoginModel login);

    /**
      Encapsulate the data form displayed by the administrator for front
    */
    public Map<String, Object> getAdminInfoModel(AdminInfo model,
        LoginModel login);
}

