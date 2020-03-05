<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5shiv.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<![endif]-->
<link href="${pageContext.request.contextPath}/static/hui/static/h-ui/css/H-ui.min.css" rel="stylesheet" type="text/css" />
    <link href="${pageContext.request.contextPath}/static/hui/static/h-ui.admin/css/H-ui.login.css" rel="stylesheet" type="text/css" />
        <link href="${pageContext.request.contextPath}/static/hui/static/h-ui.admin/css/style.css" rel="stylesheet" type="text/css" />
            <link href="${pageContext.request.contextPath}/static/hui/lib/Hui-iconfont/1.0.8/iconfont.css" rel="stylesheet" type="text/css" />
                
                
                <style>
                .loginBox1{
                    width:750px;
                    background:url(${pageContext.request.contextPath}/static/hui/static/h-ui.admin/images/admin-loginform-bg.png) no-repeat;
                        margin-left:20%;
                        margin-top:100px;
                    }
                    
                    .codeBtn{
                        position:relative;
                        color:blue;
                        top:7px;
                        left:80%;
                        z-index:99;
                    }
                    </style>
                    <!--[if IE 6]>
                    <script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
                    <script>DD_belatedPNG.fix('*');</script>
                    <![endif]-->
                    <title>Software_Engineering AE </title>
                    <meta name="keywords" content="H-ui.admin v3.1,H-uiWebsite background template">
                    <meta name="description" content="H-ui.admin v3.1">
                    </head>
                    <body>
                    <input type="hidden" id="TenantId" name="TenantId" value="" />
                    <div class="header"><h1 style="color:white;margin-left:50px;margin-top:-10px;">Software_Engineering AE_PTT Employment and training System</h1></div>
                    <div class="loginWraper" style="height:100%;">
                    <div class="loginBox1" style="background-size:100% 100%; padding:70px">
                    <div class="form form-horizontal">
                    <br><br>
                    <div class="row cl">
                    <label class="form-label col-xs-8"><p style="color:red">${msg}</p></label>
                        </div>
                        <div class="row cl">
                        <label class="form-label col-xs-3">Login Name</label>
                        <div class="formControls col-xs-8">
                        <input id="name" name="name" type="text" placeholder="Please enter your login name"  class="input-text size-L ">
                        </div>
                        </div>
                        
                        
                        
                        <div class="row cl">
                        <label class="form-label col-xs-3">Password</label>
                        <div class="formControls col-xs-8">
                        <input id="password" name="password" type="password" placeholder="Please enter the password"  class="input-text size-L ">
                        </div>
                        </div>
                        
                        <div class="row cl">
                        <label class="form-label col-xs-3">Picture verification code</label>
                        <div class="formControls col-xs-8">
                        <input class="input-text size-L" type="text" id="imgCode" name="imgCode" placeholder="Verification code" onblur="if(this.value==''){this.value='验证码:'}" onclick="if(this.value=='Verification code:'){this.value='';}" value="Verification code:" style="width:150px;">
                            <img id="codeImg1"  name="codeImg"  style="width:80px;height:40px;" alt="点击更换" title="点击更换" />  </div>
                            </div>
                            
                            <div class="row cl">
                            <label class="form-label col-xs-3">Login role</label>
                            <div class="formControls col-xs-8">
                            <input name="loginType" type="radio" value="1" id="loginType1" style="margin-left:10px;"/><label style="color:white" for="loginType1">Administrator </label>
                            <input name="loginType" type="radio" value="2" id="loginType2" style="margin-left:10px;"/><label style="color:white" for="loginType2">Teacher </label>
                            <input name="loginType" type="radio" value="3" id="loginType3" style="margin-left:10px;"/><label style="color:white" for="loginType3">PTT_Director </label>
                            <input name="loginType" type="radio" value="4" id="loginType4" style="margin-left:10px;"/><label style="color:white" for="loginType4">Class_Director </label>
                            
                            </div>
                            </div>
                            
                            
                            
                            <div class="row cl">
                            <div class="formControls col-xs-8 col-xs-offset-3">
                            <input name="" type="button"  onclick="submitForm()" id="submitBtn" class="btn btn-success radius size-L" value=" Login ">
                            
                            
                            
                            
                            </div>
                            </div>
                            </div>
                            </div>
                            <div class="footer">Copyright Software_Engineering AE_PTT Employment and training System</div>
                            </div>
                            <script type="text/javascript" src="${pageContext.request.contextPath}/static/common/jquery-1.11.1.min.js"></script>
                                <script type="text/javascript" src="${pageContext.request.contextPath}/static/hui/static/h-ui/js/H-ui.min.js"></script>
                                    <script type="text/javascript" src="${pageContext.request.contextPath}/static/common/utils/listutils.js?v=26573"></script>
                                        
                                        
                                        <script>
                                        
                                        $(document).ready(function(e) {
                                            changeCode();
                                            $("#codeImg1").bind("click",changeCode);
                                            
                                        });
                                        
                                        function genTimestamp(){
                                            var time = new Date();
                                            return time.getTime();
                                        }
                                        function changeCode(){
                                            $("img[name='codeImg']").attr("src","${pageContext.request.contextPath}/commonapi/code?t="+genTimestamp());
                                            }
                                            
                                            
                                            function submitForm(){
                                                
                                                $.ajax({
                                                    type: 'post',
                                                    url: '${pageContext.request.contextPath}/commonapi/sysSubmit',
                                                        data: {
                                                            'imgCode':$('#imgCode').val(),
                                                            'name':$("#name").val(),
                                                            'password':$("#password").val(),
                                                            'loginType':getCheckBoxVal('loginType')
                                                        },
                                                        success: function(result) {
                                                            
                                                            if(result.code==1){
                                                                var lt = getCheckBoxVal('loginType');
                                                                if(lt=='1'){
                                                                    window.location.href="${pageContext.request.contextPath}/admin/index";
                                                                    }
                                                                    if(lt=='2'){
                                                                        window.location.href="${pageContext.request.contextPath}/teacher/index";
                                                                        }
                                                                        if(lt=='3'){
                                                                            window.location.href="${pageContext.request.contextPath}/ppt/index";
                                                                            }
                                                                            if(lt=='4'){
                                                                                window.location.href="${pageContext.request.contextPath}/class_direct/index";
                                                                                }
                                                                                }else{
                                                                                    alert(result.msg);
                                                                                }
                                                                                
                                                                                
                                                                            }
                                                                        });
                                                                    }
                                                                    $(function(){
                                                                        
                                                                    })
                                                                    
                                                                    
                                                                    
                                                                    
                                                                    
                                                                    
                                                                    
                                                                    
                                                                    
                                                                    
                                                                    </script>
                                                                    </body>
                                                                    </html>
