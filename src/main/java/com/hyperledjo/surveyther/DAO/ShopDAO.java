package com.hyperledjo.surveyther.DAO;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.hyperledjo.surveyther.DTO.Shop;

@Repository
public class ShopDAO {

	private String nameSpace = "com.hyperledjo.surveyther.DAO.ShopDAO";
	private SqlSessionTemplate sql;

	public ShopDAO(SqlSessionTemplate sql) {
		this.sql = sql;
	}
	
	// INPUT: 가게 이름, OUTPUT: 가게 번호(PK)
	public Shop getShop(String name) {
		return sql.selectOne(nameSpace + ".getShop", name);
	}
	
	public List<Shop> getShopList() {
		return sql.selectList(nameSpace + ".getShopList");
	}
}
