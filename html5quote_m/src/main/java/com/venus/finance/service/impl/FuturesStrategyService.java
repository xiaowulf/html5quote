package com.venus.finance.service.impl;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.venus.finance.dao.IOperations;
import com.venus.finance.model.FuturesMessage;
import com.venus.finance.model.FuturesStrategy;
import com.venus.finance.service.IFuturesMessageService;
import com.venus.finance.service.IFuturesStrategyService;
import com.venus.finance.dao.IFuturesMessageDAO;
import com.venus.finance.dao.IFuturesStrategyDAO;
import com.venus.finance.service.AbstractService;


@Service("futuresStrategyService")
public class FuturesStrategyService extends AbstractService<FuturesStrategy> implements IFuturesStrategyService {

    @Resource(name="futuresStrategyDAO")
    private IFuturesStrategyDAO dao;
    
    public FuturesStrategyService() {
        super();
    }
    
    
    @Override
    protected IOperations<FuturesStrategy> getDao() {
        return this.dao;
    }
}