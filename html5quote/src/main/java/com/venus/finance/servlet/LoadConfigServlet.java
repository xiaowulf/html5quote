package com.venus.finance.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.venus.finance.fix.FixApplication;
import com.venus.finance.thread.ComputeLatestQuote;
import com.venus.finance.thread.SaveLatestQuote;
import com.venus.finance.util.CodeUtil;
import com.venus.finance.util.FileUtil;
import com.venus.finance.util.InitUtil;
import com.venus.finance.vo.FuturesQuoteVO;

import quickfix.ConfigError;
import quickfix.DefaultMessageFactory;
import quickfix.FileLogFactory;
import quickfix.FileStoreFactory;
import quickfix.LogFactory;
import quickfix.MessageFactory;
import quickfix.MessageStoreFactory;
import quickfix.SessionSettings;
import quickfix.SocketInitiator;

public class LoadConfigServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2932678245407661412L;
	private SocketInitiator initiator;
	private SessionSettings settings;
	private MessageStoreFactory storeFactory;
	private LogFactory logFactory;
	private MessageFactory messageFactory;
	private FixApplication fixApplication;
	//private ComputeLatestQuote computeLatestQuote;
	private SaveLatestQuote saveLatestQuote;
	//private Thread latestQuoteThread;
	private Thread saveLatestQuoteThread;

	public LoadConfigServlet() {
		super();
	}

	public void init() throws ServletException {
		String path = this.getClass().getClassLoader().getResource("/").getPath();
		String fixFileName = path + "quotefix.cfg";
		// ServletContext application = this.getServletContext();
		// if (null == application.getAttribute("fixApplication")) {
		/*
		fixApplication = new FixApplication();
		try {
			settings = new SessionSettings(new FileInputStream(fixFileName));
			storeFactory = new FileStoreFactory(settings);
			logFactory = new FileLogFactory(settings);
			messageFactory = new DefaultMessageFactory();
			initiator = new SocketInitiator(fixApplication, storeFactory, settings, logFactory, messageFactory);
			initiator.start();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ConfigError e) {
			e.printStackTrace();
		}
		*/
		// application.setAttribute("fixApplication", fixApplication);
		// }
		// 启动最新行情线程
		//computeLatestQuote = new ComputeLatestQuote();
		//computeLatestQuote.setReady(true);
		//latestQuoteThread = new Thread(computeLatestQuote);
		//latestQuoteThread.start();
		//保存数据线程
		/*
		saveLatestQuote = new SaveLatestQuote();
		saveLatestQuote.setReady(true);
		saveLatestQuoteThread = new Thread(saveLatestQuote);
		saveLatestQuoteThread.start();
		*/
	}

	public void destroy() {
		try {
			System.out.println("---destroy-----");
			//computeLatestQuote.setReady(false);
			//latestQuoteThread.interrupt();
			/*
			saveLatestQuote.setReady(false);
			saveLatestQuoteThread.interrupt();
			initiator.stop();
			*/
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}