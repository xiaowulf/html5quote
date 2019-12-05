package com.venus.finance.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.venus.finance.vo.FuturesQuoteVO;

public class CodeUtil {
	public List<String> getCodeList(){
		InitUtil initUtil = new InitUtil();
		FileUtil fileUtil = new FileUtil();
		File codeFile = null;
		try {
			codeFile = initUtil.getCodeFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<String> list = fileUtil.readFileToList(codeFile);
		return list;
	}
	
	public String getTradeDatePath(){
		InitUtil initUtil = new InitUtil();
		String filePath = null;
		try {
			filePath = initUtil.getFuturesDatePath();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return filePath;
	}
	
	public List<String> getTradeDate(){
		FileUtil fileUtil = new FileUtil();
		String filePath = getTradeDatePath();
		List<String> list = fileUtil.readFileToList(new File(filePath));
		return list;
	}
	
	public String getIndexCode(){
		InitUtil initUtil = new InitUtil();
		String code = null;
		try {
			code = initUtil.getIndexCode();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return code;
	}
	public List<FuturesQuoteVO> getDayQuoteByCodeAndDate(List<String> date30List,String code){
		InitUtil initUtil = new InitUtil();
		FileUtil fileUtil = new FileUtil();
		List<FuturesQuoteVO> list = new ArrayList<FuturesQuoteVO>();
		String dataFolder = null;
		try {
			dataFolder = initUtil.getDayDataFolder();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(null!=dataFolder) {
			for(String date:date30List) {
				File dayDataFile = new File(dataFolder+"/hlj"+date+".txt");
				List<FuturesQuoteVO> futuresDayQuoteList = 
						fileUtil.readFileToFuturesQuoteList(dayDataFile);
				for(FuturesQuoteVO futuresQuoteVO:futuresDayQuoteList) {
					if(futuresQuoteVO.getInstrumentID().toUpperCase()
							.equals(code.toUpperCase())) {
						futuresQuoteVO.setDate(Long.parseLong(date));
						list.add(futuresQuoteVO);
					}
				}
			}
		}
		return list;
	}
	public List<FuturesQuoteVO> getCodeByJys(String jys) throws UnsupportedEncodingException{
		FileUtil fileUtil = new FileUtil();
		InitUtil initUtil = new InitUtil();
		List<FuturesQuoteVO>codeList = new ArrayList<FuturesQuoteVO>();
		File codeFile = null;
		File futuresLatestFile = null;
		try {
			codeFile = initUtil.getCodeFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			futuresLatestFile = initUtil.getFutures_latest_file();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		List<String> list = fileUtil.readFileToList(codeFile);
		List<String> futuresLatest = null;
		if(futuresLatestFile.exists()){
			futuresLatest = fileUtil.readFileToList(futuresLatestFile);
		}
		//根据code生成一个map，后面好处理
		Map<String,FuturesQuoteVO> futuresQuoteMap = new HashMap<String,FuturesQuoteVO>();
		for(String codeStr:list){
			String [] codeArray = codeStr.split(",");
			if(codeArray.length==2){
				if(codeArray[1].toUpperCase().equals(jys.toUpperCase())){
					FuturesQuoteVO futuresQuoteVO = new FuturesQuoteVO();
					futuresQuoteVO.setInstrumentID(codeArray[0]);
					futuresQuoteVO.setName(getChineseName(codeArray[0])+converCodeMonth(codeArray[0]));
					futuresQuoteMap.put(codeArray[0], futuresQuoteVO);
				}
			}
		}
		for(String codeStr:futuresLatest){
			String [] codeArray = codeStr.split(",");
			if(codeArray.length>=8){
				FuturesQuoteVO futuresQuoteVO = futuresQuoteMap.get(codeArray[0]);
				if(null!=futuresQuoteVO){
					futuresQuoteVO.setOpenPrice(Double.parseDouble(codeArray[1]));
					futuresQuoteVO.setHighestPrice(Double.parseDouble(codeArray[2]));
					futuresQuoteVO.setLowestPrice(Double.parseDouble(codeArray[3]));
					futuresQuoteVO.setClosePrice(Double.parseDouble(codeArray[4]));
					futuresQuoteVO.setSettlementPrice(Double.parseDouble(codeArray[5]));
					futuresQuoteVO.setVolume(Double.parseDouble(codeArray[6]));
					futuresQuoteVO.setCcvolume(Double.parseDouble(codeArray[7]));
					codeList.add(futuresQuoteVO);
				}
			}
		}
		return codeList;
	}
	public static double maxValue = 10000000000D;
	public static double minValue = 0.0000000001D;
	public static int getCodeXiShu(String code) {
		switch (converCode(code)) {
		case "cu":
			return 5;
		case "au":
			return 1000;
		case "rb":
			return 10;
		case "a":
			return 10;
		case "SR":
			return 1;
		case "i":
			return 100;
		case "m":
			return 10;
		case "y":
			return 10;
		case "IF":
			return 300;
		case "p":
			return 10;
		case "ru":
			return 10;
		case "ag":
			return 15;
		case "c":
			return 10;
		case "T":
			return 10000;
		case "CF":
			return 1;
		case "TA":
			return 1;
		case "IC":
			return 200;
		case "TF":
			return 10000;
		case "ni":
			return 1;
		case "pp":
			return 5;
		case "zn":
			return 5;
		case "al":
			return 5;
		case "OI":
			return 1;
		case "cs":
			return 10;
		case "RM":
			return 1;
		case "j":
			return 100;
		case "MA":
			return 1;
		case "IH":
			return 300;
		case "jm":
			return 60;
		case "jd":
			return 10;
		case "FG":
			return 1;
		case "WH":
			return 1;
		case "bu":
			return 10;
		case "ZC":
			return 10;
		case "pb":
			return 5;
		case "v":
			return 5;
		case "hc":
			return 10;
		case "sn":
			return 1;
		case "TC":
			return 1;
		case "PM":
			return 1;
		case "RS":
			return 1;
		case "SM":
			return 1;
		case "SF":
			return 1;
		case "RI":
			return 1;
		case "fb":
			return 500;
		case "LR":
			return 1;
		case "JR":
			return 1;
		default:
			return 1;
		}
	}
	
	public static String getChineseName(String code) throws UnsupportedEncodingException {
		
		switch (converCode(code)) {
		//大商所
		case "c":
			return new String("玉米".getBytes(),"GBK");
		case "cs":
			return new String("淀粉".getBytes(),"GBK");
		case "a":
			return new String("豆一".getBytes(),"GBK");
		case "b":
			return new String("豆二".getBytes(),"GBK");
		case "m":
			return new String("豆粕".getBytes(),"GBK");
		case "y":
			return "豆油";
		case "p":
			return "棕榈";
		case "fb":
			return "纤板";
		case "bb":
			return "胶板";
		case "jd":
			return "鸡蛋";
		case "rr":
			return "粳米";
		case "l":
			return "塑料";
		case "v":
			return "乙烯";
		case "pp":
			return "丙烯";
		case "j":
			return "焦炭";
		case "jm":
			return "焦煤";
		case "i":
			return "铁矿";
		case "eg":
			return "二醇";
		case "eb":
			return "苯乙";
			
			
		//上期所
		case "cu":
			return "铜";
		case "al":
			return "铝";
		case "zn":
			return "锌";
		case "pb":
			return "铅";	
		case "ni":
			return "镍";
		case "sn":
			return "锡";
		case "au":
			return "金";
		case "ag":
			return "白银";
		case "rb":
			return "螺纹";
		case "wr":
			return "线材";
		case "hc":
			return "轧卷";
		case "ss":
			return "不锈钢";
		case "sc":
			return "原油";
		case "fu":
			return "燃油";
		case "bu":
			return "沥青";
		case "ru":
			return "橡胶";
		case "nr":
			return "20胶";
		case "sp":
			return "纸浆";
		//中金所	
		case "IF":
			return "股指";
		case "IC":
			return "中证500";
		case "IH":
			return "上证50";
		case "TS":
			return "国债2";
		case "TF":
			return "国债5";
		case "T":
			return "国债10";
		//郑商所
		case "WH":
			return "强麦";
		case "PM":
			return "普麦";
		case "CF":
			return "棉花";
		case "TA":
			return "苯二";
		case "MA":
			return "甲醇";
		case "SR":
			return "白糖";
		case "OI":
			return "菜油";
		case "RI":
			return "早稻";
		case "ZC":
			return "动煤";
		case "FG":
			return "玻璃";
		case "RS":
			return "菜籽";
		case "RM":
			return "菜粕";
		case "JR":
			return "粳稻";
		case "SF":
			return "硅铁";
		case "SM":
			return "锰硅";
		case "LR":
			return "晚稻";
		case "CY":
			return "棉纱";
		case "AP":
			return "苹果";
		case "UR":
			return "尿素";
		case "CJ":
			return "红枣";
			/*
		case "CJ":
			return "纯碱";
			*/
		default:
			return code;
		}
	}

	public static int getCodeDianShu(String code) {
		switch (converCode(code)) {
		case "cu":
			return 5;
		case "au":
			return 1000;
		case "rb":
			return 10;
		case "a":
			return 10;
		case "SR":
			return 10;
		case "i":
			return 100;
		case "m":
			return 10;
		case "y":
			return 10;
		case "IF":
			return 300;
		case "p":
			return 10;
		case "ru":
			return 10;
		case "ag":
			return 15;
		case "c":
			return 10;
		case "T":
			return 10000;
		case "CF":
			return 5;
		case "TA":
			return 5;
		case "IC":
			return 200;
		case "TF":
			return 10000;
		case "ni":
			return 1;
		case "pp":
			return 5;
		case "zn":
			return 5;
		case "al":
			return 5;
		case "OI":
			return 10;
		case "cs":
			return 10;
		case "RM":
			return 10;
		case "j":
			return 100;
		case "MA":
			return 10;
		case "IH":
			return 300;
		case "jm":
			return 60;
		case "jd":
			return 10;
		case "FG":
			return 20;
		case "WH":
			return 10;
		case "bu":
			return 10;
		case "ZC":
			return 100;
		case "pb":
			return 5;
		case "v":
			return 5;
		case "hc":
			return 10;
		case "sn":
			return 1;
		case "TC":
			return 10;
		case "PM":
			return 10;
		case "RS":
			return 10;
		case "SM":
			return 10;
		case "SF":
			return 10;
		case "RI":
			return 10;
		case "fb":
			return 500;
		case "LR":
			return 10;
		case "JR":
			return 10;
		default:
			return 1;
		}
	}

	public static String getCodeDce(String code) {
		switch (code) {
		case "豆一":
			return "a";
		case "豆二":
			return "b";
		case "玉米":
			return "c";
		case "胶合板":
			return "bb";
		case "玉米淀粉":
			return "cs";
		case "纤维板":
			return "fb";
		case "铁矿石":
			return "i";
		case "焦炭":
			return "j";
		case "鸡蛋":
			return "jd";
		case "焦煤":
			return "jm";
		case "聚乙烯":
			return "l";
		case "豆粕":
			return "m";
		case "棕榈油":
			return "p";
		case "聚丙烯":
			return "pp";
		case "聚氯乙烯":
			return "v";
		case "豆油":
			return "y";
		default:
			return "";
		}
	}

	public static String parseCodeDce(String line) {
		String[] s2 = line.split(" ");
		s2.toString();
		StringBuffer sb = new StringBuffer();
		String code = "";
		if (null != s2 && s2.length > 2 && null != s2[0] && null != s2[1]) {
			code = getCodeDce(s2[0]) + s2[1];
			sb.append(code);
		}

		if (null != s2 && s2.length > 3) {
			for (int i = 2; i < s2.length; i++) {
				if (null != s2[i] && !"".equals(s2[i])) {
					if (null != code && !"".equals(code)) {
						sb.append(s2[i]).append(",");
					}
				}
			}
		}
		return sb.toString();
	}
	
	
	
	public static String parseCodeDce2(String line) {
		line = line.replace(",", "");
		String[] s2 = line.split("\\s+");
		s2.toString();
		StringBuffer sb = new StringBuffer();
		String code = "";
		if (null != s2 && s2.length > 2 && null != s2[0] && null != s2[1]) {
			code = getCodeDce(s2[0]) + s2[1];
			sb.append(code);
		}

		if (null != s2 && s2.length > 3) {
			for (int i = 2; i < s2.length; i++) {
				if (null != s2[i] && !"".equals(s2[i])) {
					if (null != code && !"".equals(code)) {
						sb.append(",").append(s2[i]);
					}
				}
			}
		}

		return sb.toString();
	}

	// 解析期货合约名称
	public static String converCode(String code) {
		StringBuffer result = new StringBuffer();
		int size = code.length();
		if (size > 0) {
			for (int i = 0; i < size; i++) {
				char c = code.charAt(i);
				if (Character.isLetter(c)) {
					result.append(c);
				}
			}
		} else {
			return "";
		}
		return result.toString();
	}

	// 解析期货合约月份
	public static String converCodeMonth(String code) {
		StringBuffer result = new StringBuffer();
		int size = code.length();
		if (size > 0) {
			for (int i = 0; i < size; i++) {
				char c = code.charAt(i);
				if (!Character.isLetter(c)) {
					result.append(c);
				}
			}
		} else {
			return "";
		}
		return result.toString();
	}
}
