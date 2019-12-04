package com.venus.finance.vo;

import java.util.List;

public class FuturesPriceVO {
	private List futuresSettlePriceList;
	private List futuresClosePriceList;
	public List getFuturesSettlePriceList() {
		return futuresSettlePriceList;
	}
	public void setFuturesSettlePriceList(List futuresSettlePriceList) {
		this.futuresSettlePriceList = futuresSettlePriceList;
	}
	public List getFuturesClosePriceList() {
		return futuresClosePriceList;
	}
	public void setFuturesClosePriceList(List futuresClosePriceList) {
		this.futuresClosePriceList = futuresClosePriceList;
	}
	
}
