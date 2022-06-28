package com.example.tp1.controller;

import com.example.tp1.entity.Products;
import com.example.tp1.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private ProductService productService;

    @GetMapping(value = {"/", ""})
    public String doGetRedirectIndex(){
        return "redirect:/index";
    }

    @GetMapping("/index")
    public String doGetIndex(Model model){
        List<Products>products = productService.findAll();
        model.addAttribute("products", products);
        return "user/index";
    }

    @GetMapping(value = {"/login"})
    public String doGetLogin(){
        return "user/login";
    }
}
