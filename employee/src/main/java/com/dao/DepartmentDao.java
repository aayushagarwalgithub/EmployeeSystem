package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.classes.Department;

public class DepartmentDao 
{
	public int addDepartment(Department department) 
	{
		int val=1;
		try
		{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/emp_temp1?useSSL=false","root","root");  
//			Statement stmt=con.createStatement();  
			
			String query = "insert into departments(departmentId,departmentName) values(?, ?);";

		      PreparedStatement preparedStmt = con.prepareStatement(query);
		      
		      preparedStmt.setInt(1, department.getDepartmentId());
		      preparedStmt.setString (2, department.getDepartmentName());
		      
			preparedStmt.execute();
			
			con.close();
			val=1;
			System.out.println("Success in EmplyeeDao.java");
		}
		catch(SQLException e)
		{ 
			val=0;
			System.out.println("failed");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		return val;
	}
	
	public int deleteDepartment(Department department) 
	{
		int val=1;
		try
		{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/emp_temp1?useSSL=false","root","root");  
//			Statement stmt=con.createStatement();  
			
			String query = "delete from departments where department_id =?);";

		      PreparedStatement preparedStmt = con.prepareStatement(query);
		      preparedStmt.setInt(1, department.getDepartmentId());		      
			preparedStmt.execute();
			
			con.close();
			val=1;
			System.out.println("Success in EmplyeeDao.java");
		}
		catch(SQLException e)
		{ 
			val=0;
			System.out.println("failed");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		return val;
	}	
	
	public List<Department> viewAllDepartments() 
	{
		List<Department> list = new ArrayList<>();
		try
		{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/emp_temp1?useSSL=false","root","root");  
			String query = "select * from departments;";
		    Statement statement = con.createStatement();
		    ResultSet resultSet = statement.executeQuery(query);
					    
		    while(resultSet.next())
		    {
		    	Department department = new Department(resultSet.getInt("departmentId"),
		    			resultSet.getString("departmentName"));
		    	System.out.println(department);
		    	list.add(department);   	
		    }
		    con.close();
			System.out.println("Success in EmplyeeDao.java");
			
		}
		catch(SQLException e)
		{ 
			System.out.println("failed");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}  
		return list;
		
	}
}
