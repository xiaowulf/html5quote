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
    <!--awesome font include-->
    <link type="text/css" rel="stylesheet" href="./css/main.css" />
    <link type="text/css" rel="stylesheet" href="./css/font-awesome.min.css" />
    <!--include plugin css-->
    <link type="text/css" rel="stylesheet" href="./js/jquery-rvnm.css" />
    <link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
</head>

<body style="background-color: #ffffff;">

<nav class="navbar navbar-default navbar-fixed-top">
        <div class="container-fluid">
            <div class="navbar-header" style="float:left;margin-left:1px;">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#TaoistsNavBar" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
            </div>
            <div class="collapse navbar-collapse" id="TaoistsNavBar">
                <jsp:include page="mnavbar.jsp"></jsp:include>
            </div>
        </div>
    </nav>

	<div class="container-fluid">
		<div class="row" style="margin-top:60px;">
			<div style="padding-top:3px;" class="mainrightZhiBiao1 col-xs-2 col-sm-2 col-md-2 col-lg-2">
				策略ID
			</div>
			<div style="padding-top:3px;" class="mainrightZhiBiao1 col-xs-2 col-sm-2 col-md-2 col-lg-2">
				策略名称	
			</div>
			<div style="padding-top:3px;" class="mainrightZhiBiao1 col-xs-2 col-sm-2 col-md-2 col-lg-2">
				开始日期	
			</div>
			<div style="padding-top:3px;" class="mainrightZhiBiao1 col-xs-2 col-sm-2 col-md-2 col-lg-2">
				初始资金
			</div>
			<div style="padding-top:3px;" class="mainrightZhiBiao1 col-xs-2 col-sm-2 col-md-2 col-lg-2">
				是否有效
			</div>
			<div style="padding-top:3px;" class="mainrightZhiBiao1 col-xs-2 col-sm-2 col-md-2 col-lg-2">
				编辑 <span style="cursor:pointer;" onclick="addStrategy(${dataList.id})">新增</span>
			</div>
		</div>
		
		<c:forEach  items="${list}" var="dataList"  varStatus="userStatus">
			<div class="row">
			<c:if test="${userStatus.index%2==0}">
				 <div style="padding-top:3px;" class="mainrightZhiBiao2 col-xs-2 col-sm-2 col-md-2 col-lg-2">
					<c:out value="${dataList.id}"></c:out>
				 </div>
				 <div style="padding-top:3px;" class="mainrightZhiBiao2 col-xs-2 col-sm-2 col-md-2 col-lg-2">
					<c:out value="${dataList.name}"></c:out>
				 </div>
				 <div style="padding-top:3px;" class="mainrightZhiBiao2 col-xs-2 col-sm-2 col-md-2 col-lg-2">
					<c:out value="${dataList.initdate}"></c:out>
				 </div>
				 <div style="padding-top:3px;" class="mainrightZhiBiao2 col-xs-2 col-sm-2 col-md-2 col-lg-2">
					<c:out value="${dataList.qcqy}"></c:out>
				 </div>
				 <div style="padding-top:3px;" class="mainrightZhiBiao2 col-xs-2 col-sm-2 col-md-2 col-lg-2">
					<c:if test="${dataList.is_use eq 0}">
				 		无效
				 	</c:if>
				 	<c:if test="${dataList.is_use eq 1}">
				 		有效
				 	</c:if>
				 </div>
				 <div style="padding-top:3px;" class="mainrightZhiBiao2 col-xs-2 col-sm-2 col-md-2 col-lg-2">
					<span style="cursor:pointer;" onclick="editStrategy(${dataList.id})">编辑</span> <span style="cursor:pointer;" onclick="deleteStrategy(${dataList.id})">删除</span>
				 </div>
			</c:if>
				   	 			
			<c:if test="${userStatus.index%2==1}">
				 <div style="padding-top:3px;" class="mainrightZhiBiao1 col-xs-2 col-sm-2 col-md-2 col-lg-2">
				 	<c:out value="${dataList.id}"></c:out>
				 </div>
				 <div style="padding-top:3px;" class="mainrightZhiBiao1 col-xs-2 col-sm-2 col-md-2 col-lg-2">
				 	<c:out value="${dataList.name}"></c:out>
				 </div>
				 <div style="padding-top:3px;" class="mainrightZhiBiao1 col-xs-2 col-sm-2 col-md-2 col-lg-2">
				 	<c:out value="${dataList.initdate}"></c:out>
				 </div>
				 <div style="padding-top:3px;" class="mainrightZhiBiao1 col-xs-2 col-sm-2 col-md-2 col-lg-2">
				 	<c:out value="${dataList.qcqy}"></c:out>
				 </div>
				 <div style="padding-top:3px;" class="mainrightZhiBiao1 col-xs-2 col-sm-2 col-md-2 col-lg-2">
				 	<c:if test="${dataList.is_use eq 0}">
				 		无效
				 	</c:if>
				 	<c:if test="${dataList.is_use eq 1}">
				 		有效
				 	</c:if>
				 </div>
				 <div style="padding-top:3px;" class="mainrightZhiBiao1 col-xs-2 col-sm-2 col-md-2 col-lg-2">
				 	<span style="cursor:pointer;" onclick="editStrategy(${dataList.id})">编辑</span> <span style="cursor:pointer;" onclick="deleteStrategy(${dataList.id})">删除</span> 
				 </div>
			</c:if>
		</div> 
		</c:forEach>
		
	</div>
	
	<div class="container-fluid" id="strategyEdit">
		<div class="row" style="margin-top:10px;height:35px;background-color:#EEEEEE;text-align:left;" id="strategyIDTR">
			<div style="padding-top:8px;text-align:right;" class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
				策略ID
			</div>
			<div style="padding-top:5px;text-align:left;" class="col-xs-8 col-sm-8 col-md-8 col-lg-8">
				<input type="text" readonly value="" id="strategyID" size="50"/>
			</div>
		</div>
		<div class="row" style="margin-top:0px;height:35px;background-color:#ffffff;text-align:left;">
			<div style="padding-top:8px;text-align:right;" class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
				策略名称
			</div>
			<div style="padding-top:5px;text-align:left;" class="col-xs-8 col-sm-8 col-md-8 col-lg-8">
				<input type="text" value="" id="strategyName" size="50"/>
			</div>
		</div>
		<div class="row" style="margin-top:0px;height:35px;background-color:#EEEEEE;text-align:left;">
			<div style="padding-top:8px;text-align:right;" class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
				开始日期
			</div>
			<div style="padding-top:5px;text-align:left;" class="col-xs-8 col-sm-8 col-md-8 col-lg-8">
				<input type="text" value="" id="strategyInitDate" size="50"/>
			</div>
		</div>
		<div class="row" style="margin-top:0px;height:35px;background-color:#ffffff;text-align:left;">
			<div style="padding-top:8px;text-align:right;" class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
				初始资金
			</div>
			<div style="padding-top:5px;text-align:left;" class="col-xs-8 col-sm-8 col-md-8 col-lg-8">
				<input type="text" value="" id="strategyQcqy" size="50"/>
			</div>
		</div>
		<div class="row" style="margin-top:0px;height:35px;background-color:#EEEEEE;text-align:left;">
			<div style="padding-top:8px;text-align:right;" class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
				是否有效
			</div>
			<div style="padding-top:0px;text-align:left;" class="col-xs-8 col-sm-8 col-md-8 col-lg-8">
				<select style="max-width:100px;" class="form-control" id="strategyISUSE">
					 <option value="0">无效</option>
					 <option value="1">有效</option>
				</select>
			</div>
		</div>
		<div class="row"  style="margin-top:0px;height:35px;background-color:#ffffff;text-align:center;">
			<div style="padding-top:5px;" class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
				<input type="button" value="保存"  onclick="saveStrategy()"/>
				<input type="button" value="取消"  onclick="hideDIV()"/>
			</div>
		</div>
	</div>
	
	
	
	
    <script src="js/jquery-1.11.0.min.js" type="text/javascript"></script>
    <script src="js/strategy.js" type="text/javascript"></script>
    <!--include plugin js-->
    <script type="text/javascript" src="./js/jquery-rvnm.js"></script>
    <script
		src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"
		integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
		crossorigin="anonymous"></script>
</body>
</html>