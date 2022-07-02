package com.example.tp1.service;
import com.example.tp1.entity.Users;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;

@Repository
public interface UsersService {

    Users doLogin (Users userRequest);
    Users save(Users user) throws SQLException;
    //Users findByUsername (String username);
}
