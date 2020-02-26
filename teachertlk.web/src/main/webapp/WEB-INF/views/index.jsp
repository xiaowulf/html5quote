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
<link type="text/css" rel="stylesheet" href="./css/bootstrap.css" />
<link type="text/css" rel="stylesheet" href="./css/font-awesome.min.css" />
<!--include plugin css-->
<link type="text/css" rel="stylesheet" href="./js/jquery-rvnm.css" />
</head>

<body style="background-color: #ffffff;">
	<nav class="navbar navbar-default navbar-fixed-top">
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

	<div class="container-fluid">
		<div class="row">
			<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
					<div class="row" style="margin-top:80px;">
						<div id="myCarousel" class="carousel slide" data-ride="carousel">
						  <!-- Indicators -->
						  <ol class="carousel-indicators">
						    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
						    <li data-target="#myCarousel" data-slide-to="1"></li>
						    <li data-target="#myCarousel" data-slide-to="2"></li>
						  </ol>
						  <!-- Wrapper for slides -->
						  <div class="carousel-inner">
						    <div class="item active" id="slide11">
						      	<img src="images/1.png" alt="Los Angeles" style="margin:auto;">
						    </div>
						
						    <div class="item" id="slide12">
						      	<img src="images/2.jpg" alt="Los Angeles" style="margin:auto;">
						    </div>
						
						    <div class="item" id="slide13">
						      	<img src="images/3.jpg" alt="Los Angeles" style="margin:auto;">
						    </div>
						  </div>
						</div>
					</div>
			</div>
		</div>
	</div>
	<div class="container-fluid">
		<div class="row" style="height:30px;">
			<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
			</div>
		</div>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-xs-12 col-sm-12 col-md-4 col-lg-4">
				<div class="panel panel-success">
					<div class="panel-heading">
						<h3 class="panel-title">面板标题</h3>
					</div>
					<div class="panel-body">
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
					</div>
				</div>
			</div>
			<div class="col-xs-12 col-sm-12 col-md-4 col-lg-4">
				<div class="panel panel-info">
					<div class="panel-heading">
						<h3 class="panel-title">面板标题</h3>
					</div>
					<div class="panel-body">
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
					</div>
				</div>
			</div>
			<div class="col-xs-12 col-sm-12 col-md-4 col-lg-4">
				<div class="panel panel-danger">
					<div class="panel-heading">
						<h3 class="panel-title">面板标题</h3>
					</div>
					<div class="panel-body">
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
					</div>
				</div>
			</div>
		</div>
	</div>	
	<div class="container-fluid">
		<div class="row" style="height:30px;">
			<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
			</div>
		</div>
	</div>
	
	<div class="container">
		<div class="row" style="height:30px;">
			<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
				How Lingoda works
			</div>
		</div>
	</div>
	
	<div class="container">
		<div class="row">
			<div class="col-xs-12 col-sm-12 col-md-4 col-lg-4">
				<div class="panel panel-success">
					<div class="panel-heading">
						<h3 class="panel-title">面板标题</h3>
					</div>
					<div class="panel-body">
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
					</div>
				</div>
			</div>
			<div class="col-xs-12 col-sm-12 col-md-4 col-lg-4">
				<div class="panel panel-info">
					<div class="panel-heading">
						<h3 class="panel-title">面板标题</h3>
					</div>
					<div class="panel-body">
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
					</div>
				</div>
			</div>
			<div class="col-xs-12 col-sm-12 col-md-4 col-lg-4">
				<div class="panel panel-danger">
					<div class="panel-heading">
						<h3 class="panel-title">面板标题</h3>
					</div>
					<div class="panel-body">
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="row" style="height:30px;">
			<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
				How Lingoda works
			</div>
		</div>
	</div>
	
	<div class="container">
		<div class="row">
			<div class="col-xs-12 col-sm-12 col-md-4 col-lg-4">
				<div class="panel panel-success">
					<div class="panel-heading">
						<h3 class="panel-title">面板标题</h3>
					</div>
					<div class="panel-body">
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
					</div>
				</div>
			</div>
			<div class="col-xs-12 col-sm-12 col-md-4 col-lg-4">
				<div class="panel panel-info">
					<div class="panel-heading">
						<h3 class="panel-title">面板标题</h3>
					</div>
					<div class="panel-body">
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
					</div>
				</div>
			</div>
			<div class="col-xs-12 col-sm-12 col-md-4 col-lg-4">
				<div class="panel panel-danger">
					<div class="panel-heading">
						<h3 class="panel-title">面板标题</h3>
					</div>
					<div class="panel-body">
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
						这是一个基本的面板
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<%@ include file="footer.jsp"%>
	
	<script src="js/jquery-1.11.0.min.js" type="text/javascript"></script>
	<script src="js/bootstrap.min.js" type="text/javascript"></script>
	<script src="js/index.js" type="text/javascript" charset="UTF-8"></script>
</body>
</html>