<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ include file="constants.jsp"%>
<!DOCTYPE html>
<html lang="zh">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0"
	name="viewport" />
<title><%=appName%></title>
<script src="js/echarts.min.js" type="text/javascript"></script>
<!--awesome font include-->
<link type="text/css" rel="stylesheet" href="./css/main.css" />
<link type="text/css" rel="stylesheet" href="./css/font-awesome.min.css" />
<link rel="stylesheet" type="text/css" href="./themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="./themes/icon.css">
</head>
<body>
    <div class="easyui-layout" style="width:100%;height:100%;">
        <div data-options="region:'north'" style="height:50px;background-color:#e0ecff;">
        	<div style="float:left;text-align:center;margin-top:10px;margin-left:50px;font-size:20px;font-weight:bold;">
		       	<spring:message code="system.name"/>
		     </div>
		     <div style="float:right;text-align:right;margin-right:50px;margin-top:10px;">
		       	<input type="button" id="changePwd" value="修改密码" class="cupid-blue" onclick="addTab('<spring:message code="system.changepwd"/>','m-password.html')">
		       	<input type="button" id="logoutImg" value="退出系统" class="cupid-blue">
		     </div>
        
        </div>
        <div data-options="region:'south',split:true" style="height:50px;"></div>
        <div data-options="region:'west',split:true" title='<spring:message code="system.welcome"/><c:out value="${tbEmployee.trueName}"></c:out>' style="width:300px;">
        
        <ul class="easyui-tree" id="funcTree">
        	<!--  
            <li>
            	<span>系统管理</span>
                <ul>
                    <li  data-options='state:closed,id:1,attributes:{urlaction:"m-employee.html"}'>员工管理</li>
                    <li  data-options='state:closed,id:1,attributes:{urlaction:"m-role.html"}'>角色管理</li>
                    <li  data-options='state:closed,id:1,attributes:{urlaction:"m-authority.html"}'>权限管理</li>
                    <li  data-options='state:closed,id:1,attributes:{urlaction:"m-log.html"}'>日志管理</li>
                </ul>
            </li>
            -->
            <li>
                <span>教学管理</span>
                <ul>
                    <li  data-options='state:closed,id:1,attributes:{urlaction:"m-teacher.html"}'>教师管理</li>
                    <li  data-options='state:closed,id:1,attributes:{urlaction:"m-student.html"}'>学生管理</li>
                    <li  data-options='state:closed,id:1,attributes:{urlaction:"m-course.html"}'>课程管理</li>
                    <li  data-options='state:closed,id:1,attributes:{urlaction:"m-course.html"}'>成绩管理</li>
                </ul>
            </li>
            <li>
                <span>财务管理</span>
                <ul>
                    <li  data-options='state:closed,id:1,attributes:{urlaction:"m-teacher.html"}'>教师管理</li>
                    <li  data-options='state:closed,id:1,attributes:{urlaction:"m-student.html"}'>学生管理</li>
                    <li  data-options='state:closed,id:1,attributes:{urlaction:"m-course.html"}'>课程管理</li>
                    <li  data-options='state:closed,id:1,attributes:{urlaction:"m-course.html"}'>成绩管理</li>
                </ul>
            </li>
            <li>
                <span>发布管理</span>
                <ul>
                    <li  data-options='state:closed,id:1,attributes:{urlaction:"m-teacher.html"}'>教师管理</li>
                    <li  data-options='state:closed,id:1,attributes:{urlaction:"m-student.html"}'>学生管理</li>
                    <li  data-options='state:closed,id:1,attributes:{urlaction:"m-course.html"}'>课程管理</li>
                    <li  data-options='state:closed,id:1,attributes:{urlaction:"m-course.html"}'>成绩管理</li>
                </ul>
            </li>
        </ul>
        </div>
        
        
        
        
        
        <div data-options="region:'center',title:'教育管理平台'" >
            <div class="easyui-tabs"  id="mainTabs">
		        <div title="主页">
		        	主頁
		            
		    	</div>
        	</div>
        </div>
        
        
        
    </div>




	
</body>
<script src="js/jquery-1.11.0.min.js" type="text/javascript"></script>
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
<script src="js/main.js" type="text/javascript"></script>
</html>