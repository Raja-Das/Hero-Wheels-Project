package com.ecom.Hero.WheelsByRAJA.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.Hero.WheelsByRAJA.model.Product;
import com.ecom.Hero.WheelsByRAJA.service.ProductService;


//class
@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "http://localhost:5173")
public class ProductController {

	//instance of service layer
	private final ProductService productService;
	
	//constructor
	public ProductController(ProductService productService) {
		this.productService=productService;
	}
	
	//method-1  for all products (connected to service)
	@GetMapping
	public List<Product> getAllProducts(){
		return productService.getAllProducts();
	}
	
	//method-2 for product by Category (connected to service)
	@GetMapping("/category/{categoryId}")
	public List<Product> getProductByCategory(@PathVariable Long categoryId){
		return productService.getProductByCategory(categoryId);//getting from service
	}
}
