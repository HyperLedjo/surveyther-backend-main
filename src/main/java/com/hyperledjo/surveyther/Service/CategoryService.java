package com.hyperledjo.surveyther.Service;

import com.hyperledjo.surveyther.DAO.CategoryDAO;
import com.hyperledjo.surveyther.DTO.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
	
	private CategoryDAO categoryDAO;
	
	public CategoryService(CategoryDAO categoryDAO) {
		this.categoryDAO = categoryDAO;
	}
	
	public List<Category> getCategoryList() {
		return categoryDAO.getCategoryList();
	}
}
