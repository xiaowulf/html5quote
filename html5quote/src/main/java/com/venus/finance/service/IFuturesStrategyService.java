package com.venus.finance.service;
import java.util.List;

import com.venus.finance.dao.IOperations;
import com.venus.finance.model.FuturesStrategy;

public interface IFuturesStrategyService extends IOperations<FuturesStrategy> {
	public List<FuturesStrategy> findFuturesStrategyByIsUsed(String isUse);
}