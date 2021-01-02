<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page  isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html lang="zh">
<%@ include file="constants.jsp"%>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0;" name="viewport" />
    <title><%=appName%></title>
	<script src="js/echarts.min.js" type="text/javascript"></script>
	<link type="text/css" rel="stylesheet" href="./css/main.css" />
	<link type="text/css" rel="stylesheet" href="./css/font-awesome.min.css" />
	<link rel="stylesheet" type="text/css" href="./themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="./themes/icon.css">
	<link rel="stylesheet" type="text/css" href="./css/bootstrap.css">
</head>

<body style="background-color: #ffffff;">
	<div class="container-fluid">
		<div class="row">
			<div class="col-xs-12 col-sm-12 col-md-4 col-lg-4">
						   <div class="panel panel-primary" style="margin-top:10px;">
							    <div class="panel-heading">
							        <h3 class="panel-title"><spring:message code="system.changepwd"/></h3>
							    </div>
							    <div class="panel-body">
						        <div style="text-align:center;padding:5px">
						        	<spring:message code="system.password.now"/>:<input type="password" name="oldpassword" style="width:200px;">
						        </div>    
						        <div style="text-align:center;padding:5px">
						        	<spring:message code="system.password.new"/>:<input type="password" name="newpassword" style="width:200px;">
						        </div> 
						        <div style="text-align:center;padding:5px">
						        	<spring:message code="system.password.confirm"/>:<input type="password" name="confirmpassword" style="width:200px;">
						        </div> 
						        <div style="text-align:center;padding:5px">
						        	<button class="btn btn-success" type="button" onclick="changePwdForm()"><spring:message code="system.save"/></button>
						        </div>
							    </div>
							</div>
			</div>
		</div>
		<!-- end row -->
	</div>
<script src="js/jquery-1.11.0.min.js" type="text/javascript"></script>
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<script src="js/main.js" type="text/javascript"></script>
</body>
</html>