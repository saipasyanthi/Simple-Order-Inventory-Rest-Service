package com.Inventory_order_service.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "TBL_Inventory")
public class Inventory{
	
	
   
    private Long id;
    private String name;
    private String description;
    private int price;
    private int quantityAvailable;
    
    @Id
	@Column(name="Inventory_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantityAvailable() {
		return quantityAvailable;
	}
	public void setQuantityAvailable(int quantityAvailable) {
		this.quantityAvailable = quantityAvailable;
	}
	@Override
	public String toString() {
		return "Inventory [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", quantityAvailable=" + quantityAvailable + "]";
	}
	
	


}
