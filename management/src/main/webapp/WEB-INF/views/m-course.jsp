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
				<table class="tableClass">
				   	 	<thead>
				   	 		<tr>
				   	 			<th width="15%">
				   	 				<spring:message code="teacher.management"/>
				   	 			</th>
				   	 		</tr>
				   	 	</thead>
				</table>
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
				   	 			<th width="15%">
				   	 				ID
				   	 			</th>
				   	 			<th width="15%">
				   	 			fdsaf
				   	 			</th>
				   	 			<th width="15%">
				   	 			</th>
				   	 			<th width="15%">
				   	 			</th>
				   	 			<th width="10%">
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
				   	 				<c:out value="${dataList.id}"></c:out>
					   	 		</td>
				   	 			<td>
				   	 				<c:out value="${dataList.username}"></c:out>
					   	 		</td>
					   	 		<td>
						   	 		<img alt="" src="./images/13.png" style="margin-top:5px;cursor:pointer;" onclick="addCapital('<c:out value="${dataList.id}"></c:out>')">
					   	 		</td>
					   	 		<td>
						   	 		<img alt="" src="./images/11.png" style="margin-top:5px;cursor:pointer;" onclick="editStrategy('<c:out value="${dataList.id}"></c:out>')">
					   	 		</td>
					   	 		<td>
						   	 		<img alt="" src="./images/12.png" style="margin-top:5px;cursor:pointer;" onclick="delStrategy('<c:out value="${dataList.id}"></c:out>')">
					   	 		</td>
				   	 		</tr>
				   	 		</c:forEach>
				   	 	</tbody>
				   	 	
				   	 	<tfoot>
				   	 		<tr>
				   	 			<td colspan="7">
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