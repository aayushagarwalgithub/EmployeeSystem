package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.classes.Comment;
import com.classes.Comment;
import com.service.CommentService;
import com.service.CommentService;

@Controller
public class CommentController 
{
	@RequestMapping(value = "addCommentWindow")
	public ModelAndView addCommentWindow(HttpServletRequest req,HttpSession session)
	{
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("addComment.jsp");
		
		return mav;

	}
	@RequestMapping(value = "addComment")
	public ModelAndView addComment(HttpServletRequest req,HttpSession session)
	{
		System.out.println("HOO1");
		Comment comment = new Comment();
		comment.setUsername(req.getParameter("username"));
		comment.setComment(req.getParameter("comment"));
		comment.setRegulationId(Integer.parseInt(req.getParameter("regulationId")));
		
		System.out.println("HOO2");
		System.out.println(comment);
		ModelAndView mav = new ModelAndView();
		CommentService commentService= new CommentService();
		
		String Result="";
		Result = commentService.addComment(comment);
		System.out.println(" result="+Result);
		mav.setViewName("viewRegulation.jsp");
		if(Result.equals("success")) 
			mav.addObject("msg","Success");
		else
			mav.addObject("msg", "InValid username");
		
		return mav;

	}
	
	

}
