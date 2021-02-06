package com.venus.finance.service;
import java.util.List;

import com.venus.finance.dao.IOperations;
import com.venus.finance.model.FuturesClose;
import com.venus.finance.model.FuturesResult;

public interface IFuturesResultService extends IOperations<FuturesResult> {
	public List<FuturesResult> findFuturesResultByDate(Long date);
	public String findMaxDate();
	public List<FuturesResult> findStrategyFuturesResultByDate(Long date);
}