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

	public Comment getComment(int id) {
		return sql.selectOne(nameSpace + ".getComment", id);
	}

	public List<Comment> getCommentList() {
		return sql.selectList(nameSpace + ".getCommentList");
	}
}
