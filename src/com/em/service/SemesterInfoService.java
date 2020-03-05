package com.em.service;

import com.em.controller.LoginModel;

import com.em.model.*;

import java.io.InputStream;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public interface SemesterInfoService {
    /**
      Pagination query semester data list
    */
    public Map<String, Object> getDataList(SemesterInfo queryModel,
        Integer page, Integer pageSize, LoginModel login);

    /**
      Encapsulate semester data format for front display
    */
    public Map<String, Object> getSemesterInfoModel(SemesterInfo model,
        LoginModel login);

    /**
     * Delete the data
     * 
     * @param id
     */
    public void delete(Integer id);

    /**
     * ADD
     * 
     * @param model
     * @param login
     * @return
     */
    public String add(SemesterInfo model, LoginModel login);

    /**
     * Update
     * 
     * @param model
     * @param login
     * @return
     */
    public String update(SemesterInfo model, LoginModel login);
}

