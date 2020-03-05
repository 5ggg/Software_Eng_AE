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
@RequestMapping("/admin/class_director")
public class AClassDirectorController {
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
    @Autowired
    ClassDirectorService classDirectorService;
    @Autowired
    AdminInfoMapper adminInfoMapper;
    @Autowired
    ClassDirectorMapper classDirectorMapper;
    @Autowired
    ClassInfoMapper classInfoMapper;

    public void getList(ModelMap modelMap, LoginModel login) { //get the data list and then return to front side.

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
     * Return class Director list jsp page
    */
    @RequestMapping(value = "")
    public String index(ModelMap modelMap, HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName); //Get current login account information
        AdminInfo adminInfo = adminInfoMapper.selectByPrimaryKey(login.getId());
        modelMap.addAttribute("user", adminInfo);
        getList(modelMap, login); //Get the list of data and return to the front side

        return "admin/class_director/list";
    }

    /**
     * Paginate the class director data according to the query conditions, 
     * and then return to the foreground for rendering
    */
    @RequestMapping(value = "queryList")
    @ResponseBody
    public Object toList(ClassDirector model, Integer page,
        HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName);

        return classDirectorService.getDataList(model, page,
            CommonVal.pageSize, login); //Querying data by pagination
    }

    /**
     enter the add page.
    */
    @RequestMapping("add")
    public String add(ModelMap modelMap, ClassDirector model,
        HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName); //Get current login account from session	
        getList(modelMap, login); //Get the list of data needed by the front side and return it
        modelMap.addAttribute("data", model);

        return "admin/class_director/add_page";
    }

    /**
    Added submission information interface
    */
    @RequestMapping("add_submit")
    @ResponseBody
    public Object add_submit(ClassDirector model, ModelMap modelMap,
        HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName);
        Map<String, Object> rs = new HashMap<String, Object>();
        String msg = classDirectorService.add(model, login); //Perform add operation

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
     Enter the update/modification page
    */
    @RequestMapping("update")
    public String update(ModelMap modelMap, ClassDirector model,
        HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName); //Get current login account from session
        getList(modelMap, login); //Get the list of data needed by the foreground and return it to the foreground

        ClassDirector data = classDirectorMapper.selectByPrimaryKey(model.getId());
        modelMap.addAttribute("data", data);

        return "admin/class_director/update_page";
    }

    /**
     Modify submission information interface
    */
    @RequestMapping("update_submit")
    @ResponseBody
    public Object update_submit(ClassDirector model, ModelMap modelMap,
        HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName);
        Map<String, Object> rs = new HashMap<String, Object>();
        String msg = classDirectorService.update(model, login); //Perform update

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
        classDirectorService.delete(id);
        rs.put("code", 1);
        rs.put("msg",
            "Delete success");

        return rs;
    }
}

