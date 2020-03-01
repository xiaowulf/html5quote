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
		<div class="row" style="margin-top:20px;">
			<div class="col-xs-12 col-sm-12 col-md-6 col-lg-6" style="height:500px;float:left;border-left:1px solid #EEEEEE;border-top:1px solid #EEEEEE;border-bottom:1px solid #EEEEEE;">
				<div class="mainrightOrdersNav1 col-xs-12 col-sm-12 col-md-4 col-lg-4" onclick="getPosition()" id="mainrightOrdersNav1">
					持仓
				</div>
				<div class="mainrightOrdersNav2  col-xs-12 col-sm-12 col-md-4 col-lg-4" onclick="getSusPosition()" id="mainrightOrdersNav2">
					挂单
				</div>
				<div class="mainrightOrdersNav3  col-xs-12 col-sm-12 col-md-4 col-lg-4" onclick="getClosePosition()" id="mainrightOrdersNav3">
					平仓
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