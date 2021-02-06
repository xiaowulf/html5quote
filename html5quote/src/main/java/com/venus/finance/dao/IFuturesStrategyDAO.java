package com.venus.finance.dao;

import java.util.List;

import com.venus.finance.model.FuturesStrategy;

public interface IFuturesStrategyDAO extends IOperations<FuturesStrategy> {
	public List<FuturesStrategy> findFuturesStrategyByIsUsed(String isUse);
}