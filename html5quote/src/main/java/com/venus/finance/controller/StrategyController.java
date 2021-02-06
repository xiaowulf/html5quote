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
import com.venus.finance.vo.FuturesStrategyOneVO;
import com.venus.finance.vo.FuturesStrategyVO;
import com.venus.finance.vo.FuturesSusOrdersVO;
import com.venus.finance.vo.MacdVO;
import com.venus.finance.vo.MaxMinPriceVO;

@Controller
public class StrategyController {

	
	@RequestMapping(value = "/strategy.html", method = RequestMethod.GET)
	public String strategy(HttpServletRequest request,ModelMap model) {
		List<FuturesStrategy> strategyList = futuresStrategyService.findAll();
		model.put("list", strategyList);
		return "strategy";
	}
	
	@RequestMapping(value = "/editStrategy.html", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String editStrategy(HttpServletRequest request, ModelMap model) {
		String id = request.getParameter("id");
		FuturesStrategyOneVO futuresStrategyOneVO = new FuturesStrategyOneVO();
		if(null==id||id.contentEquals("0"))
		{
			futuresStrategyOneVO.setStatus("0");
			Gson gson = new Gson();
			String json = gson.toJson(futuresStrategyOneVO);
			return json;
		}
		FuturesStrategy futuresStrategy = futuresStrategyService.findOne(Long.parseLong(id));
		futuresStrategyOneVO.setStatus("1");
		futuresStrategyOneVO.setFuturesStrategy(futuresStrategy);
		Gson gson = new Gson();
		String json = gson.toJson(futuresStrategyOneVO);
		return json;
	}
	@RequestMapping(value = "/saveStrategy.html", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String saveStrategy(HttpServletRequest request, ModelMap model) {
		String id = request.getParameter("id");
		FuturesStrategyOneVO futuresStrategyOneVO = new FuturesStrategyOneVO();
		if(null==id||id.contentEquals("0"))
		{
			futuresStrategyOneVO.setStatus("0");
			Gson gson = new Gson();
			String json = gson.toJson(futuresStrategyOneVO);
			return json;
		}
		FuturesStrategy futuresStrategy = futuresStrategyService.findOne(Long.parseLong(id));
		futuresStrategy.setInitdate(Long.parseLong(request.getParameter("initdate")));
		futuresStrategy.setName(request.getParameter("name"));
		futuresStrategy.setIs_use(request.getParameter("is_use"));
		futuresStrategy.setQcqy(Double.parseDouble(request.getParameter("qcqy")));
		futuresStrategyService.update(futuresStrategy);
		futuresStrategyOneVO.setStatus("1");
		futuresStrategyOneVO.setFuturesStrategy(futuresStrategy);
		Gson gson = new Gson();
		String json = gson.toJson(futuresStrategyOneVO);
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
