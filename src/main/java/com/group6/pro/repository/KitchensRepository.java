package com.group6.pro.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.group6.pro.model.Kitchens;
//import com.group6.pro.model.User;


public interface KitchensRepository extends JpaRepository<Kitchens, Long>{
	Kitchens findByKitchenName(String kitchenName);
}
