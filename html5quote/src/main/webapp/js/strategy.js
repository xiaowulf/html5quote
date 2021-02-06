$(function() {
	$("#strategyEdit").hide();
});
function hideDIV()
{
	$("#strategyEdit").hide();
}
function editStrategy(id){
	$.ajax({
		type : 'POST',
		url : 'editStrategy.html',
		data : {
			id:id
		},
		contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
		dataType : 'json',
		success : function(data) {
			if(data.status=="0"){
				alert("查询策略出错");
			}else if(data.status=="1"){
				$("#strategyEdit").show();
				$("#strategyID").val(data.futuresStrategy.id);
				$("#strategyName").val(data.futuresStrategy.name);
				$("#strategyInitDate").val(data.futuresStrategy.initdate);
				$("#strategyQcqy").val(data.futuresStrategy.qcqy);
				$("#strategyISUSE").val(data.futuresStrategy.is_use);
				
			}
		}
	});
}

function saveStrategy()
{
	$.ajax({
		type : 'POST',
		url : 'saveStrategy.html',
		data : {
			id:$("#strategyID").val(),name:$("#strategyName").val(),initdate:$("#strategyInitDate").val(),qcqy:$("#strategyQcqy").val(),is_use:$("#strategyISUSE").val()
		},
		contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
		dataType : 'json',
		success : function(data) {
			if(data.status=="0"){
				alert("查询策略出错");
			}else if(data.status=="1"){
				alert("保存成功");
				$("#strategyEdit").hide();
			}
		}
	});
}
