package com.example.tp1.service.impl;

import com.example.tp1.dto.CartDetailDto;
import com.example.tp1.dto.CartDto;
import com.example.tp1.entity.Orders;
import com.example.tp1.entity.Products;
import com.example.tp1.entity.Users;
import com.example.tp1.service.CartService;
import com.example.tp1.service.OrderDetailsService;
import com.example.tp1.service.OrdersService;
import com.example.tp1.service.ProductService;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private ProductService productsService;

    @Autowired
    private OrdersService ordersService;

    @Autowired
    private OrderDetailsService orderDetailsService;

    @Override
    public CartDto updateCart(CartDto cart, Long productId, Integer quantity, boolean isReplace) {
        Products product = productsService.findById(productId);
        HashMap<Long, CartDetailDto> details = cart.getDetails();

        // 1- them moi
        // 2- update:
        //		2.1- cong don
        //		2.2- thay the hoan toan (isReplace = true)
        // 3- delete (update vs quantity = 0)

        if (!details.containsKey(productId)) {
            CartDetailDto cartDetailDto = createNewCartDetail(product, quantity);
            details.put(productId, cartDetailDto);
        } else if (quantity > 0) {
            if (isReplace) {
                details.get(productId).setQuantity(quantity);
            } else {
                Integer currentQuantity = details.get(productId).getQuantity();
                Integer newQuantity = currentQuantity + quantity;
                details.get(productId).setQuantity(newQuantity);
            }
        } else {
            details.remove(productId);
        }
        // update totalQuantity
        cart.setTotalQuantity(getTotalQuantity(cart));
        // update totalPrice
        cart.setTotalPrice(getTotalPrice(cart));
        return cart;
    }

    @Override
    public Integer getTotalQuantity(CartDto cart) {
        Integer totalQuantity = 0;
        HashMap<Long, CartDetailDto> details = cart.getDetails();
        for (CartDetailDto cartDetail : details.values()){
            totalQuantity += cartDetail.getQuantity();
        }
        return totalQuantity;
    }

    @Override
    public Double getTotalPrice(CartDto cart) {
        Double totalPrice = Double.valueOf(0);
        HashMap<Long, CartDetailDto> details = cart.getDetails();
        for (CartDetailDto cartDetail : details.values()){
            totalPrice += (cartDetail.getQuantity()*cartDetail.getPrice());
        }
        return totalPrice;
    }

    private CartDetailDto createNewCartDetail(Products product, Integer quantity) {
        CartDetailDto cartDetailDto = new CartDetailDto();
        cartDetailDto.setProductId(product.getId());
        cartDetailDto.setQuantity(quantity);
        cartDetailDto.setPrice(product.getPrice());
        cartDetailDto.setImgUrl(product.getImgUrl());
        cartDetailDto.setSlug(product.getSlug());
        cartDetailDto.setName(product.getName());
        return cartDetailDto;
    }

    @Transactional(rollbackOn = {Exception.class})
    @Override
    public void insert(CartDto cartDto, Users user, String address, String phone) throws Exception{
        Orders orders = new Orders();
        orders.setAddress(address);
        orders.setPhone(phone);
        orders.setUsers(user);

        Orders ordersResponse = ordersService.insert(orders);
        if (ObjectUtils.isEmpty(ordersResponse)){
            throw new Exception("Insert into Orders failed");
        }

        // Insert vào bảng Order Detail
        for(CartDetailDto cartDetailDto: cartDto.getDetails().values()){
            cartDetailDto.setOrderId(ordersResponse.getId());
            orderDetailsService.insert(cartDetailDto);
            // Update số lượng mới cho product
            Products products = productsService.findById(cartDetailDto.getProductId());
            Integer newQuantity = products.getQuantity() - cartDetailDto.getQuantity();
            productsService.updateQuantity(newQuantity, products.getId());
        }
    }
}
