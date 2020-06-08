package com.group6.pro.service;


import com.group6.pro.model.Kitchens;

public interface KitchensService {
	  void save(Kitchens kitchens);

	    Kitchens findByKitchenname(String kitchen_name);

}

