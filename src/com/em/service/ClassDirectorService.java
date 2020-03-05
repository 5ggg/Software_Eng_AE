package com.em.service;

import com.em.controller.LoginModel;

import com.em.model.*;

import java.io.InputStream;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public interface ClassDirectorService {
    /**
      Pagination query class supervisor data list
    */
    public Map<String, Object> getDataList(ClassDirector queryModel,
        Integer page, Integer pageSize, LoginModel login);

    /**
      Encapsulate the data format presented by the class supervisor for the front desk
    */
    public Map<String, Object> getClassDirectorModel(ClassDirector model,
        LoginModel login);

    /**
     * Delele
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
    public String add(ClassDirector model, LoginModel login);

    /**
     * Update
     * @param model
     * @param login
     * @return
     */
    public String update(ClassDirector model, LoginModel login);
}

