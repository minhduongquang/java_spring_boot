package com.example.tp1.repository;

import com.example.tp1.entity.Roles;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepo extends JpaRepository<Roles, Long> {

    Roles findByDescription(String description);
}

