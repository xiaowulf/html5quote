package com.venus.finance.controller;

import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
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
import com.venus.finance.vo.FuturesPriceVO;
import com.venus.finance.vo.FuturesQuoteVO;

@Controller
public class IndexController {
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/index.html", method = RequestMethod.GET)
	public String home(HttpServletRequest request,ModelMap model) {
		/*
		CodeUtil codeUtil = new CodeUtil();
		List<FuturesQuoteVO> jysCodeList;
		try {
			jysCodeList = codeUtil.getCodeByJys("shfe");
			model.addAttribute("jysCodeList", jysCodeList);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		*/
		return "index";
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
	@RequestMapping(value = "/findFuturesCodeIndex.html",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String findFuturesCodeIndex(HttpServletRequest request,ModelMap model) {
		String code = request.getParameter("code");
		CodeUtil codeUtil = new CodeUtil();
		if(code.equals("index")){
			code = codeUtil.getIndexCode();
		}
		FuturesPriceVO futuresPriceVO = new FuturesPriceVO();
		Gson gson = new Gson();
        String json = gson.toJson(futuresPriceVO);
		return json;
	}
	
}
