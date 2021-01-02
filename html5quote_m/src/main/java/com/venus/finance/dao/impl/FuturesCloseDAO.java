package com.venus.finance.dao.impl;
import org.springframework.stereotype.Repository;

import com.venus.finance.dao.IFuturesStrategyDAO;
import com.venus.finance.model.FuturesClose;
import com.venus.finance.dao.AbstractHibernateDAO;
import com.venus.finance.dao.IFuturesCloseDAO;

@Repository("futuresCloseDAO")
public class FuturesCloseDAO extends AbstractHibernateDAO<FuturesClose> implements IFuturesCloseDAO {

    public FuturesCloseDAO() {
        super();
        setClazz(FuturesClose.class);
    }
}