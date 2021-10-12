//package com.hyperledjo.surveyther.DAO;
//
//import java.util.List;
//
//import org.mybatis.spring.SqlSessionTemplate;
//import org.springframework.stereotype.Repository;
//
//import com.hyperledjo.surveyther.DTO.Choice;
//
//@Repository
//public class ChoiceDAO {
//
//	private String nameSpace = "com.hyperledjo.surveyther.DAO.ChoiceDAO";
//	private SqlSessionTemplate sql;
//
//	// ChoiceDAO Repository에 SqlSessionTemplate을 constructor 형태로 주입
//	public ChoiceDAO(SqlSessionTemplate sql) {
//		this.sql = sql;
//	}
//
//	// Choice 등록
//	public int postChoice(Choice choice) {
//		try { 
//			sql.insert(nameSpace + ".postChoice", choice);	
//		} catch (Exception e) {
//			e.printStackTrace();
//			return 0;
//		} finally {
//			System.out.println("[POST]" + choice.toString());
//		}
//		return choice.getNo();
//	}
//
//	// 서베이에 포함된 Choice를 반환
//	public List<Choice> getChoicesFromSurvey(int id) {
//		return sql.selectList(nameSpace + ".getChoicesFromSurvey", id);
//	}
//
//	// 전체 Choice를 반환
//	public List<Choice> getChoiceList() {
//		return sql.selectList(nameSpace + ".getChoiceList");
//	}
//}
