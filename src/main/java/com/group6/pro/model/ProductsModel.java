package com.group6.pro.model;

import java.util.ArrayList;
import java.util.List;
import com.group6.pro.model.Product;

public class ProductsModel {

	private List<Product> products;

	public ProductsModel() {
		this.products = new ArrayList<Product>();
		this.products.add(new Product("p01", "name 1", "Burger.png", 20));
		this.products.add(new Product("p02", "name 2", "Cutlets.png", 21));
		this.products.add(new Product("p03", "name 3", "Pizza.png", 22));
	}

	public List<Product> findAll() {
		return this.products;
	}

	public Product find(String id) {
		for (Product product : this.products) {
			if (product.getId().equalsIgnoreCase(id)) {
				return product;
			}
		}
		return null;
	}

}