package com.example.tp1.service;

import com.example.tp1.entity.Products;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductService {

    List<Products> findAll();
    Products findById(Long id);
    //Use Optional
    //Optional<Products> findById(Long id);
    Products findBySlug(String slug);
    void updateQuantity(Integer newQuantity, Long id);

}
