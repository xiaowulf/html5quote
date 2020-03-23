package com.venus.finance.service;
import java.util.List;

import com.venus.finance.dao.IOperations;
import com.venus.finance.model.TbCourseCategory;

public interface ICourseCategoryService extends IOperations<TbCourseCategory> {
	public Long findAllTbCourseCategoryCount(String name);
	public List findAllTbCourseCategory(int start,int pageSize,String name);
	public boolean saveTbCourseCategory(TbCourseCategory TbCourseCategory);
	public TbCourseCategory findAllTbCourseCategoryByCode(String username);
}