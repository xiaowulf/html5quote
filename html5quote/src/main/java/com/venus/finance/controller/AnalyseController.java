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
import com.venus.finance.vo.CandleVO;
import com.venus.finance.vo.FuturesPriceVO;
import com.venus.finance.vo.FuturesQuoteVO;
import com.venus.finance.vo.FuturesStatistics;
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
		futuresStatistics.setInstrumentID(code);
		futuresStatistics.setTodayStr(todayStr);
		Gson gson = new Gson();
        String json = gson.toJson(futuresStatistics);
		return json;
	}
	
}
