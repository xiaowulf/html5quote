$(function() {
	getJys("shfe");
	getChart("index");
});
var option_close_settle = {
	title : {
		text : '期货价格',
		textStyle : {
			fontSize : 13
		},
		padding : [ 5, 50 ]
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
				show : true,
				readOnly : false
			},
			magicType : {
				show : true,
				type : [ 'line', 'bar' ]
			},
			restore : {
				show : true
			},
			saveAsImage : {
				show : true
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

// 基于准备好的dom，初始化echarts实例

// 指定图表的配置项和数据
var option = {
	title : {
		text : 'ECharts 入门示例'
	},
	tooltip : {},
	legend : {
		data : [ '销量' ]
	},
	xAxis : {
		data : [ "衬衫", "羊毛衫", "雪纺衫", "裤子", "高跟鞋", "袜子" ]
	},
	yAxis : {},
	series : [ {
		name : '销量',
		type : 'bar',
		data : [ 5, 20, 36, 10, 10, 20 ]
	} ]
};


function getChart(code) {
	var chart1 = echarts.init(document.getElementById('chart1'));
	var data_closeprice_series = [];
	var data_closeprice_xAxis = [];
	$.ajax({
		type : 'POST',
		url : 'findFuturesCodeIndex.html',
		data : {
			code : code
		},
		dataType : 'json',
		success : function(data) {
			chart1.setOption(option_close_settle);
			console.log("------------------");
		}
	});
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
		dataType : 'json',
		success : function(data) {
			$("#style-3").empty();
			var strDiv = "";
			//var firstInstrumentID = "";
			for ( var o in data) {
				//if(firstInstrumentID==""){
				//	firstInstrumentID = data[o].instrumentID;
				//}
				strDiv += "<div class=\"mainrightZhiBiao\">";
				strDiv += "<div class=\"mainrightZhiBiaoNameY\">";
				strDiv += data[o].name;
				strDiv += "</div>";
				strDiv += "<div class=\"mainrightZhiBiao2\">";
				strDiv += data[o].instrumentID;
				strDiv += "</div>";
				strDiv += "<div class=\"mainrightZhiBiao2\">";
				strDiv += data[o].openPrice;
				strDiv += "</div>";
				strDiv += "<div class=\"mainrightZhiBiao2\">";
				strDiv += data[o].highestPrice;
				strDiv += "</div>";
				strDiv += "<div class=\"mainrightZhiBiao2\">";
				strDiv += data[o].lowestPrice;
				strDiv += "</div>";
				strDiv += "<div class=\"mainrightZhiBiao2\">";
				strDiv += data[o].closePrice;
				strDiv += "</div>";
				strDiv += "<div class=\"mainrightZhiBiao2\">";
				strDiv += data[o].settlementPrice;
				strDiv += "</div>";
				strDiv += "<div class=\"mainrightZhiBiao2\">";
				strDiv += data[o].bidPrice1;
				strDiv += "</div>";
				strDiv += "<div class=\"mainrightZhiBiao2\">";
				strDiv += data[o].bidVolume1;
				strDiv += "</div>";
				strDiv += "<div class=\"mainrightZhiBiao2\">";
				strDiv += data[o].askPrice1;
				strDiv += "</div>";
				strDiv += "<div class=\"mainrightZhiBiao2\">";
				strDiv += data[o].askVolume1;
				strDiv += "</div>";
				strDiv += "<div class=\"mainrightZhiBiao2\">";
				strDiv += data[o].volume;
				strDiv += "</div>";
				strDiv += "<div class=\"mainrightZhiBiao2\">";
				strDiv += data[o].ccvolume;
				strDiv += "</div>";
				strDiv += "</div>";
			}
			$("#style-3").html(strDiv);
		}
	});
}
