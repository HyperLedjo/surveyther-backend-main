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

	public int putComment() {
		return 0;
	}

	public int deleteComment() {
		return 0;
	}

	public int postComment() {
		return 0;
	}

	public int getCommentCount() {
		return 0;
	}

	public Comment getComment() {
		return null;
	}

	public List<Comment> getCommentList() {
		return null;
	}
}
