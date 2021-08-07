package com.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.classes.Employee;
import com.service.EmployeeService;

@Controller
public class EmployeeController 
{
	@RequestMapping(value = "addEmployee")
	public ModelAndView addEmployee(HttpServletRequest req,HttpSession session)
	{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("addEmployee.jsp");
		return mav;
	}
	
	@RequestMapping(value = "createEmployee")
	public ModelAndView employeeSignUp(HttpServletRequest req,HttpSession session)
	{
		Employee emp = new Employee();
		//emp.setEmpid(0);
		emp.setFirstname(req.getParameter("firstname"));
		emp.setLastname(req.getParameter("lastname"));
		emp.setDob(req.getParameter("dob"));
		emp.setEmail(req.getParameter("email"));
		emp.setDepartment_id(Integer.parseInt(req.getParameter("department_id")));
		emp.setUsername(req.getParameter("username"));
		emp.setPassword(req.getParameter("password"));
		
		ModelAndView mav = new ModelAndView();
		EmployeeService employeeService= new EmployeeService();
		
		String Result="";
		try {
			Result = employeeService.storeEmployee(emp);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		System.out.println(" result="+Result);
		if(Result.equals("success")) 
		{
			mav.setViewName("addEmployee.jsp");
			mav.addObject("msg","Success");
		}
		else
		{
			mav.addObject("msg", "InValid username or password");
			mav.setViewName("addEmployee.jsp");
		}
		return mav;
	}
	
	@RequestMapping(value = "loginToDeleteEmployee")
	public ModelAndView toDeleteEmployee(HttpServletRequest req,HttpSession session)
	{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("deleteEmployee.jsp");
		return mav;
	}
	
	@RequestMapping(value = "deleteEmployee")
	public ModelAndView deleteEmployee(HttpServletRequest req,HttpSession session)
	{
		Employee emp = new Employee();
		emp.setUsername(req.getParameter("username"));
		ModelAndView mav = new ModelAndView();
		EmployeeService employeeService= new EmployeeService();
		
		String Result="";
		try {
			Result = employeeService.deleteEmployee(emp);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		System.out.println(" result="+Result);
		mav.setViewName("deleteEmployee.jsp");
		if(Result.equals("success")) 
			mav.addObject("msg","Success");
		else
			mav.addObject("msg", "InValid username");
		
		return mav;

	}

	@RequestMapping(value = "displayAllEmployee")
	public ModelAndView viewAllEmployee(HttpServletRequest req,HttpSession session)
	{
		System.out.println("here");
		ModelAndView mav = new ModelAndView();
		EmployeeService employeeService= new EmployeeService();
		List<Employee>allEmployees = employeeService.getAllEmployees();
		System.out.println(allEmployees.toString());
		session.setAttribute("allEmployees", allEmployees);
		mav.setViewName("displayAllEmployee.jsp");
		mav.addObject("msg","Success");		
		return mav;

	}

}
