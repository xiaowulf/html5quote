package com.venus.finance.controller;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.venus.finance.fix.FixApplication;
import com.venus.finance.model.LoginCommand;
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
import com.venus.finance.util.PropertiesUtil;
import com.venus.finance.vo.AtrVO;
import com.venus.finance.vo.CandleVO;
import com.venus.finance.vo.FuturesPriceVO;
import com.venus.finance.vo.FuturesQuoteVO;
import com.venus.finance.vo.FuturesStatistics;
import com.venus.finance.vo.MacdVO;
import com.venus.finance.vo.MaxMinPriceVO;

@Controller
public class TeacherController {
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/m-teacher.html", method = RequestMethod.GET)
	public String analyse(HttpServletRequest request, ModelMap model) {
		try {
			String name = "";
			if (null != request.getParameter("name")) {
				name = (String) request.getParameter("name");
			}
			int total = teacherService.findAllTbTeacherCount(name).intValue();
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
			page.setPageAction("m-teacher.html?name=" + name + "&");
			model.addAttribute("page", page);
			model.addAttribute("name", name);
			List dataList = teacherService.findAllTbTeacher(page.getStartRow(), pageSize, name);
			model.addAttribute("dataList", dataList);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "m-teacher";
	}

	

	// 编辑老师的资料
	@RequestMapping(value = "/m-teacher-e.html", method = RequestMethod.GET)
	public String m_teacher_e(HttpServletRequest request, ModelMap model) {
		try {
			Long id = Long.parseLong(request.getParameter("id"));
			TbTeacher tbTeacher = teacherService.findOne(id);
			model.addAttribute("tbTeacher", tbTeacher);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "m-teacher-e";
	}

	// 新增老师的资料
	@RequestMapping(value = "/m-teacher-a.html", method = RequestMethod.GET)
	public String m_teacher_a(HttpServletRequest request, ModelMap model) {
		try {
			TbTeacher tbTeacher = new TbTeacher();
			model.addAttribute("tbTeacher", tbTeacher);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "m-teacher-e";
	}

	// 新增老师的资料
	@RequestMapping(value = "/saveTeacher.html", method = RequestMethod.POST)
	public String saveTeacher(MultipartFile image, HttpServletRequest request, ModelMap model,
			TbTeacher tbTeacherTemp) {
		try {
			String realpath = request.getServletContext().getRealPath("/file/");
			TbTeacher tbTeacher;
			if (tbTeacherTemp.getId() != null && tbTeacherTemp.getId().longValue() != 0L) {
				Long id = Long.parseLong(request.getParameter("id"));
				tbTeacher = teacherService.findOne(id);
				TbTeacher tbTeacherTemp2 = teacherService.findAllTbTeacherByUsername(tbTeacherTemp.getUsername());
				if (tbTeacherTemp2 != null && tbTeacherTemp2.getId().longValue() != id.longValue()) {
					request.setAttribute("result", "teacher.exist");
					return "result";
				}
			} else {
				tbTeacher = new TbTeacher();
			}
			if (image != null) {
				String fileName = image.getOriginalFilename();
				if (fileName != null && !fileName.equals("")) {
					File savedir = new File(realpath);
					if (!savedir.getParentFile().exists()) {
						savedir.getParentFile().mkdirs();
					}
					Long millSeconds = Calendar.getInstance().getTimeInMillis();
					tbTeacher.setPic1("file/" + millSeconds + fileName);
					PropertiesUtil propertiesUtil = new PropertiesUtil();
					String fileupload = propertiesUtil.getfileConfigValueByKey("fileupload");
					image.transferTo(new File(fileupload + millSeconds + fileName));
				}
			}

			tbTeacher.setUsername(tbTeacherTemp.getUsername());
			tbTeacher.setTruename(tbTeacherTemp.getTruename());
			tbTeacher.setCertificate(tbTeacherTemp.getCertificate());
			tbTeacher.setEmail(tbTeacherTemp.getEmail());
			tbTeacher.setIdcard(tbTeacherTemp.getIdcard());
			tbTeacher.setEducation(tbTeacherTemp.getEducation());
			tbTeacher.setMobile(tbTeacherTemp.getMobile());
			tbTeacher.setResume(tbTeacherTemp.getResume());
			tbTeacher.setPassword(MD5.getMD5Str(MD5.getRandomString(6)));
			tbTeacher.setSex(tbTeacherTemp.getSex());
			tbTeacher.setBirthday(tbTeacherTemp.getBirthday());
			tbTeacher.setStatus(tbTeacherTemp.getStatus());
			boolean result = teacherService.saveTbTeacher(tbTeacher);
			if (result) {
				request.setAttribute("result", "system.success");
			} else {
				request.setAttribute("result", "system.failure");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "result";
	}

	@Resource(name = "teacherService")
	private ITeacherService teacherService;

}
