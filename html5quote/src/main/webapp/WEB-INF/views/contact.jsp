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
    <title>王者期货分析系统</title>
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
    <div class="mainrightSuggest">
    	<div class="mainrightSuggestMain">
    	<form id="myForm" action="suggestsave.html" method="post">
    		 <table style="width:30%;color:red;">
    		 	<tr>
    		 		<td>软件作者: </td>
    		 		<td>风和云</td>
    		 	</tr>
    		 	<tr>
    		 		<td>联系QQ: </td>
    		 		<td>3824561</td>
    		 	</tr>
    		 	<tr>
    		 		<td>QQ群号: </td>
    		 		<td>123456</td>
    		 	</tr>
    		 </table>
		</form>
    	</div>
    </div>
    
    <script src="js/jquery-1.11.0.min.js" type="text/javascript"></script>
    <script src="js/suggest.js" type="text/javascript"></script>
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