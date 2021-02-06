package com.venus.finance.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.venus.finance.dao.IFuturesStrategyDAO;
import com.venus.finance.model.FuturesOrders;
import com.venus.finance.model.FuturesStrategy;
import com.venus.finance.dao.AbstractHibernateDAO;

@Repository("futuresStrategyDAO")
public class FuturesStrategyDAO extends AbstractHibernateDAO<FuturesStrategy> implements IFuturesStrategyDAO {

	public FuturesStrategyDAO() {
		super();
		setClazz(FuturesStrategy.class);
	}

	@Override
	public List<FuturesStrategy> findFuturesStrategyByIsUsed(String isUse) {
		Session session = getCurrentSession();
		try {
			List<FuturesStrategy> list = session
					.createQuery("from FuturesStrategy u where is_use=:isUse order by id asc")
					.setParameter("isUse", isUse).list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}