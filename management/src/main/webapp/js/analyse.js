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
var option_ccvolume = {
		title : {
			text : '持仓',
			textStyle : {
				fontSize : 13
			}
		},
		tooltip : {
			trigger : 'axis'
		},
		legend : {
			data : [ '持仓' ]
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
			name : '持仓',
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
		}]
	};


var option_volume = {
		title : {
			text : '成交量',
			textStyle : {
				fontSize : 13
			}
		},
		tooltip : {
			trigger : 'axis'
		},
		legend : {
			data : [ '成交量' ]
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
			name : '成交量',
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
		}]
	};

var option_macd = {
		title : {
			text : 'MACD',
			textStyle : {
				fontSize : 13
			}
		},
		tooltip : {
			trigger : 'axis'
		},
		legend : {
			data : [ '5日', '10日', '20日', '40日', '60日' ]
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
			name : '5日',
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
			name : '10日',
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
			name : '20日',
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
			name : '40日',
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
			name : '60日',
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
			data : [ '收盘拟合', '结算拟合' ]
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
			name : '收盘拟合',
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
		},
		{
			name : '结算拟合',
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

var option_vdivcc = {
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
			data : [ '成交持仓比' ]
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
			name : '成交持仓比',
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
		}]
	};
var option_closeprice_deri = {
		title : {
			text : '收盘价导数',
			textStyle : {
				fontSize : 13
			}
		},
		tooltip : {
			trigger : 'axis'
		},
		legend : {
			data : [ '收盘价导数','结算价导数' ]
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
			name : '收盘价导数',
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
		},{
			name : '结算价导数',
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
		}]
	};


var option_macdCur = {
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
			data : [ '5日', '10日', '20日', '40日', '60日' ]
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
			name : '5日',
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
		},
		{
			name : '10日',
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
		},
		{
			name : '20日',
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
		},
		{
			name : '40日',
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
		},
		{
			name : '60日',
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
		}   ]
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
		url : 'findFuturesCharts.html',
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
			
			
			
			
			option_vdivcc.title.text = data.code+"成交持仓比";
			option_vdivcc.xAxis[0].data = data.dateRtnList;
			option_vdivcc.series[0].data=data.vdivccList;
			
			option_settleCur.title.text = data.code+"收盘结算拟合";
			option_settleCur.xAxis[0].data = data.dateRtnList;
			option_settleCur.series[0].data=data.settlePriceCurList;
			option_settleCur.series[1].data=data.closePriceCurList;
			
			//收盘价的导数
			option_closeprice_deri.xAxis[0].data = data.dateRtnList;
			option_closeprice_deri.series[0].data=data.closePriceDeriCurList;
			//结算价的导数
			option_closeprice_deri.series[1].data=data.settlePriceDeriCurList;
			
			option_macdCur.title.text = "MACD拟合";
			option_macdCur.xAxis[0].data = data.dateRtnList;
			option_macdCur.series[0].data=data.macd5CurList;
			option_macdCur.series[1].data=data.macd10CurList;
			option_macdCur.series[2].data=data.macd20CurList;
			option_macdCur.series[3].data=data.macd40CurList;
			option_macdCur.series[4].data=data.macd60CurList;
			
			//k线
			option_candle.xAxis[0].data = data.dateRtnList;
			//macd
			option_macd.xAxis[0].data = data.dateRtnList;
			option_ccvolume.xAxis[0].data = data.dateRtnList;
			option_ccvolume.series[0].data=data.ccVolumeList;
			option_volume.xAxis[0].data = data.dateRtnList;
			option_volume.series[0].data=data.volumeList;
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
			
			//macd
			var values1 = [];
			var values2 = [];
			var values3 = [];
			var values4 = [];
			var values5 = [];
		    for (var i = 0; i < data.macdList.length; i++) {
		    	var categoryData = [];
		    	values1.push(data.macdList[i].macd5);
		    	values2.push(data.macdList[i].macd10);
		    	values3.push(data.macdList[i].macd20);
		    	values4.push(data.macdList[i].macd40);
		    	values5.push(data.macdList[i].macd60);
		        //values.push(categoryData);
		    }
		    //console.log(values1);
		    option_macd.series[0].data=values1;
		    option_macd.series[1].data=values2;
		    option_macd.series[2].data=values3;
		    option_macd.series[3].data=values4;
		    option_macd.series[4].data=values5;
			chart4.setOption(option_macd);
			chart5.setOption(option_ccvolume);
			chart6.setOption(option_volume);
			chart7.setOption(option_macdCur);
			chart8.setOption(option_vdivcc);
			chart9.setOption(option_closeprice_deri);
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
			var code ="";
			for ( var o in data) {
				$('#jyscodeid').append("<option value=\""+data[o].instrumentID +"\">"+getNameByCode(data[o].instrumentID)+data[o].instrumentID+"</option>"); 
				if(code==""){
					code=data[o].instrumentID;
					getCodeDetail(code);
				}
			}
		}
	});
}

function getCodeDetail(code){
	if(code==""||code==undefined){
		code = $("#jyscodeid").val();
	}
	getChart(code);
	$.ajax({
		type : 'GET',
		url : 'findCodeStatistics.html',
		data : {
			code : code
		},
		dataType : 'json',
		contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
		success : function(data) {
			$('#instrumentID').text(data.instrumentID);
			$('#todayStrID').text(data.todayStr);
			$('#openpriceID').text(data.futuresQuoteVO.openPrice);
			$('#highestpriceID').text(data.futuresQuoteVO.highestPrice);
			$('#lowestpriceID').text(data.futuresQuoteVO.lowestPrice);
			$('#highest20priceID').text(data.maxMinPriceVO.maxValue);
			$('#lowest20priceID').text(data.maxMinPriceVO.minValue);
			$('#closepriceID').text(data.futuresQuoteVO.closePrice);
			$('#settlepriceID').text(data.futuresQuoteVO.settlementPrice);
			$('#presettlepriceID').text(data.futuresQuoteVO.preSettlementPrice);
			$('#atrID').text(data.atrvo.atr);
			$('#macd5ID').text(data.macdVO.macd5);
			$('#macd10ID').text(data.macdVO.macd10);
			$('#macd20ID').text(data.macdVO.macd20);
			$('#macd40ID').text(data.macdVO.macd40);
			$('#macd60ID').text(data.macdVO.macd60);
		}
	});
	
}

