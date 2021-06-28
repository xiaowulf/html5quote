package com.venus.finance.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.venus.finance.fix.FixApplication;
import com.venus.finance.model.FuturesClose;
import com.venus.finance.model.FuturesOrders;
import com.venus.finance.model.FuturesResult;
import com.venus.finance.model.FuturesStrategy;
import com.venus.finance.model.FuturesSusOrders;
import com.venus.finance.service.IFuturesCloseService;
import com.venus.finance.service.IFuturesMessageService;
import com.venus.finance.service.IFuturesOrdersService;
import com.venus.finance.service.IFuturesResultService;
import com.venus.finance.service.IFuturesStrategyService;
import com.venus.finance.service.IFuturesSusOrdersService;
import com.venus.finance.util.CodeUtil;
import com.venus.finance.util.DateUtil;
import com.venus.finance.util.FileUtil;
import com.venus.finance.util.InitUtil;
import com.venus.finance.util.MathUtil;
import com.venus.finance.util.PropertiesUtil;
import com.venus.finance.vo.AtrVO;
import com.venus.finance.vo.CandleVO;
import com.venus.finance.vo.FuturesOrdersVO;
import com.venus.finance.vo.FuturesPriceVO;
import com.venus.finance.vo.FuturesQuoteAttrVO;
import com.venus.finance.vo.FuturesQuoteReadVO;
import com.venus.finance.vo.FuturesQuoteVO;
import com.venus.finance.vo.FuturesResultVO;
import com.venus.finance.vo.FuturesStatistics;
import com.venus.finance.vo.FuturesStrategyVO;
import com.venus.finance.vo.FuturesSusOrdersVO;
import com.venus.finance.vo.MacdVO;
import com.venus.finance.vo.MaxMinPriceVO;

@Controller
public class SettlementController {

	@RequestMapping(value = "/settlement.html", method = RequestMethod.GET)
	public String orders(HttpServletRequest request, ModelMap model) {
		String todayStr = DateUtil.getDateFormat("yyyyMMdd");
		model.put("todayStr", todayStr);
		return "settlement";
	}

	@RequestMapping(value = "/computeDateResult.html", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String computeDateResult(HttpServletRequest request, ModelMap model) {
		InitUtil initUtil = new InitUtil();
		FileUtil fileUtil = new FileUtil();
		String tick_quote_dir = "";
		try {
			tick_quote_dir = initUtil.getTickQuoteDir();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 配置文件中的信息
		String tradeDateFile = tick_quote_dir + "/tradedate.txt";
		FuturesResultVO futuresResultVO = new FuturesResultVO();
		String todayStr = request.getParameter("todayStr");
		// 得到日行情的文件夹
		System.out.println(tick_quote_dir + "/day/" + todayStr + ".txt");
		File todayQuoteFile = new File(tick_quote_dir + "/day/" + todayStr + ".txt");
		List<String> todayQuoateList = fileUtil.readFileToList(todayQuoteFile);
		File file = new File(tradeDateFile);
		List<String> dateList = fileUtil.readFileToList(file);
		int index = 0;
		boolean find = false;
		if (null != dateList && dateList.size() > 0) {
			for (String v : dateList) {
				if (v.equals(todayStr)) {
					find = true;
					break;
				}
				index++;
			}
		}
		if (!find) {
			futuresResultVO.setStatus(0L);
			Gson gson = new Gson();
			String json = gson.toJson(futuresResultVO);
			return json;
		}
		System.out.println("---1---");
		//把ATR放入到map中
		Map<String,Double>atrMap = new HashMap<String,Double>();
		try {
			String atrfiledir = initUtil.getTickQuoteDir();
			String atrfileStr = atrfiledir+"/atr/atr"+todayStr+".txt";
			File atrFile = new File(atrfileStr);
			if(atrFile.exists())
			{
				List<String> artList = fileUtil.readFileToList(atrFile);
				if(null!=artList&&artList.size()>0) {
					for (String atrStr : artList) {
						String[] atrArray = atrStr.split(",");
						atrMap.put(atrArray[0], Double.parseDouble(atrArray[1]));
					}
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("---2---");
		//获取今日的行情属性，用于计算保证金比例的
		File todayQuoteAttrFile = new File(tick_quote_dir + "/futures_code/" + todayStr + ".txt");
		List<String>todayQuoteAttrList = fileUtil.readFileToList(todayQuoteAttrFile);
		Map<String,FuturesQuoteAttrVO>futuresQuoteAttrMap = new HashMap<String,FuturesQuoteAttrVO>();
		if(null!=todayQuoteAttrList&&todayQuoteAttrList.size()>0)
		{
			for(String attr:todayQuoteAttrList) {
				String[]attrArray = attr.split(",");
				if(null!=attrArray&&attrArray.length>0)
				{
					FuturesQuoteAttrVO futuresQuoteAttrVO = new FuturesQuoteAttrVO();
					futuresQuoteAttrVO.setInstrumentID(attrArray[0]);
					futuresQuoteAttrVO.setJys(attrArray[1]);
					futuresQuoteAttrVO.setName(attrArray[2]);
					futuresQuoteAttrVO.setCode(attrArray[3]);
					futuresQuoteAttrVO.setMultiply(Double.parseDouble(attrArray[7]));
					futuresQuoteAttrVO.setLongratio(Double.parseDouble(attrArray[8]));
					futuresQuoteAttrVO.setShortratio(Double.parseDouble(attrArray[9]));
					futuresQuoteAttrMap.put(attrArray[0], futuresQuoteAttrVO);
				}
			}
		}
		//删除今日的数据
		List<FuturesResult> resultList = futuresResultService.findFuturesResultByDate(Long.parseLong(todayStr));
		for(FuturesResult result:resultList) {
			futuresResultService.deleteById(result.getId());
		}
		// 昨日
		String yesterDay = dateList.get(index - 1);
		// 把今日行情转换成map
		Map<String, FuturesQuoteReadVO> todayQuoteMap = new HashMap<String, FuturesQuoteReadVO>();
		for (String quoteStr : todayQuoateList) {
			String[] quoteStrArray = quoteStr.split(",");
			if (quoteStrArray.length > 0) {
				FuturesQuoteReadVO futuresQuoteReadVO = new FuturesQuoteReadVO();
				futuresQuoteReadVO.setInstrumentID(quoteStrArray[0]);
				futuresQuoteReadVO.setOpenPrice(Double.parseDouble(quoteStrArray[1]));
				futuresQuoteReadVO.setHighestPrice(Double.parseDouble(quoteStrArray[2]));
				futuresQuoteReadVO.setLowestPrice(Double.parseDouble(quoteStrArray[3]));
				futuresQuoteReadVO.setClosePrice(Double.parseDouble(quoteStrArray[4]));
				futuresQuoteReadVO.setAveragePrice(Double.parseDouble(quoteStrArray[5]));
				futuresQuoteReadVO.setVolume(Double.parseDouble(quoteStrArray[6]));
				futuresQuoteReadVO.setOpenInterest(Double.parseDouble(quoteStrArray[7]));
				futuresQuoteReadVO.setTurnover(Double.parseDouble(quoteStrArray[8]));
				futuresQuoteReadVO.setPreSettlementPrice(Double.parseDouble(quoteStrArray[9]));
				futuresQuoteReadVO.setPreClosePrice(Double.parseDouble(quoteStrArray[10]));
				/*
				futuresQuoteReadVO.setPreOpenInterest(Double.parseDouble(quoteStrArray[11]));
				futuresQuoteReadVO.setUpdateTime(quoteStrArray[12]);
				futuresQuoteReadVO.setDate(Long.parseLong(todayStr));
				*/
				todayQuoteMap.put(quoteStrArray[0], futuresQuoteReadVO);
			}
		}
		// 查询出所有的策略
		List<FuturesStrategy> strategyList = futuresStrategyService.findFuturesStrategyByIsUsed("1");
		//根據所有的策略，生成策略的结算数据
		Map<Long,FuturesResult> strategyResultMap = new HashMap();
		for (FuturesStrategy strategy : strategyList) {
			FuturesResult futuresResult = new FuturesResult();
			futuresResult.setStrategy_id(strategy.getId());
			futuresResult.setRecord_date(Long.parseLong(todayStr));
			strategyResultMap.put(strategy.getId(), futuresResult);
		}
		// 所有的持仓数据
		List<FuturesOrders> ordersList = futuresOrdersService.findAll();
		// 根据行情算出持仓数据的盈亏，根据开仓和方向进行计算
		for (int i=0;i<ordersList.size();i++) {
			FuturesOrders order = ordersList.get(i);
			FuturesResult futuresResult = strategyResultMap.get(order.getStrategy_id());
			if(order.getRecord_date().longValue()==Long.parseLong(todayStr))
			{
				if (order.getDirection().equals("B")) {
					order.setRemain_profit((todayQuoteMap.get(order.getCode()).getClosePrice()-order.getOpen_price()) *order.getHand()*futuresQuoteAttrMap.get(order.getCode()).getMultiply());
					//order.setCcjsyk((todayQuoteMap.get(order.getCode()).getAveragePrice()-order.getOpen_price()) *order.getHand());
				}else {
					order.setRemain_profit((order.getOpen_price() - todayQuoteMap.get(order.getCode()).getClosePrice()) *order.getHand()*futuresQuoteAttrMap.get(order.getCode()).getMultiply());
					//order.setCcjsyk((order.getOpen_price() - todayQuoteMap.get(order.getCode()).getAveragePrice()) *order.getHand());
				}
			}else {
				if (order.getDirection().equals("B")) {
					if(order.getCode().contentEquals("a2109"))
					{
						System.out.println(todayStr);
						System.out.println(todayQuoteMap.get(order.getCode()).getClosePrice());
						System.out.println(todayQuoteMap.get(order.getCode()).getPreClosePrice());
						System.out.println(todayQuoteMap.get(order.getCode()).getClosePrice());
						System.out.println(futuresQuoteAttrMap.get(order.getCode()).getMultiply());
					}
					
					System.out.println(todayQuoteMap.get(order.getCode()).getClosePrice());
					System.out.println(todayQuoteMap.get(order.getCode()).getPreClosePrice());
					System.out.println(futuresQuoteAttrMap.get(order.getCode()).getMultiply());
					System.out.println(todayQuoteMap.get(order.getCode()).getClosePrice());
					order.setRemain_profit((todayQuoteMap.get(order.getCode()).getClosePrice()-todayQuoteMap.get(order.getCode()).getPreClosePrice()) *order.getHand()*futuresQuoteAttrMap.get(order.getCode()).getMultiply());
					System.out.println(order.getRemain_profit());
					//order.setCcjsyk((todayQuoteMap.get(order.getCode()).getAveragePrice()-todayQuoteMap.get(order.getCode()).getPreSettlementPrice()) *order.getHand());
				}else {
					if(order.getCode().contentEquals("a2109"))
					{
						System.out.println(todayStr);
						System.out.println(todayQuoteMap.get(order.getCode()).getClosePrice());
						System.out.println(todayQuoteMap.get(order.getCode()).getPreClosePrice());
						System.out.println(todayQuoteMap.get(order.getCode()).getClosePrice());
						System.out.println(futuresQuoteAttrMap.get(order.getCode()).getMultiply());
					}
					order.setRemain_profit((todayQuoteMap.get(order.getCode()).getPreClosePrice() - todayQuoteMap.get(order.getCode()).getClosePrice()) *order.getHand()*futuresQuoteAttrMap.get(order.getCode()).getMultiply());
					//order.setCcjsyk((todayQuoteMap.get(order.getCode()).getPreSettlementPrice() - todayQuoteMap.get(order.getCode()).getAveragePrice()) *order.getHand());
				}
			}
			if(futuresQuoteAttrMap.containsKey(order.getCode()))
			{
				if(order.getDirection().equals("B"))
				{
					futuresResult.setBzj(futuresResult.getBzj()+
							order.getHand()*order.getOpen_price()*futuresQuoteAttrMap.get(order.getCode()).getMultiply()*futuresQuoteAttrMap.get(order.getCode()).getLongratio());
				}
				else
				{
					futuresResult.setBzj(futuresResult.getBzj()+
							order.getHand()*order.getOpen_price()*futuresQuoteAttrMap.get(order.getCode()).getMultiply()*futuresQuoteAttrMap.get(order.getCode()).getShortratio());
				}
			}
			else
			{
				futuresResult.setBzj(futuresResult.getBzj()+
						order.getHand()*order.getOpen_price()*futuresQuoteAttrMap.get(order.getCode()).getMultiply()*1);
			}
			futuresResult.setCcyk(futuresResult.getCcyk() + order.getRemain_profit());
			if(atrMap.containsKey(order.getCode()))
			{
				double atr = atrMap.get(order.getCode());
				order.setRisk(order.getRemain_profit()/(atr*futuresQuoteAttrMap.get(order.getCode()).getMultiply()));
			}
			else
			{
				double atr = todayQuoteMap.get(order.getCode()).getHighestPrice()-todayQuoteMap.get(order.getCode()).getLowestPrice();
				order.setRisk(order.getRemain_profit()/(atr*futuresQuoteAttrMap.get(order.getCode()).getMultiply()));
			}
			futuresOrdersService.update(order);
		}
		// 今日平仓数据
		List<FuturesClose> closeList = futuresCloseService.findFuturesCloseByDate(Long.parseLong(todayStr));
		// 算平仓盈亏
		for (int i = 0; i < closeList.size(); i++) {
			FuturesClose closeOrder = closeList.get(i);
			FuturesResult futuresResult = strategyResultMap.get(closeOrder.getStrategy_id());
			futuresResult.setPcyk(futuresResult.getPcyk()+closeOrder.getClose_profit());
		}
		// 昨天的计算结果
		List<FuturesResult> resultYesterDayList = futuresResultService
				.findFuturesResultByDate(Long.parseLong(yesterDay));
		Map<Long, FuturesResult> yesterDayResultMap = new HashMap<Long, FuturesResult>();
		for (FuturesResult result : resultYesterDayList) {
			yesterDayResultMap.put(result.getStrategy_id(), result);
		}
		for (FuturesStrategy strategy : strategyList) {
			//昨日结果
			FuturesResult yesterDayResult = yesterDayResultMap.get(strategy.getId());
			//今日结果
			FuturesResult futuresResult = strategyResultMap.get(strategy.getId());
			
			Double sxf = 0.0;
			for (FuturesOrders o : ordersList) {
				if (o.getRecord_date().longValue() == Long.parseLong(todayStr)
						&&o.getStrategy_id()==strategy.getId()) {
					sxf += o.getSxf();
				}
			}
			for (FuturesClose c : closeList) {
				if (c.getRecord_date().longValue() == Long.parseLong(todayStr)
						&&c.getStrategy_id()==strategy.getId()) {
					sxf += c.getSxf();
				}
			}
			futuresResult.setSxf(sxf);
			// 昨天有計算結果
			if (yesterDayResult != null) {
				futuresResult.setSrqy(yesterDayResult.getDrqy());
				System.out.println(yesterDayResult.getDrqy());
				System.out.println(futuresResult.getCcyk());
				futuresResult.setDrqy(yesterDayResult.getDrqy()+futuresResult.getPcyk()+futuresResult.getCcyk()-futuresResult.getSxf());
				futuresResult.setDwjz(futuresResult.getDrqy()/strategy.getQcqy());
				futuresResult.setLjyle(futuresResult.getDrqy()-strategy.getQcqy());
				futuresResult.setBzjratio(futuresResult.getBzj()/strategy.getQcqy());
				futuresResult.setKyzj(futuresResult.getDrqy()-futuresResult.getBzj());
			}
			//这个策略昨天没有计算结果，应该今天是第一天开始的策略
			else {
				futuresResult.setSrqy(strategy.getQcqy());
				futuresResult.setDrqy(strategy.getQcqy()+futuresResult.getPcyk()+futuresResult.getCcyk()-futuresResult.getSxf());
				futuresResult.setDwjz(futuresResult.getDrqy()/strategy.getQcqy());
				futuresResult.setLjyle(futuresResult.getDrqy()-strategy.getQcqy());
				futuresResult.setBzjratio(futuresResult.getBzj()/strategy.getQcqy());
				futuresResult.setKyzj(futuresResult.getDrqy()-futuresResult.getBzj());
			}
			futuresResultService.create(futuresResult);
			strategy.setSrqy(futuresResult.getSrqy());
			strategy.setDrqy(futuresResult.getDrqy());
			strategy.setRecord_date(futuresResult.getRecord_date());
			strategy.setKyzj(futuresResult.getKyzj());
			strategy.setDwjz(futuresResult.getDwjz());
			futuresStrategyService.create(strategy);
		}
		futuresSusOrdersService.deleteAllSusOrders();
		futuresResultVO.setStatus(3L);
		Gson gson = new Gson();
		String json = gson.toJson(futuresResultVO);
		return json;
	}

	@RequestMapping(value = "/mergeData.html", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String mergeData(HttpServletRequest request, ModelMap model) {
		String todayStr = request.getParameter("todayStr");
		FuturesResultVO futuresResultVO = new FuturesResultVO();
		System.out.println("---生成今日行情开始--------");
		System.out.println("----0-----");
		// 首先得到日行情的文件夹
		InitUtil initUtil = new InitUtil();
		FileUtil fileUtil = new FileUtil();
		System.out.println("----0.1-----");
		String tick_quote_dir = "";
		try {
			tick_quote_dir = initUtil.getTickQuoteDir();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("----0.2-----");
		System.out.println("----tick_quote_dir-----");
		String tradeDateFile = tick_quote_dir + "/tradedate.txt";
		File file = new File(tradeDateFile);
		List<String> dateList = fileUtil.readFileToList(file);
		int index = 0;
		boolean find = false;
		System.out.println("----1-----");
		if (null != dateList && dateList.size() > 0) {
			for (String v : dateList) {
				if (v.equals(todayStr)) {
					find = true;
					break;
				}
				index++;
			}
		}
		if (!find) {
			futuresResultVO.setStatus(0L);
			Gson gson = new Gson();
			String json = gson.toJson(futuresResultVO);
			return json;
		}
		System.out.println("----1.1-----");
		// Txt行情目录
		String todayQuoteFileDir = tick_quote_dir + "/ticktxt/" + todayStr;
		File todayQuoteFileDirFile = new File(todayQuoteFileDir);
		File[] fileList = todayQuoteFileDirFile.listFiles();
		List<String> fileNameList = new ArrayList<String>();
		Map<String, File> fileMap = new HashMap<String, File>();
		for (File fileTemp : fileList) {
			fileNameList.add(fileTemp.getName());
			fileMap.put(fileTemp.getName(), fileTemp);
		}
		System.out.println("----1.2-----");
		Set<String> fileNameSet = fileMap.keySet();
		Iterator<String> it = fileNameSet.iterator();
		List<String> quoteList = new ArrayList();
		while (it.hasNext()) {
			String code = it.next();
			File codeFile = fileMap.get(code);
			List<String> dataList = fileUtil.readFileToList(codeFile);
			quoteList.add(dataList.get(dataList.size() - 1) + "\n");
		}
		System.out.println("----1.3-----");
		Collections.sort(quoteList);
		File todayQuoteFile = new File(tick_quote_dir + "/day/" + todayStr + ".txt");
		fileUtil.saveQuoteFile(todayQuoteFile, quoteList);
		System.out.println("----2-----");
		//以下计算ATR
		//昨日行情
		System.out.println("---以下计算ATR--------");
		String yesterDay = dateList.get(index - 1);
		String yesterDayQuoteFileDir = tick_quote_dir + "/day/" + yesterDay+".txt";
		File yesterDayQuoteFile = new File(yesterDayQuoteFileDir);
		List<String> yesterDayQuoteList = new ArrayList<String>();
		if(yesterDayQuoteFile.exists())
		{
			yesterDayQuoteList = fileUtil.readFileToList(yesterDayQuoteFile);
		}
		//昨日ATR
		String yesterDayATRFileDir = tick_quote_dir + "/atr/atr" + yesterDay+".txt";
		File yesterDayATRFile = new File(yesterDayATRFileDir);
		List<String> yesterDayATRList = new ArrayList<String>();
		if(yesterDayATRFile.exists())
		{
			yesterDayATRList = fileUtil.readFileToList(new File(yesterDayATRFileDir));
		}
		//把今日行情转换Map
		Map<String, FuturesQuoteReadVO>todayQuoteMap = new HashMap<String, FuturesQuoteReadVO>();
		for(String todayQuote:quoteList)
		{
			String [] quoteStrArray = todayQuote.split(",");
			FuturesQuoteReadVO futuresQuoteReadVO = new FuturesQuoteReadVO();
			futuresQuoteReadVO.setInstrumentID(quoteStrArray[0]);
			futuresQuoteReadVO.setOpenPrice(Double.parseDouble(quoteStrArray[1]));
			futuresQuoteReadVO.setHighestPrice(Double.parseDouble(quoteStrArray[2]));
			futuresQuoteReadVO.setLowestPrice(Double.parseDouble(quoteStrArray[3]));
			futuresQuoteReadVO.setClosePrice(Double.parseDouble(quoteStrArray[4]));
			futuresQuoteReadVO.setAveragePrice(Double.parseDouble(quoteStrArray[5]));
			futuresQuoteReadVO.setVolume(Double.parseDouble(quoteStrArray[6]));
			futuresQuoteReadVO.setOpenInterest(Double.parseDouble(quoteStrArray[7]));
			futuresQuoteReadVO.setTurnover(Double.parseDouble(quoteStrArray[8]));
			futuresQuoteReadVO.setPreSettlementPrice(Double.parseDouble(quoteStrArray[9]));
			futuresQuoteReadVO.setPreClosePrice(Double.parseDouble(quoteStrArray[10]));
			futuresQuoteReadVO.setPreOpenInterest(Double.parseDouble(quoteStrArray[11]));
			futuresQuoteReadVO.setUpdateTime(quoteStrArray[12]);
			todayQuoteMap.put(quoteStrArray[0],futuresQuoteReadVO);
			
			
		}
		System.out.println("----3-----");
		//就是今天是第一天计算ATR值
		String todayDayATRFileDir = tick_quote_dir + "/atr/atr" + todayStr+".txt";
		Map<String,Double>atrMap = new HashMap<String,Double>();
		if(yesterDayQuoteList.size()<=0||yesterDayATRList.size()<=0)
		{
			System.out.println("----3.1-----");
			Set codeSet = todayQuoteMap.keySet();
			Iterator<String> itCodeSet = codeSet.iterator();
			while(itCodeSet.hasNext()) {
				String key = itCodeSet.next();
				atrMap.put(key, Math.abs(todayQuoteMap.get(key).getHighestPrice()-todayQuoteMap.get(key).getLowestPrice()));
			}
			Set atrSet = atrMap.keySet();
			Iterator<String> atrKeyIT=atrSet.iterator();
			List<String>atrList = new ArrayList<String>();
			while(atrKeyIT.hasNext())
			{
				String key = atrKeyIT.next();
				String value = key+","+atrMap.get(key)+"\n";
				atrList.add(value);
			}
			Collections.sort(atrList);
			fileUtil.saveQuoteFile(new File(todayDayATRFileDir), atrList);
		}
		//已经不是第一天，昨天有ATR数据
		else
		{
			System.out.println("----3.2-----");
			//把昨日的行情转化成Map
			Map<String, FuturesQuoteReadVO>yesterdayQuoteMap = new HashMap<String, FuturesQuoteReadVO>();
			for(String yesterdayQuote:yesterDayQuoteList)
			{
				String [] quoteStrArray = yesterdayQuote.split(",");
				FuturesQuoteReadVO futuresQuoteReadVO = new FuturesQuoteReadVO();
				System.out.println("----3.2.1-----"+quoteStrArray[0]);
				futuresQuoteReadVO.setInstrumentID(quoteStrArray[0]);
				futuresQuoteReadVO.setOpenPrice(Double.parseDouble(quoteStrArray[1]));
				futuresQuoteReadVO.setHighestPrice(Double.parseDouble(quoteStrArray[2]));
				futuresQuoteReadVO.setLowestPrice(Double.parseDouble(quoteStrArray[3]));
				futuresQuoteReadVO.setClosePrice(Double.parseDouble(quoteStrArray[4]));
				futuresQuoteReadVO.setAveragePrice(Double.parseDouble(quoteStrArray[5]));
				futuresQuoteReadVO.setVolume(Double.parseDouble(quoteStrArray[6]));
				futuresQuoteReadVO.setOpenInterest(Double.parseDouble(quoteStrArray[7]));
				
				futuresQuoteReadVO.setTurnover(Double.parseDouble(quoteStrArray[8]));
				futuresQuoteReadVO.setPreSettlementPrice(Double.parseDouble(quoteStrArray[9]));
				futuresQuoteReadVO.setPreClosePrice(Double.parseDouble(quoteStrArray[10]));
				//futuresQuoteReadVO.setPreOpenInterest(Double.parseDouble(quoteStrArray[11]));
				//futuresQuoteReadVO.setUpdateTime(quoteStrArray[12]);
				yesterdayQuoteMap.put(quoteStrArray[0],futuresQuoteReadVO);
				
			}
			//把昨日的ATR转化成Map
			Map<String,Double>yesterdayAtrMap = new HashMap<String,Double>();
			for(String yesterdayAtr:yesterDayATRList) {
				String[]yesterdayAtrArray = yesterdayAtr.split(",");
				yesterdayAtrMap.put(yesterdayAtrArray[0], Double.parseDouble(yesterdayAtrArray[1]));
			}
			List<String>atrList = new ArrayList<String>();
			//计算今日ATR数据
			Set codeSet = todayQuoteMap.keySet();
			Iterator<String> itCodeSet = codeSet.iterator();
			while(itCodeSet.hasNext()) {
				String key = itCodeSet.next();
				if(yesterdayQuoteMap.containsKey(key)&&yesterdayAtrMap.containsKey(key))
				{
					Double TR = Math.max(Math.max(Math.abs(todayQuoteMap.get(key).getHighestPrice()-yesterdayQuoteMap.get(key).getClosePrice()), Math.abs(todayQuoteMap.get(key).getLowestPrice()-yesterdayQuoteMap.get(key).getClosePrice())),Math.abs(todayQuoteMap.get(key).getHighestPrice()-todayQuoteMap.get(key).getLowestPrice()));
					Double atr = (19*yesterdayAtrMap.get(key)+TR)/20;
					String value = key+","+atr+"\n";
					atrList.add(value);
				}
			}
			//保存数据
			Collections.sort(atrList);
			fileUtil.saveQuoteFile(new File(todayDayATRFileDir), atrList);
		}
		System.out.println("----4-----");
		System.out.println("---计算ATR完毕--------");
		//以下计算20天MAXMIN
		System.out.println("---开始计算20Day MaxMin-----");
		String todayMaxMinFileDir = tick_quote_dir + "/maxmin/" + todayStr+"day20maxmin.txt";
		String yester20DayMaxMinFileDir = tick_quote_dir + "/maxmin/" + yesterDay+"day20maxmin.txt";
		File yester20DayMaxMinFile = new File(yester20DayMaxMinFileDir);
		Map<String,MaxMinPriceVO>todayMaxMin = new HashMap<String,MaxMinPriceVO>();
		if(yester20DayMaxMinFile.exists())
		{
			Set codeSet = todayQuoteMap.keySet();
			Iterator<String> itTodaySet = codeSet.iterator();
			while(itTodaySet.hasNext()) {
				String key = itTodaySet.next();
				MaxMinPriceVO maxMinPriceVO = new MaxMinPriceVO();
				maxMinPriceVO.setInstrumentID(key);
				maxMinPriceVO.setMaxValue(todayQuoteMap.get(key).getHighestPrice());
				maxMinPriceVO.setMinValue(todayQuoteMap.get(key).getLowestPrice());
				todayMaxMin.put(key, maxMinPriceVO);
			}
			for(int k=1;k<20;k++)
			{
				String day = dateList.get(index-k);
				if(day!=null&&!day.equals(""))
				{
					String dayMaxMinFileDir = tick_quote_dir + "/day/" + dateList.get(index-k)+".txt";
					File dayMaxMinFile = new File(dayMaxMinFileDir);
					if(dayMaxMinFile.exists())
					{
						List<String> dayMaxMinList = fileUtil.readFileToList(dayMaxMinFile);
						for(String dayMaxMinStr:dayMaxMinList)
						{
							String[]dayMaxMinStrArray = dayMaxMinStr.split(",");
							if(todayMaxMin.containsKey(dayMaxMinStrArray[0]))
							{
								
								if(todayMaxMin.get(dayMaxMinStrArray[0]).getMaxValue()<Double.parseDouble(dayMaxMinStrArray[2]))
								{
									if(dayMaxMinStrArray[0].equals("AP110"))
									{
										System.out.println("--------"+index);
										System.out.println("--------"+dayMaxMinFileDir);
										System.out.println("--------"+dayMaxMinStrArray[1]);
										System.out.println("--------"+todayMaxMin.get(dayMaxMinStrArray[0]).getMaxValue());
									}
									todayMaxMin.get(dayMaxMinStrArray[0]).setMaxValue(Double.parseDouble(dayMaxMinStrArray[2]));
								}
								//System.out.println("--------"+dayMaxMinStrArray[0]);
								if(todayMaxMin.get(dayMaxMinStrArray[0]).getMinValue()>Double.parseDouble(dayMaxMinStrArray[3]))
								{
									todayMaxMin.get(dayMaxMinStrArray[0]).setMinValue(Double.parseDouble(dayMaxMinStrArray[3]));
								}
							}
						}
					}
				}
			}
			System.out.println("----5-----");
			List<String>maxMinList = new ArrayList<String>();
			Iterator<String> itCodeSet = codeSet.iterator();
			while(itCodeSet.hasNext()) {
				String key = itCodeSet.next();
				String value = key+","+todayMaxMin.get(key).getMaxValue()+","+todayMaxMin.get(key).getMinValue()+"\n";
				maxMinList.add(value);
			}
			Collections.sort(maxMinList);
			fileUtil.saveQuoteFile(new File(todayMaxMinFileDir), maxMinList);
		}
		//昨日没有最大值和最小值，则把几天的值放入到文件中
		else
		{
			Set codeSet = todayQuoteMap.keySet();
			List<String>maxMinList = new ArrayList<String>();
			Iterator<String> itCodeSet = codeSet.iterator();
			while(itCodeSet.hasNext()) {
				String key = itCodeSet.next();
				String value = key+","+todayQuoteMap.get(key).getHighestPrice()+","+todayQuoteMap.get(key).getLowestPrice()+"\n";
				maxMinList.add(value);
			}
			Collections.sort(maxMinList);
			fileUtil.saveQuoteFile(new File(todayMaxMinFileDir), maxMinList);
		}
		System.out.println("----6-----");
		System.out.println("---计算20Day MaxMin完成-----");
		System.out.println("---计算5分钟数据开始-----");
		
		{
			Set codeSet = todayQuoteMap.keySet();
			List<String>maxMinList = new ArrayList<String>();
			Iterator<String> itCodeSet = codeSet.iterator();
			
			while(itCodeSet.hasNext()) {
				String key = itCodeSet.next();
				
				String minute5FileDir = tick_quote_dir + "/minute5/" + todayStr+"/"+key+".txt";
				File minute5File = new File(minute5FileDir);
				if (!minute5File.exists()) {	
					//文件不存在则创建文件，先创建目录
					File dir = new File(minute5File.getParent());
					dir.mkdirs();
					try {
						minute5File.createNewFile();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				//有了文件就开始读取文件
				File codeTickFile = new File(tick_quote_dir+"/ticktxt/"+key);
				if(codeTickFile.exists()) {
					List<String> todayQuoteList = fileUtil.readFileToList(codeTickFile);
					for(String quoteStr:todayQuoteList) {
						String[] quoteStrArry=quoteStr.split(",");
						
					}
				}
			
				
			}
		}
		System.out.println("---计算5分钟数据结束-----");
		futuresResultVO.setStatus(1L);
		Gson gson = new Gson();
		String json = gson.toJson(futuresResultVO);
		return json;
	}
	
	@RequestMapping(value = "/findAllResult.html", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String findAllResult(HttpServletRequest request, ModelMap model) {
		String todayStr = request.getParameter("todayStr");
		FuturesResultVO futuresResultVO = new FuturesResultVO();
		List<FuturesResult> resultList = futuresResultService.findStrategyFuturesResultByDate(Long.parseLong(todayStr));
		futuresResultVO.setStatus(1L);
		futuresResultVO.setResultList(resultList);
		Gson gson = new Gson();
		String json = gson.toJson(futuresResultVO);
		return json;
	}
	
	
	@RequestMapping(value = "/findResultDetail.html", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String findResultDetail(HttpServletRequest request, ModelMap model) {
		String strategy_id = request.getParameter("strategy_id");
		List<Object[]>strategyList = futuresResultService.findFuturesResultByStrategyID(Long.parseLong(strategy_id));
		FuturesResultVO futuresResultVO = new FuturesResultVO();
		List<Long>dateRtnList = new ArrayList<Long>();
		List<Double>ljyleList = new ArrayList<Double>();
		List<Double>dwjzList = new ArrayList<Double>();
		for(Object[] result:strategyList)
		{
			FuturesResult futuresResult = (FuturesResult)result[0];
			FuturesStrategy futuresStrategy = (FuturesStrategy)result[1];
			dateRtnList.add(futuresResult.getRecord_date());
			ljyleList.add(futuresResult.getLjyle());
			dwjzList.add(futuresResult.getDwjz());
		}
		futuresResultVO.setDateRtnList(dateRtnList);
		futuresResultVO.setLjyleList(ljyleList);
		futuresResultVO.setDwjzList(dwjzList);
		futuresResultVO.setStatus(1L);
		Gson gson = new Gson();
		String json = gson.toJson(futuresResultVO);
		return json;
	}
	
	
	
	
	
	@Resource(name = "futuresStrategyService")
	private IFuturesStrategyService futuresStrategyService;
	@Resource(name = "futuresOrdersService")
	private IFuturesOrdersService futuresOrdersService;
	@Resource(name = "futuresCloseService")
	private IFuturesCloseService futuresCloseService;
	@Resource(name = "futuresSusOrdersService")
	private IFuturesSusOrdersService futuresSusOrdersService;
	@Resource(name = "futuresResultService")
	private IFuturesResultService futuresResultService;
}
