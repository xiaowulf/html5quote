package com.venus.finance.vo;

public class FuturesQuoteVO{
	private String instrumentID;
	private Double askPrice1=0D;
	private Double bidPrice1=0D;
	private Double askVolume1=0D;
	private Double bidVolume1=0D;
	private Double averagePrice=0D;
	private Double volume=0D;
	private Double openInterest=0D;
	private Double settlementPrice=0D;
	private Double highestPrice=0D;
	private Double lowestPrice=0D;
	private Double openPrice=0D;
	private Double closePrice=0D;
	private Double LastPrice=0D;
	private String name;
	private Long date;
	private Double ccvolume=0D;
	private Double preSettlementPrice=0D;
	private MacdVO macdVO;
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
		FuturesQuoteVO other = (FuturesQuoteVO) obj;
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
	public Double getAskPrice1() {
		return askPrice1;
	}
	public void setAskPrice1(Double askPrice1) {
		this.askPrice1 = askPrice1;
	}
	public Double getBidPrice1() {
		return bidPrice1;
	}
	public void setBidPrice1(Double bidPrice1) {
		this.bidPrice1 = bidPrice1;
	}
	public Double getAskVolume1() {
		return askVolume1;
	}
	public void setAskVolume1(Double askVolume1) {
		this.askVolume1 = askVolume1;
	}
	public Double getBidVolume1() {
		return bidVolume1;
	}
	public void setBidVolume1(Double bidVolume1) {
		this.bidVolume1 = bidVolume1;
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
	public Double getSettlementPrice() {
		return settlementPrice;
	}
	public void setSettlementPrice(Double settlementPrice) {
		this.settlementPrice = settlementPrice;
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
	public Double getLastPrice() {
		return LastPrice;
	}
	public void setLastPrice(Double lastPrice) {
		LastPrice = lastPrice;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getCcvolume() {
		return ccvolume;
	}
	public void setCcvolume(Double ccvolume) {
		this.ccvolume = ccvolume;
	}
	public Long getDate() {
		return date;
	}
	public void setDate(Long date) {
		this.date = date;
	}
	public Double getPreSettlementPrice() {
		return preSettlementPrice;
	}
	public void setPreSettlementPrice(Double preSettlementPrice) {
		this.preSettlementPrice = preSettlementPrice;
	}
	public MacdVO getMacdVO() {
		return macdVO;
	}
	public void setMacdVO(MacdVO macdVO) {
		this.macdVO = macdVO;
	}
	
}
