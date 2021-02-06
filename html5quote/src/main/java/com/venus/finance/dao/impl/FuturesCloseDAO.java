package com.venus.finance.dao.impl;
import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.venus.finance.dao.IFuturesStrategyDAO;
import com.venus.finance.model.FuturesClose;
import com.venus.finance.model.FuturesStrategy;
import com.venus.finance.dao.AbstractHibernateDAO;
import com.venus.finance.dao.IFuturesCloseDAO;

@Repository("futuresCloseDAO")
public class FuturesCloseDAO extends AbstractHibernateDAO<FuturesClose> implements IFuturesCloseDAO {

    public FuturesCloseDAO() {
        super();
        setClazz(FuturesClose.class);
    }

	@Override
	public List<FuturesClose> findFuturesCloseByDate(Long date) {
		Session session = getCurrentSession();
		try {
			List<FuturesClose> list = session
					.createQuery("from FuturesClose u where record_date=:record_date order by id asc")
					.setParameter("record_date", date).list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}