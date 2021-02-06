package com.venus.finance.service.impl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.venus.finance.dao.IOperations;
import com.venus.finance.model.FuturesMessage;
import com.venus.finance.model.FuturesResult;
import com.venus.finance.model.FuturesStrategy;
import com.venus.finance.service.IFuturesMessageService;
import com.venus.finance.service.IFuturesResultService;
import com.venus.finance.service.IFuturesStrategyService;
import com.venus.finance.dao.IFuturesMessageDAO;
import com.venus.finance.dao.IFuturesResultDAO;
import com.venus.finance.dao.IFuturesStrategyDAO;
import com.venus.finance.service.AbstractService;


@Service("futuresResultService")
public class FuturesResultService extends AbstractService<FuturesResult> implements IFuturesResultService {

    @Resource(name="futuresResultDAO")
    private IFuturesResultDAO dao;
    
    public FuturesResultService() {
        super();
    }
    
    
    @Override
    protected IOperations<FuturesResult> getDao() {
        return this.dao;
    }


	@Override
	public List<FuturesResult> findFuturesResultByDate(Long date) {
		return dao.findFuturesResultByDate(date);
	}


	@Override
	public String findMaxDate() {
		return dao.findMaxDate();
	}
	@Override
	public List<FuturesResult> findStrategyFuturesResultByDate(Long date) {
		return dao.findStrategyFuturesResultByDate(date);
	}
}