package com.crud.CRUD.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductModel {
 public ProductModel(int id, String name, int price, int stock, String brand) {
		super();
		this.id = id;
		Name = name;
		this.price = price;
		this.stock = stock;
		this.brand = brand;
	}
 public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
 private int id;
 private String Name;
 private  int price;
  private int stock;
  private String brand;
}
