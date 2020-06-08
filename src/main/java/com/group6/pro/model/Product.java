package com.group6.pro.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product {

//	private String id;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String photo;
	private double price;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "kitchenid", referencedColumnName = "kitchenid")
    private Kitchens kitchen;

	/*
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
*/
	
	public long getId() {return id;}
	public Kitchens getKitchen() {return kitchen;}
	public void setId(long x) {id = x;}
	public void setKitchen(Kitchens x) {kitchen = x;}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Product() {
	}

	public Product(long id, String name, String photo, double price) {
//		this.id = id;
		this.name = name;
		this.photo = photo;
		this.price = price;
	}

}