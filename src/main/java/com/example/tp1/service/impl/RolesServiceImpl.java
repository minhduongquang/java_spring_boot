package com.example.tp1.service.impl;

import com.example.tp1.constant.RolesConstant;
import com.example.tp1.entity.Roles;
import com.example.tp1.repository.RolesRepo;
import com.example.tp1.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolesServiceImpl implements RolesService {

    @Autowired
    private RolesRepo repo;

    @Override
    public Roles findByDescription(String description) {
        return repo.findByDescription(description);
    }
}

