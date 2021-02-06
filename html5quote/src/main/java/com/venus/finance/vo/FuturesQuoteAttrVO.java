package com.venus.finance.vo;

public class FuturesQuoteAttrVO{
	private String instrumentID;
	private String jys;
	private String name;
	private String code;
	private Double multiply;
	private Double longratio;
	private Double shortratio;
	public String getInstrumentID() {
		return instrumentID;
	}
	public void setInstrumentID(String instrumentID) {
		this.instrumentID = instrumentID;
	}
	public String getJys() {
		return jys;
	}
	public void setJys(String jys) {
		this.jys = jys;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Double getMultiply() {
		return multiply;
	}
	public void setMultiply(Double multiply) {
		this.multiply = multiply;
	}
	public Double getLongratio() {
		return longratio;
	}
	public void setLongratio(Double longratio) {
		this.longratio = longratio;
	}
	public Double getShortratio() {
		return shortratio;
	}
	public void setShortratio(Double shortratio) {
		this.shortratio = shortratio;
	}
	
	
}
