package com.venus.finance.dao.impl;
import org.springframework.stereotype.Repository;

import com.venus.finance.dao.IFuturesMessageDAO;
import com.venus.finance.model.FuturesMessage;
import com.venus.finance.dao.AbstractHibernateDAO;

@Repository("futuresMessageDAO")
public class FuturesMessageDAO extends AbstractHibernateDAO<FuturesMessage> implements IFuturesMessageDAO {

    public FuturesMessageDAO() {
        super();
        setClazz(FuturesMessage.class);
    }
}