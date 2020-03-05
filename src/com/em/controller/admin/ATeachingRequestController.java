package com.em.controller.admin;

import com.em.controller.LoginModel;

import com.em.dao.*;

import com.em.model.*;

import com.em.service.*;
import com.em.service.impl.*;

import com.em.util.*;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/admin/teaching_request")
public class ATeachingRequestController {
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
    @Autowired
    TeachingRequestService teachingRequestService;
    @Autowired
    AdminInfoMapper adminInfoMapper;
    @Autowired
    TeachingRequestMapper teachingRequestMapper;
    @Autowired
    SemesterInfoMapper semesterInfoMapper;
    @Autowired
    SubjectInfoMapper subjectInfoMapper;

    public void getList(ModelMap modelMap, LoginModel login) { //Get the list of data and return to front

        SubjectInfoExample subjectInfoE = new SubjectInfoExample();
        SubjectInfoExample.Criteria subjectInfoC = subjectInfoE.createCriteria();
        List<SubjectInfo> subjectInfoList = subjectInfoMapper.selectByExample(subjectInfoE);
        List<Map<String, Object>> subjectInfoList2 = new ArrayList<Map<String, Object>>();

        for (SubjectInfo m : subjectInfoList) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("id", m.getId());
            map.put("name", m.getName());
            subjectInfoList2.add(map);
        }

        modelMap.addAttribute("subjectInfoList", subjectInfoList2);

        SemesterInfoExample semesterInfoE = new SemesterInfoExample();
        SemesterInfoExample.Criteria semesterInfoC = semesterInfoE.createCriteria();
        List<SemesterInfo> semesterInfoList = semesterInfoMapper.selectByExample(semesterInfoE);
        List<Map<String, Object>> semesterInfoList2 = new ArrayList<Map<String, Object>>();

        for (SemesterInfo m : semesterInfoList) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("id", m.getId());
            map.put("name", m.getName());
            semesterInfoList2.add(map);
        }

        modelMap.addAttribute("semesterInfoList", semesterInfoList2);
    }

    /**
     * Return list of teaching request jsp page
    */
    @RequestMapping(value = "")
    public String index(ModelMap modelMap, HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName); //Get current login account information
        AdminInfo adminInfo = adminInfoMapper.selectByPrimaryKey(login.getId());
        modelMap.addAttribute("user", adminInfo);
        getList(modelMap, login); //Get the list of data and return to the foreground

        return "admin/teaching_request/list";
    }

    /**
     * Paginate the query request data according to the query conditions, 
     * and then return to the front for rendering
    */
    @RequestMapping(value = "queryList")
    @ResponseBody
    public Object toList(TeachingRequest model, Integer page,
        HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName);
        model.setCheckStatus(2); //Audit status equals approval

        return teachingRequestService.getDataList(model, page,
            CommonVal.pageSize, login); //Querying data by pagination
    }
}

