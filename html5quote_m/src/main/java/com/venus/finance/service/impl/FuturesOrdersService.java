package com.venus.finance.service.impl;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.venus.finance.dao.IOperations;
import com.venus.finance.model.FuturesMessage;
import com.venus.finance.model.FuturesOrders;
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
}