package com.venus.finance.vo;

import java.util.List;

import com.venus.finance.model.FuturesResult;
import com.venus.finance.model.FuturesStrategy;

public class FuturesResultVO{
	private Long status;
	private String message;
	private List<FuturesResult> resultList;
	private List<Long> dateRtnList;
	private List<Double> ljyleList;
	private List<Double> dwjzList;
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Long getStatus() {
		return status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

	public List<FuturesResult> getResultList() {
		return resultList;
	}

	public void setResultList(List<FuturesResult> resultList) {
		this.resultList = resultList;
	}

	public List<Long> getDateRtnList() {
		return dateRtnList;
	}

	public void setDateRtnList(List<Long> dateRtnList) {
		this.dateRtnList = dateRtnList;
	}

	public List<Double> getLjyleList() {
		return ljyleList;
	}

	public void setLjyleList(List<Double> ljyleList) {
		this.ljyleList = ljyleList;
	}

	public List<Double> getDwjzList() {
		return dwjzList;
	}

	public void setDwjzList(List<Double> dwjzList) {
		this.dwjzList = dwjzList;
	}
	
	
}
