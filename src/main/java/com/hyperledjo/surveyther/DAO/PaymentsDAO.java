package com.hyperledjo.surveyther.DAO;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.hyperledjo.surveyther.DTO.Payments;

@Repository
public class PaymentsDAO {
	private String nameSpace = "com.hyperledjo.surveyther.DAO.PaymentsDAO";
	private SqlSessionTemplate sql;
	
	public PaymentsDAO(SqlSessionTemplate sql) {
		this.sql = sql;
	}
	
	public int postPayments(Payments payments) {
		return sql.insert(nameSpace + ".postPayments", payments);
	}
}
