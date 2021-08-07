package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.classes.Login;
import com.service.LoginService;

@Controller
public class LoginController {

	@RequestMapping(value = "loginCheck",method = RequestMethod.POST)
	public ModelAndView checkLoginDetails(HttpServletRequest req,HttpSession session) {
	 
		System.out.println("YOOO1");  
		Login login = new Login();
		login.setUsername(req.getParameter("username"));
		login.setPassword(req.getParameter("password"));
		login.setTypeOfUser(req.getParameter("typeOfUser"));
		
		ModelAndView mav = new ModelAndView();
		if(login.getTypeOfUser().equals("admin")) 
		{ 
			
			LoginService loginService= new LoginService();
			String adminResult = loginService.checkAdminUser(login);
			System.out.println("admin result="+adminResult);
			if(adminResult.equals("success")) 
			{
				mav.setViewName("adminHome.jsp");
			}
			else 
			{
				mav.addObject("msg", "InValid username or password");
				mav.setViewName("login.jsp");
			}
		}
		else 
		{
			LoginService loginService = new LoginService();
			String customerResult="";
			
			customerResult = loginService.checkEmployeeLogin(login);
			
			System.out.println("customer result="+customerResult);
			if(customerResult.equals("success")) 
			{
				session.setAttribute("username", login.getUsername());
				mav.setViewName("customerHome.jsp");
			}
			else 
			{
				mav.addObject("msg", "InValid username or password");
				mav.setViewName("login.jsp");
			}
		}
		return mav;
	}
	@RequestMapping(value = "createAccount")
	public ModelAndView  createAccount(HttpServletRequest req,HttpSession session)
	{
		ModelAndView mav = new ModelAndView();
		return mav;
	}
	

}
