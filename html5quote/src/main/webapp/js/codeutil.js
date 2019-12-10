function converCode(code) {
	var patten = /[0-9]/;
	var n = code.search(patten);
	if(n>0){
		return code.substring(0,n);
	}else{
		return "";
	}
}

function getNameByCode(code) {
	var code = converCode(code);
	if(code=="c"){
		return "玉米";
	}else if(code=="cs"){
		return "淀粉";
	}else if(code=="a"){
		return "豆一";
	}else if(code=="b"){
		return "豆二";
	}else if(code=="m"){
		return "豆粕";
	}else if(code=="y"){
		return "豆油";
	}else if(code=="p"){
		return "棕榈";
	}else if(code=="fb"){
		return "纤板";
	}else if(code=="bb"){
		return "胶板";
	}else if(code=="jd"){
		return "鸡蛋";
	}else if(code=="rr"){
		return "粳米";
	}else if(code=="l"){
		return "塑料";
	}else if(code=="v"){
		return "乙烯";
	}else if(code=="pp"){
		return "丙烯";
	}else if(code=="j"){
		return "焦炭";
	}else if(code=="jm"){
		return "焦煤";
	}else if(code=="i"){
		return "铁矿";
	}else if(code=="eg"){
		return "二醇";
	}else if(code=="eb"){
		return "苯乙";
	}else if(code=="cu"){
		return "铜";
	}else if(code=="al"){
		return "铝";
	}else if(code=="zn"){
		return "锌";
	}else if(code=="pb"){
		return "铅";
	}else if(code=="ni"){
		return "镍";
	}else if(code=="sn"){
		return "锡";
	}else if(code=="au"){
		return "金";
	}else if(code=="ag"){
		return "白银";
	}else if(code=="rb"){
		return "螺纹";
	}else if(code=="wr"){
		return "线材";
	}else if(code=="hc"){
		return "线材";
	}else if(code=="ss"){
		return "不锈钢";
	}else if(code=="sc"){
		return "原油";
	}else if(code=="fu"){
		return "燃油";
	}else if(code=="bu"){
		return "沥青";
	}else if(code=="ru"){
		return "橡胶";
	}else if(code=="nr"){
		return "20胶";
	}else if(code=="sp"){
		return "纸浆";
	}else if(code=="IF"){
		return "股指";
	}else if(code=="IC"){
		return "中证500";
	}else if(code=="IH"){
		return "上证50";
	}else if(code=="TS"){
		return "国债2";
	}else if(code=="TF"){
		return "国债5";
	}else if(code=="T"){
		return "国债10";
	}else if(code=="WH"){
		return "强麦";
	}else if(code=="PM"){
		return "国债10";
	}else if(code=="T"){
		return "普麦";
	}else if(code=="CF"){
		return "棉花";
	}else if(code=="TA"){
		return "苯二";
	}else if(code=="MA"){
		return "甲醇";
	}else if(code=="SR"){
		return "白糖";
	}else if(code=="OI"){
		return "菜油";
	}else if(code=="RI"){
		return "早稻";
	}else if(code=="ZC"){
		return "动煤";
	}else if(code=="FG"){
		return "玻璃";
	}else if(code=="RS"){
		return "菜籽";
	}else if(code=="RM"){
		return "菜粕";
	}else if(code=="JR"){
		return "粳稻";
	}else if(code=="SF"){
		return "硅铁";
	}else if(code=="SM"){
		return "锰硅";
	}else if(code=="LR"){
		return "晚稻";
	}else if(code=="CY"){
		return "棉纱";
	}else if(code=="AP"){
		return "苹果";
	}else if(code=="UR"){
		return "尿素";
	}else if(code=="CJ"){
		return "红枣";
	}else if(code=="SA"){
		return "纯碱";
	}else{
		return code;
	}
}