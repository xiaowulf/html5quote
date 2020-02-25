package com.venus.finance.fix;

public class FuturesQuote {
	private String code;
	private Double ccvolume;
	private Double volume;
	private Double openprice;
	private Double highprice;
	private Double lowprice;
	private Double closeprice;
	private Double jsjprice;
	private Double preSettlementPrice;
	private Double buy1;
	private Double sell1;
	private Double buy1qty;
	private Double sell1qty;
	private String direction;
	private Double atr=0.0D;
	private Double loss;
	public Double getHighprice() {
		return highprice;
	}
	public void setHighprice(Double highprice) {
		this.highprice = highprice;
	}
	public Double getLowprice() {
		return lowprice;
	}
	public void setLowprice(Double lowprice) {
		this.lowprice = lowprice;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Double getCcvolume() {
		return ccvolume;
	}
	public void setCcvolume(Double ccvolume) {
		this.ccvolume = ccvolume;
	}
	public Double getVolume() {
		return volume;
	}
	public void setVolume(Double volume) {
		this.volume = volume;
	}
	public Double getOpenprice() {
		return openprice;
	}
	public void setOpenprice(Double openprice) {
		this.openprice = openprice;
	}
	public Double getCloseprice() {
		return closeprice;
	}
	public void setCloseprice(Double closeprice) {
		this.closeprice = closeprice;
	}
	public Double getJsjprice() {
		return jsjprice;
	}
	public void setJsjprice(Double jsjprice) {
		this.jsjprice = jsjprice;
	}
	public Double getPreSettlementPrice() {
		return preSettlementPrice;
	}
	public void setPreSettlementPrice(Double preSettlementPrice) {
		this.preSettlementPrice = preSettlementPrice;
	}
	public Double getBuy1() {
		return buy1;
	}
	public void setBuy1(Double buy1) {
		this.buy1 = buy1;
	}
	public Double getSell1() {
		return sell1;
	}
	public void setSell1(Double sell1) {
		this.sell1 = sell1;
	}
	public Double getBuy1qty() {
		return buy1qty;
	}
	public void setBuy1qty(Double buy1qty) {
		this.buy1qty = buy1qty;
	}
	public Double getSell1qty() {
		return sell1qty;
	}
	public void setSell1qty(Double sell1qty) {
		this.sell1qty = sell1qty;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		FuturesQuote futuresQuote = null;
		try{
			futuresQuote = (FuturesQuote)super.clone();
		}catch(CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return futuresQuote;
	}
	public Double getAtr() {
		return atr;
	}
	public void setAtr(Double atr) {
		this.atr = atr;
	}
	public Double getLoss() {
		return loss;
	}
	public void setLoss(Double loss) {
		this.loss = loss;
	}
	
}
