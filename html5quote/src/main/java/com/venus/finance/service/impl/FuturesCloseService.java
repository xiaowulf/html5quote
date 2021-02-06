package com.venus.finance.service.impl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.venus.finance.dao.IOperations;
import com.venus.finance.model.FuturesClose;
import com.venus.finance.model.FuturesMessage;
import com.venus.finance.model.FuturesOrders;
import com.venus.finance.model.FuturesStrategy;
import com.venus.finance.service.IFuturesMessageService;
import com.venus.finance.service.IFuturesOrdersService;
import com.venus.finance.service.IFuturesStrategyService;
import com.venus.finance.dao.IFuturesCloseDAO;
import com.venus.finance.dao.IFuturesMessageDAO;
import com.venus.finance.dao.IFuturesOrdersDAO;
import com.venus.finance.dao.IFuturesStrategyDAO;
import com.venus.finance.service.AbstractService;
import com.venus.finance.service.IFuturesCloseService;


@Service("futuresCloseService")
public class FuturesCloseService extends AbstractService<FuturesClose> implements IFuturesCloseService {

    @Resource(name="futuresCloseDAO")
    private IFuturesCloseDAO dao;
    
    public FuturesCloseService() {
        super();
    }
    
    
    @Override
    protected IOperations<FuturesClose> getDao() {
        return this.dao;
    }


	@Override
	public List<FuturesClose> findFuturesCloseByDate(Long date) {
		return dao.findFuturesCloseByDate(date);
	}
}