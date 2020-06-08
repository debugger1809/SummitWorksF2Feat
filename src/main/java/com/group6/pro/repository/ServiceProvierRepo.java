package com.group6.pro.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.group6.pro.model.ServiceProvider;
//import com.group6.pro.model.User;

//
//public interface KitchensRepository extends JpaRepository<Kitchens, Long>{
//	Kitchens findByKitchenName(String kitchenName);
//}

public interface ServiceProvierRepo extends JpaRepository<ServiceProvider, Long>{
//	ServiceProvider findByKitchenid(Long kitchenid);
}
