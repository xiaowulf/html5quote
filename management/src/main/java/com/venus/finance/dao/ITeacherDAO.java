package com.venus.finance.dao;

import java.util.List;

import com.venus.finance.model.TbTeacher;

public interface ITeacherDAO extends IOperations<TbTeacher> {
	public Long findAllTbTeacherCount(String name);
	public List findAllTbTeacher(int start,int pageSize,String name);
	public boolean saveTbTeacher(TbTeacher tbTeacher);
}