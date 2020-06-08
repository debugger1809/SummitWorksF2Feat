package com.group6.pro.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.group6.pro.model.Kitchens;
import com.group6.pro.model.Kitchens;
import com.group6.pro.repository.KitchensRepository;
//import com.group6.pro.repository.UserRepository;

import java.util.HashSet;

@Service
public class KitchenServiceImpl implements KitchensService {
    @Autowired
    private KitchensRepository kitchenRepository;

    @Override
    public void save(Kitchens kitchens) 
    {System.out.println("TEST");
    	kitchenRepository.save(kitchens);
    }

	@Override
	public Kitchens findByKitchenname(String kitchen_name)
	{
		return kitchenRepository.findByKitchenName(kitchen_name);
	}
	
	public Kitchens findById(long id)
	{
		return kitchenRepository.getOne(id);
	}
}
