package com.group6.pro.web;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.group6.pro.model.ProductsModel;

@Controller
@RequestMapping(value = "/welcome/product")
public class ProductController {

	@RequestMapping(method = RequestMethod.GET, value="/{kitchen}")
	public String index(ModelMap modelMap, @PathVariable(name = "kitchenId") String kitchen_name) {
		ProductsModel productModel = new ProductsModel();
		modelMap.put("products", productModel.findAll());
		return "product";
	}

}
