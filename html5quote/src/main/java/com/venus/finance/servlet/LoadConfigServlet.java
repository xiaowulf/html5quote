package com.venus.finance.servlet;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.venus.finance.fix.FixApplication;

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
	private FixApplication application;

	public LoadConfigServlet() {
		super();
	}

	public void init() throws ServletException {
		// fix ≥ı ºªØ
		String path = this.getClass().getClassLoader().getResource("/").getPath();
		String fixFileName = path + "quotefix.cfg";
		application = new FixApplication();
		try {
			settings = new SessionSettings(new FileInputStream(fixFileName));
			storeFactory = new FileStoreFactory(settings);
			logFactory = new FileLogFactory(settings);
			messageFactory = new DefaultMessageFactory();
			initiator = new SocketInitiator(application, storeFactory, settings, logFactory, messageFactory);
			initiator.start();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ConfigError e) {
			e.printStackTrace();
		}
	}
}