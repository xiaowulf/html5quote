package com.venus.finance.dao.impl;
import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.venus.finance.dao.IFuturesStrategyDAO;
import com.venus.finance.model.FuturesOrders;
import com.venus.finance.model.FuturesOrdersJS;
import com.venus.finance.model.FuturesStrategy;
import com.venus.finance.dao.AbstractHibernateDAO;
import com.venus.finance.dao.IFuturesOrdersDAO;

@Repository("futuresOrdersDAO")
public class FuturesOrdersDAO extends AbstractHibernateDAO<FuturesOrders> implements IFuturesOrdersDAO {

    public FuturesOrdersDAO() {
        super();
        setClazz(FuturesOrders.class);
    }
    @Override
	public List<FuturesOrders> findFuturesOrdersByStrategyID(Long strategyID) {
		Session session =  getCurrentSession();
		try{
			if(strategyID.longValue()==0L) {
				List<FuturesOrders> list = session.createQuery("from FuturesOrders u order by id asc").list();
				return list;
			}else {
				List<FuturesOrders> list = session.createQuery("from FuturesOrders u where strategy_id=:strategy_id order by id asc").setParameter("strategy_id", strategyID).list();
				return list;
			}
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		
	}
	@Override
	public void deleteAllFuturesOrdersJSByDate(Long date) {
		Session session = getCurrentSession();
		try {
			session.createQuery("delete from FuturesOrdersJS u where u.record_date=:date").setParameter("date", date).executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public List<FuturesOrdersJS> findFuturesOrdersJSByDate(Long date) {
		Session session =  getCurrentSession();
		try{
			List<FuturesOrdersJS> list = session.createQuery("from FuturesOrdersJS u where u.record_date=:date order by id asc").setParameter("date", date).list();
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public void saveFuturesOrdersJS(FuturesOrdersJS futuresOrdersJS) {
		Session session =  getCurrentSession();
		try{
			session.saveOrUpdate(futuresOrdersJS);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}