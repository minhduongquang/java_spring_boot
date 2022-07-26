package com.example.tp1.api;


import com.example.tp1.dto.CartDto;
import com.example.tp1.service.CartService;
import com.example.tp1.util.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class CartApi {

    @Autowired
    private CartService cartService;

    // /api/cart/update?productId=...&quantity=...&isReplace=...
    @GetMapping("/update")
    public ResponseEntity<?> doGetUpdate(@RequestParam("productId") Long producId,
                                         @RequestParam("quantity") Integer quantity,
                                         @RequestParam("isReplace") Boolean isReplace,
                                         HttpSession session) {
        CartDto currentCart = SessionUtil.getCurrentCart(session);
        cartService.updateCart(currentCart, producId, quantity, isReplace);
        return ResponseEntity.ok(currentCart);
    }
}
