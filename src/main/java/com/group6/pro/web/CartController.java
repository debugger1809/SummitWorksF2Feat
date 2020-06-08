package com.group6.pro.web;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.group6.pro.model.Item;
import com.group6.pro.model.Kitchens;
import com.group6.pro.model.Product;
import com.group6.pro.model.ProductsModel;
import com.group6.pro.service.KitchensService;
import com.group6.pro.service.ProductService;

@Controller
@RequestMapping(value = "/welcome/cart")
public class CartController {
	
	@Autowired
	private ProductService productService;

	@RequestMapping(value = "index", method = RequestMethod.GET)
	public String index() {
		return "cart";
	}

	@RequestMapping(value = "buy/{id}", method = RequestMethod.GET)
	public String buy(@PathVariable("id") String id, HttpSession session) 
	{
		if (session.getAttribute("cart") == null) 
		{
			List<Item> cart = new ArrayList<Item>();
			cart.add(new Item(productService.findById(Long.parseLong(id)), 1));
			session.setAttribute("cart", cart);
		} 
		else 
		{
			List<Item> cartv = (List<Item>) session.getAttribute("cart");
			int index = this.exists(Long.parseLong(id), cartv);
			if (index == -1) 
			{
				cartv.add(new Item(productService.findById(Long.parseLong(id)), 1));
			} 
			else 
			{
				int quantity = cartv.get(index).getQuantity() + 1;
				cartv.get(index).setQuantity(quantity);
			}
			session.setAttribute("cart", cartv	);
		}
		return "redirect:/cartv.jsp";
	}

	@RequestMapping(value = "remove/{id}", method = RequestMethod.GET)
	public String remove(@PathVariable("id") String id, HttpSession session) {
		ProductsModel productModel = new ProductsModel();
		List<Item> cart = (List<Item>) session.getAttribute("cart");
		int index = this.exists(Long.parseLong(id), cart);
		if(index == -1) System.out.println("\n\n\n\nERROR - REMOVING NONEXISTANT ITEM\n\n\n");
		else			cart.remove(index);
		session.setAttribute("cart", cart);
		return "redirect:/cartv.jsp";
	}

//	private int exists(String id, List<Item> cart) {
	private int exists(long id, List<Item> cart) {
		for (int i = 0; i < cart.size(); i++) {
		//	if (cart.get(i).getProduct().getId().equalsIgnoreCase(id)) {
			if(cart.get(i).getProduct().getId() == id) {
				return i;
			}
		}
		return -1;
	}

}