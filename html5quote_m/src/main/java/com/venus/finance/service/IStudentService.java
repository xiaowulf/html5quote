package com.venus.finance.service;
import java.util.List;

import com.venus.finance.dao.IOperations;
import com.venus.finance.model.TbStudent;

public interface IStudentService extends IOperations<TbStudent> {
	public Long findAllTbStudentCount(String name);
	public List findAllTbStudent(int start,int pageSize,String name);
}