package com.venus.finance.vo;

import java.util.List;

import com.venus.finance.model.FuturesStrategy;

public class FuturesStrategyOneVO{
	FuturesStrategy futuresStrategy;
	private String status;
	private String message;
	
	public FuturesStrategy getFuturesStrategy() {
		return futuresStrategy;
	}
	public void setFuturesStrategy(FuturesStrategy futuresStrategy) {
		this.futuresStrategy = futuresStrategy;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
