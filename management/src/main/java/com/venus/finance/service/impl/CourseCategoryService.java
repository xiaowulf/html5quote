package com.venus.finance.service.impl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.venus.finance.dao.IOperations;
import com.venus.finance.dao.ITeacherDAO;
import com.venus.finance.model.TbEmployee;
import com.venus.finance.model.TbCourseCategory;
import com.venus.finance.model.FuturesMessage;
import com.venus.finance.service.IFuturesMessageService;
import com.venus.finance.service.ITeacherService;
import com.venus.finance.dao.ICourseCategoryDAO;
import com.venus.finance.dao.IEmployeeDAO;
import com.venus.finance.dao.IFuturesMessageDAO;
import com.venus.finance.service.AbstractService;
import com.venus.finance.service.ICourseCategoryService;
import com.venus.finance.service.IEmployeeService;


@Service("courseCategoryService")
public class CourseCategoryService extends AbstractService<TbCourseCategory> implements ICourseCategoryService {

    @Resource(name="teacherDAO")
    private ICourseCategoryDAO dao;
    
    public CourseCategoryService() {
        super();
    }
    @Override
    protected IOperations<TbCourseCategory> getDao() {
        return this.dao;
    }
	@Override
	public Long findAllTbCourseCategoryCount(String name) {
		return this.dao.findAllTbCourseCategoryCount(name);
	}
	@Override
	public List findAllTbCourseCategory(int start, int pageSize, String name) {
		return this.dao.findAllTbCourseCategory(start, pageSize, name);
	}
	@Override
	public boolean saveTbCourseCategory(TbCourseCategory TbCourseCategory) {
		return this.dao.saveTbCourseCategory(TbCourseCategory);
	}
	@Override
	public TbCourseCategory findAllTbCourseCategoryByCode(String code) {
		return this.dao.findAllTbCourseCategoryByCode(code);
	}
}