package com.hyperledjo.surveyther.DAO;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.hyperledjo.surveyther.DTO.Like;

@Repository
public class LikeDAO {
	
	private String nameSpace = "com.hyperledjo.surveyther.DAO.LikeDAO";
	private SqlSessionTemplate sql;

	public LikeDAO(SqlSessionTemplate sql) {
		this.sql = sql;
	}
	
	public int dislike() {
		return 0;
	}
	
	public int like() {
		return 0;
	}
	
	public int getLikedCount() {
		return 0;
	}
	
	public Like getLiked() {
		return null;
	}
	
	public List<Like> getLikedList() {
		return null;
	}
}
