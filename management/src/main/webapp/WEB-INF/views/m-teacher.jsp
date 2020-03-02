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
	<link type="text/css" rel="stylesheet" href="./css/main.css" />
	<link type="text/css" rel="stylesheet" href="./css/font-awesome.min.css" />
	<link rel="stylesheet" type="text/css" href="./themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="./themes/icon.css">
	<link rel="stylesheet" type="text/css" href="./css/bootstrap.css">
</head>

<body style="background-color: #ffffff;">
	<div class="container-fluid">
		<div class="row" style="margin-top:20px;">
			<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
				<table class="easyui-datagrid" title="教师管理" style="width:100%;height:600px;"
            data-options="rownumbers:true,singleSelect:true,url:'datagrid_data1.json',method:'get'">
        <thead>
            <tr>
                <th data-options="field:'itemid',width:80">Item ID</th>
                <th data-options="field:'productid',width:100">Product</th>
                <th data-options="field:'listprice',width:80,align:'right'">List Price</th>
                <th data-options="field:'unitcost',width:80,align:'right'">Unit Cost</th>
                <th data-options="field:'attr1',width:240">Attribute</th>
                <th data-options="field:'status',width:60,align:'center'">Status</th>
            </tr>
        </thead>
    </table>
			</div>
		</div>
		<!-- end row -->
	</div>
<script src="js/jquery-1.11.0.min.js" type="text/javascript"></script>
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<script src="js/main.js" type="text/javascript"></script>
</body>
</html>