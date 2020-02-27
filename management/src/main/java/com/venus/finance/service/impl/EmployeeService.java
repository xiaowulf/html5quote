package com.venus.finance.service.impl;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.venus.finance.dao.IOperations;
import com.venus.finance.model.TbEmployee;
import com.venus.finance.model.FuturesMessage;
import com.venus.finance.service.IFuturesMessageService;
import com.venus.finance.dao.IEmployeeDAO;
import com.venus.finance.dao.IFuturesMessageDAO;
import com.venus.finance.service.AbstractService;
import com.venus.finance.service.IEmployeeService;


@Service("employeeService")
public class EmployeeService extends AbstractService<TbEmployee> implements IEmployeeService {

    @Resource(name="employeeDAO")
    private IEmployeeDAO dao;
    
    public EmployeeService() {
        super();
    }
    
    
    @Override
    protected IOperations<TbEmployee> getDao() {
        return this.dao;
    }


	@Override
	public TbEmployee findEmployeeByNameAndPwd(String username, String pwd) {
		return this.dao.findEmployeeByNameAndPwd(username, pwd);
	}
}