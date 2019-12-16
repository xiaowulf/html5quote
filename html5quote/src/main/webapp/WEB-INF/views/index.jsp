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
		<div class="row">
			<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
					<div class="row" style="margin-top:50px;">
						<div class="mainrightMain" id="style-3">
						
						</div>
					</div>
					
					
					<div class="row">
						<div class="mainrightBottomNav">
				    		<div class="mainrightBottomNav1 col-xs-6 col-sm-6 col-md-3 col-lg-3" onclick="getJys('shfe')" id="mainrightBottomNav1">
					    		<spring:message code="jys_shfe"/>
					    	</div>
					    	<div class="mainrightBottomNav2  col-xs-6 col-sm-6 col-md-3 col-lg-3" onclick="getJys('czce')" id="mainrightBottomNav2">
					    		<spring:message code="jys_czce"/>
					    	</div>
					    	<div class="mainrightBottomNav3  col-xs-6 col-sm-6 col-md-3 col-lg-3" onclick="getJys('dce')" id="mainrightBottomNav3">
					    		<spring:message code="jys_dce"/>
					    	</div>
					    	<div class="mainrightBottomNav4  col-xs-6 col-sm-6 col-md-3 col-lg-3" onclick="getJys('cffex')" id="mainrightBottomNav4">
					    		<spring:message code="jys_cffex"/>
					    	</div>
					    	<!--  
					    	<div class="mainrightBottomNavMore  col-xs-2 col-sm-2 col-md-2 col-lg-2" id="mainrightBottomNavMore" onclick="getMoreChart()">
					    		更多指标
					    	</div>
					    	-->
			    		</div>
					</div>
					
					<div class="row">
				    		<div id="chart1" class="col-xs-12 col-sm-12 col-md-4 col-lg-4" style="height:300px;float:left"></div>
				    		<div id="chart2" class="col-xs-12 col-sm-12 col-md-4 col-lg-4" style="height:300px;float:left"></div>
				    		<div id="chart3" class="col-xs-12 col-sm-12 col-md-4 col-lg-4" style="height:300px;float:left"></div>
					</div>
				</div>
		</div>
	</div>
	
	<script src="js/jquery-1.11.0.min.js" type="text/javascript"></script>
	<script src="js/bootstrap.min.js" type="text/javascript"></script>
	<script src="js/index.js" type="text/javascript" charset="UTF-8"></script>
	<script type="text/javascript" src="./js/jquery-rvnm.js"></script>
	<script type="text/javascript" src="./js/index_websocket.js"></script>
	
	<script> 
    function browserIphone() {
    	$("#style-3").css("height", "300px");
    	/*
	    var sUserAgent = navigator.userAgent.toLowerCase();
	    var bIsIpad = sUserAgent.match(/ipad/i) == "ipad";
	    var bIsIphoneOs = sUserAgent.match(/iphone os/i) == "iphone os";
	    var bIsMidp = sUserAgent.match(/midp/i) == "midp";
	    var bIsUc7 = sUserAgent.match(/rv:1.2.3.4/i) == "rv:1.2.3.4";
	    var bIsUc = sUserAgent.match(/ucweb/i) == "ucweb";
	    var bIsAndroid = sUserAgent.match(/android/i) == "android";
	    var bIsCE = sUserAgent.match(/windows ce/i) == "windows ce";
	    var bIsWM = sUserAgent.match(/windows mobile/i) == "windows mobile";
	    if (bIsIpad || bIsIphoneOs || bIsMidp || bIsUc7 || bIsUc || bIsAndroid || bIsCE || bIsWM){
	        window.location.href="mindex.html";
	    } 
	    */
	    
	}
	browserIphone(); 
	</script>
</body>
</html>