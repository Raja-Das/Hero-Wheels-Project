package com.ecom.Hero.WheelsByRAJA.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity       //Marks this class as a JPA entity (mapped to a database table). Hibernate will create a product table for it.
@Data         //(from Lombok) → Generates getters, setters, toString(), equals(), and hashCode() automatically
public class Product {
	@Id                                                  //Marks id as the primary key of the entity.
	@GeneratedValue(strategy = GenerationType.IDENTITY)  //Database will auto-generate the value for id
	private long id;
	private String name;
	private String description;
	private String imageUrl;
	private Double price;
	
	@ManyToOne                                       //many Products can belong to one Category
	@JoinColumn(name="Category_id", nullable=false)  //Creates a foreign key column in the product table called Category_id.
	private Category category;

	
	public void setName(String name) {this.name=name;}
	public void setDescription(String description) {this.description=description;}
	public void setPrice(double price) {this.price=price;}
	public void setCategory(Category category) {this.category=category;}
	public void setImageUrl(String imageUrl) {this.imageUrl=imageUrl;}
	
	public String getName() { return name;}
	public String getDescription() {return description;}
	public double getPrice() {return price;}
	public Category getCategory() {return category;}
	public String getImageUrl() {return imageUrl;}
}
