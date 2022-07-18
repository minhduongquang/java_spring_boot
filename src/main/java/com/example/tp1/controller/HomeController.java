package com.example.tp1.controller;

import com.example.tp1.constant.SessionConstant;
import com.example.tp1.entity.Products;
import com.example.tp1.entity.Users;
import com.example.tp1.service.ProductService;
import com.example.tp1.service.UsersService;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private ProductService productService;
    @Autowired
    private UsersService usersService;


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
    public String doGetLogin(Model model){
        model.addAttribute("userRequest", new Users());
        return "user/login";
    }

    @GetMapping(value = {"/logout"})
    public String doGetLogout(Model model, HttpSession session){
        session.removeAttribute(SessionConstant.CURRENT_USER);
        return "user/index";
    }
    @GetMapping("/register")
    public String doGetRegister(Model model) {
        model.addAttribute("userRequest", new Users());
        return "user/register";
    }


    @PostMapping("/login")
    public String doPostMapping(@ModelAttribute("userRequest") Users usersRequest, HttpSession session){
        Users usersReponse = usersService.doLogin(usersRequest);
        if(ObjectUtils.isNotEmpty(usersReponse)){
            session.setAttribute(SessionConstant.CURRENT_USER, usersReponse);
            return "redirect:/index";
        }
        return "redirect:/login";
    }
    @PostMapping("/register")
    public String doPostRegister(@ModelAttribute("userRequest") Users usersRequest, HttpSession session){
        try {
            Users usersReponse = usersService.save(usersRequest);
            if(ObjectUtils.isNotEmpty(usersReponse)){
                session.setAttribute(SessionConstant.CURRENT_USER, usersReponse);
                return "redirect:/index";
            }
            else {
                return "redirect:/register";
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
            return"redirect:/register";
        }
    }
}
