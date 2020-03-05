package com.em.controller;

import com.em.util.CommonVal;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * The filter, verify all requests that need to be verified, 
 * determine whether there is a login, if not logged in, 
 * force to jump to the login page, if already logged in, 
 * determine whether an illegal request is being made
 * 
 * @author 5gggLeon
 *
 */
public class LoginInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request,
        HttpServletResponse response, Object handler) throws Exception {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName);
        String requestUri = request.getRequestURI();
        String contextPath = request.getContextPath();
        String contextPath2 = requestUri.trim().replaceAll("/", "");

        if (contextPath2.equals("employ_sys") ||
                ((contextPath2.contains("admin") == false) &&
                (contextPath2.contains("teacher") == false) &&
                (contextPath2.contains("ppt") == false) &&
                (contextPath2.contains("class_direct") == false))) {
            return true;
        }

        if (login == null) {
            System.out.println(
                "Not logged in, transferred to the login page");

            if (requestUri.contains("/admin/")) {
                response.sendRedirect(contextPath + "/commonapi/sys_login"); //Force jump to login page

                return false;
            }

            if (requestUri.contains("/teacher/")) {
                response.sendRedirect(contextPath + "/commonapi/sys_login"); //Force jump to login page

                return false;
            }

            if (requestUri.contains("/ppt/")) {
                response.sendRedirect(contextPath + "/commonapi/sys_login"); //Force jump to login page

                return false;
            }

            if (requestUri.contains("/class_direct/")) {
                response.sendRedirect(contextPath + "/commonapi/sys_login"); //Force jump to login page

                return false;
            }

            response.sendRedirect(contextPath + "/");

            return false;
        } else {
            if (login.getLoginType() == 1) {
                if ((requestUri.contains("admin") == false) &&
                        (requestUri.contains("commonapi") == false)) { 
                	
//                	The current login role is administrator, 
//                	but requests the interface used by other roles, 
//                	which needs to intercept and prompt errors
                	
                    response.sendRedirect(contextPath +
                        "/commonapi/error?msg=-2");

                    return true;
                }
            }

            if (login.getLoginType() == 2) {
                if ((requestUri.contains("teacher") == false) &&
                        (requestUri.contains("commonapi") == false)) { 
                	
//                	The current login role is Teacher, 
//                	but requests the interface used by other roles, 
//                	which needs to intercept and prompt errors
                	
                	
                    response.sendRedirect(contextPath +
                        "/commonapi/error?msg=-2");

                    return true;
                }
            }

            if (login.getLoginType() == 3) {
                if ((requestUri.contains("ppt") == false) &&
                        (requestUri.contains("commonapi") == false)) { //当前登录角色为PPT主任,但请求其他角色使用的接口,即盗链,这种需要拦截并提示错误
                    response.sendRedirect(contextPath +
                        "/commonapi/error?msg=-2");
                    
//                	The current login role is PTT_Director, 
//                	but requests the interface used by other roles, 
//                	which needs to intercept and prompt errors
                    

                    return true;
                }
            }

            if (login.getLoginType() == 4) {
                if ((requestUri.contains("class_direct") == false) &&
                        (requestUri.contains("commonapi") == false)) { 
                    response.sendRedirect(contextPath +
                        "/commonapi/error?msg=-2");
                    
//                	The current login role is Class_Director, 
//                	but requests the interface used by other roles, 
//                	which needs to intercept and prompt errors

                    return true;
                }
            }
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request,
        HttpServletResponse response, Object handler, ModelAndView modelAndView)
        throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request,
        HttpServletResponse response, Object handler, Exception ex)
        throws Exception {
    }
}

