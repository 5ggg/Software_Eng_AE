package com.em.service;

import com.em.controller.LoginModel;

import com.em.model.*;

import java.io.InputStream;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public interface TeacherService {
    /**
      Pagination query teacher data list
    */
    public Map<String, Object> getDataList(Teacher queryModel, Integer page,
        Integer pageSize, LoginModel login);

    /**
      Encapsulate the data form displayed by the teacher for the front
    */
    public Map<String, Object> getTeacherModel(Teacher model, LoginModel login);

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
    public String add(Teacher model, LoginModel login);

    /**
     * Update
     * 
     * @param model
     * @param login
     * @return
     */
    public String update(Teacher model, LoginModel login);
}

