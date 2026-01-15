package com.ecom.Hero.WheelsByRAJA.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ecom.Hero.WheelsByRAJA.model.Product;
import com.ecom.Hero.WheelsByRAJA.repository.ProductRepository;





//class
@Service
public class ProductService {

	//instance of Repository layer
	private final ProductRepository productRepository;
	
	//Constructor
	public ProductService(ProductRepository productRepository) {
		this.productRepository=productRepository;
	}
	
	//method-1 for all products (connected to repo)
	public List<Product> getAllProducts(){
		return productRepository.findAll();
	}
	
	//method-2 for product by Category (connected to repo)
	public List<Product> getProductByCategory(Long categoryId){
		return productRepository.findByCategoryId(categoryId); //finding from repo , repo takes it from DB
	}
	
}
