package com.example.tp1.service;

import com.example.tp1.entity.Roles;

import org.springframework.stereotype.Repository;

@Repository
public interface RolesService {

        Roles findByDescription(String description);
}

