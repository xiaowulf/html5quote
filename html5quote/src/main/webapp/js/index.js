

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
			mark : {show : true},
			dataView : {show : false,readOnly : false},
			magicType : {show : false,type : [ 'line', 'bar' ]},
			restore : {show : false},
			saveAsImage : {show : false}
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
			option_close_settle.title.text = data.code+"价格";
			option_close_settle.xAxis[0].data = data.dateRtnList;
			option_close_settle.series[0].data=data.closePriceList;
			option_close_settle.series[1].data=data.settlePriceList;
			option_settleCur.title.text = data.code+"均价拟合";
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
			option_candle.title.text = data.code+"K线";
			//收盘价和结算价曲线
			chart1.setOption(option_close_settle);
			//结算价格拟合
			chart2.setOption(option_candle);
			chart3.setOption(option_settleCur);
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
		type : 'POST',
		url : 'changeFuturesJys.html',
		data : {
			jys : jys
		},
		contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
		dataType : 'json',
		success : function(data) {
			$("#style-3").empty();
			var strDiv = "";
			var row = 0;
			//var firstInstrumentID = "";
			for ( var o in data) {
				//if(firstInstrumentID==""){
				//	firstInstrumentID = data[o].instrumentID;
				//}
				//console.log(data[o].name);
				if(row==0){
					row ++;
					strDiv += "<div  class=\"container-fluid\">";
					strDiv += "<div  class=\"row\">";
					strDiv += "<div class=\"mainrightZhiBiao1 position-fixed fixed-top col-xs-4 col-sm-3 col-md-2 col-lg-1\" onclick=\"getChart('"+data[o].instrumentID+"')\">";
					strDiv += "品种";
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao1 position-fixed fixed-top col-xs-4 col-sm-3 col-md-2 col-lg-1\">";
					strDiv += "开盘";
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao1 position-fixed fixed-top col-xs-4 col-sm-3 col-md-2 col-lg-1\">";
					strDiv += "最高";
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao1 position-fixed fixed-top col-xs-4 col-sm-3 col-md-2 col-lg-1\">";
					strDiv += "最低";
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao1 position-fixed fixed-top col-xs-4 col-sm-3 col-md-2 col-lg-1\">";
					strDiv += "收盘";
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao1 position-fixed fixed-top col-xs-4 col-sm-3 col-md-2 col-lg-1\">";
					strDiv += "结算";
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao1 position-fixed fixed-top col-xs-4 col-sm-3 col-md-2 col-lg-1\">";
					strDiv += "买价";
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao1 position-fixed fixed-top col-xs-4 col-sm-3 col-md-2 col-lg-1\">";
					strDiv += "买量";
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao1 position-fixed fixed-top col-xs-4 col-sm-3 col-md-2 col-lg-1\">";
					strDiv += "卖价";
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao1 position-fixed fixed-top col-xs-4 col-sm-3 col-md-2 col-lg-1\">";
					strDiv += "卖量";
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao1 position-fixed fixed-top col-xs-4 col-sm-3 col-md-2 col-lg-1\">";
					strDiv += "成量";
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao1 position-fixed fixed-top col-xs-4 col-sm-3 col-md-2 col-lg-1\">";
					strDiv += "手数";
					strDiv += "</div>";
					strDiv += "</div>";
					strDiv += "</div>";
				}
				row ++;
				if(row%2==0){
					strDiv += "<div   class=\"container-fluid\">";
					strDiv += "<div  id=\"zhibiaodiv\" class=\"row\">";
					strDiv += "<div class=\"mainrightZhiBiao2 col-xs-4 col-sm-3 col-md-2 col-lg-1\" onclick=\"getChart('"+data[o].instrumentID+"')\">";
					//console.log(data[o].name);
					//console.log("---------------");
					//console.log(decodeURI(data[o].name));
					strDiv += decodeURI(data[o].instrumentID);
					strDiv += "</div>";
					
					strDiv += "<div class=\"mainrightZhiBiao2 col-xs-4 col-sm-3 col-md-2 col-lg-1\"  onclick=\"getChart('"+data[o].instrumentID+"')\">";
					strDiv += "<label id=\""+data[o].instrumentID+"openPrice\">"+data[o].openPrice+"</label>";
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao2 col-xs-4 col-sm-3 col-md-2 col-lg-1\" onclick=\"getChart('"+data[o].instrumentID+"')\">";
					strDiv += "<label id=\""+data[o].instrumentID+"highestPrice\">"+data[o].highestPrice+"</label>";
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao2 col-xs-4 col-sm-3 col-md-2 col-lg-1\" onclick=\"getChart('"+data[o].instrumentID+"')\">";
					strDiv += "<label id=\""+data[o].instrumentID+"lowestPrice\">"+data[o].lowestPrice+"</label>";
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao2 col-xs-4 col-sm-3 col-md-2 col-lg-1\" onclick=\"getChart('"+data[o].instrumentID+"')\">";
					strDiv += "<label id=\""+data[o].instrumentID+"closePrice\">"+data[o].closePrice+"</label>";
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao2 col-xs-4 col-sm-3 col-md-2 col-lg-1\" onclick=\"getChart('"+data[o].instrumentID+"')\">";
					strDiv += "<label id=\""+data[o].instrumentID+"settlementPrice\">"+data[o].settlementPrice+"</label>";
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao2 col-xs-4 col-sm-3 col-md-2 col-lg-1\"  onclick=\"getChart('"+data[o].instrumentID+"')\">";
					strDiv += "<label id=\""+data[o].instrumentID+"bidPrice1\">"+data[o].bidPrice1+"</label>";
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao2 col-xs-4 col-sm-3 col-md-2 col-lg-1\" onclick=\"getChart('"+data[o].instrumentID+"')\">";
					strDiv += "<label id=\""+data[o].instrumentID+"bidVolume1\">"+data[o].bidVolume1+"</label>";
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao2 col-xs-4 col-sm-3 col-md-2 col-lg-1\" onclick=\"getChart('"+data[o].instrumentID+"')\">";
					strDiv += "<label id=\""+data[o].instrumentID+"askPrice1\">"+ data[o].askPrice1+"</label>";
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao2 col-xs-4 col-sm-3 col-md-2 col-lg-1\" onclick=\"getChart('"+data[o].instrumentID+"')\">";
					strDiv += "<label id=\""+data[o].instrumentID+"askVolume1\">"+ data[o].askVolume1+"</label>";
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao2 col-xs-4 col-sm-3 col-md-2 col-lg-1\" onclick=\"getChart('"+data[o].instrumentID+"')\">";
					strDiv += "<label id=\""+data[o].instrumentID+"volume\">"+ data[o].volume+"</label>";
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao2 col-xs-4 col-sm-3 col-md-2 col-lg-1\" onclick=\"getChart('"+data[o].instrumentID+"')\">";
					strDiv += "<label id=\""+data[o].instrumentID+"ccvolume\">"+ data[o].ccvolume+"</label>";
					strDiv += "</div>";
					strDiv += "</div>";
					strDiv += "</div>";
				}else{
					strDiv += "<div   class=\"container-fluid\">";
					strDiv += "<div  id=\"zhibiaodiv\" class=\"row\">";
					strDiv += "<div class=\"mainrightZhiBiao3 col-xs-4 col-sm-3 col-md-2 col-lg-1\" onclick=\"getChart('"+data[o].instrumentID+"')\">";
					//console.log(data[o].name);
					//console.log("---------------");
					//console.log(decodeURI(data[o].name));
					strDiv += decodeURI(data[o].instrumentID);
					strDiv += "</div>";
					
					strDiv += "<div class=\"mainrightZhiBiao3 col-xs-4 col-sm-3 col-md-2 col-lg-1\" onclick=\"getChart('"+data[o].instrumentID+"')\">";
					strDiv += data[o].openPrice;
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao3 col-xs-4 col-sm-3 col-md-2 col-lg-1\" onclick=\"getChart('"+data[o].instrumentID+"')\">";
					strDiv += data[o].highestPrice;
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao3 col-xs-4 col-sm-3 col-md-2 col-lg-1\" onclick=\"getChart('"+data[o].instrumentID+"')\">";
					strDiv += data[o].lowestPrice;
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao3 col-xs-4 col-sm-3 col-md-2 col-lg-1\" onclick=\"getChart('"+data[o].instrumentID+"')\">";
					strDiv += data[o].closePrice;
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao3 col-xs-4 col-sm-3 col-md-2 col-lg-1\" onclick=\"getChart('"+data[o].instrumentID+"')\">";
					strDiv += data[o].settlementPrice;
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao3 col-xs-4 col-sm-3 col-md-2 col-lg-1\" onclick=\"getChart('"+data[o].instrumentID+"')\">";
					strDiv += data[o].bidPrice1;
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao3 col-xs-4 col-sm-3 col-md-2 col-lg-1\" onclick=\"getChart('"+data[o].instrumentID+"')\">";
					strDiv += data[o].bidVolume1;
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao3 col-xs-4 col-sm-3 col-md-2 col-lg-1\" onclick=\"getChart('"+data[o].instrumentID+"')\">";
					strDiv += data[o].askPrice1;
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao3 col-xs-4 col-sm-3 col-md-2 col-lg-1\" onclick=\"getChart('"+data[o].instrumentID+"')\">";
					strDiv += data[o].askVolume1;
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao3 col-xs-4 col-sm-3 col-md-2 col-lg-1\" onclick=\"getChart('"+data[o].instrumentID+"')\">";
					strDiv += data[o].volume;
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao3 col-xs-4 col-sm-3 col-md-2 col-lg-1\" onclick=\"getChart('"+data[o].instrumentID+"')\">";
					strDiv += data[o].ccvolume;
					strDiv += "</div>";
					strDiv += "</div>";
					strDiv += "</div>";
				}
					
				
			}
			strDiv += "<div  class=\"container-fluid\">";
			strDiv += "<div  class=\"row\">";
			strDiv += "<div class=\"mainrightZhiBiao1 position-fixed fixed-top col-xs-4 col-sm-3 col-md-2 col-lg-1\" onclick=\"getChart('"+data[o].instrumentID+"')\">";
			strDiv += "品种";
			strDiv += "</div>";
			strDiv += "<div class=\"mainrightZhiBiao1 position-fixed fixed-top col-xs-4 col-sm-3 col-md-2 col-lg-1\">";
			strDiv += "开盘";
			strDiv += "</div>";
			strDiv += "<div class=\"mainrightZhiBiao1 position-fixed fixed-top col-xs-4 col-sm-3 col-md-2 col-lg-1\">";
			strDiv += "最高";
			strDiv += "</div>";
			strDiv += "<div class=\"mainrightZhiBiao1 position-fixed fixed-top col-xs-4 col-sm-3 col-md-2 col-lg-1\">";
			strDiv += "最低";
			strDiv += "</div>";
			strDiv += "<div class=\"mainrightZhiBiao1 position-fixed fixed-top col-xs-4 col-sm-3 col-md-2 col-lg-1\">";
			strDiv += "收盘";
			strDiv += "</div>";
			strDiv += "<div class=\"mainrightZhiBiao1 position-fixed fixed-top col-xs-4 col-sm-3 col-md-2 col-lg-1\">";
			strDiv += "结算";
			strDiv += "</div>";
			strDiv += "<div class=\"mainrightZhiBiao1 position-fixed fixed-top col-xs-4 col-sm-3 col-md-2 col-lg-1\">";
			strDiv += "买价";
			strDiv += "</div>";
			strDiv += "<div class=\"mainrightZhiBiao1 position-fixed fixed-top col-xs-4 col-sm-3 col-md-2 col-lg-1\">";
			strDiv += "买量";
			strDiv += "</div>";
			strDiv += "<div class=\"mainrightZhiBiao1 position-fixed fixed-top col-xs-4 col-sm-3 col-md-2 col-lg-1\">";
			strDiv += "卖价";
			strDiv += "</div>";
			strDiv += "<div class=\"mainrightZhiBiao1 position-fixed fixed-top col-xs-4 col-sm-3 col-md-2 col-lg-1\">";
			strDiv += "卖量";
			strDiv += "</div>";
			strDiv += "<div class=\"mainrightZhiBiao1 position-fixed fixed-top col-xs-4 col-sm-3 col-md-2 col-lg-1\">";
			strDiv += "成量";
			strDiv += "</div>";
			strDiv += "<div class=\"mainrightZhiBiao1 position-fixed fixed-top col-xs-4 col-sm-3 col-md-2 col-lg-1\">";
			strDiv += "手数";
			strDiv += "</div>";
			strDiv += "</div>";
			strDiv += "</div>";
			$("#style-3").html(strDiv);
		}
	});
}
