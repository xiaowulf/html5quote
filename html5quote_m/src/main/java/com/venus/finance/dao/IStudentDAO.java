package com.venus.finance.dao;

import java.util.List;

import com.venus.finance.model.TbStudent;

public interface IStudentDAO extends IOperations<TbStudent> {
	public Long findAllTbStudentCount(String name);
	public List findAllTbStudent(int start,int pageSize,String name);
}