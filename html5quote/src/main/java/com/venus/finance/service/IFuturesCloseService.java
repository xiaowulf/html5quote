package com.venus.finance.service;
import java.util.List;

import com.venus.finance.dao.IOperations;
import com.venus.finance.model.FuturesClose;
import com.venus.finance.model.FuturesOrders;

public interface IFuturesCloseService extends IOperations<FuturesClose> {
	public List<FuturesClose> findFuturesCloseByDate(Long date);
}