package com.em.controller;

import com.em.dao.*;


import com.em.model.*;

import com.em.util.*;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * This class defines the process of changing the password
 * @author 5gggLeon
 *
 */

@Controller
@RequestMapping("/commonapi/alterPassword")
public class AlterPasswordController {
    @Autowired
    AdminInfoMapper adminInfoMapper;
    @Autowired
    TeacherMapper teacherMapper;
    @Autowired
    PptDirectorMapper pptDirectorMapper;
    @Autowired
    ClassDirectorMapper classDirectorMapper;

    /**
            Enter the interface for changing the password page
    */
    @RequestMapping("")
    public Object alterPassword(ModelMap modelMap, HttpServletRequest request,
        HttpServletResponse response) {
        LoginModel user = (LoginModel) request.getSession()
                                              .getAttribute(CommonVal.sessionName);

        if (user == null) {
            return "redirect:/commonapi/login";
        }

        return "alter_password";
    }

    /**
            Submit a password change request interface
    */
    @RequestMapping("submit")
    @ResponseBody
    public Object submit(ModelMap modelMap, String password1, String password2,
        String password3, HttpServletRequest request,
        HttpServletResponse response) {
        Map<String, Object> rs = new HashMap<String, Object>();
        LoginModel user = (LoginModel) request.getSession()
                                              .getAttribute(CommonVal.sessionName);

        if ((password1 == null) || (password2 == null) || (password3 == null)) {
            rs.put("rs", 0);
            rs.put("msg",
                "Error");

            return rs;
        }

        if (password2.equals(password3) == false) {
            rs.put("rs", 0);
            rs.put("msg",
                "Password input is not consistent twice");

            return rs;
        }

        if (user.getLoginType() == 1) {
            AdminInfo l = adminInfoMapper.selectByPrimaryKey(user.getId());

            if (l.getPassWord().equals(password1) == false) { //Check the account's original password
                rs.put("code", 0);
                rs.put("msg",
                    "Old password entered incorrectly");

                return rs;
            }

            l.setPassWord(password2); //Set as new password
            adminInfoMapper.updateByPrimaryKeySelective(l);
        }

        if (user.getLoginType() == 2) {
            Teacher l = teacherMapper.selectByPrimaryKey(user.getId());

            if (l.getPassWord().equals(password1) == false) { //Check the account's original password
                rs.put("code", 0);
                rs.put("msg",
                    "Old password entered incorrectly");

                return rs;
            }

            l.setPassWord(password2); //Set as new password
            teacherMapper.updateByPrimaryKeySelective(l);
        }

        if (user.getLoginType() == 3) {
            PptDirector l = pptDirectorMapper.selectByPrimaryKey(user.getId());

            if (l.getPassWord().equals(password1) == false) { //Check the account's original password
                rs.put("code", 0);
                rs.put("msg",
                    "Old password entered incorrectly");

                return rs;
            }

            l.setPassWord(password2); //Set as new password
            pptDirectorMapper.updateByPrimaryKeySelective(l);
        }

        if (user.getLoginType() == 4) {
            ClassDirector l = classDirectorMapper.selectByPrimaryKey(user.getId());

            if (l.getPassWord().equals(password1) == false) { //Check the account's original password
                rs.put("code", 0);
                rs.put("msg",
                    "Old password entered incorrectly");

                return rs;
            }

            l.setPassWord(password2); //Set as new password
            classDirectorMapper.updateByPrimaryKeySelective(l);
        }

        rs.put("rs", 1);
        rs.put("msg",
            "The password is changed successfully and will take effect at the next login");

        return rs;
    }
}

