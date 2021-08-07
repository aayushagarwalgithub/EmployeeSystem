package com.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.classes.Department;
import com.service.DepartmentService;

@Controller
public class DepartmentController {

	@RequestMapping(value = "addDepartment")
	public ModelAndView addDepartment(HttpServletRequest req,HttpSession session)
	{
		Department department = new Department();
		department.setDepartmentId(Integer.parseInt(req.getParameter("departmentId")));
		department.setDepartmentName(req.getParameter("departmentName"));
		
		System.out.println(department);
		ModelAndView mav = new ModelAndView();
		DepartmentService departmentService= new DepartmentService();
		
		String Result="";
		Result = departmentService.addDepartment(department);
		System.out.println(" result="+Result);
		mav.setViewName("addDepartment.jsp");
		if(Result.equals("success")) 
			mav.addObject("msg","Success");
		else
			mav.addObject("msg", "InValid username");
		
		return mav;

	}
	
	@RequestMapping(value = "deleteDepartment")
	public ModelAndView deleteDepartment(HttpServletRequest req,HttpSession session)
	{
		Department department = new Department();
		department.setDepartmentName(req.getParameter("departmentName"));
		
		ModelAndView mav = new ModelAndView();
		DepartmentService departmentService= new DepartmentService();
		
		String Result="";
		try {
			Result = departmentService.deleteDepartment(department);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		System.out.println(" result="+Result);
		mav.setViewName("deleteDepartment.jsp");
		if(Result.equals("success")) 
			mav.addObject("msg","Success");
		else
			mav.addObject("msg", "InValid username");
		
		return mav;

	}


	@RequestMapping(value = "displayAllDepartments")
	public ModelAndView viewAllDepartment(HttpServletRequest req,HttpSession session)
	{
		ModelAndView mav = new ModelAndView();
		DepartmentService departmentService= new DepartmentService();
		List<Department>allDepartments = departmentService.getAllDepartments();
		System.out.println(allDepartments.toString());
		session.setAttribute("allDepartments", allDepartments);
		mav.setViewName("displayAllDepartments.jsp");
		mav.addObject("msg","Success");		
		return mav;

	}

}
