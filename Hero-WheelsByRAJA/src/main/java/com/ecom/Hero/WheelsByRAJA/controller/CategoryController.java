package com.ecom.Hero.WheelsByRAJA.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.Hero.WheelsByRAJA.model.Category;
import com.ecom.Hero.WheelsByRAJA.service.CategoryService;


//class
@RestController
@RequestMapping("/api/categories")
@CrossOrigin(origins = "http://localhost:5173")
public class CategoryController {

	//instance of service layer
	private CategoryService categoryService;
	
	//Constructor
	public CategoryController(CategoryService categoryService) {
		this.categoryService=categoryService;
	}
	
	
	//method
	@GetMapping
	public List<Category> getAllCategories(){
		return categoryService.getAllCategories();
	}
}
