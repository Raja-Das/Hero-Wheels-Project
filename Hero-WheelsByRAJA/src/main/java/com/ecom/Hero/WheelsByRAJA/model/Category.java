package com.ecom.Hero.WheelsByRAJA.model;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	
	//Tells Hibernate that the relationship is already mapped by the category field in 
	// the Product entity (foreign key lives in Product, not here).
	//one Category can have multiple Products.
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)  
	private Set<Product> products;

	public void setName(String name) {this.name=name;}
	public String getName() {return name;}
	
}
