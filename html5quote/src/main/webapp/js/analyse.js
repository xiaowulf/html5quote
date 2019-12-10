$(function() {
	getJys("shfe");
	getChart("index");
});
var option_close_settle = {
	title : {
		text : '期货价格',
		textStyle : {
			fontSize : 13
		}
	},
	tooltip : {
		trigger : 'axis'
	},
	legend : {
		data : [ '收盘价格', '结算价格' ]
	},
	toolbox : {
		show : true,
		feature : {
			mark : {
				show : true
			},
			dataView : {
				show : false,
				readOnly : false
			},
			magicType : {
				show : false,
				type : [ 'line', 'bar' ]
			},
			restore : {
				show : false
			},
			saveAsImage : {
				show : false
			}
		}
	},
	calculable : true,
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
		name : '收盘价格',
		type : 'line',
		data : [],
		markPoint : {
			data : [ {
				type : 'max',
				name : '最大值'
			}, {
				type : 'min',
				name : '最小值'
			} ]
		},
		markLine : {
			data : [ {
				type : 'average',
				name : '平均值'
			} ]
		}
	}, {
		name : '结算价格',
		type : 'line',
		data : [],
		markPoint : {
			data : [ {
				type : 'max',
				name : '最大值'
			}, {
				type : 'min',
				name : '最小值'
			} ]
		},
		markLine : {
			data : [ {
				type : 'average',
				name : '平均值'
			} ]
		}
	} ]
};
var option_settleCur = {
		title : {
			text : '期货价格',
			textStyle : {
				fontSize : 13
			}
		},
		tooltip : {
			trigger : 'axis'
		},
		legend : {
			data : [ '结算价格拟合' ]
		},
		toolbox : {
			show : true,
			feature : {
				mark : {
					show : true
				},
				dataView : {
					show : false,
					readOnly : false
				},
				magicType : {
					show : false,
					type : [ 'line', 'bar' ]
				},
				restore : {
					show : false
				},
				saveAsImage : {
					show : false
				}
			}
		},
		calculable : true,
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
		series : [{
			name : '结算价格拟合',
			type : 'line',
			data : [],
			symbol:'none',
			smooth:0.8,
			markPoint : {
				data : [ {
					type : 'max',
					name : '最大值'
				}, {
					type : 'min',
					name : '最小值'
				} ]
			},
			markLine : {
				data : [ {
					type : 'average',
					name : '平均值'
				} ]
			}
		} ]
	};

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
	var chart1 = echarts.init(document.getElementById('chart1'));
	var chart2 = echarts.init(document.getElementById('chart2'));
	var chart3 = echarts.init(document.getElementById('chart3'));
	var chart4 = echarts.init(document.getElementById('chart4'));
	var chart5 = echarts.init(document.getElementById('chart5'));
	var chart6 = echarts.init(document.getElementById('chart6'));
	var chart7 = echarts.init(document.getElementById('chart7'));
	var chart8 = echarts.init(document.getElementById('chart8'));
	var chart9 = echarts.init(document.getElementById('chart9'));
	$.ajax({
		type : 'GET',
		url : 'findFuturesCodeIndex.html',
		data : {
			code : code
		},
		contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
		dataType : 'json',
		success : function(data) {
			//alert(data.code+decodeURI("价格"));
			option_close_settle.title.text = data.code+"价格";
			option_close_settle.xAxis[0].data = data.dateRtnList;
			option_close_settle.series[0].data=data.closePriceList;
			option_close_settle.series[1].data=data.settlePriceList;
			option_settleCur.title.text = data.code+"结算价拟合";
			option_settleCur.xAxis[0].data = data.dateRtnList;
			option_settleCur.series[0].data=data.settlePriceCurList;
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
			console.log(values);
			//收盘价和结算价曲线
			chart1.setOption(option_close_settle);
			//结算价格拟合
			chart2.setOption(option_candle);
			chart3.setOption(option_settleCur);
			chart4.setOption(option_close_settle);
			chart5.setOption(option_candle);
			chart6.setOption(option_settleCur);
			chart7.setOption(option_close_settle);
			chart8.setOption(option_candle);
			chart9.setOption(option_settleCur);
		}
	});
}

function getMoreChart(){
	self.location.href='analyse.html'
}

function getJys(jys) {
	if (jys == "shfe") {
		$("#mainrightBottomNav1").css("background-color", "#4B306C");
		$("#mainrightBottomNav2").css("background-color", "#000000");
		$("#mainrightBottomNav3").css("background-color", "#000000");
		$("#mainrightBottomNav4").css("background-color", "#000000");
	} else if (jys == "czce") {
		$("#mainrightBottomNav1").css("background-color", "#000000");
		$("#mainrightBottomNav2").css("background-color", "#4B306C");
		$("#mainrightBottomNav3").css("background-color", "#000000");
		$("#mainrightBottomNav4").css("background-color", "#000000");
	} else if (jys == "dce") {
		$("#mainrightBottomNav1").css("background-color", "#000000");
		$("#mainrightBottomNav2").css("background-color", "#000000");
		$("#mainrightBottomNav3").css("background-color", "#4B306C");
		$("#mainrightBottomNav4").css("background-color", "#000000");
	} else if (jys == "cffex") {
		$("#mainrightBottomNav1").css("background-color", "#000000");
		$("#mainrightBottomNav2").css("background-color", "#000000");
		$("#mainrightBottomNav3").css("background-color", "#000000");
		$("#mainrightBottomNav4").css("background-color", "#4B306C");
	}
	$.ajax({
		type : 'GET',
		url : 'changeFuturesJys.html',
		data : {
			jys : jys
		},
		dataType : 'json',
		contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
		success : function(data) {
			$("#jyscodeid").empty();
			var strDiv = "";
			for ( var o in data) {
				$('#jyscodeid').append("<option value=\""+data[o].instrumentID +"\">"+getNameByCode(data[o].instrumentID)+data[o].instrumentID+"</option>"); 
			}
			
		}
	});
}

function getCodeDetail(){
	
}

