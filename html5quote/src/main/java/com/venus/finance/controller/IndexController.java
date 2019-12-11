package com.venus.finance.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.venus.finance.util.CodeUtil;
import com.venus.finance.util.FileUtil;
import com.venus.finance.util.InitUtil;
import com.venus.finance.util.MathUtil;
import com.venus.finance.vo.CandleVO;
import com.venus.finance.vo.FuturesPriceVO;
import com.venus.finance.vo.FuturesQuoteVO;
import com.venus.finance.vo.SuggestVO;

@Controller
public class IndexController {
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/index.html", method = RequestMethod.GET)
	public String home(HttpServletRequest request,ModelMap model) {
		return "index";
	}
	@RequestMapping(value = "/suggest.html", method = RequestMethod.GET)
	public String suggest(HttpServletRequest request,ModelMap model) {
		return "suggest";
	}
	@RequestMapping(value = "/contact.html", method = RequestMethod.GET)
	public String contact(HttpServletRequest request,ModelMap model) {
		return "contact";
	}
	@RequestMapping(value = "/strategy.html", method = RequestMethod.GET)
	public String strategy(HttpServletRequest request,ModelMap model) {
		return "strategy";
	}
	@RequestMapping(value = "/backtest.html", method = RequestMethod.GET)
	public String backtest(HttpServletRequest request,ModelMap model) {
		return "backtest";
	}
	@RequestMapping(value = "/position.html", method = RequestMethod.GET)
	public String position(HttpServletRequest request,ModelMap model) {
		return "position";
	}
	@RequestMapping(value = "/suggestsave.html", method = RequestMethod.POST)
	public String suggestsave(SuggestVO suggestVO) {
		InitUtil initUtil = new InitUtil();
		File file;
		try {
			file = new File(initUtil.getSuggestFilePath());
			FileUtil fileUtil = new FileUtil();
			fileUtil.saveSuggest(file,suggestVO);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "rsuccess";
	}
	@RequestMapping(value = "/changeFuturesJys.html",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String changeFuturesJys(HttpServletRequest request,ModelMap model) {
		String jys = request.getParameter("jys");
		CodeUtil codeUtil = new CodeUtil();
		List<FuturesQuoteVO> jysCodeList = null;
		try {
			jysCodeList = codeUtil.getCodeByJys(jys);
			model.addAttribute("jysCodeList", jysCodeList);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		Gson gson = new Gson();
        String json = gson.toJson(jysCodeList);
		return json;
	}
	@RequestMapping(value = "/findFuturesCodeIndex.html",produces={"text/html;charset=UTF-8;","application/json;"})
	@ResponseBody
	public String findFuturesCodeIndex(HttpServletRequest request,ModelMap model) {
		System.out.println("-------中文----------");
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
		List<Double> settlePriceList = new ArrayList<Double>();
		List<Double> settlePriceCurList = new ArrayList<Double>();
		List<CandleVO> candlePriceList = new ArrayList<CandleVO>();
		
		Collections.reverse(dateList);
		List<String> date30List = dateList.subList(0, 30);
		Collections.reverse(date30List);
		//得到所有天的行情
		List<FuturesQuoteVO> futuresDayQuoteList = 
				codeUtil.getDayQuoteByCodeAndDate(date30List,code);
		for(FuturesQuoteVO futuresQuoteVO:futuresDayQuoteList) {
			dateRtnList.add(futuresQuoteVO.getDate());
			closePriceList.add(futuresQuoteVO.getClosePrice());
			settlePriceList.add(futuresQuoteVO.getSettlementPrice());
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
		//三次曲线拟合
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
		Gson gson = new Gson();
        String json = gson.toJson(futuresPriceVO);
		return json;
	}
	
}
