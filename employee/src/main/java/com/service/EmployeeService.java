package com.service;

import java.sql.SQLException;
import java.util.List;

import com.classes.Employee;
import com.dao.EmployeeDao;


public class EmployeeService 
{
	public String storeEmployee(Employee e) throws SQLException
	{
		EmployeeDao employeeDao = new EmployeeDao();
		if(employeeDao.storeEmployee(e) > 0) 
		{
			return "success";
		}
		else 
		{
			return "failure";
		}
	}
	public String deleteEmployee(Employee e) throws SQLException
	{
		EmployeeDao employeeDao = new EmployeeDao();
		if(employeeDao.deleteEmployee(e) > 0) 
		{
			return "success";
		}
		else 
		{
			return "failure";
		}
	}
	public List<Employee> getAllEmployees()
	{
		EmployeeDao employeeDao = new EmployeeDao();
		return employeeDao.viewAllEmployees();	
	}
	
}
