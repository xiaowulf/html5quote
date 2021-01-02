package com.venus.finance.dao.impl;
import org.springframework.stereotype.Repository;

import com.venus.finance.dao.IFuturesStrategyDAO;
import com.venus.finance.model.FuturesOrders;
import com.venus.finance.model.FuturesStrategy;
import com.venus.finance.dao.AbstractHibernateDAO;
import com.venus.finance.dao.IFuturesOrdersDAO;

@Repository("futuresOrdersDAO")
public class FuturesOrdersDAO extends AbstractHibernateDAO<FuturesOrders> implements IFuturesOrdersDAO {

    public FuturesOrdersDAO() {
        super();
        setClazz(FuturesOrders.class);
    }
}