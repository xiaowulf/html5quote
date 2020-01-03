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
				  <label>权益：</label><label>可用：</label><label>使用率：</label>
			</div>
			<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
				<form class="form-inline">
				  <div class="form-group">
				    <div class="input-group">
				      <div class="input-group-addon">品种</div>
				      <input type="text" class="form-control" id="exampleInputAmount" placeholder="品种">
				    </div>
				    <div class="input-group">
				      <div class="input-group-addon">手数</div>
				      <input type="text" class="form-control" id="exampleInputAmount" placeholder="手数">
				    </div>
				    <div class="input-group">
				      <div class="input-group-addon">价格</div>
				      <input type="text" class="form-control" id="exampleInputAmount" placeholder="价格">
				    </div>
				    <div class="input-group">
					  <div class="input-group-addon">策略</div>
					  <select class="form-control" id="strategyID">
					    
					  </select>
					</div>
				  </div>
				  <button type="submit" class="btn btn-primary">买入F1(22222/35)</button>
				  <button type="submit" class="btn btn-primary">卖出F2(33333/34)</button>
				  <button type="submit" class="btn btn-primary">平仓F3</button>
				</form>
			</div>
		</div>
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
				<!--  
				<div class="mainrightOrdersNav4  col-xs-12 col-sm-12 col-md-3 col-lg-3" onclick="getAllPosition()" id="mainrightOrdersNav4">
					成交
				</div>
				-->
				<div class="orderrightMain" id="style-4">
						
				</div>
			</div>
			<div class="col-xs-12 col-sm-12 col-md-6 col-lg-6" style="height:500px;float:left;border-left:1px solid #EEEEEE;border-top:1px solid #EEEEEE;border-bottom:1px solid #EEEEEE;">
				<div class="mainrightOrdersNav1 col-xs-12 col-sm-12 col-md-3 col-lg-3" onclick="getPosdddition('shfe')" id="mainrightBottomNav1">
					分时
				</div>
				<div class="mainrightOrdersNav2  col-xs-12 col-sm-12 col-md-3 col-lg-3" onclick="getJys('czce')" id="mainrightBottomNav2">
					K线
				</div>
				<div class="mainrightOrdersNav3  col-xs-12 col-sm-12 col-md-3 col-lg-3" onclick="getJys('czce')" id="mainrightBottomNav2">
					盘口
				</div>
				<div class="mainrightOrdersNav4  col-xs-12 col-sm-12 col-md-3 col-lg-3" onclick="getJys('czce')" id="mainrightBottomNav2">
					资讯
				</div>
				<div class="orderrightMain" id="style-4">
						<div id="chart2" class="col-xs-12 col-sm-12 col-md-12 col-lg-12" style="height:400px;float:left;"></div>
				</div>
			</div>
			
		</div>
		
	</div>
	<script src="js/jquery-1.11.0.min.js" type="text/javascript"></script>
	<script src="js/bootstrap.min.js" type="text/javascript"></script>
	<script src="js/orders.js" type="text/javascript" charset="UTF-8"></script>
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
	<script>
	  $( function() {
	    $( "#tabs" ).tabs();
	  } );
	  </script>
</body>
</html>