package com.em.controller.teacher;

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
@RequestMapping("/teacher/teaching_request")
public class TTeachingRequestController {
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
    @Autowired
    TeachingRequestService teachingRequestService;
    @Autowired
    TeacherMapper teacherMapper;
    @Autowired
    TeachingRequestMapper teachingRequestMapper;
    @Autowired
    SemesterInfoMapper semesterInfoMapper;
    @Autowired
    SubjectInfoMapper subjectInfoMapper;

    public void getList(ModelMap modelMap, LoginModel login) { //Get the list of data and return

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
     * Return the list of Teaching request jsp page.
    */
    @RequestMapping(value = "")
    public String index(ModelMap modelMap, HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName); //Get current login account information
        Teacher teacher = teacherMapper.selectByPrimaryKey(login.getId());
        modelMap.addAttribute("user", teacher);
        getList(modelMap, login); //Get the list of data and return to front

        return "teacher/teaching_request/list";
    }

    /**
     * Paginate the query request data according to the query conditions, 
     * and then return to front for rendering
    */
    @RequestMapping(value = "queryList")
    @ResponseBody
    public Object toList(TeachingRequest model, Integer page,
        HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName);
        model.setTeaherId(login.getId()); //Teaching request equals to current login id

        return teachingRequestService.getDataList(model, page,
            CommonVal.pageSize, login); //Querying data by pagination
    }

    /**
     Enter the add page.
    */
    @RequestMapping("add")
    public String add(ModelMap modelMap, TeachingRequest model,
        HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName); //Get current login account from session	
        getList(modelMap, login); //Get the list of data needed by front and return it
        modelMap.addAttribute("data", model);

        return "teacher/teaching_request/add_page";
    }

    /**
     Added submission information interface
    */
    @RequestMapping("add_submit")
    @ResponseBody
    public Object add_submit(TeachingRequest model, ModelMap modelMap,
        HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName);
        Map<String, Object> rs = new HashMap<String, Object>();
        String msg = teachingRequestService.add(model, login); //Perform add operation

        if (msg.equals("")) {
            rs.put("code", 1);
            rs.put("msg",
                "Add success");

            return rs;
        }

        rs.put("code", 0);
        rs.put("msg", msg);

        return rs;
    }

    /**
     Enter the update page
    */
    @RequestMapping("update")
    public String update(ModelMap modelMap, TeachingRequest model,
        HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName); //Get current login account from session
        getList(modelMap, login); //Get the list of data needed by the front and return it

        TeachingRequest data = teachingRequestMapper.selectByPrimaryKey(model.getId());
        modelMap.addAttribute("data", data);

        return "teacher/teaching_request/update_page";
    }

    /**
     Update submission information interface
    */
    @RequestMapping("update_submit")
    @ResponseBody
    public Object update_submit(TeachingRequest model, ModelMap modelMap,
        HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName);
        Map<String, Object> rs = new HashMap<String, Object>();
        String msg = teachingRequestService.update(model, login); //Perform modification

        if (msg.equals("")) {
            rs.put("code", 1);
            rs.put("msg",
                "Update success");

            return rs;
        }

        rs.put("code", 0);
        rs.put("msg", msg);

        return rs;
    }

    /**
     Delete the data interface
    */
    @RequestMapping("del")
    @ResponseBody
    public Object del(Integer id, ModelMap modelMap, HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName);
        Map<String, Object> rs = new HashMap<String, Object>();
        teachingRequestService.delete(id);
        rs.put("code", 1);
        rs.put("msg",
            "Delete");

        return rs;
    }
}

