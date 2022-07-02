package com.example.tp1.service;
import com.example.tp1.entity.Users;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersService {

    Users doLogin (Users userRequest);
    //Users findByUsername (String username);
}
