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
		//把ATR放入到map中
		Map<String,Double>atrMap = new HashMap<String,Double>();
		try {
			String atrfiledir = initUtil.getDayDataFolder();
			String atrfileStr = atrfiledir+"/atr"+todayStr+".txt";
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
				futuresQuoteReadVO.setPreOpenInterest(Double.parseDouble(quoteStrArray[11]));
				futuresQuoteReadVO.setUpdateTime(quoteStrArray[12]);
				futuresQuoteReadVO.setDate(Long.parseLong(todayStr));
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
					order.setRemain_profit((todayQuoteMap.get(order.getCode()).getClosePrice()-order.getOpen_price()) *order.getHand());
					//order.setCcjsyk((todayQuoteMap.get(order.getCode()).getAveragePrice()-order.getOpen_price()) *order.getHand());
				}else {
					order.setRemain_profit((order.getOpen_price() - todayQuoteMap.get(order.getCode()).getClosePrice()) *order.getHand());
					//order.setCcjsyk((order.getOpen_price() - todayQuoteMap.get(order.getCode()).getAveragePrice()) *order.getHand());
				}
			}else {
				if (order.getDirection().equals("B")) {
					order.setRemain_profit((todayQuoteMap.get(order.getCode()).getClosePrice()-todayQuoteMap.get(order.getCode()).getPreClosePrice()) *order.getHand());
					//order.setCcjsyk((todayQuoteMap.get(order.getCode()).getAveragePrice()-todayQuoteMap.get(order.getCode()).getPreSettlementPrice()) *order.getHand());
				}else {
					order.setRemain_profit((todayQuoteMap.get(order.getCode()).getPreClosePrice() - todayQuoteMap.get(order.getCode()).getClosePrice()) *order.getHand());
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
				order.setRisk(order.getRemain_profit()/atr);
			}
			else
			{
				double atr = todayQuoteMap.get(order.getCode()).getHighestPrice()-todayQuoteMap.get(order.getCode()).getLowestPrice();
				order.setRisk(order.getRemain_profit()/atr);
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
				.findFuturesResultByDate(Long.parseLong(todayStr));
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
		}
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
		// 首先得到日行情的文件夹
		InitUtil initUtil = new InitUtil();
		FileUtil fileUtil = new FileUtil();
		String tick_quote_dir = "";
		try {
			tick_quote_dir = initUtil.getTickQuoteDir();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String tradeDateFile = tick_quote_dir + "/tradedate.txt";
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
		Set<String> fileNameSet = fileMap.keySet();
		Iterator<String> it = fileNameSet.iterator();
		List<String> quoteList = new ArrayList();
		while (it.hasNext()) {
			String code = it.next();
			File codeFile = fileMap.get(code);
			List<String> dataList = fileUtil.readFileToList(codeFile);
			quoteList.add(dataList.get(dataList.size() - 1) + "\n");
		}
		Collections.sort(quoteList);
		File todayQuoteFile = new File(tick_quote_dir + "/day/" + todayStr + ".txt");
		fileUtil.saveQuoteFile(todayQuoteFile, quoteList);
		futuresResultVO.setStatus(1L);
		Gson gson = new Gson();
		String json = gson.toJson(futuresResultVO);
		return json;
	}
	
	@RequestMapping(value = "/findAllResule.html", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String findAllResule(HttpServletRequest request, ModelMap model) {
		String todayStr = request.getParameter("todayStr");
		FuturesResultVO futuresResultVO = new FuturesResultVO();
		List<FuturesResult> resultList = futuresResultService.findStrategyFuturesResultByDate(Long.parseLong(todayStr));
		futuresResultVO.setStatus(1L);
		futuresResultVO.setResultList(resultList);
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
