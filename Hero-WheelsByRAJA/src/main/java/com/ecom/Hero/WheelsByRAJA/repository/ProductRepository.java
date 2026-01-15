package com.ecom.Hero.WheelsByRAJA.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecom.Hero.WheelsByRAJA.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	//abstraction
	List<Product> findByCategoryId(Long categoryId);  
	//findBy(something) = spring data JPA naming convention
	//by just looking at the name "find By CategoryId", JPA/Hibernate is able to get desired QUERY (SELECT * FROM product(table) WHERE categoryId=####)
}
