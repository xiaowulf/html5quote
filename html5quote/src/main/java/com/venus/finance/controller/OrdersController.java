package com.venus.finance.controller;

import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
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
import com.venus.finance.model.FuturesStrategy;
import com.venus.finance.service.IFuturesMessageService;
import com.venus.finance.service.IFuturesStrategyService;
import com.venus.finance.util.CodeUtil;
import com.venus.finance.util.MathUtil;
import com.venus.finance.vo.AtrVO;
import com.venus.finance.vo.CandleVO;
import com.venus.finance.vo.FuturesPriceVO;
import com.venus.finance.vo.FuturesQuoteVO;
import com.venus.finance.vo.FuturesStatistics;
import com.venus.finance.vo.FuturesStrategyVO;
import com.venus.finance.vo.MacdVO;
import com.venus.finance.vo.MaxMinPriceVO;

@Controller
public class OrdersController {
	
	@RequestMapping(value = "/findStrategy.html", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String findStrategy(HttpServletRequest request, ModelMap model) {
		List<FuturesStrategy> strategyList = futuresStrategyService.findAll();
		FuturesStrategyVO futuresStrategyVO = new FuturesStrategyVO();
		futuresStrategyVO.setStrategyList(strategyList);
		Gson gson = new Gson();
		String json = gson.toJson(futuresStrategyVO);
		return json;
	}
	@Resource(name="futuresStrategyService")
    private IFuturesStrategyService futuresStrategyService;
	

}
