package com.hyperledjo.surveyther.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hyperledjo.surveyther.DAO.CommentDAO;
import com.hyperledjo.surveyther.DTO.Comment;

@Service
public class CommentService {

	private CommentDAO commentDAO;

	public CommentService(CommentDAO commentDAO) {
		// TODO Auto-generated constructor stub
		this.commentDAO = commentDAO;
	}

	public int putComment(Comment comment) {
		return commentDAO.putComment(comment);
	}

	public int deleteComment(int id) {
		return commentDAO.deleteComment(id);
	}

	public int postComment(Comment comment) {
		return commentDAO.postComment(comment);
	}

	public int getCommentCount(int id) {
		return commentDAO.getCommentCount(id);
	}

	public List<Comment> getCommentListFromSurvey(int id) {
		return commentDAO.getCommentListFromSurvey(id);
	}

	// id is comment's primary key
	public Comment getComment(int id) {
		return commentDAO.getComment(id);
	}

	public List<Comment> getCommentList() {
		return commentDAO.getCommentList();
	}
}
