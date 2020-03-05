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
@RequestMapping("/admin/match_info")
public class AMatchInfoController {
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
    @Autowired
    MatchInfoService matchInfoService;
    @Autowired
    AdminInfoMapper adminInfoMapper;
    @Autowired
    TeacherMapper teacherMapper;
    @Autowired
    ClassDirectorMapper classDirectorMapper;
    @Autowired
    TeachingRequestMapper teachingRequestMapper;
    @Autowired
    SemesterInfoMapper semesterInfoMapper;
    @Autowired
    ClassInfoMapper classInfoMapper;
    @Autowired
    TeachingRequirementMapper teachingRequirementMapper;
    @Autowired
    MatchInfoMapper matchInfoMapper;

    public void getList(ModelMap modelMap, LoginModel login) { //Get the list of data and return to front

        TeachingRequirementExample teachingRequirementE = new TeachingRequirementExample();
        TeachingRequirementExample.Criteria teachingRequirementC = teachingRequirementE.createCriteria();
        List<TeachingRequirement> teachingRequirementList = teachingRequirementMapper.selectByExample(teachingRequirementE);
        List<Map<String, Object>> teachingRequirementList2 = new ArrayList<Map<String, Object>>();

        for (TeachingRequirement m : teachingRequirementList) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("id", m.getId());
            map.put("name", m.getSemesterName() + "+" + m.getSubjectName());
            teachingRequirementList2.add(map);
        }

        modelMap.addAttribute("teachingRequirementList",
            teachingRequirementList2);

        TeachingRequestExample teachingRequestE = new TeachingRequestExample();
        TeachingRequestExample.Criteria teachingRequestC = teachingRequestE.createCriteria();
        teachingRequestC.andCheckStatusEqualTo(2); //The audit status is equal to the current approval

        List<TeachingRequest> teachingRequestList = teachingRequestMapper.selectByExample(teachingRequestE);
        List<Map<String, Object>> teachingRequestList2 = new ArrayList<Map<String, Object>>();

        for (TeachingRequest m : teachingRequestList) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("id", m.getId());
            map.put("name", m.getSubjectName() + "+" + m.getSemesterName());
            teachingRequestList2.add(map);
        }

        modelMap.addAttribute("teachingRequestList", teachingRequestList2);

        TeacherExample teacherE = new TeacherExample();
        TeacherExample.Criteria teacherC = teacherE.createCriteria();
        List<Teacher> teacherList = teacherMapper.selectByExample(teacherE);
        List<Map<String, Object>> teacherList2 = new ArrayList<Map<String, Object>>();

        for (Teacher m : teacherList) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("id", m.getId());
            map.put("name", m.getName());
            teacherList2.add(map);
        }

        modelMap.addAttribute("teacherList", teacherList2);

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

        ClassDirectorExample classDirectorE = new ClassDirectorExample();
        ClassDirectorExample.Criteria classDirectorC = classDirectorE.createCriteria();
        List<ClassDirector> classDirectorList = classDirectorMapper.selectByExample(classDirectorE);
        List<Map<String, Object>> classDirectorList2 = new ArrayList<Map<String, Object>>();

        for (ClassDirector m : classDirectorList) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("id", m.getId());
            map.put("name", m.getName());
            classDirectorList2.add(map);
        }

        modelMap.addAttribute("classDirectorList", classDirectorList2);

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
     * Return requirements-request matching list jsp page
    */
    @RequestMapping(value = "")
    public String index(ModelMap modelMap, HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName); //Get current login account information
        AdminInfo adminInfo = adminInfoMapper.selectByPrimaryKey(login.getId());
        modelMap.addAttribute("user", adminInfo);
        getList(modelMap, login); //Get the list of data and return to the front

        return "admin/match_info/list";
    }

    /**
     * Paginate query requirements based on query conditions-request matching data, 
     * and then return to the foreground for rendering
    */
    @RequestMapping(value = "queryList")
    @ResponseBody
    public Object toList(MatchInfo model, Integer page,
        HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName);

        return matchInfoService.getDataList(model, page, CommonVal.pageSize,
            login); //Querying data by pagination
    }

    /**
     enter the match page.
    */
    @RequestMapping("add")
    public String add(ModelMap modelMap, MatchInfo model,
        HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName); //Get current login account from session	
        getList(modelMap, login); //Get the list of data needed by the front and return it to front
        modelMap.addAttribute("data", model);

        return "admin/match_info/add_page";
    }

    /**
     Match submission information interface
    */
    @RequestMapping("add_submit")
    @ResponseBody
    public Object add_submit(MatchInfo model, ModelMap modelMap,
        HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName);
        Map<String, Object> rs = new HashMap<String, Object>();
        String msg = matchInfoService.add(model, login); //Perform add operation

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
    Delete data interface
    */
    @RequestMapping("del")
    @ResponseBody
    public Object del(Integer id, ModelMap modelMap, HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName);
        Map<String, Object> rs = new HashMap<String, Object>();
        matchInfoService.delete(id);
        rs.put("code", 1);
        rs.put("msg",
            "Delete success");

        return rs;
    }
}

