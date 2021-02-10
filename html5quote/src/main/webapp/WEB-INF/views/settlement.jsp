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
    <link rel="stylesheet" href="https://code.jquery.com/ui/1.11.0/themes/smoothness/jquery-ui.css">
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
		<div class="row" style="margin-top:50px;">
			<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 alert alert-danger" role="alert">
				<form class="form-inline">
				  <div class="form-group">
				    <div class="input-group">
				      <div class="input-group-addon">结算日期</div>
				      <input type="text" value="${todayStr}" size="50" class="form-control" id="computeDateText" placeholder="输入日期，日期格式为yyyymmdd">
				    </div>
				    <button type="button" class="btn btn-primary" onclick="mergeData()">生成今日数据</button>
					<button type="button" class="btn btn-primary" onclick="computeDayResult()">今日结算</button>
					<button type="button" class="btn btn-primary" onclick="queryResult()">查看结果</button>
				  </div>
				</form>
			</div>
		</div>
		<div class="row" style="margin-top:20px;">
			<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12" style="float:left;">
				<div class="resultMain" id="resultMain">
						
				</div>
			</div>
		</div>
		<div class="row" style="margin-top:20px;">
			<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12" style="float:left;">
				<div class="resultMain" id="resultChartMain">
						<div id="chart_ljyle_detail" class="col-xs-12 col-sm-12 col-md-6 col-lg-6" style="height:300px;float:left"></div>
						<div id="chart_dwjz_detail" class="col-xs-12 col-sm-12 col-md-6 col-lg-6" style="height:300px;float:left"></div>
				</div>
			</div>
		</div>
		<!-- end row -->
	</div>
	<script src="js/jquery-1.11.0.min.js" type="text/javascript"></script>
	<script src="js/bootstrap.min.js" type="text/javascript"></script>
	<script src="js/settlement.js" type="text/javascript" charset="UTF-8"></script>
    <!--include plugin js-->
    <script type="text/javascript" src="./js/jquery-rvnm.js"></script>
    <script
  src="https://code.jquery.com/ui/1.11.0/jquery-ui.min.js"
  integrity="sha256-lCF+55kMUF+3fO/3BiXui4eiUKcQmtr7ecKSeLVDxIQ="
  crossorigin="anonymous"></script>
    <script
		src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"
		integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
		crossorigin="anonymous"></script>
</body>
</html>