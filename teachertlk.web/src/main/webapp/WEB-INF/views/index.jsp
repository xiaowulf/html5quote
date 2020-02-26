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
	<div class="container-fluid" style="background-color:#F8F8F8;">
		<div class="row" style="height:30px;" >
			<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
			</div>
		</div>
	</div>
	<div class="container-fluid" style="background-color:#F8F8F8;">
		<div class="row" style="height:500px;">
			<div class="container" style="background-color:#F8F8F8;">
				<div class="row">
					<div class="jumbotron" style="height:460px;">
					  <h1 style="text-align:center;">kid-english专注于青少年英语教育</h1>
					  <div class="container" style="margin-top:50px;">
						<div class="row">
							<div class="col-xs-12 col-sm-12 col-md-4 col-lg-4"">
								<div style="text-align:center;">
									<embed src="images/street-talk-lingoda.svg" type="image/svg+xml" />
								</div>
								<div style="text-align:center;color:#1669BC;">
									<h3>小班教学，最多5名同学</h3>
								</div>
								<div style="text-align:center;">
									<h4>有充足的交流和互动课程</h4>
								</div>
							</div>
							<div class="col-xs-12 col-sm-12 col-md-4 col-lg-4">
								<div style="text-align:center;">
									<embed src="images/street-talk-lingoda.svg" type="image/svg+xml" />
								</div>
								<div style="text-align:center;color:#1669BC;">
									<h3>小班教学，最多5名同学</h3>
								</div>
								<div style="text-align:center;">
									<h4>有充足的交流和互动课程</h4>
								</div>
							</div>
							<div class="col-xs-12 col-sm-12 col-md-4 col-lg-4">
								<div style="text-align:center;">
									<embed src="images/street-talk-lingoda.svg" type="image/svg+xml" />
								</div>
								<div style="text-align:center;color:#1669BC;">
									<h3>小班教学，最多5名同学</h3>
								</div>
								<div style="text-align:center;">
									<h4>有充足的交流和互动课程</h4>
								</div>
							</div>
						</div>
					</div>	
					</div>
				</div>
			</div>
		</div>
	</div>
	
	
	<div class="container-fluid" >
		<div class="row" style="height:30px;">
			<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
			</div>
		</div>
	</div>
	
	<div class="container">
		<div class="row" style="height:30px;">
			<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12" style="text-align:center;">
				<h1>如何在Kid-English上学习英语</h1>
			</div>
		</div>
	</div>
	
	
	<div class="container">
		<div class="row" style="height:500px;">
			<div class="col-xs-12 col-sm-12 col-md-4 col-lg-4" style="text-align:right;color:#03B3FE;">
				<h1>1. Choose a time</h1>
			</div>
			<div class="col-xs-12 col-sm-12 col-md-8 col-lg-8">
				<video width="650" height="400" controls  style="float:right;">
				  <source src="images/1.mp4" type="video/mp4">
				Your browser does not support the video tag.
				</video>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="row" style="height:500px;">
			<div class="col-xs-12 col-sm-12 col-md-8 col-lg-8">
				<video width="650" height="400" controls style="float:left;">
				  <source src="images/2.mp4" type="video/mp4">
				Your browser does not support the video tag.
				</video>
			</div>
			<div class="col-xs-12 col-sm-12 col-md-4 col-lg-4" style="text-align:leftt;color:#03B3FE;">
				<h1>2. Choose a class</h1>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="row" style="height:500px;">
			<div class="col-xs-12 col-sm-12 col-md-4 col-lg-4" style="text-align:right;color:#03B3FE;">
				<h1>3. Choose a time</h1>
			</div>
			<div class="col-xs-12 col-sm-12 col-md-8 col-lg-8">
				<video width="650" height="400" controls style="float:right;">
				  <source src="images/3.mp4" type="video/mp4">
				Your browser does not support the video tag.
				</video>
			</div>
		</div>
	</div>
	<%@ include file="footer.jsp"%>
	
	<script src="js/jquery-1.11.0.min.js" type="text/javascript"></script>
	<script src="js/bootstrap.min.js" type="text/javascript"></script>
	<script src="js/index.js" type="text/javascript" charset="UTF-8"></script>
</body>
</html>