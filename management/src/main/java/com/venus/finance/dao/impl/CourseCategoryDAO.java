package com.venus.finance.dao.impl;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.venus.finance.model.TbCourseCategory;
import com.venus.finance.dao.AbstractHibernateDAO;
import com.venus.finance.dao.ICourseCategoryDAO;
import com.venus.finance.dao.ITeacherDAO;

@Repository("courseCategoryDAO")
public class CourseCategoryDAO extends AbstractHibernateDAO<TbCourseCategory> implements ICourseCategoryDAO {

    public CourseCategoryDAO() {
        super();
        setClazz(TbCourseCategory.class);
    }

	@Override
	public Long findAllTbCourseCategoryCount(String name) {
		try {
			String hql = "select count(*) from TbCourseCategory u where u.coursename is null or u.coursename like :name";
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
	public List findAllTbCourseCategory(int start, int pageSize, String name) {
		try {
			final String hql = "from TbCourseCategory u where u.coursename is null or u.coursename like :name  order by id desc";
			
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

	@Override
	public boolean saveTbCourseCategory(TbCourseCategory TbCourseCategory) {
		boolean result = false;
		try {
			getCurrentSession().saveOrUpdate(TbCourseCategory);
			result = true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}

	@Override
	public TbCourseCategory findAllTbCourseCategoryByCode(String code) {
		try {
			final String hql = "from TbCourseCategory u where u.coursecode  = :coursecode  order by id desc";
			
			Query query = getCurrentSession().createQuery(hql).setParameter("coursecode", code);
			List list = query.list();
			if(list.size()>0) {
				return (TbCourseCategory)list.get(0);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
}