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

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.kiiik.dao.TbEmployee;
import com.kiiik.dao.TbRole;
import com.kiiik.util.MD5;
import com.venus.finance.fix.FixApplication;
import com.venus.finance.model.Employee;
import com.venus.finance.model.FuturesMessage;
import com.venus.finance.model.LoginCommand;
import com.venus.finance.model.RtnResultVO;
import com.venus.finance.service.IEmployeeService;
import com.venus.finance.service.IFuturesMessageService;
import com.venus.finance.util.CodeUtil;
import com.venus.finance.util.FileUtil;
import com.venus.finance.util.InitUtil;
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
	
	@RequestMapping(value = "/loginCheck.html",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String changeFuturesJys(HttpServletRequest request,ModelMap model,LoginCommand loginCommand) {
		CodeUtil codeUtil = new CodeUtil();
		List<FuturesQuoteVO>  jysCodeList = null;
		String verycode = (String)request.getSession().getAttribute("verycode");
		RtnResultVO rtnResultVO = new RtnResultVO();
		if(null==verycode||null==loginCommand.getVerycode()||
				!verycode.equals(loginCommand.getVerycode().toUpperCase())){
			rtnResultVO.setResultStatus("-3");
			rtnResultVO.setResultMessage("verycode is error");
		}else{
			Employee tbEmployee = employeeService.findOne(id)
					loginService.findTbEmployee(loginCommand.getUserName(), MD5.getMD5Str(loginCommand.getPassword()));
			if (null!=tbEmployee) {
				Set tbDepartments = tbEmployee.getTbDepartments();
				Set tbRoles = tbEmployee.getTbRoles();
				request.getSession().setAttribute("tbEmployee", tbEmployee);
				request.getSession().setAttribute("tbDepartments", tbDepartments);
				request.getSession().setAttribute("tbRoles", tbRoles);
				List funcList = new ArrayList();
				if(tbRoles!=null){
					Iterator it = tbRoles.iterator();
					while(it!=null&&it.hasNext()){
						TbRole tbRole = (TbRole)it.next();
						if(tbRole!=null){
							funcList.addAll(tbRole.getTbFunctions());
						}
					}
				}
				request.getSession().setAttribute("funcList", funcList);
				result = "{\"resultStatus\":\"1\",\"resultMessage\":\"success\"}";
			} else {
				result = "{\"resultStatus\":\"-1\",\"resultMessage\":\"loginfail\"}";
			}
		}
		Gson gson = new Gson();
        String json = gson.toJson(rtnResultVO);
		return json;
	}
	
	
	@Resource(name="employeeService")
    private IEmployeeService employeeService;
	
}
