package com.hyperledjo.surveyther.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hyperledjo.surveyther.DAO.CommentDAO;
import com.hyperledjo.surveyther.DAO.SurveyDAO;
import com.hyperledjo.surveyther.DTO.Comment;
import com.hyperledjo.surveyther.DTO.TransferComments;

@Service
public class CommentService {

	private CommentDAO commentDAO;
	private SurveyDAO surveyDAO;

	public CommentService(CommentDAO commentDAO, SurveyDAO surveyDAO) {
		// TODO Auto-generated constructor stub
		this.commentDAO = commentDAO;
		this.surveyDAO = surveyDAO;
	}

	public int putComment(Comment comment) {
		return commentDAO.putComment(comment);
	}

	public int deleteComment(int id) {
		return commentDAO.deleteComment(id);
	}

	public int postComment(Comment comment) {
		TransferComments tc = new TransferComments();
		tc.setSurveyId(comment.getSurveyId());

		int result = commentDAO.postComment(comment);
		if (result < 1)
			return -1;

		int count = commentDAO.getCommentCount(comment.getSurveyId());
		tc.setComments(count);
		result = surveyDAO.updateComments(tc);
		if (result < 1)
			return 0;
		
		return 1;
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
