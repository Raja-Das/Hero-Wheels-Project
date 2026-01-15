package com.ecom.Hero.WheelsByRAJA.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ecom.Hero.WheelsByRAJA.model.Category;
import com.ecom.Hero.WheelsByRAJA.repository.CategoryRepository;


//class
@Service
public class CategoryService {
	
    //instance of repository layer
	private CategoryRepository categoryRepository;
	
	//constructor
	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository=categoryRepository;
	}
    
	//method
	public List<Category> getAllCategories() {
		// TODO Auto-generated method stub
		return categoryRepository.findAll();
		}
}
