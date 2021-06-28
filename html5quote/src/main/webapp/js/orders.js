$(function() {
	//getChart("index");
	//getStrategy();
	$("#strategyEdit").hide();
	getPosition();
});


function changeStrategy(orderid,orderCode,strategy_id,type){
	$("#orderID").val(orderid);
	$("#orderCode").val(orderCode);
	$("#strategyChangeID").val(strategy_id);
	$("#strategyChangeType").val(type);
	$("#strategyEdit").show();
}
function saveOrderStrategy(){
	$.ajax({
		type : 'POST',
		url : 'saveOrderStrategy.html',
		data : {
			id:$("#orderID").val(),strategyid:$("#strategyChangeID").val(),type:$("#strategyChangeType").val()
		},
		contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
		dataType : 'json',
		success : function(data) {
			if(data.status=="0"){
				alert("转移策略失败");
			}else if(data.status=="1"){
				alert("保存成功");
				$("#strategyEdit").hide();
			}
		}
	});
}

function hideOrderStrategyDIV(){
	$("#strategyEdit").hide();
}

function getStrategy(){
	$("#strategyID").empty();
	$.ajax({
		type : 'POST',
		url : 'findStrategy.html',
		data : {
			
		},
		contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
		dataType : 'json',
		success : function(data) {
			for (var i = 0; i < data.strategyList.length; i++) {
				$("#strategyID").append("<option value="+data.strategyList[i].id+">"+data.strategyList[i].name+"</option>");
		    	$("#strategyChangeID").append("<option value="+data.strategyList[i].id+">"+data.strategyList[i].name+"</option>");
			}
		}
	});
}

function getPosition(){
	$("#mainrightOrdersNav1").css("background-color", "#4B306C");
	$("#mainrightOrdersNav2").css("background-color", "#000000");
	$("#mainrightOrdersNav3").css("background-color", "#000000");
	$("#mainrightOrdersNav4").css("background-color", "#000000");
	$.ajax({
		type : 'POST',
		url : 'findPosition.html',
		data : {
			strategyID:$("#strategyID").val()
		},
		contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
		dataType : 'json',
		success : function(data) {
			$("#style-4").empty();
			var strDiv = "";
			var row = 0;
			for (var i = 0; i < data.ordersList.length; i++) {
				
				if(row==0){
					row ++;
					strDiv += "<div  class=\"container-fluid\">";
					strDiv += "<div  class=\"row\">";
					strDiv += "<div class=\"mainrightZhiBiao1 position-fixed fixed-top col-xs-4 col-sm-3 col-md-1 col-lg-1\">";
					strDiv += "合约";
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao1 position-fixed fixed-top col-xs-4 col-sm-3 col-md-1 col-lg-1\">";
					strDiv += "多空";
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao1 position-fixed fixed-top col-xs-4 col-sm-3 col-md-1 col-lg-1\">";
					strDiv += "总仓";
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao1 position-fixed fixed-top col-xs-4 col-sm-3 col-md-2 col-lg-2\">";
					strDiv += "手续费";
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao1 position-fixed fixed-top col-xs-4 col-sm-3 col-md-2 col-lg-2\">";
					strDiv += "均价";
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao1 position-fixed fixed-top col-xs-4 col-sm-3 col-md-2 col-lg-2\">";
					strDiv += "浮盈";
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao1 position-fixed fixed-top col-xs-4 col-sm-3 col-md-2 col-lg-2\">";
					strDiv += "风险";
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao1 position-fixed fixed-top col-xs-4 col-sm-3 col-md-1 col-lg-1\">";
					strDiv += "操作";
					strDiv += "</div>";
					strDiv += "</div>";
					strDiv += "</div>";
				}
				row ++;
				if(row%2==0){
					strDiv += "<div  class=\"container-fluid\">";
					strDiv += "<div  class=\"row\">";
					strDiv += "<div class=\"mainrightZhiBiao2 col-xs-4 col-sm-3 col-md-1 col-lg-1\" >";
					strDiv += data.ordersList[i].code;
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao2 col-xs-4 col-sm-3 col-md-1 col-lg-1\" >";
					if(data.ordersList[i].direction=="B"){
						strDiv += "多";
					}else{
						strDiv += "空";
					}
					
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao2 col-xs-4 col-sm-3 col-md-1 col-lg-1\" >";
					strDiv += data.ordersList[i].hand;
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao2 col-xs-4 col-sm-3 col-md-2 col-lg-2\" >";
					strDiv += data.ordersList[i].sxf.toFixed(2);
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao2 col-xs-4 col-sm-3 col-md-2 col-lg-2\" >";
					strDiv += data.ordersList[i].open_price;
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao2 col-xs-4 col-sm-3 col-md-2 col-lg-2\" >";
					strDiv += data.ordersList[i].remain_profit;
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao2 col-xs-4 col-sm-3 col-md-2 col-lg-2\" >";
					strDiv += data.ordersList[i].risk.toFixed(2);
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao2 col-xs-4 col-sm-3 col-md-1 col-lg-1\" >";
					strDiv += "<span style=\"cursor:pointer;\" onclick=\"changeStrategy('"+data.ordersList[i].id+"','"+data.ordersList[i].code+"','"+data.ordersList[i].strategy_id+"','pos')\">转策略</span>";
					strDiv += "</div>";
				}else{
					strDiv += "<div  class=\"container-fluid\">";
					strDiv += "<div  class=\"row\">";
					strDiv += "<div class=\"mainrightZhiBiao3 col-xs-4 col-sm-3 col-md-1 col-lg-1\" >";
					strDiv += data.ordersList[i].code;
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao3 col-xs-4 col-sm-3 col-md-1 col-lg-1\" >";
					if(data.ordersList[i].direction=="B"){
						strDiv += "多";
					}else{
						strDiv += "空";
					}
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao3 col-xs-4 col-sm-3 col-md-1 col-lg-1\" >";
					strDiv += data.ordersList[i].hand;
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao3 col-xs-4 col-sm-3 col-md-2 col-lg-2\" >";
					strDiv += data.ordersList[i].sxf.toFixed(2);
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao3 col-xs-4 col-sm-3 col-md-2 col-lg-2\" >";
					strDiv += data.ordersList[i].open_price;
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao3 col-xs-4 col-sm-3 col-md-2 col-lg-2\" >";
					strDiv += data.ordersList[i].remain_profit;
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao3 col-xs-4 col-sm-3 col-md-2 col-lg-2\" >";
					strDiv += data.ordersList[i].risk.toFixed(2);
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao3 col-xs-4 col-sm-3 col-md-1 col-lg-1\" >";
					strDiv += "<span style=\"cursor:pointer;\" onclick=\"changeStrategy('"+data.ordersList[i].id+"','"+data.ordersList[i].code+"','"+data.ordersList[i].strategy_id+"','pos')\">转策略</span>";
					strDiv += "</div>";
				}
				
		    }
			strDiv += "</div>";
			strDiv += "</div>";
			$("#style-4").html(strDiv);
		}
	});
}

function getSusPosition(){
	$("#mainrightOrdersNav1").css("background-color", "#000000");
	$("#mainrightOrdersNav2").css("background-color", "#4B306C");
	$("#mainrightOrdersNav3").css("background-color", "#000000");
	$("#mainrightOrdersNav4").css("background-color", "#000000");
	$.ajax({
		type : 'POST',
		url : 'findSusPosition.html',
		data : {
			strategyID:$("#strategyID").val()
		},
		contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
		dataType : 'json',
		success : function(data) {
			$("#style-4").empty();
			var strDiv = "";
			var row = 0;
			for (var i = 0; i < data.susOrdersList.length; i++) {
				if(row==0){
					row ++;
					strDiv += "<div  class=\"container-fluid\">";
					strDiv += "<div  class=\"row\">";
					strDiv += "<div class=\"mainrightZhiBiao1 position-fixed fixed-top col-xs-4 col-sm-3 col-md-2 col-lg-2\">";
					strDiv += "合约";
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao1 position-fixed fixed-top col-xs-4 col-sm-3 col-md-2 col-lg-2\">";
					strDiv += "多空";
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao1 position-fixed fixed-top col-xs-4 col-sm-3 col-md-2 col-lg-2\">";
					strDiv += "总仓";
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao1 position-fixed fixed-top col-xs-4 col-sm-3 col-md-2 col-lg-2\">";
					strDiv += "日期";
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao1 position-fixed fixed-top col-xs-4 col-sm-3 col-md-2 col-lg-2\">";
					strDiv += "均价";
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao1 position-fixed fixed-top col-xs-4 col-sm-3 col-md-2 col-lg-2\">";
					strDiv += "撤单";
					strDiv += "</div>";
					strDiv += "</div>";
					strDiv += "</div>";
				}
				row ++;
				if(row%2==0){
					strDiv += "<div  class=\"container-fluid\">";
					strDiv += "<div  class=\"row\">";
					strDiv += "<div class=\"mainrightZhiBiao2 col-xs-4 col-sm-3 col-md-2 col-lg-2\" onclick=\"getChart('"+data.susOrdersList[i].code+"')\">";
					strDiv += data.susOrdersList[i].code;
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao2 col-xs-4 col-sm-3 col-md-2 col-lg-2\" onclick=\"getChart('"+data.susOrdersList[i].code+"')\">";
					if(data.susOrdersList[i].direction=="B"){
						strDiv += "多";
					}else{
						strDiv += "空";
					}
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao2 col-xs-4 col-sm-3 col-md-2 col-lg-2\" onclick=\"getChart('"+data.susOrdersList[i].code+"')\">";
					strDiv += data.susOrdersList[i].hand;
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao2 col-xs-4 col-sm-3 col-md-2 col-lg-2\" onclick=\"getChart('"+data.susOrdersList[i].code+"')\">";
					strDiv += data.susOrdersList[i].record_date;
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao2 col-xs-4 col-sm-3 col-md-2 col-lg-2\" onclick=\"getChart('"+data.susOrdersList[i].code+"')\">";
					strDiv += data.susOrdersList[i].open_price;
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao2 col-xs-4 col-sm-3 col-md-2 col-lg-2\" onclick=\"getChart('"+data.susOrdersList[i].code+"')\">";
					strDiv += "撤单";
					strDiv += "</div>";
				}else{
					strDiv += "<div  class=\"container-fluid\">";
					strDiv += "<div  class=\"row\">";
					strDiv += "<div class=\"mainrightZhiBiao3 col-xs-4 col-sm-3 col-md-2 col-lg-2\" onclick=\"getChart('"+data.susOrdersList[i].code+"')\">";
					strDiv += data.susOrdersList[i].code;
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao3 col-xs-4 col-sm-3 col-md-2 col-lg-2\" onclick=\"getChart('"+data.susOrdersList[i].code+"')\">";
					if(data.susOrdersList[i].direction=="B"){
						strDiv += "多";
					}else{
						strDiv += "空";
					}
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao3 col-xs-4 col-sm-3 col-md-2 col-lg-2\" onclick=\"getChart('"+data.susOrdersList[i].code+"')\">";
					strDiv += data.susOrdersList[i].hand;
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao3 col-xs-4 col-sm-3 col-md-2 col-lg-2\" onclick=\"getChart('"+data.susOrdersList[i].code+"')\">";
					strDiv += data.susOrdersList[i].record_date;
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao3 col-xs-4 col-sm-3 col-md-2 col-lg-2\" onclick=\"getChart('"+data.susOrdersList[i].code+"')\">";
					strDiv += data.susOrdersList[i].open_price;
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao3 col-xs-4 col-sm-3 col-md-2 col-lg-2\" onclick=\"getChart('"+data.susOrdersList[i].code+"')\">";
					strDiv += "撤单";
					strDiv += "</div>";
				}
		    }
			strDiv += "</div>";
			strDiv += "</div>";
			$("#style-4").html(strDiv);
		}
	});
}
function getClosePosition(){
	$("#mainrightOrdersNav1").css("background-color", "#000000");
	$("#mainrightOrdersNav2").css("background-color", "#000000");
	$("#mainrightOrdersNav3").css("background-color", "#4B306C");
	$("#mainrightOrdersNav4").css("background-color", "#000000");
	var date ="";
	if($("#dateID").val()!=undefined)
	{
		date = $("#dateID").val();
	}
	$.ajax({
		type : 'POST',
		url : 'findClosePosition.html',
		data : {
			date:date,strategyID:$("#strategyID").val()
		},
		contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
		dataType : 'json',
		success : function(data) {
			$("#style-4").empty();
			var strDiv = "";
			var row = 0;
			strDiv += "<div  class=\"container-fluid\">";
			strDiv += "<div  class=\"row\">";
			strDiv += "<div class=\"mainrightClose  col-xs-12 col-sm-12 col-md-12 col-lg-12\">";
			strDiv += "选择日期:<input type=\"text\" value=\""+data.date+"\" id=\"dateID\" size=\"20\"><input type=\"button\" value=\"查询\" onclick=\"getClosePosition()\">";
			strDiv += "</div>";
			strDiv += "</div>";
			strDiv += "</div>";
			for (var i = 0; i < data.closeList.length; i++) {
				if(row==0){
					row ++;
					strDiv += "<div  class=\"container-fluid\">";
					strDiv += "<div  class=\"row\">";
					strDiv += "<div class=\"mainrightZhiBiao1 position-fixed fixed-top col-xs-4 col-sm-3 col-md-2 col-lg-2\">";
					strDiv += "合约";
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao1 position-fixed fixed-top col-xs-4 col-sm-3 col-md-2 col-lg-2\">";
					strDiv += "多空";
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao1 position-fixed fixed-top col-xs-4 col-sm-3 col-md-1 col-lg-1\">";
					strDiv += "总仓";
					strDiv += "</div>";
					
					strDiv += "<div class=\"mainrightZhiBiao1 position-fixed fixed-top col-xs-4 col-sm-3 col-md-2 col-lg-2\">";
					strDiv += "开仓价";
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao1 position-fixed fixed-top col-xs-4 col-sm-3 col-md-2 col-lg-2\">";
					strDiv += "平仓价";
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao1 position-fixed fixed-top col-xs-4 col-sm-3 col-md-2 col-lg-2\">";
					strDiv += "浮盈";
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao1 position-fixed fixed-top col-xs-4 col-sm-3 col-md-1 col-lg-1\">";
					strDiv += "操作";
					strDiv += "</div>";
					strDiv += "</div>";
					strDiv += "</div>";
				}
				row ++;
				if(row%2==0){
					strDiv += "<div  class=\"container-fluid\">";
					strDiv += "<div  class=\"row\">";
					strDiv += "<div class=\"mainrightZhiBiao2 col-xs-4 col-sm-3 col-md-2 col-lg-2\" onclick=\"getChart('"+data.closeList[i].code+"')\">";
					strDiv += data.closeList[i].code;
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao2 col-xs-4 col-sm-3 col-md-2 col-lg-2\" onclick=\"getChart('"+data.closeList[i].code+"')\">";
					if(data.closeList[i].direction=='B'){
						strDiv += "多";
					}else{
						strDiv += "空";
					}
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao2 col-xs-4 col-sm-3 col-md-1 col-lg-1\" onclick=\"getChart('"+data.closeList[i].code+"')\">";
					strDiv += data.closeList[i].hand;
					strDiv += "</div>";
					
					strDiv += "<div class=\"mainrightZhiBiao2 col-xs-4 col-sm-3 col-md-2 col-lg-2\" onclick=\"getChart('"+data.closeList[i].code+"')\">";
					strDiv += data.closeList[i].open_price;
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao2 col-xs-4 col-sm-3 col-md-2 col-lg-2\" onclick=\"getChart('"+data.closeList[i].code+"')\">";
					strDiv += data.closeList[i].close_price;
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao2 col-xs-4 col-sm-3 col-md-2 col-lg-2\" onclick=\"getChart('"+data.closeList[i].code+"')\">";
					strDiv += data.closeList[i].close_profit;
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao2 col-xs-4 col-sm-3 col-md-1 col-lg-1\" onclick=\"getChart('"+data.closeList[i].code+"')\">";
					strDiv += "<span style=\"cursor:pointer;\" onclick=\"changeStrategy('"+data.closeList[i].id+"','"+data.closeList[i].code+"','"+data.closeList[i].strategy_id+"','close')\">转策略</span>";
					strDiv += "</div>";
				}else{
					strDiv += "<div  class=\"container-fluid\">";
					strDiv += "<div  class=\"row\">";
					strDiv += "<div class=\"mainrightZhiBiao3 col-xs-4 col-sm-3 col-md-2 col-lg-2\" onclick=\"getChart('"+data.closeList[i].code+"')\">";
					strDiv += data.closeList[i].code;
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao3 col-xs-4 col-sm-3 col-md-2 col-lg-2\" onclick=\"getChart('"+data.closeList[i].code+"')\">";
					//console.log(data.closeList[i].direction);
					if(data.closeList[i].direction=='B'){
						strDiv += "多";
					}else{
						strDiv += "空";
					}
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao3 col-xs-4 col-sm-3 col-md-1 col-lg-1\" onclick=\"getChart('"+data.closeList[i].code+"')\">";
					strDiv += data.closeList[i].hand;
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao3 col-xs-4 col-sm-3 col-md-2 col-lg-2\" onclick=\"getChart('"+data.closeList[i].code+"')\">";
					strDiv += data.closeList[i].open_price;
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao3 col-xs-4 col-sm-3 col-md-2 col-lg-2\" onclick=\"getChart('"+data.closeList[i].code+"')\">";
					strDiv += data.closeList[i].close_price;
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao3 col-xs-4 col-sm-3 col-md-2 col-lg-2\" onclick=\"getChart('"+data.closeList[i].code+"')\">";
					strDiv += data.closeList[i].close_profit;
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao3 col-xs-4 col-sm-3 col-md-1 col-lg-1\" onclick=\"getChart('"+data.closeList[i].code+"')\">";
					strDiv += "<span style=\"cursor:pointer;\" onclick=\"changeStrategy('"+data.closeList[i].id+"','"+data.closeList[i].code+"','"+data.closeList[i].strategy_id+"','close')\">转策略</span>";
					strDiv += "</div>";
				}
		    }
			strDiv += "</div>";
			strDiv += "</div>";
			$("#style-4").html(strDiv);
		}
	});
}



