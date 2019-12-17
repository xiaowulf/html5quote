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
	public String analyse(HttpServletRequest request, ModelMap model) {
		return "analyse";
	}

	@RequestMapping(value = "/findCodeStatistics.html", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String findCodeStatistics(HttpServletRequest request, ModelMap model) {
		String code = request.getParameter("code");
		// 得到了code查询今日的文件信息返回到前台
		CodeUtil codeUtil = new CodeUtil();
		List<String> dateList = codeUtil.getTradeDate();
		String todayStr = "";
		FuturesStatistics futuresStatistics = new FuturesStatistics();
		if (dateList != null && dateList.size() > 0) {
			todayStr = dateList.get(dateList.size() - 1);
		}
		FuturesQuoteVO futuresQuoteVO = codeUtil.getDayQuoteByCodeAndDate(code, todayStr);
		if (null != futuresQuoteVO) {
			futuresStatistics.setFuturesQuoteVO(futuresQuoteVO);
		} else {
			futuresStatistics.setFuturesQuoteVO(new FuturesQuoteVO());
		}
		MaxMinPriceVO maxMinPriceVO = codeUtil.getMaxMinPriceVOByCodeAndDate(code, todayStr);
		if (null != maxMinPriceVO) {
			futuresStatistics.setMaxMinPriceVO(maxMinPriceVO);
		} else {
			futuresStatistics.setMaxMinPriceVO(new MaxMinPriceVO());
		}
		AtrVO atrVO = codeUtil.getAtrByCodeAndDate(code, todayStr);
		if (null != atrVO) {
			futuresStatistics.setAtrvo(atrVO);
		} else {
			futuresStatistics.setAtrvo(new AtrVO());
		}
		// 找出120日以内的均值
		MacdVO macdVO = codeUtil.getMacdVOByCodeAndDate(code, todayStr);
		futuresStatistics.setInstrumentID(code);
		futuresStatistics.setTodayStr(todayStr);
		futuresStatistics.setMacdVO(macdVO);
		Gson gson = new Gson();
		String json = gson.toJson(futuresStatistics);
		return json;
	}

	// 生成图形
	@RequestMapping(value = "/findFuturesCharts.html", produces = { "text/html;charset=UTF-8;", "application/json;" })
	@ResponseBody
	public String findFuturesCharts(HttpServletRequest request, ModelMap model) {
		String code = request.getParameter("code");
		CodeUtil codeUtil = new CodeUtil();
		MathUtil mathUtil = new MathUtil();
		List<Long> dateRtnList = new ArrayList<Long>();
		if (code.equals("index")) {
			code = codeUtil.getIndexCode();
		}
		// 得到所有的成交日期
		List<String> dateList = codeUtil.getTradeDate();
		List<Double> closePriceList = new ArrayList<Double>();
		List<Double> ccVolumeList = new ArrayList<Double>();
		List<Double> volumeList = new ArrayList<Double>();
		List<Double> settlePriceList = new ArrayList<Double>();
		List<Double> settlePriceCurList = new ArrayList<Double>();
		List<CandleVO> candlePriceList = new ArrayList<CandleVO>();
		List<MacdVO> macdList = new ArrayList<MacdVO>();
		List<Double> closePriceCurList = new ArrayList<Double>();
		List<Double> closePriceDeriCurList = new ArrayList<Double>();
		List<Double> macd5CurList = new ArrayList<Double>();
		List<Double> macd10CurList = new ArrayList<Double>();
		List<Double> macd20CurList = new ArrayList<Double>();
		List<Double> macd40CurList = new ArrayList<Double>();
		List<Double> macd60CurList = new ArrayList<Double>();
		List<Double> vdivccList = new ArrayList<Double>();
		
		Collections.reverse(dateList);
		List<String> date60List = dateList.subList(0, 60);
		Collections.reverse(date60List);
		// 得到所有天的行情
		List<FuturesQuoteVO> futuresDayQuoteList = codeUtil.getDayQuoteByCodeAndDate(date60List, code);
		for (FuturesQuoteVO futuresQuoteVO : futuresDayQuoteList) {
			dateRtnList.add(futuresQuoteVO.getDate());
			closePriceList.add(futuresQuoteVO.getClosePrice());
			settlePriceList.add(futuresQuoteVO.getSettlementPrice());
			ccVolumeList.add(futuresQuoteVO.getCcvolume());
			volumeList.add(futuresQuoteVO.getVolume());
			if(futuresQuoteVO.getCcvolume()!=0.0){
				vdivccList.add(futuresQuoteVO.getVolume()/futuresQuoteVO.getCcvolume());
			}else{
				vdivccList.add(0.0D);
			}
			macdList.add(futuresQuoteVO.getMacdVO());
			CandleVO candleVO = new CandleVO();
			candleVO.setOpenPrice(futuresQuoteVO.getOpenPrice());
			candleVO.setHighPrice(futuresQuoteVO.getHighestPrice());
			candleVO.setLowPrice(futuresQuoteVO.getLowestPrice());
			candleVO.setDate(futuresQuoteVO.getDate());
			candleVO.setClosePrice(futuresQuoteVO.getClosePrice());
			candlePriceList.add(candleVO);
		}

		// 结算价曲线拟合
		Double[] arrayX = new Double[dateRtnList.size()];
		Double[] arrayY = new Double[dateRtnList.size()];
		Double[] arrayR = new Double[dateRtnList.size()];
		for (int i = 0; i < dateRtnList.size(); i++) {
			arrayX[i] = new Double(i + 1);
		}
		for (int i = 0; i < settlePriceList.size(); i++) {
			arrayY[i] = new Double(settlePriceList.get(i));
		}
		// 结算价三次曲线拟合
		double[] result = mathUtil.generateFormula(arrayX, arrayY, 3);
		for (int i = 0; i < arrayX.length; i++) {
			arrayR[i] = result[3] * Math.pow(arrayX[i], 3) + result[2] * Math.pow(arrayX[i], 2)
					+ result[1] * Math.pow(arrayX[i], 1) + result[0];
		}
		for (int i = 0; i < arrayR.length; i++) {
			settlePriceCurList.add(arrayR[i]);
		}

		// 收盘价三次曲线拟合
		Double[] arrayXS = new Double[dateRtnList.size()];
		Double[] arrayYS = new Double[dateRtnList.size()];
		Double[] arrayRS = new Double[dateRtnList.size()];
		for (int i = 0; i < dateRtnList.size(); i++) {
			arrayXS[i] = new Double(i + 1);
		}
		for (int i = 0; i < closePriceList.size(); i++) {
			arrayYS[i] = new Double(closePriceList.get(i));
		}
		double[] resultS = mathUtil.generateFormula(arrayXS, arrayYS, 3);

		for (int i = 0; i < arrayXS.length; i++) {
			arrayRS[i] = resultS[3] * Math.pow(arrayXS[i], 3) + resultS[2] * Math.pow(arrayXS[i], 2)
					+ resultS[1] * Math.pow(arrayXS[i], 1) + result[0];
		}
		
		for (int i = 0; i < arrayRS.length; i++) {
			closePriceCurList.add(arrayRS[i]);
		}
		//收盘价的导数曲线拟合
		

		// MACD三次曲线拟合
		Double[] arrayXMacd5 = new Double[dateRtnList.size()];
		Double[] arrayYMacd5 = new Double[dateRtnList.size()];
		Double[] arrayRMacd5 = new Double[dateRtnList.size()];
		for (int i = 0; i < dateRtnList.size(); i++) {
			arrayXMacd5[i] = new Double(i + 1);
		}
		for (int i = 0; i < macdList.size(); i++) {
			arrayYMacd5[i] = new Double(macdList.get(i).getMacd5());
		}
		double[] resultMacd5 = mathUtil.generateFormula(arrayXMacd5, arrayYMacd5, 3);

		for (int i = 0; i < arrayXMacd5.length; i++) {
			arrayRMacd5[i] = resultMacd5[3] * Math.pow(arrayXMacd5[i], 3) + resultMacd5[2] * Math.pow(arrayXMacd5[i], 2)
					+ resultMacd5[1] * Math.pow(arrayXMacd5[i], 1) + resultMacd5[0];
		}
		for (int i = 0; i < arrayRMacd5.length; i++) {
			macd5CurList.add(arrayRMacd5[i]);
		}
		// 10日
		Double[] arrayXMacd10 = new Double[dateRtnList.size()];
		Double[] arrayYMacd10 = new Double[dateRtnList.size()];
		Double[] arrayRMacd10 = new Double[dateRtnList.size()];
		for (int i = 0; i < dateRtnList.size(); i++) {
			arrayXMacd10[i] = new Double(i + 1);
		}
		for (int i = 0; i < macdList.size(); i++) {
			arrayYMacd10[i] = new Double(macdList.get(i).getMacd10());
		}
		double[] resultMacd10 = mathUtil.generateFormula(arrayXMacd10, arrayYMacd10, 3);

		for (int i = 0; i < arrayXMacd10.length; i++) {
			arrayRMacd10[i] = resultMacd10[3] * Math.pow(arrayXMacd10[i], 3)
					+ resultMacd10[2] * Math.pow(arrayXMacd10[i], 2) + resultMacd10[1] * Math.pow(arrayXMacd10[i], 1)
					+ resultMacd10[0];
		}
		for (int i = 0; i < arrayRMacd10.length; i++) {
			macd10CurList.add(arrayRMacd10[i]);
		}
		// 20日
		Double[] arrayXMacd20 = new Double[dateRtnList.size()];
		Double[] arrayYMacd20 = new Double[dateRtnList.size()];
		Double[] arrayRMacd20 = new Double[dateRtnList.size()];
		for (int i = 0; i < dateRtnList.size(); i++) {
			arrayXMacd20[i] = new Double(i + 1);
		}
		for (int i = 0; i < macdList.size(); i++) {
			arrayYMacd20[i] = new Double(macdList.get(i).getMacd20());
		}
		double[] resultMacd20 = mathUtil.generateFormula(arrayXMacd20, arrayYMacd20, 3);

		for (int i = 0; i < arrayXMacd20.length; i++) {
			arrayRMacd20[i] = resultMacd20[3] * Math.pow(arrayXMacd20[i], 3)
					+ resultMacd20[2] * Math.pow(arrayXMacd20[i], 2) + resultMacd20[1] * Math.pow(arrayXMacd20[i], 1)
					+ resultMacd20[0];
		}
		for (int i = 0; i < arrayRMacd20.length; i++) {
			macd20CurList.add(arrayRMacd20[i]);
		}
		// 40日
		Double[] arrayXMacd40 = new Double[dateRtnList.size()];
		Double[] arrayYMacd40 = new Double[dateRtnList.size()];
		Double[] arrayRMacd40 = new Double[dateRtnList.size()];
		for (int i = 0; i < dateRtnList.size(); i++) {
			arrayXMacd40[i] = new Double(i + 1);
		}
		for (int i = 0; i < macdList.size(); i++) {
			arrayYMacd40[i] = new Double(macdList.get(i).getMacd40());
		}
		double[] resultMacd40 = mathUtil.generateFormula(arrayXMacd40, arrayYMacd40, 3);

		for (int i = 0; i < arrayXMacd40.length; i++) {
			arrayRMacd40[i] = resultMacd40[3] * Math.pow(arrayXMacd40[i], 3)
					+ resultMacd40[2] * Math.pow(arrayXMacd40[i], 2) + resultMacd40[1] * Math.pow(arrayXMacd40[i], 1)
					+ resultMacd40[0];
		}
		for (int i = 0; i < arrayRMacd40.length; i++) {
			macd40CurList.add(arrayRMacd40[i]);
		}
		// 60日
		Double[] arrayXMacd60 = new Double[dateRtnList.size()];
		Double[] arrayYMacd60 = new Double[dateRtnList.size()];
		Double[] arrayRMacd60 = new Double[dateRtnList.size()];
		for (int i = 0; i < dateRtnList.size(); i++) {
			arrayXMacd60[i] = new Double(i + 1);
		}
		for (int i = 0; i < macdList.size(); i++) {
			arrayYMacd60[i] = new Double(macdList.get(i).getMacd60());
		}
		double[] resultMacd60 = mathUtil.generateFormula(arrayXMacd60, arrayYMacd60, 3);

		for (int i = 0; i < arrayXMacd60.length; i++) {
			arrayRMacd60[i] = resultMacd60[3] * Math.pow(arrayXMacd60[i], 3)
					+ resultMacd60[2] * Math.pow(arrayXMacd60[i], 2) + resultMacd60[1] * Math.pow(arrayXMacd60[i], 1)
					+ resultMacd60[0];
		}
		for (int i = 0; i < arrayRMacd60.length; i++) {
			macd60CurList.add(arrayRMacd60[i]);
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
		futuresPriceVO.setClosePriceCurList(closePriceCurList);
		futuresPriceVO.setClosePriceDeriCurList(closePriceDeriCurList);
		futuresPriceVO.setMacd5CurList(macd5CurList);
		futuresPriceVO.setMacd10CurList(macd10CurList);
		futuresPriceVO.setMacd20CurList(macd20CurList);
		futuresPriceVO.setMacd40CurList(macd40CurList);
		futuresPriceVO.setMacd60CurList(macd60CurList);
		futuresPriceVO.setVdivccList(vdivccList);
		Gson gson = new Gson();
		String json = gson.toJson(futuresPriceVO);
		return json;
	}

}
