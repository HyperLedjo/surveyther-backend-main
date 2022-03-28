package com.hyperledjo.surveyther.DAO;

import com.hyperledjo.surveyther.DTO.Shop;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

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
