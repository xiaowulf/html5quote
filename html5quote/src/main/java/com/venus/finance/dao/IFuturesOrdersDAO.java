package com.venus.finance.dao;

import java.util.List;

import com.venus.finance.model.FuturesOrders;
import com.venus.finance.model.FuturesOrdersJS;
import com.venus.finance.model.FuturesStrategy;

public interface IFuturesOrdersDAO extends IOperations<FuturesOrders> {
	public List<FuturesOrders> findFuturesOrdersByStrategyID(Long strategyID);
	public void deleteAllFuturesOrdersJSByDate(Long date);
	public List<FuturesOrdersJS> findFuturesOrdersJSByDate(Long date);
	public void saveFuturesOrdersJS(FuturesOrdersJS futuresOrdersJS);
}