package com.em.controller.class_direct;

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
@RequestMapping("/class_direct/teaching_requirement")
public class CTeachingRequirementController {
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
    @Autowired
    TeachingRequirementService teachingRequirementService;
    @Autowired
    ClassDirectorMapper classDirectorMapper;
    @Autowired
    SemesterInfoMapper semesterInfoMapper;
    @Autowired
    SubjectInfoMapper subjectInfoMapper;
    @Autowired
    ClassInfoMapper classInfoMapper;
    @Autowired
    TeachingRequirementMapper teachingRequirementMapper;

    public void getList(ModelMap modelMap, LoginModel login) { //Get the list of data and return to front

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

        ClassInfoExample classInfoE = new ClassInfoExample();
        ClassInfoExample.Criteria classInfoC = classInfoE.createCriteria();
        List<ClassInfo> classInfoList = classInfoMapper.selectByExample(classInfoE);
        List<Map<String, Object>> classInfoList2 = new ArrayList<Map<String, Object>>();

        for (ClassInfo m : classInfoList) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("id", m.getId());
            map.put("name", m.getName());
            classInfoList2.add(map);
        }

        modelMap.addAttribute("classInfoList", classInfoList2);
    }

    /**
     * Return teaching requirements list jsp page
    */
    @RequestMapping(value = "")
    public String index(ModelMap modelMap, HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName); //Get current login account information
        ClassDirector classDirector = classDirectorMapper.selectByPrimaryKey(login.getId());
        modelMap.addAttribute("user", classDirector);
        getList(modelMap, login); //Get the list of data and return to front

        return "class_direct/teaching_requirement/list";
    }

    /**
     * Paginate the teaching demand data according to the query conditions, 
     * and then return to front for rendering
    */
    @RequestMapping(value = "queryList")
    @ResponseBody
    public Object toList(TeachingRequirement model, Integer page,
        HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName);
        model.setManageId(login.getId()); //Class Director equals current login id

        return teachingRequirementService.getDataList(model, page,
            CommonVal.pageSize, login); //Querying data by pagination
    }

    /**
     Enter add page
    */
    @RequestMapping("add")
    public String add(ModelMap modelMap, TeachingRequirement model,
        HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName); //Get current login account from session	
        getList(modelMap, login); //Get the list of data needed by the front side and return it
        modelMap.addAttribute("data", model);

        return "class_direct/teaching_requirement/add_page";
    }

    /**
     Added submission information interface
    */
    @RequestMapping("add_submit")
    @ResponseBody
    public Object add_submit(TeachingRequirement model, ModelMap modelMap,
        HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName);
        Map<String, Object> rs = new HashMap<String, Object>();
        String msg = teachingRequirementService.add(model, login); //Perform add operation

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
     Enter update page.
    */
    @RequestMapping("update")
    public String update(ModelMap modelMap, TeachingRequirement model,
        HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName); //Get current login account from session	
        getList(modelMap, login); //Get the list of data needed by the front and return it

        TeachingRequirement data = teachingRequirementMapper.selectByPrimaryKey(model.getId());
        modelMap.addAttribute("data", data);

        return "class_direct/teaching_requirement/update_page";
    }

    /**
     Update submission information interface
    */
    @RequestMapping("update_submit")
    @ResponseBody
    public Object update_submit(TeachingRequirement model, ModelMap modelMap,
        HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName);
        Map<String, Object> rs = new HashMap<String, Object>();
        String msg = teachingRequirementService.update(model, login); //Perform modification

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
     Delete data interface
    */
    @RequestMapping("del")
    @ResponseBody
    public Object del(Integer id, ModelMap modelMap, HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName);
        Map<String, Object> rs = new HashMap<String, Object>();
        teachingRequirementService.delete(id);
        rs.put("code", 1);
        rs.put("msg",
            "Delete success");

        return rs;
    }
}

