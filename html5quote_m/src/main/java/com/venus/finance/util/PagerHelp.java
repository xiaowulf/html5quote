package com.venus.finance.util;

import javax.servlet.http.*;


public class PagerHelp {
	public static Page getPager(HttpServletRequest httpServletRequest,
			int totalRows,int pageSize) {

		
		// 定义pager对象，用于传到页面    
        Page pager = new Page(totalRows,pageSize);   
		//从Request对象中获取当前页号
		String currentPage = httpServletRequest.getParameter("currentPage");
		//如果当前页号为空，表示为首次查询该页
		//如果不为空，则刷新page对象，输入当前页号等信息
		if (currentPage != null) {
			pager.refresh(Integer.parseInt(currentPage));
		}
		//获取当前执行的方法，首页，前一页，后一页，尾页。
		String pagerMethod = httpServletRequest.getParameter("pageMethod");
		if (pagerMethod != null) {
			if (pagerMethod.equals("first")) {
				pager.first();
			} else if (pagerMethod.equals("previous")) {
				pager.previous();
			} else if (pagerMethod.equals("next")) {
				pager.next();
			} else if (pagerMethod.equals("last")) {
				pager.last();
			}
		}
		return pager;
	}

}
