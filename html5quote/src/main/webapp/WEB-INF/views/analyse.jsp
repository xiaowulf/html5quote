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
<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" name="viewport" />
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
						<div class="mainrightBottomNav">
				    		<div class="mainrightBottomNav1 col-xs-6 col-sm-6 col-md-2 col-lg-2" onclick="getJys('shfe')" id="mainrightBottomNav1">
					    		上期所
					    	</div>
					    	<div class="mainrightBottomNav2  col-xs-6 col-sm-6 col-md-2 col-lg-2" onclick="getJys('czce')" id="mainrightBottomNav2">
					    		郑商所
					    	</div>
					    	<div class="mainrightBottomNav3  col-xs-6 col-sm-6 col-md-2 col-lg-2" onclick="getJys('dce')" id="mainrightBottomNav3">
					    		大商所
					    	</div>
					    	<div class="mainrightBottomNav4  col-xs-6 col-sm-6 col-md-2 col-lg-2" onclick="getJys('cffex')" id="mainrightBottomNav4">
					    		中金所
					    	</div>
					    	<div class="jysButton1  col-xs-6 col-sm-6 col-md-2 col-lg-2" id="mainrightBottomNavMore">
					    		<select class="form-control" id="jyscodeid">...</select>
					    	</div>
					    	<div class="jysButton1  col-xs-6 col-sm-6 col-md-2 col-lg-2" id="mainrightBottomNavMore">
					    		<input class="btn btn-info" type="button" value="Input" onclick="getCodeDetail()">
					    	</div>
			    		</div>
			    		<!-- end mainrightBottomNav -->
					</div>
					<!-- end row -->
					<div class="row">
					<div class="panel panel-default">
					  <div class="panel-heading">基本统计信息</div>
						    <table  class="table table-bordered table-hover table-striped table-responsive">
						    	<tr>
						    		 <td>日期: </td>
						    		 <td>a2005</td>
						    		 <td>收盘: </td>
						    		 <td>a2005</td>
						    	</tr>
						    	<tr>
						    		 		<td>开盘价: </td>
						    		 		<td>a2005</td>
						    		 		<td>最高价: </td>
						    		 		<td>a2005</td>
						    		 	</tr>
						    		 	<tr>
						    		 		<td>最低价: </td>
						    		 		<td>a2005</td>
						    		 		<td>收盘价价: </td>
						    		 		<td>a2005</td>
						    		 	</tr>
						    		 	<tr>
						    		 		<td>结算价: </td>
						    		 		<td>a2005</td>
						    		 		<td>昨结价: </td>
						    		 		<td>a2005</td>
						    		 	</tr>
						    		 	<tr>
						    		 		<td>5日均值: </td>
						    		 		<td>a2005</td>
						    		 		<td>20日均值: </td>
						    		 		<td>a2005</td>
						    		 	</tr>
						    		 	<tr>
						    		 		<td>40日均值: </td>
						    		 		<td>a2005</td>
						    		 		<td>60日均值: </td>
						    		 		<td>a2005</td>
						    		 	</tr>
						    		 	<tr>
						    		 		<td>20日最高: </td>
						    		 		<td>a2005</td>
						    		 		<td>20日最低: </td>
						    		 		<td>a2005</td>
						    		 	</tr>
						    		 	<tr>
						    		 		<td>20日ATR: </td>
						    		 		<td>a2005</td>
						    		 		<td>20日RSI: </td>
						    		 		<td>a2005</td>
						    		 	</tr>
						    		 </table>
					</div>
					</div>					
					<!-- end row 
					<div class="row">
						<button style= "text-align:left;" class="btn btn-primary col-xs-12 col-sm-12 col-md-12 col-lg-12" type="button">图表分析 <span class="badge">2</span></button>
					</div>
					-->
					<!-- end row -->
					<div class="row">
					<div class="panel panel-default">
					  <div class="panel-heading">图表统计信息</div>
						<div class="analyseCharts">
				    		<div id="chart1" class="col-xs-12 col-sm-12 col-md-1 col-lg-4" style="height:300px;float:left"></div>
				    		<div id="chart2" class="col-xs-12 col-sm-12 col-md-1 col-lg-4" style="height:300px;float:left"></div>
				    		<div id="chart3" class="col-xs-12 col-sm-12 col-md-1 col-lg-4" style="height:300px;float:left"></div>
				    		<div id="chart4" class="col-xs-12 col-sm-12 col-md-1 col-lg-4" style="height:300px;float:left"></div>
				    		<div id="chart5" class="col-xs-12 col-sm-12 col-md-1 col-lg-4" style="height:300px;float:left"></div>
				    		<div id="chart6" class="col-xs-12 col-sm-12 col-md-1 col-lg-4" style="height:300px;float:left"></div>
				    		<div id="chart7" class="col-xs-12 col-sm-12 col-md-1 col-lg-4" style="height:300px;float:left"></div>
				    		<div id="chart8" class="col-xs-12 col-sm-12 col-md-1 col-lg-4" style="height:300px;float:left"></div>
				    		<div id="chart9" class="col-xs-12 col-sm-12 col-md-1 col-lg-4" style="height:300px;float:left"></div>
			    		</div>
					</div>
					<!-- end pannel -->
					</div>
					<!-- end row -->
					<div class="row">
					<div class="panel panel-default">
					  <div class="panel-heading">结论</div>
					  <table  class="table table-bordered table-hover table-striped table-responsive">
						    	<tr>
						    		 <td>日期: </td>
						    		 <td>a2005</td>
						    		 <td>收盘: </td>
						    		 <td>a2005</td>
						    	</tr>
					</table>
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
	<script src="js/codeutil.js" type="text/javascript" charset="gb2312"></script>
	<script src="js/analyse.js" type="text/javascript" charset="gb2312"></script>
	<!--include plugin js-->
	<script type="text/javascript" src="./js/jquery-rvnm.js"></script>
</body>
</html>