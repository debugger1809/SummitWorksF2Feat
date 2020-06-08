package com.group6.pro.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Kitchens")
public class Kitchens {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long kitchenid;
	
	private String kitchenName;
	
    private String Kitchen_working_Days;
    
    private String Kitchen_start_time;
    
    private String Kitchen_stop_time;
    
    @ManyToOne
	private ServiceProvider serviceprovider;
    
    @OneToMany(
            mappedBy = "kitchen",
            cascade = CascadeType.PERSIST,
            fetch = FetchType.LAZY
        )
    private Set<Product> menu;
    
    public Set<Product> getMenu(){return menu;}
    public void setMenu(Set<Product> x) {menu = x;}
    
	public ServiceProvider getServiceprovider() {
		return serviceprovider;
	}

	public void setServiceprovider(ServiceProvider serviceprovider) {
		this.serviceprovider = serviceprovider;
	}

	public Long getKitchenid() {
		return kitchenid;
	}

	public void setKitchenid(Long kitchenid) {
		this.kitchenid = kitchenid;
	}

	public String getKitchen_working_Days() {
		return Kitchen_working_Days;
	}

	public void setKitchen_working_Days(String kitchen_working_Days) {
		Kitchen_working_Days = kitchen_working_Days;
	}

	public String getKitchen_start_time() {
		return Kitchen_start_time;
	}

	public void setKitchen_start_time(String kitchen_start_time) {
		Kitchen_start_time = kitchen_start_time;
	}

	public String getKitchen_stop_time() {
		return Kitchen_stop_time;
	}

	public void setKitchen_stop_time(String kitchen_stop_time) {
		Kitchen_stop_time = kitchen_stop_time;
	}
	
	public String getKitchenName() {
		return kitchenName;
	}
	
	public void setKitchenName(String x) {
		kitchenName = x;
	}
    
}
