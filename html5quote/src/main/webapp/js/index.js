function getJys(jys){
	//jys = "shfe";
	$.ajax({
		type: 'POST',
		url: 'changeFuturesJys.html',
		data: {jys:jys},
		dataType: 'json',
		success: function(data){
			$("#style-3").empty();
			var strDiv = "";
			for(var o in data){ 
				strDiv +="<div class=\"mainrightZhiBiao\">";
				strDiv +="<div class=\"mainrightZhiBiaoNameY\">";
				strDiv +=data[o].name;
				strDiv +="</div>";
				strDiv +="<div class=\"mainrightZhiBiao1\">";
				strDiv +=data[o].instrumentID;
				strDiv +="</div>";
				strDiv +="<div class=\"mainrightZhiBiao2\">";
				strDiv +="&nbsp;";
				strDiv +="</div>";
				strDiv +="<div class=\"mainrightZhiBiao2\">";
				strDiv +="&nbsp;";
				strDiv +="</div>";
				strDiv +="<div class=\"mainrightZhiBiao2\">";
				strDiv +="&nbsp;";
				strDiv +="</div>";
				strDiv +="<div class=\"mainrightZhiBiao2\">";
				strDiv +="&nbsp;";
				strDiv +="</div>";
				strDiv +="<div class=\"mainrightZhiBiao2\">";
				strDiv +="&nbsp;";
				strDiv +="</div>";
				strDiv +="<div class=\"mainrightZhiBiao2\">";
				strDiv +="&nbsp;";
				strDiv +="</div>";
				strDiv +="<div class=\"mainrightZhiBiao2\">";
				strDiv +="&nbsp;";
				strDiv +="</div>";
				strDiv +="<div class=\"mainrightZhiBiao2\">";
				strDiv +="&nbsp;";
				strDiv +="</div>";
				strDiv +="<div class=\"mainrightZhiBiao2\">";
				strDiv +="&nbsp;";
				strDiv +="</div>";
				strDiv +="</div>";
		    } 
			$("#style-3").html(strDiv);
		}
	});
}

$(function(){
	$("#futures-shfe").click(function () {
		
    })
});