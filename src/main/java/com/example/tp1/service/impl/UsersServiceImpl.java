package com.example.tp1.service.impl;

import com.example.tp1.entity.Users;
import com.example.tp1.repository.UsersRepo;
import com.example.tp1.service.UsersService;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements UsersService {

    private final BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
    @Autowired
    private UsersRepo repo;

    @Override
//    public Users findByUsername(String username) {
//        return repo.findByUsername(username);
//    }
    public  Users doLogin(Users userRequest){
        Users userReponse = repo.findByUsername(userRequest.getUsername());
        if(ObjectUtils.isNotEmpty(userReponse)) {
            boolean checkPassword = bcrypt.matches(userRequest.getHashPassword(), userReponse.getHashPassword());
            return checkPassword ? userReponse : null;
        }
        return null;
    }

}
