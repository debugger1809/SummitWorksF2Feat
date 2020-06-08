package com.group6.pro.service;


import java.util.Optional;
import com.group6.pro.model.Product;

public interface ProductService {
	  void save(Product product);

//	    Optional<Product> findById(long id);
	  Product findById(long id);

}

