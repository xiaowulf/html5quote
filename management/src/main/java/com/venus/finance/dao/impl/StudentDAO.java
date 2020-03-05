package com.venus.finance.dao.impl;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.venus.finance.model.TbStudent;
import com.venus.finance.model.TbTeacher;
import com.venus.finance.dao.AbstractHibernateDAO;
import com.venus.finance.dao.IStudentDAO;
import com.venus.finance.dao.ITeacherDAO;

@Repository("studentDAO")
public class StudentDAO extends AbstractHibernateDAO<TbStudent> implements IStudentDAO {

    public StudentDAO() {
        super();
        setClazz(TbStudent.class);
    }

	
	@Override
	public Long findAllTbStudentCount(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List findAllTbStudent(int start, int pageSize, String name) {
		// TODO Auto-generated method stub
		return null;
	}
}