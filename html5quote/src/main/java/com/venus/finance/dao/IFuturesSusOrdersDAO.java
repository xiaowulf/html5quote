package com.venus.finance.dao;

import java.util.List;

import com.venus.finance.model.FuturesStrategy;
import com.venus.finance.model.FuturesSusOrders;

public interface IFuturesSusOrdersDAO extends IOperations<FuturesSusOrders> {
	public void deleteAllSusOrders();
}