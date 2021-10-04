package com.hyperledjo.surveyther.DAO;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.hyperledjo.surveyther.DTO.Choice;

@Repository
public class ChoiceDAO {

	private String nameSpace = "com.hyperledjo.surveyther.DAO.ChoiceDAO";
	private SqlSessionTemplate sql;

	// ChoiceDAO Repository에 SqlSessionTemplate을 constructor 형태로 주입
	public ChoiceDAO(SqlSessionTemplate sql) {
		this.sql = sql;
	}

	// Choice 등록
	public int postChoice(Choice choice) {
		// Choice DTO에 필요한 데이터를 담아 DB에 INSERT함
		// 실패시 0, 성공시 1 이상의 값을 반환
		int result = sql.insert(nameSpace + ".postChoice", choice);
		// 이 때, Mapper에 정의된 대로 마지막으로 INSERT된 ID(PK)도 같이 반환
		// 반환 성공시 Choice DTO에는 성공적으로 INSERT된 ROW의 ID를 getter로 불러올 수 있음
		if (0 < result) {
			return choice.getNo();
		}
		return result;
	}

	// 서베이에 포함된 Choice를 반환
	public List<Choice> getChoicesFromSurvey(int id) {
		return sql.selectList(nameSpace + ".getChoicesFromSurvey", id);
	}

	// 전체 Choice를 반환
	public List<Choice> getChoiceList() {
		return sql.selectList(nameSpace + ".getChoiceList");
	}
}
