package com.venus.finance.service.impl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.venus.finance.dao.IOperations;
import com.venus.finance.dao.IStudentDAO;
import com.venus.finance.dao.ITeacherDAO;
import com.venus.finance.model.TbEmployee;
import com.venus.finance.model.TbStudent;
import com.venus.finance.model.TbTeacher;
import com.venus.finance.model.FuturesMessage;
import com.venus.finance.service.IFuturesMessageService;
import com.venus.finance.service.IStudentService;
import com.venus.finance.service.ITeacherService;
import com.venus.finance.dao.IEmployeeDAO;
import com.venus.finance.dao.IFuturesMessageDAO;
import com.venus.finance.service.AbstractService;
import com.venus.finance.service.IEmployeeService;


@Service("studentService")
public class StudentService extends AbstractService<TbStudent> implements IStudentService {

    @Resource(name="studentDAO")
    private IStudentDAO dao;
    
    public StudentService() {
        super();
    }
    @Override
    protected IOperations<TbStudent> getDao() {
        return this.dao;
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