package com.hyperledjo.surveyther.DAO;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.hyperledjo.surveyther.DTO.Category;

@Repository
public class CategoryDAO {

	private String nameSpace = "com.hyperledjo.surveyther.DAO.CategoryDAO";
	private SqlSessionTemplate sql;

	public CategoryDAO(SqlSessionTemplate sql) {
		this.sql = sql;
	}

	public List<Category> getCategoryList() {
		return sql.selectList(nameSpace + ".getCategoryList");
	}
}
