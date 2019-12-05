package com.venus.finance.vo;

import java.util.List;

public class FuturesPriceVO {
	private String code;
	private List<Long>dateRtnList;
	private List<Double> closePriceList;
	private List<Double> settlePriceList;
	private List<Double> settlePriceCurList;
	private List<CandleVO> candlePriceList;
	public List<Long> getDateRtnList() {
		return dateRtnList;
	}
	public void setDateRtnList(List<Long> dateRtnList) {
		this.dateRtnList = dateRtnList;
	}
	public List<Double> getClosePriceList() {
		return closePriceList;
	}
	public void setClosePriceList(List<Double> closePriceList) {
		this.closePriceList = closePriceList;
	}
	public List<Double> getSettlePriceList() {
		return settlePriceList;
	}
	public void setSettlePriceList(List<Double> settlePriceList) {
		this.settlePriceList = settlePriceList;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public List<Double> getSettlePriceCurList() {
		return settlePriceCurList;
	}
	public void setSettlePriceCurList(List<Double> settlePriceCurList) {
		this.settlePriceCurList = settlePriceCurList;
	}
	public List<CandleVO> getCandlePriceList() {
		return candlePriceList;
	}
	public void setCandlePriceList(List<CandleVO> candlePriceList) {
		this.candlePriceList = candlePriceList;
	}

	
	
}
