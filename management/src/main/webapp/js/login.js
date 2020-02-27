$(function(){
	document.onkeydown = function(e){ 
	    var ev = document.all ? window.event : e;
	    if(ev.keyCode==13) {
	    	submitForm();//处理事件
	    }
	}
});  

function submitForm(){
	if($('input[name=userName]').val()==""){
		alert("请输入用户名");
		return ;
	}
	if($('input[name=password]').val()==""){
		alert("请输入密码");
		return ;
	}
	if($('input[name=verycode]').val()==""){
		alert("请输入验证码");
		return ;
	}
	$.ajax({
		type: 'POST',
		url: 'loginCheck.html',
		data: $("#loginForm").serialize(),
		dataType: 'json',
		success: function(data){
			if(data.resultStatus=="1"){
				location.href="index.html";
			}else if(data.resultStatus=="-3"){
				alert("验证码错误！");
			}else if(data.resultStatus=="-4"){
				alert("用户名或者密码不可以我空！");
			}else{
				$('input[name=password]').val("");
				alert("用户名或者密码错误！");
			}
		}
	});
}
function clearForm(){
    $('#loginForm').form('clear');
}
function reloadImage(){
    document.getElementById("imageServlet").src='imageServlet?ts='+new Date().getTime();
}



