package com.venus.finance.dao;

import java.util.List;

import com.venus.finance.model.TbCourseCategory;
import com.venus.finance.model.TbCourseCategory;

public interface ICourseCategoryDAO extends IOperations<TbCourseCategory> {
	public Long findAllTbCourseCategoryCount(String name);
	public List findAllTbCourseCategory(int start,int pageSize,String name);
	public boolean saveTbCourseCategory(TbCourseCategory TbCourseCategory);
	public TbCourseCategory findAllTbCourseCategoryByCode(String code);
	
}