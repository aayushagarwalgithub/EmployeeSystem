package com.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.classes.Regulation;
import com.service.RegulationService;

@Controller
public class RegulationController {

	@RequestMapping(value = "viewRegulation")
	public ModelAndView enterDepartmentToViewRegulation(HttpServletRequest request,HttpSession session)
	{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("viewRegulation.jsp");
		return mav;
	}
	
	@RequestMapping(value = "viewRegulationsForDepartment")
	public ModelAndView viewRegulation(HttpServletRequest request,HttpSession session)
	{
		ModelAndView mav = new ModelAndView();
		String department_nm=request.getParameter("departmentForWhichRegulationIsToBeViewed");
		RegulationService regulationService = new RegulationService();
		List<Regulation> departmentRegulation = regulationService.getRegulation(department_nm);
		session.setAttribute("departmentRegulation", departmentRegulation);
		
		mav.setViewName("viewRegulationForDepartment.jsp");
		return mav;
	}
	
	@RequestMapping(value = "addRegulation")
	public ModelAndView enterDepartmentToAddRegulation(HttpServletRequest request,HttpSession session)
	{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("addRegulation.jsp");
		return mav;
	}
	
	@RequestMapping(value = "addRegulationsForDepartment")
	public ModelAndView addRegulation(HttpServletRequest request,HttpSession session)
	{
		ModelAndView mav = new ModelAndView();
		Regulation regulation = new Regulation();
		regulation.setDepartmentName(request.getParameter("departmentForWhichRegulationsIsToBeAdded"));
		regulation.setRegulationId(Integer.parseInt(request.getParameter("regulationId")));
		regulation.setRegulationName(request.getParameter("regulationName"));
		RegulationService regulationService = new RegulationService();
		
		try {
			regulationService.addRegulation(regulation);
			mav.addObject("msg","Success");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			mav.addObject("msg","failed");
		}
		mav.setViewName("addRegulation.jsp");
		return mav;
	}
}
