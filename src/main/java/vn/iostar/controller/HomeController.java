package vn.iostar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import vn.iostar.service.CategoryService;
import vn.iostar.service.ProductService;

@Controller
public class HomeController {
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	ProductService productService; 
	
    @GetMapping("/user/home")
    public String userHome() {
        return "user/home";
    }

    @GetMapping("/admin/home")
    public String adminHome(Model model) {
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("products", productService.findAll());
        return "admin/home";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
