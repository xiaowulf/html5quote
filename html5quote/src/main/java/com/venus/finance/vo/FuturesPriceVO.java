package com.venus.finance.vo;

import java.util.List;

public class FuturesPriceVO {
	private List<Long>dateRtnList;
	private List<FuturesQuoteVO> futuresPriceList;
	public List<Long> getDateRtnList() {
		return dateRtnList;
	}
	public void setDateRtnList(List<Long> dateRtnList) {
		this.dateRtnList = dateRtnList;
	}
	public List<FuturesQuoteVO> getFuturesPriceList() {
		return futuresPriceList;
	}
	public void setFuturesPriceList(List<FuturesQuoteVO> futuresPriceList) {
		this.futuresPriceList = futuresPriceList;
	}
	
	
}
