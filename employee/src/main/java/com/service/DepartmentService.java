package com.service;

import java.sql.SQLException;
import java.util.List;

import com.classes.Department;
import com.dao.DepartmentDao;

public class DepartmentService 
{
	public String addDepartment(Department department)
	{
		DepartmentDao departmentDao = new DepartmentDao();
		if(departmentDao.addDepartment(department) > 0) 
		{
			return "success";
		}
		else 
		{
			return "failure";
		}
	}
	public String deleteDepartment(Department e) throws SQLException
	{
		DepartmentDao departmentDao = new DepartmentDao();
		if(departmentDao.deleteDepartment(e) > 0) 
		{
			return "success";
		}
		else 
		{
			return "failure";
		}
	}
	public List<Department> getAllDepartments()
	{
		DepartmentDao departmentDao = new DepartmentDao();
		return departmentDao.viewAllDepartments();	
	}
	
}
