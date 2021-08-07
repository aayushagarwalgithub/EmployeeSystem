package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.classes.Comment;

public class CommentDao {

	public int addComment(Comment comment) 
	{
		int val=1;
		try
		{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/emp_temp1?useSSL=false","root","root");  
			
			String query = "select listOfComments from  regulations where regulationId = ?;";
			
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.setInt(1, comment.getRegulationId());
			
			System.out.println("query="+query);
		    ResultSet resultSet =preparedStmt.executeQuery();
			
		    String listOfComments ="";
		    resultSet.next();
		    listOfComments = resultSet.getString(1);
		    System.out.println("list Of Comments = "+listOfComments);
		    
		    
		    
		    listOfComments = listOfComments+"<br>"+comment.getUsername()+":"+comment.getComment()+".";
		    query = "UPDATE regulations SET listOfComments = ? WHERE regulationId = ?;";
		    
		     preparedStmt = con.prepareStatement(query);
		      
		      preparedStmt.setString (1, listOfComments);
		      preparedStmt.setInt (2, comment.getRegulationId());
			preparedStmt.execute();
			
			con.close();
			val=1;
			System.out.println("Success in commentDao.java");
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
	
	public int deletecomment(Comment comment) 
	{
		int val=1;
		try
		{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/emp_temp1?useSSL=false","root","root");  
//			Statement stmt=con.createStatement();  
			
			String query = "delete from comments where commentId =?);";

		    PreparedStatement preparedStmt = con.prepareStatement(query);
		    preparedStmt.setInt(1, comment.getCommentId());		      
			preparedStmt.execute();
			
			con.close();
			val=1;
			System.out.println("Success in commentDao.java");
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
}