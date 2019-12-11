package com.venus.finance.vo;

import java.util.List;

public class FuturesStatistics {
	private String instrumentID;
	private String todayStr;
	private FuturesQuoteVO futuresQuoteVO;
	public String getInstrumentID() {
		return instrumentID;
	}
	public void setInstrumentID(String instrumentID) {
		this.instrumentID = instrumentID;
	}
	public String getTodayStr() {
		return todayStr;
	}
	public void setTodayStr(String todayStr) {
		this.todayStr = todayStr;
	}
	public FuturesQuoteVO getFuturesQuoteVO() {
		return futuresQuoteVO;
	}
	public void setFuturesQuoteVO(FuturesQuoteVO futuresQuoteVO) {
		this.futuresQuoteVO = futuresQuoteVO;
	}
	
}
