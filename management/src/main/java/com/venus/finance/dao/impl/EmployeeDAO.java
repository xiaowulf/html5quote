package com.venus.finance.dao.impl;
import org.springframework.stereotype.Repository;

import com.venus.finance.model.Employee;
import com.venus.finance.dao.AbstractHibernateDAO;
import com.venus.finance.dao.IEmployeeDAO;

@Repository("employeeDAO")
public class EmployeeDAO extends AbstractHibernateDAO<Employee> implements IEmployeeDAO {

    public EmployeeDAO() {
        super();
        setClazz(Employee.class);
    }
}