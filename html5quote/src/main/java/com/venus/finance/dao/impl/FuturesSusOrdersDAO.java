package com.venus.finance.dao.impl;
import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.venus.finance.dao.IFuturesStrategyDAO;
import com.venus.finance.dao.IFuturesSusOrdersDAO;
import com.venus.finance.model.FuturesOrders;
import com.venus.finance.model.FuturesResult;
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

	@Override
	public void deleteAllSusOrders() {
		Session session = getCurrentSession();
		try {
			session.createQuery("delete from FuturesSusOrders u").executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}