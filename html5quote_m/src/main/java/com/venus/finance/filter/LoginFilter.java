package com.venus.finance.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import com.venus.finance.model.TbEmployee;

import javax.servlet.http.HttpServletRequest;
/**
 * Servlet Filter implementation class EncodeFilter
 */
public class LoginFilter implements Filter {
	public static final String loginPage = "login.html";
	/**
	 * Default constructor.
	 */
	public LoginFilter() {
		
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
			
	}
	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		try {
			TbEmployee tbEmployee = (TbEmployee) ((HttpServletRequest) request).getSession()
					.getAttribute("tbEmployee");
			HttpServletResponse respo = (HttpServletResponse)response;
			ServletContext application = ((HttpServletRequest) request).getSession().getServletContext();
			String path = ((HttpServletRequest) request).getServletPath();
			if(null==tbEmployee&&!path.contains(loginPage)
					&&!path.contains("login")){
				respo.sendRedirect(loginPage);
				return;
			}
		} catch (Exception ignore) {

		}
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
