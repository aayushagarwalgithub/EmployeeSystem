package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.classes.Regulation;

public class RegulationDao {

	public int addRegulation(Regulation regulation) 
	{
		int val=1;
		try
		{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/emp_temp1?useSSL=false","root","root");  
			
			String query = "insert into regulations(regulationId,regulationName,departmentName) values(?, ?, ?);";

		      PreparedStatement preparedStmt = con.prepareStatement(query);
		      
		      preparedStmt.setInt(1, regulation.getRegulationId());
		      preparedStmt.setString (2, regulation.getRegulationName());
		      preparedStmt.setString (3, regulation.getDepartmentName());
		    //  preparedStmt.setString (4, regulation.getListOfComments());
		    preparedStmt.execute();
			
			con.close();
			val=1;
			System.out.println("Success in RegulationDao.java");
		}
		catch(SQLException e)
		{ 
			val=0;
			System.out.println("failed");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			val=0;
			e.printStackTrace();
		}  
		return val;
	}
	
	public int deleteRegulation(Regulation regulation) 
	{
		int val=1;
		try
		{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/emp_temp1?useSSL=false","root","root");  
//			Statement stmt=con.createStatement();  
			
			String query = "delete from regulation where regulationId =?);";

		    PreparedStatement preparedStmt = con.prepareStatement(query);
		    preparedStmt.setInt(1, regulation.getRegulationId());		      
			preparedStmt.execute();
			
			con.close();
			val=1;
			System.out.println("Success in RegulationDao.java");
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
	
	public List<Regulation> viewAllRegulations(String departmentName) 
	{
		List<Regulation> list = new ArrayList<>();
		try
		{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/emp_temp1?useSSL=false","root","root");  
			String query = "select * from regulations where departmentName = '"+departmentName+"';";
			
			System.out.println("--"+departmentName);
			Statement statement = con.createStatement();
		    ResultSet resultSet = statement.executeQuery(query);
					    
		    while(resultSet.next())
		    {
		    	Regulation regulation = new Regulation(resultSet.getInt("regulationId"),
		    			resultSet.getString("regulationName"),
		    			resultSet.getString("departmentName"),
		    			resultSet.getString("listOfComments"));
		    	System.out.println(regulation);
		    	list.add(regulation);   	
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
