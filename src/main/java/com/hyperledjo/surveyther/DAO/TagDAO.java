package com.hyperledjo.surveyther.DAO;

import com.hyperledjo.surveyther.DTO.Tag;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TagDAO {

	private String nameSpace = "com.hyperledjo.surveyther.DAO.TagDAO";
	private SqlSessionTemplate sql;

	public TagDAO(SqlSessionTemplate sql) {
		this.sql = sql;
	}

	public int deleteTag(int id) {
		return sql.delete(nameSpace + ".deleteTag", id);
	}
	
	public int putTag(Tag tag) {
		return sql.update(nameSpace + ".putTag", tag);
	}
	
	public int postTag(Tag tag) {
		try { 
			sql.insert(nameSpace + ".postTag", tag);	
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		return 1;
	} 
	
	public List<Tag> getTagList(int id) {
		return sql.selectList(nameSpace + ".getTagList", id);
	}
}
