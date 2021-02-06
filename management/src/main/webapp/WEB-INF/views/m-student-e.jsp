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
<form action="saveStudent.html" method="post"  enctype="multipart/form-data">
	<div class="container">
		<div class="row">
			<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 mainrightOrdersNav1">
				<spring:message code="student.management.detail"/>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-2 col-sm-2 col-md-2 col-lg-2" style="border:1px solid #4B306C;height:30px;">
				<label style="height:25px;margin-top:2px;text-align:right;"><spring:message code="student.truename"/></label>
			</div>
			<div class="col-xs-10 col-sm-10 col-md-10 col-lg-10" style="border:1px solid #4B306C;height:30px;">
				<input type="text" name="truename" style="height:25px;width:500px;margin-top:2px;" value='<c:out value="${tbStudent.truename}"/>'><span class="requireText">*</span>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-2 col-sm-2 col-md-2 col-lg-2" style="border:1px solid #4B306C;height:30px;">
				<label style="height:25px;margin-top:2px;text-align:right;"><spring:message code="student.username"/></label>
			</div>
			<div class="col-xs-10 col-sm-10 col-md-10 col-lg-10" style="border:1px solid #4B306C;height:30px;">
				<input type="text" name="username" style="height:25px;width:500px;margin-top:2px;" value='<c:out value="${tbStudent.username}"/>'><span class="requireText">*</span>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-2 col-sm-2 col-md-2 col-lg-2" style="border:1px solid #4B306C;height:100px;">
				<label style="height:25px;margin-top:2px;text-align:right;"><spring:message code="student.pic"/></label>
			</div>
			<div class="col-xs-10 col-sm-10 col-md-10 col-lg-10" style="border:1px solid #4B306C;height:100px;padding-top:10px;">
				<input type="file" name="image">
				<a href="./<c:out value="${tbStudent.pic1}"/>" target="_blank"><spring:message code="system.view"/></a>
				<span class="requireText">*</span>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-2 col-sm-2 col-md-2 col-lg-2" style="border:1px solid #4B306C;height:30px;">
				<label style="height:25px;margin-top:2px;text-align:right;"><spring:message code="student.email"/></label>
			</div>
			<div class="col-xs-10 col-sm-10 col-md-10 col-lg-10" style="border:1px solid #4B306C;height:30px;">
				<input type="text" name="email"  style="height:25px;width:500px;margin-top:2px;" value='<c:out value="${tbStudent.email}"/>'>
				<span class="requireText">*</span>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-2 col-sm-2 col-md-2 col-lg-2" style="border:1px solid #4B306C;height:30px;">
				<label style="height:25px;margin-top:2px;text-align:right;"><spring:message code="student.mobile"/></label>
			</div>
			<div class="col-xs-10 col-sm-10 col-md-10 col-lg-10" style="border:1px solid #4B306C;height:30px;">
				<input type="text" name="mobile" style="height:25px;width:500px;margin-top:2px;" value='<c:out value="${tbStudent.mobile}"/>'>
				<span class="requireText">*</span>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-2 col-sm-2 col-md-2 col-lg-2" style="border:1px solid #4B306C;height:30px;">
				<label style="height:25px;margin-top:2px;text-align:right;"><spring:message code="student.birthday"/></label>
			</div>
			<div class="col-xs-10 col-sm-10 col-md-10 col-lg-10" style="border:1px solid #4B306C;height:30px;">
				<input type="text" name="birthday" style="height:25px;width:500px;margin-top:2px;" value='<c:out value="${tbStudent.birthday}"/>'>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-2 col-sm-2 col-md-2 col-lg-2" style="border:1px solid #4B306C;height:30px;">
				<label style="height:25px;margin-top:2px;text-align:right;"><spring:message code="student.sex"/></label>
			</div>
			<div class="col-xs-10 col-sm-10 col-md-10 col-lg-10" style="border:1px solid #4B306C;height:30px;">
				<select name="sex" id="sex_id">
					<c:if test="${tbStudent.sex eq '0'}">
						<option value="0" selected="selected"><spring:message code="student.sex.male"/></option>
						<option value="1"><spring:message code="student.sex.female"/></option>
					</c:if>
					<c:if test="${tbStudent.sex eq '1'}">
						<option value="0"><spring:message code="student.sex.male"/></option>
						<option value="1" selected="selected"><spring:message code="student.sex.female"/></option>
					</c:if>
		   	 	</select>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-2 col-sm-2 col-md-2 col-lg-2" style="border:1px solid #4B306C;height:30px;">
				<label style="height:25px;margin-top:2px;text-align:right;"><spring:message code="student.status"/></label>
			</div>
			<div class="col-xs-10 col-sm-10 col-md-10 col-lg-10" style="border:1px solid #4B306C;height:30px;">
				<select name="status" id="status_id">
					<c:if test="${tbStudent.status eq '0'}">
						<option value="0" selected="selected"><spring:message code="student.status.off"/></option>
						<option value="1"><spring:message code="student.status.on"/></option>
					</c:if>
					<c:if test="${tbStudent.status eq '1'}">
						<option value="0"><spring:message code="student.status.off"/></option>
						<option value="1" selected="selected"><spring:message code="student.status.on"/></option>
					</c:if>
		   	 	</select>
			</div>
		</div>
		
		<div class="row">
			<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12" style="border:1px solid #4B306C;height:50px;padding-top:5px;text-align:center;">
				<input type="hidden" name="id" value="${tbStudent.id}">
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