<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>HTML5行情</title>

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
    		<div class="mainrightTop1">
    			期货
    		</div>
    		<div class="mainrightTop2">
    			股票
    		</div>
    		<div class="mainrightTop3">
    			外汇
    		</div>
    	</div>
    	<div class="mainrightZhiBiao">
	    	<div class="mainrightZhiBiao1">
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
    	</div>
    	<div class="mainrightBottomNav">
	    	<div class="mainrightBottomNav1">
	    		上海期货交易所
	    	</div>
	    	<div class="mainrightBottomNav1">
	    		郑州商品交易所
	    	</div>
	    	<div class="mainrightBottomNav1">
	    		大连商品交易所
	    	</div>
	    	<div class="mainrightBottomNav1">
	    		中国金融交易所
	    	</div>
    	</div>
    	<div class="mainrightBottomNews">
    	ddd
    	</div>
    </div>
    
    
    
    
    
    <script src="js/jquery-1.11.0.min.js" type="text/javascript"></script>
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
</body>
</html>