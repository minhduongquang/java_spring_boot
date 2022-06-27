package com.example.tp1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class HomeController {
    @GetMapping("/index")
    public String doGetIndex(){
        return "user/index";
    }
}
