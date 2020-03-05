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
import com.venus.finance.model.TbEmployee;
import com.venus.finance.model.TbTeacher;
import com.venus.finance.service.IEmployeeService;
import com.venus.finance.service.ITeacherService;
import com.venus.finance.util.CodeUtil;
import com.venus.finance.util.Constants;
import com.venus.finance.util.MD5;
import com.venus.finance.util.MathUtil;
import com.venus.finance.util.Page;
import com.venus.finance.util.PagerHelp;
import com.venus.finance.vo.AtrVO;
import com.venus.finance.vo.CandleVO;
import com.venus.finance.vo.FuturesPriceVO;
import com.venus.finance.vo.FuturesQuoteVO;
import com.venus.finance.vo.FuturesStatistics;
import com.venus.finance.vo.MacdVO;
import com.venus.finance.vo.MaxMinPriceVO;

@Controller
public class EmployeeController {
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/m-employee.html", method = RequestMethod.GET)
	public String employee(HttpServletRequest request, ModelMap model) {
		try {
			String name = "";
			if (null != request.getParameter("name")) {
				name = (String) request.getParameter("name");
			}
			int total = employeeService.findAllTbEmployeeCount(name).intValue();
			Page page = null;
			int currentPage = 1;
			if (null != request.getParameter("currentPage")) {
				currentPage = Integer.parseInt(request.getParameter("currentPage"));
			}
			int pageSize = Constants.pageSize;
			page = PagerHelp.getPager(request, total, pageSize);
			if (currentPage <= 1) {
				page.setLastPage(1);
			} else {
				page.setLastPage(currentPage - 1);
			}
			if (currentPage < page.getTotalPages()) {
				page.setNextPage(currentPage + 1);
			} else {
				page.setNextPage(page.getTotalPages());
			}
			page.setPageAction("m-employee.html?name=" + name + "&");
			model.addAttribute("page", page);
			model.addAttribute("name", name);
			List dataList = employeeService.findAllTbEmployee(page.getStartRow(), pageSize, name);
			model.addAttribute("dataList", dataList);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "m-employee";
	}

	// 编辑老师的资料
	@RequestMapping(value = "/m-employee-e.html", method = RequestMethod.GET)
	public String m_employee_e(HttpServletRequest request, ModelMap model) {
		try {
			Long id = Long.parseLong(request.getParameter("id"));
			TbEmployee tbEmployee = employeeService.findOne(id);
			model.addAttribute("tbEmployee", tbEmployee);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "m-employee-e";
	}

	// 新增老师的资料
	@RequestMapping(value = "/m-employee-a.html", method = RequestMethod.GET)
	public String m_employee_a(HttpServletRequest request, ModelMap model) {
		try {
			TbEmployee tbEmployee = new TbEmployee();
			model.addAttribute("tbEmployee", tbEmployee);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "m-employee-e";
	}

	@Resource(name = "employeeService")
	private IEmployeeService employeeService;

}
