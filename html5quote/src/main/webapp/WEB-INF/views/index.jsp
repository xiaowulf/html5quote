<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ include file="constants.jsp"%>
<!DOCTYPE html>
<html lang="zh">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0;"
	name="viewport" />
<title><%=appName%></title>
<script src="js/echarts.min.js" type="text/javascript"></script>
<!--awesome font include-->
<link type="text/css" rel="stylesheet" href="./css/main.css" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<link type="text/css" rel="stylesheet" href="./css/font-awesome.min.css" />
<!--include plugin css-->
<link type="text/css" rel="stylesheet" href="./js/jquery-rvnm.css" />
</head>

<body style="background-color: #ffffff;">
	<div class="container-fluid">
		<div class="row">
			<div class="col-xs-1 col-sm-1 col-md-1 col-lg-1">
				<div class="mainleft1">
					<jsp:include page="navbar.jsp"></jsp:include>
				</div>
			</div>
			<div class="col-xs-11 col-sm-11 col-md-11 col-lg-11">
				<div class="container-fluid">
					<div class="row">
						<div class="mainrightMain" id="style-3">
						
						</div>
					</div>
					
					
					<div class="row">
						<div class="mainrightBottomNav">
				    		<div class="mainrightBottomNav1" onclick="getJys('shfe')" id="mainrightBottomNav1">
					    		上期所
					    	</div>
					    	<div class="mainrightBottomNav2" onclick="getJys('czce')" id="mainrightBottomNav2">
					    		郑商所
					    	</div>
					    	<div class="mainrightBottomNav3" onclick="getJys('dce')" id="mainrightBottomNav3">
					    		大商所
					    	</div>
					    	<div class="mainrightBottomNav4" onclick="getJys('cffex')" id="mainrightBottomNav4">
					    		中金所
					    	</div>
					    	<div class="mainrightBottomNavMore" id="mainrightBottomNavMore" onclick="getMoreChart()">
					    		更多指标
					    	</div>
			    		</div>
					</div>
					
					<div class="row">
						<div class="mainrightBottomNews">
				    		<div id="chart1" class="col-xs-12 col-sm-12 col-md-1 col-lg-4" style="height:300px;float:left"></div>
				    		<div id="chart2" class="col-xs-12 col-sm-12 col-md-1 col-lg-4" style="height:300px;float:left"></div>
				    		<div id="chart3" class="col-xs-12 col-sm-12 col-md-1 col-lg-4" style="height:300px;float:left"></div>
			    		</div>
					</div>
					
					
					
					
				</div>
			</div>
		</div>
	</div>



	<script src="js/jquery-1.11.0.min.js" type="text/javascript"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"
		integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
		crossorigin="anonymous"></script>
	<script src="js/index.js" type="text/javascript" charset="UTF-8"></script>
	<!--include plugin js-->
	<script type="text/javascript" src="./js/jquery-rvnm.js"></script>



	<script> 
    function browserRedirect() {
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
	        window.location.href="http://i.m-futures.com/";
	    } 
	    */
	}
	browserRedirect(); 
	</script>
</body>
</html>