package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.classes.Employee;

public class EmployeeDao {

	public int storeEmployee(Employee employee) 
	{
		int val=1;
		try
		{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/emp_temp1?useSSL=false","root","root");  
//			Statement stmt=con.createStatement();  
			
			String query = "insert into employees(firstname,lastname,dob,email,department_id,username,password) values(?, ?, ?, ?, ?, ?, ?);";

		      PreparedStatement preparedStmt = con.prepareStatement(query);
		      
		      preparedStmt.setString (1, employee.getFirstname());
		      preparedStmt.setString (2, employee.getLastname());
		      preparedStmt.setString (3, employee.getDob());
		      preparedStmt.setString (4, employee.getEmail());
		      preparedStmt.setInt (5, employee.getDepartment_id());
		      preparedStmt.setString (6, employee.getUsername());
		      preparedStmt.setString (7, employee.getPassword());
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
	public int deleteEmployee(Employee employee) 
	{
		int val=1;
		try
		{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/emp_temp1?useSSL=false","root","root");  			
			String query = "delete from employees where username= ?;";
		    PreparedStatement preparedStmt = con.prepareStatement(query);
		    preparedStmt.setString (1, employee.getUsername());
		    
		    val= preparedStmt.executeUpdate();
			con.close();
			System.out.println("Success in deleteEmployee in EmplyeeDao.java");
		}
		catch(SQLException e)
		{ 
			val=0;
			System.out.println("failed delete Employee in employee.java");
			e.printStackTrace();
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}  
		return val;
	}
	
	public int updateEmployee(Employee employee) 
	{
		int val=1;
		try
		{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/emp_temp1?useSSL=false","root","root");  
			/*
			String query = "update employees set num_points = ? where first_name = ?\"";
		    PreparedStatement preparedStmt = con.prepareStatement(query);
		    preparedStmt.setString (1, employee.getUsername());
		    preparedStmt.executeUpdate();
			
			con.close();
			val=1;
			System.out.println("Success in EmplyeeDao.java");
		
			 */		
			}
		catch(SQLException e)
		{ 
			val=0;
			System.out.println("failed");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}  
		return val;
	}
	public int viewEmployee(Employee employee) 
	{
		int val=1;
		try
		{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/emp_temp1?useSSL=false","root","root");  
			
			String query = "delete from employees where username= ?;";
		    PreparedStatement preparedStmt = con.prepareStatement(query);
		    preparedStmt.setString (1, employee.getUsername());
		    val = preparedStmt.executeUpdate();
			con.close();
			System.out.println("Success in EmplyeeDao.java");
		}
		catch(SQLException e)
		{ 
			val=0;
			System.out.println("failed");
			e.printStackTrace();
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}  
		return val;
	}
	public List<Employee> viewAllEmployees() 
	{
		List<Employee> list = new ArrayList<>();
		try
		{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/emp_temp1?useSSL=false","root","root");  
			String query = "select * from employees;";
		    Statement statement = con.createStatement();
		    ResultSet resultSet = statement.executeQuery(query);
					    
		    while(resultSet.next())
		    {
		    	Employee e = new Employee(resultSet.getInt("empid"),
		    			resultSet.getString("firstname"),
		    			resultSet.getString("lastname"),
		    			resultSet.getString("dob"),
		    			resultSet.getString("email"),
		    			resultSet.getInt("department_id"),
		    			resultSet.getString("username"),
		    			resultSet.getString("password"));
		    	System.out.println(e);
		    	list.add(e);   	
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
