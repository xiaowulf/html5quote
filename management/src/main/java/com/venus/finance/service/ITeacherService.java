package com.venus.finance.service;
import java.util.List;

import com.venus.finance.dao.IOperations;
import com.venus.finance.model.TbEmployee;
import com.venus.finance.model.TbTeacher;

public interface ITeacherService extends IOperations<TbTeacher> {
	public Long findAllTbTeacherCount(String name);
	public List findAllTbTeacher(int start,int pageSize,String name);
	public boolean saveTbTeacher(TbTeacher tbTeacher);
	public TbTeacher findAllTbTeacherByUsername(String username);
}