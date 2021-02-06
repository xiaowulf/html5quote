package com.venus.finance.vo;

public class FuturesQuoteReadVO{
	private String instrumentID;
	private Double highestPrice=0D;
	private Double lowestPrice=0D;
	private Double openPrice=0D;
	private Double closePrice=0D;
	private Double averagePrice=0D;
	private Double volume=0D;
	private Double openInterest=0D;
	private Double turnover;
	public Double getTurnover() {
		return turnover;
	}
	public void setTurnover(Double turnover) {
		this.turnover = turnover;
	}
	private Double preSettlementPrice=0D;
	private Double preClosePrice=0D;
	private Double preOpenInterest=0D;
	private String UpdateTime;
	private Long date;
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((instrumentID == null) ? 0 : instrumentID.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FuturesQuoteReadVO other = (FuturesQuoteReadVO) obj;
		if (instrumentID == null) {
			if (other.instrumentID != null)
				return false;
		} else if (!instrumentID.equals(other.instrumentID))
			return false;
		return true;
	}
	public String getInstrumentID() {
		return instrumentID;
	}
	public void setInstrumentID(String instrumentID) {
		this.instrumentID = instrumentID;
	}
	public Double getHighestPrice() {
		return highestPrice;
	}
	public void setHighestPrice(Double highestPrice) {
		this.highestPrice = highestPrice;
	}
	public Double getLowestPrice() {
		return lowestPrice;
	}
	public void setLowestPrice(Double lowestPrice) {
		this.lowestPrice = lowestPrice;
	}
	public Double getOpenPrice() {
		return openPrice;
	}
	public void setOpenPrice(Double openPrice) {
		this.openPrice = openPrice;
	}
	public Double getClosePrice() {
		return closePrice;
	}
	public void setClosePrice(Double closePrice) {
		this.closePrice = closePrice;
	}
	public Double getAveragePrice() {
		return averagePrice;
	}
	public void setAveragePrice(Double averagePrice) {
		this.averagePrice = averagePrice;
	}
	public Double getVolume() {
		return volume;
	}
	public void setVolume(Double volume) {
		this.volume = volume;
	}
	public Double getOpenInterest() {
		return openInterest;
	}
	public void setOpenInterest(Double openInterest) {
		this.openInterest = openInterest;
	}
	public Double getPreSettlementPrice() {
		return preSettlementPrice;
	}
	public void setPreSettlementPrice(Double preSettlementPrice) {
		this.preSettlementPrice = preSettlementPrice;
	}
	public Double getPreClosePrice() {
		return preClosePrice;
	}
	public void setPreClosePrice(Double preClosePrice) {
		this.preClosePrice = preClosePrice;
	}
	public Double getPreOpenInterest() {
		return preOpenInterest;
	}
	public void setPreOpenInterest(Double preOpenInterest) {
		this.preOpenInterest = preOpenInterest;
	}
	public String getUpdateTime() {
		return UpdateTime;
	}
	public void setUpdateTime(String updateTime) {
		UpdateTime = updateTime;
	}
	public Long getDate() {
		return date;
	}
	public void setDate(Long date) {
		this.date = date;
	}
	
}
