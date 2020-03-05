package com.em.service;

import com.em.controller.LoginModel;

import com.em.model.*;

import java.io.InputStream;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public interface SubjectInfoService {
    /**
      Pagination query account data list
    */
    public Map<String, Object> getDataList(SubjectInfo queryModel,
        Integer page, Integer pageSize, LoginModel login);

    /**
      Encapsulated subjects are in the form of data displayed for front
    */
    public Map<String, Object> getSubjectInfoModel(SubjectInfo model,
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
    public String add(SubjectInfo model, LoginModel login);

    /**
     * Update
     * 
     * @param model
     * @param login
     * @return
     */
    public String update(SubjectInfo model, LoginModel login);
}

