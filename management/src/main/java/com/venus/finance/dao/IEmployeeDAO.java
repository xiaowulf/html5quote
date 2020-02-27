package com.venus.finance.dao;

import com.venus.finance.model.TbEmployee;

public interface IEmployeeDAO extends IOperations<TbEmployee> {
	TbEmployee findEmployeeByNameAndPwd(String username,String pwd);
}