package com.venus.finance.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.venus.finance.dao.IFuturesStrategyDAO;
import com.venus.finance.model.FuturesClose;
import com.venus.finance.model.FuturesOrders;
import com.venus.finance.model.FuturesResult;
import com.venus.finance.model.FuturesStrategy;
import com.venus.finance.dao.AbstractHibernateDAO;
import com.venus.finance.dao.IFuturesResultDAO;

@Repository("futuresResultDAO")
public class FuturesResultDAO extends AbstractHibernateDAO<FuturesResult> implements IFuturesResultDAO {

	public FuturesResultDAO() {
		super();
		setClazz(FuturesResult.class);
	}

	@Override
	public List<FuturesResult> findFuturesResultByDate(Long date) {
		Session session = getCurrentSession();
		try {
			List<FuturesResult> list = session
					.createQuery("from FuturesResult u where record_date=:record_date order by id asc")
					.setParameter("record_date", date).list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public String findMaxDate() {
		Session session = getCurrentSession();
		try {
			String maxDate = session
					.createQuery("select max(record_date) from FuturesResult").uniqueResult().toString();
			return maxDate;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<FuturesResult> findStrategyFuturesResultByDate(Long date) {
		Session session = getCurrentSession();
		try {
			List<FuturesResult> list = session
					.createQuery("from FuturesResult u1,FuturesStrategy u2 where u1.strategy_id=u2.id and u1.record_date=:record_date order by u1.id asc")
					.setParameter("record_date", date).list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Object[]> findFuturesResultByStrategyID(Long strategy_id) {
		Session session = getCurrentSession();
		try {
			List<Object[]> list = session
					.createQuery("from FuturesResult u1,FuturesStrategy u2 where u1.strategy_id=u2.id and u1.strategy_id=:strategy_id order by u1.record_date asc")
					.setParameter("strategy_id", strategy_id).list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}