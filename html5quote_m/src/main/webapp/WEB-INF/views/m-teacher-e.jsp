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
<form action="saveTeacher.html" method="post"  enctype="multipart/form-data">
	<div class="container">
		<div class="row">
			<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 mainrightOrdersNav1">
				<spring:message code="teacher.management.detail"/>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-2 col-sm-2 col-md-2 col-lg-2" style="border:1px solid #4B306C;height:30px;">
				<label style="height:25px;margin-top:2px;text-align:right;"><spring:message code="teacher.truename"/></label>
			</div>
			<div class="col-xs-10 col-sm-10 col-md-10 col-lg-10" style="border:1px solid #4B306C;height:30px;">
				<input type="text" name="truename" style="height:25px;width:500px;margin-top:2px;" value='<c:out value="${tbTeacher.truename}"/>'><span class="requireText">*</span>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-2 col-sm-2 col-md-2 col-lg-2" style="border:1px solid #4B306C;height:30px;">
				<label style="height:25px;margin-top:2px;text-align:right;"><spring:message code="teacher.idcard"/></label>
			</div>
			<div class="col-xs-10 col-sm-10 col-md-10 col-lg-10" style="border:1px solid #4B306C;height:30px;">
				<input type="text" name="idcard" style="height:25px;width:500px;margin-top:2px;" value='<c:out value="${tbTeacher.idcard}"/>'>
				<span class="requireText">*</span>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-2 col-sm-2 col-md-2 col-lg-2" style="border:1px solid #4B306C;height:100px;">
				<label style="height:25px;margin-top:2px;text-align:right;"><spring:message code="teacher.pic"/></label>
			</div>
			<div class="col-xs-10 col-sm-10 col-md-10 col-lg-10" style="border:1px solid #4B306C;height:100px;padding-top:10px;">
				<input type="file" name="image">
				<a href="./<c:out value="${tbTeacher.pic1}"/>" target="_blank"><spring:message code="system.view"/></a>
				<span class="requireText">*</span>
			</div>
		</div>
		
		<div class="row">
			<div class="col-xs-2 col-sm-2 col-md-2 col-lg-2" style="border:1px solid #4B306C;height:30px;">
				<label style="height:25px;margin-top:2px;text-align:right;"><spring:message code="teacher.certificate"/></label>
			</div>
			<div class="col-xs-10 col-sm-10 col-md-10 col-lg-10" style="border:1px solid #4B306C;height:30px;">
				<input type="text" name="certificate" style="height:25px;width:500px;margin-top:2px;" value='<c:out value="${tbTeacher.certificate}"/>'>
				<span class="requireText">*</span>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-2 col-sm-2 col-md-2 col-lg-2" style="border:1px solid #4B306C;height:30px;">
				<label style="height:25px;margin-top:2px;text-align:right;"><spring:message code="teacher.username"/></label>
			</div>
			<div class="col-xs-10 col-sm-10 col-md-10 col-lg-10" style="border:1px solid #4B306C;height:30px;">
				<input type="text" name="username" style="height:25px;width:500px;margin-top:2px;" value='<c:out value="${tbTeacher.username}"/>'>
				<span class="requireText">*</span>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-2 col-sm-2 col-md-2 col-lg-2" style="border:1px solid #4B306C;height:30px;">
				<label style="height:25px;margin-top:2px;text-align:right;"><spring:message code="teacher.email"/></label>
			</div>
			<div class="col-xs-10 col-sm-10 col-md-10 col-lg-10" style="border:1px solid #4B306C;height:30px;">
				<input type="text" name="email"  style="height:25px;width:500px;margin-top:2px;" value='<c:out value="${tbTeacher.email}"/>'>
				<span class="requireText">*</span>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-2 col-sm-2 col-md-2 col-lg-2" style="border:1px solid #4B306C;height:30px;">
				<label style="height:25px;margin-top:2px;text-align:right;"><spring:message code="teacher.mobile"/></label>
			</div>
			<div class="col-xs-10 col-sm-10 col-md-10 col-lg-10" style="border:1px solid #4B306C;height:30px;">
				<input type="text" name="mobile" style="height:25px;width:500px;margin-top:2px;" value='<c:out value="${tbTeacher.mobile}"/>'>
				<span class="requireText">*</span>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-2 col-sm-2 col-md-2 col-lg-2" style="border:1px solid #4B306C;height:30px;">
				<label style="height:25px;margin-top:2px;text-align:right;"><spring:message code="teacher.birthday"/></label>
			</div>
			<div class="col-xs-10 col-sm-10 col-md-10 col-lg-10" style="border:1px solid #4B306C;height:30px;">
				<input type="text" name="birthday" style="height:25px;width:500px;margin-top:2px;" value='<c:out value="${tbTeacher.birthday}"/>'>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-2 col-sm-2 col-md-2 col-lg-2" style="border:1px solid #4B306C;height:30px;">
				<label style="height:25px;margin-top:2px;text-align:right;"><spring:message code="teacher.sex"/></label>
			</div>
			<div class="col-xs-10 col-sm-10 col-md-10 col-lg-10" style="border:1px solid #4B306C;height:30px;">
				<select name="status" id="status_id">
		   	 		<option value="1"><spring:message code="teacher.status.on"/></option>
		   	 		<option value="0"><spring:message code="teacher.status.off"/></option>
		   	 	</select>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-2 col-sm-2 col-md-2 col-lg-2" style="border:1px solid #4B306C;height:30px;">
				<label style="height:25px;margin-top:2px;text-align:right;"><spring:message code="teacher.status"/></label>
			</div>
			<div class="col-xs-10 col-sm-10 col-md-10 col-lg-10" style="border:1px solid #4B306C;height:30px;">
				<select name="status" id="status_id">
		   	 		<option value="1"><spring:message code="teacher.status.on"/></option>
		   	 		<option value="0"><spring:message code="teacher.status.off"/></option>
		   	 	</select>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-2 col-sm-2 col-md-2 col-lg-2" style="border:1px solid #4B306C;height:260px;">
				<label style="height:25px;margin-top:2px;text-align:right;"><spring:message code="teacher.resume"/></label>
			</div>
			<div class="col-xs-10 col-sm-10 col-md-10 col-lg-10" style="border:1px solid #4B306C;height:260px;">
				<textarea rows="10" name="resume" cols="68"><c:out value="${tbTeacher.resume}"/></textarea>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12" style="border:1px solid #4B306C;height:50px;padding-top:5px;text-align:center;">
				<input type="hidden" name="id" value="${tbTeacher.id}">
				<button class="btn btn-success" type="submit" ><spring:message code="system.save"/></button>
				<button class="btn btn-success" type="button" onclick="submitForm()"><spring:message code="system.close"/></button>
				<button class="btn btn-warning" type="button" onclick="submitForm()"><spring:message code="system.reset.password"/></button>
			</div>
		</div>
		<!-- end row -->
	</div>
</form>
<script src="js/jquery-1.11.0.min.js" type="text/javascript"></script>
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<script src="js/main.js" type="text/javascript"></script>
</body>
</html>