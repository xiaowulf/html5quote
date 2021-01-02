package com.venus.finance.dao.impl;
import org.springframework.stereotype.Repository;

import com.venus.finance.dao.IFuturesStrategyDAO;
import com.venus.finance.model.FuturesStrategy;
import com.venus.finance.dao.AbstractHibernateDAO;

@Repository("futuresStrategyDAO")
public class FuturesStrategyDAO extends AbstractHibernateDAO<FuturesStrategy> implements IFuturesStrategyDAO {

    public FuturesStrategyDAO() {
        super();
        setClazz(FuturesStrategy.class);
    }
}