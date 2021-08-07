package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.classes.Login;

public class LoginDao {

	public int checkLoginDetails(Login login) 
	{
		int val =0;
		String pass ="";
		try
		{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/emp_temp1?useSSL=false","root","root");  
			Statement stmt=con.createStatement();  
			
			ResultSet rs=stmt.executeQuery("SELECT password FROM employees where username="+"'"+login.getUsername() +"';");
			
			int c =0;
			while(rs.next())
			{
				c++;
				pass = rs.getString(1);
			}
			
			if(c == 0)
				return 0;
			 
			System.out.println("password="+pass+",expected= "+login.getPassword());
			
			if(pass.equals(login.getPassword()))
				val= 1;
			else 
				val=0;
			con.close();  
		}
		catch(Exception e)
		{ 
			val =0;
			System.out.println(e);
		}  
			  
		return val;
	} 
}
