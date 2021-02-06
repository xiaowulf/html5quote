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

import com.venus.finance.vo.AtrVO;
import com.venus.finance.vo.FuturesQuoteVO;
import com.venus.finance.vo.Macd;
import com.venus.finance.vo.MacdVO;
import com.venus.finance.vo.MaxMinPriceVO;

public class CodeUtil {
	public static List<String> getCodeList() {
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

	public String getTradeDatePath() {
		InitUtil initUtil = new InitUtil();
		String filePath = null;
		try {
			filePath = initUtil.getFuturesDatePath();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return filePath;
	}

	public List<String> getTradeDate() {
		FileUtil fileUtil = new FileUtil();
		String filePath = getTradeDatePath();
		List<String> list = fileUtil.readFileToList(new File(filePath));
		return list;
	}

	public String getIndexCode() {
		InitUtil initUtil = new InitUtil();
		String code = null;
		try {
			code = initUtil.getIndexCode();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return code;
	}

	public FuturesQuoteVO getDayQuoteByCodeAndDate(String code, String date) {
		InitUtil initUtil = new InitUtil();
		FileUtil fileUtil = new FileUtil();
		List<FuturesQuoteVO> list = new ArrayList<FuturesQuoteVO>();
		String dataFolder = null;
		try {
			dataFolder = initUtil.getDayDataFolder();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (null != dataFolder) {
			File dayDataFile = new File(dataFolder + "/hlj" + date + ".txt");
			List<FuturesQuoteVO> futuresDayQuoteList = fileUtil.readFileToFuturesQuoteList(dayDataFile);
			for (FuturesQuoteVO futuresQuoteVO : futuresDayQuoteList) {
				if (futuresQuoteVO.getInstrumentID().toUpperCase().equals(code.toUpperCase())) {
					//futuresQuoteVO.setDate(Long.parseLong(date));
					//list.add(futuresQuoteVO);
					return futuresQuoteVO;
				}
			}
		}
		return null;
	}
	
	public MaxMinPriceVO getMaxMinPriceVOByCodeAndDate(String code, String date) {
		InitUtil initUtil = new InitUtil();
		FileUtil fileUtil = new FileUtil();
		List<FuturesQuoteVO> list = new ArrayList<FuturesQuoteVO>();
		String dataFolder = null;
		try {
			dataFolder = initUtil.getDayDataFolder();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (null != dataFolder) {
			File dayDataFile = new File(dataFolder + "/" + date + "day20maxmin.txt");
			List<MaxMinPriceVO> futuresDayQuoteList = fileUtil.readFileToMaxMinPriceVOList(dayDataFile);
			for (MaxMinPriceVO maxMinPriceVO : futuresDayQuoteList) {
				if (maxMinPriceVO.getInstrumentID().toUpperCase().equals(code.toUpperCase())) {
					//futuresQuoteVO.setDate(Long.parseLong(date));
					//list.add(futuresQuoteVO);
					return maxMinPriceVO;
				}
			}
		}
		return null;
	}
	
	public MacdVO getMacdVOByCodeAndDate(String code, String date) {
		InitUtil initUtil = new InitUtil();
		FileUtil fileUtil = new FileUtil();
		List<FuturesQuoteVO> list = new ArrayList<FuturesQuoteVO>();
		MacdVO macdVO = new MacdVO();
		String dataFolder = null;
		try {
			dataFolder = initUtil.getDayDataFolder();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (null != dataFolder) {
			File day5DataFile = new File(dataFolder + "/macd5-" + date + ".txt");
			List<Macd> futures5DaysQuoteList = fileUtil.readFileMacdVOList(day5DataFile);
			
			File day10DataFile = new File(dataFolder + "/macd10-" + date + ".txt");
			List<Macd> futures10DaysQuoteList = fileUtil.readFileMacdVOList(day10DataFile);
			
			File day20DataFile = new File(dataFolder + "/macd20-" + date + ".txt");
			List<Macd> futures20DaysQuoteList = fileUtil.readFileMacdVOList(day20DataFile);
			
			File day40DataFile = new File(dataFolder + "/macd40-" + date + ".txt");
			List<Macd> futures40DaysQuoteList = fileUtil.readFileMacdVOList(day40DataFile);
			
			File day60DataFile = new File(dataFolder + "/macd60-" + date + ".txt");
			List<Macd> futures60DaysQuoteList = fileUtil.readFileMacdVOList(day60DataFile);
			
			for (Macd macd : futures5DaysQuoteList) {
				if (macd.getInstrumentID().toUpperCase().equals(code.toUpperCase())) {
					macdVO.setMacd5(macd.getValue());
					break;
				}
			}
			for (Macd macd : futures10DaysQuoteList) {
				if (macd.getInstrumentID().toUpperCase().equals(code.toUpperCase())) {
					macdVO.setMacd10(macd.getValue());
					break;
				}
			}
			for (Macd macd : futures20DaysQuoteList) {
				if (macd.getInstrumentID().toUpperCase().equals(code.toUpperCase())) {
					macdVO.setMacd20(macd.getValue());
					break;
				}
			}
			for (Macd macd : futures40DaysQuoteList) {
				if (macd.getInstrumentID().toUpperCase().equals(code.toUpperCase())) {
					macdVO.setMacd40(macd.getValue());
					break;
				}
			}
			for (Macd macd : futures60DaysQuoteList) {
				if (macd.getInstrumentID().toUpperCase().equals(code.toUpperCase())) {
					macdVO.setMacd60(macd.getValue());
					break;
				}
			}
		}
		return macdVO;
	}
	
	
	public AtrVO getAtrByCodeAndDate(String code, String date) {
		InitUtil initUtil = new InitUtil();
		FileUtil fileUtil = new FileUtil();
		List<FuturesQuoteVO> list = new ArrayList<FuturesQuoteVO>();
		String dataFolder = null;
		try {
			dataFolder = initUtil.getDayDataFolder();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (null != dataFolder) {
			File dayDataFile = new File(dataFolder + "/atr" + date + ".txt");
			List<AtrVO> futuresDayQuoteList = fileUtil.readFileToAtrVOList(dayDataFile);
			for (AtrVO atrVO : futuresDayQuoteList) {
				if (atrVO.getInstrumentID().toUpperCase().equals(code.toUpperCase())) {
					//futuresQuoteVO.setDate(Long.parseLong(date));
					//list.add(futuresQuoteVO);
					return atrVO;
				}
			}
		}
		return null;
	}
	

	public List<FuturesQuoteVO> getDayQuoteByCodeAndDate(List<String> date30List, String code) {
		InitUtil initUtil = new InitUtil();
		FileUtil fileUtil = new FileUtil();
		List<FuturesQuoteVO> list = new ArrayList<FuturesQuoteVO>();
		String dataFolder = null;
		try {
			dataFolder = initUtil.getDayDataFolder();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (null != dataFolder) {
			for (String date : date30List) {
				File dayDataFile = new File(dataFolder + "/hlj" + date + ".txt");
				List<FuturesQuoteVO> futuresDayQuoteList = fileUtil.readFileToFuturesQuoteList(dayDataFile);
				for (FuturesQuoteVO futuresQuoteVO : futuresDayQuoteList) {
					if (futuresQuoteVO.getInstrumentID().toUpperCase().equals(code.toUpperCase())) {
						futuresQuoteVO.setDate(Long.parseLong(date));
						
						if(date.equals("20210104")&&code.toUpperCase().equals("AG2103")) {
							System.out.println();
						}
						File day5DataFile = new File(dataFolder + "/macd5-" + date + ".txt");
						List<Macd> futures5DaysQuoteList = fileUtil.readFileMacdVOList(day5DataFile);
						
						File day10DataFile = new File(dataFolder + "/macd10-" + date + ".txt");
						List<Macd> futures10DaysQuoteList = fileUtil.readFileMacdVOList(day10DataFile);
						
						File day20DataFile = new File(dataFolder + "/macd20-" + date + ".txt");
						List<Macd> futures20DaysQuoteList = fileUtil.readFileMacdVOList(day20DataFile);
						
						File day40DataFile = new File(dataFolder + "/macd40-" + date + ".txt");
						List<Macd> futures40DaysQuoteList = fileUtil.readFileMacdVOList(day40DataFile);
						
						File day60DataFile = new File(dataFolder + "/macd60-" + date + ".txt");
						List<Macd> futures60DaysQuoteList = fileUtil.readFileMacdVOList(day60DataFile);
						
						for (Macd macd : futures5DaysQuoteList) {
							if (macd.getInstrumentID().toUpperCase().equals(code.toUpperCase())) {
								futuresQuoteVO.getMacdVO().setMacd5(macd.getValue());
								break;
							}
						}
						for (Macd macd : futures10DaysQuoteList) {
							if (macd.getInstrumentID().toUpperCase().equals(code.toUpperCase())) {
								futuresQuoteVO.getMacdVO().setMacd10(macd.getValue());
								break;
							}
						}
						for (Macd macd : futures20DaysQuoteList) {
							if (macd.getInstrumentID().toUpperCase().equals(code.toUpperCase())) {
								futuresQuoteVO.getMacdVO().setMacd20(macd.getValue());
								break;
							}
						}
						for (Macd macd : futures40DaysQuoteList) {
							if (macd.getInstrumentID().toUpperCase().equals(code.toUpperCase())) {
								futuresQuoteVO.getMacdVO().setMacd40(macd.getValue());
								break;
							}
						}
						for (Macd macd : futures60DaysQuoteList) {
							if (macd.getInstrumentID().toUpperCase().equals(code.toUpperCase())) {
								futuresQuoteVO.getMacdVO().setMacd60(macd.getValue());
								break;
							}
						}
						list.add(futuresQuoteVO);
						break;
					}
				}
			}
		}
		return list;
	}

	public List<FuturesQuoteVO> getCodeByJys(String jys) throws UnsupportedEncodingException {
		FileUtil fileUtil = new FileUtil();
		InitUtil initUtil = new InitUtil();
		List<FuturesQuoteVO> codeList = new ArrayList<FuturesQuoteVO>();
		File codeFile = null;
		
		try {
			codeFile = initUtil.getCodeFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String dayDataFolder = "";
		try {
			dayDataFolder = initUtil.getDayDataFolder();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String latestFilePath = "";
		try {
			latestFilePath = dayDataFolder+"/hlj"+initUtil.getRecordDate()+".txt";
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		File futuresLatestFile = new File(latestFilePath);
//		try {
//			futuresLatestFile = initUtil.getFutures_latest_file();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

		List<String> list = fileUtil.readFileToList(codeFile);
		List<String> futuresLatest = null;
		if (futuresLatestFile.exists()) {
			futuresLatest = fileUtil.readFileToList(futuresLatestFile);
		}
		// 根据code生成一个map，后面好处理
		Map<String, FuturesQuoteVO> futuresQuoteMap = new HashMap<String, FuturesQuoteVO>();
		for (String codeStr : list) {
			String[] codeArray = codeStr.split(",");
			if (codeArray.length == 2) {
				if (codeArray[1].toUpperCase().equals(jys.toUpperCase())) {
					FuturesQuoteVO futuresQuoteVO = new FuturesQuoteVO();
					futuresQuoteVO.setInstrumentID(codeArray[0]);
					futuresQuoteVO.setName(getChineseName(codeArray[0]) + converCodeMonth(codeArray[0]));
					futuresQuoteMap.put(codeArray[0], futuresQuoteVO);
				}
			}
		}
		for (String codeStr : futuresLatest) {
			String[] codeArray = codeStr.split(",");
			if (codeArray.length >= 8) {
				FuturesQuoteVO futuresQuoteVO = futuresQuoteMap.get(codeArray[0]);
				if (null != futuresQuoteVO) {
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

	public List<String> getCodeListByJys(String jys) throws UnsupportedEncodingException {
		FileUtil fileUtil = new FileUtil();
		InitUtil initUtil = new InitUtil();
		List<String> codeList = new ArrayList<String>();
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
		for (String codeStr : list) {
			String[] codeArray = codeStr.split(",");
			if (codeArray.length == 2) {
				if (codeArray[1].toUpperCase().equals(jys.toUpperCase())) {
					codeList.add(codeArray[0]);
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
		// 大商所
		case "c":
			return URLEncoder.encode("玉米", "utf-8");
		case "cs":
			return URLEncoder.encode("淀粉", "utf-8");
		case "a":
			return URLEncoder.encode("豆一", "utf-8");
		case "b":
			return URLEncoder.encode("豆二", "utf-8");
		case "m":
			return URLEncoder.encode("豆粕", "utf-8");
		case "y":
			return URLEncoder.encode("豆油", "utf-8");
		case "p":
			return URLEncoder.encode("棕榈", "utf-8");
		case "fb":
			return URLEncoder.encode("纤板", "utf-8");
		case "bb":
			return URLEncoder.encode("胶板", "utf-8");
		case "jd":
			return URLEncoder.encode("鸡蛋", "utf-8");
		case "rr":
			return URLEncoder.encode("粳米", "utf-8");
		case "l":
			return URLEncoder.encode("塑料", "utf-8");
		case "v":
			return URLEncoder.encode("乙烯", "utf-8");
		case "pp":
			return URLEncoder.encode("丙烯", "utf-8");
		case "j":
			return URLEncoder.encode("焦炭", "utf-8");
		case "jm":
			return URLEncoder.encode("焦煤", "utf-8");
		case "i":
			return URLEncoder.encode("铁矿", "utf-8");
		case "eg":
			return URLEncoder.encode("二醇", "utf-8");
		case "eb":
			return URLEncoder.encode("苯乙", "utf-8");

		// 上期所
		case "cu":
			return URLEncoder.encode("铜", "utf-8");
		case "al":
			return URLEncoder.encode("铝", "utf-8");
		case "zn":
			return URLEncoder.encode("锌", "utf-8");
		case "pb":
			return URLEncoder.encode("铅", "utf-8");
		case "ni":
			return URLEncoder.encode("镍", "utf-8");
		case "sn":
			return URLEncoder.encode("锡", "utf-8");
		case "au":
			return URLEncoder.encode("金", "utf-8");
		case "ag":
			return URLEncoder.encode("白银", "utf-8");
		// System.out.println(name.getBytes("GBK"));
		// System.out.println("--------------");
		// System.out.println(URLEncoder.encode(name, "utf-8"));
		case "rb":
			return URLEncoder.encode("螺纹", "utf-8");
		case "wr":
			return URLEncoder.encode("线材", "utf-8");
		case "hc":
			return URLEncoder.encode("轧卷", "utf-8");
		case "ss":
			return URLEncoder.encode("不锈钢", "utf-8");
		case "sc":
			return URLEncoder.encode("原油", "utf-8");
		case "fu":
			return URLEncoder.encode("燃油", "utf-8");
		case "bu":
			return URLEncoder.encode("沥青", "utf-8");
		case "ru":
			return URLEncoder.encode("橡胶", "utf-8");
		case "nr":
			return URLEncoder.encode("20胶", "utf-8");
		case "sp":
			return URLEncoder.encode("纸浆", "utf-8");
		// 中金所
		case "IF":
			return URLEncoder.encode("股指", "utf-8");
		case "IC":
			return URLEncoder.encode("中证500", "utf-8");
		case "IH":
			return URLEncoder.encode("上证50", "utf-8");
		case "TS":
			return URLEncoder.encode("国债2", "utf-8");
		case "TF":
			return URLEncoder.encode("国债5", "utf-8");
		case "T":
			return URLEncoder.encode("国债10", "utf-8");
		// 郑商所
		case "WH":
			return URLEncoder.encode("强麦", "utf-8");
		case "PM":
			return URLEncoder.encode("普麦", "utf-8");
		case "CF":
			return URLEncoder.encode("棉花", "utf-8");
		case "TA":
			return URLEncoder.encode("苯二", "utf-8");
		case "MA":
			return URLEncoder.encode("甲醇", "utf-8");
		case "SR":
			return URLEncoder.encode("白糖", "utf-8");
		case "OI":
			return URLEncoder.encode("菜油", "utf-8");
		case "RI":
			return URLEncoder.encode("早稻", "utf-8");
		case "ZC":
			return URLEncoder.encode("动煤", "utf-8");
		case "FG":
			return URLEncoder.encode("玻璃", "utf-8");
		case "RS":
			return URLEncoder.encode("菜籽", "utf-8");
		case "RM":
			return URLEncoder.encode("菜粕", "utf-8");
		case "JR":
			return URLEncoder.encode("粳稻", "utf-8");
		case "SF":
			return URLEncoder.encode("硅铁", "utf-8");
		case "SM":
			return URLEncoder.encode("锰硅", "utf-8");
		case "LR":
			return URLEncoder.encode("晚稻", "utf-8");
		case "CY":
			return URLEncoder.encode("棉纱", "utf-8");
		case "AP":
			return URLEncoder.encode("苹果", "utf-8");
		case "UR":
			return URLEncoder.encode("尿素", "utf-8");
		case "CJ":
			return URLEncoder.encode("红枣", "utf-8");
		case "SA":
			return "纯碱";
		
		default:
			return code;
		}
	}
	
	
	
	public static String getJys(String code) throws UnsupportedEncodingException {

		switch (converCode(code)) {
		// 大商所
		case "c":
			return "dce";
		case "cs":
			return "dce";
		case "a":
			return "dce";
		case "b":
			return "dce";
		case "m":
			return "dce";
		case "y":
			return "dce";
		case "p":
			return "dce";
		case "fb":
			return "dce";
		case "bb":
			return "dce";
		case "jd":
			return "dce";
		case "rr":
			return "dce";
		case "l":
			return "dce";
		case "v":
			return "dce";
		case "pp":
			return "dce";
		case "j":
			return "dce";
		case "jm":
			return "dce";
		case "i":
			return "dce";
		case "eg":
			return "dce";
		case "eb":
			return "dce";

		// 上期所
		case "cu":
			return "shfe";
		case "al":
			return "shfe";
		case "zn":
			return "shfe";
		case "pb":
			return "shfe";
		case "ni":
			return "shfe";
		case "sn":
			return "shfe";
		case "au":
			return "shfe";
		case "ag":
			return "shfe";
		case "rb":
			return "shfe";
		case "wr":
			return "shfe";
		case "hc":
			return "shfe";
		case "ss":
			return "shfe";
		case "sc":
			return "shfe";
		case "fu":
			return "shfe";
		case "bu":
			return "shfe";
		case "ru":
			return "shfe";
		case "nr":
			return "shfe";
		case "sp":
			return "shfe";
		// 中金所
		case "IF":
			return "cffex";
		case "IC":
			return "cffex";
		case "IH":
			return "cffex";
		case "TS":
			return "cffex";
		case "TF":
			return "cffex";
		case "T":
			return "cffex";
		// 郑商所
		case "WH":
			return "czce";
		case "PM":
			return "czce";
		case "CF":
			return "czce";
		case "TA":
			return "czce";
		case "MA":
			return "czce";
		case "SR":
			return "czce";
		case "OI":
			return "czce";
		case "RI":
			return "czce";
		case "ZC":
			return "czce";
		case "FG":
			return "czce";
		case "RS":
			return "czce";
		case "RM":
			return "czce";
		case "JR":
			return "czce";
		case "SF":
			return "czce";
		case "SM":
			return "czce";
		case "LR":
			return "czce";
		case "CY":
			return "czce";
		case "AP":
			return "czce";
		case "UR":
			return "czce";
		case "CJ":
			return "czce";
		case "SA":
			return "czce";
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
