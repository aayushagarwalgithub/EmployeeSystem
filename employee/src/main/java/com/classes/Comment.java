package com.classes;

public class Comment {

	private int commentId;
	private String comment;
	private String username;
	private int regulationId;
	
	
	
	public Comment() {
		super();
	}

	public Comment(int commentId, String comment, String username, int regulationId) {
		super();
		this.commentId = commentId;
		this.comment = comment;
		this.username = username;
		this.regulationId = regulationId;
	}
	
	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", comment=" + comment + ", username=" + username + ", regulationId="
				+ regulationId + "]";
	}

	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getRegulationId() {
		return regulationId;
	}
	public void setRegulationId(int regulationId) {
		this.regulationId = regulationId;
	}
	
	
}
