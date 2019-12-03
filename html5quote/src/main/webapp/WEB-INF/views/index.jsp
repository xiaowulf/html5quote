<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page  isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0;" name="viewport" />
    <title>HTML5行情</title>
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
    		<!--  
    		<div class="mainrightMainLeft">
    		-->
		    	<c:forEach  items="${jysCodeList}" var="list"  varStatus="userStatus">
		    	<div class="mainrightZhiBiao">
			    	<div class="mainrightZhiBiaoNameY">
			    		<c:out value="${list.name}"/>
			    	</div>
			    	<div class="mainrightZhiBiao1">
			    		<c:out value="${list.instrumentID}"/>
			    	</div>
			    	<div class="mainrightZhiBiao2">
			    		<c:out value="${list.openPrice}"/>
			    	</div>
			    	<div class="mainrightZhiBiao2">
			    		<c:out value="${list.highestPrice}"/>
			    	</div>
			    	<div class="mainrightZhiBiao2">
			    		<c:out value="${list.lowestPrice}"/>
			    	</div>
			    	<div class="mainrightZhiBiao2">
			    		<c:out value="${list.closePrice}"/>
			    	</div>
			    	<div class="mainrightZhiBiao2">
			    		<c:out value="${list.settlementPrice}"/>
			    	</div>
			    	<div class="mainrightZhiBiao2">
			    		<c:out value="${list.bidPrice1}"/>
			    	</div>
			    	<div class="mainrightZhiBiao2">
			    		<c:out value="${list.askPrice1}"/>
			    	</div>
			    	<div class="mainrightZhiBiao2">
			    		<c:out value="${list.bidVolume1}"/>
			    	</div>
			    	<div class="mainrightZhiBiao2">
			    		<c:out value="${list.askVolume1}"/>
			    	</div>
			    	<div class="mainrightZhiBiao2">
			    		<c:out value="${list.volume}"/>
			    	</div>
			    	<div class="mainrightZhiBiao2">
			    		<c:out value="${list.cjvolume}"/>
			    	</div>
			    	
		    	</div>
		    	</c:forEach>
		    	<!-- end  mainrightZhiBiao-->
    		<!--
    		</div>
    		-->
    		<!--  
    		<div class="mainrightMainRight">
    			<div class="mainrightMainChart">
    				数据图表
    			</div>
    		</div>
    		-->
    	</div>
    	<!-- end  mainrightMain-->
    	<div class="mainrightBottomNav">
	    	<div class="mainrightBottomNav1" onclick="getJys('shfe')">
	    		上海期货交易所
	    	</div>
	    	<div class="mainrightBottomNav1" onclick="getJys('czce')">
	    		郑州商品交易所
	    	</div>
	    	<div class="mainrightBottomNav1" onclick="getJys('dce')">
	    		大连商品交易所
	    	</div>
	    	<div class="mainrightBottomNav1" onclick="getJys('cffex')">
	    		中国金融交易所
	    	</div>
    	</div>
    	<div class="mainrightBottomNews">
    		<div id="main" style="width: 600px;height:400px;"></div>
    		<script type="text/javascript">
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main'));

        // 指定图表的配置项和数据
        var option = {
            title: {
                text: 'ECharts 入门示例'
            },
            tooltip: {},
            legend: {
                data:['销量']
            },
            xAxis: {
                data: ["衬衫","羊毛衫","雪纺衫","裤子","高跟鞋","袜子"]
            },
            yAxis: {},
            series: [{
                name: '销量',
                type: 'bar',
                data: [5, 20, 36, 10, 10, 20]
            }]
        };

        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
    </script>
    	</div>
    </div>
    
    
    
    
    
    <script src="js/jquery-1.11.0.min.js" type="text/javascript"></script>
    
    
    <script src="js/index.js" type="text/javascript"></script>
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