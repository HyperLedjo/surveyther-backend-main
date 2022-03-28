package com.hyperledjo.surveyther.DAO;

import com.hyperledjo.surveyther.DTO.Category;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

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
