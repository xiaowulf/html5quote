package com.venus.finance.dao.impl;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.venus.finance.model.TbCourse;
import com.venus.finance.model.TbTeacher;
import com.venus.finance.dao.AbstractHibernateDAO;
import com.venus.finance.dao.ICourseDAO;
import com.venus.finance.dao.ITeacherDAO;

@Repository("courseDAO")
public class CourseDAO extends AbstractHibernateDAO<TbCourse> implements ICourseDAO {

    public CourseDAO() {
        super();
        setClazz(TbCourse.class);
    }

	@Override
	public Long findAllTbCourseCount(String code) {
		try {
			String hql = "select count(*) from TbCourseCategory u where u.truename is null or u.truename like :name";
			Long userCount = (Long) getCurrentSession()
					.createQuery(hql)
					.setParameter("name", "%"+code+"%")
					.uniqueResult();
			return userCount;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return 0L;
	}

	@Override
	public List findAllTbCourse(int start, int pageSize, String code) {
		return null;
	}

	@Override
	public boolean saveTbCourse(TbCourse tbCourse) {
		return false;
	}

	@Override
	public TbCourse findAllTbCourseByCode(String code) {
		return null;
	}
}