package com.venus.finance.dao;
import org.springframework.stereotype.Repository;

import com.venus.finance.model.FuturesMessage;


@Repository("futuresMessageDAO")
public class FuturesMessageDAO extends AbstractHibernateDao<FuturesMessage> implements IFuturesMessageDAO {

    public FuturesMessageDAO() {
        super();
        setClazz(FuturesMessage.class);
    }
}