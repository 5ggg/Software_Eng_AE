<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<c:set var="uri" value="${pageContext.request.contextPath}" />
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
                                <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/common/page/myPagination.css?t=4" />
                                    
                                    <style type="text/css">
                                    .btnStyle{
                                        margin-left:8px;
                                        margin-top:8px
                                    }
                                    .loadingModel {
                                        position: absolute;
                                        top: 0;
                                        left: 0;
                                        background-color: rgba(9, 9, 9, 0.63);
                                        width: 100%;
                                        height: 100%;
                                        z-index: 1000;
                                    }
                                    
                                    
                                    .loading-content {
                                        width: 50%;
                                        text-align: center;
                                        background: #ffffff;
                                        border-radius: 6px;
                                        line-height: 30px;
                                        z-index: 10001;
                                    }
                                    </style>
                                    <!--[if IE 6]>
                                    
                                    <script>DD_belatedPNG.fix('*');</script>
                                    <![endif]-->
                                    <title>教学请求</title>
                                    </head>
                                    <body>
                                    <div id="loadingDiv"></div>
                                    <div id="bodyModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                    <div class="modal-dialog">
                                    <div class="modal-content radius">
                                    <div class="modal-header">
                                    <h3 class="modal-title" id="bodyModalTile"></h3>
                                    <a class="close" data-dismiss="modal" aria-hidden="true" href="javascript:void();">×</a>
                                    </div>
                                    <div class="modal-body" id="bodyModalContent">
                                    </div>
                                    <div class="modal-footer">
                                    <button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
                                    </div>
                                    </div>
                                    </div>
                                    </div>
                                    <nav class="breadcrumb"><i class="Hui-iconfont"></i>教学请求<a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont"></i></a></nav>
                                    <div class="page-container">
                                    
                                    <div style="display:inline;margin-top:30px"><span style="width:200px;margin-left:50px;">科目名</span>
                                    <input type="text" class="input-text"  style="width:250px;display:inline"  placeholder="请输入科目名进行查询" id="subjectName">
                                    </div>
                                    
                                    <div style="display:inline;margin-top:30px"><span style="width:200px;margin-left:50px;">学期</span>
                                    <input type="text" class="input-text"  style="width:250px;display:inline"  placeholder="请输入学期进行查询" id="semesterName">
                                    </div>
                                    
                                    <button type="button" onclick="ajaxList(1);" style="margin-left:30px" class="btn btn-success" ><i class="Hui-iconfont"></i> 查询</button>
                                    
                                    
                                    <div class="cl pd-5 bg-1 bk-gray mt-20">
                                    <span class="l" id="globalBtns">
                                    
                                    
                                    </span>
                                    <span id="batchUpdateDiv">
                                    
                                    </span>
                                    </div>
                                    
                                    <table class="table table-border table-bordered table-hover table-bg table-sort" style="">
                                    <thead>
                                    <tr style="text-align:center">
                                    <th>科目名</th>
                                    <th>学期</th>
                                    <th>请求教师</th>
                                    <th>教学内容</th>
                                    <th>审核状态</th>
                                    <th>审核备注</th>
                                    
                                    </tr>
                                    </thead>
                                    <tbody id="teaching_request_body">
                                    </tbody>
                                    </table>
                                    
                                    <div id="teaching_request_bar" class="pagination" style="margin-top:20px;">
                                    </div>
                                    <div>
                                    </div>
                                    </div>
                                    <script type="text/javascript" src="${pageContext.request.contextPath}/static/common/jquery-1.11.1.min.js"></script>
                                        <script type="text/javascript" src="${pageContext.request.contextPath}/static/common/page/myPagination.js"></script>
                                            
                                            
                                            <script type="text/javascript" src="${pageContext.request.contextPath}/static/hui/lib/layer/2.4/layer.js"></script>
                                                <script type="text/javascript" src="${pageContext.request.contextPath}/static/hui/static/h-ui/js/H-ui.min.js"></script>
                                                    <script type="text/javascript" src="${pageContext.request.contextPath}/static/hui/static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->
                                                        <script type="text/javascript" src="${pageContext.request.contextPath}/static/hui/lib/jquery.contextmenu/jquery.contextmenu.r2.js"></script>
                                                            
                                                            
                                                            
                                                            
                                                            
                                                            <script type="text/javascript" src="${pageContext.request.contextPath}/static/common/utils/listutils.js?v=9550"></script>
                                                                
                                                                
                                                                <script type="text/javascript">
                                                                
                                                                $(function(){
                                                                    
                                                                    ajaxList(1);
                                                                    
                                                                    
                                                                });
                                                                
                                                                
                                                                
                                                                
                                                                
                                                                
                                                                function ajaxList(page) {
                                                                    var subjectName = $("#subjectName").val();
                                                                    var semesterName = $("#semesterName").val();
                                                                    
                                                                    showLoading('${pageContext.request.contextPath}/static/common/loading.gif');
                                                                        $.ajax({
                                                                            type : 'get',
                                                                            url : "${pageContext.request.contextPath}/admin/teaching_request/queryList",
                                                                                data : {
                                                                                    "page":page,
                                                                                    "subjectName":subjectName,
                                                                                    "semesterName":semesterName
                                                                                    
                                                                                },
                                                                                success : function(result) {
                                                                                    hideLoading();
                                                                                    var rows = result.list;//得到数据列
                                                                                    var total = result.count;//得到数据总数
                                                                                    lastPage=result.totalPage;
                                                                                    totalCount=total;
                                                                                    var html = '';
                                                                                    for (var i = 0; i < rows.length; i++) {
                                                                                        html += '<tr>' ;
                                                                                        var subjectNameVal=setNullToEmpty(rows[i].teachingRequest.subjectName);
                                                                                        html+='<td>'+ subjectNameVal+'</td>';
                                                                                        var semesterNameVal=setNullToEmpty(rows[i].teachingRequest.semesterName);
                                                                                        html+='<td>'+ semesterNameVal+'</td>';
                                                                                        var teaherIdVal=setNullToEmpty(rows[i].teaherIdStr);
                                                                                        html+='<td>'+ teaherIdVal+'</td>';
                                                                                        var teachDescVal=setNullToEmpty(rows[i].teachingRequest.teachDesc);
                                                                                        html+='<td>'+ teachDescVal+'</td>';
                                                                                        var checkStatusVal=setNullToEmpty(rows[i].checkStatusStr);
                                                                                        html+='<td>'+checkStatusVal+'</td>';
                                                                                        var checkRemarkVal=setNullToEmpty(rows[i].teachingRequest.checkRemark);
                                                                                        html+='<td>'+ checkRemarkVal+'</td>';
                                                                                        html+='</tr>';
                                                                                    }
                                                                                    if (rows.length == 0) {
                                                                                        html += '<tr><td></td><td></td><td></td><td>无数据</td><td></td><td></td></tr>';
                                                                                    }
                                                                                    $("#teaching_request_body").html(html);
                                                                                    
                                                                                    
                                                                                    new myPagination({
                                                                                        id: 'teaching_request_bar',
                                                                                        curPage:page, //初始页码
                                                                                        pageTotal: result.totalPage, //总页数
                                                                                        pageAmount: 10,  //每页多少条
                                                                                        dataTotal: total, //总共多少条数据
                                                                                        pageSize: 5, //可选,分页个数
                                                                                        showPageTotalFlag:true, //是否显示数据统计
                                                                                        showSkipInputFlag:false, //是否支持跳转
                                                                                        getPage: function (page) {
                                                                                            ajaxList(page);
                                                                                        }
                                                                                    })
                                                                                    
                                                                                }
                                                                            });
                                                                        }
                                                                        
                                                                        
                                                                        
                                                                        function gotoPage(e){
                                                                            var pageName = $(e).attr("page-name");
                                                                            var url = $(e).attr("data-url");
                                                                            creatIframe(url,pageName);
                                                                        }
                                                                        
                                                                        
                                                                        
                                                                        </script>
                                                                        </body>
                                                                        </html>
