package com.venus.finance.dao.impl;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.venus.finance.model.TbEmployee;
import com.venus.finance.dao.AbstractHibernateDAO;
import com.venus.finance.dao.IEmployeeDAO;

@Repository("employeeDAO")
public class EmployeeDAO extends AbstractHibernateDAO<TbEmployee> implements IEmployeeDAO {

    public EmployeeDAO() {
        super();
        setClazz(TbEmployee.class);
    }
	@Override
	public TbEmployee findEmployeeByNameAndPwd(String username, String pwd) {
		Session session =  getCurrentSession();
		try{
			List<TbEmployee> list = session.createQuery("from TbEmployee u where u.userName=:username and password=:pwd")
					.setParameter("username", username)
					.setParameter("pwd", pwd).list();
			if(list!=null&&list.size()>0){
				TbEmployee employee = list.get(0);
				return employee;
			}else{
				return null;
			}
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		
	}
	@Override
	public Long findAllTbEmployeeCount(String name) {
		try {
			String hql = "select count(*) from TbEmployee u where (u.userName like :name or u.trueName like :name)";
			Long userCount = (Long) getCurrentSession()
					.createQuery(hql)
					.setParameter("name", "%"+name+"%")
					.uniqueResult();
			return userCount;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return 0L;
	}
	@Override
	public List findAllTbEmployee(int start, int pageSize, String name) {
		try {
			final String hql = "from TbEmployee u where (u.userName like :name or u.trueName like :name) order by id desc";
			
			Query query = getCurrentSession().createQuery(hql).setParameter("name", "%"+name+"%");
			//3.分页
			query.setFirstResult(start);//从什么位置开始，默认为0
			query.setMaxResults(pageSize);//最多检出的条数
			//4.执行SQL
			List list = query.list();
			return list;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
}