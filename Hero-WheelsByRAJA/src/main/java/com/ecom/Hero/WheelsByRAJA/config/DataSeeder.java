package com.ecom.Hero.WheelsByRAJA.config;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ecom.Hero.WheelsByRAJA.model.Category;
import com.ecom.Hero.WheelsByRAJA.model.Product;
import com.ecom.Hero.WheelsByRAJA.repository.CategoryRepository;
import com.ecom.Hero.WheelsByRAJA.repository.ProductRepository;


//class for DUMMY DATA for my project
@Component
public class DataSeeder implements CommandLineRunner {

	private final ProductRepository productRepository;
	private final CategoryRepository categoryRepository;
	
	 // Constructor for dependency injection
    public DataSeeder(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }
    
	
	@Override
	public void run(String... args) throws Exception{
		//Clear All existing data
		productRepository.deleteAll();
		categoryRepository.deleteAll();
		
		
		//Create Categories
		Category diecasts =  new Category();
		diecasts.setName("Diecast Cars");
		
		Category actionFigures =  new Category();
		actionFigures.setName("Action Figures");
		
		
		//saving categories
		categoryRepository.saveAll(Arrays.asList(diecasts, actionFigures));
		
		//Create Products
		
		//diecast product-1
				Product mercedes1 = new Product();
				mercedes1.setName("Mercedes Maybach S680");
				mercedes1.setDescription("1/24 Scale Golden Brown Metal");
				mercedes1.setImageUrl("/images/products/mercedes1.jpg");
				mercedes1.setPrice(1600.00);
				mercedes1.setCategory(diecasts);
		
		
		//diecast product-2
				Product bmw1 = new Product();
				bmw1.setName("BMW 760Li");
				bmw1.setDescription("1/24 Scale White");
				bmw1.setImageUrl("/images/products/bmw1.jpg");
				bmw1.setPrice(2000.00);
				bmw1.setCategory(diecasts);
				
				
		//diecast product-3
				Product mercedes2 = new Product();
				mercedes2.setName("Mercedes Benz AMG Vision");
				mercedes2.setDescription("1/24 Scale Matte Black Metal");
				mercedes2.setImageUrl("/images/products/mercedes2.jpg");
				mercedes2.setPrice(1500.00);
				mercedes2.setCategory(diecasts);
				
		
		//Action Figures product-1
				Product ironman = new Product();
				ironman.setName("Ironman Mark VII");
				ironman.setDescription("17cm Marvel Ironman PVC figure");
				ironman.setImageUrl("/images/products/ironman.jpg");
				ironman.setPrice(300.00);
				ironman.setCategory(actionFigures);
				
		//Action Figures product-2
				Product captainamerica = new Product();
				captainamerica.setName("Captain America");
				captainamerica.setDescription("17cm Marvel Captain America Civil War PVC figure");
				captainamerica.setImageUrl("/images/products/captainamerica.jpg");
				captainamerica.setPrice(300.00);
				captainamerica.setCategory(actionFigures);
		
		//Action Figures product-3
				Product antman = new Product();
				antman.setName("Antman");
				antman.setDescription("16cm Marvel Antman PVC figure");
				antman.setImageUrl("/images/products/antman.jpg");
				antman.setPrice(300.00);
				antman.setCategory(actionFigures);
				
		//Action Figures product-4
				Product doctorstrange = new Product();
				doctorstrange.setName("Doctor Strange");
				doctorstrange.setDescription("17cm Marvel Doctor Strange PVC figure");
				doctorstrange.setImageUrl("/images/products/doctorstrange.jpg");
				doctorstrange.setPrice(300.00);
				doctorstrange.setCategory(actionFigures);
				
		//Action Figures product-5
				Product hulk = new Product();
				hulk.setName("Hulk");
				hulk.setDescription("17.5cm Marvel Hulk PVC figure");
				hulk.setImageUrl("/images/products/hulk.jpg");
				hulk.setPrice(300.00);
				hulk.setCategory(actionFigures);
				
		//Action Figures product-6
				Product thanos = new Product();
				thanos.setName("Thanos");
				thanos.setDescription("17cm Marvel Thanos PVC figure");
				thanos.setImageUrl("/images/products/thanos.jpg");
				thanos.setPrice(300.00);
				thanos.setCategory(actionFigures);
				
		//Action Figures product-7
				Product blackpanther = new Product();
				blackpanther.setName("Black Panther");
				blackpanther.setDescription("17cm Marvel Black Panther PVC figure");
				blackpanther.setImageUrl("/images/products/blackpanther.jpg");
				blackpanther.setPrice(300.00);
				blackpanther.setCategory(actionFigures);
				
		//Action Figures product-8
				Product spiderman = new Product();
				spiderman.setName("Spiderman");
				spiderman.setDescription("17cm Marvel Spiderman PVC figure");
				spiderman.setImageUrl("/images/products/spiderman.jpg");
				spiderman.setPrice(300.00);
				spiderman.setCategory(actionFigures);
				
		//saving all products
				productRepository.saveAll(Arrays.asList(mercedes1, bmw1, mercedes2, ironman, captainamerica, antman, doctorstrange, hulk, thanos, blackpanther, spiderman));
	}
 }
