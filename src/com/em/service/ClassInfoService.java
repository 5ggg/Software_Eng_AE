package com.em.service;

import com.em.controller.LoginModel;

import com.em.model.*;

import java.io.InputStream;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public interface ClassInfoService {
    /**
      Pagination query class data list
    */
    public Map<String, Object> getDataList(ClassInfo queryModel, Integer page,
        Integer pageSize, LoginModel login);

    /**
      Encapsulate the data form that the class displays for the front desk
    */
    public Map<String, Object> getClassInfoModel(ClassInfo model,
        LoginModel login);

    /**
     * Delete (the data)
     * @param id
     */
    public void delete(Integer id);

   /**
    * Add
    * 
    * @param model
    * @param login
    * @return
    */
    public String add(ClassInfo model, LoginModel login);

   /**
    * Update
    * 
    * @param model
    * @param login
    * @return
    */
    public String update(ClassInfo model, LoginModel login);
}

