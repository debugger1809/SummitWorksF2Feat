package com.group6.pro.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.group6.pro.model.Kitchens;
import com.group6.pro.model.Product;
import com.group6.pro.model.User;
import com.group6.pro.repository.KitchensRepository;
import com.group6.pro.service.KitchenServiceImpl;
import com.group6.pro.service.KitchensService;
import com.group6.pro.service.ProductService;
import com.group6.pro.service.SecurityService;
import com.group6.pro.service.UserService;
import com.group6.pro.validator.UserValidator;

@Controller
public class UserController {
	
	@Autowired 
	private  KitchenServiceImpl kitchenservice;
	
	@Autowired
	private KitchensRepository kitchenrepo;
	
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;
    
    @Autowired 
    private KitchensService kitchensService;
    
    @Autowired
    private ProductService productService;

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.save(userForm);

        securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:/welcome";
    }

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

    @GetMapping({"/", "/welcome"})
    public String welcome(ModelMap modelMap) {
    	System.out.println("DONE");
//    	List<Kitchens> AllKitchens = kitchenrepo.findAll();
//    	modelMap.put("KitchenList", kitchenrepo.findAll());
    	
        return "welcome";
    }
    
    @GetMapping("/welcome/kitchenListing")
    public String kitchenList(ModelMap modelMap) {
    	System.out.println("DONE");
//    	List<Kitchens> AllKitchens = kitchenrepo.findAll();
    	modelMap.put("KitchenList", kitchenrepo.findAll());
    	
        return "kitchenlist";
    }
    
    @RequestMapping("/welcome/kitchenListing/{kitchenId}")
    public String KitchenOrderPage(@PathVariable(name = "kitchenId") String kitchen_name, Model model) {
//        ModelAndView mav = new ModelAndView("edit_product");
        Kitchens kitchen = kitchensService.findByKitchenname(kitchen_name);
//        mav.addObject("kitchen", kitchen);
        model.addAttribute("kitchen", kitchen);     
        return "kitchen";
    }
    
    
    
    @GetMapping("/addKitchen")
    public String addKitchenGet(Model model) {
        model.addAttribute("kitchens", new Kitchens());
        
        return "addKitchen";
    }
    
      

    @PostMapping("/addKitchen")
    public @ResponseBody ModelAndView addKitchenPost(@RequestParam String name, @RequestParam String days, @RequestParam String start, @RequestParam String end,
    		HttpSession session) {
        System.out.println("TEST");
        Kitchens kitchen = new Kitchens();
        kitchen.setKitchenName(name);
        kitchen.setKitchen_working_Days(days);
        kitchen.setKitchen_start_time(start);
        kitchen.setKitchen_stop_time(end);
    	kitchensService.save(kitchen);
    	session.setAttribute("kitchen", kitchen);
//        return "addMenu";
    	return new ModelAndView("addMenu", "kitchen", kitchen);
    }
    
    @GetMapping("/addMenu")
    public String addMenuGet(Model model) {
        model.addAttribute("product", new Product());
        return "addMenu";
    }
    
      

    @PostMapping("/addMenu")
    public @ResponseBody ModelAndView addMenuPost(@RequestParam String name, @RequestParam String photo, @RequestParam String price, 
    		HttpSession session) {
    	Kitchens kitchen = (Kitchens)session.getAttribute("kitchen");
        Product product = new Product();
        product.setName(name);
        product.setPhoto(photo);
        product.setPrice(Double.parseDouble(price));
        product.setKitchen(kitchen);
        productService.save(product);
        return new ModelAndView("addMenu", "kitchen", kitchen);
    }
}
