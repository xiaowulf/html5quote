$(function() {
	//getPosition();
});
function computeDayResult(){
	$.ajax({
		type : 'POST',
		url : 'computeDateResult.html',
		data : {
			todayStr:$("#computeDateText").val()
		},
		contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
		dataType : 'json',
		success : function(data) {
			if(data.status=="0"){
				alert("此日期无开盘，请查询之后再计算");
			}else if(data.status=="3"){
				alert("今日结算完成");
			}
		}
	});
}
function mergeData(){
	$.ajax({
		type : 'POST',
		url : 'mergeData.html',
		data : {
			todayStr:$("#computeDateText").val()
		},
		contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
		dataType : 'json',
		success : function(data) {
			if(data.status=="0"){
				alert("此日期无开盘，请查询之后再计算");
			}
			else if(data.status=="1"){
				alert("今日行情数据生成成功");
			}
			
		}
	});
}

function queryResult()
{
	$.ajax({
		type : 'POST',
		url : 'findAllResule.html',
		data : {
			todayStr:$("#computeDateText").val()
		},
		contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
		dataType : 'json',
		success : function(data) {
			var strDiv = "";
			var row = 0;
			$("#resultMain").empty();
			for (var i = 0; i < data.resultList.length; i++) {
				if(row==0){
					row ++;
					strDiv += "<div  class=\"container-fluid\">";
					strDiv += "<div  class=\"row\">";
					strDiv += "<div class=\"mainrightZhiBiao1 position-fixed fixed-top col-xs-4 col-sm-4 col-md-1 col-lg-1\">";
					strDiv += "策略ID";
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao1 position-fixed fixed-top col-xs-4 col-sm-4 col-md-1 col-lg-1\">";
					strDiv += "策略名称";
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao1 position-fixed fixed-top col-xs-4 col-sm-4 col-md-1 col-lg-1\">";
					strDiv += "开始日期";
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao1 position-fixed fixed-top col-xs-4 col-sm-4 col-md-1 col-lg-1\">";
					strDiv += "记录日期";
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao1 position-fixed fixed-top col-xs-4 col-sm-4 col-md-2 col-lg-1\">";
					strDiv += "当日权益";
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao1 position-fixed fixed-top col-xs-4 col-sm-4 col-md-2 col-lg-1\">";
					strDiv += "上日权益";
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao1 position-fixed fixed-top col-xs-4 col-sm-4 col-md-2 col-lg-1\">";
					strDiv += "单位净值";
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao1 position-fixed fixed-top col-xs-4 col-sm-4 col-md-1 col-lg-1\">";
					strDiv += "累计盈亏额";
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao1 position-fixed fixed-top col-xs-4 col-sm-4 col-md-1 col-lg-1\">";
					strDiv += "保证金";
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao1 position-fixed fixed-top col-xs-4 col-sm-4 col-md-1 col-lg-1\">";
					strDiv += "保证金比率";
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao1 position-fixed fixed-top col-xs-4 col-sm-4 col-md-1 col-lg-1\">";
					strDiv += "持仓盈亏";
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao1 position-fixed fixed-top col-xs-4 col-sm-4 col-md-1 col-lg-1\">";
					strDiv += "平仓盈亏";
					strDiv += "</div>";
					strDiv += "</div>";
					strDiv += "</div>";
				}
				row ++;
				if(row%2==0){
					strDiv += "<div  class=\"container-fluid\">";
					strDiv += "<div  class=\"row\">";
					strDiv += "<div class=\"mainrightZhiBiao2 col-xs-4 col-sm-4 col-md-1 col-lg-1\" >";
					strDiv += data.resultList[i][0].strategy_id;
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao2 col-xs-4 col-sm-4 col-md-1 col-lg-1\" >";
					strDiv += data.resultList[i][1].name;
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao2 col-xs-4 col-sm-4 col-md-1 col-lg-1\" >";
					strDiv += data.resultList[i][1].initdate;
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao2 col-xs-4 col-sm-4 col-md-1 col-lg-1\" >";
					strDiv += data.resultList[i][0].record_date;
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao2 col-xs-4 col-sm-4 col-md-1 col-lg-1\" >";
					strDiv += data.resultList[i][0].drqy;
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao2 col-xs-4 col-sm-4 col-md-1 col-lg-1\" >";
					strDiv += data.resultList[i][0].srqy;
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao2 col-xs-4 col-sm-4 col-md-1 col-lg-1\" >";
					strDiv += data.resultList[i][0].dwjz;
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao2 col-xs-4 col-sm-4 col-md-1 col-lg-1\" >";
					strDiv += data.resultList[i][0].ljyle;
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao2 col-xs-4 col-sm-4 col-md-1 col-lg-1\" >";
					strDiv += data.resultList[i][0].bzj;
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao2 col-xs-4 col-sm-4 col-md-1 col-lg-1\" >";
					strDiv += data.resultList[i][0].bzjratio;
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao2 col-xs-4 col-sm-4 col-md-1 col-lg-1\" >";
					strDiv += data.resultList[i][0].ccyk;
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao2 col-xs-4 col-sm-4 col-md-1 col-lg-1\" >";
					strDiv += data.resultList[i][0].pcyk;
					strDiv += "</div>";
				}else{
					strDiv += "<div  class=\"container-fluid\">";
					strDiv += "<div  class=\"row\">";
					strDiv += "<div class=\"mainrightZhiBiao3 col-xs-4 col-sm-4 col-md-1 col-lg-1\" >";
					strDiv += data.resultList[i][0].strategy_id;
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao3 col-xs-4 col-sm-4 col-md-1 col-lg-1\" >";
					strDiv += data.resultList[i][1].name;
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao3 col-xs-4 col-sm-4 col-md-1 col-lg-1\" >";
					strDiv += data.resultList[i][1].initdate;
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao3 col-xs-4 col-sm-4 col-md-1 col-lg-1\" >";
					strDiv += data.resultList[i][0].record_date;
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao3 col-xs-4 col-sm-4 col-md-1 col-lg-1\" >";
					strDiv += data.resultList[i][0].drqy;
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao3 col-xs-4 col-sm-4 col-md-1 col-lg-1\" >";
					strDiv += data.resultList[i][0].srqy;
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao3 col-xs-4 col-sm-4 col-md-1 col-lg-1\" >";
					strDiv += data.resultList[i][0].dwjz;
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao3 col-xs-4 col-sm-4 col-md-1 col-lg-1\" >";
					strDiv += data.resultList[i][0].ljyle;
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao3 col-xs-4 col-sm-4 col-md-1 col-lg-1\" >";
					strDiv += data.resultList[i][0].bzj;
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao3 col-xs-4 col-sm-4 col-md-1 col-lg-1\" >";
					strDiv += data.resultList[i][0].bzjratio;
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao3 col-xs-4 col-sm-4 col-md-1 col-lg-1\" >";
					strDiv += data.resultList[i][0].ccyk;
					strDiv += "</div>";
					strDiv += "<div class=\"mainrightZhiBiao3 col-xs-4 col-sm-4 col-md-1 col-lg-1\" >";
					strDiv += data.resultList[i][0].pcyk;
					strDiv += "</div>";
				}
				
		    }
			strDiv += "</div>";
			strDiv += "</div>";
			$("#resultMain").html(strDiv);
		}
	});
}
