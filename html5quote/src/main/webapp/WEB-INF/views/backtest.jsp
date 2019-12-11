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
						<div class="panel panel-warning">
						  <div class="panel-heading">
						    <h3 class="panel-title"><span class="badge">1</span><spring:message code="strategy_one_title"/></h3>
						  </div>
						  <div class="panel-body">
						    <spring:message code="strategy_result_title"/>
						  </div>
						</div>
						<div class="panel panel-warning">
						  <div class="panel-heading">
						    <h3 class="panel-title"><span class="badge">2</span><spring:message code="strategy_two_title"/></h3>
						  </div>
						  <div class="panel-body">
						    <spring:message code="strategy_result_title"/>
						  </div>
						</div>
						<div class="panel panel-warning">
						  <div class="panel-heading">
						    <h3 class="panel-title"><span class="badge">3</span><spring:message code="strategy_three_title"/></h3>
						  </div>
						  <div class="panel-body">
						    <spring:message code="strategy_result_title"/>
						  </div>
						</div>
						<div class="panel panel-warning">
						  <div class="panel-heading">
						    <h3 class="panel-title"><span class="badge">4</span><spring:message code="strategy_four_title"/></h3>
						  </div>
						  <div class="panel-body">
						    <spring:message code="strategy_result_title"/>
						  </div>
						</div>
						<div class="panel panel-warning">
						  <div class="panel-heading">
						    <h3 class="panel-title"><span class="badge">5</span><spring:message code="strategy_five_title"/></h3>
						  </div>
						  <div class="panel-body">
						    <spring:message code="strategy_result_title"/>
						  </div>
						</div>
						<div class="panel panel-warning">
						  <div class="panel-heading">
						    <h3 class="panel-title"><span class="badge">6</span><spring:message code="strategy_six_title"/></h3>
						  </div>
						  <div class="panel-body">
						    <spring:message code="strategy_result_title"/>
						  </div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

    
    <script src="js/jquery-1.11.0.min.js" type="text/javascript"></script>
    <script src="js/suggest.js" type="text/javascript"></script>
    <!--include plugin js-->
    <script type="text/javascript" src="./js/jquery-rvnm.js"></script>
    <script
		src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"
		integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
		crossorigin="anonymous"></script>
</body>
</html>