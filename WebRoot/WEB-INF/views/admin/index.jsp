<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<!--[if lt IE 9]>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/hui/lib/html5shiv.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/hui/lib/respond.min.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/hui/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/hui/static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/hui/lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/hui/static/h-ui.admin/skin/green/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/hui/static/h-ui.admin/css/style.css" />
<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>兼职教学人员的雇用和培训系统</title>
<meta name="keywords" content="">
<meta name="description" content="">
</head>
<body>
<header class="navbar-wrapper">
	<div class="navbar navbar-fixed-top">
		<div class="container-fluid cl"> <a class="logo navbar-logo f-l mr-10 hidden-xs" href="#">兼职教学人员的雇用和培训系统</a>
			<span class="logo navbar-slogan f-l mr-10 hidden-xs"></span> 
			<a aria-hidden="false" class="nav-toggle Hui-iconfont visible-xs" href="javascript:;"></a>
			<nav class="nav navbar-nav">
		</nav>
		<nav id="Hui-userbar" class="nav navbar-nav navbar-userbar hidden-xs">
			<ul class="cl">
			
			
			
			 <li>${roleName}</li>
				
					
				<li class="dropDown dropDown_hover">
					<a href="#" class="dropDown_A">${login.name} <i class="Hui-iconfont"></i></a>
					<ul class="dropDown-menu menu radius box-shadow">
					
						<li><a href="${pageContext.request.contextPath}/commonapi/sys_logout">退出</a></li>
						<li><a href="javascript:void(0)" onclick="alterPassword()">修改密码</a></li>
				</ul>
			</li>
				 
				
				<li id="Hui-skin" class="dropDown right dropDown_hover"> <a href="javascript:;" class="dropDown_A" title="换肤"><i class="Hui-iconfont" style="font-size:18px"></i></a>
					<ul class="dropDown-menu menu radius box-shadow">
						<li><a href="javascript:;" data-val="default" title="默认（黑色）">默认（黑色）</a></li>
						<li><a href="javascript:;" data-val="blue" title="蓝色">蓝色</a></li>
						<li><a href="javascript:;" data-val="green" title="绿色">绿色</a></li>
						<li><a href="javascript:;" data-val="red" title="红色">红色</a></li>
						<li><a href="javascript:;" data-val="yellow" title="黄色">黄色</a></li>
						<li><a href="javascript:;" data-val="orange" title="橙色">橙色</a></li>
					</ul>
				</li>
			</ul>
		</nav>
	</div>
</div>
</header>
<aside class="Hui-aside">
	<div class="menu_dropdown bk_2">
		
		<dl id="menu-product">
 	<dt class="selected">
  <i class="Hui-iconfont"></i>
 人员管理 
  <i class="Hui-iconfont menu_dropdown-arrow"></i>
 	</dt>
<dd style="display: block;"> 
 <ul>
 
 <li>
  
  <a   href="javascript:void(0)" data-href="${pageContext.request.contextPath}/admin/teacher" data-title="老师账号管理" title="老师账号管理"> 
老师账号管理 
</a>
  
</li> 

 <li>
  
  <a   href="javascript:void(0)" data-href="${pageContext.request.contextPath}/admin/ppt_director" data-title="PPT主任账号管理" title="PPT主任账号管理"> 
PPT主任账号管理 
</a>
  
</li> 

 <li>
  
  <a   href="javascript:void(0)" data-href="${pageContext.request.contextPath}/admin/class_director" data-title="班级主管账号管理" title="班级主管账号管理"> 
班级主管账号管理 
</a>
  
</li> 

</ul>
</dd>
  </dl><dl id="menu-product">
 	<dt class="selected">
  <i class="Hui-iconfont"></i>
 教学请求查询 
  <i class="Hui-iconfont menu_dropdown-arrow"></i>
 	</dt>
<dd style="display: block;"> 
 <ul>
 
 <li>
  
  <a   href="javascript:void(0)" data-href="${pageContext.request.contextPath}/admin/teaching_request" data-title="教学请求查询" title="教学请求查询"> 
教学请求查询 
</a>
  
</li> 

</ul>
</dd>
  </dl><dl id="menu-product">
 	<dt class="selected">
  <i class="Hui-iconfont"></i>
 教学需求查询 
  <i class="Hui-iconfont menu_dropdown-arrow"></i>
 	</dt>
<dd style="display: block;"> 
 <ul>
 
 <li>
  
  <a   href="javascript:void(0)" data-href="${pageContext.request.contextPath}/admin/teaching_requirement" data-title="教学需求查询" title="教学需求查询"> 
教学需求查询 
</a>
  
</li> 

</ul>
</dd>
  </dl><dl id="menu-product">
 	<dt class="selected">
  <i class="Hui-iconfont"></i>
 教学匹配 
  <i class="Hui-iconfont menu_dropdown-arrow"></i>
 	</dt>
<dd style="display: block;"> 
 <ul>
 
 <li>
  
  <a   href="javascript:void(0)" data-href="${pageContext.request.contextPath}/admin/match_info" data-title="教学匹配" title="教学匹配"> 
教学匹配 
</a>
  
</li> 

</ul>
</dd>
  </dl>
	
	</div>


</aside>
<div class="dislpayArrow hidden-xs"><a class="pngfix" href="javascript:void(0);" onClick="displaynavbar(this)"></a></div>
<section class="Hui-article-box">
	<div id="Hui-tabNav" class="Hui-tabNav hidden-xs">
		<div class="Hui-tabNav-wp">
			<ul id="min_title_list" class="acrossTab cl">
				<li class="active">
					<span title="老师账号管理" data-href="${pageContext.request.contextPath}/admin/teacher">老师账号管理</span>
					<em></em></li>
		</ul>
	</div>
		<div class="Hui-tabNav-more btn-group"><a id="js-tabNav-prev" class="btn radius btn-default size-S" href="javascript:;"><i class="Hui-iconfont"></i></a><a id="js-tabNav-next" class="btn radius btn-default size-S" href="javascript:;"><i class="Hui-iconfont"></i></a></div>
</div>
	<div id="iframe_box" class="Hui-article">
		<div class="show_iframe">
			<div style="display:none" class="loading"></div>
			<iframe scrolling="yes" id="iframeDom" frameborder="0" src="${pageContext.request.contextPath}/admin/teacher"></iframe>
	</div>
</div>
</section>

<div class="contextMenu" id="Huiadminmenu">
	<ul>
		<li id="closethis">关闭当前 </li>
		<li id="closeall">关闭全部 </li>
</ul>
</div>

<script type="text/javascript" src="${pageContext.request.contextPath}/static/common/jquery-1.11.1.min.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/static/hui/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/hui/static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/hui/static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->
<script type="text/javascript" src="${pageContext.request.contextPath}/static/hui/lib/jquery.contextmenu/jquery.contextmenu.r2.js"></script>


<script type="text/javascript">
$(function(){


	$("body").Huitab({
		tabBar:".navbar-wrapper .navbar-levelone",
		tabCon:".Hui-aside .menu_dropdown",
		className:"current",
		index:0,
	});
	
	
});


function gotoPage(e){
 var url = $(e).attr("data-url");
 var  urlName = $(e).attr('url-name');
  creatIframe(url,urlName);

}

function alterPassword(){
	 creatIframe("${pageContext.request.contextPath}/commonapi/alterPassword","修改密码");
	
}

</script>

</body>
</html>