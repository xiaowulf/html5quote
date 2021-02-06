package com.venus.finance.dao;

import java.util.List;

import com.venus.finance.model.FuturesResult;

public interface IFuturesResultDAO extends IOperations<FuturesResult> {
	public List<FuturesResult> findFuturesResultByDate(Long date);
	public String findMaxDate();
	public List<FuturesResult> findStrategyFuturesResultByDate(Long date);
}