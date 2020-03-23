package com.venus.finance.dao;

import java.util.List;

import com.venus.finance.model.TbCourse;
import com.venus.finance.model.TbTeacher;

public interface ICourseDAO extends IOperations<TbCourse>{
	public Long findAllTbCourseCount(String code);
	public List findAllTbCourse(int start,int pageSize,String code);
	public boolean saveTbCourse(TbCourse tbCourse);
	public TbCourse findAllTbCourseByCode(String code);
}