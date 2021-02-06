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

	<div class="container-fluid" style="margin-top:20px;">
		<div class="row">
			<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
				<form action="m-course-category.html" method="get">
				<table class="tableClass">
				   	 	<thead>
				   	 		<tr>
				   	 			<th width="50%" style="text-align:left;">
				   	 				<spring:message code="course.catetory.management"/>
				   	 				<spring:message code="course.category.name"/>:
				   	 				<input type="text" name="name" value='<c:out value="${name}"></c:out>'>
				   	 				<input type="submit" value="<spring:message code="system.query"/>">
				   	 				<a href="m-course-category-a.html" target="_blank" style="margin-left:50px;"><spring:message code="system.add"/></a>
				   	 			</th>
				   	 		</tr>
				   	 	</thead>
				</table>
				</form>
			</div>
		</div>
	</div>

	<div class="container-fluid">
		<div class="row">
			<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
				<div id="mainTable">
				   	 <table class="tableClass">
				   	 	<thead>
				   	 		<tr>
				   	 			<th width="10%">
				   	 				<spring:message code="course.category.name"/>
				   	 			</th>
				   	 			<th width="10%">
				   	 				<spring:message code="course.category.code"/>
				   	 			</th>
				   	 			<th width="10%">
				   	 				<spring:message code="system.createdate"/>
				   	 			</th>
				   	 			<th width="10%">
				   	 				<spring:message code="system.updatedate"/>
				   	 			</th>
				   	 			<th width="10%">
				   	 				<spring:message code="teacher.status"/>
				   	 			</th>
				   	 			<th width="10%">
				   	 				<spring:message code="teacher.edit"/>
				   	 			</th>
				   	 		</tr>
				   	 	</thead>
				   	 	<tbody id="tableContent">
				   	 		<c:forEach  items="${dataList}" var="dataList"  varStatus="userStatus">
				   	 		<c:if test="${userStatus.index%2==0}">
				   	 			<tr style="background-color:#ffffff;" onmouseover="style.backgroundColor='#f2f288'" onmouseout="style.backgroundColor='#FFFFFF'" id='tableContent${dataList.id}'> 
				   	 		</c:if>
				   	 			
				   	 		<c:if test="${userStatus.index%2==1}">
				   	 			<tr style="background-color:#e0ecff;" onmouseover="style.backgroundColor='#f2f288'" onmouseout="style.backgroundColor='#e0ecff'" id='tableContent${dataList.id}'>
				   	 		</c:if>
				   	 			<td>
				   	 				<c:out value="${dataList.coursename}"></c:out>
					   	 		</td>
				   	 			<td>
				   	 				<c:out value="${dataList.coursecode}"></c:out>
					   	 		</td>
					   	 		<td>
				   	 				<c:out value="${dataList.create_date}"></c:out>
					   	 		</td>
					   	 		<td>
				   	 				<c:out value="${dataList.update_date}"></c:out>
					   	 		</td>
					   	 		<td>
				   	 				<c:if test="${dataList.status==0}">
					   	 				<spring:message code="course.category.off"/>
					   	 			</c:if>
						   	 		<c:if test="${dataList.status==1}">
					   	 				<spring:message code="course.category.on"/>
					   	 			</c:if>
					   	 		</td>
					   	 		<td>
						   	 		<a href='m-course-category-e.html?id=<c:out value="${dataList.id}"></c:out>' target="_blank"><img alt="" src="./images/11.png" style="margin-top:5px;cursor:pointer;"></a>
					   	 		</td>
				   	 		</tr>
				   	 		</c:forEach>
				   	 	</tbody>
				   	 	
				   	 	<tfoot>
				   	 		<tr>
				   	 			<td colspan="9">
				   	 				<%@ include file="page.jsp"%>
				   	 			</td>
				   	 		</tr>
				   	 	</tfoot>
				   	 </table>
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