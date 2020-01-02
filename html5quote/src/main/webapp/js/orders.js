$(function() {
	getChart("index");
	getStrategy();
	getPosition();
});
var option_candle = {
		title : {
			text : '期货价格K线',
			textStyle : {
				fontSize : 13
			}
		},
		tooltip : {
			trigger : 'axis'
		},
		legend : {
			data : [ '期货价格K线']
		},
		xAxis : [ {
			type : 'category',
			boundaryGap : false,
			data : []
		} ],
		yAxis : [ {
			type : 'value',
			axisLabel : {
				formatter : '{value}'
			},
			scale : true
		} ],
		series : [ {
			name : 'k线',
			type : 'k',
			data : []
		} ]
	};



function getChart(code) {
	var chart2 = echarts.init(document.getElementById('chart2'));
	$.ajax({
		type : 'POST',
		url : 'findFuturesCodeIndex.html',
		data : {
			code : code
		},
		contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
		dataType : 'json',
		success : function(data) {
			//alert(data.code+decodeURI("价格"));
			//k线
			option_candle.xAxis[0].data = data.dateRtnList;
		    var values = [];
		    for (var i = 0; i < data.candlePriceList.length; i++) {
		    	var categoryData = [];
		        categoryData.push(data.candlePriceList[i].openPrice);
		        categoryData.push(data.candlePriceList[i].closePrice);
		        categoryData.push(data.candlePriceList[i].lowPrice);
		        categoryData.push(data.candlePriceList[i].highPrice);
		        values.push(categoryData);
		    }
			option_candle.series[0].data=values;
			option_candle.title.text = data.code+"K线";
			chart2.setOption(option_candle);
		}
	});
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
		    }
		}
	});
}

function getPosition(){
	$.ajax({
		type : 'POST',
		url : 'findPosition.html',
		data : {
			
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
					strDiv += "可用";
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao1 position-fixed fixed-top col-xs-4 col-sm-3 col-md-2 col-lg-2\">";
					strDiv += "均价";
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao1 position-fixed fixed-top col-xs-4 col-sm-3 col-md-2 col-lg-2\">";
					strDiv += "浮盈";
					strDiv += "</div>";
					strDiv += "</div>";
					strDiv += "</div>";
				}
				row ++;
				if(row%2==0){
					strDiv += "<div  class=\"container-fluid\">";
					strDiv += "<div  class=\"row\">";
					strDiv += "<div class=\"mainrightZhiBiao2 col-xs-4 col-sm-3 col-md-2 col-lg-2\" onclick=\"getChart('"+data.ordersList[i].code+"')\">";
					strDiv += data.ordersList[i].code;
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao2 col-xs-4 col-sm-3 col-md-2 col-lg-2\" onclick=\"getChart('"+data.ordersList[i].code+"')\">";
					strDiv += data.ordersList[i].fangxiang;
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao2 col-xs-4 col-sm-3 col-md-2 col-lg-2\" onclick=\"getChart('"+data.ordersList[i].code+"')\">";
					strDiv += data.ordersList[i].hand;
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao2 col-xs-4 col-sm-3 col-md-2 col-lg-2\" onclick=\"getChart('"+data.ordersList[i].code+"')\">";
					strDiv += data.ordersList[i].remain_hand;
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao2 col-xs-4 col-sm-3 col-md-2 col-lg-2\" onclick=\"getChart('"+data.ordersList[i].code+"')\">";
					strDiv += data.ordersList[i].open_price;
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao2 col-xs-4 col-sm-3 col-md-2 col-lg-2\" onclick=\"getChart('"+data.ordersList[i].code+"')\">";
					strDiv += data.ordersList[i].remain_profit;
					strDiv += "</div>";
				}else{
					strDiv += "<div  class=\"container-fluid\">";
					strDiv += "<div  class=\"row\">";
					strDiv += "<div class=\"mainrightZhiBiao3 col-xs-4 col-sm-3 col-md-2 col-lg-2\" onclick=\"getChart('"+data.ordersList[i].code+"')\">";
					strDiv += data.ordersList[i].code;
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao3 col-xs-4 col-sm-3 col-md-2 col-lg-2\" onclick=\"getChart('"+data.ordersList[i].code+"')\">";
					strDiv += data.ordersList[i].fangxiang;
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao3 col-xs-4 col-sm-3 col-md-2 col-lg-2\" onclick=\"getChart('"+data.ordersList[i].code+"')\">";
					strDiv += data.ordersList[i].hand;
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao3 col-xs-4 col-sm-3 col-md-2 col-lg-2\" onclick=\"getChart('"+data.ordersList[i].code+"')\">";
					strDiv += data.ordersList[i].remain_hand;
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao3 col-xs-4 col-sm-3 col-md-2 col-lg-2\" onclick=\"getChart('"+data.ordersList[i].code+"')\">";
					strDiv += data.ordersList[i].open_price;
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao3 col-xs-4 col-sm-3 col-md-2 col-lg-2\" onclick=\"getChart('"+data.ordersList[i].code+"')\">";
					strDiv += data.ordersList[i].remain_profit;
					strDiv += "</div>";
				}
				
		    }
			strDiv += "</div>";
			strDiv += "</div>";
			$("#style-4").html(strDiv);
		}
	});
}


