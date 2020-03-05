package com.em.controller;

import com.em.controller.LoginModel;

import com.em.dao.*;

import com.em.model.*;

import com.em.util.*;
import com.em.util.CommonVal;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;

import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * The class perform login account verification
 * @author 5gggLeon
 *
 */
@Controller
@RequestMapping("/commonapi")
public class LoginController {
	// Date format
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
    @Autowired
    ClassDirectorMapper classDirectorMapper;
    @Autowired
    AdminInfoMapper adminInfoMapper;
    @Autowired
    TeacherMapper teacherMapper;
    @Autowired
    PptDirectorMapper pptDirectorMapper;

    /**
      The system enters the login page interface
    */
    @RequestMapping(value = "sys_login")
    public String sys_login(ModelMap modelMap, String msg) {
        modelMap.addAttribute("msg", msg);

        return "sys_login";
    }

    /**
      System exit interface
    */
    @RequestMapping(value = "sys_logout")
    public String sys_logout(ModelMap modelMap, String msg,
        HttpServletRequest request) {
        request.getSession().removeAttribute(CommonVal.sessionName);

        return "redirect:/commonapi/sys_login";
    }

    /**
      System submits login authentication information interface
    */
    @RequestMapping("sysSubmit")
    @ResponseBody
    public Object sysSubmit(LoginModel user, String imgCode, ModelMap modelMap,
        HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        Map<String, Object> rs = new HashMap<String, Object>();

        // Image verification code verification, 
        // query the verification code from the session and verify
        if ((imgCode != null) &&
                !imgCode.toLowerCase()
                            .equals(request.getSession()
                                               .getAttribute(CommonVal.code)
                                               .toString().toLowerCase())) {
            rs.put("code", 0);
            rs.put("msg",
                "Picture verification code error");

            return rs;
        }

        if (user.getLoginType() == null) {
            rs.put("code", 0);
            rs.put("msg",
                "Please select a login role");// from Admin/Class_DIrector/PTT_Director/Teacher/

            return rs;
        }

        if ((user.getName() == null) || user.getName().equals("")) {
            rs.put("code", 0);
            rs.put("msg",
                "Please enter your login name");

            return rs;
        }

        if ((user.getPassword() == null) || user.getPassword().equals("")) {
            rs.put("code", 0);
            rs.put("msg",
                "Please enter the password");

            return rs;
        }

        if (user.getLoginType() == 1) {
            AdminInfoExample te = new AdminInfoExample(); //Verify administrator account password
            AdminInfoExample.Criteria tc = te.createCriteria();
            tc.andNameEqualTo(user.getName());
            tc.andPassWordEqualTo(user.getPassword());

            List<AdminInfo> tl = adminInfoMapper.selectByExample(te);

            if (tl.size() == 0) { //No account can be queried from the database
                rs.put("code", 0);
                rs.put("msg",
                    "Login name or password is incorrect");

                return rs;
            } else {
                LoginModel login = new LoginModel();
                login.setId(tl.get(0).getId());
                login.setLoginType(1);
                login.setName(user.getName());
                request.getSession().setAttribute(CommonVal.sessionName, login); //Set login session, keep session
                rs.put("code", 1);
                rs.put("msg",
                    "login successful");

                return rs;
            }
        }

        if (user.getLoginType() == 2) {
            TeacherExample te = new TeacherExample(); //Verify teacher account password
            TeacherExample.Criteria tc = te.createCriteria();
            tc.andNameEqualTo(user.getName());
            tc.andPassWordEqualTo(user.getPassword());

            List<Teacher> tl = teacherMapper.selectByExample(te);

            if (tl.size() == 0) { //No account can be queried from the database
                rs.put("code", 0);
                rs.put("msg",
                    "Login name or password is incorrect");

                return rs;
            } else {
                LoginModel login = new LoginModel();
                login.setId(tl.get(0).getId());
                login.setLoginType(2);
                login.setName(user.getName());
                request.getSession().setAttribute(CommonVal.sessionName, login); //Set login session, keep session
                rs.put("code", 1);
                rs.put("msg",
                    "login successful");

                return rs;
            }
        }

        if (user.getLoginType() == 3) {
            PptDirectorExample te = new PptDirectorExample(); //Verify PTT Director Account Password
            PptDirectorExample.Criteria tc = te.createCriteria();
            tc.andNameEqualTo(user.getName());
            tc.andPassWordEqualTo(user.getPassword());

            List<PptDirector> tl = pptDirectorMapper.selectByExample(te);

            if (tl.size() == 0) { //No account can be queried from the database
                rs.put("code", 0);
                rs.put("msg",
                    "Login name or password is incorrect");

                return rs;
            } else {
                LoginModel login = new LoginModel();
                login.setId(tl.get(0).getId());
                login.setLoginType(3);
                login.setName(user.getName());
                request.getSession().setAttribute(CommonVal.sessionName, login); //Set login session, keep session
                rs.put("code", 1);
                rs.put("msg",
                    "login successful");

                return rs;
            }
        }

        if (user.getLoginType() == 4) {
            ClassDirectorExample te = new ClassDirectorExample(); //Verify Class_Director account password
            ClassDirectorExample.Criteria tc = te.createCriteria();
            tc.andNameEqualTo(user.getName());
            tc.andPassWordEqualTo(user.getPassword());

            List<ClassDirector> tl = classDirectorMapper.selectByExample(te);

            if (tl.size() == 0) { //No account can be queried from the database
                rs.put("code", 0);
                rs.put("msg",
                    "Login name or password is incorrect");

                return rs;
            } else {
                LoginModel login = new LoginModel();
                login.setId(tl.get(0).getId());
                login.setLoginType(4);
                login.setName(user.getName());
                request.getSession().setAttribute(CommonVal.sessionName, login); //Set login session, keep session
                rs.put("code", 1);
                rs.put("msg",
                    "login successful");

                return rs;
            }
        }

        rs.put("code", 0);
        rs.put("msg",
            "System Error");

        return rs;
    }
}

