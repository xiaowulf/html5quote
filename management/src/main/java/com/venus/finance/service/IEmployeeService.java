package com.venus.finance.service;
import java.util.List;

import com.venus.finance.dao.IOperations;
import com.venus.finance.model.TbEmployee;

public interface IEmployeeService extends IOperations<TbEmployee> {
	TbEmployee findEmployeeByNameAndPwd(String username, String pwd);
	public Long findAllTbEmployeeCount(String name);
	public List findAllTbEmployee(int start,int pageSize,String name);
	public void saveTbEmployee(TbEmployee tbEmployee);
}