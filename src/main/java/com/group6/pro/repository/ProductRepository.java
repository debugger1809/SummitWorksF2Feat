package com.group6.pro.repository;


import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import com.group6.pro.model.Kitchens;
import com.group6.pro.model.Product;


public interface ProductRepository extends JpaRepository<Product, Long>{
	Set<Product> findByKitchen(Kitchens kitchen);
}
