package com.venus.finance.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.venus.finance.fix.FixApplication;
import com.venus.finance.model.TbEmployee;
import com.venus.finance.model.ChangePwdForm;
import com.venus.finance.model.FuturesMessage;
import com.venus.finance.model.LoginCommand;
import com.venus.finance.model.RtnResultVO;
import com.venus.finance.service.IEmployeeService;
import com.venus.finance.service.IFuturesMessageService;
import com.venus.finance.util.CodeUtil;
import com.venus.finance.util.FileUtil;
import com.venus.finance.util.InitUtil;
import com.venus.finance.util.MD5;
import com.venus.finance.util.MathUtil;
import com.venus.finance.vo.CandleVO;
import com.venus.finance.vo.FuturesPriceVO;
import com.venus.finance.vo.FuturesQuoteVO;
import com.venus.finance.vo.SuggestVO;

@Controller
public class LoginController {
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/login.html", method = RequestMethod.GET)
	public String login(HttpServletRequest request,ModelMap model) {
		return "login";
	}
	@RequestMapping(value = "/main.html", method = RequestMethod.GET)
	public String main(HttpServletRequest request,ModelMap model) {
		return "main";
	}
	@RequestMapping(value = "/m-password.html", method = RequestMethod.GET)
	public String mpassword(FuturesMessage futuresMessage) {
		return "m-password";
	}
	
	@RequestMapping(value = "/changePwd.html",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String changePwd(HttpSession session,ModelMap model,ChangePwdForm changePwdForm) {
		RtnResultVO rtnResultVO = new RtnResultVO();
		Gson gson = new Gson();
        String json = gson.toJson(rtnResultVO);
		return json;
	}
	
	
	@RequestMapping(value = "/loginCheck.html",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String changeFuturesJys(HttpSession session,ModelMap model,LoginCommand loginCommand) {
		String verycode = (String)session.getAttribute("verycode");
		RtnResultVO rtnResultVO = new RtnResultVO();
		if(null==verycode||null==loginCommand.getVerycode()||
				!verycode.equals(loginCommand.getVerycode().toUpperCase())){
			rtnResultVO.setResultStatus("-3");
			rtnResultVO.setResultMessage("verycode is error");
		}else if(null==loginCommand.getUserName()||null==loginCommand.getPassword()||
				"".equals(loginCommand.getUserName())||"".equals(loginCommand.getPassword())){
			rtnResultVO.setResultStatus("-4");
			rtnResultVO.setResultMessage("用户名和密码不可以为空");
		}else{
			TbEmployee tbEmployee = employeeService.findEmployeeByNameAndPwd(loginCommand.getUserName(),MD5.getMD5Str(loginCommand.getPassword()));
			if (null!=tbEmployee) {
				rtnResultVO.setResultStatus("1");
				rtnResultVO.setResultMessage("success");
				session.setAttribute("tbEmployee", tbEmployee);
			} else {
				rtnResultVO.setResultStatus("-1");
				rtnResultVO.setResultMessage("username or password is not correct");
			}
		}
		Gson gson = new Gson();
        String json = gson.toJson(rtnResultVO);
		return json;
	}
	
	
	@Resource(name="employeeService")
    private IEmployeeService employeeService;
	
}
