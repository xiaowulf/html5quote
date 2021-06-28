package com.venus.finance.service.impl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.venus.finance.dao.IOperations;
import com.venus.finance.model.FuturesMessage;
import com.venus.finance.model.FuturesOrders;
import com.venus.finance.model.FuturesOrdersJS;
import com.venus.finance.model.FuturesStrategy;
import com.venus.finance.service.IFuturesMessageService;
import com.venus.finance.service.IFuturesOrdersService;
import com.venus.finance.service.IFuturesStrategyService;
import com.venus.finance.dao.IFuturesMessageDAO;
import com.venus.finance.dao.IFuturesOrdersDAO;
import com.venus.finance.dao.IFuturesStrategyDAO;
import com.venus.finance.service.AbstractService;


@Service("futuresOrdersService")
public class FuturesOrdersService extends AbstractService<FuturesOrders> implements IFuturesOrdersService {

    @Resource(name="futuresOrdersDAO")
    private IFuturesOrdersDAO dao;
    
    public FuturesOrdersService() {
        super();
    }
    
    
    @Override
    protected IOperations<FuturesOrders> getDao() {
        return this.dao;
    }
    @Override
    public List<FuturesOrders> findFuturesOrdersByStrategyID(Long strategyID)
    {
    	return dao.findFuturesOrdersByStrategyID(strategyID);
    }


	@Override
	public List<FuturesOrdersJS> findFuturesOrdersJSByDate(Long date) {
		return dao.findFuturesOrdersJSByDate(date);
	}


	@Override
	public void deleteAllFuturesOrdersJSByDate(Long date) {
		dao.deleteAllFuturesOrdersJSByDate(date);
	}


	@Override
	public void saveFuturesOrdersJS(FuturesOrdersJS futuresOrdersJS) {
		dao.saveFuturesOrdersJS(futuresOrdersJS);
	}
}