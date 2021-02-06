package com.venus.finance.service.impl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.venus.finance.dao.IOperations;
import com.venus.finance.dao.ITeacherDAO;
import com.venus.finance.model.TbEmployee;
import com.venus.finance.model.TbTeacher;
import com.venus.finance.model.FuturesMessage;
import com.venus.finance.model.TbCourse;
import com.venus.finance.service.IFuturesMessageService;
import com.venus.finance.service.ITeacherService;
import com.venus.finance.dao.ICourseDAO;
import com.venus.finance.dao.IEmployeeDAO;
import com.venus.finance.dao.IFuturesMessageDAO;
import com.venus.finance.service.AbstractService;
import com.venus.finance.service.ICourseService;
import com.venus.finance.service.IEmployeeService;


@Service("courseService")
public class CourseService extends AbstractService<TbCourse> implements ICourseService {

    @Resource(name="courseDAO")
    private ICourseDAO dao;
    
    public CourseService() {
        super();
    }

	@Override
	protected IOperations<TbCourse> getDao() {
		return this.dao;
	}

	@Override
	public Long findAllTbCourseCount(String name) {
		return this.dao.findAllTbCourseCount(name);
	}

	@Override
	public List findAllTbCourse(int start, int pageSize, String name) {
		return this.dao.findAllTbCourse(start, pageSize, name);
	}

	@Override
	public boolean saveTbCourse(TbCourse tbCourse) {
		return this.dao.saveTbCourse(tbCourse);
	}

	@Override
	public TbCourse findAllTbCourseByCourseName(String coursename) {
		return this.dao.findAllTbCourseByCode(coursename);
	}
}