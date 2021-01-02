package com.venus.finance.util;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArraySet;

import com.venus.finance.socket.IndexQuoteServer;
import com.venus.finance.vo.FuturesQuoteVO;

public class Variable {
	private static ConcurrentLinkedQueue<FuturesQuoteVO> futuresQuoteQueue = 
			new ConcurrentLinkedQueue<FuturesQuoteVO>();
	private static ConcurrentHashMap<String, FuturesQuoteVO> futuresQuoteMap = 
			new ConcurrentHashMap<String, FuturesQuoteVO>();
	private static CopyOnWriteArraySet<IndexQuoteServer> webSocketSet = new CopyOnWriteArraySet<IndexQuoteServer>();
	public static ConcurrentLinkedQueue<FuturesQuoteVO> getFuturesQuoteQueue() {
		return futuresQuoteQueue;
	}
	public static void setFuturesQuoteQueue(ConcurrentLinkedQueue<FuturesQuoteVO> futuresQuoteQueue) {
		Variable.futuresQuoteQueue = futuresQuoteQueue;
	}
	public static ConcurrentHashMap<String, FuturesQuoteVO> getFuturesQuoteMap() {
		return futuresQuoteMap;
	}
	public static void setFuturesQuoteMap(ConcurrentHashMap<String, FuturesQuoteVO> futuresQuoteMap) {
		Variable.futuresQuoteMap = futuresQuoteMap;
	}
	public static CopyOnWriteArraySet<IndexQuoteServer> getWebSocketSet() {
		return webSocketSet;
	}
	public static void setWebSocketSet(CopyOnWriteArraySet<IndexQuoteServer> webSocketSet) {
		Variable.webSocketSet = webSocketSet;
	}
	
}
