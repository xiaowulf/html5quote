package com.venus.finance.service;
import java.util.List;

import com.venus.finance.dao.IOperations;
import com.venus.finance.model.FuturesOrders;
import com.venus.finance.model.FuturesOrdersJS;

public interface IFuturesOrdersService extends IOperations<FuturesOrders> {
	public List<FuturesOrders> findFuturesOrdersByStrategyID(Long strategyID);
	public List<FuturesOrdersJS> findFuturesOrdersJSByDate(Long date);
	public void deleteAllFuturesOrdersJSByDate(Long date);
	public void saveFuturesOrdersJS(FuturesOrdersJS futuresOrdersJS);
}