package com.hyperledjo.surveyther.DAO;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.hyperledjo.surveyther.DTO.Comment;

@Repository
public class CommentDAO {

	private String nameSpace = "com.hyperledjo.surveyther.DAO.CommentDAO";
	private SqlSessionTemplate sql;

	public CommentDAO(SqlSessionTemplate sql) {
		this.sql = sql;
	}

	public int putComment(Comment comment) {
		return sql.update(nameSpace + ".putComment", comment);
	}

	public int deleteComment(int id) {
		return sql.delete(nameSpace + ".deleteComment", id);
	}

	public int postComment(Comment comment) {
		return sql.insert(nameSpace + ".postComment", comment);
	}

	public int getCommentCount(int id) {
		return sql.selectOne(nameSpace + ".getCommentCount", id);
	}

	public List<Comment> getCommentListFromSurvey(int id) {
		return sql.selectList(nameSpace + ".getCommentListFromSurvey", id);
	}

	// id is comment's primary key
	public Comment getComment(int id) {
		return sql.selectOne(nameSpace + ".getComment", id);
	}

	public List<Comment> getCommentList() {
		return sql.selectList(nameSpace + ".getCommentList");
	}
}
