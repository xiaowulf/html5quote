package com.venus.finance.thread;

import java.util.concurrent.ConcurrentHashMap;

import com.venus.finance.fix.FixApplication;
import com.venus.finance.vo.FuturesQuoteVO;

public class ComputeLatestQuote implements Runnable {

	private boolean isReady = false;
	private FixApplication fixApplication;
	///private ConcurrentHashMap<String,FuturesQuoteVO> quoteMap;
	public boolean isReady() {
		return isReady;
	}

	public void setReady(boolean isReady) {
		this.isReady = isReady;
	}

	public ComputeLatestQuote(FixApplication fixApplication) {
		this.fixApplication = fixApplication;
	}
	@Override
	public void run() {
		while (true) {
			try {
				if (!fixApplication.getFuturesQuoteQueue().isEmpty()&&isReady) {
					FuturesQuoteVO quote = fixApplication.getFuturesQuoteQueue().poll();
					if(quote!=null&&!quote.getInstrumentID().equals("")){
						//quoteMap.put(quote.getInstrumentID(),quote);
					}
				}else{
					Thread.sleep(1);
				}
			} catch (InterruptedException e) {
				System.out.println("Thread interrupted...");
			}
		}
	}
}
