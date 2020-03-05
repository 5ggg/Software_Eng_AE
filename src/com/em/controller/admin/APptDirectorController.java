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
@RequestMapping("/admin/ppt_director")
public class APptDirectorController {
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
    @Autowired
    PptDirectorService pptDirectorService;
    @Autowired
    AdminInfoMapper adminInfoMapper;
    @Autowired
    PptDirectorMapper pptDirectorMapper;

    /**
    * Return PTT Director List jsp page
    */
    @RequestMapping(value = "")
    public String index(ModelMap modelMap, HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName); //Get current login account information
        AdminInfo adminInfo = adminInfoMapper.selectByPrimaryKey(login.getId());
        modelMap.addAttribute("user", adminInfo);

        return "admin/ppt_director/list";
    }

    /**
     * Paginate the PTT director's data according to the query conditions, 
     * and then return to front for rendering
    */
    @RequestMapping(value = "queryList")
    @ResponseBody
    public Object toList(PptDirector model, Integer page,
        HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName);

        return pptDirectorService.getDataList(model, page, CommonVal.pageSize,
            login); //Querying data by pagination
    }

    /**
     Enter the add page
    */
    @RequestMapping("add")
    public String add(ModelMap modelMap, PptDirector model,
        HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName); //Get current login account from session
        modelMap.addAttribute("data", model);

        return "admin/ppt_director/add_page";
    }

    /**
     Added submission information interface
    */
    @RequestMapping("add_submit")
    @ResponseBody
    public Object add_submit(PptDirector model, ModelMap modelMap,
        HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName);
        Map<String, Object> rs = new HashMap<String, Object>();
        String msg = pptDirectorService.add(model, login); //Perform add operation

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
    public String update(ModelMap modelMap, PptDirector model,
        HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName); //Get current login account from session	
        PptDirector data = pptDirectorMapper.selectByPrimaryKey(model.getId());
        modelMap.addAttribute("data", data);

        return "admin/ppt_director/update_page";
    }

    /**
     Update submmition information interface.
    */
    @RequestMapping("update_submit")
    @ResponseBody
    public Object update_submit(PptDirector model, ModelMap modelMap,
        HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName);
        Map<String, Object> rs = new HashMap<String, Object>();
        String msg = pptDirectorService.update(model, login); //Perform modification

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
        pptDirectorService.delete(id);
        rs.put("code", 1);
        rs.put("msg",
            "DElete success");

        return rs;
    }
}

