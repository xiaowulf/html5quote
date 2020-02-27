package com.venus.finance.vo;

public class MacdVO {
	private Double macd5 = 0.0;
	private Double macd10 = 0.0;
	private Double macd20 = 0.0;
	private Double macd40 = 0.0;
	private Double macd60 = 0.0;
	private String instrumentID;
	public Double getMacd5() {
		return macd5;
	}
	public void setMacd5(Double macd5) {
		this.macd5 = macd5;
	}
	public Double getMacd10() {
		return macd10;
	}
	public void setMacd10(Double macd10) {
		this.macd10 = macd10;
	}
	public Double getMacd20() {
		return macd20;
	}
	public void setMacd20(Double macd20) {
		this.macd20 = macd20;
	}
	public Double getMacd40() {
		return macd40;
	}
	public void setMacd40(Double macd40) {
		this.macd40 = macd40;
	}
	public Double getMacd60() {
		return macd60;
	}
	public void setMacd60(Double macd60) {
		this.macd60 = macd60;
	}
	public String getInstrumentID() {
		return instrumentID;
	}
	public void setInstrumentID(String instrumentID) {
		this.instrumentID = instrumentID;
	}
	
}
