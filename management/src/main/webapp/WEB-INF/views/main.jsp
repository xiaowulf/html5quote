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
        <div data-options="region:'north'" style="height:50px"></div>
        <div data-options="region:'south',split:true" style="height:50px;"></div>
        <div data-options="region:'west',split:true" title="West" style="width:300px;">
        
        <ul class="easyui-tree" id="funcTree">
            <li>
                <span>管理系统</span>
                <ul>
                    <li data-options="state:'closed'">
                        <span>Photos</span>
                        <ul>
                            <li data-options='state:closed,id:1'>
                                <span>Friend</span>
                            </li>
                            <li>
                                <span>Wife</span>
                            </li>
                            <li>
                                <span>Company</span>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <span>Program Files</span>
                        <ul>
                            <li>Intel</li>
                            <li>Java</li>
                            <li>Microsoft Office</li>
                            <li>Games</li>
                        </ul>
                    </li>
                    <li>index.html</li>
                    <li>about.html</li>
                    <li>welcome.html</li>
                </ul>
            </li>
        </ul>
        
        
        </div>
        
        
        
        
        
        <div data-options="region:'center',title:'教育管理平台'" >
            <div class="easyui-tabs"  id="mainTabs">
		        <div title="主页">
		        	fdsafsdafdsafdsafdsfdsfds
		            
		    	</div>
        	</div>
        </div>
        
        
        
    </div>




	
</body>
<script src="js/main.js" type="text/javascript"></script>
<script src="js/jquery-1.11.0.min.js" type="text/javascript"></script>
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
</html>