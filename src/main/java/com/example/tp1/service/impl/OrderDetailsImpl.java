package com.example.tp1.service.impl;

import com.example.tp1.dto.CartDetailDto;
import com.example.tp1.repository.OrderDetailsRepo;
import com.example.tp1.service.OrderDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class OrderDetailsImpl implements OrderDetailsService {
    @Autowired
    private OrderDetailsRepo repo;

    @Transactional(value = Transactional.TxType.REQUIRED)
    @Override
    public void insert(CartDetailDto cartDetailDto) {
        repo.insert(cartDetailDto);
    }
}
