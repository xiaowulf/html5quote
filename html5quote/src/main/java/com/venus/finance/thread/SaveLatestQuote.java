package com.venus.finance.thread;

import java.util.concurrent.ConcurrentHashMap;

import com.venus.finance.fix.FixApplication;
import com.venus.finance.vo.FuturesQuoteVO;

public class SaveLatestQuote implements Runnable {

	private boolean isReady = false;
	private ConcurrentHashMap<String,FuturesQuoteVO> quoteMap;
	public boolean isReady() {
		return isReady;
	}

	public void setReady(boolean isReady) {
		this.isReady = isReady;
	}

	public SaveLatestQuote(ConcurrentHashMap<String,FuturesQuoteVO> quoteMap) {
		this.quoteMap = quoteMap;
	}
	@Override
	public void run() {
		while (true) {
			try {
				if (isReady) {
					System.out.println("-quoteMap---------------------------------"+quoteMap.size());
				}else{
					Thread.sleep(1);
				}
			} catch (InterruptedException e) {
				System.out.println("Thread interrupted...");
			}
		}
	}
}
