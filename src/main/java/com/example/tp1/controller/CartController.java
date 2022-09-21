package com.example.tp1.controller;


import com.example.tp1.dto.CartDto;
import com.example.tp1.service.CartService;
import com.example.tp1.util.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/cart")
public class CartController {
    @GetMapping("")
    public String doGetViewCart(){
        return"user/cart";
    }

    @Autowired
    private CartService cartService;

    // /cart/update?productId=...&quantity=...&isReplace=...
    @GetMapping("/update")
    public String doGetUpdate(@RequestParam("productId") Long producId,
                                         @RequestParam("quantity") Integer quantity,
                                         @RequestParam("isReplace") Boolean isReplace,
                                         HttpSession session) {
        CartDto currentCart = SessionUtil.getCurrentCart(session);
        cartService.updateCart(currentCart, producId, quantity, isReplace);
        return "/user/cart::#viewCartFragment";
    }
}
