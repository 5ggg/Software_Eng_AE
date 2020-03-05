package com.em.service;

import com.em.controller.LoginModel;

import com.em.model.*;

import java.io.InputStream;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public interface PptDirectorService {
    /**
      Paging query PTT director data list
    */
    public Map<String, Object> getDataList(PptDirector queryModel,
        Integer page, Integer pageSize, LoginModel login);

    /**
      Encapsulate the data form presented by the PTT director for the front
    */
    public Map<String, Object> getPptDirectorModel(PptDirector model,
        LoginModel login);

    /**
     * Delete
     * 
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
    public String add(PptDirector model, LoginModel login);

    /**
     * Update
     * 
     * @param model
     * @param login
     * @return
     */
    public String update(PptDirector model, LoginModel login);
}

