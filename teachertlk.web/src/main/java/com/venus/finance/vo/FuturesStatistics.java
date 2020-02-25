package com.venus.finance.vo;

import java.util.List;

public class FuturesStatistics {
	private String instrumentID;
	private String todayStr;
	private FuturesQuoteVO futuresQuoteVO;
	private MaxMinPriceVO maxMinPriceVO;
	private AtrVO atrvo;
	private MacdVO macdVO;
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
	public MaxMinPriceVO getMaxMinPriceVO() {
		return maxMinPriceVO;
	}
	public void setMaxMinPriceVO(MaxMinPriceVO maxMinPriceVO) {
		this.maxMinPriceVO = maxMinPriceVO;
	}
	public AtrVO getAtrvo() {
		return atrvo;
	}
	public void setAtrvo(AtrVO atrvo) {
		this.atrvo = atrvo;
	}
	public MacdVO getMacdVO() {
		return macdVO;
	}
	public void setMacdVO(MacdVO macdVO) {
		this.macdVO = macdVO;
	}
	
}
