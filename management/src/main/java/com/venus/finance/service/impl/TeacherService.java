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
import com.venus.finance.service.IFuturesMessageService;
import com.venus.finance.service.ITeacherService;
import com.venus.finance.dao.IEmployeeDAO;
import com.venus.finance.dao.IFuturesMessageDAO;
import com.venus.finance.service.AbstractService;
import com.venus.finance.service.IEmployeeService;


@Service("teacherService")
public class TeacherService extends AbstractService<TbTeacher> implements ITeacherService {

    @Resource(name="teacherDAO")
    private ITeacherDAO dao;
    
    public TeacherService() {
        super();
    }
    @Override
    protected IOperations<TbTeacher> getDao() {
        return this.dao;
    }
	@Override
	public Long findAllTbTeacherCount(String name) {
		return this.dao.findAllTbTeacherCount(name);
	}
	@Override
	public List findAllTbTeacher(int start, int pageSize, String name) {
		return this.dao.findAllTbTeacher(start, pageSize, name);
	}
	@Override
	public boolean saveTbTeacher(TbTeacher tbTeacher) {
		return this.dao.saveTbTeacher(tbTeacher);
	}
}