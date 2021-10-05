package com.hyperledjo.surveyther.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hyperledjo.surveyther.DAO.ShopDAO;
import com.hyperledjo.surveyther.DTO.Shop;

@Service
public class ShopService {
	
	private ShopDAO shopDAO;
	
	public ShopService(ShopDAO shopDAO) {
		this.shopDAO = shopDAO;
	}
	
	public Shop getShop(String name) {
		return shopDAO.getShop(name);
	}
	
	public List<Shop> getShopList() {
		return shopDAO.getShopList();
	}
}
