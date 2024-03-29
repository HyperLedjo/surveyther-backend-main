package com.hyperledjo.surveyther.Controller;

import com.hyperledjo.surveyther.DTO.Category;
import com.hyperledjo.surveyther.Service.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController {
	
	private CategoryService categoryService;
	
	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	@GetMapping("/category")
	public List<Category> getCategoryList() {
		return categoryService.getCategoryList();
	}
}
