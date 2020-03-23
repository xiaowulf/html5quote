package com.venus.finance.service;
import java.util.List;

import com.venus.finance.dao.IOperations;
import com.venus.finance.model.TbCourse;

public interface ICourseService extends IOperations<TbCourse> {
	public Long findAllTbCourseCount(String name);
	public List findAllTbCourse(int start,int pageSize,String name);
	public boolean saveTbCourse(TbCourse TbCourse);
	public TbCourse findAllTbCourseByUsername(String username);
}