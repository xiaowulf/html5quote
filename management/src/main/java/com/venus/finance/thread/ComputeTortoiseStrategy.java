package com.venus.finance.thread;

import java.util.concurrent.ConcurrentHashMap;

import com.venus.finance.fix.FixApplication;
import com.venus.finance.util.Variable;
import com.venus.finance.vo.FuturesQuoteVO;

public class ComputeTortoiseStrategy implements Runnable {

	private boolean isReady = false;
	//private FixApplication fixApplication;
	///private ConcurrentHashMap<String,FuturesQuoteVO> quoteMap;
	public boolean isReady() {
		return isReady;
	}

	public void setReady(boolean isReady) {
		this.isReady = isReady;
	}

	public ComputeTortoiseStrategy() {
		//this.fixApplication = fixApplication;
	}
	@Override
	public void run() {
		while (true) {
			try {
				if (!Variable.getFuturesQuoteQueue().isEmpty()&&isReady) {
					//FuturesQuoteVO quote = fixApplication.getFuturesQuoteQueue().poll();
					//if(quote!=null&&!quote.getInstrumentID().equals("")){
						//quoteMap.put(quote.getInstrumentID(),quote);
					//}
				}else{
					Thread.sleep(1);
				}
			} catch (InterruptedException e) {
				System.out.println("Thread interrupted...");
			}
		}
	}
}
