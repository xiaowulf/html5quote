$(function() {
	var clientwidth = document.body.clientWidth;
	var chartwidth = (clientwidth-180)/3;
	var chartcsswidth = chartwidth +"px";
	//$("#chart1").css("width",chartcsswidth);
	//$("#chart2").css("width",chartcsswidth);
	//$("#chart3").css("width",chartcsswidth);
	getJys("shfe");
	getChart("index");
});
var option_close_settle = {
	title : {
		text : '�ڻ��۸�',
		textStyle : {
			fontSize : 13
		}
	},
	tooltip : {
		trigger : 'axis'
	},
	legend : {
		data : [ '���̼۸�', '����۸�' ]
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
		name : '���̼۸�',
		type : 'line',
		data : [],
		markPoint : {
			data : [ {
				type : 'max',
				name : '���ֵ'
			}, {
				type : 'min',
				name : '��Сֵ'
			} ]
		},
		markLine : {
			data : [ {
				type : 'average',
				name : 'ƽ��ֵ'
			} ]
		}
	}, {
		name : '����۸�',
		type : 'line',
		data : [],
		markPoint : {
			data : [ {
				type : 'max',
				name : '���ֵ'
			}, {
				type : 'min',
				name : '��Сֵ'
			} ]
		},
		markLine : {
			data : [ {
				type : 'average',
				name : 'ƽ��ֵ'
			} ]
		}
	} ]
};
var option_settleCur = {
		title : {
			text : '�ڻ��۸�',
			textStyle : {
				fontSize : 13
			}
		},
		tooltip : {
			trigger : 'axis'
		},
		legend : {
			data : [ '����۸����' ]
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
			name : '����۸����',
			type : 'line',
			data : [],
			symbol:'none',
			smooth:0.8,
			markPoint : {
				data : [ {
					type : 'max',
					name : '���ֵ'
				}, {
					type : 'min',
					name : '��Сֵ'
				} ]
			},
			markLine : {
				data : [ {
					type : 'average',
					name : 'ƽ��ֵ'
				} ]
			}
		} ]
	};

var option_candle = {
		title : {
			text : '�ڻ��۸�K��',
			textStyle : {
				fontSize : 13
			}
		},
		tooltip : {
			trigger : 'axis'
		},
		legend : {
			data : [ '�ڻ��۸�K��']
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
			name : 'k��',
			type : 'k',
			data : []
		} ]
	};

// ����׼���õ�dom����ʼ��echartsʵ��

// ָ��ͼ��������������
var option = {
	title : {
		text : 'ECharts ����ʾ��'
	},
	tooltip : {},
	legend : {
		data : [ '����' ]
	},
	xAxis : {
		data : [ "����", "��ë��", "ѩ����", "����", "�߸�Ь", "����" ]
	},
	yAxis : {},
	series : [ {
		name : '����',
		type : 'bar',
		data : [ 5, 20, 36, 10, 10, 20 ]
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
		dataType : 'json',
		success : function(data) {
			//alert(data.code+decodeURI("�۸�"));
			option_close_settle.title.text = data.code+"�۸�";
			option_close_settle.xAxis[0].data = data.dateRtnList;
			option_close_settle.series[0].data=data.closePriceList;
			option_close_settle.series[1].data=data.settlePriceList;
			option_settleCur.title.text = data.code+"������������";
			option_settleCur.xAxis[0].data = data.dateRtnList;
			option_settleCur.series[0].data=data.settlePriceCurList;
			//k��
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
			//���̼ۺͽ��������
			chart1.setOption(option_close_settle);
			//����۸����
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
					strDiv += "Ʒ��";
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao1 position-fixed fixed-top col-xs-4 col-sm-3 col-md-2 col-lg-1\">";
					strDiv += "����";
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao1 position-fixed fixed-top col-xs-4 col-sm-3 col-md-2 col-lg-1\">";
					strDiv += "���";
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao1 position-fixed fixed-top col-xs-4 col-sm-3 col-md-2 col-lg-1\">";
					strDiv += "���";
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao1 position-fixed fixed-top col-xs-4 col-sm-3 col-md-2 col-lg-1\">";
					strDiv += "����";
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao1 position-fixed fixed-top col-xs-4 col-sm-3 col-md-2 col-lg-1\">";
					strDiv += "����";
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao1 position-fixed fixed-top col-xs-4 col-sm-3 col-md-2 col-lg-1\">";
					strDiv += "���";
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao1 position-fixed fixed-top col-xs-4 col-sm-3 col-md-2 col-lg-1\">";
					strDiv += "����";
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao1 position-fixed fixed-top col-xs-4 col-sm-3 col-md-2 col-lg-1\">";
					strDiv += "����";
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao1 position-fixed fixed-top col-xs-4 col-sm-3 col-md-2 col-lg-1\">";
					strDiv += "����";
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao1 position-fixed fixed-top col-xs-4 col-sm-3 col-md-2 col-lg-1\">";
					strDiv += "����";
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao1 position-fixed fixed-top col-xs-4 col-sm-3 col-md-2 col-lg-1\">";
					strDiv += "����";
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
					
					strDiv += "<div class=\"mainrightZhiBiao2 col-xs-4 col-sm-3 col-md-2 col-lg-1\" onclick=\"getChart('"+data[o].instrumentID+"')\">";
					strDiv += data[o].openPrice;
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao2 col-xs-4 col-sm-3 col-md-2 col-lg-1\" onclick=\"getChart('"+data[o].instrumentID+"')\">";
					strDiv += data[o].highestPrice;
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao2 col-xs-4 col-sm-3 col-md-2 col-lg-1\" onclick=\"getChart('"+data[o].instrumentID+"')\">";
					strDiv += data[o].lowestPrice;
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao2 col-xs-4 col-sm-3 col-md-2 col-lg-1\" onclick=\"getChart('"+data[o].instrumentID+"')\">";
					strDiv += data[o].closePrice;
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao2 col-xs-4 col-sm-3 col-md-2 col-lg-1\" onclick=\"getChart('"+data[o].instrumentID+"')\">";
					strDiv += data[o].settlementPrice;
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao2 col-xs-4 col-sm-3 col-md-2 col-lg-1\" onclick=\"getChart('"+data[o].instrumentID+"')\">";
					strDiv += data[o].bidPrice1;
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao2 col-xs-4 col-sm-3 col-md-2 col-lg-1\" onclick=\"getChart('"+data[o].instrumentID+"')\">";
					strDiv += data[o].bidVolume1;
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao2 col-xs-4 col-sm-3 col-md-2 col-lg-1\" onclick=\"getChart('"+data[o].instrumentID+"')\">";
					strDiv += data[o].askPrice1;
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao2 col-xs-4 col-sm-3 col-md-2 col-lg-1\" onclick=\"getChart('"+data[o].instrumentID+"')\">";
					strDiv += data[o].askVolume1;
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao2 col-xs-4 col-sm-3 col-md-2 col-lg-1\" onclick=\"getChart('"+data[o].instrumentID+"')\">";
					strDiv += data[o].volume;
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao2 col-xs-4 col-sm-3 col-md-2 col-lg-1\" onclick=\"getChart('"+data[o].instrumentID+"')\">";
					strDiv += data[o].ccvolume;
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
			strDiv += "Ʒ��";
			strDiv += "</div>";
			strDiv += "<div class=\"mainrightZhiBiao1 position-fixed fixed-top col-xs-4 col-sm-3 col-md-2 col-lg-1\">";
			strDiv += "����";
			strDiv += "</div>";
			strDiv += "<div class=\"mainrightZhiBiao1 position-fixed fixed-top col-xs-4 col-sm-3 col-md-2 col-lg-1\">";
			strDiv += "���";
			strDiv += "</div>";
			strDiv += "<div class=\"mainrightZhiBiao1 position-fixed fixed-top col-xs-4 col-sm-3 col-md-2 col-lg-1\">";
			strDiv += "���";
			strDiv += "</div>";
			strDiv += "<div class=\"mainrightZhiBiao1 position-fixed fixed-top col-xs-4 col-sm-3 col-md-2 col-lg-1\">";
			strDiv += "����";
			strDiv += "</div>";
			strDiv += "<div class=\"mainrightZhiBiao1 position-fixed fixed-top col-xs-4 col-sm-3 col-md-2 col-lg-1\">";
			strDiv += "����";
			strDiv += "</div>";
			strDiv += "<div class=\"mainrightZhiBiao1 position-fixed fixed-top col-xs-4 col-sm-3 col-md-2 col-lg-1\">";
			strDiv += "���";
			strDiv += "</div>";
			strDiv += "<div class=\"mainrightZhiBiao1 position-fixed fixed-top col-xs-4 col-sm-3 col-md-2 col-lg-1\">";
			strDiv += "����";
			strDiv += "</div>";
			strDiv += "<div class=\"mainrightZhiBiao1 position-fixed fixed-top col-xs-4 col-sm-3 col-md-2 col-lg-1\">";
			strDiv += "����";
			strDiv += "</div>";
			strDiv += "<div class=\"mainrightZhiBiao1 position-fixed fixed-top col-xs-4 col-sm-3 col-md-2 col-lg-1\">";
			strDiv += "����";
			strDiv += "</div>";
			strDiv += "<div class=\"mainrightZhiBiao1 position-fixed fixed-top col-xs-4 col-sm-3 col-md-2 col-lg-1\">";
			strDiv += "����";
			strDiv += "</div>";
			strDiv += "<div class=\"mainrightZhiBiao1 position-fixed fixed-top col-xs-4 col-sm-3 col-md-2 col-lg-1\">";
			strDiv += "����";
			strDiv += "</div>";
			strDiv += "</div>";
			strDiv += "</div>";
			$("#style-3").html(strDiv);
		}
	});
}
