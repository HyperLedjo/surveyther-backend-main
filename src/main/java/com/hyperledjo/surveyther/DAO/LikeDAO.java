package com.hyperledjo.surveyther.DAO;

import com.hyperledjo.surveyther.DTO.Like;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LikeDAO {
	
	private String nameSpace = "com.hyperledjo.surveyther.DAO.LikeDAO";
	private SqlSessionTemplate sql;

	public LikeDAO(SqlSessionTemplate sql) {
		this.sql = sql;
	}
	
	public int dislike(Like like) {
		return sql.update(nameSpace + ".dislike", like);
	}
	
	public int like(Like like) {
		return sql.insert(nameSpace + ".like", like);
	}
	
	public int getLikedCount(int id) {
		return sql.selectOne(nameSpace + ".getLikedCount", id);
	}
	
	public Like getMyLike(Like like) {
		return sql.selectOne(nameSpace + ".getMyLike", like);
	}
	
	public List<Like> getLikeFromSurvey(int id) {
		return sql.selectList(nameSpace + ".getLikeFromSurvey", id);
	}
	
	public List<Like> getLikeList() {
		return sql.selectList(nameSpace + ".getLikeList");
	}
}
