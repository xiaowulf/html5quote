package com.venus.finance.dao.impl;
import org.springframework.stereotype.Repository;

import com.venus.finance.dao.IFuturesStrategyDAO;
import com.venus.finance.dao.IFuturesSusOrdersDAO;
import com.venus.finance.model.FuturesOrders;
import com.venus.finance.model.FuturesStrategy;
import com.venus.finance.model.FuturesSusOrders;
import com.venus.finance.dao.AbstractHibernateDAO;
import com.venus.finance.dao.IFuturesOrdersDAO;

@Repository("futuresSusOrdersDAO")
public class FuturesSusOrdersDAO extends AbstractHibernateDAO<FuturesSusOrders> implements IFuturesSusOrdersDAO {

    public FuturesSusOrdersDAO() {
        super();
        setClazz(FuturesSusOrders.class);
    }
}