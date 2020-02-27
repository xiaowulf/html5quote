package com.venus.finance.service;
import com.venus.finance.dao.IOperations;
import com.venus.finance.model.TbEmployee;

public interface IEmployeeService extends IOperations<TbEmployee> {
	TbEmployee findEmployeeByNameAndPwd(String username, String pwd);
}