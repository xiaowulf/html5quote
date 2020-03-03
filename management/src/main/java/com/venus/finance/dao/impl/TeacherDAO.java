package com.venus.finance.dao.impl;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.venus.finance.model.TbTeacher;
import com.venus.finance.dao.AbstractHibernateDAO;
import com.venus.finance.dao.ITeacherDAO;

@Repository("teacherDAO")
public class TeacherDAO extends AbstractHibernateDAO<TbTeacher> implements ITeacherDAO {

    public TeacherDAO() {
        super();
        setClazz(TbTeacher.class);
    }

	@Override
	public Long findAllTbTeacherCount(String name) {
		try {
			String hql = "select count(*) from TbTeacher u where u.username like :name";
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
	public List findAllTbTeacher(int start, int pageSize, String name) {
		try {
			final String hql = "from TbTeacher u where u.username like :name  order by id desc";
			
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