package com.em.service;

import com.em.controller.LoginModel;

import com.em.model.*;

import java.io.InputStream;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public interface MatchInfoService {
    /**
      Pagination query requirements-request matching data list
    */
    public Map<String, Object> getDataList(MatchInfo queryModel, Integer page,
        Integer pageSize, LoginModel login);

    /**
      Encapsulation requirements-request matches the data form displayed in front
    */
    public Map<String, Object> getMatchInfoModel(MatchInfo model,
        LoginModel login);

   /**
    * Delete the date
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
    public String add(MatchInfo model, LoginModel login);
}

