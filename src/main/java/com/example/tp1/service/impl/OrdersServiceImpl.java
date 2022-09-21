package com.example.tp1.service.impl;


import com.example.tp1.entity.Orders;
import com.example.tp1.repository.OrdersRepo;
import com.example.tp1.service.OrdersService;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private OrdersRepo repo;

    @Transactional(value = Transactional.TxType.REQUIRED)
    @Override
    public Orders insert(Orders order) {
        return repo.saveAndFlush(order);
    }
}
