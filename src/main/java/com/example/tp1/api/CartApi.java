package com.example.tp1.api;


import com.example.tp1.constant.SessionConstant;
import com.example.tp1.dto.CartDto;
import com.example.tp1.entity.Users;
import com.example.tp1.service.CartService;
import com.example.tp1.util.SessionUtil;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/cart")
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
    @GetMapping("/refresh")
    public ResponseEntity<?>doGetRefresh(HttpSession session){
        CartDto currentCart = SessionUtil.getCurrentCart(session);
        return ResponseEntity.ok(currentCart);
    }
    // /api/cart/checkout?address=...&phone=...
    @GetMapping("/checkout")
    public ResponseEntity<?> doGetCheckout(@RequestParam("address") String address,
                                           @RequestParam("phone") String phone,
                                           HttpSession session) {
        Users currentUser = SessionUtil.getCurrentUser(session);

        if (ObjectUtils.isEmpty(currentUser)) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED); // 401
        }

        CartDto currentCart = SessionUtil.getCurrentCart(session);
        try {
            cartService.insert(currentCart, currentUser, address, phone);
            session.setAttribute(SessionConstant.CURRENT_CART, new CartDto());
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST); // 400
        }
    }
}
