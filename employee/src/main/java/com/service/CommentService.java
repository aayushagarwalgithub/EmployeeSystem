package com.service;

import com.classes.Comment;
import com.dao.CommentDao;


public class CommentService {

	public String addComment(Comment comment) {
		CommentDao commentDao = new CommentDao();
		if(commentDao.addComment(comment) > 0) 
		{
			return "success";
		}
		else 
		{
			return "failure";
		}
	}

	public String deleteComment(Comment comment) {
		// TODO Auto-generated method stub
		return null;
	}

}
