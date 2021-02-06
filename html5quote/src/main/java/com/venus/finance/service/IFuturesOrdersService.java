package com.venus.finance.service;
import java.util.List;

import com.venus.finance.dao.IOperations;
import com.venus.finance.model.FuturesOrders;

public interface IFuturesOrdersService extends IOperations<FuturesOrders> {
	public List<FuturesOrders> findFuturesOrdersByStrategyID(Long strategyID);
}