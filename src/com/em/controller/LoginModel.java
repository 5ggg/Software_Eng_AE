package com.em.controller;

/**
 * This class represent the Login Model that we need during the login process.
 * @author 5gggLeon
 *
 */
public class LoginModel {
    private Integer id;//Login ID
    private String name;//Login Name
    private String password;//Login password
    private Integer loginType;//Login Account Type/Role
    public Integer getLoginType() {
        return loginType;
    }
    public void setLoginType(Integer loginType) {
        this.loginType = loginType;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
