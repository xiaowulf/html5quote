package com.venus.finance.service.impl;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.venus.finance.dao.IOperations;
import com.venus.finance.model.FuturesMessage;
import com.venus.finance.service.IFuturesMessageService;
import com.venus.finance.dao.IFuturesMessageDAO;
import com.venus.finance.service.AbstractService;


@Service("futuresMessageService")
public class FuturesMessageService extends AbstractService<FuturesMessage> implements IFuturesMessageService {

    @Resource(name="futuresMessageDAO")
    private IFuturesMessageDAO dao;
    
    public FuturesMessageService() {
        super();
    }
    
    
    @Override
    protected IOperations<FuturesMessage> getDao() {
        return this.dao;
    }
}