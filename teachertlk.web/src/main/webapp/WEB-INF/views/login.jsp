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
<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" name="viewport" />
<title><%=appName%></title>
<script src="js/echarts.min.js" type="text/javascript"></script>
<link type="text/css" rel="stylesheet" href="./css/main.css" />
<link type="text/css" rel="stylesheet" href="./css/bootstrap.css" />
<link type="text/css" rel="stylesheet" href="./css/font-awesome.min.css" />
<!--include plugin css-->
<link type="text/css" rel="stylesheet" href="./js/jquery-rvnm.css" />
</head>

<body style="background-color: #ffffff;">
	<nav class="navbar navbar-default">
        <div class="container">
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
	<div class="container">
		<div class="row">
			<div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
			</div>
			<div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
					<div class="row" style="margin-top:50px;">
						<div class="item active" style="height:600px;"  style="margin:auto;">
						   <div class="panel panel-warning" style="height:500px;">
							    <div class="panel-heading">
							        <h3 class="panel-title">面板标题</h3>
							    </div>
							    <div class="panel-body">
							        这是一个fff基本的面板
							    </div>
							</div>
						</div>
					</div>
			</div>
			<div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
			</div>
		</div>
	</div>
	
	<%@ include file="footer.jsp"%>
	<script src="js/jquery-1.11.0.min.js" type="text/javascript"></script>
	<script src="js/bootstrap.min.js" type="text/javascript"></script>
	<script src="js/analyse.js" type="text/javascript" charset="UTF-8"></script>
</body>
</html>