package com.venus.finance.controller;

import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;

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
import com.venus.finance.util.CodeUtil;
import com.venus.finance.util.MathUtil;
import com.venus.finance.vo.AtrVO;
import com.venus.finance.vo.CandleVO;
import com.venus.finance.vo.FuturesPriceVO;
import com.venus.finance.vo.FuturesQuoteVO;
import com.venus.finance.vo.FuturesStatistics;
import com.venus.finance.vo.MacdVO;
import com.venus.finance.vo.MaxMinPriceVO;

@Controller
public class AnalyseController {
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/analyse.html", method = RequestMethod.GET)
	public String analyse(HttpServletRequest request,ModelMap model) {
		return "analyse";
	}
	@RequestMapping(value = "/findCodeStatistics.html",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String findCodeStatistics(HttpServletRequest request,ModelMap model) {
		String code = request.getParameter("code");
		//得到了code查询今日的文件信息返回到前台
		CodeUtil codeUtil = new CodeUtil();
		List<String> dateList = codeUtil.getTradeDate();
		String todayStr="";
		FuturesStatistics futuresStatistics = new FuturesStatistics();
		if(dateList!=null&&dateList.size()>0) {
			todayStr = dateList.get(dateList.size()-1);
		}
		FuturesQuoteVO futuresQuoteVO = codeUtil.getDayQuoteByCodeAndDate(code, todayStr);
		if(null!=futuresQuoteVO) {
			futuresStatistics.setFuturesQuoteVO(futuresQuoteVO);
		}else {
			futuresStatistics.setFuturesQuoteVO(new FuturesQuoteVO());
		}
		MaxMinPriceVO maxMinPriceVO = codeUtil.getMaxMinPriceVOByCodeAndDate(code, todayStr);
		if(null!=maxMinPriceVO) {
			futuresStatistics.setMaxMinPriceVO(maxMinPriceVO);
		}else {
			futuresStatistics.setMaxMinPriceVO(new MaxMinPriceVO());
		}
		AtrVO atrVO = codeUtil.getAtrByCodeAndDate(code, todayStr);
		if(null!=atrVO) {
			futuresStatistics.setAtrvo(atrVO);
		}else {
			futuresStatistics.setAtrvo(new AtrVO());
		}
		//找出120日以内的均值
		MacdVO macdVO = codeUtil.getMacdVOByCodeAndDate(code, todayStr);
		futuresStatistics.setInstrumentID(code);
		futuresStatistics.setTodayStr(todayStr);
		futuresStatistics.setMacdVO(macdVO);
		Gson gson = new Gson();
        String json = gson.toJson(futuresStatistics);
		return json;
	}
	
	
	//生成图形
	@RequestMapping(value = "/findFuturesCharts.html",produces={"text/html;charset=UTF-8;","application/json;"})
	@ResponseBody
	public String findFuturesCharts(HttpServletRequest request,ModelMap model) {
		String code = request.getParameter("code");
		CodeUtil codeUtil = new CodeUtil();
		MathUtil mathUtil = new MathUtil();
		List<Long>dateRtnList = new ArrayList<Long>();
		if(code.equals("index")){
			code = codeUtil.getIndexCode();
		}
		//得到所有的成交日期
		List<String> dateList = codeUtil.getTradeDate();
		List<Double> closePriceList = new ArrayList<Double>();
		List<Double> ccVolumeList = new ArrayList<Double>();
		List<Double> volumeList = new ArrayList<Double>();
		List<Double> settlePriceList = new ArrayList<Double>();
		List<Double> settlePriceCurList = new ArrayList<Double>();
		List<CandleVO> candlePriceList = new ArrayList<CandleVO>();
		List<MacdVO> macdList = new ArrayList<MacdVO>();
		
		Collections.reverse(dateList);
		List<String> date60List = dateList.subList(0, 60);
		Collections.reverse(date60List);
		//得到所有天的行情
		List<FuturesQuoteVO> futuresDayQuoteList = 
				codeUtil.getDayQuoteByCodeAndDate(date60List,code);
		for(FuturesQuoteVO futuresQuoteVO:futuresDayQuoteList) {
			dateRtnList.add(futuresQuoteVO.getDate());
			closePriceList.add(futuresQuoteVO.getClosePrice());
			settlePriceList.add(futuresQuoteVO.getSettlementPrice());
			ccVolumeList.add(futuresQuoteVO.getCcvolume());
			volumeList.add(futuresQuoteVO.getVolume());
			macdList.add(futuresQuoteVO.getMacdVO());
			CandleVO candleVO = new CandleVO();
			candleVO.setOpenPrice(futuresQuoteVO.getOpenPrice());
			candleVO.setHighPrice(futuresQuoteVO.getHighestPrice());
			candleVO.setLowPrice(futuresQuoteVO.getLowestPrice());
			candleVO.setDate(futuresQuoteVO.getDate());
			candleVO.setClosePrice(futuresQuoteVO.getClosePrice());
			candlePriceList.add(candleVO);
		}
		
		
		Double []arrayX = new Double[dateRtnList.size()];
		Double []arrayY = new Double[dateRtnList.size()];
		Double []arrayR = new Double[dateRtnList.size()];
		for(int i=0;i<dateRtnList.size();i++){
			arrayX[i] = new Double(i+1);
		}
		for(int i=0;i<settlePriceList.size();i++){
			arrayY[i] = new Double(settlePriceList.get(i));
		}
		//结算价三次曲线拟合
		double[] result =mathUtil.generateFormula(arrayX, arrayY, 3);
		
		for(int i=0;i<arrayX.length;i++){
			arrayR[i] = result[3]*Math.pow(arrayX[i], 3)+result[2]*Math.pow(arrayX[i], 2)+result[1]*Math.pow(arrayX[i], 1)+result[0];
		}
		for(int i=0;i<arrayR.length;i++){
			settlePriceCurList.add(arrayR[i]);
		}
		FuturesPriceVO futuresPriceVO = new FuturesPriceVO();
		futuresPriceVO.setCode(code);
		futuresPriceVO.setDateRtnList(dateRtnList);
		futuresPriceVO.setClosePriceList(closePriceList);
		futuresPriceVO.setSettlePriceList(settlePriceList);
		futuresPriceVO.setSettlePriceCurList(settlePriceCurList);
		futuresPriceVO.setCandlePriceList(candlePriceList);
		futuresPriceVO.setMacdList(macdList);
		futuresPriceVO.setVolumeList(volumeList);
		futuresPriceVO.setCcVolumeList(ccVolumeList);
		Gson gson = new Gson();
        String json = gson.toJson(futuresPriceVO);
		return json;
	}
	
}
