package com.venus.finance.dao.impl;
import java.util.List;

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
}