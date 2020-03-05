package com.em.service;

import com.em.controller.LoginModel;

import com.em.model.*;

import java.io.InputStream;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public interface TeachingRequirementService {
    /**
      Paging query data list of teaching requirement
    */
    public Map<String, Object> getDataList(TeachingRequirement queryModel,
        Integer page, Integer pageSize, LoginModel login);

    /**
      Encapsulate teaching requirement as a form of data displayed in front
    */
    public Map<String, Object> getTeachingRequirementModel(
        TeachingRequirement model, LoginModel login);

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
    public String add(TeachingRequirement model, LoginModel login);

    /**
     * Update
     * 
     * @param model
     * @param login
     * @return
     */
    public String update(TeachingRequirement model, LoginModel login);
}

