package com.em.service;

import com.em.controller.LoginModel;

import com.em.model.*;

import java.io.InputStream;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public interface TeachingRequestService {
    /**
      Pagination query teaching request data list
    */
    public Map<String, Object> getDataList(TeachingRequest queryModel,
        Integer page, Integer pageSize, LoginModel login);

    /**
      Encapsulate the data format for teaching requests to be displayed in front
    */
    public Map<String, Object> getTeachingRequestModel(TeachingRequest model,
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
    public String add(TeachingRequest model, LoginModel login);

    /**
     * Update
     * 
     * @param model
     * @param login
     * @return
     */
    public String update(TeachingRequest model, LoginModel login);

    /**
     * Reamrk
     * 
     * @param model
     * @param login
     * @return
     */
    public String remark(TeachingRequest model, LoginModel login);
}

