package com.example.tp1.service;

import com.example.tp1.dto.CartDto;

public interface CartService {
    CartDto updateCart(CartDto cart, Long productId, Integer quantity, boolean isReplace);

    Integer getTotalQuantity(CartDto cart);

    Double getTotalPrice(CartDto cart);

}
