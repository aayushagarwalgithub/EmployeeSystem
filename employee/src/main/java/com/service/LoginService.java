package com.service;


import com.classes.Login;
import com.dao.LoginDao;

public class LoginService {

	public String checkAdminUser(Login login) 
	{
		if(login.getUsername().equals("admin@gmail.com") && login.getPassword().equals("admin")) 
		{
			return "success";
		}
		else  
		{
			return "failure";
		}
	}
	
	public String checkEmployeeLogin(Login login)  
	{
		LoginDao loginDao = new LoginDao();
			if(loginDao.checkLoginDetails(login) > 0) 
				return "success";
			
			else 
				return  "failure";
	}
}
