$(function() {
	getChart("index");
	getStrategy();
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

