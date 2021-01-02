package com.venus.finance.service.impl;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.venus.finance.dao.IOperations;
import com.venus.finance.model.FuturesMessage;
import com.venus.finance.model.FuturesOrders;
import com.venus.finance.model.FuturesStrategy;
import com.venus.finance.model.FuturesSusOrders;
import com.venus.finance.service.IFuturesMessageService;
import com.venus.finance.service.IFuturesOrdersService;
import com.venus.finance.service.IFuturesStrategyService;
import com.venus.finance.service.IFuturesSusOrdersService;
import com.venus.finance.dao.IFuturesMessageDAO;
import com.venus.finance.dao.IFuturesOrdersDAO;
import com.venus.finance.dao.IFuturesStrategyDAO;
import com.venus.finance.dao.IFuturesSusOrdersDAO;
import com.venus.finance.service.AbstractService;


@Service("futuresSusOrdersService")
public class FuturesSusOrdersService extends AbstractService<FuturesSusOrders> implements IFuturesSusOrdersService {

    @Resource(name="futuresSusOrdersDAO")
    private IFuturesSusOrdersDAO dao;
    
    public FuturesSusOrdersService() {
        super();
    }
    
    
    @Override
    protected IOperations<FuturesSusOrders> getDao() {
        return this.dao;
    }
}