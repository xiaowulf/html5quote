package com.venus.finance.vo;

import java.util.ArrayList;
import java.util.List;

public class FuturesPriceVO {
	private String code;
	private List<Long>dateRtnList;
	private List<Double> closePriceList;
	private List<Double> settlePriceList;
	private List<Double> settlePriceCurList;
	private List<CandleVO> candlePriceList;
	private List<MacdVO> macdList;
	private List<Double> ccVolumeList;
	private List<Double> volumeList;
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
	public List<MacdVO> getMacdList() {
		return macdList;
	}
	public void setMacdList(List<MacdVO> macdList) {
		this.macdList = macdList;
	}
	public List<Double> getCcVolumeList() {
		return ccVolumeList;
	}
	public void setCcVolumeList(List<Double> ccVolumeList) {
		this.ccVolumeList = ccVolumeList;
	}
	public List<Double> getVolumeList() {
		return volumeList;
	}
	public void setVolumeList(List<Double> volumeList) {
		this.volumeList = volumeList;
	}

	
	
}
