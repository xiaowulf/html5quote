package com.venus.finance.dao;

import java.util.List;

import com.venus.finance.model.FuturesClose;

public interface IFuturesCloseDAO extends IOperations<FuturesClose> {
	public List<FuturesClose> findFuturesCloseByDate(Long date);
}