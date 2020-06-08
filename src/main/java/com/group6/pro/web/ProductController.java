package com.group6.pro.web;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.group6.pro.model.Kitchens;
import com.group6.pro.model.Product;
import com.group6.pro.model.ProductsModel;
import com.group6.pro.service.KitchensService;

@Controller
@RequestMapping(value = "/welcome/product")
public class ProductController 
{
	
    @Autowired 
    private KitchensService kitchensService;
    
	@RequestMapping(method = RequestMethod.GET, value="/{kitchen}")
	public String index(ModelMap modelMap, @PathVariable(name = "kitchen") String kitchen, HttpSession session) 
	{
		Kitchens k = kitchensService.findByKitchenname(kitchen);
		ProductsModel productModel = new ProductsModel();
		List<Product> ls = new ArrayList<Product>(k.getMenu());
		productModel.setProducts(ls);
		modelMap.put("products", productModel.findAll());
		session.setAttribute("kitchen", k.getKitchenName());
		return "product";
	}

}
