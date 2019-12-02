package com.venus.finance.controller;

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

import com.venus.finance.model.User;
import com.venus.finance.util.CodeUtil;

@Controller
public class IndexController {
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/index.html", method = RequestMethod.GET)
	public String home(HttpServletRequest request,ModelMap model) {
		CodeUtil codeUtil = new CodeUtil();
		List<String> jysCodeList = codeUtil.getCodeByJys("czce");
		request.setAttribute("jysCodeList", jysCodeList);
		return "index";
	}
	
}
