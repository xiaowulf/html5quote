<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page  isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="constants.jsp"%>
<!DOCTYPE html>
<html lang="zh">
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
</head>

<body>
	<div class="mainleft">
		<div class="mainleft1">
		<jsp:include page="navbar.jsp"></jsp:include>
		</div>
	</div>
    <div class="mainright">
    	<div class="mainrightTop">
    		<!--  
    		<div class="mainrightTop1">
    			期货王者
    		</div>
    		
    		<div class="mainrightTop2">
    			股票
    		</div>
    		-->
    	</div>
    	<div class="mainrightZhiBiaoHead">
			    	<div class="mainrightZhiBiaoNameY">
			    		品种
			    	</div>
			    	<div class="mainrightZhiBiao1">
			    		代码
			    	</div>
			    	<div class="mainrightZhiBiao1">
			    		开盘价
			    	</div>
			    	<div class="mainrightZhiBiao1">
			    		最高价
			    	</div>
			    	<div class="mainrightZhiBiao1">
			    		最低价
			    	</div>
			    	<div class="mainrightZhiBiao1">
			    		收盘价
			    	</div>
			    	<div class="mainrightZhiBiao1">
			    		结算价
			    	</div>
			    	<div class="mainrightZhiBiao1">
			    		买入价
			    	</div>
			    	<div class="mainrightZhiBiao1">
			    		买量
			    	</div>
			    	<div class="mainrightZhiBiao1">
			    		卖出价
			    	</div>
			    	<div class="mainrightZhiBiao1">
			    		卖出价
			    	</div>
			    	<div class="mainrightZhiBiao1">
			    		成量
			    	</div>
			    	<div class="mainrightZhiBiao1">
			    		成交手数
			    	</div>
			    	
		</div>
    	<div class="mainrightMain" id="style-3">
    		
    	</div>
    	<!-- end  mainrightMain-->
    	<div class="mainrightBottomNav">
	    	<div class="mainrightBottomNav1" onclick="getJys('shfe')" id="mainrightBottomNav1">
	    		上海期货交易所
	    	</div>
	    	<div class="mainrightBottomNav2" onclick="getJys('czce')" id="mainrightBottomNav2">
	    		郑州商品交易所
	    	</div>
	    	<div class="mainrightBottomNav3" onclick="getJys('dce')" id="mainrightBottomNav3">
	    		大连商品交易所
	    	</div>
	    	<div class="mainrightBottomNav4" onclick="getJys('cffex')" id="mainrightBottomNav4">
	    		中国金融交易所
	    	</div>
	    	<div class="mainrightBottomNavMore" id="mainrightBottomNavMore" onclick="getMoreChart()">
	    		更多技术分析指标
	    	</div>
    	</div>
    	<div class="mainrightBottomNews">
    		<div id="chart1" style="width:450px;height:300px;float:left"></div>
    		<div id="chart2" style="width:450px;height:300px;float:left"></div>
    		<div id="chart3" style="width:450px;height:300px;float:left"></div>
    	</div>
    </div>
    
    
    
    
    
    <script src="js/jquery-1.11.0.min.js" type="text/javascript"></script>
    
    
    <script src="js/index.js" type="text/javascript"  charset="UTF-8"></script>
    <!--include plugin js-->
    <script type="text/javascript" src="./js/jquery-rvnm.js"></script>
    <!--js run code-->
    <script type="text/javascript">
        $(function () {
            var rvnMenu = $("#navbar").rvnm({
                //                    mode: 'mobile',
                //                    responsive: false,
                searchable: false,
                theme: 'dark'
            });
            console.log(rvnMenu);
            //                rvnMenu.setMode('minimal');
            rvnMenu.setTheme('dark-ruby');
        });
    </script>
    <script> 
		self.moveTo(0,0) 
		self.resizeTo(screen.availWidth,screen.availHeight) 
	</script>
</body>
</html>