package com.group6.pro.web;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.group6.pro.model.ProductsModel;

@Controller
@RequestMapping(value = "/welcome/product")
public class ProductController {

	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		ProductsModel productModel = new ProductsModel();
		modelMap.put("products", productModel.findAll());
		return "product";
	}

}
