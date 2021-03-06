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
						<div class="mainrightBottomNav">
				    		<div class="mainrightBottomNav1 col-xs-6 col-sm-6 col-md-2 col-lg-2" onclick="getJys('shfe')" id="mainrightBottomNav1">
					    		<spring:message code="jys_shfe"/>
					    	</div>
					    	<div class="mainrightBottomNav2  col-xs-6 col-sm-6 col-md-2 col-lg-2" onclick="getJys('czce')" id="mainrightBottomNav2">
					    		<spring:message code="jys_czce"/>
					    	</div>
					    	<div class="mainrightBottomNav3  col-xs-6 col-sm-6 col-md-2 col-lg-2" onclick="getJys('dce')" id="mainrightBottomNav3">
					    		<spring:message code="jys_dce"/>
					    	</div>
					    	<div class="mainrightBottomNav4  col-xs-6 col-sm-6 col-md-2 col-lg-2" onclick="getJys('cffex')" id="mainrightBottomNav4">
					    		<spring:message code="jys_cffex"/>
					    	</div>
					    	<div class="jysButton1  col-xs-6 col-sm-6 col-md-2 col-lg-2" id="mainrightBottomNavMore">
					    		<select class="form-control" id="jyscodeid" onchange="getCodeDetail()"></select>
					    	</div>
					    	<div class="jysButton1  col-xs-6 col-sm-6 col-md-2 col-lg-2" id="mainrightBottomNavMore">
					    		<input class="btn btn-info" type="button" value="<spring:message code="system_query_title"/>" onclick="getCodeDetail()">
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
						    		 <td>时间: </td>
						    		 <td><label id="todayStrID"></label></td>
						    		 <td>品种: </td>
						    		 <td><label id="instrumentID"></label></td>
						    		 
						    	</tr>
						    	<tr>
						    		 <td>开盘价: </td>
						    		 <td><label id="openpriceID"></label></td>
						    		 <td>收盘价: </td>
						    		 <td><label id="closepriceID"></label></td>
						    	</tr>
						    	<tr>
						    		 <td>最高价: </td>
						    		 <td><label id="highestpriceID"></label></td>
						    		 <td>最低价: </td>
						    		 <td><label id="lowestpriceID"></label></td>
						    	</tr>
						    	<tr>
						    		 <td>20日最高价: </td>
						    		 <td><label id="highest20priceID"></label></td>
						    		 <td>20日最低价: </td>
						    		 <td><label id="lowest20priceID"></label></td>
						    	</tr>
						    	<tr>
						    		 <td>结算价: </td>
						    		 <td><label id="settlepriceID"></label></td>
						    		 <td>昨结价: </td>
						    		 <td><label id="presettlepriceID"></label></td>
						    	</tr>
						    		 	<tr>
						    		 		<td>5日均值: </td>
						    		 		<td><label id="macd5ID"></label></td>
						    		 		<td>10日均值: </td>
						    		 		<td><label id="macd10ID"></label></td>
						    		 	</tr>
						    		 	<tr>
						    		 		<td>20日均值: </td>
						    		 		<td><label id="macd20ID"></label></td>
						    		 		<td>40日均值: </td>
						    		 		<td><label id="macd40ID"></label></td>
						    		 	</tr>
						    		 	<tr>
						    		 		<td>60日均值: </td>
						    		 		<td><label id="macd60ID"></label></td>
						    		 		<td>20日ATR: </td>
						    		 		<td><label id="atrID"></label></td>
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
					<div class="analyseCharts">
				    		<div id="chart1" class="col-xs-12 col-sm-12 col-md-12 col-lg-4" style="height:300px;float:left"></div>
				    		<div id="chart3" class="col-xs-12 col-sm-12 col-md-12 col-lg-4" style="height:300px;float:left"></div>
				    		<div id="chart9" class="col-xs-12 col-sm-12 col-md-12 col-lg-4" style="height:300px;float:left"></div>
				    		
				    		<div id="chart4" class="col-xs-12 col-sm-12 col-md-12 col-lg-4" style="height:300px;float:left"></div>
				    		<div id="chart7" class="col-xs-12 col-sm-12 col-md-12 col-lg-4" style="height:300px;float:left"></div>
				    		<div id="chart2" class="col-xs-12 col-sm-12 col-md-12 col-lg-4" style="height:300px;float:left"></div>
				    		
				    		
				    		<div id="chart6" class="col-xs-12 col-sm-12 col-md-12 col-lg-4" style="height:300px;float:left"></div>
				    		<div id="chart5" class="col-xs-12 col-sm-12 col-md-12 col-lg-4" style="height:300px;float:left"></div>
				    		<div id="chart8" class="col-xs-12 col-sm-12 col-md-12 col-lg-4" style="height:300px;float:left"></div>
				    		
			    	</div>
					</div>
					<!-- end row -->
					<!-- 
					<div class="row">
					<div class="panel panel-default">
					  <div class="panel-heading">结论</div>
					  <table  class="table table-bordered table-hover table-striped table-responsive">
						    <tr>
						    		 <td><span class="badge">1</span><spring:message code="strategy_one_title"/></td>
						    		 <td>
						    		 <label id="strategyID1"></label>
						    		 </td>
						    </tr>
						    <tr>
						    		 <td><span class="badge">2</span><spring:message code="strategy_two_title"/></td>
						    		 <td>
						    		 <label id="strategyID2"></label>
						    		 </td>
						    </tr>
						    <tr>
						    		 <td><span class="badge">3</span><spring:message code="strategy_three_title"/></td>
						    		 <td>
						    		 <label id="strategyID3"></label>
						    		 </td>
						    </tr>
						    <tr>
						    		 <td><span class="badge">4</span><spring:message code="strategy_four_title"/></td>
						    		 <td>
						    		 <label id="strategyID4"></label>
						    		 </td>
						    </tr>
						    <tr>
						    		 <td><span class="badge">5</span><spring:message code="strategy_five_title"/></td>
						    		 <td>
						    		 <label id="strategyID5"></label>
						    		 </td>
						    </tr>
						    <tr>
						    		 <td><span class="badge">6</span><spring:message code="strategy_six_title"/></td>
						    		 <td>
						    		 <label id="strategyID6"></label>
						    		 </td>
						    </tr>
					</table>
					</div>
					</div>
					-->
					<!-- end row -->
					
					
					
				</div>
			</div>
	</div>


	<script src="js/jquery-1.11.0.min.js" type="text/javascript"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"
		integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
		crossorigin="anonymous"></script>
	<script src="js/codeutil.js" type="text/javascript" charset="UTF-8"></script>
	<script src="js/analyse.js" type="text/javascript" charset="UTF-8"></script>
	<!--include plugin js-->
	<script type="text/javascript" src="./js/jquery-rvnm.js"></script>
</body>
</html>