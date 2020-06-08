package com.group6.pro.model;

import javax.persistence.OneToMany;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ServiceProvider {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long kitchenid;
	
	@OneToMany
	private Set<Kitchens> kitchens;

	public Set<Kitchens> getKitchens() {
		return kitchens;
	}

	public void setKitchens(Set<Kitchens> kitchens) {
		this.kitchens = kitchens;
	}
	

}
